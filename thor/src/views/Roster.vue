
<template>
  <div class="content-container">
    <h1>夜间批量值班表</h1>
    <hr />
    <el-button text @click="handleEdit(1)"> click to open the Dialog </el-button>
    <p>Roster page</p>
    <Counter />

    <el-dialog v-model="dialogVisible" title="Tips" width="30%" :before-close="handleClose">
      <span>This is a message</span>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="dialogVisible = false"> Confirm </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import { ElMessageBox } from 'element-plus'

let dialogVisible = ref(false)
const handleEdit = (index: number) => {
  console.log('handleEdit clicked')
  console.log(index)
  dialogVisible = ref(true)
}
const handleClose = (done: () => void) => {
  ElMessageBox.confirm('Are you sure to close this dialog?')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
}
</script>

<style lang="less" scoped>
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>
