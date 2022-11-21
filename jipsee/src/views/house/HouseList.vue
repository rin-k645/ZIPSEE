<template>
  <div class="w-full h-full">
    <div class="w-full h-full grid grid-cols-[auto_396px] grid-rows-[56px_auto] gap-y-17">
      <div class="flex items-end justify-between">
        <div>
          <select
            v-model="sidoCode"
            @change="gugunList"
            class="text-yellow-400 border-yellow-400 border-solid cursor-pointer w-180 h-46 ml-17 mr-36 rounded-5 hover:brightness-90 focus:ring-white focus:border-yellow-400"
          >
            <option v-for="(sido, index) in sidos" :key="index" :value="sido.value">
              {{ sido.text }}
            </option>
          </select>
          <select
            v-model="gugunCode"
            @change="dongList"
            class="text-yellow-400 border-yellow-400 border-solid cursor-pointer w-180 h-46 mr-36 rounded-5 hover:brightness-90 focus:ring-white focus:border-yellow-400"
          >
            <option v-for="(gugun, index) in guguns" :key="index" :value="gugun.value">
              {{ gugun.text | gugunFormat }}
            </option>
          </select>
          <select
            v-model="dongCode"
            class="text-yellow-400 border-yellow-400 border-solid cursor-pointer w-180 h-46 mr-36 rounded-5 hover:brightness-90 focus:ring-white focus:border-yellow-400"
          >
            <option v-for="(dong, index) in dongs" :key="index" :value="dong.value">
              {{ dong.text | dongFormat }}
            </option>
          </select>
          <button class="bg-yellow-400 border-yellow-400 w-150 h-46 rounded-5 hover:brightness-90" @click="searchHouse">
            검색하기
          </button>
        </div>
        <button
          class="text-yellow-400 bg-white border-yellow-400 border-solid w-120 h-46 rounded-5 border-1 hover:brightness-90"
          @click="ChangeViewModal"
        >
          필터
        </button>
      </div>
      <div></div>

      <house-map></house-map>

      <div
        v-if="houses && houses.length != 0"
        class="flex flex-col overflow-scroll border-t-2 border-gray-100 scrollbar-thin scrollbar-thumb-yellow-400"
      >
        <house-list-item
          v-for="(house, index) in houses"
          :key="index"
          :houseItem="house"
          @click.native="viewHouseLocation(house)"
          class="border-gray-200 cursor-pointer w-396 h-200 border-b-1"
        >
        </house-list-item>
      </div>
      <div v-else class="flex flex-col items-center justify-center"></div>
    </div>
    <house-filter-modal v-if="!viewModal" class="absolute z-10 right-[420px] top-[150px]"></house-filter-modal>
  </div>
</template>

<script>
import HouseListItem from "@/views/house/HouseListItem";
import HouseMap from "@/views/house/HouseMap";
import { mapState, mapMutations, mapActions } from "vuex";
import HouseFilterModal from "@/views/house/HouseFilterModal";
const houseStore = "houseStore";

export default {
  name: "HouseList",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      viewModal: false,
    };
  },
  components: {
    HouseListItem,
    HouseMap,
    HouseFilterModal,
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.CLEAR_HOUSES_LIST();
    this.getSidoList();
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs", "houses", "house"]),
  },
  methods: {
    ...mapActions(houseStore, ["getSidoList", "getGugunList", "getDongList", "getHouseList"]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_HOUSES_LIST",
      "SET_DETAIL_HOUSE",
    ]),
    gugunList() {
      this.CLEAR_GUGUN_LIST();
      if (this.sidoCode) this.getGugunList(this.sidoCode.slice(0, 2));
    },
    dongList() {
      this.CLEAR_DONG_LIST();
      if (this.gugunCode) this.getDongList(this.gugunCode.slice(0, 4));
    },
    searchHouse() {
      this.CLEAR_HOUSES_LIST();
      if (this.dongCode) this.getHouseList(this.dongCode);
    },
    ChangeViewModal() {
      this.viewModal = !this.viewModal;
    },
    viewHouseLocation(house) {
      this.SET_DETAIL_HOUSE(house);
      console.log(house);
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
