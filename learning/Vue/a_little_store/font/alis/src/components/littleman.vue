<template>
    <div>
        <div id="spig" class="spig">
            <div id="message">{{littleman}}</div>
            <div id="mumu" class="mumu" @mouseover="say" @mousedown="mouseClick"></div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'littleman',
  data() {
    return {
      littleman: '加载中.......^v ^.',
      clickNum: 0
    }
  },
  methods: {
    say() {
      if (Math.floor(Math.random() * 2) % 2 === 0) {
        var msgs = ['我隐身了，你看不到我', '哼，你再摸我，我告诉主人去！', '我会隐身哦！嘿嘿！', '别动手动脚的，把手拿开！', '把手拿开我才出来！'];
        var i = Math.floor(Math.random() * msgs.length)
        if (msgs[i] === '我隐身了，你看不到我') {
          this.littleman = msgs[i]
        } else {
          this.littleman = msgs[i]
        }
      } else {
        console.log('no change')
      }
    },
    mouseClick() {
      this.clickNum = parseInt(window.sessionStorage.getItem('clickNum'))
      this.clickNum += 1
      window.sessionStorage.setItem('clickNum', this.clickNum)
      if (Math.floor(Math.random() * 2) % 2 === 0) {
        this.littleman = '点我干嘛？又没有好吃的！！'
      } else {
        this.littleman = '我记住了，你点我 ' + window.sessionStorage.getItem('clickNum') + '下了！呜呜呜'
      }
    }
  }
}

</script>

<style scoped>
    .spig {display:block;width:10%;height:20%;position:fixed;bottom: 100px;right:20px;z-index:9999;}
    #message{color :#191919;
        border: 1px solid #c4c4c4;
        background:#ddd;
        -moz-border-radius:5px;
        -webkit-border-radius:5px;
        border-radius:5px;min-height:1em;
        padding:5px;top:-45px;position:absolute;
        text-align:center;
        width:auto !important;z-index:10000;-moz-box-shadow:0 0 15px #eeeeee;-webkit-box-shadow:0 0 15px #eeeeee;border-color:#eeeeee;
        box-shadow:0 0 15px #eeeeee;outline:none;}
    .mumu{width:130px;height:170px;cursor: pointer;background:url(../assets/spig0.png) no-repeat;}
    @media (max-width:560px){
        .spig{display: none;}
    }
</style>
