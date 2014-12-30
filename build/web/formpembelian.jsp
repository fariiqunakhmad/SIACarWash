<%-- 
    Document   : formcustomer
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.sia.query.PembelianQuery"%>
<%@page import="com.sia.model.Pembelian"%>
<%@page import="com.sia.query.PemasokQuery"%>
<%@page import="com.sia.model.Pemasok"%>
<%@page import="com.sia.model.Perlengkapan"%>
<%@page import="com.sia.query.PerlengkapanQuery"%>
<%@page import="com.sia.utils.DBConnection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form 
            Pembelian</title>
        <jsp:include page="clientimport.jsp" />
        
    </head>
    <body>
        <div id="wrapper">
            
            

        <jsp:include page="navigation.jsp" />
        <%
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
    %>
        
        <%
            java.util.Calendar cal = java.util.Calendar.getInstance();
            java.util.Date utilDate = cal.getTime();
            
            String timeStamp = new SimpleDateFormat("ddHHmmss").format(Calendar.getInstance().getTime());
            String idPembelian="PP"+timeStamp, pegawai="PEG01", action;
            
        java.sql.Date tglPP= new java.sql.Date(utilDate.getTime());
        
        int pemasok=0;
        if(request.getParameter("txtid")!=null){
            idPembelian=request.getParameter("txtid");
            DBConnection conn = DBConnection.getInstance();
            PembelianQuery pq= new PembelianQuery(conn.getCon());
            Pembelian p=new Pembelian();
            p=pq.load(idPembelian);
            pemasok=p.getPemasok();
            pegawai=p.getPegawai();
            
            
            action="updatepembelian";
            
        } else  action="insertpembelian";
        %>
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
        <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Form Pembelian
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Beranda</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Pembelian
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                    <div class="col-lg-6">
                        <form action="<% out.print(action); %>" method="POST">
            <div class="form-group">
                    <td>ID PEMBELIAN</td>
                    <td><input class="form-control" type="text" name="txtid" value="<% out.print(idPembelian);%>"></td>
                </div>
                
                <div class="form-group">
                    <td>PEMASOK</td>
                <%!
                public List<Pemasok> datap = new ArrayList<Pemasok>();
                %>

                
                    <td><select class="form-control"  name="txtpemasok">
                <%
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
                %>            
                        </select>
                </div>
                
                <div class="form-group">
                    <td>PEGAWAI</td>
                    <td><input class="form-control" type="text" name="txtpeg" value="<% out.print(pegawai);%>" readonly="" ></td>
                </div>
                
                <div class="form-group">
                    <td>TANGGAL</td>
                    <td><input class="form-control" type="text" name="txttgl" readonly="" value="<% out.print(tglPP);%>"></td>
                </div>
                
                <button type="submit" name="submit" value="submit" class="btn btn-sm btn-primary">Submit</button>
                            <button type="reset" name="reset" value="clear form" class="btn btn-sm btn-danger" >Clear Field</button>
                     
                </form>
                </div>
                    
                </div>
                <!-- /.row -->
                
            </div>
                
               
            <!-- /.container-fluid -->
            <br><br>
            <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Tabel Pembelian
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> Pembelian
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <a align="center" href="formjcoa.jsp">Tambah</a>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table align="center" class="table table-bordered table-hover">
                                <thead align="center">
                                    <tr>
                                        <th>Id Pembelian</th>
                                            <th>Pemasok</th>
                                                <th>Pegawai</th>
                                                    <th>Tanggal</th>
    
                                                        <th colspan="2">CONTROL</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%!
                public List <Pembelian> data= new ArrayList <Pembelian>();
                %>
                <%
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
                                        "<td><a href='formpembelian.jsp?txtid="+p.getIdPembelian()+"'>Edit</a> | <a href='deletepembelian?txtid="+p.getIdPembelian()+"'>Delete</a></td>"+
                                    "</tr>");
                    
                }
                //out.print(ljenisCOA.size());
                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                   

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
        
       
        
    </body>
</html>
