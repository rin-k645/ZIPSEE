import { writeNotice, noticeList, askList, writeAsk, writeComment } from "@/api/board";
import router from "@/router";

const boardStore = {
  namespaced: true,
  state: {
    notices: [],
    notice: [],
    asks: [],
    ask: [],
    comment: [],
  },
  getters: {},
  mutations: {
    SET_NOTICE_LIST(state, notices) {
      state.notices = notices;
    },
    SET_ASK_LIST(state, asks) {
      state.asks = asks;
    },
  },
  actions: {
    getNoticeList({ commit }) {
      noticeList(
        ({ data }) => {
          console.log(data);
          commit("SET_NOTICE_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    writeNoticeAdmin(context, notice) {
      writeNotice(
        notice,
        ({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          router.push({ name: "boardnotice" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
    writeAsk(context, ask) {
      writeAsk(
        ask,
        ({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getAskList({ commit }) {
      askList(
        ({ data }) => {
          console.log(data);
          commit("SET_ASK_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    writeComment(context, comment) {
      writeComment(
        comment,
        ({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default boardStore;
