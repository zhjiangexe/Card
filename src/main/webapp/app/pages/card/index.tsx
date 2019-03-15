import React, { FunctionComponent, useEffect, useState } from 'react'
import { Col, Container, Row } from 'reactstrap'

import Add from './add'
import List from './list'
import { getCards } from 'app/pages/card/service'

export interface ICard {
  userName: string
  cardNo: string
  balance: number
  limit: number
}

const cardPage: FunctionComponent = props => {
  const [cards, setCards] = useState([])
  const addCard = (newCard: ICard) => {
    setCards([...cards, newCard])
  }
  const fetchCards = async () => {
    try {
      const data = await getCards()
      setCards(data)
    } catch (e) {
      console.log(e)
    }
  }
  useEffect(() => {
    fetchCards()
  }, [])
  return (
    <Container>
      <Row>
        <Col>
          <h1>Credit Card System</h1>
        </Col>
      </Row>
      <Row>
        <Col md="6">
          <Add addCard={addCard}/>
        </Col>
        <Col md="6">
          <List cards={cards}/>
        </Col>
      </Row>
    </Container>
  )
}

export default cardPage
