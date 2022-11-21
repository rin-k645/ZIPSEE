<template>
  <div class="flex flex-col items-end mt-50">
    <div class="">제목</div>
        <input
          type="text"
          name="id"
          placeholder="제목을 입력해주세요"
          v-model="ask.title"
          class="" />
    <ckeditor :editor="editor" v-model="ask.content" />
    <button class="mt-20 font-semibold text-white bg-yellow-700 w-100 h-50" @click="writeNewNotice">전송하기</button>
  </div>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import CKEditor from "@ckeditor/ckeditor5-vue2";
import { mapActions } from "vuex";
const boardStore = "boardStore";

export default {
  name: "CKEditor",
  components: {
    ckeditor: CKEditor.component,
  },
  data: () => ({
    editor: ClassicEditor,
    ask: {
        userId: null,
        title: null,
        content: "<p>질문할 내용을 적어주세요.</p>",
      },
  }),
  methods: {
    ...mapActions(boardStore, ["writeAsk"]),
    writeNewNotice() {
      console.log(this.content);
      console.log(typeof this.content);
      this.writeAsk(this.ask);
    },
  },
};
</script>

<style>
.ck-editor__editable {
  min-height: 400px;
  min-width: 1200px;
}
</style>
