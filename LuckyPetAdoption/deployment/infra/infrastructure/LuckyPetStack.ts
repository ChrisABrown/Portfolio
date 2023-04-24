import { CfnOutput, Fn, Stack, StackProps } from 'aws-cdk-lib'
import {
  AuthorizationType,
  Cors,
  LambdaIntegration,
  MethodOptions,
  ResourceOptions,
  RestApi,
} from 'aws-cdk-lib/aws-apigateway'
import { PolicyStatement } from 'aws-cdk-lib/aws-iam'
import { NodejsFunction } from 'aws-cdk-lib/aws-lambda-nodejs'
import { Construct } from 'constructs'
import { join } from 'path'
import { GenericTable } from './GenericTable'
import { AuthorizerWrapper } from './auth/AuthorizerWrapper'
import { Bucket, HttpMethods } from 'aws-cdk-lib/aws-s3'
import { WebAppDeployment } from './WebAppDeployment'

export class LuckyPetStack extends Stack {
  private api = new RestApi(this, 'LuckyPetApi')
  private authorizer: AuthorizerWrapper
  private suffix: string
  private luckyPetPhotosBucket: Bucket

  private luckyPetTable = new GenericTable(this, {
    tableName: 'LuckyPetTable',
    primaryKey: 'luckyPetId',
    createLambdaPath: 'Create',
    readLambdaPath: 'Read',
    updateLambdaPath: 'Update',
    deleteLambdaPath: 'Delete',
    secondaryIndexes: ['breed'],
  })

  constructor(scope: Construct, id: string, props: StackProps) {
    super(scope, id, props)
    this.initializeSuffix()
    this.initializeLuckyPetPhotosBucket()
    this.authorizer = new AuthorizerWrapper(
      this,
      this.api,
      this.luckyPetPhotosBucket.bucketArn + '/*'
    )
    new WebAppDeployment(this, this.suffix)

    // const helloLambdaNodeJS = new NodejsFunction(this, 'HelloLambdaNodeJS', {
    //   entry: join(__dirname, '..', 'services', 'node-lambda', 'hello.ts'),
    //   handler: 'handler',
    // })

    // const s3ListPolicy = new PolicyStatement()
    // s3ListPolicy.addActions('s3:ListAllMyBuckets')
    // s3ListPolicy.addResources('*')
    // helloLambdaNodeJS.addToRolePolicy(s3ListPolicy)

    const optionsWithAuthorizer: MethodOptions = {
      authorizationType: AuthorizationType.COGNITO,
      authorizer: {
        authorizerId: this.authorizer.authorizer.authorizerId,
      },
    }

    const optionsWithCors: ResourceOptions = {
      defaultCorsPreflightOptions: {
        allowOrigins: Cors.ALL_ORIGINS,
        allowMethods: Cors.ALL_METHODS,
      },
    }

    //luckypet api integrations
    const luckyPetResource = this.api.root.addResource('pets')
    luckyPetResource.addMethod(
      'POST',
      this.luckyPetTable.createLambdaIntegration
    )
    luckyPetResource.addMethod('GET', this.luckyPetTable.readLambdaIntegration)
    luckyPetResource.addMethod(
      'PUT',
      this.luckyPetTable.updateLambdaIntegration
    )
    luckyPetResource.addMethod(
      'DELETE',
      this.luckyPetTable.deleteLambdaIntegration
    )
  }

  private initializeSuffix() {
    const shortStackId = Fn.select(2, Fn.split('/', this.stackId))
    const Suffix = Fn.select(4, Fn.split('-', shortStackId))
    this.suffix = Suffix
  }

  private initializeLuckyPetPhotosBucket() {
    this.luckyPetPhotosBucket = new Bucket(this, 'luckypet-photos', {
      bucketName: `lucky-pet-${this.suffix}-photos`,
      cors: [
        {
          allowedMethods: [
            HttpMethods.GET,
            HttpMethods.POST,
            HttpMethods.PUT,
            HttpMethods.DELETE,
          ],
          allowedOrigins: ['*'],
          allowedHeaders: ['*'],
        },
      ],
    })
    new CfnOutput(this, 'luckypet-photos-bucket', {
      value: this.luckyPetPhotosBucket.bucketName,
    })
  }
}
