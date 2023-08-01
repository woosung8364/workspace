<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>헤라 : 게시판</title>
<jsp:include page="/WEB-INF/views/modules/style-script.jsp" />
<script defer src="/js/id-check.js"></script>
</head>

<body>
	<!-- 우측하단 버튼 모듈화 -->
	<jsp:include page="/WEB-INF/views/modules/option.jsp" />
	<!-- 사이드 메뉴 모듈화 -->
	<jsp:include page="/WEB-INF/views/modules/sidemenu.jsp" />
	<!-- header 영역 모듈화 -->
	<jsp:include page="/WEB-INF/views/modules/header.jsp" />

	<!-- 게시판 전체영역-->
	<div class="article_wrap">

		<a href="${path}/article" class="article_main_text">게시판</a>

		<!-- 상단 메뉴 -->
		<%
		String requestPage = request.getParameter("page");
		%>
		<ul class="article_menu">
			<li id="notice" onclick="doT('${requestPage}')">Notice</li>
			<li id="FAQ" onclick="doT('${requestPage}')">FAQ</li>
			<li id="QnA" onclick="doT('${requestPage}')">QnA</li>
			<li id="normal" onclick="doT('${requestPage}')">자유게시판</li>
		</ul>


		<!-- 게시판 테이블 -->
		<table class="article_table">
			<thead>
				<!-- 테이블 제목 -->
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
		<ul class="article_page_list">

			<%-- 처음으로 보여주기 여부 --%>
			<c:if test="${pagination.showFirst}">
				<li class="article_page_list_previus" onclick="doP('1')">
				<a aria-label="First"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>

			<%-- 이전 목록 보여주기 여부 --%>
			<c:if test="${pagination.showPrevious}">
				<li onclick="doP('${pagination.previousStartPage}')"><a aria-label="Previous">
				<span aria-hidden="true">&lt;</span>
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
						<li  onclick="doP('${i}')"><a>${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<%-- 다음 목록 보여주기 여부 --%>
			<c:if test="${pagination.showNext}">
				<li onclick="doP('${pagination.nextStartPage}')"><a aria-label="Next">
				<span aria-hidden="true">&gt;</span>
				</a></li>
			</c:if>

			<%-- 마지막으로 보여주기 여부 --%>
			<c:if test="${pagination.showLast}">
				<li class="article_page_list_next" onclick="doP('${pagination.totalPages}')">
				<a aria-label="First">
				<span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
		</ul>
		<!-- 글쓰기 버튼 -->
		<c:choose>
			<c:when test="${empty loginMember}">
				<button type="button" class="article_page_write_bt">
					<a href="${path}/cart">문의하기</a></button>
			</c:when>
			<c:otherwise>
				<button type="button" class="article_page_write_bt">
					<a href="${path}/QnA">문의하기</a></button>
			</c:otherwise>
		</c:choose>

	
	</div>

</body>

</html>