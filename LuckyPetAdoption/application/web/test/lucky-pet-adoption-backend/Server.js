const express = require('express')
const cors = require('cors')
const products = require('./data/products')

const port = 5000

const app = express()
app.use(cors())

app.get('/', (req, res) => {
  res.send('API up and running...')
})

app.get('/api/store-items', (req, res) => {
  res.json(products)
})

app.get('/api/store-items/:id', (req, res) => {
  const product = products.find((p) => p.id === req.params.id)
  res.json(product)
})

app.listen(port, console.log('Server running on port ' + port))
