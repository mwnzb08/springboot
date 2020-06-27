<template>
  <div id="app" class="backImage" :style="{ height: bodyH }">
    <littleman></littleman>
    <br>
    <br>
    <div>
    <div class="userInfo" id="nav" ref="nav" :style="{height: userH}">
      <a-icon type="user" style="font-size: x-large" @click="showDrawer"></a-icon>
      <label class="cursors" style="color: white; font-size: x-large" v-text="this.$store.state.users" @click="showDrawer"></label>
      <div class="userDrawer">
        <a-drawer
                title="User message"
                placement="top"
                :closable="false"
                :visible="visible"
                :get-container="false"
                :wrap-style="{ position: 'absolute' }"
                @close="onClose"
                height="90%"
        >
          <div v-if="isLogin">
            levels: {{levels}}
            <br>
            money：{{money}}
            <br>
            notices:{{notices}}
            <br>
            <button @click="logout">Logout</button>
            <br>
          </div>
          <div v-else>
            Account:
            <br>
            <input v-model="account"/>
            <br>
            password:
            <br><input v-model="pwd"/>
            <br>
            <br>
            <button @click="login">Login</button>
            <br>
            <a class="cursors" @click="registry">registry</a>
          </div>
        </a-drawer>
      </div>
    </div>
    </div>
    <div class="leftAndRight" :style="{ height: bodyH - 30 + 'px'}">
      <router-view id="bodyHeight" ref="bodyHeight"/>
    </div>
  </div>
</template>

<script>
import littleman from './components/littleman'
export default {
  components: {
    littleman
  },
  data() {
    return {
      bodyH: null,
      vuexStoreHeight: null,
      nowUrl: null,
      visible: true,
      account: null,
      pwd: null,
      levels: 0,
      money: 0,
      notices: ''
    }
  },
  created () {
    // 获取window.localStorage保存的url及背景的高度
    this.$store.commit('getBackgroundHeight')
    this.vuexStoreHeight = this.$store.state.backgroundHeight
    this.nowUrl = this.$store.state.nowUrl
  },
  computed: {
    userH() {
      return document.documentElement.clientHeight * 0.4 + 'px'
    },
    isLogin() {
      return this.$store.state.isLogin
    }
  },
  mounted () {
    this.calculateHeight()
    this.onRefresh()
  },
  methods: {
    registry() {
      this.$router.push('registry')
    },
    // 计算页面的高度用来自适应背景图片的高度
    calculateHeight() {
      // 获取当前屏幕的高度
      const clientH = document.documentElement.clientHeight
      // 获取块元素的高度
      const bodyH = document.getElementById('bodyHeight').scrollHeight + document.getElementById('nav').scrollHeight
      console.log('>>>>>vuexStoreHeight' + this.vuexStoreHeight + '>>>>>>>>now' + this.$route.path + '>>>>>store' + this.nowUrl)
      // 用于刷新时候的判断，当有保存背景图片高度且路由不产生变化的时候直接使用保存的背景高度
      if (this.vuexStoreHeight && this.nowUrl === this.$route.path) {
        console.log('>>>>>>>>>>>>>1')
        this.bodyH = this.vuexStoreHeight
      } else {
        console.log('>>>>>>>>>>>>>2')
        // else 当大于屏幕的高度时候设置背景图片的高度为块元素的高度，保存到windows.localStorage
        if (clientH < (bodyH)) {
          this.bodyH = bodyH + 30 + 'px'
          this.$store.state.backgroundHeight = this.bodyH
          this.$store.state.nowUrl = this.$route.path
          this.$store.commit('saveBackgroundHeight')
        } else {
          // else 铺满屏幕
          this.bodyH = '100%'
        }
      }
    },
    showDrawer() {
      if (this.visible) {
        this.visible = false
      } else {
        this.visible = true
      }
    },
    onClose() {
      this.visible = false
    },
    login() {
      if (!this.account || !this.pwd) {
        alert('must input all need')
        return false
      } else {
        this.axios.post('/api/login', { account: this.account, pwd: this.pwd })
          .then(res => {
            const result = res.data
            if (result[0].isLogin) {
              alert('login successful')
              this.$store.commit('setLogin', { isLogin: result[0].isLogin, userName: result[0].userName })
            } else {
              alert('error for login')
            }
          })
      }
    },
    logout() {
      this.$store.state.isLogin = false
      this.$store.state.users = '你还未登录o'
      this.$store.commit('setLogout')
    },
    onRefresh() {
      this.axios.post('/api/findLevelsAndMoney', { account: 'mo' })
        .then(res => {
          const result = res.data
          if (result[0]) {
            this.levels = result[0].levels
            this.money = result[0].money
            this.notices = result[0].notices
          }
        })
    }
  },
  watch: {
    // 路由变更后执行获取新的背景高度
    '$route.query': function (oldVal, newVal) {
      if (newVal) {
        this.$nextTick(function() {
          this.calculateHeight()
        });
      }
    }
  }
}
</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
