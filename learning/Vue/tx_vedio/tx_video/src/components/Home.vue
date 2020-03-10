<template>
  <div class="home-head">
    <div class="logo-name">
      <a-icon type="search" />
      腾讯视频<span class="logo-name-second">不负好时光</span>
    </div>
    <div class="head-center">
      <a-input-search placeholder="神之手第九集" @search="onSearch">
        <a-button slot="enterButton">
          <a-icon type="search" />
          全网搜
        </a-button>
      </a-input-search>
    </div>
    <div class="text-center" style="font-size: x-large; float: right">
      <a-icon type="property-safety" />
      <a-icon type="clock-circle" />
      <a-icon type="upload" />
      <a-icon type="share-alt" />
      <a-icon type="user" />
    </div>
    <div class="guid">
      <a-tabs defaultActiveKey="1" @change="callback" tab-position="right" :style="{height: '200px'}">
        <a-tab-pane tab="Tab 1" key="1">Content of Tab Pane 1</a-tab-pane>
        <a-tab-pane tab="Tab 2" key="2" forceRender
          >Content of Tab Pane 2</a-tab-pane
        >
        <a-tab-pane tab="Tab 3" key="3" forceRender
        >Content of Tab Pane 3</a-tab-pane>
        <a-tab-pane tab="Tab 4" key="4" forceRender
        >Content of Tab Pane 2</a-tab-pane
        >
        <a-tab-pane tab="Tab 5" key="5" forceRender
        >Content of Tab Pane 2</a-tab-pane
        >
        <a-tab-pane tab="Tab 6" key="6" forceRender
        >Content of Tab Pane 2</a-tab-pane
        >
      </a-tabs>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  methods: {
    onSearch() {
      console.log('ss');
    },
    callback() {
      console.log('ss');
    }
  }
};
</script>

<style scoped>
.home-head {
  height: 50px;
  background-color: rgba(255, 255, 255, 0.3);
}

.logo-name {
  float: left;
  margin-left: 5%;
  width: 135px;
  height: 36px;
  color: black;
  font-size: x-large;
}

.logo-name-second {
  font-size: small;
}

.head-center {
  text-align: center;
  float: left;
  margin-left: 30%;
  width: 20%;
}

.text-center {
  text-align: center;
}
  .guid {
    float: left;
  }
</style>
