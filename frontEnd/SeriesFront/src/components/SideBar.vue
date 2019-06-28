<template>
  <el-menu default-active="1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
    <div class="logoSpace">
      <router-link to="/">
        <img src="@/assets/Logo series.png" id="logo" alt="logo">
      </router-link>
    </div>
    <el-divider></el-divider>
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-data-analysis"></i>
        <span>Percepción</span>
      </template>
      <router-link to="/percepcionSerie" style="text-decoration:none">
        <el-menu-item index="1-1">Percepción de serie</el-menu-item>
      </router-link>
      <router-link to="/popularidadActor" style="text-decoration:none">
        <el-menu-item index="1-2">Popularidad de actores</el-menu-item>
      </router-link>
      <router-link to="/popularidadPersonaje" style="text-decoration:none">
        <el-menu-item index="1-2">Popularidad de personajes</el-menu-item>
      </router-link>
    </el-submenu>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-trophy-1"></i>
        <span>Tuiteros</span>
      </template>
      <router-link to="/tweetsSerie" style="text-decoration:none">
        <el-menu-item index="2-1">Tuits sobre una serie</el-menu-item>
      </router-link>
      <router-link to="/usuariosInfluyentes" style="text-decoration:none">
        <el-menu-item index="2-2">Tuiteros más influyentes por serie</el-menu-item>
      </router-link>
      <router-link to="/pesoUsuario" style="text-decoration:none">
        <el-menu-item index="3-2">Percepción según peso del tuitero</el-menu-item>
      </router-link>
    </el-submenu>
    <!-- <el-submenu index="3">
      <template slot="title">
        <i class="el-icon-map-location"></i>
        <span>Sprint 3</span>
      </template>
      <el-menu-item index="3-1">item one</el-menu-item>
      <el-menu-item index="3-2">item one</el-menu-item>
    </el-submenu> -->
  </el-menu>
</template>


<script>
export default {
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath)
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath)
        },
    },
}
</script>

<style scoped>
.el-menu-vertical-demo {
    background: url(../assets/fondoNav.svg) no-repeat center center;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    height: 100vh;
    width: 100%;
}
.el-menu-item {
    color: #5b86e5;
}

.el-submenu__title:hover * {
    color: #5b86e5;
}
.el-submenu__title * {
    font-size: 1.2em;
    color: aliceblue;
}

.logoSpace {
    height: 7vh;
    margin-bottom: 15px;
    margin-top: 15px;
}
#logo {
    height: 75px;
}
.el-divider {
    display: inline-block;
    width: 70%;
}
</style>
