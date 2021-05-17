import Vue from "vue";
import VueRouter from "vue-router";
import Index from "@/views/index.vue";
import Board from "@/views/board.vue";
import BoardList from "@/views/boardlist.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "index",
    component: Index,
  },
  {
    path: "/board",
    name: "board",
    component: Board,
  },
  {
    path: "/board/list",
    name: "boardlist",
    component: BoardList,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
