<template>
  <div class="flex items-center justify-center">
    <div class="flex flex-col items-center justify-center w-640 h-831">
      <div class="h-24 w-74 mb-19">회원가입</div>
      <div class="h-2 bg-black w-640 mb-17"></div>
      <div class="flex items-center mb-20 w-612 h-46">
        <div class="h-24 w-66">아이디*</div>
        <input
          type="text"
          placeholder="아이디를 입력해주세요"
          class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md ml-84 mr-12"
        />
        <button class="text-yellow-400 border-yellow-400 rounded-md w-120 h-46 border-1">중복확인</button>
      </div>
      <div class="flex items-center mb-20 w-612 h-46">
        <div class="h-24 w-84">비밀번호*</div>
        <input
          type="password"
          placeholder="비밀번호를 입력해주세요"
          class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md ml-66"
        />
      </div>
      <div class="flex items-center mb-20 w-612 h-46">
        <div class="h-24 w-47">이름*</div>
        <input
          type="text"
          placeholder="이름을 입력해주세요"
          class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md ml-103"
        />
      </div>
      <div class="flex items-center mb-20 w-612 h-46">
        <div class="h-24 w-66">닉네임*</div>
        <input
          type="text"
          placeholder="닉네임을 입력해주세요"
          class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md ml-84"
        />
      </div>
      <div class="flex items-center mb-20 w-612 h-46">
        <div class="h-24 w-66">이메일*</div>
        <input
          type="email"
          placeholder="예: ssafy@ssafy.com"
          class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md ml-84 mr-12"
        />
        <button class="text-yellow-400 border-yellow-400 rounded-md w-120 h-46 border-1">중복확인</button>
      </div>
      <div class="flex items-center mb-20 w-612 h-46">
        <div class="h-24 w-66">휴대폰*</div>
        <input
          type="text"
          placeholder="예: 010-1234-5678"
          class="w-330 h-46 border-1 border-[#e5e5e5] rounded-md ml-84"
        />
      </div>
      <div class="flex items-center mb-20 w-612 h-46">
        <div class="h-24 w-37">성별</div>
        <div class="flex justify-between w-271 h-22 ml-122">
          <div class="flex items-center justify-between w-66 h-22">
            <input type="radio" name="sex" class="w-20 h-20 text-yellow-400 bg-gray-200 border-none checked:bg-none" />
            남자
          </div>
          <div class="flex items-center justify-between w-66 h-22">
            <input type="radio" name="sex" class="w-20 h-20 text-yellow-400 bg-gray-200 border-none checked:bg-none" />
            여자
          </div>
          <div class="flex items-center justify-between w-99 h-22">
            <input type="radio" name="sex" class="w-20 h-20 text-yellow-400 bg-gray-200 checked:bg-none" />
            선택안함
          </div>
        </div>
      </div>
      <div class="flex mb-20 w-612 h-61">
        <div class="h-24 w-66">관심사</div>
        <div class="grid grid-cols-4 grid-rows-2 w-295 h-61 ml-91">
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
          <button class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">카페</button>
        </div>
      </div>
      <div class="flex mb-20 w-612 h-61">
        <div class="h-24 w-80">관심 지역</div>
        <div class="grid grid-cols-4 grid-rows-2 w-295 h-61 ml-77">
          <button v-for="index in 8" :key="index" class="w-64 border-yellow-400 h-26 border-1 rounded-12 text-14">
            역삼동
          </button>
        </div>
        <button class="ml-40 text-yellow-400 border-yellow-400 rounded-md w-120 h-46 border-1">추가하기</button>
      </div>
      <button class="mt-20 text-white bg-yellow-700 w-640 h-50 text-20">수정하기</button>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
