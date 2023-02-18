<template>
  <div class="sidebar">
    <el-menu
      class="sidebar-el-menu"
      :default-active="onRoutes"
      :collapse="sidebar.collapse"
      text-color="#bfc3dd"
      background-color="#324455"
      active-text-color="#20a0ff"
      unique-opened
      router
    >
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-sub-menu :index="item.index" :key="item.index" v-permission="item.permission">
            <template #title>
              <el-icon>
                <component :is="item.icon"></component>
              </el-icon>
              <span>{{ item.title }}</span>
            </template>
            <template v-for="subItem in item.subs">
              <el-sub-menu
                v-if="subItem.subs"
                :index="subItem.index"
                :key="subItem.index"
                v-permission="item.permission"
              >
                <template #title>{{ subItem.title }}</template>
                <el-menu-item
                  v-for="(threeItem, i) in subItem.subs"
                  :key="i"
                  :index="threeItem.index"
                >
                  {{ threeItem.title }}
                </el-menu-item>
              </el-sub-menu>
              <el-menu-item v-else :index="subItem.index" v-permission="item.permission">
                {{ subItem.title }}
              </el-menu-item>
            </template>
          </el-sub-menu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index" v-permission="item.permission">
            <el-icon>
              <component :is="item.icon"></component>
            </el-icon>
            <template #title>{{ item.title }}</template>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import { useSidebarStore } from '~/store/sidebar'
import { useRoute } from 'vue-router'

const items = [
  {
    icon: 'House',
    index: '/',
    title: '系统首页',
    permission: 'dashboard'
  },
  {
    icon: 'Calendar',
    index: '1',
    title: '表格相关',
    permission: 'table',
    subs: [
      {
        index: '/table',
        title: '常用表格',
        permission: 'table'
      },
      {
        index: '/import',
        title: '导入Excel',
        permission: 'import'
      },
      {
        index: '/export',
        title: '导出Excel',
        permission: 'export'
      }
    ]
  },
  {
    icon: 'DocumentCopy',
    index: '/tabs',
    title: 'tab选项卡',
    permission: 'tabs'
  },
  {
    icon: 'Edit',
    index: '3',
    title: '表单相关',
    permission: 'form',
    subs: [
      {
        index: '/form',
        title: '基本表单',
        permission: 'form'
      },
      {
        index: '/upload',
        title: '文件上传',
        permission: 'upload'
      },
      {
        index: '4',
        title: '三级菜单',
        permission: 'menu',
        subs: [
          {
            index: '/editor',
            title: '富文本编辑器',
            permission: 'editor'
          },
          {
            index: '/markdown',
            title: 'markdown编辑器',
            permission: 'markdown'
          }
        ]
      }
    ]
  },
  {
    icon: 'Help',
    index: '/icon',
    title: '自定义图标',
    permission: 'icon'
  },
  {
    icon: 'PieChart',
    index: '/charts',
    title: 'chart图表',
    permission: 'charts'
  },
  {
    icon: 'Warning',
    index: '/permission',
    title: '权限管理',
    permission: 'permission'
  },
  {
    icon: 'Switch',
    index: '/axios',
    title: 'axios封装',
    permission: 'axios'
  },
  {
    icon: 'Location',
    index: '/i18n',
    title: '多语言切换',
    permission: 'i18n'
  },
  {
    icon: 'CoffeeCup',
    index: '/donate',
    title: '支持作者',
    permission: 'donate'
  }
]
const route = useRoute()
const onRoutes = computed(() => {
  return route.path
})

const sidebar = useSidebarStore()
</script>

<style lang="less" scoped>
.sidebar {
  display: block;
  position: absolute;
  left: 0;
  top: 70px;
  bottom: 0;
  overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
  width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
  width: 250px;
}
.sidebar > ul {
  height: 100%;
}
</style>
