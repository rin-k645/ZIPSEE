<template>
  <div class="flex justify-center">
    <div class="grid grid-rows-[47px_153px] grid-cols-[168px_192px]">
      <div class="relative flex items-center col-span-2 font-bold">
        {{ houseItem.houseDeal.houseInfo.houseName }}
        <div v-if="like" class="absolute top-7 right-5" @click="onClickLike">
          <font-awesome-icon
            icon="fa-solid fa-heart"
            class="text-red-500 cursor-pointer w-30 h-30" />
        </div>
        <div v-else class="absolute top-7 right-5" @click="onClickLike">
          <font-awesome-icon
            icon="fa-regular fa-heart"
            class="text-red-500 cursor-pointer w-30 h-30" />
        </div>
      </div>
      <div class="grid justify-end">
        <div class="bg-gray-100 w-168 h-130">
          <!-- <img :src="houseItem.houseDeal.houseInfo.img" /> -->
        </div>
      </div>
      <div class="pt-10 pl-15">
        <div class="pb-10 font-bold text-18">
          {{ houseItem.houseDeal.dealType }}
          {{ houseItem.houseDeal.deposit | changeMoneyUnit }} /
          {{ houseItem.houseDeal.price | changeMoneyUnit }}
        </div>
        <div>
          {{ houseItem.houseDeal.area }}m² {{ houseItem.houseDeal.floor }}층
        </div>
        <button class="mt-20 bg-yellow-400 h-38 w-100">
          <router-link :to="{ name: 'housedetail' }">보러가기</router-link>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const userStore = "userStore";
export default {
  props: {
    houseItem: Object,
  },
  data() {
    return {
      like: true,
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapActions(userStore, [
      "userLikeHouse",
      "userUnLikeHouse",
      "getUserInfo",
    ]),
    onClickLike() {
      if (!this.isLogin) alert("로그인이 필요합니다!");
      else {
        if (this.like) {
          this.userUnLikeHouse(this.houseItem.dealId);
          this.like = false;
        } else {
          this.userLikeHouse({
            userId: this.userInfo.userId,
            dealId: this.houseItem.dealId,
          });
          this.like = true;
        }
      }
    },
  },
  filters: {
    changeMoneyUnit(money) {
      return money / 10000;
    },
  },
};
</script>

<style></style>
