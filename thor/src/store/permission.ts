import { defineStore } from 'pinia'

interface ObjectList {
  [key: string]: string[]
}

export const usePermissionStore = defineStore('permission', {
  state: () => {
    const keys = localStorage.getItem('ms_keys');
    return {
      key: keys ? JSON.parse(keys) : <string[]>[],
      defaultList: <ObjectList>{
        admin: [
          'dashboard', 'table', 'import', 'export', 'tabs', 'form', 'upload', 'menu', 'editor', 'markdown', 'icon', 'charts', 'permission', 'axios', 'i18n', 'donate', '15', '16'
        ],
        user: ['dashboard', 'table', 'import', 'export', 'icon', 'charts', 'permission', 'axios', 'i18n', 'donate']
      }
    };
  },
  actions: {
    handleSet(val: string[]) {
      this.key = val;
    }
  }
});
