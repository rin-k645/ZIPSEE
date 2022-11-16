<template>
  <div class="sticky top-0 z-10 flex items-center justify-between bg-white border-b-4 border-yellow-300 border-solid">
    <div class="flex items-center ml-10">
      <router-link to="/" class="h-80 w-80"><img src="@/assets/logo.png" /></router-link>
      <router-link :to="{ name: 'houselist' }" class="ml-32 font-semibold text-18">매물탐색</router-link>
      <router-link :to="{ name: 'board' }" class="ml-32 font-semibold text-18">공지사항</router-link>
    </div>
    <div class="mr-16">
      <router-link :to="{ name: 'search' }" class="text-lg"
        ><font-awesome-icon icon="fa-solid fa-magnifying-glass"
      /></router-link>
      <router-link :to="{ name: 'userlogin' }" class="ml-12 font-semibold text-18">로그인</router-link>
      <router-link :to="{ name: 'usersignup' }" class="ml-12 font-semibold text-18">회원가입</router-link>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
