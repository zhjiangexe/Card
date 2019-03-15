import React, { FunctionComponent, useState } from 'react'
import { Alert, Button, Form, FormGroup, Input, Label } from 'reactstrap'
import { postAdd } from 'app/pages/card/service'

interface IFormData {
  userName: string
  cardNo: string
  limit: string
}

interface IFormErr {
  cardNo?: string
  userName?: string
  limit?: string
}

const add: FunctionComponent<{ addCard }> = ({ addCard }) => {
  const [form, setForm] = useState<IFormData>({ userName: '', cardNo: '', limit: '' })
  const [formErr, setFormErr] = useState<IFormErr>({})
  const addFun = async () => {
    try {
      const data = await postAdd(form)
      addCard(data)
      setForm({ userName: '', cardNo: '', limit: '' })
      setFormErr({})
    } catch (data) {
      if (data) {
        const err = data.error
        if (err !== undefined && err.code === 'IV100001') {
          const errorMap = Object.assign({}, ...err.errors.map(elem => ({ [elem.field]: elem.message })))
          setFormErr(errorMap)
        }
      }
    }
  }
  const handleInputChange = event => {
    const { name, value } = event.target
    setForm({ ...form, [name]: value })
  }
  const isNumeric = n => /^\d*$/.test(n)
  const handleCardNoChange = event => {
    const value = event.target.value
    if (isNumeric(value) && value.length <= 19) {
      handleInputChange(event)
    }
  }
  const handleLimitChange = event => {
    const value = event.target.value
    if (isNumeric(value) && value.substr(0, 1) !== '0') {
      handleInputChange(event)
    }
  }
  return (
    <div>
      <h2>Add</h2>
      <Form>
        <FormGroup>
          <Label>Name</Label>
          <Input type="text" name="userName" value={form.userName} onChange={handleInputChange}/>
          {formErr.userName ? <Alert color="warning">{formErr.userName}</Alert> : null}
        </FormGroup>
        <FormGroup>
          <Label>Card number</Label>
          <Input type="text" name="cardNo" value={form.cardNo} onChange={handleCardNoChange}/>
          {formErr.cardNo ? <Alert color="warning">{formErr.cardNo}</Alert> : null}
        </FormGroup>
        <FormGroup>
          <Label>Limit</Label>
          <Input type="text" name="limit" value={form.limit} onChange={handleLimitChange}/>
          {formErr.limit ? <Alert color="warning">{formErr.limit}</Alert> : null}
        </FormGroup>
        <FormGroup>
          <Button color="primary" onClick={addFun}>Add</Button>
        </FormGroup>
      </Form>
    </div>
  )
}

export default add
