/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sia.query;

import com.sia.model.COA;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akhmad Fariiqun
 */
public class COAQuery  {
    private Connection conn=null;
    public COAQuery(Connection conn){
        this.conn=conn;
    }
    

    
    public void simpanCOA(COA cOA) {
        String sql = "INSERT INTO `coa`(`IDCOA`, `IDJCOA`, `NAMACOA`, `SALDOAWALCOA`, `TANGGALBUKACOA`, `STAT`) VALUES(?,?,?,?,?,?)";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, cOA.getIdCOA());
        st.setInt(2, cOA.getIdJenisCOA());
        st.setString(3, cOA.getNamaCOA());
        st.setString(4, cOA.getSaldoAwalCOA());
        st.setString(5, String.valueOf(cOA.getTglBukaCOA()));
        st.setString(6, cOA.getStatCOA());
        st.executeUpdate();
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void deleteCOA(String idCOA) {
        String sql = "DELETE FROM `coa` WHERE `IDCOA`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, idCOA);
        st.executeUpdate();
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    
    public void updateCOA(String idCOA, COA cOA) {
        String sql = "UPDATE `coa` SET `IDJCOA`=?,`NAMACOA`=?,`SALDOAWALCOA`=?, `STAT`=? WHERE `IDCOA`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, cOA.getIdJenisCOA());
        st.setString(2, cOA.getNamaCOA());
        st.setString(3, cOA.getSaldoAwalCOA());
        st.setString(4, cOA.getStatCOA());
        st.setString(5, idCOA);
        st.executeUpdate();
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public COA load(String idCOA) {
        COA cOA = null;
        String sql = "SELECT * FROM `coa` WHERE `IDCOA`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, idCOA);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
        cOA = new COA();
        cOA.setIdCOA(rs.getString(1));
        cOA.setIdJenisCOA(rs.getInt(2));
        cOA.setNamaCOA(rs.getString(3));
        cOA.setSaldoAwalCOA(rs.getString(4));
        cOA.setTglBukaCOA(Date.valueOf(rs.getString(5)));
        cOA.setStatCOA(rs.getString(6));
        }
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cOA;
    }

    
    public List<COA> getAll() {
        String sql = "SELECT * FROM cOA";
        List<COA> list = new ArrayList<COA>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                COA cOA = new COA();
                cOA.setIdCOA(rs.getString(1));
                cOA.setIdJenisCOA(rs.getInt(2));
                cOA.setNamaCOA(rs.getString(3));
                cOA.setSaldoAwalCOA(rs.getString(4));
                cOA.setTglBukaCOA(Date.valueOf(rs.getString(5)));
                cOA.setStatCOA(rs.getString(6));
                list.add(cOA);
            }
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<COA> getAllS(String id) {
        String sql = "SELECT * FROM `coa` WHERE `IDCOA`=? UNION SELECT * FROM `coa` WHERE `IDCOA`!=? ";
        List<COA> list = new ArrayList<COA>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                COA cOA = new COA();
                cOA.setIdCOA(rs.getString(1));
                cOA.setIdJenisCOA(rs.getInt(2));
                cOA.setNamaCOA(rs.getString(3));
                cOA.setSaldoAwalCOA(rs.getString(4));
                cOA.setTglBukaCOA(Date.valueOf(rs.getString(5)));
                cOA.setStatCOA(rs.getString(6));
                list.add(cOA);
            }
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    

    

   
    
}
