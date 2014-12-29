<%-- 
    Document   : formcustomer
    Created on : Sep 26, 2014, 9:33:44 AM
    Author     : ibnu
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.sia.query.PembelianQuery"%>
<%@page import="com.sia.model.Pembelian"%>
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
            Pembelian</title>
    </head>
    <body>
        <%
            java.util.Calendar cal = java.util.Calendar.getInstance();
            java.util.Date utilDate = cal.getTime();
            
            String timeStamp = new SimpleDateFormat("ddHHmmss").format(Calendar.getInstance().getTime());
            String idPP="PP"+timeStamp, idPetugasPBB="PEG01", idPengambilPBB="", action;
        java.sql.Date tglPP = new java.sql.Date(utilDate.getTime());
        %>
        <h1 align="center">Input Data Pembelian</h1>
        <form action="insertpembelian" method="POST">
            <table align="center">
                <tr>
                    <td>ID PEMBELIAN</td>
                    <td><input type="text" name="txtid" value="<% out.print(idPP);%>"></td>
                </tr>
                
                <tr>
                <tr>
                    <td>PEMASOK</td>
                <%!
                public List<Pemasok> datap = new ArrayList<Pemasok>();
                %>

                
                    <td><select name="txtpemasok">
                <%
                DBConnection dbc = DBConnection.getInstance();
                int r = 0;
               PemasokQuery kt = new PemasokQuery(dbc.getCon());
                datap = kt.getAll2();
                
                            for (r = 0; this.data.size() > r; r++) {
                            out.print("<option value=");
                            out.print(datap.get(r).getIdPemasok());
                            out.print(">");
                            out.print(datap.get(r).getNamaPemasok());
                            out.print("</option>");
                            }
                %>            
                        </select>
                </tr>
                
                <tr>
                    <td>PEGAWAI</td>
                    <td><input type="text" name="txtpeg" value="peg_001" readonly="" ></td>
                </tr>
                
                <tr>
                    <td>TANGGAL</td>
                    <td><input type="text" name="txttgl" readonly="" value="<% out.print(tglPP);%>"></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="submit"></td>
                    <td><input type="reset" value="clear form"></td>
                </tr>
                
            </table>
            
            
        </form>
        
        <br><br>        
        <table align="center" border="2" >  
    <th>Id Pembelian</th>
    <th>Pemasok</th>
    <th>Pegawai</th>
    <th>Tanggal</th>
    
    <th colspan="2">CONTROL</th>
   
    <%!
        public List <Pembelian> data =
                new ArrayList <Pembelian>();
    %>
    
    <%
        DBConnection conn= DBConnection.getInstance();
        int row=0;
           
        PembelianQuery mq=new PembelianQuery(conn.getCon());
        data= mq.getAll2();
        
        for(row=0; this.data.size()>row; row++){
            Pembelian p=data.get(row);
            out.print("<tr>");
            out.print("<td>");
            out.print(p.getIdPembelian());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getPemasok());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getPegawai());
            out.print("</td>");
            out.print("<td>");
            out.print(p.getTanggal());
            out.print("</td>");
            out.print("<td>");%>
            <a href="updatepembelian.jsp?txtid=<%=data.get(row).getIdPembelian()%>">Update</a>
            <%out.print("</td>");
            out.print("<td>"); %>
            <a href="deletepembelian?txtid=<%=data.get(row).getIdPembelian()%>">Delete</a>
            <%out.print("</td>");
            
            out.print("</tr>");
            
        }
    %>
     </table>
        
    </body>
</html>
