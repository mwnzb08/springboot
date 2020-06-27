<template>
    <div>
        <label class="mainTitle">Coffee House</label>
        <grid-table
        :column-data="columnData"
        :columns="2"
        :is-show-add="true"
        >
        </grid-table>
    </div>
</template>

<script>
import GridTable from '../common/gridTable'
export default {
  name: 'coffeeIndex',
  components: { GridTable },
  data() {
    return {
      columnData: [
        { name: 'tab1', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab2', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab3', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab5', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab6', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab7', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab8', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab9', value: 2, imgUrl: require('../../assets/coffee.jpg') },
        { name: 'tab10', value: 2, imgUrl: require('../../assets/coffee.jpg') }
      ]
    }
  }
}
</script>

<style scoped>

</style>
