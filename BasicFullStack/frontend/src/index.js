import * as React from 'react'
import * as ReactDOM from 'react-dom/client'
import App from 'App.js'
import ErrorScreen from 'ErrorScreen.js'
import { createBrowserRouter, RouterProvider, createRoutesFromElements, Route } from 'react-router-dom'

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path='/*' element={<App />} errorElement={<ErrorScreen />} />
  )
)

ReactDOM.createRoot(document.getElementById('root')).render(
  <RouterProvider router={router} />
)
