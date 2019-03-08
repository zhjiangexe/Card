import axios from 'axios'

export const postAdd = async form => {
  const resp = await axios.post('http://localhost:8080/api/cards', form)
  return resp.data.data
}

export const getCards = async () => {
  const resp = await axios.get('http://localhost:8080/api/cards')
  return resp.data.data
}
