<template>
<div>
    <a v-bind:[attr]="focusFunction">123456</a>
    <div>
        <a v-on:click.once="onceChange">onceMsg</a><span>{{onceMsg}}</span>
    </div>
    <div>
        <input v-on:keyup.enter="startChange" />{{startMsg}}<span>{{stopMsg}}</span>
    </div>
</div>
</template>

<script>
export default {
  name: '后缀的作用集合',
  data () {
    return {
      attr: 'href', // 自定义：bind的值，例如focus 等等各种props的参数
      focusFunction: '',
      onceMsg: '',
      stopMsg: '',
      startMsg: 'startMsg',
      timer1: null
    }
  },
  methods: {
    onceChange () {
      this.onceMsg = 'onceMsg' + window.moment(Date.now()).format('YYYY-MM-DD')
    },
    startChange () {
      if (this.timer1 === null && this.startMsg === 'startMsg') {
        this.startMsg = 'stopMsg'
        this.timer1 = setInterval(() => {
          this.stopMsg = this.stopMsg + 1
        }, 100)
      } else {
        this.startMsg = 'startMsg'
        clearTimeout(this.timer1)
        this.timer1 = null
      }
    }
  },
  created () {
    this.focusFunction = 'login'
  }
}
</script>

<style scoped>

</style>
