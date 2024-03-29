<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">后台管理系统</div>
      <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
        <el-form-item prop="username">
          <el-input v-model="param.username" placeholder="username">
            <template #prepend>
              <el-button tabindex="-1">
                <el-icon><User /></el-icon>
              </el-button>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password"
            placeholder="password"
            v-model="param.password"
            @keyup.enter="submitForm(login)"
            show-password
          >
            <template #prepend>
              <el-button tabindex="-1">
                <el-icon><Lock /></el-icon>
              </el-button>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-checkbox v-model="param.rememberMe">记住密码</el-checkbox>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm(login)">登录</el-button>
        </div>
        <p class="login-tips">
          <span>没有账号？</span> <router-link to="/register">立即注册</router-link>
        </p>
      </el-form>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, computed, onMounted } from 'vue'
import { useTagsStore } from '../store/tags'
import { usePermissionStore } from '../store/permission'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'
import { Lock, User } from '@element-plus/icons-vue'
import UserModel from '~/models/user'
import { useUserStore } from '~/store/auth'
import authService from '~/services/auth-service'

const userStore = useUserStore()
const loading = ref(false)
const message = ref('')

onMounted(() => {
  if (userStore.status.loggedIn) {
    console.log('login success onMounted')
    router.push('/dashboard')
  }
})

const handleLogin = () => {
  loading.value = true
  return authService
    .login(param.username, param.password, param.rememberMe || false)
    .then(
      (data) => {
        ElMessage.success('登录成功')
        console.log('login success')
        // permission.generateRoutes()
        userStore.status.loggedIn = true
        userStore.user = data
        loading.value = false
        router.push('/dashboard')
      },
      (error) => {
        console.log('login error 001')
        loading.value = false
        userStore.status.loggedIn = false
        ElMessage.error('登录失败，验证未通过:' + error.message)
      }
    )
    .catch((error) => {
      console.log('login error 003: ' + error)
      loading.value = false
      userStore.status.loggedIn = false
      return Promise.reject(error)
    })
}

const router = useRouter()
const param = reactive<UserModel>({
  username: 'test001',
  password: '123456',
  rememberMe: true
})
const rules: FormRules = {
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur'
    }
  ],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
}

const permission = usePermissionStore()
const login = ref<FormInstance>()
const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid: boolean) => {
    if (valid) {
      console.log('valid ok')
      handleLogin().catch(() => {
        console.log('login error 002')
      })
    } else {
      console.log('login error 003')
      ElMessage.error('登录失败，验证未通过')
      loading.value = false
      userStore.status.loggedIn = false
      return false
    }
  })
}

const tags = useTagsStore()
tags.clearTags()
</script>

<style scoped>
.login-wrap {
  position: relative;
  width: 100%;
  /* height: 100%; */
  height: 100%;
  background-image: url(../assets/img/login-bg.jpg);
  background-size: 100%;
  background-color: rebeccapurple;
}
.ms-title {
  width: 100%;
  line-height: 50px;
  text-align: center;
  font-size: 20px;
  color: #fff;
  border-bottom: 1px solid #ddd;
}
.ms-login {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 350px;
  margin: -190px 0 0 -175px;
  border-radius: 5px;
  background: rgba(255, 255, 255, 0.3);
  overflow: hidden;
}
.ms-content {
  padding: 30px 30px;
}
.login-btn {
  text-align: center;
}
.login-btn button {
  width: 100%;
  height: 36px;
  margin-bottom: 10px;
}
.login-tips {
  font-size: 12px;
  line-height: 30px;
  color: #fff;
}
</style>
