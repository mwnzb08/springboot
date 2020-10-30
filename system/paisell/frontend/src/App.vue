<template>
  <div id="app">
    <div id="percent60">
      <div id="title">
        <div style="float: left">
          <router-link to="/"><img id="icon" alt="main pic" src="https://img9.51tietu.net/pic/2019-091213/svzene1covwsvzene1covw.jpg"></router-link>
        </div>
        <div style="float: left">
          {{users.callName}}
          <div v-if="!isLogin">
            <a @click="showBox('login')">还没登录哦</a>
          </div>
          <div v-else>
            <label>欢迎您！</label>
          </div>
        </div>
        <label style="position: absolute; left: 40%; color: black; opacity: 1;font-size: large">{{nowTime}}</label>
        <div style="float: right">ss</div>
    </div>
      <router-view />
    </div>
    <a-modal v-model="showRegistryBox" title="Registry" :centered="true" footer="" style="opacity: 0.8">
      <registry @registryShowRegistryBox="registryShowRegistryBox" ref="registryChild"></registry>
    </a-modal>
    <a-modal v-model="showLoginBox" title="Login" :centered="true" footer="" style="opacity: 0.8">
      <login @loginShowLoginBox="loginShowLoginBox" @registryShowRegistryBox="registryShowRegistryBox" ref="loginChild"></login>
    </a-modal>
  </div>
</template>

<script>
import Registry from './components/baseFunction/Registry';
import Login from './components/baseFunction/Login'
import { mapState } from 'vuex'
export default {
  components: { Registry, Login },
  provide() {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      showRegistryBox: false,
      showLoginBox: false,
      isReload: true,
      timer1: null,
      nowTime: null
    }
  },
  computed: {
    ...mapState({
      users: state => state.users,
      isLogin: state => state.isLogin
    })
  },
  methods: {
    getget() {
      this.axios.post('api/sys/getSession', {
      }).then(() => {
      })
    },
    reload() {
      this.isReload = false
      this.$nextTick(() => {
        this.isReload = true
      })
    },
    logout() {
      this.axios.post('api/sys/loginOut', {
      }).then(() => {
        this.$store.commit('setLogout')
        location.reload()
      })
    },
    registryShowRegistryBox(params) {
      this.showRegistryBox = params
    },
    loginShowLoginBox(params) {
      this.showLoginBox = params
    },
    showBox(action) {
      if (action === 'registry') {
        this.showRegistryBox = true
        this.$refs.registryChild.getRandString()
        this.$refs.registryChild.callNameFocus()
      } else {
        this.showLoginBox = true
        this.$refs.loginChild.getRandString()
        this.$refs.loginChild.callNameFocus()
      }
    }
  },
  mounted () {
    this.timer1 = setInterval(() => {
      new Date().getMilliseconds()
      this.nowTime = window.moment(new Date()).format('yyyy-MM-DD hh:mm:ss:SSS')
    }, 1)
  },
  beforeDestroy () {
    clearTimeout(this.timer1)
  }
}

</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  background-image: url("https://img9.51tietu.net/pic/2019-091213/svzene1covwsvzene1covw.jpg");
  height: 100%;

}

#percent60 {
  margin-left: 20%;
  margin-right: 20%;
  background: #cccccc;
  opacity: 0.6;
  height: 100%;
}

#title {
  height: 40px;
  position: relative;
}

#icon {
  height: 40px;
  width: 60px;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
