<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String loginId = (String) session.getAttribute("loginId");
String loginName = (String) session.getAttribute("loginName");
%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<!-- font icon : font awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- slick -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
	integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css"
	integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/app.css">
<title>My Portfolio</title>
</head>

<body>

	<!-- <h1 class="display-1"><i class="fas fa-home"></i> hello world</h1> -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light py-3 shadow-lg sticky-top">
		<div class="container">
			<a href="#" class="navbar-brand align-middle">
				<h3 class="m-0">
					<img src="images/logo.png" alt="Logo" height="38px"> My
					Portfolio Web
				</h3>
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a href="#top" class="nav-link">Home</a>
					</li>
					<li class="nav-item"><a href="#intro" class="nav-link">Intro</a>
					</li>
					<li class="nav-item"><a href="#services" class="nav-link">Services</a>
					</li>
					<li class="nav-item"><a href="#slogan" class="nav-link">Slogan</a>
					</li>
					<li class="nav-item"><a href="#gallery" class="nav-link">Gallery</a>
					</li>
					<li class="nav-item"><a href="#contact" class="nav-link">Contact</a>
					</li>
					<li class="nav-item"><a href="#find-us" class="nav-link">Find
							us</a></li>
							
							
					<li class="nav-item"><a
						href=" <c:url value="/member/register.jsp"/>" class="nav-link">Member
							List</a></li>
							
					<li class="nav-item"><a
						href=" <c:url value="/member/register.jsp"/>" class="nav-link">Sign
							In</a></li>
							
					<li class="nav-item">
						<%-- 로그인 버튼  --%> 
						<c:choose>
							<c:when test="${empty loginId}">
								<a class="btn btn-primary"
									href="<c:url value="/member/login.jsp"/>">로그인</a>
							</c:when>
							<c:otherwise>
							${loginId}(${loginName})님 행복한 하루 되세요...
							<a class="btn btn-warning"
									href="<c:url value="/member/logout-action.jsp"/>">로그아웃</a>
							</c:otherwise>
						</c:choose>

					</li>

				</ul>
			</div>
		</div>
	</nav>

	<section id="top">
		<div
			class="section-content overlay d-flex justify-content-center align-items-center">
			<div class="container-xxl">
				<div class="row align-items-center">
					<div class="col-md-9 welcome">
						<h1 class="welcome-title fw-right">
							Welcome to <span class="text-warning fw-bold">my portfilio</span>.
							Lorem ipsum dolor sit amet consectetur adipisicing elit.
						</h1>
						<div class="row welcome-desc">
							<p class="col-sm-10 col-md-12 lead">Lorem ipsum dolor sit
								amet, consectetur adipisicing elit. Eos, doloribus excepturi
								velit enim alias facere saepe cupiditate fugiat nesciunt vero.</p>
							<p class="col-sm-2 col-md-12">
								<a href="#" class="btn btn-primary">Read more</a>
							</p>
						</div>
					</div>
					<div class="col-md-3 d-none d-md-block letsgo">
						<div class="card card-body letsgo-card">
							<div class="letsgo my-3">
								<h4 class="letsgo-title card-title text-dark mb-3">Easy
									contact!</h4>
								<p class="card-text text-secondary">Lorem ipsum dolor sit,
									amet consectetur adipisicing elit. Veritatis, quia.</p>
							</div>
							<div class="letsgo-card-form">
								<form>
									<div class="mb-3">
										<input type="text" class="form-control"
											placeholder="Your name">
									</div>
									<div class="mb-3">
										<input type="tel" class="form-control"
											placeholder="Your phone">
									</div>
									<div class="form-check mb-3">
										<input type="checkbox" class="form-check-input"
											id="flexCheckDefault"> <label for="flexCheckDefault"
											class="form-check-label text-secondary">I agree to
											provide privacy</label>
									</div>
									<p class="mb-3">
										<button class="btn btn-primary w-100" type="button">Submit</button>
									</p>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
		integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="js/app.js"></script>
</body>

</html>