import { defineStore } from 'pinia'
import axios from "axios"
import UserModel from "~/models/user"
import { useUserStore } from "~/store/auth"

/**
 * AuthService
 *
 * Axios service for authentication
 *
 */
// const userStore = useUserStore()

const API_URL = "http://localhost:4000/api/auth/"

/**
 * AuthService
 *
 */
class AuthService {
  /**
   * Login the user and store the token in local storage
   *
   * @param username
   * @param password
   * @returns
   */
  login(username: string, password: string, rememberMe: boolean): Promise<any> {
    return axios
      .post(API_URL + "login", {
        username,
        password
      })
      .then(response => {
        if (response.data.accessToken) {
          console.log("####### auth-service.ts login() set token #######");
          // localStorage.setItem('user', JSON.stringify(response.data))
        }
        localStorage.setItem('user', JSON.stringify(response.data))
        return Promise.resolve(response.data)
      }).catch(error => {
        console.log("####### auth-service.ts login() error #######");

        console.log(error)
        return Promise.reject(error)
      })
  }

  /**
   * Register a new user
   *
   * @param username
   * @param email
   * @param password
   * @returns
   */
  register(user: UserModel): Promise<any> {
    return axios.post(API_URL + "register", {
      username: user.username,
      email: user.email,
      password: user.password
    }).then(response => {
      if (response.data.accessToken) {
        localStorage.setItem("user", JSON.stringify(response.data))
      }
      return Promise.resolve(response.data)
    }).catch(error => {
      console.log(error)
      return Promise.reject(error)
    })
  }
}

export default new AuthService()
