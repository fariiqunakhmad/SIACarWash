/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Akhmad Fariiqun
 */
public class DBConnection {
    private Connection conn = null;
    private static DBConnection dbConn =null;
    static final String DB_URL="jdbc:mysql://localhost:3306/siacarwash";
    static final String DB_USER="root";
    static final String DB_PASS="";
    
    private DBConnection(){
        testConnection();
    }
    private void testConnection(){
        if(conn==null){
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn=DriverManager.getConnection(DB_URL,DB_USER, DB_PASS);
                
            } catch (Exception e){
                System.out.println("Gagal karena "+e);
            }
        }
    }
    public static DBConnection getInstance(){
        DBConnection conn =null;
        if(dbConn==null){
            dbConn=new DBConnection();
            conn=dbConn;
        }else{
            conn=dbConn;
        }
        return conn;
    }
    public Connection getCon() throws SQLException{
        return  this.conn;
    }
}
