<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lnag="ko">

<head>
  <meta charset="UTF-8">
  <title>헤라 : 회원가입</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
  integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
  crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script defer src="js/lib/jquery-3.1.1.min.js"></script>
  <script  defer src="/js/main.js"></script>
  <script  defer src="/js/nav.js"></script>
  
</head>

<body>

  <!-- 헤더 전체 영역 -->
   <header class="membership_header">

      <!-- 로고 이미지 -->
      <h1 class="logo">
        <a href="/">
          <img src="/img/hera_logo.png" alt="logo">
        </a>
      </h1>
    </div>
  </header>

  <!-- wrapper -->
  <div id="wrapper">
    <!-- content-->
    <div id="content">
      <form action="${path}/membership" method="post">
      <!-- ID (1) -->
      <div>
        <h3 class="join_title">
          <label for="id">아이디</label>
        </h3>
        <span class="box int_id">
          <input type="text" id="id" name="id" class="int" maxlength="20">
        </span>
        <span class="error_next_box"></span>
      </div>
      <!-- PW1 (2)-->
      <div>
        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
        <span class="box int_pass">
          <input type="text" id="pswd1" name="pswd1" class="int" maxlength="20">
          <span id="alertTxt">사용불가</span>
          <img src="/img/membership/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
        </span>
        <span class="error_next_box"></span>
      </div>

      <!-- PW2 (3)-->
      <div>
        <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
        <span class="box int_pass_check">
          <input type="text" id="pswd2" name="pswd2" class="int" maxlength="20">
          <img src="/img/membership/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
        </span>
        <span class="error_next_box"></span>
      </div>

      <!-- NAME (4)-->
      <div>
        <h3 class="join_title"><label for="name">이름</label></h3>
        <span class="box int_name">
          <input type="text" id="name" name="name" class="int" maxlength="20">
        </span>
        <span class="error_next_box"></span>
      </div>

      <!-- BIRTH (5)-->
      <div>
        <h3 class="join_title"><label for="yy">생년월일</label></h3>

        <div id="bir_wrap">
          <!-- BIRTH_YY -->
          <div id="bir_yy">
            <span class="box">
              <input type="text" id="yy" name="yy" class="int" maxlength="4" placeholder="년(4자)">
            </span>
          </div>

          <!-- BIRTH_MM -->
          <div id="bir_mm">
            <span class="box">
              <select id="mm" name="mm" class="sel">
                <option>월</option>
                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
                <option value="05">5</option>
                <option value="06">6</option>
                <option value="07">7</option>
                <option value="08">8</option>
                <option value="09">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
              </select>
            </span>
          </div>

          <!-- BIRTH_DD -->
          <div id="bir_dd">
            <span class="box">
              <input type="text" id="dd" name="dd" class="int" maxlength="2" placeholder="일">
            </span>
          </div>

        </div>
        <span class="error_next_box"></span>
      </div>

      <!-- ADRESS -->
      <div>
        <h3 class="join_title"><label for="adress">주소</label></h3>
        <span class="box int_adress">
          <input type="text" id="address" name="address" class="int" maxlength="20">
        </span>
        <span class="error_next_box"></span>
      </div>


      <!-- MOBILE -->
      <div>
        <h3 class="join_title"><label for="mobile">휴대전화</label></h3>
        <span class="box int_mobile">
          <input type="tel" id="mobile" class="int" name="mobile" maxlength="16" placeholder="전화번호 입력">
        </span>
        <span class="error_next_box"></span>
      </div>


      <!-- JOIN BTN-->
      <div class="btn_area">
        <button type="submit" id="btnJoin">
          <span>가입하기</span>
        </button>
      </div>


    </form>
    </div>
    <!-- content-->
 
  </div>
  <!-- wrapper -->
  
</body>

</html>