<template>
  <div>
    <img src="@/assets/main.jpg" class="object-cover object-center w-full h-500" />
    <div>
      <div class="mt-20 mb-20 ml-20 text-xl font-bold">실시간 매물 TOP 10</div>
      <!-- Slider main container -->
      <div ref="swiper" class="swiper">
        <div class="swiper-wrapper">
          <!-- Slides -->
          <div v-for="index in 10" :key="index" class="swiper-slide"><img src="@/assets/sample.jpg" /></div>
        </div>
      </div>

      <div class="mt-20 mb-20 ml-20 mr-20 text-xl font-bold">내 꿈은 건물주님을 위한 HOT 10</div>
      <div ref="swiper2" class="swiper">
        <div class="swiper-wrapper">
          <!-- Slides -->
          <div v-for="index in 10" :key="index" class="swiper-slide"><img src="@/assets/sample.jpg" /></div>
        </div>
      </div>
      <div class="mt-20 mb-20 ml-20 mr-20 text-xl font-bold">내 꿈은 건물주님을 위한 HOT 10</div>
      <div ref="swiper3" class="swiper">
        <div class="swiper-wrapper">
          <!-- Slides -->
          <div v-for="index in 10" :key="index" class="swiper-slide"><img src="@/assets/sample.jpg" /></div>
        </div>
      </div>
      <div class="mt-20 mb-20 ml-20 mr-20 text-xl font-bold">내 꿈은 건물주님을 위한 HOT 10</div>
      <div ref="swiper4" class="swiper">
        <div class="swiper-wrapper">
          <!-- Slides -->
          <div v-for="index in 10" :key="index" class="swiper-slide"><img src="@/assets/sample.jpg" /></div>
        </div>
      </div>
      <div class="mt-20 mb-20 ml-20 mr-20 text-xl font-bold">내 꿈은 건물주님을 위한 HOT 10</div>
      <div ref="swiper5" class="swiper">
        <div class="swiper-wrapper">
          <!-- Slides -->
          <div v-for="index in 10" :key="index" class="swiper-slide"><img src="@/assets/sample.jpg" /></div>
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

export default {
  components: { TheFooter },
  mounted() {
    new Swiper(this.$refs.swiper, {
      modules: [Navigation, Pagination, Autoplay],
      grabCursor: true,
      slidesPerView: 5.3,
      spaceBetween: 30,
    });
    new Swiper(this.$refs.swiper2, {
      modules: [Navigation, Pagination, Autoplay],
      grabCursor: true,
      slidesPerView: 5.3,
      spaceBetween: 30,
      freeMode: true,
    });
    new Swiper(this.$refs.swiper3, {
      modules: [Navigation, Pagination, Autoplay],
      grabCursor: true,
      slidesPerView: 5.3,
      spaceBetween: 30,
      freeMode: true,
    });
    new Swiper(this.$refs.swiper4, {
      modules: [Navigation, Pagination, Autoplay],
      grabCursor: true,
      slidesPerView: 5.3,
      spaceBetween: 30,
      freeMode: true,
    });
    new Swiper(this.$refs.swiper5, {
      modules: [Navigation, Pagination, Autoplay],
      grabCursor: true,
      slidesPerView: 5.3,
      spaceBetween: 30,
      freeMode: true,
    });
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
