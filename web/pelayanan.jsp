

<%@page import="cr.id.model.pelayanan"%>
<%@page import="cr.id.model.pencucian"%>
<%@page import="cr.id.query.CarWashQuery"%>
<%@page import="cr.id.include.DBConection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MASTER PELAYANAN</h1>
        
        <form action="#" method="POST">
            <table border="1">
                <tr>
                    <th>ID PELAYANAN                </th>
                    <th>NAMA PELAYANAN             </th>
                    <th>HARGA            </th>
                    <th>ACTION</th>             
                </tr>
                
                <%!
                public List<pelayanan> data = new ArrayList<pelayanan>();
                %>
                
                <%
                DBConection dbc = DBConection.getInstance();
                int r = 0;
                CarWashQuery cwq = new CarWashQuery(dbc.getCon());
                data = cwq.getAllPel();
                for(r=0 ; this.data.size() > r ; r++){
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(data.get(r).getIdPel());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(data.get(r).getNamaPel());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(data.get(r).getHargaPel());
                    out.print("</td>");
                    out.print("</tr>");
                    out.print("<td>");%>
                    <a href="updatepelayanan.jsp?idcuci=<%data.get(r).getIdPel();%>">Update</a>
                    <%out.print("</td>");
                     out.print("<td>");
      
                }%>
                
            </table>
                <p><a href="insertpelayanan.jsp">Insert Customer[+]</a></p>
        </form>
   </body>
</html>
