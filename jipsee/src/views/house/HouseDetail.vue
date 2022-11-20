<template>
  <div class="flex flex-col items-center">
    <div class="relative bg-yellow-200 w-1000 h-500">
      <button
        class="absolute h-40 font-bold bg-yellow-400 bottom-10 left-10 w-70">
        <a href="http://localhost:8077/1/index.html">360</a>
      </button>
    </div>
    <div class="flex flex-row w-1000 h-500 mt-100">
      <div class="relative w-400 h-500">
        <div class="absolute top-0 right-5">♥</div>
        <div class="font-bold text-18">
          {{ house.houseInfo.houseName }}
        </div>
        <div class="pb-10 font-bold text-18">
          {{ house.dealType }}
          {{ house.deposit | changeMoneyUnit }} /
          {{ house.price | changeMoneyUnit }}
        </div>
        <div class="text-16">
          {{ house.houseInfo.dongName }}
        </div>
        <div>
          {{ house.houseInfo.houseType }} {{ house.area }}m² {{ house.floor }}층
        </div>
      </div>
      <house-map class="w-600 h-500"></house-map>
    </div>
    <div class="mt-100 mb-100"></div>
  </div>
</template>

<script>
import HouseMap from "@/views/house/HouseMap";
import { mapState } from "vuex";
const houseStore = "houseStore";
export default {
  components: {
    HouseMap,
  },

  computed: {
    ...mapState(houseStore, ["house"]),
  },

  filters: {
    changeMoneyUnit(money) {
      return money / 10000;
    },
  },
};
</script>

<style></style>
