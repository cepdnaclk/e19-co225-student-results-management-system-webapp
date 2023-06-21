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
</style>

