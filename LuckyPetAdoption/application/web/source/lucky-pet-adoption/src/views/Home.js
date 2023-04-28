import { Container } from 'react-bootstrap'
import Header from '../components/Header'

const Home = () => {
  return (
    <>
      <Container>
        <main className='py-3'>
          <Header />
          <h1>Welcome to Lucky Pet Adoption Agency!</h1>
          <section>
            Here is the main paragraph describing the lucky pet adoption agency
          </section>
        </main>
      </Container>
    </>
  )
}

export default Home
