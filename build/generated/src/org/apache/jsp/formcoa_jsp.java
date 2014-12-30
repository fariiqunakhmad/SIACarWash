package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Date;
import com.sia.query.JenisCOAQuery;
import com.sia.model.JenisCOA;
import java.util.ArrayList;
import java.util.List;
import com.sia.model.COA;
import com.sia.utils.DBConnection;
import com.sia.query.COAQuery;

public final class formcoa_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                            public List <JenisCOA> lJenisCOA= new ArrayList <JenisCOA>();
                            
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>Form COA</title>\r\n");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "clientimport.jsp", out, false);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    ");

    //allow access only if session exists
    String user = null;
    if(session.getAttribute("id") == null){
        response.sendRedirect("login.jsp");
    }else user = (String) session.getAttribute("name");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
    for(Cookie cookie : cookies){
        if(cookie.getName().equals("name")) userName = cookie.getValue();
        if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
    }
    }
    
      out.write("\r\n");
      out.write("   \r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigation.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Date tglBukaCOA= new java.sql.Date(utilDate.getTime());
    
        String idCOA="", namaCOA="", saldoAwalCOA="", statCOA="", action;
        
        int idJenisCOA=0;
        if(request.getParameter("idCOA")!=null){
            idCOA=request.getParameter("idCOA");
            DBConnection conn = DBConnection.getInstance();
            COAQuery cOAq= new COAQuery(conn.getCon());
            COA cOA=new COA();
            cOA=cOAq.load(idCOA);
            idJenisCOA=cOA.getIdJenisCOA();
            namaCOA=cOA.getNamaCOA();
            saldoAwalCOA=cOA.getSaldoAwalCOA();
            tglBukaCOA=cOA.getTglBukaCOA();
            statCOA=cOA.getStatCOA();
            action="updateCOA";
            
        } else  action="insertCOA";
        
      out.write("\r\n");
      out.write("    \r\n");
      out.write("        <div id=\"page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Page Heading -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <h1 class=\"page-header\">\r\n");
      out.write("                            Form COA\r\n");
      out.write("                        </h1>\r\n");
      out.write("                        <ol class=\"breadcrumb\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <i class=\"fa fa-dashboard\"></i>  <a href=\"index.jsp\">Beranda</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"active\">\r\n");
      out.write("                                <i class=\"fa fa-edit\"></i> COA\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ol>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("\r\n");
      out.write("                        <form role=\"formpeg\" onSubmit=\"\" action=\"");
 out.print(action); 
      out.write("\" method=\"POST\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label>ID</label>\r\n");
      out.write("                                <input class=\"form-control\" placeholder=\"Masukkan ID COA\" name=\"txtIdCOA\" value=\"");
 out.print(idCOA); 
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label>NAMA</label>\r\n");
      out.write("                                <input class=\"form-control\" placeholder=\"Masukkan NAMA COA\" name=\"txtNamaCOA\" value=\"");
 out.print(namaCOA); 
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label>SALDO AWAL</label>\r\n");
      out.write("                                <input class=\"form-control\" placeholder=\"Masukkan SALDO AWAL\" name=\"txtSaldoAwalCOA\" value=\"");
 out.print(saldoAwalCOA); 
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label>TANGGAL BUKA</label>\r\n");
      out.write("                                <input type=\"date\" class=\"form-control\" placeholder=\"Masukkan TANGGAL BUKA\" name=\"txtTglBukaCOA\" value=\"");
 out.print(tglBukaCOA); 
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                          \r\n");
      out.write("\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label>JENIS COA</label>\r\n");
      out.write("                                <select class=\"form-control\"  name=\"txtIdJenisCOA\" id=\"txtIdJenisCOA\">\r\n");
      out.write("                                    \r\n");
      out.write("                                    ");

                                    DBConnection dbc = DBConnection.getInstance();
                                    try{
                                        JenisCOAQuery jenisCOAQuery = new JenisCOAQuery(dbc.getCon());
                                        lJenisCOA=jenisCOAQuery.getAllS(idJenisCOA);
                                        System.out.println("Load Sukses");
                                    } catch (Exception e){
                                        System.out.println("Gagal karena : "+ e);
                                    }
                                    for (int row=0; this.lJenisCOA.size()>row; row++){
                                        JenisCOA jCOA=lJenisCOA.get(row);
                                        out.println("<option value='"+ jCOA.getIdJenisCOA()+"'>"+jCOA.getNamaJenisCOA() +"</option>");
                                    }
                                    
      out.write(" \r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                             \r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label>Status COA</label>\r\n");
      out.write("                                            <div class=\"radio\">\r\n");
      out.write("                                                <label>\r\n");
      out.write("                                                    <input type=\"radio\" name=\"txtStatCOA\" id=\"optionsRadios1\" value=\"1\" checked>Aktif\r\n");
      out.write("                                                </label>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"radio\">\r\n");
      out.write("                                                <label>\r\n");
      out.write("                                                    <input type=\"radio\" name=\"txtStatCOA\" id=\"optionsRadios2\" value=\"0\">Non Aktif\r\n");
      out.write("                                                </label>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <button type=\"submit\" name=\"submit\" value=\"submit\" class=\"btn btn-sm btn-primary\">Submit</button>\r\n");
      out.write("                            <button type=\"reset\" name=\"reset\" value=\"clear form\" class=\"btn btn-sm btn-danger\" >Clear Field</button>\r\n");
      out.write("\r\n");
      out.write("                           \r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /#page-wrapper -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /#wrapper -->\r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
}
