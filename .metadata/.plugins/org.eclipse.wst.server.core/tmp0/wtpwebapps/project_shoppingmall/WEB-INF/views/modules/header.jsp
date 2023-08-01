<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 헤더 전체 영역 -->
       <header>

        <!-- 컨텐츠 가운데 정렬을 위한 영역2 -->
        <div class="header_wrap cont_wrap">
          <a href="#" class="mob_nav_btn">
            <i></i>
          </a>
          
          <!-- 로고 이미지 -->
          <h1 class="logo">
            <a href="/">
              <img src="/img/hera_logo.png" alt="logo">
            </a>
          </h1>

          <!-- 매장찾기 / 구매하기 / 검색아이콘 -->
          <div class="header_links">

            <!-- 로그인버튼 -->
            <c:choose>
			<c:when test="${empty loginMember}">
            <a href="${path}/login" data-bs-auto-close="outside" data-bs-toggle="dropdown">
              <i class="fa-solid fa-user"></i>
            </a>
			</c:when>
			<c:otherwise>
			<a href="${path}/member/signin" data-bs-auto-close="outside" data-bs-toggle="dropdown"> 
           <i class="fa-solid fa-right-from-bracket" style="font-size: 15px;"></i></a>
			<a href="${path}/mypage" data-bs-auto-close="outside">
			<i class="fa-solid fa-user"></i></a>
			</c:otherwise>
            </c:choose>
          <!-- 검색버튼 -->
            <a href="#" class="h_open_search">
              <i class="icon-search"></i>
            </a>
          </div>
          <!-- 검색 아이콘 클릭시 나타나는 영역 -->
          <div id="top_search" class="search_container ">
            <div class="top_search_bg"></div>
            <form action="header_top_search">
              <div class="search_wrap">
                <label for="h_search" class="blind">검색</label>
                <input type="search" name="h_search" id="h_search" class="text"  autofocus>
                <button class="submit">
                  <i class="icon-search"></i>
                </button>
                <!-- 검색버튼을 종료하기위한 X ICON -->
                <a href="#" class="sch_close">
                  <img src="/img/bu_x.png" alt="x">
                </a>
              </div>
            </form>
          </div>
        </div>
      </header>