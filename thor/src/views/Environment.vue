
<template>
  <h1>核心系统开发测试环境</h1>
  <hr />
  <el-table id="src-table" :data="tableData">
    <el-table-column label="No." width="50px" align="center">
      <template #default="scope">
        <div style="display: flex; align-items: center">
          <span style="margin-left: 10px">{{ scope.row.no }}</span>
        </div>
      </template>
    </el-table-column>
    <el-table-column label="环境名称" width="120px" align="center">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top" width="auto">
          <template #default>
            <div>name: {{ scope.row.name }}</div>
            <div>address: {{ scope.row.db_address }}</div>
          </template>
          <template #reference>
            <el-tag>{{ scope.row.name }}</el-tag>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="数据库地址" prop="db_address" width="240px" align="center" />
    <el-table-column label="应用地址" prop="app_address" width="160px" align="center" />
    <el-table-column label="柜面地址" prop="front_address" width="160px" align="center" />
    <el-table-column label="ESB地址" prop="esb_address" width="160px" align="center" />
    <el-table-column label="使用人" prop="user" width="80px" />
    <el-table-column label="使用项目" prop="project" width="200px" />
    <el-table-column label="使用日期" prop="date" width="120px" />
    <el-table-column label="Operations" align="center">
      <template #default="scope">
        <el-button type="primary" size="small" @click="handleEdit(scope.$index, scope.row)"
          >Edit</el-button
        >

        <!-- <el-button type="primary" size="small">Edit</el-button> -->
      </template>
    </el-table-column>
  </el-table>
  <hr />
  <el-dialog v-model="dialogFormVisible" title="Shipping address">
    <el-form :model="form">
      <el-form-item label="Name" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Address" :label-width="formLabelWidth">
        <el-input v-model="form.address" placeholder="Please select a user"></el-input>
      </el-form-item>
      <el-form-item>
        <el-option label="Yiny" value="yiny" />
        <el-option label="Lix" value="lix" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogFormVisible = false"> Confirm </el-button>
      </span>
    </template>
  </el-dialog>
  <hr />
</template>

<script lang="ts" setup>
// import { Timer } from "@element-plus/icons-vue";
import { reactive, ref } from 'vue'
const dialogFormVisible = ref(false)
const formLabelWidth = ref('140px')
let form = reactive({
  name: '',
  address: ''
})
interface Environment {
  no: number
  name: string
  db_address: string
  app_address: string
  esb_address: string
  front_address: string
  user: string
  project: string
  date: string
  editable: boolean
}

const handleEdit = (index: number, row: Environment) => {
  console.log('handleEdit clicked')
  console.log(index, row)
  // dialogFormVisible = ref(true);
}

const tableData: Environment[] = [
  {
    no: 1,
    name: 'cbs1',
    db_address: '16.24.44.106:1529/cbs1_app',
    app_address: '16.24.60.11-13',
    esb_address: '16.24.44.40',
    front_address: '',
    user: '陈明星，贾洪亮',
    project: '贷款机构转移、新综合前置',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 2,
    name: 'cbs2',
    db_address: '16.24.44.106:1529/cbs2_app',
    app_address: '16.24.60.21-23',
    esb_address: '16.24.44.41',
    front_address: '',
    user: '林乐森',
    project: '智能存款',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 3,
    name: 'cbs3',
    db_address: '16.24.44.106:1529/cbs3_app',
    app_address: '16.24.38.41-43',
    esb_address: '16.24.44.42',
    front_address: '',
    user: '丁雷雷',
    project: '',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 4,
    name: 'cbs4',
    db_address: '16.24.44.107:1529/cbs4_app',
    app_address: '16.24.38.51-53',
    esb_address: '16.24.44.43',
    front_address: '',
    user: '陈明星',
    project: '网贷',
    date: '2023-10-01',
    editable: false
  },
  {
    no: 5,
    name: 'cbs5',
    db_address: '16.24.44.107:1529/cbs5_app',
    app_address: '16.24.43.91-93',
    esb_address: '16.24.44.44',
    front_address: '',
    user: 'UAT',
    project: 'UAT',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 6,
    name: 'cbs6',
    db_address: '16.24.44.107:1529/cbs6_app',
    app_address: '16.24.38.111-113',
    esb_address: '16.24.44.45',
    front_address: '',
    user: '李隆业',
    project: '',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 7,
    name: 'cbs7',
    db_address: '16.24.44.107:1529/cbs7_app',
    app_address: '16.24.38.121-123',
    esb_address: '16.24.44.46',
    front_address: '',
    user: '林乐森',
    project: '智能存款享存产品测试',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 8,
    name: 'cbs8',
    db_address: '16.24.44.107:1529/cbs8_app',
    app_address: '',
    esb_address: '',
    front_address: '',
    user: '林乐森',
    project: '智能存款享存产品测试',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 9,
    name: 'cbs9',
    db_address: '16.24.44.106:1529/cbs9_app',
    app_address: '16.24.38.113,115',
    esb_address: '16.24.44.132',
    front_address: '',
    user: 'SIT',
    project: 'SIT共用',
    date: '2023-10-01',
    editable: false
  },
  {
    no: 10,
    name: 'cbs10',
    db_address: '16.24.44.107:1529/vdb3_app',
    app_address: '',
    esb_address: '',
    front_address: '',
    user: '陈明星',
    project: '网贷',
    date: '2023-10-01',
    editable: true
  },
  {
    no: 11,
    name: 'cbs11',
    db_address: '16.24.44.107:1529/vdb4_app',
    app_address: '16.24.38.44-46',
    esb_address: '',
    front_address: '',
    user: '刘永飞',
    project: '电票系统测试',
    date: '2023-10-01',
    editable: true
  },

  {
    no: 12,
    name: '开发环境',
    db_address: '16.24.44.107:1529/sopdb1',
    app_address: '16.24.43.99',
    esb_address: '',
    front_address: '',
    user: '共用',
    project: '开发环境',
    date: '-',
    editable: false
  },
  {
    no: 13,
    name: '开发版本',
    db_address: '16.24.44.107:1529/SOPDBVER',
    app_address: '16.24.43.98',
    esb_address: '',
    front_address: '',
    user: '共用',
    project: '开发版本',
    date: '-',
    editable: false
  }
]
</script>


<style lang="less" scoped>
#src-table {
  width: 1440px;
}
.el-button--text {
  margin-right: 15px;
}
.el-select {
  width: 300px;
}
.el-input {
  width: 300px;
}
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>
