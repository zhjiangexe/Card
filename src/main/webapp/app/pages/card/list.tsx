import React, { FunctionComponent } from 'react'
import { Table } from 'reactstrap'
import { ICard } from 'app/pages/card/index'

const listBlock: FunctionComponent<{ cards: ICard[] }> = ({ cards = [] }) => (
  <div>
    <h2>Existing Cards</h2>
    <Table bordered>
      <thead>
      <tr>
        <th>Name</th>
        <th>Card Number</th>
        <th>Balance</th>
        <th>Limit</th>
      </tr>
      </thead>
      {
        cards.length > 0
          ? <tbody>
          {
            cards.map((card, idx) => (
              <tr key={idx}>
                <td>{card.userName}</td>
                <td>{card.cardNo}</td>
                <td>£{card.balance}</td>
                <td>£{card.limit}</td>
              </tr>
            ))
          }
          </tbody>
          : null
      }
    </Table>
  </div>
)

export default listBlock
