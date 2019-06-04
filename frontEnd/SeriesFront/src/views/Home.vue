<template>
  <div class="home">
  </div>
</template>

<script>
// @ is an alias to /src
import SideBar from '@/components/SideBar.vue'
import GraphicCard from '@/components/GraphicCard.vue'

export default {
    name: 'home',
    components: {
        SideBar,
        GraphicCard,
    },
}
</script>

<style scoped>
.home {
  background: url('~@/assets/Fondo series.png');
  background-size: contain, cover;
  width: 100%;
  height: 100vh;
  margin-left: -20px;
  margin-right: -20px;
  margin-top: -20px;
  margin-bottom: -20px;
}

</style>