<%-- 
    Document   : updatecustomer
    Created on : Dec 29, 2014, 4:04:05 PM
    Author     : AHSMP
--%>

<%@page import="cr.id.model.pencucian"%>
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
        <h1>Update Master Customer</h1>
        <form action="updatecustomer" method="POST">
            <table>
                <%!
                pencucian pen =  new pencucian();
                
                %>
                
                <%
                    DBConection dbc = DBConection.getInstance();
                    String id = request.getParameter("idcuci");
                    CarWashQuery cwq = new CarWashQuery(dbc.getCon());
                    pen = cwq.getPencu(id);
                    
                %>
                
                <tr>   
                    <th>ID CUCI</th>
                    <td><input type="text" name="idcustomer" value="<%=pen.getIdCuci()%>"></td>
                </tr>
                <tr>
                    <th>ID PEGAWAI</th>
                    <td><input type="text" name="idpegawai" value="<%=pen.getIdPegawai()%>"></td>
                </tr>
                <tr>
                    <th>ID CUSTOMER</th>
                    <td><input type="text" name="idcustomer" value="<%=pen.getIdCustomer()%>"></td>
                </tr>
                <tr>
                    <th>TGL CUCI</th>
                    <td><input type="text" name="tglcuci" value="<%=pen.getTglCuci()%>"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="Update"></td>
                    <td><input type="reset"  name="Reset"></td>
                </tr>
      
            </table>
     
        </form>
    </body>
</html>
