<template>
  <div class="content-container">
    <h1>VueUse Sample</h1>
    <hr />
    <p>vueuse sample page</p>
    <hr />
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { useEventListener, useMouse } from '@vueuse/core'

const { x, y } = useMouse()
console.log(x.value)

const mouse = reactive(useMouse())
console.log(mouse.x)

// 使用vueuse的useEventListener
useEventListener('mousemove', (e: MouseEvent) => {
  console.log(e.clientX, e.clientY)
})
</script>

<style lang="less" scoped>
</style>
