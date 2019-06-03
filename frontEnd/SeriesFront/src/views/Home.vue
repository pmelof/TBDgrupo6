<template>
  <div class="home">
    <el-container>
      <el-header>
        <h1>Bienvenido</h1>
      </el-header>
      <el-main>
        <GraphicCard/>
      </el-main>
    </el-container>
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
</style>

