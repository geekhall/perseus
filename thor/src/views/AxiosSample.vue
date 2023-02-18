<template>
  <div class="content-container">
    <div class="plugins-tips">
      <h1>Axios Sample Page</h1>
      <el-card>
        <div>
          这是一个前后端通信的示例页面，对应的后端工程是：<a
            href="https://github.com/geekhall/hera"
            target="_blank"
            >hera</a
          >
        </div>
      </el-card>
      <el-button class="btn" type="primary" @click="clearProducts">清空数据</el-button>
      <el-button class="btn" type="primary" @click="getProducts">获取数据</el-button>
    </div>

    <hr />
    <div class="data-container">
      <div class="content">
        <el-table :data="envs" stripe>
          <el-table-column prop="id" label="ID" width="80"> </el-table-column>
          <el-table-column prop="name" label="环境名称" width="120"> </el-table-column>
          <el-table-column prop="description" label="描述" width="150"> </el-table-column>
          <el-table-column prop="dbType" label="数据库类型" width="120"> </el-table-column>
          <el-table-column prop="dbHost" label="IP" width="120"> </el-table-column>
          <el-table-column prop="dbPort" label="端口" width="80"> </el-table-column>
          <el-table-column prop="dbServName" label="实例名" width="120"> </el-table-column>
          <el-table-column prop="dbName" label="库名" width="120"> </el-table-column>
          <el-table-column prop="dbUser" label="用户名" width="120"> </el-table-column>
          <el-table-column prop="comment" label="备注"> </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { computed, onMounted, ref } from 'vue'
import axios from 'axios'

interface ILocalEnvironment {
  id: number
  name: string
  description: string
  dbType: string
  dbHost: string
  dbPort: number
  dbServType: string
  dbServName: string
  dbName: string
  dbUser: string
  dbPassword: string
  userId: number
  useFrom: string
  useTo: string
  deleted: boolean
}

let title_color = ['#f60', '#3c0']
const envs = ref([{}] as ILocalEnvironment[])
const currentDate = ref(new Date())
const clearProducts = () => {
  envs.value = []
}
const handleEdit = (index: number, row: ILocalEnvironment) => {
  console.log(index, row)
}
const handleDelete = (index: number, row: ILocalEnvironment) => {
  console.log(index, row)
}
const getProducts = async () => {
  const result = await axios({
    method: 'GET',
    url: '/api/environment/all'
  })
    .then((res: any) => {
      console.log(res.data)
      console.log('Test2:@@@' + JSON.stringify(res.data))
      envs.value = JSON.parse(JSON.stringify(res.data))
      console.log('Test2:@@@: envs=' + JSON.stringify(envs))
    })
    .catch((err: any) => {
      console.log(err.message)
    })
}
const random_color = () => {
  return title_color[Math.floor(Math.random() * title_color.length)]
}

onMounted(() => {
  getProducts()
})
</script>

<style lang="less" scoped>
.title {
  color: cyan;
}
.btn {
  margin: 10px;
}

.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}
.data-container {
  align-content: center;
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin: 0 auto;
  padding: 0;
}
.content {
  margin: 0 auto;
  padding: 0;
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  align-content: space-around;
  justify-content: center;
}

.box {
  border: 1px solid #ccc;
  border-radius: 0.25em;
  margin: 1em;
  width: 18em;
  height: 12em;
  text-align: center;
  font-size: 1em;
  display: flex;
  flex-direction: column;
  padding: 0.25em;
  box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
  border-radius: 0.5em;
  .box-title {
    display: flex;
    flex-direction: row;
    align-content: space-between;
    justify-content: center;
    .main-title {
      text-align: center;
      font-size: 2em;
      color: red;
    }
    .sub-title {
      font-size: 1.5em;
      color: #777;
      align-self: right;
    }
  }
  .db-info {
    display: flex;
    flex-direction: column;
    text-align: left;
  }
  .user-info {
    display: flex;
    flex-direction: column;
  }
}
.box:hover {
  box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;
  transform: translateY(-3px);
}
</style>
