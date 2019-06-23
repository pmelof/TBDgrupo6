<template>
  <div>
    <transition name="modal">
      <div v-if="isOpen">
        <div class="overlay" @click.self="isOpen = false;">
          <div class="modal">
            <InfoSeriesTable @isOpenChild="close" :nombreSerie="this.nombreSerie"></InfoSeriesTable>
          </div>
        </div>
      </div>
    </transition>
    <el-button type="primary" v-on:click="isOpen = !isOpen;" class="simpleButton">{{this.nombreSerie}}</el-button>
  </div>
</template>

<script>
import axios from 'axios'
import InfoSeriesTable from '@/components/InfoSeriesTable.vue'
export default {
  components: {
    InfoSeriesTable,
  },
  props: {
    nombreSerie: String
  },
  data: function() {
    return {
      isOpen: false,
    }
  },
  methods: {
    close(isOpenChild) {
      this.isOpen = isOpenChild
    }
  }
}
</script>

<style scoped>
.modal {
  width: 1000px;
  margin: 0px auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px 3px;
  transition: all 0.2s ease-in;
  font-family: Helvetica, Arial, sans-serif;
}
.fadeIn-enter {
  opacity: 0;
}

.fadeIn-leave-active {
  opacity: 0;
  transition: all 0.2s step-end;
}

.fadeIn-enter .modal,
.fadeIn-leave-active.modal {
  transform: scale(1.1);
}

.overlay {
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: #00000094;
  z-index: 999;
  transition: opacity 0.2s ease;
}

.simpleButton {
  background: #FFFFFF;
  border: none;
  color: grey;
  padding: 5px 10px;
}
</style>