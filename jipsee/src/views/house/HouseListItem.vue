<template>
  <div class="flex justify-center">
    <div class="grid grid-rows-[47px_153px] grid-cols-[168px_192px]">
      <div class="relative col-span-2 flex items-center text-bold">
        {{ house.houseInfo.houseName }}
        <div class="absolute top-0 right-5">♥</div>
      </div>
      <div class="grid justify-end">
        <div class="bg-gray-100 w-168 h-130">
          <img :src="house.houseInfo.img" />
        </div>
      </div>
      <div class="pt-10 pl-15">
        <div class="text-18 font-bold pb-10">
          {{ house.dealType }} {{ house.deposit | changeMoneyUnit }} /
          {{ house.price | changeMoneyUnit }}
        </div>
        <div>{{ house.area }}m² {{ house.floor }}층</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HouseListItem",
  props: {
    house: Object,
  },
  filters: {
    changeMoneyUnit(money) {
      return money / 10000;
    },
  },
};
</script>

<style></style>
