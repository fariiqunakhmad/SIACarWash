<%-- 
    Document   : formmatakuliah
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>


<%@page import="com.sia.model.Perlengkapan"%>
<%@page import="com.sia.query.PerlengkapanQuery"%>
<%@page import="com.sia.utils.DBConnection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Perlengkapan</title>
    </head>
    <body>
        
      
        
        <h1 align="center">Update Data Perlengkapan</h1>
        <form action="updateperkap" method="POST">
            <table align="center">
                <%!
    Perlengkapan data = new Perlengkapan();
    %>

    <%
    DBConnection dbc = DBConnection.getInstance();

    String id = request.getParameter("txtidperkap").toString();
    PerlengkapanQuery cq = new PerlengkapanQuery(dbc.getCon());
    data = cq.getAll(id);
    %>
                <tr>
                    <td>No Ktp Pelanggan</td>
                    <td><input type="text" readonly="" name="txtidperkap" value="<%=data.getIdPerkap()%>"></td>
                </tr>
                
                <tr>
                    <td>Kota</td>
                    <td><input type="text" name="txtnamaperkap" value="<%=data.getNamaPerkap()%>"></td>
                </tr>
                
               
                <tr>
                    <td><input type="submit" value="submit"></td>
                    <td><input type="reset" value="clear form"></td>
                </tr>
                
            </table>
            
            
        </form>
    </body>
</html>
