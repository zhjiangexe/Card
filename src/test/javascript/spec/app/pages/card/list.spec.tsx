import React from 'react'
import { mount } from 'enzyme'
import List from 'app/pages/card/list'
import { ICard } from 'app/pages/card'

describe('Card', () => {
  it('WHEN give no cards THEN there are no cards', () => {
    const wrapper = mount(<List cards={[]}/>)

    const contentText = wrapper.find('td').text()

    expect(contentText).toBe('There are no cards.')
  })

  it('WHEN specified quantity of cards THEN get specified quantiry of tr', () => {
    const cards: ICard[] = [
      { userName: 'first', cardNo: '567', balance: 0, limit: 123 },
      { userName: 'second', cardNo: '567', balance: 0, limit: 123 }
    ]
    const wrapper = mount(<List cards={cards}/>)

    const trList = wrapper.find('tbody > tr')

    expect(trList).toHaveLength(2)
  })
})
