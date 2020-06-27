<template>
   <div>
<!--        <div v-if="isShowCount">-->
<!--            <div style="float: left; margin-left: 105%; background: white; width: 25%">-->
<!--                <label>sssss</label>-->
<!--                <label>sssss</label>-->
<!--                <label>sssss</label>-->
<!--                <label>sssss</label>-->

<!--            </div>-->
<!--        </div>-->
        <div class="whiteBack">
            <div v-for="item in columnData" :key="item.name">
                <div class="gridTable" :style="columnsPercent">
                    <label>{{item.name}}</label>
                    <br>
                    <a-icon v-if="isShowAdd" type="close" @click="addOne"></a-icon>
                    <img class="imageHeight" :style="{ height: columnsXY[0], width: columnsXY[1] }" :src="item.imgUrl" @click="jumpTo(item.name)">
                    <a-icon v-if="isShowAdd" type="close" @click="addOne"></a-icon>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'gridTable',
  props: {
    columnData: {
      type: Array,
      default: function () {
        return []
      }
    },
    columns: {
      type: Number,
      default: 2
    },
    columnsXY: {
      type: Array,
      default: function () {
        return [175, 300]
      }
    },
    isShowAdd: {
      type: Boolean,
      default: false
    },
    isShowCount: {
      type: Boolean,
      default: true
    }
  },
  computed: {
    columnsPercent: function () {
      if (this.columns === 0) {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.columns = 2
      }
      return { width: 100 / this.columns + '%' }
    }
  },
  methods: {
    addOne() {
    },
    jumpTo() {
    }
  }
}
</script>

<style scoped>

</style>
