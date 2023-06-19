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
      import(/* webpackChunkName: "reset" */ "../views/ResetPasswordView.vue"),
  },
  {
    path: "/temp",
    name: "temp",
    component: () =>
      import(/* webpackChunkName: "temp" */ "../views/TempPasswordView.vue"),
  },
  {
    path: "/home_ar",
    name: "home_ar",
    component: () =>
      import(/* webpackChunkName: "home_ar" */ "../views/HomeArView.vue"),
  },
  {
    path: "/adduser_ar",
    name: "adduser_ar",
    component: () =>
      import(/* webpackChunkName: "adduser_ar" */ "../views/AddUserArView.vue"),
  },
  {
    path: "/user_ar",
    name: "user_ar",
    component: () =>
      import(/* webpackChunkName: "user_ar" */ "../views/UserArView.vue"),
  },
  {
    path: "/logout_ar",
    name: "logout_ar",
    component: () =>
      import(/* webpackChunkName: "logout_ar" */ "../views/LogoutArView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
