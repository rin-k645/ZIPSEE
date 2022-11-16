import Vue from "vue";
import Vuex from "vuex";
import http from "@/api/http";
import axios from "axios";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    sidos: [],
    guguns: [],
    dongs: [],
    houses: [],
    house: [],
    notices: [],
    notice: "",
  },
  getters: {},
  mutations: {
    /////////////////////////////// House start /////////////////////////////////////
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.code, text: sido.name });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.code, text: gugun.name });
      });
    },
    SET_DONG_LIST(state, dongs) {
      dongs.forEach((dong) => {
        state.dongs.push({ value: dong.code, text: dong.name });
      });
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
    },
    SET_DETAIL_HOUSE(state, house) {
      // console.log("Mutations", house);
      state.house = house;
    },
    SET_NOTICE_LIST(state, notices) {
      state.notices = notices;
    },
    SET_NEW_NOTICE(state, notice) {
      state.notice = notice;
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "시/도" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "구/군" }];
    },
    CLEAR_DONG_LIST(state) {
      state.dongs = [{ value: null, text: "동" }];
    },
    CLEAR_HOUSES_LIST(state) {
      state.houses = [];
      state.house = null;
    },

    /////////////////////////////// House end /////////////////////////////////////
  },
  actions: {
    getSidoList({ commit }) {
      const url = `https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000`;
      axios
        .get(url)
        .then(({ data }) => {
          console.log(data);
          commit("SET_SIDO_LIST", data.regcodes);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getGugunList({ commit }, sido) {
      console.log(sido);
      const url = `https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=${sido}*000000&is_ignore_zero=true`;
      console.log(url);
      axios
        .get(url)
        .then(({ data }) => {
          console.log(data);
          commit("SET_GUGUN_LIST", data.regcodes);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getDongList({ commit }, gugun) {
      const url = `https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=${gugun}*&is_ignore_zero=true`;
      axios
        .get(url)
        .then(({ data }) => {
          console.log(data);
          commit("SET_DONG_LIST", data.regcodes);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getHouseList({ commit }, dongCode) {
      const params = { dongCode: dongCode };
      http
        .get(`/deal`, { params })
        .then(({ data }) => {
          console.log(commit, data);
          commit("SET_HOUSE_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getNoticeList({ commit }) {
      http
        .get(`/board/notice`)
        .then(({ data }) => {
          console.log(data);
          commit("SET_NOTICE_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    writeNotice(context, notice) {
      console.log("notice", notice);
      http
        .post(`/board/notice`, {
          userId: "admin",
          title: "공지사항",
          content: notice,
        })
        .then(({ data }) => {
          console.log(notice);
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
        })
        .catch((error) => {
          console.log(notice);
          console.log(error);
        });
    },
  },
  modules: {},
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
});
