<template>
  <div class="bg-yellow-50">
    <div class="grid grid-rows-[47px_153px] grid-cols-[168px_192px]">
      <div class="col-span-2"></div>
      <div class="grid justify-end">
        <div class="bg-yellow-100 w-160 h-130">
          <img :src="house.houseInfo.img" />
        </div>
      </div>
      <div>{{ house.houseInfo.houseName }}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HouseListItem",
  props: {
    house: Object,
  },
};
</script>

<style></style>
