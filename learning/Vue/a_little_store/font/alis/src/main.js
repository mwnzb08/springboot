import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import axios from 'axios';
import { Input, Button, Icon, Drawer } from 'ant-design-vue'

Vue.prototype.axios = axios;
require('./style/width-check.less')
Vue.use(Input);
Vue.use(Button);
Vue.use(Icon);
Vue.use(Drawer);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
