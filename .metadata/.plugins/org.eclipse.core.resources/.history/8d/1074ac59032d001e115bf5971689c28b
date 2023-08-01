<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>헤라 : 자유게시판</title>
<jsp:include page="/WEB-INF/views/modules/style-script.jsp" />
<script defer src="js/lib/jquery-3.1.1.min.js"></script>
<script defer src="/js/id-check.js"></script>
</head>

<body class="comment">
	<!-- 헤더 전체 영역 -->
	<!-- 우측하단 버튼 모듈화 -->
	<jsp:include page="/WEB-INF/views/modules/option.jsp" />
	<!-- 사이드 메뉴 모듈화 -->
	<jsp:include page="/WEB-INF/views/modules/sidemenu.jsp" />
	<!-- header 영역 모듈화 -->
	<jsp:include page="/WEB-INF/views/modules/header.jsp" />

	<!-- 메인 타이틀 -->
	<h2 class="comment_main_title">자유게시판</h2>

	<!-- 게시판 컨텐츠 전체영역 -->
	<div class="comment_wrap">


		<!-- 글쓰기 전체영역 -->
		<div class="comment_write">
			<form action="${path}/comments" method="post">
				<!-- 글쓰기 텍스트 공간 -->
				<textarea name="comment_write_contents" id="write_contents"
					class="write_textarea" cols="30" rows="10" placeholder="로그인 하여야 게시글을 입력할 수 있습니다...." required
					<c:if test="${empty loginMember}">disabled</c:if>></textarea>
				<!-- 글쓰기 버튼 -->
				<button type="submit" class="comment_wirte_bt" id="write_contents">글쓰기</button>
				
			</form>
		</div>

		<!-- 남긴 댓글을 출력하는영역 innerHTML -->
		<c:forEach items="${list}" var="board">
			<div class="comment_record">
				<!-- 사용자 이름과 날짜 표시  H2 태그안에 이름,  Span 태그안에  날짜 -->
				<h2 class="comment_title">${board.memberName}
					<span class="comment_title_date">${board.writeDate}</span>
				</h2>

				<!-- 댓글 내용에 해당하는 부분입니다  -->
				<div class="comment_content">${board.content}</div>
			</div>
		</c:forEach>
	</div>

	<!-- 페이지 선택 버튼 -->
	<ul class="article_page_list">

		<%-- 처음으로 보여주기 여부 --%>
		<c:if test="${pagination.showFirst}">
			<li class="article_page_list_previus" onclick="doP('1')"><a
				aria-label="First"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>

		<%-- 이전 목록 보여주기 여부 --%>
		<c:if test="${pagination.showPrevious}">
			<li onclick="doP('${pagination.previousStartPage}')"><a
				aria-label="Previous"> <span aria-hidden="true">&lt;</span>
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
					<li onclick="doP('${i}')"><a>${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<%-- 다음 목록 보여주기 여부 --%>
		<c:if test="${pagination.showNext}">
			<li onclick="doP('${pagination.nextStartPage}')"><a
				aria-label="Next"> <span aria-hidden="true">&gt;</span>
			</a></li>
		</c:if>

		<%-- 마지막으로 보여주기 여부 --%>
		<c:if test="${pagination.showLast}">
			<li class="article_page_list_next"
				onclick="doP('${pagination.totalPages}')"><a aria-label="First">
					<span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
	</ul>

</body>

</html>