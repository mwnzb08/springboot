import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

let defaultLogin = false
let defaultUser = { callName: '游客 ' + Math.floor(Math.random() * 10000 + 1) }

try {
  if (localStorage.isLogin) {
    defaultLogin = localStorage.isLogin
  } else {
    console.log('>>>>>>>>>>>>')
    this.$router.push({ path: '/' })
  }
} catch (e) {
  //
}
try {
  if (localStorage.users) {
    defaultUser = JSON.parse(localStorage.users)
  } else {
    localStorage.users = JSON.stringify(defaultUser)
  }
} catch (e) {
  //
}

export default new Vuex.Store({
  state: {
    isLogin: defaultLogin,
    users: defaultUser
  },
  mutations: {
    setLogin(state, loginStates) {
      state.isLogin = loginStates.isLogin
      state.users = loginStates.users
      try {
        console.log('login ')
        localStorage.isLogin = loginStates.isLogin
        localStorage.users = JSON.stringify(loginStates.users)
      } catch (e) {
        console.log('login error for save localStorage')
      }
    },
    setLogout: function () {
      try {
        console.log('logout ')
        localStorage.clear()
      } catch (e) {
        //
      }
    }
  },
  actions: {},
  modules: {}
})
