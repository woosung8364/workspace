<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>헤라 | 빈틈없이 밀착되는 맑은 컬러감</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimal-ui">
<!-- style, script 모듈화 -->
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

		<!-- SECTION1 메인화면 영역 -->
		<div class="visual">
			<!-- 이미지 좌우측에 있는 뒤로가기 , 앞으로가기 버튼 -->
			<button class="visu_arrow left">left</button>
			<button class="visu_arrow right">right</button>
			<!-- 슬라이드 되는 이미지를 감싸는 전체영역 -->
			<ul class="visual_wrap">
				<!-- 슬라이드 되는 메인이미지 컨텐츠1 -->
				<li class="visu_slide">
					<div class="visu_veil"></div>
					<div class="visu_txt_wrap">
						<div class="visu_txt_cont">
							<div class="visu_txt_cont_cell">
								<h1>처음 바른 그대로 매끈한 실키 스킨</h1>
								<p>실키 스테이 파운데이션</p>
								<div class="visu_btn_wrap">
									<a href="#" class="btn_view">자세히 보기</a> <a href="#"
										class="btn_view">구매하러 가기</a>
								</div>
							</div>
						</div>
					</div>
				</li>

				<!-- 슬라이드 되는 메인이미지 컨텐츠2 -->
				<li class="visu_slide">
					<div class="visu_veil"></div>
					<div class="visu_txt_wrap">
						<div class="visu_txt_cont">
							<div class="visu_txt_cont_cell">
								<h1>광채를 되찾아주는 피치빛 생기 톤업</h1>
								<p>UV 프로텍터 톤업 SPF50+ / PA+++</p>
								<div class="visu_btn_wrap">
									<a href="#" class="btn_view">자세히 보기</a> <a href="#"
										class="btn_view">구매하러 가기</a>
								</div>
							</div>
						</div>
					</div>
				</li>

				<!-- 슬라이드 되는 메인이미지 컨텐츠3 -->
				<li class="visu_slide">
					<div class="visu_veil"></div>
					<div class="visu_txt_wrap">
						<div class="visu_txt_cont">
							<div class="visu_txt_cont_cell">
								<h1>나다운 피부 표현의 완성</h1>
								<p>블랙 쿠션 & 스킨 래디언트 글로우 쿠션</p>
								<div class="visu_btn_wrap">
									<a href="#" class="btn_view">자세히 보기</a> <a href="#"
										class="btn_view">구매하러 가기</a>
								</div>
							</div>
						</div>
				</li>
			</ul>

			<!-- 컨텐츠 하단 - 이미지 순서를 나타내는 네비게이션 버튼 -->
			<ul class="visu_btm_wrap">
				<!-- 해당 이미지로 이동하면 li에 class ="act" 가 자동으로 붙으면서 검은색버튼이 길어짐 -->
				<li><a href="#">btn01</a></li>
				<li><a href="#">btn02</a></li>
				<li><a href="#">btn03</a></li>

				<!-- 슬라이드 재생/정지 기능을 제어하기 위한 버튼 -->
				<li class="controls_wrap">
					<button class="control start">start</button>
					<button class="control stop">stop</button>
				</li>
			</ul>
		</div>
	</div>


	<!-- 섹션2 : Today's Hot Menu 제품소개 영역 -->
	<div class="content">
		<!-- 컨텐츠의 위치를 제어하기위한 전체영역 -->
		<div class="recommend">
			<!-- Today’s Hot Menu 텍스트 -->
			<h2 class="cont_title ct1">SILKY STAY FOUNDATION</h2>
			<!-- choice - 선택한 메뉴의 카테고리에 맞는 제품의 이미지가 출력됨 -->
			<!-- 제품 이미지들의 위치를 제어하기위한 영역 -->
			<div class="recom_list_wrap">
				<!-- 유튜브 비디오 -->
				<div class="video_wrap">
					<iframe class="video img-h" width="560" height="315"
						src="https://www.youtube.com/embed/eTdfSRK55Hk"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
				</div>


			</div>
		</div>
	</div>
	<!-- 섹션3 : Product : 상품목록 -->
	<div class="product">
		<h2 class="product_main_title">상품목록</h2>
		<c:forEach items="${product}" var="product" varStatus="status">
			<c:if test="${status.index % 3 == 0}">
				<!-- 새로운 행 시작 -->
				<div class="product_wrap">
			</c:if>

			<!-- 1줄 innerHTML -->
			<div class="product_list">
				<a href="${path}/detail?proName=${product.proName}"> <c:forEach
						items="${product.imgUrlList}" var="imageUrl">
						<img src="${imageUrl}" alt="ProductImage">
					</c:forEach>
				</a>
				<h1 class="product_name">${product.proName}</h1>
			</div>

			<c:if test="${status.index % 3 == 2 || status.last}">
				<!-- 행 닫기 -->
	</div>
	</c:if>
	</c:forEach>
	</div>
	<!-- 섹션3 -->
	<div class="with">
		<!-- 화면 상단 가운대에 위치한 메인 텍스트 -->
		<h2 class="cont_title ct2">BEST ITEM</h2>
		<!-- 메인텍스트 바로 밑에 위치한 서브 텍스트 -->
		<span class="with_txt"> <i class="icon-instagram"></i> Check
			Instagram
		</span>

		<!-- 이미지 전체 영역 -->
		<div class="with_list_wrap">
			<!-- 이미지 전체 영역2 : Ul -->
			<ul class="with_list">

				<!-- 이미지 컨텐츠 1 -->
				<li class="w_list01"><a href="/" class="img_holder">0</a> <!-- 이미지를 hover 했을때 밑에서부터 올라오는 Text 영역 -->
					<div class="info_holder">
						<!-- 올라온 text 영역 배경 -->
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                    <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                  </svg>
						<!-- @ hover : 메인텍스트 -->
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera</a>
							</div>
							<!-- hover : 서브텍스트 -->
							<div class="user_caption">센슈얼 글로우 피팅 틴트</div>
						</div>
					</div></li>

				<!-- 이미지 컨텐츠 2 -->
				<li class="w_list02"><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                    <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                  </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera</a>
							</div>
							<div class="user_caption">센슈얼 파우더 매트 리퀴드</div>
						</div>
					</div></li>

				<!-- 이미지 컨텐츠 3 -->
				<li class="w_list03"><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                    <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                  </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera</a>
							</div>
							<div class="user_caption">실키 스테이 24H 롱웨어 파운데이션</div>
						</div>
					</div></li>

				<!-- 이미지 컨텐츠 4 -->
				<li class="w_list04"><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                    <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                  </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera</a>
							</div>
							<div class="user_caption">UV 프로텍터 액티브 선 밤</div>
						</div>
					</div></li>


			</ul>
		</div>
	</div>


	<!-- 섹션4 : 중앙 배너 -->
	<div class="mid_banner">
		<div class="text_contents">
			<h2 class="mid_banner_maintext">베스트 셀러</h2>
			<p class="mid_banner_subtext">
				건강하게 빛나고 힘있게 채우는<br> 헤라의 시그니처 케어
			</p>
			<button class="mid_banner_bt">
				<a href="#">더보기</a>
			</button>
		</div>
	</div>





	<!-- 섹션 5 : 제품 소개 페이지 -->
	<div class="perfume" id="index_content">
		<!-- 제품소개 . 텍스트영역 -->
		<div class="perfume_wrap pw01">

			<!-- 제품사진 -->
			<div class="perfume_img">
				<a href="#"> <img src="/img/hera/화장품/틴트/틴트2_상세3.jpg" alt="01">
				</a>
			</div>


			<!-- 제품 설명 : 텍스트영역 -->
			<div class="perfume_txt">
				<h3 class="perfume_main_txt"># HERA LOVERS PICK!</h3>
				<p class="perfume_sub_txt">
					어느 각도에서나 빈틈없이 <br> 반짝이는 GLAZED 글로우
				</p>
				<div class="desc">NEW SENSUAL FITTING GLOW TINT</div>

				<div class="btn_wrap">
					<a href="#" class="btn_view">자세히 보러가기</a>
				</div>
			</div>

			<!-- 제품상세페이지로 이동하기 위한 버튼 -->

		</div>



		<!-- 제품2 . 소개페이지 전체영역 -->
		<div class="perfume_wrap pw02">

			<!-- 제품사진 -->
			<div class="perfume_img">
				<a href="#"> <img src="/img/hera/lv5.jpg" alt="01">
				</a>
			</div>


			<!-- 제품 설명 : 텍스트영역 -->
			<div class="perfume_txt">
				<h3 class="perfume_main_txt">WHAT'S NEW?</h3>
				<p class="perfume_sub_txt">
					일상에서의 강력하고<br> 세심한 선케어를 위한<br> 클린 포뮬라의 수분 선 밤
				</p>
				<div class="desc">UV 프로텍터 액티브 선 밤</div>

				<div class="btn_wrap">
					<a href="#" class="btn_view">자세히 보러가기</a>
				</div>
			</div>
		</div>
	</div>



	<!-- 섹션7 : 커뮤니티 , 인스타그램 -->
	<div class="culture">
		<!-- 컨텐츠 전체영역 -->
		<div class="content">
			<a href="#" class="content_img"> <img src="/img/hera_logo2.png" alt="">
			</a>
			<!-- 서브 텍스트1 -->
			<p class="culture_txt">
				Share your #HERA moments!
				<!-- 서브 텍스트2 -->
				<span> <i class="icon-instagram"></i> 인스타그램에서 Hera 를 방문해보세요
				</span>
			</p>
			<!-- 이미지 컨텐츠 구획 -->
			<ul class="culture_list cfix">
				<!-- 이미지1 -->
				<li>
					<!-- a태그에 css를 통해 이미지를 적용하였음 --> <a href="#" class="img_holder">0</a>
					<!-- 이미지를 호버했을시 나오는 컨텐츠 -->
					<div class="info_holder">
						<!-- 호버했을때 나오는 컨텐츠의 배경 -->
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<!-- hover : 컨텐츠 텍스트1-->
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<!-- hover : 컨텐츠 텍스트2 -->
							<div class="user_caption">엑스커베이션 블랙 쿠션</div>
						</div>
					</div>

				</li>

				<!-- 이미지2 -->
				<li><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<div class="user_caption">센슈얼 피팅 글로우 틴트</div>
						</div>
					</div></li>

				<!-- 이미지3 -->
				<li><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<div class="user_caption">센슈얼 피팅 글로우 틴트</div>
						</div>
					</div></li>

				<!-- 이미지4 -->
				<li><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<div class="user_caption">센슈얼 파우더 매트 리퀴드</div>
						</div>
					</div></li>

				<!-- 이미지5 -->
				<li><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<div class="user_caption">UV 프로텍트 액티브 선 밤</div>
						</div>
					</div></li>

				<!-- 이미지6 -->
				<li><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<div class="user_caption">센슈얼 파우더 매트 리퀴드</div>
						</div>
					</div></li>

				<!-- 이미지7 -->
				<li><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<div class="user_caption">엑스커베이션 에디팅 박스</div>
						</div>
					</div></li>

				<!-- 이미지8 -->
				<li><a href="#" class="img_holder">0</a>
					<div class="info_holder">
						<svg viewBox="0 -5 240 51" preserveAspectRatio="none">
                  <path
								d="M120,0c82.1,0,100.6,39.2,120,39.2c0,0.7,0,3.6,0,6.7c-23.6,0-194.8,0-240,0c0-2.7,0-4.1,0-6.7C14,39.2,37.9,0,120,0z"></path>
                </svg>
						<div class="info_content">
							<div class="user_handle">
								<a href="#">@Hera-Instagram</a>
							</div>
							<div class="user_caption">루즈 홀릭</div>
						</div>
					</div></li>
			</ul>
		</div>
	</div>

	<!-- footer 영역-->
	<jsp:include page="/WEB-INF/views/modules/footer.jsp" />


</body>
</html>
