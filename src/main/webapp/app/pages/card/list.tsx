import React, { FunctionComponent } from 'react'
import { Table } from 'reactstrap'
import { ICard } from 'app/pages/card/index'

const listBlock: FunctionComponent<{ cards: ICard[] }> = ({ cards = [] }) => (
  <div>
    <h2>Existing Cards</h2>
    <Table striped responsive>
      <thead>
      <tr>
        <th>Name</th>
        <th>Card Number</th>
        <th>Balance</th>
        <th>Limit</th>
      </tr>
      </thead>
      <tbody>
      {
        cards.length > 0
          ? cards.map((card, idx) => (
            <tr key={idx}>
              <td>{card.userName}</td>
              <td>{card.cardNo}</td>
              <td>£{card.balance}</td>
              <td>£{card.limit}</td>
            </tr>
          ))
          : <tr>
            <td colSpan={4}>There are no cards.</td>
          </tr>
      }
      </tbody>
    </Table>
  </div>
)

export default listBlock
