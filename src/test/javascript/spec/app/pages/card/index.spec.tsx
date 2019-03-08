import React from 'react'
import { shallow, mount } from 'enzyme'

import Card from 'app/pages/card'
import Add from 'app/pages/card/add'
import List from 'app/pages/card/list'

describe('Card', () => {
  let mountedWrapper
  const devProps = {}
  const wrapper = (props = devProps) => {
    if (!mountedWrapper) {
      mountedWrapper = shallow(
        <Card/>
      )
    }
    return mountedWrapper
  }

  beforeEach(() => {
    mountedWrapper = undefined
  })

  it('Card snapshot', () => {
    const component = wrapper()

    expect(component).toMatchSnapshot()
  })

  it('Card has Add component', () => {
    const component = wrapper()

    expect(component.find(Add)).toHaveLength(1)
  })

  it('Card has List component', () => {
    const component = wrapper()

    expect(component.find(List)).toHaveLength(1)
  })

})
