import React from 'react'
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import './index.css'
import Header from './components/header/Header.jsx';
import Home from './components/home/Home.jsx';
import SolarInfo from './components/solarInfo/SolarInfo.jsx';


const router = createBrowserRouter([
  {
    path: "/",
    element: <Header />,
    children: [
       {
        path: "/",
        element: <Home />
       },
       {
        path: "/solarwatch",
        element: <SolarInfo />
       }
    ]
  }
])

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
