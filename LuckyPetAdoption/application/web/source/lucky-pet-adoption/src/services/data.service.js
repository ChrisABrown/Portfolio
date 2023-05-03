import axios from 'axios'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:5000',
  headers: {
    'Access-Control-Allow-Origin': 'no-cors',
  },
})

const getAllProducts = async () => {
  try {
    return await axiosInstance.get('/api/store-items').then((res) => {
      return res.data
    })
  } catch (error) {
    return Promise.reject(error)
  }
}

const DataService = {
  getAllProducts,
}

export default DataService
