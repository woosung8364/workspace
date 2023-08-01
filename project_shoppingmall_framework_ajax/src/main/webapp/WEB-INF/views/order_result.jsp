<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>헤라 : 주문완료</title>
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
   <header class="order_header">

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

  <!-- 컨텐츠 전체를 감싸는 전체영역 -->
  <div class="order_result_wrap">
    <!-- 주문완료 메인텍스트 -->
    <h1 class="order_success_text">주문이 완료되었습니다</h1>
 
    <!-- 완료명세 전체영역 -->
    <div class="order_result_contents">

      <!-- 컨텐츠 : 텍스트 영역 -->
      <div class="order_result_text">
        <h1>주문자 성함 :               <span>&nbsp;&nbsp;홍길동</span></h1>
        <h1>주문 목록 :                 <span>&nbsp;&nbsp;iphone15 Pro Max</span></h1>
        <h1>배송지 :                    <span>&nbsp;&nbsp;Ezen 초등학교</span></h1>
        <h1>결제 금액 :                 <span>&nbsp;&nbsp;10,000(원)</span></h1>
      </div>
    </div>
   
  </div>

<button class="order_result_goHome"><a href="index.html">홈으로</a></button>

  

</div>
</body>
</html>