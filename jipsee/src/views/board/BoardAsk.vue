<template>
  <div class="flex flex-col items-end mt-50">
    <ckeditor :editor="editor" v-model="editorData" />
    <button class="mt-20 font-semibold text-white bg-yellow-700 w-100 h-50">전송하기</button>
  </div>
</template>

<script>
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import CKEditor from "@ckeditor/ckeditor5-vue2";

export default {
  name: "CKEditor",
  components: {
    ckeditor: CKEditor.component,
  },
  data: () => ({
    editor: ClassicEditor,
    editorData: "<p>문의하실 내용을 적어주세요.</p>",
  }),
};
</script>

<style>
.ck-editor__editable {
  min-height: 400px;
  min-width: 1200px;
}
</style>
