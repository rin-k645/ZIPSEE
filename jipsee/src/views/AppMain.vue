<template>
  <div>
    <img
      src="@/assets/main.jpg"
      class="object-cover object-center w-full h-500" />
    <div>
      <div class="mt-20 mb-20 ml-20 text-xl font-bold">실시간 매물 TOP 10</div>
      <!-- Slider main container -->
      <div ref="swiper" class="swiper">
        <div class="swiper-wrapper">
          <!-- Slides -->
          <div
            v-for="(houseDeal, index) in recommendHouses.popularDealList"
            :key="index"
            class="swiper-slide">
            <img src="@/assets/sample.jpg" />
          </div>
        </div>
      </div>

      <!-- 아파트 추천 리스트(동코드) -->
      <div v-for="(apartList, i) in recommendHouses.apartListBydong" :key="i">
        <div class="mt-20 mb-20 ml-20 mr-20 text-xl font-bold">
          내 꿈은 건물주님을 위한 HOT 10
        </div>
        <div :ref="`swiper${i + 2}`" class="swiper">
          <div class="swiper-wrapper">
            <!-- Slides -->
            <div
              v-for="(houseDeal, index) in apartList"
              :key="index"
              class="swiper-slide">
              <img src="@/assets/sample.jpg" />
            </div>
          </div>
        </div>
      </div>

      <!-- 원룸 추천 리스트(동코드) -->
      <div v-for="(oneRoom, i) in recommendHouses.oneRoomListByDong" :key="i">
        <div class="mt-20 mb-20 ml-20 mr-20 text-xl font-bold">
          내 꿈은 건물주님을 위한 HOT 10
        </div>
        <div
          :ref="`swiper${recommendHouses.apartListBydong.length + i + 2}`"
          class="swiper">
          <div class="swiper-wrapper">
            <!-- Slides -->
            <div
              v-for="(houseDeal, index) in oneRoom"
              :key="index"
              class="swiper-slide">
              <img src="@/assets/sample.jpg" />
            </div>
          </div>
        </div>
      </div>
    </div>
    <the-footer></the-footer>
  </div>
</template>

<script>
import Swiper, { Navigation, Pagination, Autoplay } from "swiper";
import "swiper/swiper-bundle.min.css";
import TheFooter from "@/views/TheFooter.vue";
import { mapState, mapActions } from "vuex";
const houseStore = "houseStore";

export default {
  components: { TheFooter },
  created() {
    this.getRecommendHouseList().then(() => console.log(this.recommendHouses));
  },
  mounted() {
    let user = this.recommendHouses.user;
    console.log(user);

    let apartRecommendSize = this.recommendHouses.apartListBydong.length;
    console.log(apartRecommendSize);

    let oneRoomRecommendSize = this.recommendHouses.oneRoomListByDong.length;
    console.log(oneRoomRecommendSize);

    let num = 2;

    new Swiper(this.$refs.swiper, {
      //실시간 top 10
      modules: [Navigation, Pagination, Autoplay],
      grabCursor: true,
      slidesPerView: 5.3,
      spaceBetween: 30,
    });

    for (let i = 0; i < apartRecommendSize; i++) {
      //아파트 추천 리스트(동코드)
      new Swiper(this.$refs["swiper" + num], {
        modules: [Navigation, Pagination, Autoplay],
        grabCursor: true,
        slidesPerView: 5.3,
        spaceBetween: 30,
        freeMode: true,
      });

      num++;
    }

    for (let i = 0; i < oneRoomRecommendSize; i++) {
      //원룸 추천 리스트(동코드)
      new Swiper(this.$refs["swiper" + num], {
        modules: [Navigation, Pagination, Autoplay],
        grabCursor: true,
        slidesPerView: 5.3,
        spaceBetween: 30,
        freeMode: true,
      });

      num++;
    }
  },
  computed: {
    ...mapState(houseStore, ["recommendHouses"]),
  },
  methods: {
    ...mapActions(houseStore, ["getRecommendHouseList"]),
  },
};
</script>

<style scoped>
.swiper {
  width: calc(100% - 90px);
  height: 160px;
}

.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
