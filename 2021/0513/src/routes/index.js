import Vue from "vue";
import VueRouter from "vue-router";
import Index from "@/page/index.vue";
import Board from "@/page/board.vue";
import Member from "@/page/member.vue";
import List from "@/page/list.vue";
import Read from "@/page/read.vue";
import Write from "@/page/write.vue";
import MemberList from "@/page/memberlist.vue";

Vue.use(VueRouter);

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: "/",
            name: "Index",
            component: Index,
        },
        {
            path: "/board",
            name: "board",
            component: Board,
            // redirect: "/board/list",
            children: [
                {
                    path: "list",
                    name: "boardlist",
                    component: List,
                },
                {
                    path: "read/:no",
                    name: "read",
                    component: Read,
                },
                {
                    path: "write",
                    name: "write",
                    component: Write,
                }
            ],
        },
        {
            path: "/member",
            name: "member",
            component: Member,
            children: [
                {
                    path: "list",
                    name: "memberlist",
                    component: MemberList,
                },
                {
                    path: "read/:no",
                    name: "read",
                    component: Read,
                },
                {
                    path: "write",
                    name: "write",
                    component: Write,
                }
            ],
        }
        
    ],
});
