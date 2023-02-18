<template>
  <div class="counter">
    <h3>Counter</h3>
    <hr />
    <h2>{{ cnt }}</h2>
    <p>Counter page</p>
    <el-button type="primary" @click="increase">Increase</el-button>
    <el-button type="primary" @click="decrease">Decrease</el-button>
  </div>
</template>
<script lang="ts" setup>
import { computed, ref } from 'vue'
import mainStore from '~/store'
const store = mainStore()

const cnt = computed(() => store.count)
const increase = () => store.increment()
const decrease = () => store.decrement()
</script>

<style lang="less" scoped>
.counter {
  width: 100%;
  height: 100px;
}
</style>
