<template>
  <div class="flex justify-center">
    <div class="grid grid-rows-[47px_153px] grid-cols-[168px_192px]">
      <div class="relative flex items-center col-span-2 font-bold">
        {{ houseOneItem.houseInfo.houseName }}
        <div class="absolute top-7 right-5">
          <font-awesome-icon icon="fa-solid fa-heart" class="text-red-500 w-30 h-30" />
        </div>
      </div>
      <div class="grid justify-end">
        <div class="bg-gray-100 w-168 h-130">
          <img :src="houseOneItem.houseInfo.img" />
        </div>
      </div>
      <div class="pt-10 pl-15">
        <div class="pb-10 font-bold text-18">
          {{ houseOneItem.dealType }}
          {{ houseOneItem.deposit | changeMoneyUnit }} /
          {{ houseOneItem.price | changeMoneyUnit }}
        </div>
        <div>{{ houseOneItem.area }}m² {{ houseOneItem.floor }}층</div>
        <button class="mt-20 bg-yellow-400 h-38 w-100">
          <router-link :to="{ name: 'housedetail' }">보러가기</router-link>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
const houseStore = "houseStore";
export default {
  name: "HouseListItem",
  props: {
    houseItem: Object,
  },
  data() {
    return {
      houseOneItem: null,
    };
  },
  created() {
    if (this.houseItem) this.houseOneItem = this.houseItem;
    else this.houseOneItem = this.house;
  },
  computed: {
    ...mapState(houseStore, ["house"]),
  },
  methods: {
    likeHouse() {},
  },
  filters: {
    changeMoneyUnit(money) {
      return money / 10000;
    },
  },
};
</script>

<style></style>
