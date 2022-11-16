<template>
  <div class="flex flex-col items-end mt-50">
    <ckeditor :editor="editor" v-model="editorData" />
    <button class="mt-20 font-semibold text-white bg-yellow-700 w-100 h-50" @click="writeNewNotice">작성하기</button>
  </div>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import CKEditor from "@ckeditor/ckeditor5-vue2";
import { mapActions } from "vuex";
export default {
  name: "CKEditor",
  components: {
    ckeditor: CKEditor.component,
  },
  data: () => ({
    editor: ClassicEditor,
    editorData: "aa",
  }),
  methods: {
    ...mapActions(["writeNotice"]),
    writeNewNotice() {
      console.log(this.editorData);
      console.log(typeof this.editorData);
      this.writeNotice(this.editorData);
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
