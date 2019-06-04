import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import locale from 'element-ui/lib/locale/lang/es';
import App from './App.vue'
import router from './router'
import store from './store'
import HighchartsVue from 'highcharts-vue'

Vue.config.productionTip = false
Vue.use(ElementUI, {
  locale
});
Vue.use(HighchartsVue)

new Vue({
  router,
  store,
  HighchartsVue,
  el: '#app',
  render: function (h) {
    return h(App)
  }
}).$mount('#app')