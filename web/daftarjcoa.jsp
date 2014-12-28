<%-- 
    Document   : daftarjenisCOA
    Created on : Oct 10, 2014, 6:50:06 AM
    Author     : Akhmad Fariiqun Awwa
--%>

<%@page import="com.sia.query.JenisCOAQuery"%>
<%@page import="com.sia.utils.DBConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sia.model.JenisCOA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tabel Jenis COA</title>

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
                            Tabel JenisCOA
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> JenisCOA
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <a href="formjcoa.jsp">Tambah</a>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Id Jenis COA</th>
                                        <th>Nama Jenis COA</th>
                                        <th>Control</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%!
                public List <JenisCOA> ljenisCOA= new ArrayList <JenisCOA>();
                %>
                <%
                DBConnection dbc = DBConnection.getInstance();
                int row=0;
                try{
                    JenisCOAQuery jenisCOAq = new JenisCOAQuery(dbc.getCon());
                    ljenisCOA=jenisCOAq.getAll();
                    System.out.println("Load Sukses");
                } catch (Exception e){
                    System.out.println("Gagal karena : "+ e);
                }
                for (row=0; this.ljenisCOA.size()>row; row++){
                    JenisCOA jenisCOA=ljenisCOA.get(row);
                    out.println(
                                    "<tr>"+
                                        "<td>"+jenisCOA.getIdJenisCOA()+"</td>"+
                                        "<td>"+jenisCOA.getNamaJenisCOA()+"</td>"+
                                        "<td><a href='formjcoa.jsp?idJCOA="+jenisCOA.getIdJenisCOA()+"'>Edit</a> | <a href='deleteJenisCOA?idJenisCOA="+jenisCOA.getIdJenisCOA()+"'>Delete</a></td>"+
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

    </div>
    <!-- /#wrapper -->
    
</body>

</html>
