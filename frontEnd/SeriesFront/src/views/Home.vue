<template>
  <div class="home">
  </div>
</template>

<script>
// @ is an alias to /src
import SideBar from '@/components/SideBar.vue'

export default {
    name: 'home',
    components: {
        SideBar,
    },
}
</script>

<style scoped>
.home {
  background: url('~@/assets/Fondo series.png');
  background-size: contain, cover;

  width: 100%;
  height: 100vh;
}
</style>