# Happy House Project

## #2 Web Front PJT

### 1. 목표

- 동적 코딩을 위한 Javascript와 jQuery을 활용할 수 있다.
- UI 설계 툴을 활용한 화면 설계 기법을 이해하고 활용할 수 있다.
-

### 2. 준비사항

- 개발언어/프로그램
- Java / Eclipse
- 사용데이터

  - 국토교통부 광명시 아파트매매 실거래자료 현황

### 3. 기본기능

- 메인 페이지(동별, 아파트별 실거래가 검색 기능 포함)

  **실행 결과**

  - 로그인, 회원가입 버튼 구현
  - 지도 구현
  - 사이드 바로 이동(메인 페이지, 매매정보(동별, 아파트별 거래 정보 검색), 회원 정보 확인)

  ![image-20210312171508975](/README.assets/image-20210312171508975.png)

- 동별 실거래가 검색 결과 페이지

- 아파트별 실거래가 검색 결과 페이지

- 회원정보 등록, 확인, 수정 페이지

  **0) 사전 데이터**

  - 회원 정보

    ```xml
    <users>
      <user>
        <id>ssafy</id>
        <password>1234</password>
        <user-name>김싸피</user-name>
        <phone>010-7564-0626</phone>
        <email>ssunyujin@naver.com</email>
        <address>대전시 유성구 구암동</address>
      </user>
      <user>
        <id>sunyujin</id>
        <password>5678</password>
        <user-name>양유진</user-name>
        <phone>010-7564-0626</phone>
        <email>sssunyujin@gmail.com</email>
        <address>서울시 성북구 정릉동</address>
      </user>
    </users>
    ```

  **1) 회원 정보 등록**

  - **joinin.html joinin.js 참고**

  - Join in 버튼 클릭시 회원가입 페이지로 이동

  - check id 버튼 클릭시 아이디 중복 검사를 실행

    **실행 결과**

    - 가입 화면

    ![image-20210312172449214](/README.assets/image-20210312172449214.png)

    - 가입 성공

    ![image-20210312172642770](/README.assets/image-20210312172642770.png)

  **2) 회원 정보 확인**

  - **profile.html profile.js 참고**
  - 로그인 성공시 회원 정보 조회 화면으로 이동
  - 아이디를 입력시 해당 아이디가 있다면 조회

  **실행 결과**

  ![image-20210312172907245](/README.assets/image-20210312172907245.png)

  **3) 회원 정보 수정**

  - **profile.js 참고**
  - 수정 버튼 클릭시 이동

  **실행 결과**

  ![image-20210312173040207](/README.assets/image-20210312173040207.png)

  **3-1) 수정하기**

  - 내용 입력후 수정하기 버튼 클릭시 수정
  - 수정 성공후 해당 내용 출력

  **실행 결과**

  <img src="/README.assets/image-20210312173226187.png" alt="image-20210312173226187" style="zoom: 67%;" /><img src="/README.assets/image-20210312173348561.png" alt="image-20210312173348561" style="zoom: 67%;" />

- 로그인/로그아웃 페이지

  **1) 로그인**

  - **login.html modal_login.js 참고**

  - 로그인 버튼 클릭시 이동한다.
  - 로그인 성공시 alert으로 "로그인 성공", 실패시 "로그인 실패"가 뜬다.

  **로그인 실행 결과**

  ![image-20210312171552810](/README.assets/image-20210312171552810.png)

![image-20210312171644196](/README.assets/image-20210312171644196.png)

​ **1-1) 로그인 성공 시 회원 정보 조회 페이지로 이동**

![image-20210312171730060](/README.assets/image-20210312171730060.png)

**2) 로그아웃**

- 로그아웃 클릭시 로그인 페이지로 이동

메인페이지

![메인페이지](/README.assets/메인페이지.png)

- 지도를 연동하였습니다.

![맵초기](/README.assets/맵초기.png)

- 지도 연동 코드 부분.

![마커찍기](/README.assets/마커찍기.png)

- 데이터 불러와서 마커 찍기.

![동으로검색하기](/README.assets/동으로검색하기.png)

- 동 이름 입력해서 검색하기 부분.
  ![동으로검색하기1](/README.assets/동으로검색하기1.png)
  select 이용해서 원하는 동 선택시 아파트 목록 출력.
  ![동으로검색하기2](/README.assets/동으로검색하기2.png)

- 동으로 검색하기 부분 코드.
  ![동으로검색하기코드](/README.assets/동으로검색하기코드.png)
  ![동으로검색하기코드2](/README.assets/동으로검색하기코드2.png)

- 아파트 이름으로 검색하기 부분.
  구현하려했지만 실패.
  아파트 이름을 검색해서 그 값으로 데이터를 검색하고 싶었으나 실패.
  ![이름으로검색하기](/README.assets/이름으로검색하기.png)
  ![실패코드](/README.assets/실패코드.png)

### 4. 추가기능

#### 1) 비밀 번호 찾기

- **modal_login.js 참고**

- 아이디를 입력하고 비밀번호 찾기를 누르면 해당 아이디의 비밀 번호가 나온다. 아이디가 없을 시 아이디 없다고 나온다.

  **실행 결과**
  ![image-20210312174449593](/README.assets/image-20210312174449593.png)
