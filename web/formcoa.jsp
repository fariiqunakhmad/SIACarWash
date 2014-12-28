<%-- 
    Document   : formcOA
    Created on : Sep 26, 2014, 9:33:58 AM
    Author     : Akhmad Fariiqun Awwa
--%>

<%@page import="java.sql.Date"%>
<%@page import="com.sia.query.JenisCOAQuery"%>
<%@page import="com.sia.model.JenisCOA"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sia.model.COA"%>
<%@page import="com.sia.utils.DBConnection"%>
<%@page import="com.sia.query.COAQuery"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Form COA</title>

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

<%      java.util.Calendar cal = java.util.Calendar.getInstance();
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
                                <input class="form-control" placeholder="Masukkan ID COA" name="txtIdCOA" value="<% out.print(idCOA); %>">
                            </div>
							
                            <div class="form-group">
                                <label>NAMA</label>
                                <input class="form-control" placeholder="Masukkan NAMA COA" name="txtNamaCOA" value="<% out.print(namaCOA); %>">
                            </div>
                            
                            <div class="form-group">
                                <label>SALDO AWAL</label>
                                <input class="form-control" placeholder="Masukkan SALDO AWAL" name="txtSaldoAwalCOA" value="<% out.print(saldoAwalCOA); %>">
                            </div>
                            <div class="form-group">
                                <label>TANGGAL BUKA</label>
                                <input type="date" class="form-control" placeholder="Masukkan TANGGAL BUKA" name="txtTglBukaCOA" value="<% out.print(tglBukaCOA); %>">
                            </div>
                            <%!
                            public List <JenisCOA> lJenisCOA= new ArrayList <JenisCOA>();
                            %>
                          

                            <div class="form-group">
                                <label>JENIS COA</label>
                                <select class="form-control"  name="txtIdJenisCOA" id="txtIdJenisCOA">
                                    
                                    <%
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
                                    %> 
                                </select>
                            </div>
                             
                                        <div class="form-group">
                                            <label>Status COA</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="txtStatCOA" id="optionsRadios1" value="1" checked>Aktif
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="txtStatCOA" id="optionsRadios2" value="0">Non Aktif
                                                </label>
                                            </div>
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
