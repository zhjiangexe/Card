import axios from 'axios'
import React, { FunctionComponent, useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import { Col, Container, Row } from 'reactstrap'

import { IResp } from 'app/interface/response'

import Add from './add'
import List from './list'

export interface ICard {
  userName: string
  cardNo: string
  balance: number
  limit: number
}

const cardPage: FunctionComponent = props => {
  const [cards, setCards] = useState<ICard[]>([])
  const notify = message => toast.error(message)
  const addCard = (newCard: ICard) => {
    setCards([...cards, newCard])
  }
  const fetchCards = async () => {
    try {
      const resp = await axios.get('http://localhost:8080/api/cards')
      if (resp.data) {
        setCards(resp.data.data)
      }
    } catch (e) {
      if (e.response) {
        const resp: IResp<any> = e.response.data
        const error = resp.error
        if (error) {
          if (error.errors) {
            const errorMap = Object.assign({}, ...error.errors.map(elem => ({ [elem.field]: elem.message })))
          } else {
            notify(error.message)
          }
        }
      }
    }
  }
  useEffect(() => {
    fetchCards()
  }, [])
  return (
    <Container>
      <Row>
        <Col xs="12" sm="8" md="8">
          <h1>Credit Card System</h1>
          <Add addCard={addCard}/>
          <List cards={cards}/>
        </Col>
      </Row>

    </Container>
  )
}

export default cardPage
