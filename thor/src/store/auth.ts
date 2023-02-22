import { defineStore } from 'pinia'
import UserModel from '~/models/user'
import authService from '~/services/auth-service'

export const useUserStore = defineStore('user', {
  state: () => {
    const storedUser = JSON.parse(localStorage.getItem('user') || '{}')
    const loggedIn = storedUser && storedUser.accessToken
    return {
      status: { loggedIn },
      user: storedUser
    }
  },
  getters: {},
  actions: {
    login(username: string, password: string) {
      return authService.login(username, password).then(
        (user) => {
          this.user = user
          this.status.loggedIn = true
          return Promise.resolve(user)
        },
        (error) => {
          this.logout()
          return Promise.reject(error)
        }
      )
    },
    logout() {
      this.status.loggedIn = false
      this.user = null
      this.$reset()
    },
    register(username: string, email: string, password: string) {
      return authService.register({ username, email, password })
    }
  }
})

