/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-28 05:15:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mypage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>헤라 : 마이페이지</title>\r\n");
      out.write("     <!-- 타이틀 옆에 표시되는 아이콘 링크 -->\r\n");
      out.write("     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/modules/style-script.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("      <!-- 헤더 전체 영역 -->\r\n");
      out.write("   ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/modules/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- 헤더 밑 mypage 전체영역을 감싸는 div -->\r\n");
      out.write("      <div class=\"mypage_wrap\">\r\n");
      out.write("        <!-- 좌측 네비게이션 전체영역 -->\r\n");
      out.write("        <div class=\"mypage_left_wrap\">\r\n");
      out.write("            <!-- 텍스트칸의 위치를 지정하기 위한 ul -->\r\n");
      out.write("            <ul class=\"mypage_left_text\">\r\n");
      out.write("                <li><a href=\"\">개인정보</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shopping\">장바구니</a></li>\r\n");
      out.write("                <li><a href=\"\">주문현황</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/myarticle\">나의게시글</a></li>\r\n");
      out.write("                <li><a href=\"\">1:1 문의</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"mypage_right_wrap\">\r\n");
      out.write("            <!-- 메인타이틀 : mypage -->\r\n");
      out.write("            <h1 id=\"mypage_title\">My Page</h1>\r\n");
      out.write("            <p id=\"mypage_customer_name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 회원님의 페이지 입니다</p>\r\n");
      out.write("            <div class=\"mypage_info_table\">\r\n");
      out.write("                <h1>최근 주문 정보  <span>최근 30일 내에 주문하신 내역입니다</span></h1>\r\n");
      out.write("            <table>\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>날짜</td>\r\n");
      out.write("                        <td>주문번호</td>\r\n");
      out.write("                        <td>상품명</td>\r\n");
      out.write("                        <td>수량</td>\r\n");
      out.write("                        <td>금액</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("\r\n");
      out.write("               \r\n");
      out.write("                <tbody>\r\n");
      out.write("                     <!-- 더미데이터1 -->\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>2005/05/04</td>\r\n");
      out.write("                        <td>02347897</td>\r\n");
      out.write("                        <td>iphone30</td>\r\n");
      out.write("                        <td>300</td>\r\n");
      out.write("                        <td>100(원)</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                     <!-- 더미데이터2 -->\r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td>2005/03/02</td>\r\n");
      out.write("                        <td>02347897</td>\r\n");
      out.write("                        <td>iphone30</td>\r\n");
      out.write("                        <td>300</td>\r\n");
      out.write("                        <td>100(원)</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                     <!-- 더미데이터3 -->\r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td>2004</td>\r\n");
      out.write("                        <td>02347897</td>\r\n");
      out.write("                        <td>iphone30</td>\r\n");
      out.write("                        <td>300</td>\r\n");
      out.write("                        <td>100(원)</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                     <!-- 더미데이터4 -->\r\n");
      out.write("                     <tr>\r\n");
      out.write("                        <td>2090</td>\r\n");
      out.write("                        <td>02347897</td>\r\n");
      out.write("                        <td>iphone30</td>\r\n");
      out.write("                        <td>300</td>\r\n");
      out.write("                        <td>100(원)</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 맨밑하단 footer 영역  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <!-- 메인페이지 최하단 footer 마무으리~! -->\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/modules/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
