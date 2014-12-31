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
        <title>INSERT PENCUCIAN CAR WASH ABAH HITAM</title>
    </head>
    <body>
        <form action="insert_pencucian" method="POST">
            <table>
                <tr>
                    <th>ID CUCI           </th>
                    <td><input type="text" name="idcuci"></td>
                </tr>
                <tr>
                    <th>ID PEGAWAI         </th>
                    <td><input type="text" name="idpegawai"></td>
                </tr>
                <tr>
                    <th>ID CUSTOMER       </th>
                    <td><input type="text" name="idcustomer"></td>
                </tr>
                <tr>
                    <th>TGL CUCI      </th>
                    <td><input type="text" name="tglcuci"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="SIMPAN"></td>
                    <td><input type="reset" name="RESET"></td>
                </tr>    
            </table>
        </form>
    </body>
</html>
