<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>

<head>
  <title>헤라 : 구매하기</title>
  <!-- 여기에 필요한 CSS를 포함시킬 수 있습니다. -->

  <!-- 타이틀 옆에 표시되는 아이콘 링크 -->
  <link rel="shortcut icon" type="image/x-icon" href="img/favicon1.ico">

  <!-- 폰트어썸 icon 적용을 위한 link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />

  <!-- css 스타일시트 적용 -->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/order.css">
  <!-- script -->
  <script defer src="js/lib/jquery-3.1.1.min.js"></script>
</head>

<body>

  <!-- 헤더 전체 영역 -->
  <header class="order_header">

    <!-- 컨텐츠 가운대 정렬을 위한 영역2 -->
    <div class="header_wrap cont_wrap">
      <!-- 로고 이미지 -->
      <h1 class="logo">
        <a href="#">
          <img src="img/hera_logo.png" alt="logo">
        </a>
      </h1>


    </div>
  </header>

  <!-- 메인타이틀 -->
  <h2 class="order_main_title">구매하기</h2>


  <div class="order_wrap">
    <div class="order_contents">
      <!-- 최근 주문 목록 -->
      <h1 class="order_recent">
        결제정보
      </h1>

      <div class="order_information">
        <div class="order_info_title">
        <h2 id="order_id">결제(주문)번호</h2>
        <h2 id="order_name">주문자 성함</h2>
        <h2 id="order_address">주문자 주소</h2>
        <h2 id="order_tel">연락처</h2>
        <h2 id="order_payway">결제수단</h2>
      </div>
      <div class="order_info_detail">
        <p id="order_id_detail">3284901284901</p>
        <p id="order_name_detail">홍길동</p>
        <p id="order_address_detail">홍길동</p>
        <p id="order_tel_detail">010 8282 1004</p>
        <p id="order_payway">신용카드</p>
      </div>
      </div>

      <!-- 결제수단 체크박스 -->
      <div class="order_check">

        <!-- 신용 / 체크카드 -->
        <label for="way_card">
          <input type="checkbox" name="way_card" id="way_card">
          <p>신용 / 체크카드</p>
        </label>

        <!-- 온라인 이체 -->
        <label for="way_card">
          <input type="checkbox" name="way_online" id="way_online">
          <p>온라인 이체</p>
        </label>

        <!-- 기타 -->
        <label for="way_else">
          <input type="checkbox" name="way_else" id="way_else">
          <p>기타</p>
        </label>
      </div>

      <!-- 결제방법 전체영역 -->
      <div class="order_way_list_wrap">
        <div class="order_way_list">

          <!-- 결제종류 -->
          <div class="order_way_type">
            <h2>종류창</h2>
            <!-- 결제종류 : select -->
            <select name="order_way_type_select" class="order_type_select owts1">
              <option value="kb">국민카드</option>
              <option value="shinhan">신한카드</option>
              <option value="mom">엄마카드</option>
              <option value="father">아빠카드</option>
              <option value="corporation">법인카드</option>
            </select>
          </div>

          <!-- 카드번호 -->
          <div class="order_way_type">
            <h2>카드번호</h2>
            <input type="text" name="credit_number" id="credit_number" placeholder="카드번호를 입력해주세요">
          </div>

          <!-- 할부여부 -->
          <div class="order_way_type">
            <h2>할부여부</h2>
            <!-- 할부여부 : select -->
            <select name="order_way_type_select" class="order_type_select">
              <option value="kb">일시불</option>
              <option value="12m">12개월 할부</option>
              <option value="24m">24개월 할부</option>
            </select>
          </div>

        </div>
      </div>

      <div class="order_all_price">
        <h1>총 금액 : 32000 (원) </h1>
        <button class="order_pay" onclick="openModal()">결제하기</button>
      </div>

      <!-- 모달 창 -->
      <div id="myModal" class="modal">
        

        <div class="modal_bt">
          <h2>결제하시겠습니까?</h2>
        <button class="yes"><a href="order_result.html">YES</a></button>
        <button class="close_modal" onclick="closeModal()">닫기</button>
      </div>
      </div>

      <!-- 필요한 JavaScript 코드 -->
      <script>
        // 모달 열기
        function openModal() {
          var modal = document.getElementById("myModal");
          modal.style.opacity= 1;
        }

        // 모달 닫기
        function closeModal() {
          var modal = document.getElementById("myModal");
          modal.style.opacity=0;
        }
      </script>
</body>

</html>