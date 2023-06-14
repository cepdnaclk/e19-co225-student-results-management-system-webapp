import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/login",
    name: "login",
    component: () =>
      import(/* webpackChunkName: "login" */ "../views/LoginView.vue"),
  },
  {
    path: "/firstlogin",
    name: "firstlogin",
    component: () =>
      import(/* webpackChunkName: "firstlogin" */ "../views/FirstLoginView.vue"),
  },
  {
    path: "/reset",
    name: "reset",
    component: () =>
      import(/* webpackChunkName: "reset" */ "../views/ResetView.vue"),
  },
  {
    path: "/temp",
    name: "temp",
    component: () =>
      import(/* webpackChunkName: "temp" */ "../views/TempPasswordView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
