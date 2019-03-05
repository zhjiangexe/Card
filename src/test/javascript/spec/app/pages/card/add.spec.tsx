import React from 'react'
import { shallow, mount } from 'enzyme'
import Add from 'app/pages/card/add'
import sinon from 'sinon'

describe('Card', () => {
  let mountedWrapper
  const devProps = {}
  const wrapper = (props = devProps) => {
    if (!mountedWrapper) {
      mountedWrapper = shallow(
        <Add addCard={null}/>
      )
    }
    return mountedWrapper
  }

  beforeEach(() => {
    mountedWrapper = undefined
  })

  it('snapshot', () => {
    const component = wrapper()
    expect(component).toMatchSnapshot()
  })
  it('should render correctly in "debug" mode', () => {
    const component = wrapper()
    component.find("[color='primary']").simulate('click')
    expect(component.find('[color="warning"]')).toHaveLength(3)
  })
})

/*
1. import component
2. understanding Enzyme, shallow(淺拷貝), render(HTML), mount(WHOLE DOM TREE)
 */
