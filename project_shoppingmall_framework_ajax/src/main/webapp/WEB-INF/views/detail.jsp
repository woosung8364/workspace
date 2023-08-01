<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">


<head>
  <meta charset="UTF-8">
  <title>헤라 | 빈틈없이 밀착되는 맑은 컬러감</title>
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
  
</head>


<body>
   <!-- 전체영역 -->
   <div id="wrap">
    <!-- 메뉴버튼 클릭시 왼쪽에서 펼쳐지는 영역- -->
    <nav class="mob_nav ">
      <div class="m_nav_bg">

      </div>
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
              제품
              <i class="icon_nav"></i>
            </a>
            <dl>
              <dt class="blind">제품</dt>
              <dd><a href="#best">BEST ITEM</a></dd>
              <dd><a href="#">HOT ITEM</a></dd>
              <dd><a href="#new">NEW ITEM</a></dd>
              <dd><a href="#">화장품</a></dd>
              <dd><a href="#">스킨케어</a></dd>
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
              <dd><a href="#">제품상담</a></dd>
            </dl>
          </li>
        </ul>
        <div class="m_nav_btm">
          <div class="m_nav_sitemap">
            <a href="login.html">로그인</a>
            <a href="#">회원가입</a>
          </div>
          <div class="m_copy">
            © AMOREPACIFIC CORPORATION. All rights reserved.
          </div>
        </div>
      </div>
    </nav>

    <!-- 헤더 전체 영역 -->
     <header>

      <!-- 컨텐츠 가운데 정렬을 위한 영역2 -->
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
              <input type="search" name="h_search" id="h_search" class="text"  autofocus>
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

      <!-- 이미지와 텍스트를 모두 감싸기위한 div : position - relative  -->
      <div class="content_wrap">

      <!-- 이미지를 감싸기 위한 div : position - absolute -->
      <div class="prd_img">
        <img src="./img/hera/화장품/틴트/틴트1.jpg" alt="센슈얼 파우더 매트 리퀴드 133호 베이비치크">
      </div>

      <!-- 텍스트를 감싸기 위한 div : position - absolute -->
      <div class="prd_primary_wrap">
        <div class="prd_primary">
          <h1>
            <div class="prd_name">센슈얼 파우더 매트 리퀴드</div>
            <div class="prd_name_en">SENSUAL POWDER MATTE LIQUID</div>
          </h1>
            <div class="capacity">5g</div>
          <h2 class="prd_desc">한 번의 터치로 각질 부각 없이 풍부한 컬러로 감싸주는 편안한 <br> 소프트 벨벳 틴트</h2>
          <div class="go_review">
            <a href="#" class="cta_underline review" ap-click-area="Product" ap-click-name="Click - Review" ap-click-data="SENSUAL POWDER MATTE LIQUID">제품
            리뷰 보기
          </a>
        </div>
        
            <div class="sticky_inner">
              <a id="xAP" target="_blank" href="#" class="cta_black">장바구니</a>
              <a id="xAP" target="_blank" href="#" class="cta_black">구매하기</a>
            </div>
        </div>
      </div>
      </div>

      <div class="pdp_wrap">
        <div class="pdp_inner pyc_gap">
          <h2 class="bx_title">FIND YOUR COLOR</h2>
          <p class="bx_desc">더 편안하고 독보적인 분위기로 업그레이드된 센슈얼 파우더 매트 리퀴드의 10가지 컬러를 만나보세요.</p>
          <div class="pyc_img_wrap">
            <img src="./img/hera/화장품/틴트/틴트1_상세4.jpg" alt="센슈얼 파우더 매트 리퀴드 상세1" class="dp_pc">
          </div>
        </div>
      </div>

       <!-- 메인페이지 최하단 footer 마무으리~! -->
       <footer>
        <div class="footer_wrap">
          <!-- 텍스트 상단에 위치한 icon 이미지 -->
          <ul class="footer_mark">
            <!-- 페이스북 -->
            <li>
              <a href="#">
                <i class="icon-facebook"></i>
              </a>
            </li>

            <!-- 인스타그램 -->
            <li>
              <a href="#">
                <i class="icon-instagram"></i>
              </a>
            </li>

            <!-- 유튜브 -->
            <li>
              <a href="#">
                <i class="icon-youtube-play"></i>
              </a>
            </li>


            <li>
              <a href="#">
                <img src="img/kakaotalk.png" alt="">
              </a>
            </li>
          </ul>

        
        <!-- 첫째줄 text 컨텐츠 -->
        <div class="footer_link_left">
          <a href="#" class="footer_item">사이트맵</a>
          <a href="#" class="footer_item">로그인</a>
          <a href="#" class="footer_item">회원가입</a><br>
          <a href="#" class="footer_item_company">회사소개</a>
          <a href="#" class="footer_item_sys">서비스이용약관</a>
          <a href="#" class="footer_item_sys">개인정보처리방침</a>
          <a href="#" class="footer_item_sys">영상정보처리방침</a>
          <a href="#" class="footer_item_sys">뷰티포인트</a><br>
        </div>

        <div class="footer_link_left2">
          <a href="#" class="footer_item">고객상담팀(수신자요금부담): 080-023-5454</a>
          <span class="footer_item time">[상담시간] 월~금:AM 09:00~PM 06:00</span><br>
          <span class="footer_item copyright">
            © AMOREPACIFIC CORPORATION. All rights reserved.
          </span>
        
        </div>

        
        <!-- footer 이미지 하단에 위치한 text 컨텐츠들 -->
        <div class="footer_legal">
         
          
          <div class="wa">
            <a href="#">
              <img src="img/wa.png" alt="01">
            </a>
          </div>
          <!-- 웹표준 w3c 아이콘 -->
          <p class="w3c">
            <a href="http://validator.kldp.org/check?uri=referer"
              onclick="this.href=this.href.replace(/referer$/,encodeURIComponent(document.URL))"><img
                src="//validator.kldp.org/w3cimgs/validate/html5-orange.png" alt="Valid HTML 5" height="15"
                width="80"></a>
          </p>
        </div>

      </div>
      </footer>
     </div>


</body>
</html>