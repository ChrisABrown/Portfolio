import { Container, Navbar } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const Header = () => {
  // const dispatch = useDispatch()
  // const userLogin = useSelector((state) => state.userLogin)
  // const { userInfo } = userLogin
  // const logoutHandler = () => {
  //   dispatch(logout())
  //   alert(`${userInfo.username} Successfully logged out.`)
  //   window.location.reload(true)
  // }
  return (
    <header>
      <Navbar bg='dark' variant='dark' expand='lg' collapseOnSelect>
        <Container>
          <LinkContainer to='/'>
            <Navbar.Brand>
              <img
                src='https://static.vecteezy.com/system/resources/thumbnails/004/343/259/small/cute-puppy-or-dog-cartoon-illustration-animal-raising-hand-wildlife-icon-design-concept-isolated-flat-face-style-free-vector.jpg'
                alt='puppy icon'
                height={50}
                width={50}
              />
            </Navbar.Brand>
          </LinkContainer>
          <LinkContainer to='/about'>
            <Navbar.Brand>
              <img
                src='https://media.istockphoto.com/id/1256096552/vector/about-us-rgb-color-icon.jpg?s=612x612&w=0&k=20&c=KKozSJIgaX2lu1OIRY9Oc5Rp1GhQzpTIKatBtc_4lQQ='
                alt='about us icon'
                height={50}
                width={50}
              />
            </Navbar.Brand>
          </LinkContainer>
          <LinkContainer to='/pets'>
            <Navbar.Brand>
              <img
                src='https://static.vecteezy.com/system/resources/previews/005/724/866/original/animal-paw-and-human-hand-linear-icon-animal-donation-care-and-protection-concept-adoption-of-pets-shelter-charity-line-icon-animal-welfare-pictogram-illustration-vector.jpg'
                alt='pets adoption icon'
                height={50}
                width={50}
              />
            </Navbar.Brand>
          </LinkContainer>
          <LinkContainer to='/store'>
            <Navbar.Brand>
              <img
                src='https://static.vecteezy.com/system/resources/previews/003/346/398/original/shopping-store-or-market-icon-free-vector.jpg'
                alt='pet supplies store icon'
                height={50}
                width={50}
              />
            </Navbar.Brand>
          </LinkContainer>
          <Navbar.Toggle aria-controls='basic-navbar-nav' />
          <Navbar.Collapse id='basic-navbar-nav'>
            {/* <Nav className='ms-auto'>
              <LinkContainer to='/cart'>
                <Nav.Link>
                  <CartIcon />
                </Nav.Link>
              </LinkContainer>
              {userInfo ? (
                <NavDropdown title={userInfo.username} id='nav-dropdown'>
                  <LinkContainer to='/profile'>
                    <NavDropdown.Item>Profile</NavDropdown.Item>
                  </LinkContainer>
                  <NavDropdown.Divider />
                  <NavDropdown.Item onClick={logoutHandler}>
                    Logout{' '}
                  </NavDropdown.Item>
                </NavDropdown>
              ) : (
                <LinkContainer to='/login'>
                  <Nav.Link>
                    <i className='fas fa fa-user'> Login </i>
                  </Nav.Link>
                </LinkContainer>
              )}
            </Nav> */}
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </header>
  )
}

export default Header
