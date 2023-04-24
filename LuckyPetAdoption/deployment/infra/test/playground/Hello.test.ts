import { APIGatewayProxyEvent } from 'aws-lambda'
import { handler } from '../../services/LuckyPetTable/Create'

const event: APIGatewayProxyEvent = {
  body: {
    name: 'Bubbles',
    breed: 'Bulldog',
    sex: 'male',
  },
} as any

const result = handler(event, {} as any).then((apiResult) => {
  const items = JSON.parse(apiResult.body)
  console.log(123)
})
