<template>
  <div>
    <div class="pl-40 pt-30 pb-30 bg-gray-50" v-html="notice.content"></div>
    <button
      class="mt-20 font-semibold text-white bg-yellow-700 w-100 h-50"
      @click="deleteAdminNotice"
    >
      삭제하기
    </button>
  </div>
</template>

<script>
import { mapActions } from "vuex";
const boardStore = "boardStore";

export default {
  name: "BoardNoticeDetail",
  props: {
    notice: Object,
  },
  methods: {
    ...mapActions(boardStore, ["deleteNotice"]),
    deleteAdminNotice() {
      console.log(this.notice.boardId);
      this.deleteNotice(this.notice.boardId).then(() => {
        this.$router.go();
      });
    },
  },
};
</script>

<style></style>
