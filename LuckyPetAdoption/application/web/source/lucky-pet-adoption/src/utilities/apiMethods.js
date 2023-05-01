import axios from 'axios'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:5000',
})

export async function getAllProducts() {
  const response = axiosInstance.get('/products')

  return response
}
