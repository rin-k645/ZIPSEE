<template>
  <div class="flex flex-col">
    <div>
      <select
        v-model="sidoCode"
        @change="gugunList"
        class="text-yellow-400 border-yellow-400 border-solid cursor-pointer w-180 h-46 rounded-5 hover:brightness-90 focus:ring-white focus:border-yellow-400">
        <option v-for="(sido, index) in sidos" :key="index" :value="sido.value">
          {{ sido.text }}
        </option>
      </select>
      <select
        v-model="gugunCode"
        @change="dongList"
        class="text-yellow-400 border-yellow-400 border-solid cursor-pointer w-180 h-46 rounded-5 hover:brightness-90 focus:ring-white focus:border-yellow-400">
        <option
          v-for="(gugun, index) in guguns"
          :key="index"
          :value="gugun.value">
          {{ gugun.text | gugunFormat }}
        </option>
      </select>
      <select
        v-model="dongCode"
        class="text-yellow-400 border-yellow-400 border-solid cursor-pointer w-180 h-46 rounded-5 hover:brightness-90 focus:ring-white focus:border-yellow-400">
        <option v-for="(dong, index) in dongs" :key="index" :value="dong.value">
          {{ dong.text | dongFormat }}
        </option>
      </select>
      <button
        class="text-white bg-yellow-700 w-150 h-46 rounded-5 hover:brightness-90"
        @clcik="setUserRegion">
        추가하기
      </button>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex";
const houseStore = "houseStore";

export default {
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      dongName: null,
    };
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.getSidoList();
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs", "userInfo"]),
  },
  methods: {
    ...mapActions(houseStore, ["getSidoList", "getGugunList", "getDongList"]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    gugunList() {
      this.CLEAR_GUGUN_LIST();
      if (this.sidoCode) this.getGugunList(this.sidoCode.slice(0, 2));
    },
    dongList() {
      this.CLEAR_DONG_LIST();
      if (this.gugunCode) this.getDongList(this.gugunCode.slice(0, 4));
    },
    setUserRegion() {
      this.$emit("setUserRegion", {
        dongCode: this.dongCode,
        dongName: this.dongName,
      });
    },
  },
  filters: {
    gugunFormat(gugun) {
      if (gugun === "구/군") return "구/군";
      return gugun.split(" ")[1];
    },
    dongFormat(gugun) {
      if (gugun === "동") return "동";
      return gugun.split(" ")[2];
    },
  },
};
</script>

<style></style>
