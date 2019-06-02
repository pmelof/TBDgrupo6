import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import locale from 'element-ui/lib/locale/lang/es';
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false
Vue.use(ElementUI, {
  locale
});

new Vue({
  router,
  store,
  el: '#app',
  render: function (h) {
    return h(App)
  }
}).$mount('#app')