import { AxiosRequestConfig } from 'axios'
import request from '../utils/request'
import { MethodType } from '~/utils/types'

export const getHeraData = (api_url: string) => {
  return request({
    url: api_url,
    method: MethodType.GET
  } as AxiosRequestConfig)
}
