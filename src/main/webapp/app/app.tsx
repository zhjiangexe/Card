import './app.scss'
import 'react-toastify/dist/ReactToastify.css'

import React, { FunctionComponent } from 'react'
import { ToastContainer } from 'react-toastify'
import { Button, Form, FormGroup, FormText, Input, Label, Table } from 'reactstrap'

import CardPage from './pages/card'

const app: FunctionComponent = () => (
  <div className="app-container">
    <CardPage/>
    <ToastContainer/>
  </div>
)

export default app
