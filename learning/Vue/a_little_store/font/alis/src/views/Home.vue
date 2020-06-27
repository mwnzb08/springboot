<template>
  <div>
    <div class="home">
      <h2>Welcome to A Little Store</h2>
      <main-menu></main-menu>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import mainMenu from '../components/main'
export default {
  components: {
    mainMenu
  }
};
</script>
