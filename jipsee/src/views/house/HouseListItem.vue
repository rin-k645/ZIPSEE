<template>
  <div class="flex justify-center">
    <div class="grid grid-rows-[47px_153px] grid-cols-[168px_192px]">
      <div class="relative flex items-center col-span-2 font-bold">
        {{ houseOneItem.houseInfo.houseName }}
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
import { mapState, mapActions } from "vuex";
const houseStore = "houseStore";
const userStore = "userStore";
export default {
  name: "HouseListItem",
  props: {
    houseItem: Object,
  },
  data() {
    return {
      houseOneItem: null,
      like: false,
    };
  },
  created() {
    if (this.houseItem) this.houseOneItem = this.houseItem;
    else this.houseOneItem = this.house;

    let isLikeHouse = false;
    if (this.userInfo.likeList) {
      this.userInfo.likeList.forEach((house) => {
        if (house.dealId == this.house.dealId) {
          isLikeHouse = true;
          return false;
        }
      });
    }
    console.log(isLikeHouse);
    if (isLikeHouse) this.like = true;
    else this.like = false;
  },
  computed: {
    ...mapState(houseStore, ["house"]),
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
          this.userUnLikeHouse(this.house.dealId);
          this.like = false;
        } else {
          this.userLikeHouse({
            userId: this.userInfo.userId,
            dealId: this.house.dealId,
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
