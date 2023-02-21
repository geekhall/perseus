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
import { storeToRefs } from 'pinia'
import { computed, ref } from 'vue'
import { useCounterStore } from '~/store/counter'

const counter = useCounterStore()

const cnt = computed(() => counter.count)
const increase = () => counter.increment()
const decrease = () => counter.decrement()
</script>

<style lang="less" scoped>
.counter {
  width: 100%;
  height: 100px;
}
</style>
