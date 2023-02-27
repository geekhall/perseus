import { defineStore } from 'pinia'
import UserModel from '~/models/user'
import authService from '~/services/auth-service'

/**
 * authStore
 *
 * Pinia store for authentication
 *
 */
export const useUserStore = defineStore('user', {
  state: () => {
    const storedUser = JSON.parse(localStorage.getItem('user') || '{}')
    const loggedIn = storedUser && storedUser.accessToken

    return {
      status: { loggedIn },
      user: storedUser
    }
  },
  getters: {
    isLoggedIn(): boolean {
      return this.status.loggedIn
    },
    getUser(): UserModel {
      return this.user
    },
    getAccessToken(): string {
      return this.user.accessToken
    },
    getRefreshToken(): string {
      return this.user.refreshToken
    },
    getRole(): string {
      return this.user.role
    },
    getRoles(): string[] {
      return this.user.roles
    },
    getPermissions(): string[] {
      return this.user.permissions
    },
    getUsername(): string {
      return this.user.username
    },
    getEmail(): string {
      return this.user.email
    },
    getDesc(): string {
      return this.user.desc
    }
  },
  actions: {
    login(username: string, password: string): Promise<any> {
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
      localStorage.removeItem('user')
      this.status.loggedIn = false
      this.user = null
    },
    register(username: string, email: string, password: string) {
      return authService.register({ username, email, password })
    },
    getCurrentUser() { // Get current user from local storage
      return JSON.parse(localStorage.getItem('user') || '{}')
    }

  }
})

