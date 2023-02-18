import axios, { AxiosError, AxiosRequestConfig, AxiosResponse } from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

export default function request(config: AxiosRequestConfig) {

  // 1. 创建 axios 实例
  const instance = axios.create({
    baseURL: '/api',
    timeout: 5000,
    headers: {
      'Content-Type': 'application/json',
    }
  })
  // 2. axios 的拦截器
  // 2.1 请求拦截的作用
  instance.interceptors.request.use(
    (config: AxiosRequestConfig) => {
      const token = localStorage.getItem('token');
      if (token) {
        config.headers.Authorization = token;
      }
      return config;
    },
    (err: AxiosError) => {
      console.log(err);
      return Promise.reject(err);
    }
  );

  // 2.2 响应拦截
  instance.interceptors.response.use(
    (res: AxiosResponse) => {
      if (res.status === 200) {
        console.log(res.data);
        return res.data;
      } else {
        return Promise.reject(res);
      }
    },
    (err: AxiosError) => {
      if (err?.response) {
        switch (err.response.status) {
          case 400:
            err.message = '请求错误';
            break;
          case 401:
            err.message = '未授权，请登录';
            break;
          case 403:
            err.message = '拒绝访问';
            break;
          case 404:
            err.message = `请求地址出错: ${err.response.config.url}`;
            break;
          case 408:
            err.message = '请求超时';
            break;
          case 500:
            err.message = '服务器内部错误';
            break;
          case 501:
            err.message = '服务未实现';
            break;
          case 502:
            err.message = '网关错误';
            break;
          case 503:
            err.message = '服务不可用';
            break;
          case 504:
            err.message = '网关超时';
            break;
          case 505:
            err.message = 'HTTP版本不受支持';
            break;
          default:
            err.message = '未知错误';
            break;
        }
        console.log(err.message);
        return Promise.reject(err);
      } else {
        if (err.message.includes('timeout')) {
          err.message = '请求超时';
        }
        if (err.message.includes('Network Error')) {
          err.message = '网络错误';
        }
        console.log(err.message)
        return Promise.reject(err);
      }
    }
  )
  return instance(config);
}
