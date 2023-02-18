<template>
  <div class="content-container">
    <h1>Iconify Sample</h1>
    <hr />
    <div class="title2">1. Use Iconify</div>
    <hr />
    <div class="i-ep-lock"></div>
    <i-ep-edit />
    <i-ep-search></i-ep-search>
    <div style="width: 100%">
      <el-space direction="vertical" alignment="left">
        <!-- 直接使用 -->
        <el-space>
          <!-- 使用class -->
          <div class="i-ep-lock"></div>
          <!-- 使用标签 -->
          <i-ep-edit />
        </el-space>

        <!-- 组件里使用 -->
        <el-button icon="i-ep-avatar">Button</el-button>

        <el-input prefix-icon="i-ep-search" suffix-icon="i-ep-pointer"></el-input>

        <el-menu>
          <el-menu-item>
            <el-icon class="i-ep-menu"></el-icon>
            <span>Navigator Two</span>
          </el-menu-item>
        </el-menu>
      </el-space>
      <div class="title2">2. Use Element Plus icons-vue</div>
      <el-icon :size="30" :color="editColor">
        <Edit />
      </el-icon>
      <hr />

      <el-icon :size="20">
        <Edit />
      </el-icon>
      <el-icon color="#409EFC" class="no-inherit">
        <Share />
      </el-icon>
      <el-icon>
        <Delete />
      </el-icon>
      <el-icon class="is-loading">
        <Loading />
      </el-icon>
      <el-button type="primary">
        <el-icon style="vertical-align: middle">
          <Search />
        </el-icon>
        <span style="vertical-align: middle"> Search </span>
      </el-button>
      <el-icon :size="ticketSize">
        <Ticket />
      </el-icon>
      <hr />
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const editColor = ref('#e83960')
const ticketSize = ref(50)
</script>

<style lang="less" scoped>
</style>
