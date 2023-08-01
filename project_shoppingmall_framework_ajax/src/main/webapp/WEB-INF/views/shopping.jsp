<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Shopping Cart</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimal-ui">
  <!-- 타이틀 옆에 표시되는 아이콘 링크 -->
  <link rel="shortcut icon" type="image/x-icon" href="img/favicon1.ico">

  <!-- 폰트어썸 icon 적용을 위한 link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />

  <!-- css 스타일시트 적용 -->
  <link rel="stylesheet" href="css/style.css">

  <!-- script -->
  <script defer src="js/lib/jquery-3.1.1.min.js"></script>
  <script defer src="js/nav.js"></script>
</head>

<body>

  <!-- 전체영역 -->
  <div id="wrap">
    <!-- 메뉴버튼 클릭시 왼쪽에서 펼쳐지는 영역- -->
    <nav class="mob_nav ">
      <div class="m_nav_bg"></div>
      <div class="m_nav_wrap">
        <h2>
          <a href="#">
            <img src="img/hera_logo.png" alt="logo">
          </a>
        </h2>
        <!-- m_nav_list  m_list_tit  icon_nav  blind-->
        <ul class="m_nav_list">
          <li>
            <a href="#" class="m_list_tit">Brand</a>
          </li>
          <li>
            <a href="#" class="m_list_tit">
              Product
              <i class="icon_nav"></i>
            </a>
            <dl>
              <dt class="blind">제품</dt>
              <dd><a href="#">BEST ITEM</a></dd>
              <dd><a href="#">HOT ITEM</a></dd>
              <dd><a href="#">NEW ITEM</a></dd>
              <dd><a href="#">Camera</a></dd>
              <dd><a href="#">Glasses</a></dd>
              <dd><a href="#">Binocular</a></dd>
              <dd><a href="#">Microscope</a></dd>
            </dl>
          </li>
          <li>
            <a href="#" class="m_list_tit">
              이벤트
              <i class="icon_nav"></i>
            </a>
            <dl>
              <dt class="blind">진행중인이벤트</dt>
              <dd><a href="#">종료된 이벤트</a></dd>
              <dd><a href="#">당첨자 발표</a></dd>
            </dl>
          </li>
          <li>
            <a href="#" class="m_list_tit">
              고객센터
              <i class="icon_nav"></i>
            </a>
            <dl>
              <dt class="blind">스파</dt>
              <dd><a href="#">Q&A</a></dd>
              <dd><a href="#">제품지원</a></dd>
              <dd><a href="#">제품상담</a></dd>
              <dd><a href="#">자료실</a></dd>
              <dd><a href="#">매장 및 서비스센터</a></dd>
            </dl>
          </li>
          <li>
            <a href="#" class="m_list_tit">
              My 서비스
              <i class="icon_nav"></i>
            </a>
            <dl>
              <dt class="blind">서비스</dt>
              <dd><a href="#">정품등록조회</a></dd>
              <dd><a href="#">무상서비스 연장 조회</a></dd>
              <dd><a href="#">A/S 이력 및 A/S온라인 결제내역 조회</a></dd>
              <dd><a href="#">VOC</a></dd>
            </dl>
          </li>
          <li>
            <a href="#" class="m_list_tit">
              택배서비스
              <i class="icon_nav"></i>
            </a>
            <dl>
              <dt class="blind">제품</dt>
              <dd><a href="#">D2D 서비스</a></dd>
              <dd><a href="#">일반택배 서비스</a></dd>
              <dd><a href="#"></a></dd>
              <dd><a href="#"></a></dd>
              <dd><a href="#"></a></dd>
              <dd><a href="#"></a></dd>
              <dd><a href="#"></a></dd>
            </dl>
          </li>

        </ul>
        <div class="m_nav_btm">
          <div class="m_nav_sitemap">
            <a href="#">사이트맵</a>
            <a href="login.html">로그인</a>
            <a href="#">회원가입</a>
          </div>
          <div class="m_nav_cs">
            <a href="#">고객상담팀(수신자요금부담) 080-800-6600</a>
            <span>월~금: 09:00~18:00 (토/일 공휴일 휴무)</span>
          </div>
          <div class="m_nav_cp">
            <p>
              <a href="#">회사소개</a>
              <a href="#">서비스이용약관</a>
              <a href="#">개인정보저리방침</a>
            </p>
            <p>
              <a href="#">영상정보처리방침</a>
              <a href="#">협찬문의</a>
            </p>
          </div>
          <div class="m_copy">
            © AMOREPACIFIC CORPORATION. All rights reserved.
          </div>
        </div>
      </div>
    </nav>


    <!-- 헤더 전체 영역 -->
    <header id="shopping_header">

      <!-- 컨텐츠 가운대 정렬을 위한 영역2 -->
      <div class="header_wrap cont_wrap">
        <a href="#" class="mob_nav_btn">
          <i></i>
        </a>

        <!-- 로고 이미지 -->
        <h1 class="logo">
          <a href="#">
            <img src="img/hera_logo.png" alt="logo">
          </a>
        </h1>

        <!-- 매장찾기 / 구매하기 / 검색아이콘 -->
        <div class="header_links">

          <!-- 로그인버튼 -->
          <a href="login.html">
            <i class="fa-solid fa-user"></i>
          </a>
          <!-- 검색버튼 -->
          <a href="#" class="h_open_search">
            <i class="icon-search"></i>
          </a>
        </div>
        <!-- 검색 아이콘 클릭시 나타나는 영역 -->
        <div id="top_search" class="search_container ">
          <div class="top_search_bg"></div>
          <form action="header_top_search">
            <div class="search_wrap">
              <label for="h_search" class="blind">검색</label>
              <input type="search" name="h_search" id="h_search" class="text" autofocus>
              <button class="submit">
                <i class="icon-search"></i>
              </button>
              <!-- 검색버튼을 종료하기위한 X ICON -->
              <a href="#" class="sch_close">
                <img src="img/bu_x.png" alt="x">
              </a>
            </div>
          </form>
        </div>
      </div>
    </header>

  


<!-- 쇼핑 페이지 시작 -->
    <div class="shopping_page">
      <!-- 장바구니 텍스트 -->
      <div class="shop_text">
        <h2>장바구니</h2>
      </div>

      <!-- 전체선택 -->
      <div class="shop_select">
        <button type="check"></button>
        <h2 id="shop_select_all">전체선택</h2>
      </div>




    </div>



















</div>
</body>