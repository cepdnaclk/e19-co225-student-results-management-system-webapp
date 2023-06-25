import { createStore } from "vuex";

export default createStore({
  state: {
    showLogout: false,
    sucList: [],
    errList: [],
  },
  getters: {},
  mutations: {
    addSuccess(state, msg) {
      state.sucList.push(msg);
    },
    removeSuccess(state) {
      state.sucList.splice(0, 1);
    },
  },
  actions: {},
  modules: {},
});
