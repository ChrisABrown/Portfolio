import React from 'react'
import { Card } from 'react-bootstrap'

const PetSupplies = (storeItems) => {
  const petSupplies = Object.values(storeItems).map((item) => {
    const product = item
    return (
      <>
        <div
          className='container'
          style={{
            width: '40%',
            marginBottom: '20px',
          }}
          key={product.id}
        >
          <Card className='card-body'>
            <h4>{product.name}</h4>
            <h5>{product.sku}</h5>
            <h6>{product.price}</h6>
            <img
              src={product.image}
              height={300}
              width={300}
              alt={product.description}
            />
            <button className='btn btn-primary'>Add to Cart</button>
          </Card>
        </div>
      </>
    )
  })
  return (
    <>
      <div className='d-flex flex-row flex-wrap justify-content-between'>
        {petSupplies}
      </div>
    </>
  )
}

export default PetSupplies
