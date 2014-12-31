package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.sia.query.PembelianQuery;
import com.sia.model.Pembelian;
import com.sia.query.PemasokQuery;
import com.sia.model.Pemasok;
import com.sia.model.Perlengkapan;
import com.sia.query.PerlengkapanQuery;
import com.sia.utils.DBConnection;
import java.util.List;
import java.util.ArrayList;

public final class formpembelian_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                public List<Pemasok> datap = new ArrayList<Pemasok>();
                

                public List <Pembelian> data= new ArrayList <Pembelian>();
                
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Form \r\n");
      out.write("            Pembelian</title>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "clientimport.jsp", out, false);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigation.jsp", out, false);
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        ");

            java.util.Calendar cal = java.util.Calendar.getInstance();
            java.util.Date utilDate = cal.getTime();
            
            String timeStamp = new SimpleDateFormat("ddHHmmss").format(Calendar.getInstance().getTime());
            String idPembelian="PP"+timeStamp, pegawai="PEG01", action;
            
        java.sql.Date tglPP= new java.sql.Date(utilDate.getTime());
        
        int pemasok=0;
        if(request.getParameter("idPembelian")!=null){
            idPembelian=request.getParameter("idPembelian");
            DBConnection conn = DBConnection.getInstance();
            PembelianQuery pq= new PembelianQuery(conn.getCon());
            Pembelian p=new Pembelian();
            p=pq.load(idPembelian);
            pemasok=p.getPemasok();
            pegawai=p.getPegawai();
            
            
            action="updatepembelian";
            
        } else  action="insertpembelian";
        
      out.write("\r\n");
      out.write("        <div id=\"page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Page Heading -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("        <!-- Page Heading -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <h1 class=\"page-header\">\r\n");
      out.write("                            Form Pembelian\r\n");
      out.write("                        </h1>\r\n");
      out.write("                        <ol class=\"breadcrumb\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <i class=\"fa fa-dashboard\"></i>  <a href=\"index.jsp\">Beranda</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"active\">\r\n");
      out.write("                                <i class=\"fa fa-edit\"></i> Pembelian\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ol>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <form method=\"POST\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                    <td>ID PEMBELIAN</td>\r\n");
      out.write("                    <td><input class=\"form-control\" type=\"text\" name=\"txtid\" value=\"");
 out.print(idPembelian);
      out.write("\"></td>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <td>PEMASOK</td>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                    <td><select class=\"form-control\"  name=\"txtpemasok\">\r\n");
      out.write("                ");

                DBConnection dbc = DBConnection.getInstance();
                int r = 0;
               PemasokQuery kt = new PemasokQuery(dbc.getCon());
                datap = kt.getAll2();
                
                            for (r = 0; this.datap.size() > r; r++) {
                            out.print("<option value=");
                            out.print(datap.get(r).getIdPemasok());
                            out.print(">");
                            out.print(datap.get(r).getNamaPemasok());
                            out.print("</option>");
                            }
                
      out.write("            \r\n");
      out.write("                        </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <td>PEGAWAI</td>\r\n");
      out.write("                    <td><input class=\"form-control\" type=\"text\" name=\"txtpeg\" value=\"peg_001\" readonly=\"\" ></td>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <td>TANGGAL</td>\r\n");
      out.write("                    <td><input class=\"form-control\" type=\"text\" name=\"txttgl\" readonly=\"\" value=\"");
 out.print(tglPP);
      out.write("\"></td>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <button type=\"submit\" name=\"submit\" value=\"submit\" class=\"btn btn-sm btn-primary\">Submit</button>\r\n");
      out.write("                            <button type=\"reset\" name=\"reset\" value=\"clear form\" class=\"btn btn-sm btn-danger\" >Clear Field</button>\r\n");
      out.write("                     \r\n");
      out.write("                </form>\r\n");
      out.write("                </div>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("                \r\n");
      out.write("               \r\n");
      out.write("            <!-- /.container-fluid -->\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <!-- Page Heading -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <h1 class=\"page-header\">\r\n");
      out.write("                            Tabel Pembelian\r\n");
      out.write("                        </h1>\r\n");
      out.write("                        <ol class=\"breadcrumb\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <i class=\"fa fa-dashboard\"></i>  <a href=\"index.jsp\">Dashboard</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"active\">\r\n");
      out.write("                                <i class=\"fa fa-table\"></i> Pembelian\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ol>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <a align=\"center\" href=\"formjcoa.jsp\">Tambah</a>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"table-responsive\">\r\n");
      out.write("                            <table align=\"center\" class=\"table table-bordered table-hover\">\r\n");
      out.write("                                <thead align=\"center\">\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>Id Pembelian</th>\r\n");
      out.write("                                            <th>Pemasok</th>\r\n");
      out.write("                                                <th>Pegawai</th>\r\n");
      out.write("                                                    <th>Tanggal</th>\r\n");
      out.write("    \r\n");
      out.write("                                                        <th colspan=\"2\">CONTROL</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </thead>\r\n");
      out.write("                                <tbody>\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                ");

                DBConnection conn = DBConnection.getInstance();
                int row=0;
                try{
                    PembelianQuery mq = new PembelianQuery(dbc.getCon());
                    data=mq.getAll2();
                    System.out.println("Load Sukses");
                } catch (Exception e){
                    System.out.println("Gagal karena : "+ e);
                }
                for (row=0; this.data.size()>row; row++){
                    Pembelian p=data.get(row);
                    out.println(
                                    "<tr>"+
                                        "<td>"+p.getIdPembelian()+"</td>"+
                                        "<td>"+p.getPemasok()+"</td>"+
                                            "<td>"+p.getPegawai()+"</td>"+
                                            "<td>"+p.getTanggal()+"</td>"+
                                        "<td><a href='updatepembelian.jsp?txtid="+p.getIdPembelian()+"'>Edit</a> | <a href='deletepembelian?txtid="+p.getIdPembelian()+"'>Delete</a></td>"+
                                    "</tr>");
                    
                }
                //out.print(ljenisCOA.size());
                
      out.write("\r\n");
      out.write("                                </tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                   \r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /#page-wrapper -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /#wrapper -->\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
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
