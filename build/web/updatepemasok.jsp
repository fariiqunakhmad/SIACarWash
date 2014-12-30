<%-- 
    Document   : formmatakuliah
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>


<%@page import="com.sia.query.PemasokQuery"%>
<%@page import="com.sia.model.Pemasok"%>
<%@page import="com.sia.model.Perlengkapan"%>
<%@page import="com.sia.query.PerlengkapanQuery"%>
<%@page import="com.sia.utils.DBConnection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pemasok</title>
    </head>
    <body>
        
      
        
        <h1 align="center">Update Data Pemasok</h1>
        <form action="updatepemasok" method="POST">
            <table align="center">
                <%!
    Pemasok data = new Pemasok();
    %>

    <%
    DBConnection dbc = DBConnection.getInstance();

    String id = request.getParameter("txtid").toString();
    PemasokQuery cq = new PemasokQuery(dbc.getCon());
    data = cq.getAll(id);
    %>
                <tr>
                    <td>No Ktp Pelanggan</td>
                    <td><input type="text" readonly="" name="txtid" value="<%=data.getIdPemasok()%>"></td>
                </tr>
                
                <tr>
                    <td>Kota</td>
                    <td><input type="text" name="txtnama" value="<%=data.getNamaPemasok()%>"></td>
                </tr>
                
                <tr>
                    <td>Telepon</td>
                    <td><input type="text" name="txttlp" value="<%=data.getTelepon()%>"></td>
                </tr>
                
                <tr>
                    <td>Alamat</td>
                    <td><input type="text" name="txtalamat" value="<%=data.getAlamat()%>"></td>
                </tr>
                
               
                <tr>
                    <td><input type="submit" value="submit"></td>
                    <td><input type="reset" value="clear form"></td>
                </tr>
                
            </table>
            
            
        </form>
    </body>
</html>
