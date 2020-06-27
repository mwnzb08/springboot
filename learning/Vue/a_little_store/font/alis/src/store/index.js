import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

let defaultLogin = false

try {
  if (localStorage.isLogin) {
    console.log('is isLogin')
    defaultLogin = localStorage.isLogin
  }
} catch (e) {
  console.log('login error for status')
}

let defaultUser = '你还未登录o'

try {
  if (localStorage.users) {
    defaultUser = localStorage.users
  }
} catch (e) {
  console.log('login error for users')
}

export default new Vuex.Store({
  state: {
    backgroundHeight: null,
    nowUrl: null,
    isDirty: false,
    isLogin: defaultLogin,
    users: defaultUser
  },
  mutations: {
    saveBackgroundHeight: function () {
      window.localStorage.setItem('backgroundHeight', this.state.backgroundHeight.toString())
      window.localStorage.setItem('nowUrl', this.state.nowUrl.toString())
    },
    getBackgroundHeight: function () {
      this.state.backgroundHeight = window.localStorage.getItem('backgroundHeight')
      this.state.nowUrl = window.localStorage.getItem('nowUrl')
    },
    setDirty: function (state, isDirty) {
      state.isDirty = isDirty
    },
    setLogin: function (state, loginStates) {
      console.log('login error for status' + loginStates)
      state.isLogin = loginStates.isLogin
      state.users = loginStates.userName
      try {
        localStorage.isLogin = loginStates.isLogin
        localStorage.users = loginStates.userName
      } catch (e) {
        console.log('login error for status')
      }
    },
    setLogout: function () {
      console.log('do logout')
      try {
        localStorage.clear()
      } catch (e) {
        console.log('do logout error')
      }
    }
  },
  actions: {},
  modules: {}
});
