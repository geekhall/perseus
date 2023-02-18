<template>
  <div class="content-container">
    <h1>Editor</h1>
    <hr />
    <div class="plugins-tips">
      <p>使用 <a href="https://www.wangeditor.com/" target="_blank">wangeditor</a> 富文本编辑器</p>
    </div>
    <div class="editor-container">
      <div class="editor mgb20" ref="editor"></div>
      <div class="editor-content">
        <el-input type="textarea" v-model="editorContent.html" placeholder="请输入内容" />
        <el-button class="btn" type="primary" @click="syncHTML">同步</el-button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import wangEditor from 'wangeditor'
import { ref, reactive, onMounted, onBeforeUnmount } from 'vue'

const editor = ref(null as any)
const editorContent = reactive({
  html: '',
  text: ''
})

let editorInstance: any = null

onMounted(() => {
  editorInstance = new wangEditor(editor.value)
  editorInstance.config.zIndex = 1
  editorInstance.create()
  editorInstance.txt.html(editorContent.html)
  editorInstance.onchange = () => {
    editorContent.html = editorInstance.txt.html()
    editorContent.text = editorInstance.txt.text()
  }
})
onBeforeUnmount(() => {
  editorInstance.destroy()
  editorInstance = null
})

const syncHTML = () => {
  editorContent.html = editorInstance.txt.html()
  console.log(editorContent.html)
}
</script>

<style lang="less" scoped>
.editor-container {
  display: flex;
  .editor {
    flex: 1;
  }
  .editor-content {
    flex: 1;
    margin-left: 20px;
  }
}
</style>
