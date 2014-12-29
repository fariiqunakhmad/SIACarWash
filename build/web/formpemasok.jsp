<%-- 
    Document   : formcustomer
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>

<%@page import="com.sia.query.PemasokQuery"%>
<%@page import="com.sia.model.Pemasok"%>
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
            Pemasok</title>
    </head>
    <body>
        <h1 align="center">Input Data Pemasok</h1>
        <form action="insertpemasok" method="POST">
            <table align="center">
                <tr>
                    <td>ID PEMASOK</td>
                    <td><input type="text" name="txtid"></td>
                </tr>
                
                <tr>
                    <td>NAMA PEMASOK</td>
                    <td><input type="text" name="txtnama"></td>
                </tr>
                
                <tr>
                    <td>TELEPON</td>
                    <td><input type="text" name="txttlp"></td>
                </tr>
                
                <tr>
                    <td>ALAMAT</td>
                    <td><input type="text" name="txtalamat"></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="submit"></td>
                    <td><input type="reset" value="clear form"></td>
                </tr>
                
            </table>
            
            
        </form>
        
        <br><br>        
        <table align="center" border="2" >  
    <th>Id Pemasok</th>
    <th>Nama Pemasok</th>
    <th>Telepon</th>
    <th>Alamat</th>
    
    <th colspan="2">CONTROL</th>
   
    <%!
        public List <Pemasok> data =
                new ArrayList <Pemasok>();
    %>
    
    <%
        DBConnection conn= DBConnection.getInstance();
        int row=0;
           
        PemasokQuery mq=new PemasokQuery(conn.getCon());
        data= mq.getAll2();
        
        for(row=0; this.data.size()>row; row++){
            Pemasok p=data.get(row);
            out.print("<tr>");
            out.print("<td>");
            out.print(p.getIdPemasok());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getNamaPemasok());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getTelepon());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getAlamat());
            out.print("</td>");
            out.print("<td>");%>
            <a href="updatepemasok.jsp?txtid=<%=data.get(row).getIdPemasok()%>">Update</a>
            <%out.print("</td>");
            out.print("<td>"); %>
            <a href="deletepemasok?txtid=<%=data.get(row).getIdPemasok()%>">Delete</a>
            <%out.print("</td>");
            
            out.print("</tr>");
            
        }
    %>
     </table>
        
    </body>
</html>
