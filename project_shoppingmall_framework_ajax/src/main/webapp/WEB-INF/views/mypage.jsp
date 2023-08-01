<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤라 : 마이페이지</title>
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
     

      <!-- 헤더 전체 영역 -->
   <header class="mypage_header">

    <!-- 컨텐츠 가운대 정렬을 위한 영역2 -->
    <div class="header_wrap cont_wrap">
      <!-- 로고 이미지 -->
      <h1 class="logo">
        <a href="index.html">
          <img src="img/hera_logo.png" alt="logo">
        </a>
      </h1>


      </div>
  </header>

      <!-- 헤더 밑 mypage 전체영역을 감싸는 div -->
      <div class="mypage_wrap">
        <!-- 좌측 네비게이션 전체영역 -->
        <div class="mypage_left_wrap">
            <!-- 텍스트칸의 위치를 지정하기 위한 ul -->
            <ul class="mypage_left_text">
                <li><a href="">개인정보</a></li>
                <li><a href="shopping.html">장바구니</a></li>
                <li><a href="">주문현황</a></li>
                <li><a href="">나의게시글</a></li>
                <li><a href="">1:1 문의</a></li>
            </ul>
        </div>

        <div class="mypage_right_wrap">
            <!-- 메인타이틀 : mypage -->
            <h1 id="mypage_title">My Page</h1>
            <p id="mypage_customer_name">ooo 회원님의 페이지 입니다</p>
            <div class="mypage_info_table">
                <h1>최근 주문 정보  <span>최근 30일 내에 주문하신 내역입니다</span></h1>
            <table>
                <thead>
                    <tr>
                        <td>날짜</td>
                        <td>주문번호</td>
                        <td>상품명</td>
                        <td>수량</td>
                        <td>금액</td>
                    </tr>
                </thead>

               
                <tbody>
                     <!-- 더미데이터1 -->
                    <tr>
                        <td>2005/05/04</td>
                        <td>02347897</td>
                        <td>iphone30</td>
                        <td>300</td>
                        <td>100(원)</td>
                    </tr>

                     <!-- 더미데이터2 -->
                     <tr>
                        <td>2005/03/02</td>
                        <td>02347897</td>
                        <td>iphone30</td>
                        <td>300</td>
                        <td>100(원)</td>
                    </tr>

                     <!-- 더미데이터3 -->
                     <tr>
                        <td>2004</td>
                        <td>02347897</td>
                        <td>iphone30</td>
                        <td>300</td>
                        <td>100(원)</td>
                    </tr>

                     <!-- 더미데이터4 -->
                     <tr>
                        <td>2090</td>
                        <td>02347897</td>
                        <td>iphone30</td>
                        <td>300</td>
                        <td>100(원)</td>
                    </tr>

                </tbody>
            </table>

            </div>
        </div>

        <!-- 맨밑하단 footer 영역  -->


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

</body>
</html>