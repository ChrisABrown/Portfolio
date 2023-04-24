import pkg from 'express'
import cors from 'cors'

const { Express } = pkg
const app = pkg()

app.use(cors())
app.use(pkg.json())
