<%-- 
    Document   : formmatakuliah
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sia.query.PembelianQuery"%>
<%@page import="com.sia.model.Pembelian"%>
<%@page import="com.sia.query.PemasokQuery"%>
<%@page import="com.sia.model.Pemasok"%>
<%@page import="com.sia.model.Perlengkapan"%>
<%@page import="com.sia.query.PerlengkapanQuery"%>
<%@page import="com.sia.utils.DBConnection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pembelian</title>
    </head>
    <body>
        
      
        
        <h1 align="center">Update Data Pembelian</h1>
        <form action="updatepembelian" method="POST">
            <table align="center">
                <%!
    Pembelian data = new Pembelian();
    %>

    <%
    DBConnection dbc = DBConnection.getInstance();

    String id = request.getParameter("txtid").toString();
    PembelianQuery cq = new PembelianQuery(dbc.getCon());
    data = cq.getAll(id);
    %>
                <tr>
                    <td>ID PP</td>
                    <td><input type="text" readonly="" name="txtid" value="<%=data.getIdPembelian()%>"></td>
                </tr>
                
                
                <tr>
                    <td>Pemasok</td>
                    <td><input type="text" name="txtpemasok" value="<%=data.getPemasok()%>"></td>
                </tr>
                
                <tr>
                    <td>Pegawai</td>
                    <td><input type="text" name="txtpeg" value="<%=data.getPegawai()%>"></td>
                </tr>
                
                
                
                <tr>
                    <td>Tanggal</td>
                    <td><input type="text" name="txttgl" value="<%=data.getTanggal()%>"></td>
                </tr>
                
               
                <tr>
                    <td><input type="submit" value="submit"></td>
                    <td><input type="reset" value="clear form"></td>
                </tr>
                
            </table>
            
            
        </form>
    </body>
</html>
