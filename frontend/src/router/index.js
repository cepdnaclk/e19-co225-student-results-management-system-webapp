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
      import(
        /* webpackChunkName: "firstlogin" */ "../views/FirstLoginView.vue"
      ),
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
    path: "/ar",
    name: "ar",
    component: () =>
      import(/* webpackChunkName: "temp" */ "../views/ArMainView.vue"),
    children: [
      {
        path: "home",
        name: "ARhome",
        component: () =>
          import(
            /* webpackChunkName: "ARhome" */ "../views/ArView/HomeArView.vue"
          ),
      },
      {
        path: "adduser",
        name: "ARadduser",
        component: () =>
          import(
            /* webpackChunkName: "ARadduser" */ "../views/ArView/AddUserArView.vue"
          ),
      },
      {
        path: "user",
        name: "ARuser",
        component: () =>
          import(
            /* webpackChunkName: "ARuser" */ "../views/ArView/UserArView.vue"
          ),
      },
      {
        path: "logout",
        name: "ARlogout",
        component: () =>
          import(
            /* webpackChunkName: "ARlogout" */ "../views/ArView/LogoutArView.vue"
          ),
      },
    ],
  },
  {
    path: "/coor",
    name: "coor",
    component: () =>
      import(/* webpackChunkName: "temp" */ "../views/CoorMainView.vue"),
    children: [
      {
        path: "log",
        name: "Coorwithlog",
        component: () =>
          import(
            /* webpackChunkName: "Coorwithlog" */ "../views/CoordinatorView/WithLoginView.vue"
          ),
      },
      {
        path: "nolog",
        name: "Coorwithoutlog",
        component: () =>
          import(
            /* webpackChunkName: "Coorwithoutlog" */ "../views/CoordinatorView/WithoutLoginView.vue"
          ),
          
      }, 
    ],
  },
  {
    path: "/rep",
    name: "Representative",
    component: () =>
      import(
        /* webpackChunkName: "RepMain" */ "../views/RepMain.vue"
      ),
      children: [
        //offered courses page
        {
          path: "viewofferedcourses",
          name: "RepViewOfferedCourse",
          component: () =>
            import(
              /* webpackChunkName: "CourseManawmwnt" */ "../views/RepView/ViewOfferedCourses.vue"
            ),
        },
        //view courses page
        {
          path: "viewcourses",
          name: "RepViewCourses",
          component: () =>
            import(
              /* webpackChunkName: "Coorwithlog" */ "../views/RepView/ViewCourses.vue"
            ),
        },
        //add courses
        {
          path: "addcourses",
          name: "RepAddCourses",
          component: () =>
            import(
              /* webpackChunkName: "Coorwithlog" */ "../views/RepView/AddEditCourses.vue"
            ),
        },
        //edit courses
        {
          path: "editcourses",
          name: "RepEditCourse",
          component: () =>
            import(
              /* webpackChunkName: "Coorwithlog" */ "../views/RepView/AddEditCourses.vue"
            ),
        },
        //course inner page
        {
          path: "offeredcoursesinner",
          name: "RepOfferedCoursesInner",
          component: () =>
            import(
              /* webpackChunkName: "Coorwithlog" */ "../views/RepView/OfferedCourseInner.vue"
            ),
        },
        // offer courses
        {
          path: "courseoffering",
          name: "RepCourseOfferings",
          component: () =>
            import(
              /* webpackChunkName: "Coorwithlog" */ "../views/RepView/CourseOffering.vue"
            ),
        },
        //edit offered course
        {
          path: "editcourseoffering",
          name: "RepEditCourseOffered",
          component: () =>
            import(
              /* webpackChunkName: "Coorwithlog" */ "../views/RepView/CourseOffering.vue"
            ),
        }
      ]

  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
