<template>
  <div>
    <div class="content-container">
      <div class="handle-box">
        <el-button type="primary" @click="exportXlsx">导出Excel</el-button>
      </div>
      <el-table :data="tableData" border class="table" header-cell-class-name="table-header">
        <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
        <el-table-column prop="name" label="讲师名"></el-table-column>
        <el-table-column prop="intro" label="简介"></el-table-column>
        <el-table-column prop="career" label="职业"></el-table-column>
        <el-table-column prop="age" label="年龄"></el-table-column>
        <el-table-column prop="sex" label="性别"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script setup lang="ts" name="export">
import { ref } from 'vue'
import * as XLSX from 'xlsx'

interface TableItem {
  id: number
  name: string
  intro: string
  career: string
  age: string
  sex: string
}

const tableData = ref<TableItem[]>([])
// 获取表格数据
const getData = () => {
  tableData.value = [
    {
      id: 1,
      name: '张三',
      intro: '金牌讲师',
      career: '前端',
      age: '30',
      sex: '男'
    },
    {
      id: 2,
      name: '李四',
      intro: '银牌讲师',
      career: '后端',
      age: '29',
      sex: '女'
    }
  ]
}
getData()

const list = [['序号', '讲师名', '简介', '职业', '年龄', '性别']]
const exportXlsx = () => {
  tableData.value.map((item: any, i: number) => {
    const arr: any[] = [i + 1]
    arr.push(...[item.name, item.intro, item.career, item.age, item.sex])
    list.push(arr)
  })
  let WorkSheet = XLSX.utils.aoa_to_sheet(list)
  let new_workbook = XLSX.utils.book_new()
  XLSX.utils.book_append_sheet(new_workbook, WorkSheet, '第一页')
  XLSX.writeFile(new_workbook, `表格.xlsx`)
}
</script>

<style scoped>
.handle-box {
  margin-bottom: 20px;
}

.handle-select {
  width: 120px;
}

.handle-input {
  width: 300px;
}
.table {
  width: 100%;
  font-size: 14px;
}
.red {
  color: #f56c6c;
}
.mr10 {
  margin-right: 10px;
}
.table-td-thumb {
  display: block;
  margin: auto;
  width: 40px;
  height: 40px;
}
</style>
