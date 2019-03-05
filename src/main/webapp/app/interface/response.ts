export enum HttpStatus {
  OK = 200,
  CREATED = 200,
  BAD_REQUEST = 400,
  UNAUTHORIZED = 401,
  NOT_FOUND = 404,
  CONFLICT = 409
}

export interface IGenericError {
  message?: string
}

export interface IFieldValidError extends IGenericError {
  field?: string
  rejectedValue?: string
}

export interface IErrorResp<E extends IGenericError> {
  code?: string
  message?: string
  errors?: E[]
}

export interface IResp<T> {
  status?: HttpStatus
  message?: string
  data?: T
  error?: IErrorResp<any>
}
