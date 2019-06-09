<template>
  <div class="home">
    <img src="@/assets/Fondo series 2.png" id="fondo" alt="fondo" class="fondo">
    <h2 style="color:#2f7ed8">¡Bienvenido!</h2>
    <h4 style="color:#2f7ed8">En este sitio usted encontrará estadísticas sobre las series de televisión más relevantes del último tiempo.</h4>
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
  width: 40%;
}
</style>