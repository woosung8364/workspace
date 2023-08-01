<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">

<head>
<meta charset="utf-8">
<title>헤라 : 장바구니</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimal-ui">
<jsp:include page="/WEB-INF/views/modules/style-script.jsp" />
<script defer src="js/shopping.js"></script>
</head>

<body>
	<!-- 전체영역 -->
	<div id="wrap">

		<!-- 우측하단 버튼 모듈화 -->
		<jsp:include page="/WEB-INF/views/modules/option.jsp" />
		<!-- 사이드 메뉴 모듈화 -->
		<jsp:include page="/WEB-INF/views/modules/sidemenu.jsp" />
		<!-- header 영역 모듈화 -->
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		<!-- 쇼핑 페이지 시작 -->
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


  		<!--  더미데이터1 -->
         <!-- 상품 디테일 전체 영역 -->
         <div class="shop_product_detail">
         
         <!--  장바구니에 추가한 컨텐츠를 제거하는 x버튼 -->
         <a href="/" class="shopping_bag_close">
         </a>

          <!-- 상품이미지 컨텐츠 영역 -->
          <div class="shopping_bag_product_img">
            <!-- 상품 선택 버튼 -->
            <button class="shop_select_all_bt"></button>
          <!-- 상품이미지  -->
          <img src="/img/product1.jpg" alt="">
          </div>
          
          <!-- 상품 디테일 텍스트영역 -->
          <div class="shopping_bag_product_text">
            <!-- 제품명 -->
            <h1 class="shopping_bag_product_name">UV 프로텍터 액티브 선 밤 SPF 50+ / PA++++</h1>
            <!-- 수량선택 -->
  
            <div class="shopping_bag_product_count">
              <div class="shopping_bag_product_bt">
                <button class="shopping_bag_product_buy_now">바로구매하기</button>
              </div>
            </div>
          </div>
        </div>
    </div>
    <!-- 하단 제품가격을 계산해주는 flex 영역 -->
    <div class="shopping_bag_product_price">
      <div class="shopping_bag_product_price_wrap">
        <div class="shopping_bag_product_price_contents">
          <h1 class="shopping_bag_product_price_text">총 주문 금액 : 7,000원</h1>
        

        </div>
        <!-- 우측 총주문 버튼 -->
        <button class="shopping_bag_product_order_bt">총 주문하기</button>
      </div>
    </div>
  </div>
</body>
<jsp:include page="/WEB-INF/views/modules/footer.jsp" />