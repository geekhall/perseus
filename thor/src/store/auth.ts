import { defineStore } from 'pinia'
import UserModel from '~/models/user'
import authService from '~/services/auth-service'

const user = JSON.parse(localStorage.getItem('user') || '{}')
const initalState = user
  ? { status: { loggedIn: true }, user }
  : { status: { loggedIn: false }, user: null }

export const useUserStore = defineStore('user', {
  state: () => initalState,
  getters: {},
  actions: {
    login(username: string, password: string) {
      return authService.login({ username, password } as UserModel).then(
        (user) => {
          this.user = user
          user.status = { loggedIn: true }
          return Promise.resolve(user)
        },
        (error) => {
          this.logout()
          return Promise.reject(error)
        }
      )
    },
    logout() {
      this.status = { loggedIn: false }
      authService.logout()
      this.user = null
    },
    register(username: string, email: string, password: string) {
      return authService.register({ username, email, password })
    }
  }
})

