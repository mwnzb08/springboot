import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import moment from 'moment'
import message from './assets/reminder/message'
import { Input, Button, Icon, Drawer, Modal, FormModel, Tooltip, Form, Alert } from 'ant-design-vue'

window.moment = moment
Vue.prototype.axios = axios
Vue.config.productionTip = false
require('./assets/css/globalcss.less')
Vue.use(Input)
Vue.use(Button)
Vue.use(Icon)
Vue.use(Drawer)
Vue.use(Modal)
Vue.use(FormModel)
Vue.use(Tooltip)
Vue.use(Form)
Vue.use(Alert)

var g = {
  message: message,
  checkNull (...field) {
    var result = false
    field.forEach((it) => {
      if (it.trim() === '' || it.trim() === null) {
        result = true
      }
    })
    return result
  },
  showMessage(content, args) {
    if (args && args.length > 0) {
      for (let i = 0; i < args.length; i++) {
        if (content.indexOf('{' + i + '}') >= 0) {
          content = content.replace('{' + i + '}', args[i])
        }
      }
    }
    return content
  },
  showAlert (type, content, args) {
    return new Promise(resolve => {
      if (args && args.length > 0) {
        for (let i = 0; i < args.length; i++) {
          if (content.indexOf('{' + i + '}') >= 0) {
            content = content.replace('{' + i + '}', args[i])
          }
        }
      }
      Modal.info({
        title: type,
        content: content,
        onOk() {
          console.log('OK');
        }
      })
      resolve('ok')
    })
  }
}
window.g = g

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
