import './App.css'
import { Container } from 'react-bootstrap'
import { Route, Routes } from 'react-router-dom'
import Home from '../views/Home'
import About from './views/About'
import AllPets from './views/AllPets'
import Cart from './views/Cart'
import Admin from './views/Admin'
import Checkout from './views/Checkout'
import CheckoutSummary from './views/CheckoutSummary'

function App() {
  return (
    <>
      <main className='py-3'>
        <Container>
          <Routes>
            <Route path='/' element={<Home />} exact />
            <Route path='/about' element={<About />} exact />
            <Route path='/pets' element={<AllPets />} exact />
            <Route path='/cart' element={<Cart />} exact />
            <Route path='/admin' element={<Admin />} exact />
            <Route path='/login' element={<Login />} exact />
            <Route path='/cart/checkout' element={<Checkout />} exact />
            <Route
              path='/cart/checkout-summary'
              element={<CheckoutSummary />}
              exact
            />
          </Routes>
        </Container>
      </main>
    </>
  )
}

export default App
