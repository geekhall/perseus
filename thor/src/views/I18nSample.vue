<template>
  <div class="content-container">
    <div class="plugins-tips">
      <h1 class="home">{{ $t('sitename') }}</h1>
      <el-card>
        <div>{{ $t('header.content') }}</div>
        <div>{{ $t('header.description') }}</div>
      </el-card>
    </div>

    <el-select v-model="$i18n.locale">
      <el-option v-for="(lang, i) in langs" :key="`Lang${i}`" :value="lang">
        {{ lang }}
      </el-option>
    </el-select>
  </div>
</template>

<script setup lang="ts">
const langs = ['cn', 'en']
</script>

<style lang="less" scoped>
</style>
