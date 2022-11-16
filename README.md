# 목차

1. [프로젝트 소개](#1-프로젝트-소개)
2. [구현 파일](#2-구현-파일)
3. [구현 기능](#3-구현-기능)
4. [데이터베이스 설계](#4-데이터베이스-설계)
5. [보완할 점](#5-보완할-점)

<br>
<br>

# 1 프로젝트 소개

<h3> 요청 조건 </h3>
<br>

- 아파트/다세대주택 별 거래 내역 정보와 주택 정보 파일을 이용
- 위 파일을 읽어와서 고객에게 원하는 주택 정보를 조회(동 별 / 아파트 매매, 다세대주택 매매)할 수 있도록 하고, 그 결과를 분석해서 화면에 표시
- 회원정보 및 관심지역을 저장하는 데이터베이스 설계
- 회원정보를 관리할 수 있는 Table 설계 및 DAO클래스 구현
- 관심지역을 관리할 수 있는 Table 설계 및 DAO클래스 구현

<br>

# 2 프로젝트 환경

| 분류 | 환경 |
| ---  | ---  |
| OS | Windows |
| IDE | STS, VS Code |
| FrontEnd | HTML, CSS, JavaScript, Vue, Tailwind |
| BackEnd | Language : JAVA |
|  | Framework : Spring Boot (2.7.5) |
|  | DataBase : Mysql  |

<br>

# 3 구현 기능

<h3> :pushpin: 메인 페이지 </h3>

<img src="https://user-images.githubusercontent.com/28649890/202128179-f5113e5f-fb8d-49e8-8466-d4c7768ac91c.PNG" />

<br>
<br>

- 상단 네비게이션 바
  - 로그인 안했을시 로그인 및 회원가입 페이지로 이동 가능, 로그인 했을시 로그아웃 하거나 마이페이지로 이동 가능 (개발중)
  - 매매 현황 클릭시 매매 현황 페이지로 이동 가능
  - 공지사항 클릭시  페이지로 이동 가능
- 화면 상단 (개발중)
  - 아파트와 주택 홍보 문구 및 이미지를 슬라이드로 볼 수 있고, 클릭하면 해당 매물로 이동 가능
- 화면 하단 (개발중)
  - 실시간 인기 매물, 사용자 맞춤 추천 매물을 스와이퍼로 넘기며 볼 수 있음
- 화면 하단 footer (개발중)
  - 상단 네비게이션 바에 있는 메뉴 및 로고, Git 링크로 이동할 수 있는 버튼

<br>
<br>
<h3> :pushpin: 매매 현황 조회 페이지 </h3>

- 시/도, 구/군, 동, 매매년/월 및 부동산 유형(아파트, 주택)을 선택하여 매매현황 확인 가능

<img src="https://user-images.githubusercontent.com/28649890/202128706-331f4014-1c56-435d-8127-5f2458b8a129.PNG" />

- 아파트 매매 현황
  - 페이지 접속 시 현재 위치를 default 값으로 지도에 표시
  - 앞서 선택한 시/도, 구/군, 동, 매매년/월 에 해당하는 매매 현황 내역이 지도 아래 테이블로 표시됨
    - makeAptList() 메소드 구현 : DB에서 비동기적으로 데이터를 불러와 반복문을 통해 테이블 element를 생성
  - '지도 표시' 버튼 클릭 시 해당 지역이 지도에 표시됨
  - '관심 등록' 버튼 클릭 시 해당 매물이 관심 매물 데이터베이스에 저장됨(추후 개발 예정)


<br>
<br>
<h3> :pushpin: 로그인 페이지 </h3>

<img src="https://user-images.githubusercontent.com/28649890/202128781-9933d52a-33c5-4a96-80e2-4e6815c2ef30.PNG" />

- 아이디 및 비밀번호 입력 폼, 로그인 버튼, 회원가입 페이지로 이동하는 버튼
  <br>
  <img src="https://user-images.githubusercontent.com/67595512/192801567-0848b4fc-8a0b-46e5-8dde-a787123233cf.png" />
  - 정확한 아이디와 비밀번호를 입력해야 로그인 가능(일치하지 않을시 alert를 띄워줌)

<img src="https://user-images.githubusercontent.com/67595512/192799221-c3d9ad70-72c1-4832-a33d-3184c19aff7f.png" />

- 로그인 성공시 상단 네비게이션 바 요소 변경
  - 로그인 버튼 -> 로그아웃 버튼
  - 회원가입 버튼 -> 마이페이지 버튼

<br>
<br>
<h3> :pushpin: 회원가입 페이지 </h3>

<img src="https://user-images.githubusercontent.com/28649890/202128878-171b989c-46bb-425d-92d6-4dddacb2a66c.PNG" />

- 아이디, 비밀번호, 이름, 전화번호, 주소, 우편번호 입력 폼, 회원가입 버튼
- 입력하지 않은 정보가 있을 경우, 회원가입이 제한됨

<br>
<br>
<h3> :pushpin: 마이페이지 </h3>

<img src="https://user-images.githubusercontent.com/67595512/192802227-3f0755dd-685b-4afe-8897-f7ecf2ce981b.png" />

- 정보변경, 관심 아파트, 관심 주택 메뉴

- 정보변경 : 아이디를 제외한 내 정보를 변경하거나 회원 탈퇴를 할 수 있음
<br>
<br>
<br>
![notice](https://user-images.githubusercontent.com/28649890/202128799-e3f26169-d3a0-4bcb-b1af-698a92876832.PNG)
![noticewrite](https://user-images.githubusercontent.com/28649890/202128809-36cef24f-90dd-4e74-82b4-f5e5901c06ef.PNG)
![ask](https://user-images.githubusercontent.com/28649890/202128830-7d46746e-7c06-4d5f-b4c2-f4d84c7625fd.PNG)
![question](https://user-images.githubusercontent.com/28649890/202128870-3783450c-6e47-4203-9c6a-cc0e8c2de4f1.PNG)


<br>


# 4 데이터베이스 설계

<h3> :pushpin: ER 다이어그램 </h3>
<img src="https://user-images.githubusercontent.com/67595512/202134838-dff4ffea-015a-40a3-8aa8-f7426c302266.PNG" />


<br>
<br>

# 5 보완할 점

<h4> :pushpin: 부분적 rest api 사용 </h4>

- 로그인에서 session을 이용해야 하기 때문에 restapi를 사용할 수 없었다.

<h4> :pushpin: 부족한 DB 구축 </h4>

- 데이터 구축에 완벽하게 성공하지 못해 보완이 필요하다.

