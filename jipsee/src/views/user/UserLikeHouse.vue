<template>
  <div class="grid grid-rows-2 grid-cols-4 w-1200 h-700">
    <div class="grid grid-rows-2 grid-cols-1">
      <div v-for="(likehouse, index) in likehouses" :key="index">
        <img :src="likehouse.houseInfo.img" />
        <div class="flex flex-col">
          <div>{{ likehouse.dealType }} {{ likehouse.price }}</div>
          <div>{{ likehouse.area }} {{ likehouse.floor }}</div>
          <div>{{ likehouse.dongName }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState(["likehouses"]),
  },
  methods: {},
};
</script>

<style></style>
