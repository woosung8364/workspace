<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤라 : 마이페이지</title>
     <!-- 타이틀 옆에 표시되는 아이콘 링크 -->
     <jsp:include page="/WEB-INF/views/modules/style-script.jsp" />
</head>
<body>
     

      <!-- 헤더 전체 영역 -->
   <jsp:include page="/WEB-INF/views/modules/header.jsp" />

      <!-- 헤더 밑 mypage 전체영역을 감싸는 div -->
      <div class="mypage_wrap">
        <!-- 좌측 네비게이션 전체영역 -->
        <div class="mypage_left_wrap">
            <!-- 텍스트칸의 위치를 지정하기 위한 ul -->
            <ul class="mypage_left_text">
                <li><a href="">개인정보</a></li>
                <li><a href="${path}/shopping">장바구니</a></li>
                <li><a href="">주문현황</a></li>
                <li><a href="${path}/myarticle">나의게시글</a></li>
                <li><a href="">1:1 문의</a></li>
            </ul>
        </div>

        <div class="mypage_right_wrap">
            <!-- 메인타이틀 : mypage -->
            <h1 id="mypage_title">My Page</h1>
            <p id="mypage_customer_name">${loginMember.name} 회원님의 페이지 입니다</p>
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
      <jsp:include page="/WEB-INF/views/modules/footer.jsp" />

</body>
</html>