import { sidoList, gugunList, dongList, houseList, interestList, recommendHouseList, houseListByFilter } from "@/api/house.js";

const houseStore = {
  namespaced: true,
  state: {
    sidos: [],
    guguns: [],
    dongs: [],
    houses: [],
    house: null,
    minDealMoney: null,
    maxDealMoney: null,
    houseType: null,
    dealType: null,
    interests: [],
    recommendHouses: [],
    filteredHouses: [],
    keyword: "",
  },
  getters: {},
  mutations: {
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
    SET_INTEREST_LIST(state, interests) {
      state.interests = interests;
    },
    SET_DETAIL_HOUSE(state, house) {
      state.house = house;
    },
    SET_RECOMMEND_HOUSE_LIST(state, recommendHouses) {
      state.recommendHouses = recommendHouses;
    },
    SET_KEYWORD_SEARCH(state, keyword) {
      state.keyword = keyword;
    },
    SET_FILTERED_HOUSE_LIST(state, filteredHouses) {
      state.filteredHouses = filteredHouses;
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
    },
    CLEAR_HOUSE_LIST(state) {
      state.house = null;
    },
    CLEAR_FILTERED_HOUSES_LIST(state) {
      state.filteredHouses = [];
    },
    CLEAR_KEYWORD_LIST(state) {
      state.keyword = null;
    },
  },
  actions: {
    getSidoList({ commit }) {
      sidoList(
        ({ data }) => {
          commit("SET_SIDO_LIST", data.regcodes);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getGugunList({ commit }, sido) {
      gugunList(
        sido,
        ({ data }) => {
          commit("SET_GUGUN_LIST", data.regcodes);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getDongList({ commit }, gugun) {
      dongList(
        gugun,
        ({ data }) => {
          commit("SET_DONG_LIST", data.regcodes);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getHouseList({ commit }, dongCode) {
      const params = { dongCode: dongCode };
      houseList(
        params,
        ({ data }) => {
          commit("SET_HOUSE_LIST", data);
          commit("SET_DETAIL_HOUSE", data[0]);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getInterestList({ commit }) {
      interestList(
        ({ data }) => {
          commit("SET_INTEREST_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getRecommendHouseList({ commit }) {
      recommendHouseList(
        ({ data }) => {
          commit("SET_RECOMMEND_HOUSE_LIST", data);
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getHouseListByFilter({ commit }) {
      houseListByFilter(
        ({ data }) => {
          commit("SET_RECOMMEND_HOUSE_LIST", data);
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default houseStore;
