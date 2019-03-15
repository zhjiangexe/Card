import React from 'react'
import { mount } from 'enzyme'
import List from 'app/pages/card/list'
import { ICard } from 'app/pages/card'

describe('card list', () => {
  it('WHEN give no cards THEN render table shows there are no cards', () => {
    const wrapper = mount(<List cards={[]}/>)

    const contentText = wrapper.find('td').text()

    expect(contentText).toBe('There are no cards.')
  })

  it('WHEN give specified quantity of cards THEN render specified quantiry of table row', () => {
    const cards: ICard[] = [
      { userName: 'first', cardNo: '5500542913424292', balance: 0, limit: 123 },
      { userName: 'second', cardNo: '4539108027394363', balance: 0, limit: 123 }
    ]
    const wrapper = mount(<List cards={cards}/>)

    const trList = wrapper.find('tbody > tr')

    expect(trList).toHaveLength(2)
  })
})
