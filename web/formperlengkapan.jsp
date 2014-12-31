<%-- 
    Document   : formcustomer
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
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
            String idPerlengkapan="", namaPerlengkapan="", idPembelian="PP"+timeStamp, pegawai="PEG01", action;
            
        java.sql.Date tglPP= new java.sql.Date(utilDate.getTime());
        
        int pemasok=0;
        if(request.getParameter("txtidperkap")!=null){
            idPerlengkapan=request.getParameter("txtidperkap");
            DBConnection conn = DBConnection.getInstance();
            PerlengkapanQuery pq= new PerlengkapanQuery(conn.getCon());
            Perlengkapan p=new Perlengkapan();
            p=pq.load(idPerlengkapan);
            namaPerlengkapan=p.getNamaPerkap();
           
            action="updateperkap";
            
        } else  action="insertperkap";
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
                            Form Perlengkapan
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Beranda</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Perlengkapan
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                    <div class="col-lg-6">
                        <form action="<% out.print(action); %>" method="POST">
            <div class="form-group">
               
                    <td>ID PERLENGKAPAN</td>
                    <td><input class="form-control" type="text" name="txtidperkap" value="<% out.print(idPerlengkapan); %>"></td>
               
                </div>
               <div class="form-group">
                    <td>NAMA PERLENGKAPAN</td>
                    <td><input class="form-control" type="text" name="txtnamaperkap" value="<% out.print(namaPerlengkapan); %>"></td>
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
                            Tabel Perlengkapan
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
                <a align="center" href="formperlengkapan.jsp">Tambah</a>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table align="center" class="table table-bordered table-hover">
                                <thead align="center">
                                  
    <th>Id Perlengkapan</th>
    <th>Nama Perlengkapan</th>
    
    <th colspan="2">CONTROL</th>
   </thead>
                                <tbody>
                                    <%!
                public List <Perlengkapan> data= new ArrayList <Perlengkapan>();
                %>
                <%
                DBConnection conn = DBConnection.getInstance();
                int row=0;
                try{
                    PerlengkapanQuery mq = new PerlengkapanQuery(conn.getCon());
                    data=mq.getAll2();
                    System.out.println("Load Sukses");
                } catch (Exception e){
                    System.out.println("Gagal karena : "+ e);
                }
                for (row=0; this.data.size()>row; row++){
                    Perlengkapan p=data.get(row);
                    out.println(
                                    "<tr>"+
                                        "<td>"+p.getIdPerkap()+"</td>"+
                                        "<td>"+p.getNamaPerkap()+"</td>"+
                                           
                                        "<td><a href='formperlengkapan.jsp?txtidperkap="+p.getIdPerkap()+"'>Edit</a> | <a href='deletepembelian?txtidperkap="+p.getIdPerkap()+"'>Delete</a></td>"+
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