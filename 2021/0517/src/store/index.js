import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    boards: [],
    board: {},
  },
  mutations: {
    setBoards(state, payload) {
      state.boards = payload;
    },
  },
  actions: {
    getBoards(context) {
      axios.get("http://localhost:9999/vue/api/board").then((resp) => {
        context.commit("setBoards", resp.data);
        console.log(resp.data);
      });
    },
  },
  modules: {},
  getters: {
    boards(state) {
      return state.boards;
    },
  },
});
