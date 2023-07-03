<template>
  <div class="app">
    <transition name="fade">
      <comp-logout v-if="store.state.showLogout" />
    </transition>
    <transition name="alert">
      <comp-success-alert v-if="store.state.sucList.length" :msg="store.state.sucList[0]" />
    </transition>
    <transition name="alert">
      <comp-error-alert v-if="store.state.errList.length" :msg="store.state.errList[0]" />
    </transition>
    <router-view />
  </div>
</template>

<script setup>
import compLogout from './components/compLogout.vue';
import compSuccessAlert from './components/compSuccessAlert.vue';
import CompErrorAlert from './components/compErrorAlert.vue';
import { useStore } from 'vuex';

const store = useStore()
</script>

<style>
* {
  font-family: 'Raleway', sans-serif;
}

/* CSS class for slide-left transition */
.slide-left-enter-active,
.slide-left-leave-active {
  transition: all 0.15s ease;
}

.slide-left-enter-from {
  transform: translateX(100px);
  opacity: 0;
}

.slide-left-leave-to {
  transform: translateX(-100px);
  opacity: 0;
}

/* CSS class for slide-right transition */
.slide-right-enter-active,
.slide-right-leave-active {
  transition: all 0.15s ease;
}

.slide-right-enter-from {
  transform: translateX(-100px);
  opacity: 0;
}

.slide-right-leave-to {
  transform: translateX(100px);
  opacity: 0;
}


.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

.fade-enter-active,
.fade-leave-active {
  transition: 0.2s all ease;
}

.alert-enter-from,
.alert-leave-to {
  transform: translateY(-6rem);
  opacity: 0;
}

.alert-enter-active,
.alert-leave-active {
  transition: 0.2s all ease;
}

.errmsg {
  font-size: 0.8rem !important;
  text-align: left;
  color: red;
  margin: 2px 5px;
}
</style>

