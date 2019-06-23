import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/percepcionSerie',
      name: 'percepcion serie',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: function () {
        return import( /* webpackChunkName: "about" */ './views/PercepcionSerie.vue')
      },
    },
    {
      path: '/popularidadActor',
      name: 'popularidad actor',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: function () {
        return import( /* webpackChunkName: "about" */ './views/PopularidadActor.vue')
      },
    },
    {
      path: '/popularidadPersonaje',
      name: 'popularidad personaje',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: function () {
        return import( /* webpackChunkName: "about" */ './views/PopularidadPersonaje.vue')
      },
    },
    {
      path: '/pesoUsuario',
      name: 'peso usuario',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: function () {
        return import( /* webpackChunkName: "about" */ './views/PesoUsuario.vue')
      },
    }, {
      path: '/tweetsSerie',
      name: 'tweets serie',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: function () {
        return import( /* webpackChunkName: "about" */ './views/TweetsSerie.vue')
      },
    }, {
      path: '/usuariosInfluyentes',
      name: 'usuarios influyentes',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: function () {
        return import( /* webpackChunkName: "about" */ './views/UsuariosInfluyentes.vue')
      },
    },
  ]
})