import { AxiosRequestConfig } from 'axios'
import request from '../utils/request'
import { MethodType } from '~/utils/types'

export const getHelaData = async (api_url: string, api_method: MethodType) => {
  return await request({
    url: api_url,
    method: api_method
  } as AxiosRequestConfig)
}

export const asyncLogin = async (username: string, password: string) => {
  return await request({
    url: '/api/auth/login',
    method: MethodType.POST,
    data: {
      username,
      password
    }
  } as AxiosRequestConfig);
}
