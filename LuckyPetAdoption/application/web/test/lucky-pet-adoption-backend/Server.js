const express = require('express')
const products = require('./data/products')

const port = 5000

const app = express()

app.get('/', (req, res) => {
  res.send('API up and running...')
})

app.get('/api/store-items', (req, res) => {
  res.json(products)
})

app.listen(port, console.log('Server running on port ' + port))
