import { writeNotice, noticeList } from "@/api/board";

const boardStore = {
  namespaced: true,
  state: {
    notices: [],
    notice: "",
  },
  getters: {},
  mutations: {
    SET_NOTICE_LIST(state, notices) {
      state.notices = notices;
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
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default boardStore;
