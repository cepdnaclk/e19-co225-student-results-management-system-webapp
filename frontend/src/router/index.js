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
        meta: { index: 1, transition: "slide-left" },
      },
      {
        path: "user",
        name: "ARuser",
        component: () =>
          import(
            /* webpackChunkName: "ARuser" */ "../views/ArView/UserArView.vue"
          ),
        meta: { index: 2, transition: "slide-right" },
      },
      {
        path: "adduser",
        name: "ARadduser",
        component: () =>
          import(
            /* webpackChunkName: "ARadduser" */ "../views/ArView/AddUserArView.vue"
          ),
        meta: { index: 3, transition: "slide-right" },
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
        path: "nolog/:id",
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
      import(/* webpackChunkName: "RepMain" */ "../views/RepMain.vue"),
    children: [
      //offered courses page
      {
        path: "viewofferedcourses",
        name: "RepViewOfferedCourse",
        component: () =>
          import(
            /* webpackChunkName: "CourseManawmwnt" */ "../views/RepView/ViewOfferedCourses.vue"
          ),
        meta: { index: 2, transition: "slide-right" },
      },
      //view courses page
      {
        path: "viewcourses",
        name: "RepViewCourses",
        component: () =>
          import(
            /* webpackChunkName: "Coorwithlog" */ "../views/RepView/ViewCourses.vue"
          ),
        meta: { index: 1, transition: "slide-right" },
      },
      //add courses
      {
        path: "addcourses",
        name: "RepAddCourses",
        component: () =>
          import(
            /* webpackChunkName: "Coorwithlog" */ "../views/RepView/AddCourses.vue"
          ),
        meta: { index: 4, transition: "slide-right" },
      },
      //edit courses
      {
        path: "editcourses/:code",
        name: "RepEditCourse",
        component: () =>
          import(
            /* webpackChunkName: "Coorwithlog" */ "../views/RepView/EditCourses.vue"
          ),
        meta: { index: 4, transition: "slide-right" },
      },
      {
        path: "editcourses/",
        name: "RepEditCourseFall",
        component: () =>
          import(
            /* webpackChunkName: "Coorwithlog" */ "../views/RepView/EditCourses.vue"
          ),
        meta: { index: 4, transition: "slide-right" },
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
            /* webpackChunkName: "Coorwithlog" */ "../views/RepView/EditCourseOffering.vue"
          ),
      },
    ],
  },
  {
    path: "/student",
    name: "Student",
    component: () =>
      import(
        /* webpackChunkName: "Studenttemp" */ "../views/StudentMainView.vue"
      ),
    children: [
      {
        path: "home",
        name: "StudentHome",
        component: () =>
          import(
            /* webpackChunkName: "StudentHome" */ "../views/StudentView/HomeView.vue"
          ),
      },
      {
        path: "dashboard",
        name: "StudentDashboard",
        component: () =>
          import(
            /* webpackChunkName: "StudentDashboard" */ "../views/StudentView/DashboardView.vue"
          ),
      },
      {
        path: "targetdashboard",
        name: "StudentTargetDashboard",
        component: () =>
          import(
            /* webpackChunkName: "StudentTargetDashboard" */ "../views/StudentView/TargetDashboardView.vue"
          ),
      },
      {
        path: "courses",
        name: "StudentCourses",
        component: () =>
          import(
            /* webpackChunkName: "StudentCourses" */ "../views/StudentView/CoursesView.vue"
          ),
      },
      {
        path: "coursesinner",
        name: "StudentCoursesInner",
        component: () =>
          import(
            /* webpackChunkName: "StudentCoursesInner" */ "../views/StudentView/CoursesInnerView.vue"
          ),
      },
      {
        path: "edit",
        name: "StudentEdit",
        component: () =>
          import(
            /* webpackChunkName: "StudentEdit" */ "../views/StudentView/EditProfileView.vue"
          ),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.afterEach((to, from) => {
  const toDepth = to.meta.index;
  const fromDepth = from.meta.index;
  to.meta.transition = toDepth < fromDepth ? "slide-right" : "slide-left";
});

export default router;
