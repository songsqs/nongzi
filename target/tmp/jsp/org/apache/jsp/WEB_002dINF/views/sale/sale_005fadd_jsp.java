package org.apache.jsp.WEB_002dINF.views.sale;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sale_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/views/sale/../layout/nav.jsp");
    _jspx_dependants.add("/WEB-INF/views/sale/../layout/sidebar.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css\">\r\n");
      out.write("<script src=\"http://libs.baidu.com/jquery/2.0.0/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/bootstrap-datetimepicker.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\" charset=\"UTF-8\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/locales/bootstrap-datetimepicker.zh-CN.js\"\r\n");
      out.write("\ttype=\"text/javascript\" charset=\"UTF-8\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/myScript.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- jquery.ui -->\r\n");
      out.write("<!-- <script src=\"//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js\"></script> -->\r\n");
      out.write("<script src=\"//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>销售管理</title>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t<a class=\"navbar-brand\" href=\"/test\">风华农资超市</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t<li><a href=\"#\">销售列表</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/customer/list\">客户管理</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/product/list\">产品管理</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"section\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<ul class=\"lead nav nav-pills nav-stacked\">\r\n");
      out.write("\t<li><a href=\"#\">销售列表</a></li>\r\n");
      out.write("\t<li><a href=\"/customer/list\">客户管理</a></li>\r\n");
      out.write("\t<li><a href=\"/product/list\">产品管理</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-md-9\">\r\n");
      out.write("\t\t\t\t<form class=\"form-horizontal\" role=\"form\" action=\"add.do\"\r\n");
      out.write("\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"productNameId\" class=\"control-label\">产品名称:</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"productIdId\" name=\"productId\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"text\" class=\"form-control\" id=\"productNameId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=产品名称 name=\"productName\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"customerNameId\" class=\"control-label\">姓名:</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"customerIdId\" name=\"customerId\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"customerNameId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"姓名\" name=\"customerName\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"price\" class=\"control-label\">单价(元):</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"priceId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"单价\" name=\"price\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"numId\" class=\"control-label\">数量:</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"numId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"数量\" name=\"num\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"totalPriceId\" class=\"control-label\">总价(元):</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"totalPriceId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"总价\" name=\"totalPrice\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"profitId\" class=\"control-label\">利润(元):</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"profitId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"利润\" name=\"profit\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"createTimeId\" class=\"control-label\">时间:</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"createTimeId\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"销售时间\" name=\"createTime\" readonly>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\"\r\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"return onSubmit();\">确定</button>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"/product/list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\">取消</button>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t//产品名\r\n");
      out.write("\t\t\t$('#productNameId').autocomplete({\r\n");
      out.write("\t\t\t\tsource : function(request, reponse) {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : \"/product/getProduct.do\",\r\n");
      out.write("\t\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\"name\" : $(\"#productNameId\").val()\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tcache : \"false\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\t\t\tvar jsonData = jQuery.parseJSON(data);\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(jsonData);\r\n");
      out.write("\t\t\t\t\t\t\treponse($.map(jsonData, function(item) {\r\n");
      out.write("\t\t\t\t\t\t\t\treturn {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlabel : item.name,\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue : item.name,\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid : item.productId,\r\n");
      out.write("\t\t\t\t\t\t\t\t\tprice : item.price\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}));\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror : function(suggestionRequest, textStatus, error) {\r\n");
      out.write("\t\t\t\t\t\t\talert(error);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tminChars : 0,\r\n");
      out.write("\t\t\t\tmax : 10,\r\n");
      out.write("\t\t\t\tautoFill : false,\r\n");
      out.write("\t\t\t\tscollHeight : 200,\r\n");
      out.write("\t\t\t\tselect : function(event, ui) {\r\n");
      out.write("\t\t\t\t\t$(\"#productIdId\").val(ui.item.id);\r\n");
      out.write("\t\t\t\t\t$(\"#productNameId\").val(ui.item.value);\r\n");
      out.write("\t\t\t\t\t$(\"#priceId\").val(ui.item.price);\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t//客户姓名\r\n");
      out.write("\t\t\t$('#customerNameId').autocomplete({\r\n");
      out.write("\t\t\t\tsource : function(request, reponse) {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : \"/customer/getCustomer.do\",\r\n");
      out.write("\t\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\"name\" : $(\"#customerNameId\").val()\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tcache : \"false\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\t\t\tvar jsonData = jQuery.parseJSON(data);\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(jsonData);\r\n");
      out.write("\t\t\t\t\t\t\treponse($.map(jsonData, function(item) {\r\n");
      out.write("\t\t\t\t\t\t\t\treturn {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlabel : item.name,\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue : item.name,\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid : item.customerId\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}));\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror : function(suggestionRequest, textStatus, error) {\r\n");
      out.write("\t\t\t\t\t\t\talert(error);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tminChars : 0,\r\n");
      out.write("\t\t\t\tmax : 10,\r\n");
      out.write("\t\t\t\tautoFill : false,\r\n");
      out.write("\t\t\t\tscollHeight : 200,\r\n");
      out.write("\t\t\t\tselect : function(event, ui) {\r\n");
      out.write("\t\t\t\t\t$(\"#customerIdId\").val(ui.item.id);\r\n");
      out.write("\t\t\t\t\t$(\"#customerNameId\").val(ui.item.value);\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$('#createTimeId').datetimepicker({\r\n");
      out.write("\t\t\tlanguage : 'zh-CN',\r\n");
      out.write("\t\t\tformat : 'yyyy-mm-dd',\r\n");
      out.write("\t\t\tminView : 2,\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\tfunction onSubmit() {\r\n");
      out.write("\t\t\tif (!checkAndGetSelectValue(\"productNameId\", \"产品名称不能为空\", \"0\")) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!checkAndGetSelectValue(\"customerNameId\", \"姓名不能为空\", \"0\")) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!checkAndGetSelectValue(\"priceId\", \"单价不能为空\", \"0\")\r\n");
      out.write("\t\t\t\t\t|| !checkIsNaN(\"priceId\", \"单价必须是数字\")) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!checkAndGetSelectValue(\"numId\", \"数量不能为空\", \"0\")\r\n");
      out.write("\t\t\t\t\t|| !checkIsNaN(\"numId\", \"数量必须是数字\")) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!checkAndGetSelectValue(\"totalPriceId\", \"总价不能为空\", \"0\")\r\n");
      out.write("\t\t\t\t\t|| !checkIsNaN(\"totalPriceId\", \"总价必须为数字\")) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!checkAndGetSelectValue(\"profitId\", \"利润不能为空\", \"0\")\r\n");
      out.write("\t\t\t\t\t|| !checkIsNaN(\"profitId\", \"利润必须是数字\")) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(!checkAndGetSelectValue(\"createTimeId\",\"时间不能为空\",\"0\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
