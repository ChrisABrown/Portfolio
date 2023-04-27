import { Nav, NavLink } from 'react-bootstrap'

export default function Navbar() {
  return (
    <Nav>
      <NavLink to='/about'>About{''}</NavLink>
      <NavLink to='/pets'>Pets{''}</NavLink>
      <NavLink to='/login'>Login{''}</NavLink>
      <NavLink to='/store'>Store{''}</NavLink>
      <NavLink to='/cart'>Cart{''}</NavLink>
    </Nav>
  )
}
