import { defineStore } from 'pinia'
import { useUserStore } from '~/store/auth'
import { useRoute } from 'vue-router'

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
          'dashboard', 'environment', 'roster', 'table', 'import', 'export', 'tabs', 'form', 'upload', 'menu', 'editor', 'markdown', 'icon', 'charts', 'permission', 'axios', 'i18n', 'donate', '15', '16'
        ],
        user: ['dashboard', 'environment', 'roster', 'table', 'import', 'export', 'icon', 'charts', 'permission', 'axios', 'i18n', 'donate']
      }
    };
  },
  actions: {
    handleSet(val: string[]) {
      this.key = val;
    },
    generateRoutes() {
      const route = useRoute();
      const userStore = useUserStore();
      const roles = userStore.getRoles();
      const permissions = userStore.getPermissions();
      const routes = route.matched;
      const keys = [];
      routes.forEach((item) => {
        if (item.meta && item.meta.permission) {
          if (roles.includes('admin')) {
            keys.push(item.meta.permission);
          } else {
            if (permissions.includes(item.meta.permission)) {
              keys.push(item.meta.permission);
            }
          }
        }
      });
      localStorage.setItem('ms_keys', JSON.stringify(keys));
      this.handleSet(keys);
    }
  }
});
