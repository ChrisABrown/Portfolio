import React from 'react'
import ReactDOM from 'react-dom/client'
import { Provider } from 'react-redux'
import {
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from 'react-router-dom'
import './index.css'
import App from './App'
import store from './store'
import 'bootstrap/dist/css/bootstrap.css'

const router = createBrowserRouter(
  createRoutesFromElements(<Route path='/*' element={<App />} exact></Route>)
)

const root = ReactDOM.createRoot(document.getElementById('root'))
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <RouterProvider router={router} />
    </Provider>
  </React.StrictMode>
)
