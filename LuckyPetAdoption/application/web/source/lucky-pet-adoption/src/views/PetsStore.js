import PetSupplies from '../components/PetSupplies'
import DataService from '../services/data.service'
import { useState, useEffect } from 'react'

const PetsStore = () => {
  const [storeItems, setStoreItems] = useState([])

  useEffect(() => {
    DataService.getAllProducts().then((res) => {
      setStoreItems(res.data)
    })
  }, [])

  return (
    <div>
      <PetSupplies storeItems={storeItems} />
    </div>
  )
}

export default PetsStore
