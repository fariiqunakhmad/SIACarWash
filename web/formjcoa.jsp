<%-- 
    Document   : formjcoa
    Created on : Dec 17, 2014, 3:12:11 AM
    Author     : Akhmad Fariiqun Awwa
--%>

<%@page import="com.sia.model.JenisCOA"%>
<%@page import="com.sia.query.JenisCOAQuery"%>
<%@page import="com.sia.utils.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Jenis COA</title>
    
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

        <% 
            int idJenisCOA=0;
            String namaJenisCOA="", action;
        if(request.getParameter("idJCOA")!=null){
            idJenisCOA=Integer.parseInt(request.getParameter("idJCOA"));
            DBConnection conn = DBConnection.getInstance();
            JenisCOAQuery jenisCOAq= new JenisCOAQuery(conn.getCon());
            JenisCOA jenisCOA=new JenisCOA();
            jenisCOA=jenisCOAq.load(idJenisCOA);
            namaJenisCOA=jenisCOA.getNamaJenisCOA();
            action="updateJenisCOA";
            
        } else  action="insertJenisCOA";
        %>
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
                        <form role="formpeg" onSubmit="" action="<% out.print(action); %>" method="POST">

                            <div class="form-group">
                                <label>ID</label>
                                <input class="form-control" placeholder="Masukkan ID " name="txtIdJenisCOA" value="<% out.print(idJenisCOA); %>">
                            </div>

                            <div class="form-group">
                                <label>NAMA</label>
                                <input class="form-control" placeholder="Masukkan NAMA " name="txtNamaJenisCOA" value="<% out.print(namaJenisCOA); %>">
                            </div>

                            <button type="submit" name="submit" value="submit" class="btn btn-sm btn-primary">Submit</button>
                            <button type="reset" name="reset" value="clear form" class="btn btn-sm btn-danger" >Clear Field</button>


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
