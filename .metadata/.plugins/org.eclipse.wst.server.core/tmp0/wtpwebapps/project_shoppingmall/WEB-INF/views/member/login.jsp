<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <!-- 타이틀 옆에 표시되는 아이콘 링크 -->
  <link rel="shortcut icon" type="image/x-icon" href="img/favicon1.ico">
  <link rel="stylesheet" href="../css/style.css">
  <script defer src="js/lib/jquery-3.1.1.min.js"></script>
  <script defer src="js/login.js"></script>
</head>

<body>
  <!-- 헤더 -->
  <header id="login_header">
    <!-- 헤더 콘텐츠를 가운대 정렬하기 위한 영역설정 -->
    <div class="login_header_wrap">
       <!-- 로고 이미지 -->
       <h1 class="logo">
        <a href="/">
          <img src="../img/hera_logo.png" alt="logo">
        </a>
      </h1>
    </div>
  </header>

  <!-- 로그인 컨텐츠 -->
  <div class="login_contents">
    <h1 id="login_first">아모레퍼시픽 뷰티포인트 통합회원<br>
      아이디로 로그인해주세요.
    </h1>

    <form action="${path}/member/signin" class="uid_form" method="post">
    <!-- 아이디 입력 텍스트칸 -->
    <input type="text" name="uid" id="uid" placeholder="아이디 입력">

    <!-- 비밀번호 입력 텍스트칸 -->
    <input type="text" name="upw" id="upw" placeholder="비밀번호 입력">
  


    <!-- 로그인 정보 제출 -->
    <button class="login" type="submit">로그인</button>
  </form>

    <!-- 모바일 , 카카오 , 네이버 , 기타 로그인  -->
    <div class="platform_login">

      <!-- 모바일 -->
      <div class="login_way lw1">
        <a href="">
          <img src="../img/login_mobite_bt.png" alt="">
          <p class=login_way_text>휴대폰</p>
        </a>
      </div>

      <!-- 카카오 -->
      <div class="login_way lw2">
        <a href="">
          <img src="../img/login_kakao_bt.png" alt="">
          <p class=login_way_text>카카오</p>
        </a>
      </div>

      <!-- 네이버 -->
      <div class="login_way lw3">
        <a href="">
          <img src="../img/login_naver_bt.png" alt="">
          <p class=login_way_text>네이버</p>
        </a>
      </div>

      <!-- 기타 -->
      <div class="login_way lw4">
        <a href="">
          <img src="../img/login_else_btn.png" alt="">
          <p class=login_way_text>기타</p>
        </a>
      </div>
    </div>

    <!-- 아이디 , 비밀번호 찾기 -->
    <div class="find_account">
      <a href="">
        <p class="find_id">아이디 찾기</p>
      </a>
      <a href="">
        <p class="find_pw">비밀번호 찾기</p>
      </a>
    </div>

    <!-- 회원가입 -->

    <!-- 회원가입 전체영역 -->
    <div class="regist_account" id="regist">
      <!-- 전체영역을 감싸는 a 태그 -->
      <a href="${path}/membership" class="regist_account_wrap">
        <!-- 텍스트를 정렬하기위한 영역 -->
        <div class="regist_account_text">
        <p>아직 회원이 아니세요?</p>
        <p>회원가입 >></p>
      </div>
      </a>
    </div>



  </div>


</body>

</html>