<template>
  <div class="flex flex-col items-center">
    <div class="w-1000 h-500 bg-yellow-200"></div>
    <div></div>
    <div></div>
  </div>
</template>

<script>
import { mapState } from "vuex";
const houseStore = "houseStore";
export default {
  computed: {
    ...mapState(houseStore, ["house"]),
  },
};
</script>

<style></style>
