<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤라 : 마이페이지</title>
     <!-- 타이틀 옆에 표시되는 아이콘 링크 -->
     <jsp:include page="/WEB-INF/views/modules/style-script.jsp" />
     <script defer src="/js/id-check.js?v=<%=System.currentTimeMillis() %>"></script>
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
                <li><a href="">나의게시글</a></li>
                <li><a href="">1:1 문의</a></li>
            </ul>
        </div>

        <div class="mypage_right_wrap">
            <!-- 메인타이틀 : mypage -->
            <h1 id="mypage_title">My Board</h1>
            <p id="mypage_customer_name">${loginMember.name} 회원님의 게시글 목록 입니다</p>
            <div class="mypage_info_table">
                <h1>문의 내역</h1>
            <table>
                <thead>
                    <tr>
                        <td>No.</td>
                        <td>카테고리</td>
                        <td>제목</td>
                        <td>작성시간</td>
                        
                    </tr>
                </thead>

               
                <tbody>
                    <c:forEach items="${list}" var="board">
					<tr id="${board.no}">
						<td>${board.no}</td>
						<td>${board.category}</td>
						<td>${board.title}</td>
						<td>${board.writeDate}</td>
					</tr>
				</c:forEach>
                </tbody>
            </table>

       
<!-- 페이지 선택 버튼 -->
		<ul class="article_page_list my">

			<%-- 처음으로 보여주기 여부 --%>
			<c:if test="${pagination.showFirst}">
				<li class="article_page_list_previus"><a aria-label="First"
					onclick="doPP('1')"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>

			<%-- 이전 목록 보여주기 여부 --%>
			<c:if test="${pagination.showPrevious}">
				<li><a aria-label="Previous"
					onclick="doPP('${pagination.previousStartPage}')"> <span
						aria-hidden="true">&lt;</span>
				</a></li>
			</c:if>

			<%-- 목록 보여주기--%>
			<c:forEach var="i" begin="${pagination.startPage }"
				end="${pagination.endPage}">
				<c:choose>
					<c:when test="${i == pagination.params.requestPage}">
						<li><a>${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a onclick="doPP('${i}')">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<%-- 다음 목록 보여주기 여부 --%>
			<c:if test="${pagination.showNext}">
				<li><a aria-label="Next"
					onclick="doPP('${pagination.nextStartPage}')"> <span
						aria-hidden="true">&gt;</span>
				</a></li>
			</c:if>

			<%-- 마지막으로 보여주기 여부 --%>
			<c:if test="${pagination.showLast}">
				<li class="article_page_list_next"><a aria-label="First"
					onclick="doPP('${pagination.totalPages}')"> <span
						aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
		</ul>
		     </div>
        </div>
        <!-- 맨밑하단 footer 영역  -->


      </div>

      <!-- 메인페이지 최하단 footer 마무으리~! -->
      <jsp:include page="/WEB-INF/views/modules/footer.jsp" />

</body>
</html>