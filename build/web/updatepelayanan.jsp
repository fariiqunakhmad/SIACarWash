<%-- 
    Document   : updatecustomer
    Created on : Dec 29, 2014, 4:04:05 PM
    Author     : AHSMP
--%>

<%@page import="cr.id.model.pelayanan"%>
<%@page import="cr.id.query.CarWashQuery"%>
<%@page import="cr.id.include.DBConection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Wash Abah Hitam</title>
    </head>
    <body>
        <h1>Update Master Pelayanan</h1>
        <form action="updatepelayanan" method="POST">
            <table>
                <%!
                pelayanan pel =  new pelayanan();
                
                %>
                
                <%
                    DBConection dbc = DBConection.getInstance();
                    String id = request.getParameter("idpelayanan");
                    CarWashQuery cwq = new CarWashQuery(dbc.getCon());
                    pel = cwq.getPel(id);
                    
                %>
                
                <tr>   
                    <th>ID PELAYANAN</th>
                    <td><input type="text" name="idpelayanan" value="<%=pel.getIdPel()%>"></td>
                </tr>
                <tr>
                    <th>NAMA PELAYANAN</th>
                    <td><input type="text" name="namapelayanan" value="<%=pel.getNamaPel()%>"></td>
                </tr>
                <tr>
                    <th>HARGA</th>
                    <td><input type="text" name="harga" value="<%=pel.getHargaPel()%>"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="Update"></td>
                    <td><input type="reset"  name="Reset"></td>
                </tr>
      
            </table>
     
        </form>
    </body>
</html>
