import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/actores',
      name: 'actores',
      component: () => import( /* webpackChunkName: "about" */ './views/Actores.vue')
    },
    {
      path: '/agregar-actor',
      name: 'agregar',
      component: () => import( /* webpackChunkName: "about" */ './views/AgregarActor.vue')
    }
  ]
})
