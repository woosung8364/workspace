/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-14 06:32:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class article_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <title>Document</title>\r\n");
      out.write("  <title>PortFolio</title>\r\n");
      out.write("  <!-- meta -->\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <!-- css -->\r\n");
      out.write("  <!-- ë§ë£¨ë¶ë¦¬ ê¸ê¼´ -->\r\n");
      out.write("  <link href=\"https://hangeul.pstatic.net/hangeul_static/css/maru-buri.css\" rel=\"stylesheet\">\r\n");
      out.write("  <!-- ë¶í¸ì¤í¸ë© -->\r\n");
      out.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("    integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\"\r\n");
      out.write("    integrity=\"sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==\"\r\n");
      out.write("    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/reset.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/media.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/article.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <section id=\"wrap01\">\r\n");
      out.write("    <div id=\"menu_box\">\r\n");
      out.write("      <h2 id=\"exit\">ë<br>ê°<br>ê¸°</h2>\r\n");
      out.write("      <ul>\r\n");
      out.write("        <li><a href=\"#wrap01\">GO HOME</a></li>\r\n");
      out.write("        <li><a href=\"#wrap02\">ABOUT ME</a></li>\r\n");
      out.write("        <li><a href=\"#wrap03\">FRONT END</a></li>\r\n");
      out.write("        <li><a href=\"#wrap04\">BACK END</a></li>\r\n");
      out.write("        <li><a href=\"#wrap05\">DESIGN</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"circle\"></div>\r\n");
      out.write("  <div class=\"arc_wrap\">\r\n");
      out.write("    <div class=\"article\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"article_header_contents\">\r\n");
      out.write("        <h2 class=\"header_text\">ê²ìê¸</h2>\r\n");
      out.write("        <p class=\"ps\">ê²ìê¸ì ë¨ê²¨ì£¼ì¸ì.</p>\r\n");
      out.write("        <div class=\"art_line\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"input_contents\">\r\n");
      out.write("        <p class=\"date\">2023-05-05</p>\r\n");
      out.write("        <input type=\"text\" name=\"textArea\" id=\"textArea\" >\r\n");
      out.write("        <button class=\"save_text\">ê¸ ë¨ê¸°ê¸°</button>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"text_contents tc1\">\r\n");
      out.write("        <h2 class=\"text_date\">ê¹ì² ì | 2023-05-05 | 12:00</h2>\r\n");
      out.write("        <p class=\"text_contnet\">Lorem ipsum dolor sit amet consectetur<br>\r\n");
      out.write("          adipisicing elit. Eligendi accusantium magnam sequi laudantium,<br>\r\n");
      out.write("          enim aperiam tempore veniam rerum doloribus consectetur est quasi nulla earum, excepturi eum iure vel fuga? Excepturi.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"text_contents tc2\">\r\n");
      out.write("        <h2 class=\"text_date\">ê¹ì² ì | 2023-05-05 | 12:00</h2>\r\n");
      out.write("        <p class=\"text_contnet\">Lorem ipsum dolor sit amet consectetur<br>\r\n");
      out.write("          adipisicing elit. Eligendi accusantium magnam sequi laudantium,<br>\r\n");
      out.write("          enim aperiam tempore veniam rerum doloribus consectetur est quasi nulla earum, excepturi eum iure vel fuga? Excepturi.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"text_contents tc2\">\r\n");
      out.write("        <h2 class=\"text_date\">ê¹ì² ì | 2023-05-05 | 12:00</h2>\r\n");
      out.write("        <p class=\"text_contnet\">Lorem ipsum dolor sit amet consectetur<br>\r\n");
      out.write("          adipisicing elit. Eligendi accusantium magnam sequi laudantium,<br>\r\n");
      out.write("          enim aperiam tempore veniam rerum doloribus consectetur est quasi nulla earum, excepturi eum iure vel fuga? Excepturi.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"text_contents tc2\">\r\n");
      out.write("        <h2 class=\"text_date\">ê¹ì² ì | 2023-05-05 | 12:00</h2>\r\n");
      out.write("        <p class=\"text_contnet\">Lorem ipsum dolor sit amet consectetur<br>\r\n");
      out.write("          adipisicing elit. Eligendi accusantium magnam sequi laudantium,<br>\r\n");
      out.write("          enim aperiam tempore veniam rerum doloribus consectetur est quasi nulla earum, excepturi eum iure vel fuga? Excepturi.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"text_contents tc2\">\r\n");
      out.write("        <h2 class=\"text_date\">ê¹ì² ì | 2023-05-05 | 12:00</h2>\r\n");
      out.write("        <p class=\"text_contnet\">Lorem ipsum dolor sit amet consectetur<br>\r\n");
      out.write("          adipisicing elit. Eligendi accusantium magnam sequi laudantium,<br>\r\n");
      out.write("          enim aperiam tempore veniam rerum doloribus consectetur est quasi nulla earum, excepturi eum iure vel fuga? Excepturi.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"text_contents tc2\">\r\n");
      out.write("        <h2 class=\"text_date\">ê¹ì² ì | 2023-05-05 | 12:00</h2>\r\n");
      out.write("        <p class=\"text_contnet\">Lorem ipsum dolor sit amet consectetur<br>\r\n");
      out.write("          adipisicing elit. Eligendi accusantium magnam sequi laudantium,<br>\r\n");
      out.write("          enim aperiam tempore veniam rerum doloribus consectetur est quasi nulla earum, excepturi eum iure vel fuga? Excepturi.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"text_contents tc2\">\r\n");
      out.write("        <h2 class=\"text_date\">ê¹ì² ì | 2023-05-05 | 12:00</h2>\r\n");
      out.write("        <p class=\"text_contnet\">Lorem ipsum dolor sit amet consectetur<br>\r\n");
      out.write("          adipisicing elit. Eligendi accusantium magnam sequi laudantium,<br>\r\n");
      out.write("          enim aperiam tempore veniam rerum doloribus consectetur est quasi nulla earum, excepturi eum iure vel fuga? Excepturi.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <div class=\"art_next_line\">\r\n");
      out.write("        <ul class=\"page_item\">\r\n");
      out.write("          <li><a class=\"page_list first_page\" href=\"#\"> << </a></li>\r\n");
      out.write("          <li><a class=\"page_list p01\" href=\"#\">1</a></li>\r\n");
      out.write("          <li><a class=\"page_list p02\" href=\"#\">2</a></li>\r\n");
      out.write("          <li><a class=\"page_list p03\" href=\"#\">3</a></li>\r\n");
      out.write("          <li><a class=\"page_list p04\" href=\"#\">4</a></li>\r\n");
      out.write("          <li><a class=\"page_list p05\" href=\"#\">5</a></li>\r\n");
      out.write("          <li><a class=\"page_list last_page\" href=\"#\">>></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"contents_box\">\r\n");
      out.write("      <!-- í¤ë -->\r\n");
      out.write("      <header>\r\n");
      out.write("\r\n");
      out.write("        <img src=\"img/logo.png\" alt=\"\" class=\"logo\">\r\n");
      out.write("        <ul class=\"header_contents\">\r\n");
      out.write("          <li><a href=\"#wrap02\">ABOUT ME</a></li>\r\n");
      out.write("          <li><a href=\"#wrap03\">FRONT END</a></li>\r\n");
      out.write("          <li><a href=\"#wrap04\">BACK END</a></li>\r\n");
      out.write("          <li><a href=\"#wrap05\">DESIGN</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"log_in_div\">\r\n");
      out.write("          <a href=\"#\" class=\"log_in\" id=\"log_in\" data-bs-auto-close=\"outside\" data-bs-toggle=\"dropdown\">\r\n");
      out.write("            ë¡ê·¸ì¸</a>\r\n");
      out.write("          <div class=\"log_in_box\">\r\n");
      out.write("            <h1>íìí©ëë¤!</h1>\r\n");
      out.write("            <p>ìì´ëì ë¹ë°ë²í¸ë¥¼ ìë ¥í´ì£¼ì¸ì!</p>\r\n");
      out.write("            <div class=\"login_line\"></div>\r\n");
      out.write("\r\n");
      out.write("            <!-- ìì´ë ìë ¥ -->\r\n");
      out.write("            <div class=\"log_in_contnets lic1\">\r\n");
      out.write("              <P>ìì´ë</P>\r\n");
      out.write("              <input type=\"text\" name=\"uid\" id=\"uid\" class=\"login_text\" required>\r\n");
      out.write("\r\n");
      out.write("              <!-- ë¹ë°ë²í¸ ìë ¥ -->\r\n");
      out.write("              <div class=\"log_in_contnets lic2\">\r\n");
      out.write("                <P>ë¹ë°ë²í¸</P>\r\n");
      out.write("                <input type=\"text\" name=\"uid\" id=\"uid\" class=\"login_text\" required>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"log_in_contnets lic3\">\r\n");
      out.write("                  <input type=\"submit\" value=\"ë¡ê·¸ì¸\">\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <img src=\"img/menu.png\" alt=\"\" class=\"menu_img\">\r\n");
      out.write("\r\n");
      out.write("        <a href=\"mailto::seo8362@naver.com\" class=\"give_mail\"></a>\r\n");
      out.write("\r\n");
      out.write("      </header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!--jquery script01 -->\r\n");
      out.write("  <script src=\"js/lib/jquery-1.12.4.min.js\"></script>\r\n");
      out.write("  <!-- easing script02-a -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/lib/jquery.easing.1.3.js\">\r\n");
      out.write("  </script>\r\n");
      out.write("  <!-- smooth scroll02-b -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/lib/jquery.smooth-scroll.js\">\r\n");
      out.write("  </script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/lib/jquery.bxslider.min.js\">\r\n");
      out.write("  </script>\r\n");
      out.write("  <!-- my script03-a -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/login.js\">\r\n");
      out.write("  </script>\r\n");
      out.write("  <!--my script 03-c  -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/fixed.js\">\r\n");
      out.write("  </script>\r\n");
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
