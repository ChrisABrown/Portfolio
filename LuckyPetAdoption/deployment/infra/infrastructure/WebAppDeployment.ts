import { CfnOutput, Stack } from 'aws-cdk-lib'
import { CloudFrontWebDistribution } from 'aws-cdk-lib/aws-cloudfront'
import { Bucket } from 'aws-cdk-lib/aws-s3'
import { BucketDeployment, Source } from 'aws-cdk-lib/aws-s3-deployment'
import { join } from 'path'

export class WebAppDeployment {
  private stack: Stack
  private bucketSuffix: string
  private deploymentBucket: Bucket

  constructor(stack: Stack, bucketSuffix: string) {
    this.stack = stack
    this.bucketSuffix = bucketSuffix
    this.initialize()
  }

  private initialize() {
    const bucketName = 'lucky-pet-app-web-id' + this.bucketSuffix
    this.deploymentBucket = new Bucket(this.stack, 'lucky-pet-app-web', {
      bucketName: bucketName,
      publicReadAccess: true,
      websiteIndexDocument: 'index.html',
    })

    new BucketDeployment(this.stack, 'lucky-pet-app-web-id-deployment', {
      destinationBucket: this.deploymentBucket,
      sources: [
        Source.asset(
          join(
            __dirname,
            '..',
            '..',
            '..',
            'application',
            'web',
            'source',
            'frontend',
            'build'
          )
        ),
      ],
    })

    const cloudfront = new CloudFrontWebDistribution(this.stack, 'cloudfront', {
      originConfigs: [
        {
          behaviors: [
            {
              isDefaultBehavior: true,
            },
          ],
          s3OriginSource: {
            s3BucketSource: this.deploymentBucket,
          },
        },
      ],
    })

    new CfnOutput(this.stack, 'luckyPetWebAppS3Url', {
      value: this.deploymentBucket.bucketWebsiteUrl,
    })
    new CfnOutput(this.stack, 'luckyPetWebAppCloudFrontUrl', {
      value: cloudfront.distributionDomainName,
    })
  }
}
