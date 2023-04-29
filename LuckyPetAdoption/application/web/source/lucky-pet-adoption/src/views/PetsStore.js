import PetSupplies from '../components/PetSupplies'

const PetsStore = () => {
  return (
    <div>
      <PetSupplies storeItems={storeItems} key={storeItems.id} />
    </div>
  )
}

export default PetsStore
