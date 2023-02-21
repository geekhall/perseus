/**
 * check if user is logged in and return Authorization header with JWT token
 *
 * @returns {Object} - Authorization header with JWT token
 */
export default function authHeader() {
  const user = JSON.parse(localStorage.getItem('user')!)

  if (user && user.accessToken) {
    return { Authorization: 'Bearer ' + user.accessToken }
  } else {
    return {}
  }
}
