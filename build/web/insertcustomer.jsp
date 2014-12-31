<%-- 
    Document   : insertcustomer
    Created on : Dec 29, 2014, 12:35:44 PM
    Author     : AHSMP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
        <title>INSERT CUSTOMER CAR WASH ABAH HITAM</title>
        <jsp:include page="clientimport.jsp" />
    </head>
    <body>
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
   
        <div id="wrapper">

            <jsp:include page="navigation.jsp" />




            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Form COA
                            </h1>
                            <ol class="breadcrumb">
                                <li>
                                    <i class="fa fa-dashboard"></i>  <a href="index.jsp">Beranda</a>
                                </li>
                                <li class="active">
                                    <i class="fa fa-edit"></i> COA
                                </li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-lg-6">
                            <form action="insert_customer" method="POST">
                                
                                       <div class="form-group">
                                        <label>ID</label>
                                        <input class="form-control" placeholder="Masukkan ID COA" name="txtIdCOA" value="">
                                        </div>
                                
                                        <div class="form-group">
                                        <label>ID</label>
                                        <input type="text" name="idcustomer" class="form-control" placeholder="Masukkan ID COA">
                                        </div>
                                        
                                        <th>NAMA         </th>
                                        <td><input type="text" name="namacustomer"></td>
                                    
                                        <th>ALAMAT       </th>
                                        <td><input type="text" name="alamatcustomer"></td>
                                    
                                        <th>TELEPON      </th>
                                        <td><input type="text" name="tlpcustomer"></td>
                                    
                                        <th>JENIS KELAMIN</th>
                                        <td><input type="text" name="jeniskelamin"></td>
                                    
                                        <th>STATUS       </th>
                                        <td><input type="text" name="status"></td>
                                    
                                        <td><input type="submit" name="SIMPAN"></td>
                                        <td><input type="reset" name="RESET"></td>
                                   
                            </form>
                        </div>
                    
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->
    </body>
</html>
