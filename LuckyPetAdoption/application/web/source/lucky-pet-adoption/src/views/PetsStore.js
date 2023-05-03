import PetSupplies from '../components/PetSupplies'
import DataService from '../services/data.service'

const PetsStore = () => {
  const storeItems = DataService.getAllProducts()

  return (
    <div>
      <PetSupplies storeItems={storeItems} />
    </div>
  )
}

export default PetsStore
