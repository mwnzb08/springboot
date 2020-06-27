<template>
    <div>
        Account：<input v-model="account"/>
        <br>
        password：<input v-model="pwd"/>
        <br>
        <button @click="registry">Login</button>
    </div>
</template>

<script>
export default {
  name: 'login',
  data() {
    return {
      account: null,
      pwd: null
    }
  },
  methods: {
    login () {
    }
  }
}
</script>

<style scoped>

</style>
