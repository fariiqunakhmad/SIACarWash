<%-- 
    Document   : insertcustomer
    Created on : Dec 29, 2014, 12:35:44 PM
    Author     : AHSMP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSERT PELAYANAN CAR WASH ABAH HITAM</title>
    </head>
    <body>
        <form action="insert_pelayanan" method="POST">
            <table>
                <tr>
                    <th>ID PELAYANAN           </th>
                    <td><input type="text" name="idpelayanan"></td>
                </tr>
                <tr>
                    <th>NAMA PELAYANAN         </th>
                    <td><input type="text" name="namapelayanan"></td>
                </tr>
                <tr>
                    <th>HARGA       </th>
                    <td><input type="text" name="harga"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="SIMPAN"></td>
                    <td><input type="reset" name="RESET"></td>
                </tr>    
            </table>
        </form>
    </body>
</html>
