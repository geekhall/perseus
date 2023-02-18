<template>
  <div class="content-container">
    <h1>SVG Sample</h1>
    <hr />
    <div class="container">
      <div class="title2">1. Use epIcons svg</div>
      <div class="home1"></div>
      <icon name="ep-home-1"></icon>
      <icon name="ep-home-1-door-solid"></icon>
      <icon name="ep-home-1-door-1"></icon>

      <div class="title2">2. Use www.iconfont.cn</div>
      <p>
        访问iconfont，搜索想要的图标，然后直接下载使用svg即可。可以修改svg中的width、height、fill来修改大小和颜色
      </p>
      <svg
        t="1675149728931"
        class="icon"
        viewBox="0 0 1024 1024"
        version="1.1"
        xmlns="http://www.w3.org/2000/svg"
        p-id="2826"
        width="50"
        height="50"
      >
        <path
          d="M267.168 454.624v316.48h152V598.224c0-6.144 4.992-11.12 11.136-11.12h169.728c6.16 0 11.136 4.976 11.136 11.12v172.88h136V453.6l-239.36-188.848-240.64 189.856z m-48 37.872l-39.36 31.04a16 16 0 0 1-22.464-2.656l-9.904-12.56a16 16 0 0 1 2.656-22.464l347.792-274.416a16 16 0 0 1 19.84 0l347.792 274.4a16 16 0 0 1 2.656 22.48l-9.92 12.56a16 16 0 0 1-22.464 2.656l-40.624-32.048v292.48a35.136 35.136 0 0 1-35.136 35.136H254.304a35.136 35.136 0 0 1-35.136-35.136V492.496z m248 270.608h96v-128h-96v128z"
          fill="#000000"
          p-id="2827"
        ></path>
      </svg>
      <div class="title2">3. Use Element Plus icons-vue</div>
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
    </div>
  </div>
</template>

<script lang="ts" setup>
import { Ticket } from '@element-plus/icons-vue'
import { ref } from 'vue'
const editColor = ref('#e83960')
const ticketSize = ref(50)
const buildingSvgs = [
  { name: 'home-1' },
  { name: 'home-1-strip' },
  { name: 'home-1-strip-solid' },
  { name: 'home-1-solid' },
  { name: 'home-1-smile' },
  { name: 'home-1-smile-solid' },
  { name: 'home-1-line' },
  { name: 'home-1-line-solid' },
  { name: 'home-1-door' },
  { name: 'home-1-door-solid' },
  { name: 'home-1-door-solid-1' },
  { name: 'home-1-door-1' }
]
</script>

<style lang="less" scoped>
.home1 {
  width: 50px;
  height: 50px;
  background: url(~/assets/svg/ep-home-1.svg);
  background-size: 50px 50px;
}
.container {
  width: 100%;
  height: 100%;
  padding: 24px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.content {
  width: 100%;
  height: 100%;
  padding: 24px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.title2 {
  font-size: 24px;
  font-weight: bold;
  margin: 24px 0;
  float: left;
}
</style>
