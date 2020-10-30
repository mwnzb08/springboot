<template>
    <a-form-item>
        <a-form-model-item label="User Account">
            <label slot="help" style="color: red" v-text="callNameReminder"></label>
            <a-input v-model="registryForm.callName" @focusout="callNameNullCheck" ref="registryCallName">
                <a-icon slot="prefix" type="user" style="color:rgba(0,0,0,.25)" />
                <a-tooltip slot="suffix" title="information">
                    <a-icon v-if="callNameLoading" type="loading" style="color: rgba(0,0,0,.45)" />
                    <a-icon v-else :type="callNameIcon" theme="twoTone" :two-tone-color="callNameIcon === 'close-circle'?'#eb2f96':'#52c41a'"/>
                </a-tooltip>
            </a-input>
        </a-form-model-item>
        <a-form-model-item label="Password" >
            <label slot="help" style="color: red" v-text="passwordReminder"></label>
            <a-input v-model="registryForm.password" type="password" @focusout="passwordCheck">
                <a-icon slot="prefix" type="lock" style="color:rgba(0,0,0,.25)" />
                <a-tooltip slot="suffix" title="information">
                    <a-icon v-if="passwordLoading" type="loading" style="color: rgba(0,0,0,.45)" />
                    <a-icon v-else :type="passwordIcon" theme="twoTone" :two-tone-color="passwordIcon === 'close-circle'?'#eb2f96':'#52c41a'"/>
                </a-tooltip>
            </a-input>
        </a-form-model-item>
        <a-form-model-item label="Password Check" >
            <label slot="help" style="color: red" v-text="passwordCheckReminder"></label>
            <a-input v-model="registryForm.passwordCheck" type="password" @focusout="passwordCheckCheck" >
                <a-icon slot="prefix" type="lock" style="color:rgba(0,0,0,.25)"  />
                <a-tooltip slot="suffix" title="information">
                    <a-icon v-if="passwordCheckLoading" type="loading" style="color: rgba(0,0,0,.45)"/>
                    <a-icon v-else :type="passwordCheckIcon" theme="twoTone" :two-tone-color="passwordCheckIcon === 'close-circle'?'#eb2f96':'#52c41a'"/>
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
            <a-button  @click="onRegistry">Registry</a-button>
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
      passwordCheckReminder: '',
      validReminder: '',
      registryForm: {
        callName: '',
        password: '',
        passwordCheck: '',
        validCheck: ''
      },
      randString: null,
      callNameIcon: '',
      passwordIcon: '',
      passwordCheckIcon: '',
      callNameLoading: false,
      passwordLoading: false,
      passwordCheckLoading: false
    }
  },
  methods: {
    afterRegistry() {
      this.registryForm.validCheck = ''
      this.registryForm.callName = ''
      this.registryForm.password = ''
      this.registryForm.passwordCheck = ''
      this.callNameIcon = ''
      this.passwordCheckIcon = ''
      this.passwordIcon = ''
      this.callNameLoading = false
      this.passwordLoading = false
      this.passwordCheckLoading = false
    },
    onRegistryCheck() {
      if (!this.passwordCheck() && !this.passwordCheckCheck()) {
        window.g.showAlert('Waring', 'please fix error then summit', [''])
        return false
      }
      if (this.randString !== parseInt(this.registryForm.validCheck)) {
        window.g.showAlert('Error', window.g.message['appMsg.E005'], [])
        this.registryForm.validCheck = ''
        return false
      }
      return true
    },
    onRegistry() {
      if (!this.onRegistryCheck()) {
        this.getRandString()
      } else {
        this.callNameNullCheck().then(res => {
          if (res) {
            this.axios.post('api/sys/registry', {
              callName: this.registryForm.callName,
              password: this.registryForm.password
            })
              .then(res => {
                alert(JSON.stringify(res.data))
                this.afterRegistry()
                this.$emit('registryShowRegistryBox', false)
              })
          } else {
            window.g.showAlert('Waring', 'please fix error then summit', [''])
          }
          this.getRandString()
        })
      }
    },
    getRandString() {
      this.randString = Math.floor(Math.random() * 10000 + 1)
      if (this.randString < 1000) {
        this.getRandString()
      }
    },
    callNameCheck() {
      return new Promise(resolve => {
        this.axios.post('api/sys/callNameCheck', { callName: this.registryForm.callName })
          .then(res => {
            const data = res.data
            if (data.isSuccessful === 'true') {
              this.callNameIcon = 'check-circle'
              this.callNameReminder = ''
              resolve(true)
            } else {
              this.callNameIcon = 'close-circle'
              this.callNameReminder = window.g.showMessage(window.g.message['appMsg.E002'], ['User Account '])
              resolve(false)
            }
          })
      })
    },
    callNameNullCheck() {
      return new Promise(resolve => {
        this.passwordLoading = true
        if (!window.g.checkNull(this.registryForm.callName)) {
          if (!/^[a-z0-9]{6,30}$/.test(this.registryForm.callName)) {
            this.callNameIcon = 'close-circle'
            this.callNameReminder = window.g.showMessage(window.g.message['appMsg.E003'], ['User Account'])
            resolve(false)
          } else {
            this.callNameCheck().then(res => {
              if (res) {
                resolve(true)
              } else {
                resolve(false)
              }
            })
          }
        } else {
          this.callNameIcon = 'close-circle'
          this.callNameReminder = window.g.showMessage(window.g.message['appMsg.E001'], ['User Account'])
          resolve(false)
        }
        this.passwordLoading = false
      })
    },
    passwordCheck() {
      var result = false
      this.passwordLoading = true
      if (!window.g.checkNull(this.registryForm.password)) {
        if (!/^[a-z0-9]{6,16}$/.test(this.registryForm.password)) {
          this.passwordReminder = window.g.showMessage(window.g.message['appMsg.E003'], ['Password'])
          this.passwordIcon = 'close-circle'
        } else {
          this.passwordIcon = 'check-circle'
          this.passwordReminder = ''
          result = true
        }
      } else {
        this.passwordReminder = window.g.showMessage(window.g.message['appMsg.E001'], ['Password'])
        this.passwordIcon = 'close-circle'
      }
      this.passwordLoading = false
      return result
    },
    passwordCheckCheck() {
      var result = false
      this.passwordCheckLoading = true
      if (!window.g.checkNull(this.registryForm.passwordCheck)) {
        if (this.registryForm.password !== this.registryForm.passwordCheck) {
          this.passwordCheckReminder = window.g.showMessage(window.g.message['appMsg.E004'], ['Password Check'])
          this.passwordCheckIcon = 'close-circle'
        } else {
          this.passwordCheckIcon = 'check-circle'
          this.passwordCheckReminder = ''
          result = true
        }
      } else {
        this.passwordCheckReminder = window.g.showMessage(window.g.message['appMsg.E001'], ['Password Check'])
        this.passwordCheckIcon = 'close-circle'
      }
      this.passwordCheckLoading = false
      return result
    },
    callNameFocus() {
      this.$nextTick(() => {
        this.$refs.registryCallName.focus()
      })
    }
  },
  mounted() {
    this.getRandString()
    this.$nextTick(() => {
      this.$refs.registryCallName.focus()
    })
  }
}
</script>

<style scoped>

</style>
