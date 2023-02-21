export default class UserModel {
  constructor(
    public id?: string,
    public username: string = '',
    public email?: string,
    public password: string = '',
    public roles?: string[],
    public accessToken?: string
  ) { }
}
