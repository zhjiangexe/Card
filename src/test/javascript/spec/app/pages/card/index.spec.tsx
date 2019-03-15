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
      mountedWrapper = mount(
        <Card/>
      )
    }
    return mountedWrapper
  }

  beforeEach(() => {
    mountedWrapper = undefined
  })

  it('Renders a Header component with List, Add components.', () => {
    const component = wrapper()

    expect(component).toMatchSnapshot()
    expect(component.find(List).length).toEqual(1)
    expect(component.find(Add).length).toEqual(1)
  })

})
