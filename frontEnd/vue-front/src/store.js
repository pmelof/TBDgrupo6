import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    actores:[],
    firstName: '',
    lastName: '',
    axios: ''
  },
  mutations: {
    llenarActores(state, actores) {
      state.actores = actores
    }

  },
  actions: {
    obtenerActores: async function ({commit}) {
      const data = await fetch('http://localhost:8081/actors');
      const actores = await data.json();
      commit('llenarActores',actores)
    }

  }
})
