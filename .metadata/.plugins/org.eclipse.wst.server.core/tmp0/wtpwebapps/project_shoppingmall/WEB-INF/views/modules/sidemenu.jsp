<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 메뉴버튼 클릭시 왼쪽에서 펼쳐지는 영역- -->
      <nav class="mob_nav ">
        <div class="m_nav_bg"></div>
        <div class="m_nav_wrap">
          <h2>
            <a href="#">
              <img src="img/hera_logo.png" alt="logo">
            </a>
          </h2>
          <!-- m_nav_list  m_list_tit  icon_nav  blind-->
          <ul class="m_nav_list">
            <li>
              <a href="#" class="m_list_tit">Brand</a>
            </li>
            <li>
              <a href="#" class="m_list_tit">
                제품
                <i class="icon_nav"></i>
              </a>
              <dl>
                <dt class="blind">제품</dt>
                <dd><a href="#best">BEST ITEM</a></dd>
                <dd><a href="#">HOT ITEM</a></dd>
                <dd><a href="#new">NEW ITEM</a></dd>
                <dd><a href="#">화장품</a></dd>
                <dd><a href="#">스킨케어</a></dd>
              </dl>
            </li>
            <li>
              <a href="#" class="m_list_tit">
                이벤트
                <i class="icon_nav"></i>
              </a>
              <dl>
                <dt class="blind">진행중인이벤트</dt>
                <dd><a href="#">종료된 이벤트</a></dd>
                <dd><a href="#">당첨자 발표</a></dd>
              </dl>
            </li>
            <li>
              <a href="${path}/article" class="m_list_tit">
                고객센터
              </a>
            </li>
          </ul>
          <div class="m_nav_btm">
            <div class="m_nav_sitemap">
              <a href="${path}/login">로그인</a>
              <a href="${path}/membership">회원가입</a>
            </div>
            <div class="m_copy">
              © AMOREPACIFIC CORPORATION. All rights reserved.
            </div>
          </div>
        </div>
      </nav>