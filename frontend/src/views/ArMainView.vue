<template>
    <div class="ar-main">
        <comp-navbar-vue>
            <li><router-link class="nav-item nav-link" to="/ar/home">Home</router-link></li>
            <li><router-link class="nav-item nav-link" to="/ar/user">View Users</router-link></li>
            <li><router-link class="nav-item nav-link" to="/ar/adduser">User Registration</router-link></li>
            <li><button @click="toggleLogout" class="nav-item nav-link">Log Out</button></li>
        </comp-navbar-vue>
        <router-view v-slot="{ Component, route }">
            <transition :name="route.meta.transition" mode="out-in">
                <component :is="Component" />
            </transition>
        </router-view>
        <comp-footer-vue />
    </div>
</template>

<script setup>
import { useStore } from 'vuex';
import compFooterVue from '../components/compFooter.vue';
import compNavbarVue from '../components/compNavbar.vue';

const store = useStore()
const toggleLogout = () => {
    store.state.showLogout = true
}
</script>

<style scoped>
.ar-main {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
}
</style>