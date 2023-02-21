import { defineStore } from 'pinia'

import axios from "axios"
import UserModel from "~/models/user"
import { useUserStore } from "~/store/auth"

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
  login(user: UserModel) {
    return axios
      .post(API_URL + "login", {
        username: user.username,
        password: user.password
      })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data))
        }
        return response.data
      }).catch(error => {
        console.log("####### auth-service.ts login() error #######");

        console.log(error)
        return error
      })
  }

  /**
   * Logout the current user
   */
  logout() {
    localStorage.removeItem('user')
    localStorage.removeItem('token')
    localStorage.removeItem('ms_username')
    // userStore.status.loggedIn = false
    useUserStore().status.loggedIn = false
  }

  /**
   * Register a new user
   *
   * @param username
   * @param email
   * @param password
   * @returns
   */
  register(user: UserModel) {
    return axios.post(API_URL + "register", {
      username: user.username,
      email: user.email,
      password: user.password
    }).then(response => {
      if (response.data.accessToken) {
        localStorage.setItem("user", JSON.stringify(response.data))
      }
      return response.data
    }).catch(error => {
      console.log(error)
      return error
    })
  }

  /**
   * Get the current logged in user
   *
   * @returns
   */
  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user")!)
  }
}

export default new AuthService()
