<template>
  <div class="pl-40 pt-30 pb-30 bg-gray-50" v-html="notice.content"></div>
</template>

<script>
export default {
  name: "BoardNoticeDetail",
  props: {
    notice: Object,
  },
};
</script>

<style></style>
