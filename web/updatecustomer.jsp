<%-- 
    Document   : updatecustomer
    Created on : Dec 29, 2014, 4:04:05 PM
    Author     : AHSMP
--%>

<%@page import="cr.id.query.CarWashQuery"%>
<%@page import="cr.id.include.DBConection"%>
<%@page import="cr.id.model.customer"%>
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
                customer c =  new customer();
                
                %>
                
                <%
                    DBConection dbc = DBConection.getInstance();
                    String id = request.getParameter("idcustomer");
                    CarWashQuery cwq = new CarWashQuery(dbc.getCon());
                    c = cwq.getCus(id);
                    
                %>
                
                <tr>   
                    <th>ID </th>
                    <td><input type="text" name="idcustomer" value="<%=c.getIdCus()%>"></td>
                </tr>
                <tr>
                    <th>NAMA CUSTOMER</th>
                    <td><input type="text" name="namacustomer" value="<%=c.getNamaCus()%>"></td>
                </tr>
                <tr>
                    <th>ALAMAT CUSTOMER</th>
                    <td><input type="text" name="alamatcustomer" value="<%=c.getAlamatCus()%>"></td>
                </tr>
                <tr>
                    <th>TELEPON</th>
                    <td><input type="text" name="tlpcustomer" value="<%=c.getTlpCus()%>"></td>
                </tr>
                <tr> 
                    <th>JENIS KELAMIN</th>
                    <td><input type="text" name="jenis kelamin" value="<%=c.getJkCus()%>"></td>
                </tr>
                <tr>
                    <th>STATUS</th>
                    <td><input type="text" name="status" value="<%=c.getStat()%>"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="Update"></td>
                    <td><input type="reset"  name="Reset"></td>
                </tr>
      
            </table>
     
        </form>
    </body>
</html>
