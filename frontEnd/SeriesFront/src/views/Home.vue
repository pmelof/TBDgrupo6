<template>
  <div class="home">
    <img src="@/assets/FondoNew2.png" id="fondo" alt="fondo" class="fondo">
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
.fondo {
    width: 100%;
}
</style>