

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
        <h1>MASTER PENCUCIAN</h1>
        
        <form action="#" method="POST">
            <table border="1">
                <tr>
                    <th>ID CUCI                </th>
                    <th>ID PEGAWAI              </th>
                    <th>ID CUSTOMER            </th>
                    <th>TGL CUCI           </th>
                    <th>ACTION</th>             
                </tr>
                
                <%!
                public List<pencucian> data = new ArrayList<pencucian>();
                %>
                
                <%
                DBConection dbc = DBConection.getInstance();
                int r = 0;
                CarWashQuery cwq = new CarWashQuery(dbc.getCon());
                data = cwq.getAllPencu();
                for(r=0 ; this.data.size() > r ; r++){
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(data.get(r).getIdCuci());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(data.get(r).getIdPegawai());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(data.get(r).getIdCustomer());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(data.get(r).getTglCuci());
                    out.print("</td>");
                    out.print("</tr>");
                    out.print("<td>");%>
                    <a href="updatepencucian.jsp?idcuci=<%data.get(r).getIdCuci();%>">Update</a>
                    <%out.print("</td>");
                     out.print("<td>");
      
                }%>
                
            </table>
                <p><a href="insertcpencucian.jsp">Insert Customer[+]</a></p>
        </form>
   </body>
</html>
