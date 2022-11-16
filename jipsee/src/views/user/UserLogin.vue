<template>
  <div class="flex items-center justify-center">
    <div class="flex flex-col items-center justify-center w-500 h-350">
      <div class="w-56 h-24 mb-59">로그인</div>
      <div class="flex flex-col justify-between mb-40 w-447 h-115">
        <div class="flex items-center justify-between w-447 h-46">
          <div class="w-56 h-24">아이디</div>
          <input
            type="text"
            placeholder="아이디를 입력해주세요"
            class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md"
          />
        </div>
        <div class="flex items-center justify-between w-447 h-46">
          <div class="w-[74px] h-24">비밀번호</div>
          <input
            type="password"
            placeholder="비밀번호를 입력해주세요"
            class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md"
          />
        </div>
      </div>
      <div class="flex justify-between w-447 h-50">
        <button class="w-200 h-50 bg-[#fab005] rounded-md text-white">로그인</button>
        <button class="text-yellow-400 border-yellow-400 rounded-md w-200 h-50 border-1">가입하기</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
