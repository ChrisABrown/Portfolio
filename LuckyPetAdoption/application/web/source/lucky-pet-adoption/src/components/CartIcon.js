import { Container } from 'react-bootstrap'

function CartIcon() {
  return (
    <Container position='relative'>
      <i className='fas fa-shopping-cart'>Cart</i>
      {<Container position='absolute' top={0} right={0}></Container>}
    </Container>
  )
}

export default CartIcon
