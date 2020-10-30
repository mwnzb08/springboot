<template>
    <a-form-item>
        <a-form-model-item label="User Account">
            <label slot="help" style="color: red" v-text="callNameReminder"></label>
            <a-input v-model="registryForm.callName" @focusout="nullCheck('callName')" ref="loginCallName">
                <a-icon slot="prefix" type="user" style="color:rgba(0,0,0,.25)" />
                <a-tooltip slot="suffix" title="information">
                    <a-icon :type="callNameIcon" theme="twoTone" :two-tone-color="callNameIcon === 'close-circle'?'#eb2f96':'#52c41a'"/>
                </a-tooltip>
            </a-input>
        </a-form-model-item>
        <a-form-model-item label="Password" >
            <label slot="help" style="color: red" v-text="passwordReminder"></label>
            <a-input v-model="registryForm.password" type="password" @focusout="nullCheck('password')">
                <a-icon slot="prefix" type="lock" style="color:rgba(0,0,0,.25)" />
                <a-tooltip slot="suffix" title="information">
                    <a-icon :type="passwordIcon" theme="twoTone" :two-tone-color="passwordIcon === 'close-circle'?'#eb2f96':'#52c41a'"/>
                </a-tooltip>
            </a-input>
        </a-form-model-item>
        <a-form-model-item label="Valid Check">
            <label slot="help" style="color: red" v-text="validReminder"></label>
            <a-input v-model="registryForm.validCheck" type="password" style="width:80%">
            </a-input>
            <label @click="getRandString()" style="text-align: center; margin-left: 4%;border:1px solid #f00;">{{randString}}</label>
        </a-form-model-item>
        <a-form-model-item style="text-align: center">
            <a-button  @click="onLogin">Login</a-button>
            <div>
                <a @click="iNeedRegistry">没有账号点我注册！</a>
            </div>
        </a-form-model-item>
    </a-form-item>
</template>

<script>
export default {
  name: 'Registry',
  data() {
    return {
      callNameReminder: '',
      passwordReminder: '',
      validReminder: '',
      registryForm: {
        callName: '',
        password: '',
        validCheck: ''
      },
      randString: null,
      callNameIcon: '',
      passwordIcon: '',
      callNameLoading: false,
      passwordLoading: false
    }
  },
  methods: {
    afterRegistry() {
      this.registryForm.validCheck = ''
      this.registryForm.callName = ''
      this.registryForm.password = ''
      this.callNameIcon = ''
      this.passwordIcon = ''
    },
    onRegistryCheck() {
      if (this.nullCheck('callName') || this.nullCheck('password')) {
        window.g.showAlert('Waring', 'please fix error then summit', [''])
        return false
      }
      if (this.randString !== parseInt(this.registryForm.validCheck)) {
        window.g.showAlert('Error', window.g.message['appMsg.E005'], [])
        this.registryForm.password = ''
        this.registryForm.validCheck = ''
        return false
      }
      return true
    },
    onLogin() {
      if (!this.onRegistryCheck()) {
        this.getRandString()
        return
      }
      this.axios.post('api/sys/login', {
        callName: this.registryForm.callName,
        password: this.registryForm.password
      })
        .then(res => {
          const data = res.data
          alert(data.isLogin)
          if (data.isLogin) {
            this.$store.commit('setLogin', { isLogin: data.isLogin, users: data.users })
            this.afterRegistry()
            this.$emit('loginShowLoginBox', false)
          } else {
            window.g.showAlert('Error', window.g.message['appMsg.E006'], [])
          }
        }).catch(reason => {
          window.g.showAlert('Error', window.g.message['appMsg.E500'], [])
        }
        )
      this.getRandString()
    },
    getRandString() {
      this.randString = Math.floor(Math.random() * 10000 + 1)
      if (this.randString < 1000) {
        this.getRandString()
      }
    },
    nullCheck(field) {
      var result = false
      if (field === 'callName') {
        if (window.g.checkNull(this.registryForm.callName)) {
          this.callNameIcon = 'close-circle'
          this.callNameReminder = window.g.showMessage(window.g.message['appMsg.E001'], ['User Account '])
          result = true
        } else {
          this.callNameIcon = ''
          this.callNameReminder = ''
        }
      } else if (field === 'password') {
        if (window.g.checkNull(this.registryForm.password)) {
          this.passwordIcon = 'close-circle'
          this.passwordReminder = window.g.showMessage(window.g.message['appMsg.E001'], ['Password'])
          result = true
        } else {
          this.passwordIcon = ''
          this.passwordReminder = ''
        }
      }
      return result
    },
    callNameFocus() {
      this.$nextTick(() => {
        this.$refs.loginCallName.focus()
      })
    },
    iNeedRegistry() {
      this.$emit('loginShowLoginBox', false)
      this.$emit('registryShowRegistryBox', true)
    }
  },
  mounted() {
    this.getRandString()
    this.$nextTick(() => {
      this.$refs.loginCallName.focus()
    })
  }
}
</script>

<style scoped>

</style>
