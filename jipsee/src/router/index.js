import Vue from "vue";
import VueRouter from "vue-router";
import AppMain from "@/views/AppMain";
import UserMain from "@/views/user/UserMain";
import UserLogin from "@/views/user/UserLogin";
import UserSignUp from "@/views/user/UserSignUp";
import UserMyPage from "@/views/user/UserMyPage";
import UserModify from "@/views/user/UserModify";
import UserLikeHouse from "@/views/user/UserLikeHouse";
import UserAsk from "@/views/user/UserAsk";
import HouseMain from "@/views/house/HouseMain";
import HouseList from "@/views/house/HouseList";
import HouseDetail from "@/views/house/HouseDetail";
import BoardMain from "@/views/board/BoardMain";
import BoardQuestion from "@/views/board/BoardQuestion";
import BoardAsk from "@/views/board/BoardAsk";
import BoardNotice from "@/views/board/BoardNotice";
import BoardNoticeDetail from "@/views/board/BoardNoticeDetail";
import BoardNoticeWrite from "@/views/board/BoardNoticeWrite";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/user",
    name: "user",
    component: UserMain,
    children: [
      {
        path: "login",
        name: "userlogin",
        component: UserLogin,
      },
      {
        path: "signup",
        name: "usersignup",
        component: UserSignUp,
      },
      {
        path: "mypage",
        name: "usermypage",
        component: UserMyPage,
        children: [
          {
            path: "modify",
            name: "usermodify",
            component: UserModify,
          },
          {
            path: "likehouse",
            name: "userlikehouse",
            component: UserLikeHouse,
          },
          {
            path: "ask",
            name: "userask",
            component: UserAsk,
          },
        ],
      },
    ],
  },
  {
    path: "/house",
    name: "house",
    component: HouseMain,
    children: [
      {
        path: "list",
        name: "houselist",
        component: HouseList,
      },
      {
        path: ":houseno",
        name: "housedetail",
        component: HouseDetail,
      },
    ],
  },
  {
    path: "/board",
    name: "board",
    component: BoardMain,
    redirect: "/board/notice",
    children: [
      {
        path: "question",
        name: "boardquestion",
        component: BoardQuestion,
      },
      {
        path: "ask",
        name: "boardask",
        component: BoardAsk,
      },
      {
        path: "notice",
        name: "boardnotice",
        component: BoardNotice,
      },
      {
        path: "notice/:noticeno",
        name: "boardnoticedetail",
        component: BoardNoticeDetail,
      },
      {
        path: "notice/write",
        name: "boardnoticewrite",
        component: BoardNoticeWrite,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
