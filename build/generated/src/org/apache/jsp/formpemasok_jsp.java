package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sia.query.PemasokQuery;
import com.sia.model.Pemasok;
import com.sia.model.Perlengkapan;
import com.sia.query.PerlengkapanQuery;
import com.sia.utils.DBConnection;
import java.util.List;
import java.util.ArrayList;

public final class formpemasok_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public List <Pemasok> data =
                new ArrayList <Pemasok>();
    
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
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Form \r\n");
      out.write("            Pemasok</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1 align=\"center\">Input Data Pemasok</h1>\r\n");
      out.write("        <form action=\"insertpemasok\" method=\"POST\">\r\n");
      out.write("            <table align=\"center\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>ID PEMASOK</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"txtid\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>NAMA PEMASOK</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"txtnama\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>TELEPON</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"txttlp\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>ALAMAT</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"txtalamat\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><input type=\"submit\" value=\"submit\"></td>\r\n");
      out.write("                    <td><input type=\"reset\" value=\"clear form\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("            </table>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        <br><br>        \r\n");
      out.write("        <table align=\"center\" border=\"2\" >  \r\n");
      out.write("    <th>Id Pemasok</th>\r\n");
      out.write("    <th>Nama Pemasok</th>\r\n");
      out.write("    <th>Telepon</th>\r\n");
      out.write("    <th>Alamat</th>\r\n");
      out.write("    \r\n");
      out.write("    <th colspan=\"2\">CONTROL</th>\r\n");
      out.write("   \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

        DBConnection conn= DBConnection.getInstance();
        int row=0;
           
        PemasokQuery mq=new PemasokQuery(conn.getCon());
        data= mq.getAll2();
        
        for(row=0; this.data.size()>row; row++){
            Pemasok p=data.get(row);
            out.print("<tr>");
            out.print("<td>");
            out.print(p.getIdPemasok());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getNamaPemasok());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getTelepon());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getAlamat());
            out.print("</td>");
            out.print("<td>");
      out.write("\r\n");
      out.write("            <a href=\"updatepemasok.jsp?txtid=");
      out.print(data.get(row).getIdPemasok());
      out.write("\">Update</a>\r\n");
      out.write("            ");
out.print("</td>");
            out.print("<td>"); 
      out.write("\r\n");
      out.write("            <a href=\"deletepemasok?txtid=");
      out.print(data.get(row).getIdPemasok());
      out.write("\">Delete</a>\r\n");
      out.write("            ");
out.print("</td>");
            
            out.print("</tr>");
            
        }
    
      out.write("\r\n");
      out.write("     </table>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
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
