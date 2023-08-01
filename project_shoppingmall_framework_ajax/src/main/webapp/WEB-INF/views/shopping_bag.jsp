<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>헤라 : 장바구니</title>
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
  <script defer src="js/shopping.js"></script>
</head>

<body>

  <!-- 전체영역 -->
  <div id="wrap">
    
    <!-- 헤더 전체 영역 -->
     <header id="shopping_header">

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




    <!-- 쇼핑 페이지 시작 -->
    <div class="shopping_page">
      <!-- 장바구니 텍스트 -->
      <div class="shop_text">
        <h2>장바구니</h2>
      </div>

      <!-- 전체선택 -->
      <div class="shop_select">
        <!-- 전체선택 : 버튼 -->
        <button class="shop_select_all_bt"></button>
        <!-- 전체선택 : 텍스트 -->
        <h2 id="shop_select_all">전체선택</h2>
      </div>

      <!-- 상품디테일 (innerHTML) -->

      <div class="shop_product_detail">
        <button class="shop_select_all_bt"></button>
        <!-- 상품이미지  -->
        <img src="img/product1.jpg" alt="">

        <!-- 상품 디테일 문구 -->
        <div class="product_text">
          <!-- 제품명 -->
          <h1 class="product_name">UV 프로텍터 액티브 선 밤 SPF 50+ / PA++++</h1>
          <!-- 수량선택 -->

          <div class="product_count">
            <span>제품 수량 :</span>
            <select id="product_select_count">
              <option value="1" selected>1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>
            <div class="product_bt">
              <button class="product_change_count">옵션/수량 변경</button>
              <button class="product_buy_now">바로구매</button>
            </div>
          </div>
        </div>
      </div>

    </div>





    <!-- 하단 제품가격을 계산해주는 flex 영역 -->
    <div class="product_price">
      <div class="product_price_wrap">
        <div class="product_price_contents">
          <h1 class="product_price_text">총 주문 금액 : 7,000원</h1>

          <img src="img/product_price_bt.png"  class="ppti">
          
          <div class="ppti_clicked">
            <h2 class="ppti_price">주문금액 상세내역</h2>
            <div class="ppti_price_math">
              <p>총 상품 선택 금액 :       <span class="ppti_price">&nbsp;&nbsp;36000원</span></p>
              <p>총 배송비  :       <span class="ppti_price">&nbsp;&nbsp;+2500원</span></p>
              <p>할인 예상 금액  :      <span class="ppti_price discount">&nbsp;&nbsp;-27000원</span></p>
            </div>
            <div class="total_price">
              <h1>총 주문 금액</h1>
              <h1>11,500원</h1>
            </div>
          </div>

        </div>
        <!-- 우측 총주문 버튼 -->
        <button class="product_order_bt">총 주문하기</button>
      </div>
    </div>












  </div>
</body>