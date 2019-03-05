import React from 'react'
import ReactDOM from 'react-dom'
import { AppContainer } from 'react-hot-loader'
import AppComponent from './app'

const render = Component => ReactDOM.render(
  <AppContainer>
    <Component/>
  </AppContainer>,
  document.getElementById('root')
)

render(AppComponent)
