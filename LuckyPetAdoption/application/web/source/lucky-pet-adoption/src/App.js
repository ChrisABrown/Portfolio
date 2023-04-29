import { Container } from 'react-bootstrap'
import About from './views/About'
import Admin from './views/Admin'
import AllPets from './views/AllPets'
import Cart from './views/Cart'
import Checkout from './views/Checkout'
import CheckoutSummary from './views/CheckoutSummary'
import Login from './views/Login'
import { Route, Routes } from 'react-router-dom'
import Header from './components/Header'
import Home from './views/Home'
import PetsStore from './views/PetsStore'

function App() {
  return (
    <>
      <Header />
      <main className='py-3'>
        <Container>
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/about' element={<About />} />
            <Route path='/pets' element={<AllPets />} />
            <Route path='/cart' element={<Cart />} />
            <Route path='/admin' element={<Admin />} />
            <Route path='/login' element={<Login />} />
            <Route path='/cart/checkout' element={<Checkout />} />
            <Route path='/store' element={<PetsStore />} />
            <Route
              path='/cart/checkout-summary'
              element={<CheckoutSummary />}
            />
          </Routes>
        </Container>
      </main>
    </>
  )
}

export default App
