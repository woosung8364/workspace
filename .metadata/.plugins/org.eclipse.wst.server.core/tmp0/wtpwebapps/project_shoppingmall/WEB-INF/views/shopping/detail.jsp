<%@page import="ezen.shoppingmall.domain.member.dto.Member"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ezen.shoppingmall.domain.product.dto.Product"%>
<%@page import="ezen.shoppingmall.domain.common.factory.ServiceFactory"%>
<%@page import="ezen.shoppingmall.domain.product.service.ProductService"%>
<%@page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<meta charset="UTF-8">
<title>헤라 | 빈틈없이 밀착되는 맑은 컬러감</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimal-ui">
<jsp:include page="/WEB-INF/views/modules/style-script.jsp" />
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

		<!-- 이미지와 텍스트를 모두 감싸기위한 div : position - relative  -->
		<div class="content_wrap">

			<!-- 이미지를 감싸기 위한 div : position - absolute -->

			<div class="prd_img">
				<div class="prd_img_wrap">
					<img src="${imageUrl}">
				</div>
			</div>

			<!-- 텍스트를 감싸기 위한 div : position - absolute -->
			<div class="prd_primary_wrap">
				<div class="prd_primary">
					<h1 class="prd_name">${product.getProName()}</h1>
					<br>
					<h1>${formattedPrice}원</h1>
					<div class="capacity">상세정보</div>
					<h2 class="prd_desc">${product.getProInfo()}</h2>
					<div class="go_review">
						<a href="#" class="cta_underline review" ap-click-area="Product"
							ap-click-name="Click - Review"
							ap-click-data="SENSUAL POWDER MATTE LIQUID">제품 리뷰 보기 </a>
							<select name="prd_select" class="prd_select_count">
							<option value="1" selected>갯수를 선택해주세요</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>

					<div class="sticky_inner">
						<a href="${path}/cart" id="xAP">장바구니 담기</a>
						<a id="xAP">상품 구매하기</a>

					</div>
				</div>
			</div>
		</div>

		<!-- footer 영역-->
		<jsp:include page="/WEB-INF/views/modules/footer.jsp" />
	</div>


</body>
</html>