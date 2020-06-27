<template>
    <div>
        <template v-for="item in MenuColumn">
            <div :key="item.name">
                <img class="mainImage" :src="item.imgUrl" @click="jumpTo(item.name)">
                <br>{{item.name}}
            </div>
        </template>
    </div>
</template>

<script>
export default {
  name: 'main',
  data: function() {
    return {
      MenuColumn: [
        { name: 'coffee', imgUrl: require('../assets/coffee.jpg') },
        { name: 'Restaurant', imgUrl: require('../assets/food.jpg') },
        { name: 'Supermarket', imgUrl: require('../assets/supermarket.jpg') }
      ]
    };
  },
  methods: {
    // 跳转，写死
    jumpTo (key) {
      this.$router.push({ path: '/' + key })
    }
  }
}
</script>

<style scoped>

</style>
