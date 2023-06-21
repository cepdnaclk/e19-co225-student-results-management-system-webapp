<template>
  <div class="app">
    <comp-logout v-if="store.state.showLogout" />
    <router-view />
  </div>
</template>

<script setup>
import compLogout from './components/compLogout.vue';
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
  transition: all 0.3s ease;
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
  transition: all 0.3s ease;
}

.slide-right-enter-from {
  transform: translateX(-100px);
  opacity: 0;
}

.slide-right-leave-to {
  transform: translateX(100px);
  opacity: 0;
}
</style>

