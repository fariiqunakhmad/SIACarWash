<%-- 
    Document   : formcustomer
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>

<%@page import="com.sia.model.Perlengkapan"%>
<%@page import="com.sia.query.PerlengkapanQuery"%>
<%@page import="com.sia.utils.DBConnection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form 
            Perlengkapan</title>
    </head>
    <body>
        <h1 align="center">Input Data Perlengkapan</h1>
        <form action="insertperkap" method="POST">
            <table align="center">
                <tr>
                    <td>ID PERLENGKAPAN</td>
                    <td><input type="text" name="txtidperkap"></td>
                </tr>
                
                <tr>
                    <td>NAMA PERLENGKAPAN</td>
                    <td><input type="text" name="txtnamaperkap"></td>
                </tr>
                
                
                <tr>
                    <td><input type="submit" value="submit"></td>
                    <td><input type="reset" value="clear form"></td>
                </tr>
                
            </table>
            
            
        </form>
        
        <br><br>        
        <table align="center" border="2" >  
    <th>Id Perlengkapan</th>
    <th>Nama Perlengkapan</th>
    
    <th colspan="2">CONTROL</th>
   
    <%!
        public List <Perlengkapan> data =
                new ArrayList <Perlengkapan>();
    %>
    
    <%
        DBConnection conn= DBConnection.getInstance();
        int row=0;
           
        PerlengkapanQuery mq=new PerlengkapanQuery(conn.getCon());
        data= mq.getAll2();
        
        for(row=0; this.data.size()>row; row++){
            Perlengkapan p=data.get(row);
            out.print("<tr>");
            out.print("<td>");
            out.print(p.getIdPerkap());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getNamaPerkap());
            out.print("</td>");
            out.print("<td>");%>
            <a href="updateperlengkapan.jsp?txtidperkap=<%=data.get(row).getIdPerkap()%>">Update</a>
            <%out.print("</td>");
            out.print("<td>"); %>
            <a href="deleteperkap?txtidperkap=<%=data.get(row).getIdPerkap()%>">Delete</a>
            <%out.print("</td>");
            
            out.print("</tr>");
            
        }
    %>
     </table>
        
    </body>
</html>
