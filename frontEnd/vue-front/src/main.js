import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

Vue.config.productionTip = false

Vue.use({
  install(Vue) {
    Vue.prototype.$axios = axios.create({
      baseURL: 'http://localhost:8081'
    })
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
