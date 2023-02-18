<template>
  <div class="content-container">
    <div class="form-box">
      <el-form ref="formRef" :rules="rules" :model="form" label-width="80px">
        <el-form-item label="表单名称" prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="选择器" prop="region">
          <el-select v-model="form.region" placeholder="请选择">
            <el-option key="系统管理员" label="系统管理员" value="系统管理员"></el-option>
            <el-option key="白金会员" label="白金会员" value="白金会员"></el-option>
            <el-option key="用户" label="用户" value="用户"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="日期时间">
          <el-col :span="11">
            <el-form-item prop="date1">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="form.date1"
                style="width: 100%"
              ></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="date2">
              <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%">
              </el-time-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="城市级联" prop="options">
          <el-cascader :options="options" v-model="form.options"></el-cascader>
        </el-form-item>
        <el-form-item label="选择开关" prop="delivery">
          <el-switch v-model="form.delivery"></el-switch>
        </el-form-item>
        <el-form-item label="多选框" prop="type">
          <el-checkbox-group v-model="form.type">
            <el-checkbox label="前端" name="type"></el-checkbox>
            <el-checkbox label="后端" name="type"></el-checkbox>
            <el-checkbox label="人工智能" name="type"></el-checkbox>
            <el-checkbox label="大数据" name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="单选框" prop="language">
          <el-radio-group v-model="form.language">
            <el-radio label="Java"></el-radio>
            <el-radio label="Python"></el-radio>
            <el-radio label="Typescript"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="文本框" prop="desc">
          <el-input type="textarea" rows="5" v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit(formRef)">表单提交</el-button>
          <el-button @click="onReset(formRef)">重置表单</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup lang="ts" name="baseform">
import { reactive, ref } from 'vue'
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'

const options = [
  {
    value: 'liaoning',
    label: '辽宁省',
    children: [
      {
        value: 'shenyang',
        label: '沈阳市',
        children: [
          {
            value: 'heping',
            label: '和平区'
          },
          {
            value: 'shenhe',
            label: '沈河区'
          },
          {
            value: 'huanggu',
            label: '皇姑区'
          },
          {
            value: 'dadong',
            label: '大东区'
          },
          {
            value: 'tiexi',
            label: '铁西区'
          }
        ]
      },
      {
        value: 'dalian',
        label: '大连市',
        children: [
          {
            value: 'shahekou',
            label: '沙河口区'
          },
          {
            value: 'ganjingzi',
            label: '甘井子区'
          }
        ]
      }
    ]
  },
  {
    value: 'beijing',
    label: '北京市',
    children: [
      {
        value: 'dongcheng',
        label: '东城区'
      },
      {
        value: 'xicheng',
        label: '西城区'
      },
      {
        value: 'haidian',
        label: '海淀区'
      },
      {
        value: 'chaoyang',
        label: '朝阳区'
      },
      {
        value: 'fengtai',
        label: '丰台区'
      }
    ]
  }
]
const rules: FormRules = {
  name: [{ required: true, message: '请输入表单名称', trigger: 'blur' }]
}
const formRef = ref<FormInstance>()
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: true,
  type: ['前端', '后端'],
  language: 'Typescript',
  desc: '',
  options: []
})
// 提交
const onSubmit = (formEl: FormInstance | undefined) => {
  // 表单校验
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      console.log(form)
      ElMessage.success('提交成功！')
    } else {
      return false
    }
  })
}
// 重置
const onReset = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>
