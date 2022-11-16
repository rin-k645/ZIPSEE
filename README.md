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

# 2 구현 파일

| 기능       | 파일명                                                                                                                |
| ---------- | --------------------------------------------------------------------------------------------------------------------- |
| dto        | UserDto, LikeHouseDto, HouseInfoDto, DongCodeDto                                                                      |
| dao        | UserMapper, HouseInfoMapper, HouseDealMapper, LikeHouseMapper, DongCodeMapper (interface/xml)                         |
| service    | UserService, HouseDealService, HouseInfoService, LikeHouseService, DongCodeService (interface/class)                  |
| controller | UserController, UserRestController, ViewController, HouseRestController                                               |
| jsp        | index.jsp, login.jsp, signup.jsp, house.jsp, mypageMain.jsp, mypageChange.jsp, mypageLikeApt.jsp, mypageLikeHouse.jsp |
| js         | house.js, main.js, user.js                                                                                            |

- User 파일: 회원가입, 로그인 등 사용자 정보 데이터베이스 및 관련 연산 수행
- HouseDeal/HouseInfo 파일 : 아파트/주택 매물 데이터베이스 및 관련 연산 수행
- LikeHouse 파일: 관심 등록한 아파트/주택 매물 데이터베이스 및 관련 연산 수행
- js 파일: 비동기 통신과 페이지 이동에 필요한 기능 수행

<br>

# 3 구현 기능

<h3> :pushpin: 메인 페이지 </h3>

<img src="https://user-images.githubusercontent.com/67595512/192798477-03155de6-1ccb-4ace-ba50-fa68db1b54c1.PNG" />

<br>
<br>

- 상단 네비게이션 바
  - 로그인 안했을시 로그인 및 회원가입 페이지로 이동 가능, 로그인 했을시 로그아웃 하거나 마이페이지로 이동 가능
  - 매매 현황 클릭시 매매 현황 페이지로 이동 가능
- 화면 상단
  - 지역별 아파트와 주택 홍보 문구 및 이미지 스와이퍼
  - 매매 현황 페이지로 이동 가능한 버튼
- 화면 하단
  - 홈페이지 공지사항 및 주요 뉴스 한눈에 확인 가능
- 화면 하단 footer
  - 상단 네비게이션 바에 있는 메뉴 및 로고, Git 링크로 이동할 수 있는 버튼

<br>
<br>
<h3> :pushpin: 매매 현황 조회 페이지 </h3>

- 시/도, 구/군, 동, 매매년/월 및 부동산 유형(아파트, 주택)을 선택하여 매매현황 확인 가능

<img src="https://user-images.githubusercontent.com/67595512/192799898-e4859b4b-a857-4c26-96c0-74a00b018bf6.png" />

- 아파트 매매 현황
  - 페이지 접속 시 현재 위치를 default 값으로 지도에 표시
  - 앞서 선택한 시/도, 구/군, 동, 매매년/월 에 해당하는 매매 현황 내역이 지도 아래 테이블로 표시됨
    - makeAptList() 메소드 구현 : DB에서 비동기적으로 데이터를 불러와 반복문을 통해 테이블 element를 생성
  - '지도 표시' 버튼 클릭 시 해당 지역이 지도에 표시됨
  - '관심 등록' 버튼 클릭 시 해당 매물이 관심 매물 데이터베이스에 저장됨(추후 개발 예정)


<br>
<br>
<h3> :pushpin: 로그인 페이지 </h3>

<img src="https://user-images.githubusercontent.com/67595512/192801436-7417552c-df04-4228-ac1a-87b9819053ff.png" />

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

<img src="https://user-images.githubusercontent.com/67595512/192802029-ede6d6ba-acac-482d-88dd-f4801ecab45b.png" />

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

- RestController 구현 : 기존의 servlet을 restcontroller로 구현

```java
@RestController
@RequestMapping("/user")
public class UserRestController {
@Autowired
private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
      this.userService = userService;
    }

    @PostMapping
    public String register(@RequestBody UserDto userDto) throws Exception {
      if(userService.registerUser(userDto))
        return "회원 가입 성공";
      return "회원 가입 실패";
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> view(@PathVariable("userid") String userId) {
      return null;
    }

    @PutMapping
    public String modify(@RequestBody UserDto userDto) throws Exception {
      if(userService.modifyUser(userDto))
        return "회원 정보 수정 성공";
      return "회원 정보 수정 실패";
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) {
      return null;
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
      return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

<br>

```java
@RestController
@RequestMapping("/deal")
public class HouseRestController {
	private HouseDealService houseDealService;

	@Autowired
	public HouseRestController(HouseDealService houseDealService) {
		super();
		this.houseDealService = houseDealService;
	}

	@GetMapping
	public ResponseEntity<?> list(@RequestParam Map<String, Object> map) {
		try {
			List<HouseDealDto> list = houseDealService.getHouseDealList(map);
			if (list != null && !list.isEmpty()) {
				System.out.println(list);
				return new ResponseEntity<List<HouseDealDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
  }

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
```

<br>

```javascript
document.querySelector("#list-btn").addEventListener("click", function() {

	let houseType = document.getElementById("kind").value;

	document.getElementById("apartInfo").setAttribute("style", "display: block;");
		document.getElementById("houseInfo").setAttribute("style", "display: none;");
		
		let gugunSel = document.querySelector("#dong");
		let regCode = gugunSel[gugunSel.selectedIndex].value;
		let yearSel = document.querySelector("#year");
		let year = yearSel[yearSel.selectedIndex].value;
		let monthSel = document.querySelector("#month");
		let month = monthSel[monthSel.selectedIndex].value;
	
		let queryParams =
			"&" + "dongCode" + "=" + regCode; /*아파트소재 구군*/
		queryParams +=
		"&" + "dealYear" + "=" + year; /*조회년*/
		queryParams +=
		"&" + "dealMonth" + "=" + month; /*조회월*/

	
		fetch(`${getContextPath()}/deal?${queryParams}`)
			.then((response) => response.json())
			.then((data) => {
				makeAptList(data);
			});

});
```

<br>


# 4 데이터베이스 설계

<h3> :pushpin: ER 다이어그램 </h3>
<img src="https://user-images.githubusercontent.com/67595512/199498777-f97889ef-4d55-4fe4-8256-6c21e88345f2.png" />


<br>
<br>

# 5 보완할 점

<h4> :pushpin: 부분적 rest api 사용 </h4>

- 로그인에서 session을 이용해야 하기 때문에 restapi를 사용할 수 없었다.

<h4> :pushpin: 부족한 DB 구축 </h4>

- 데이터 구축에 완벽하게 성공하지 못해 보완이 필요하다.

