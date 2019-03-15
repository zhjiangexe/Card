import axios from 'axios'
import { toast } from 'react-toastify'
import { ICard } from 'app/pages/card/index'

const SERVER_API_URL = process.env.SERVER_API_URL

const cardsUrl = `${SERVER_API_URL}/api/cards`

export const notify = message => toast.error(message)

export const getCards = async () =>
  new Promise<ICard[]>(((resolve, reject) => {
    axios.get(cardsUrl)
      .then(resp => {
        resolve(resp.data.data)
      })
      .catch(error => {
        reject(handleError(error))
      })
  }))

export const postAdd = async form =>
  new Promise(((resolve, reject) => {
    axios.post(cardsUrl, form)
      .then(resp => {
        resolve(resp.data.data)
      })
      .catch(error => {
        reject(handleError(error))
      })
  }))

const handleError = error => {
  const { message, response } = error
  if (!response) {
    // Network Error
    notify(message)
    return
  }
  const status = response.status
  const data = response.data
  switch (status) {
    case 401:
      // do something when you're unauthenticated
      break
    case 403:
      // do something when you're unauthorized to access a resource
      break
    case 409:
      if (data.status === 'CONFLICT') {
        notify(data.error.message)
      }
      return data
    case 500:
      notify(data.error.message)
      return data
    default:
      return data
  }
}
