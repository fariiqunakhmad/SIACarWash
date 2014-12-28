/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sia.query;

import com.sia.model.JenisCOA;
import java.sql.Connection;
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
public class JenisCOAQuery  {
    private Connection conn=null;
    public JenisCOAQuery(Connection conn){
        this.conn=conn;
    }
    

    
    public void simpanJenisCOA(JenisCOA jenisCOA) {
        String sql = "INSERT INTO `jeniscoa`(`IDJCOA`,`NAMAJCOA`) VALUES(?,?)";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, jenisCOA.getIdJenisCOA());
        st.setString(2, jenisCOA.getNamaJenisCOA());
        st.executeUpdate();
        } catch (SQLException ex) {
        Logger.getLogger(JenisCOA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteJenisCOA(int idJenisCOA) {
        String sql = "DELETE FROM `jeniscoa` WHERE `IDJCOA`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, idJenisCOA);
        st.executeUpdate();
        } catch (SQLException ex) {
        Logger.getLogger(JenisCOA.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public void updateJenisCOA(int idJenisCOA, JenisCOA jenisCOA) {
        String sql = "UPDATE `jeniscoa` SET `NAMAJCOA`=? WHERE `IDJCOA`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, jenisCOA.getNamaJenisCOA());
        st.setInt(2, idJenisCOA);
        st.executeUpdate();
        } catch (SQLException ex) {
        Logger.getLogger(JenisCOA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public JenisCOA load(int idJenisCOA) {
        JenisCOA jenisCOA = null;
        String sql = "SELECT * FROM `jeniscoa` WHERE `IDJCOA`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, idJenisCOA);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
        jenisCOA = new JenisCOA();
        jenisCOA.setIdJenisCOA(rs.getInt(1));
        jenisCOA.setNamaJenisCOA(rs.getString(2));
        }
        } catch (SQLException ex) {
        Logger.getLogger(JenisCOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jenisCOA;
    }

    public List<JenisCOA> getAll() {
        String sql = "SELECT * FROM `jeniscoa`";
        List<JenisCOA> list = new ArrayList<JenisCOA>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                JenisCOA jenisCOA = new JenisCOA();
                jenisCOA.setIdJenisCOA(rs.getInt(1));
                jenisCOA.setNamaJenisCOA(rs.getString(2));
                list.add(jenisCOA);
            }
        } catch (SQLException ex) {
        Logger.getLogger(JenisCOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<JenisCOA> getAllS(int idJenisCOA) {
        String sql = "SELECT * FROM `jeniscoa` WHERE `IDJCOA`=? UNION SELECT * FROM `jeniscoa` WHERE `IDJCOA`!=? ";
        List<JenisCOA> list = new ArrayList<JenisCOA>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idJenisCOA);
            st.setInt(2, idJenisCOA);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                JenisCOA jenisCOA = new JenisCOA();
                jenisCOA.setIdJenisCOA(rs.getInt(1));
                jenisCOA.setNamaJenisCOA(rs.getString(2));
                list.add(jenisCOA);
            }
        } catch (SQLException ex) {
        Logger.getLogger(JenisCOA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    

    

   
    
}
