/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sia.query;

import com.sia.model.Pegawai;
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
public class PegawaiQuery  {
    private Connection conn=null;
    public PegawaiQuery(Connection conn){
        this.conn=conn;
    }
    

    
    
    public List<Pegawai> getAllS(String idPegawai) {
        String sql = "SELECT * FROM `pegawai` WHERE `IDJPegawai`=? UNION SELECT * FROM `pegawai` WHERE `IDJPegawai`!=? ";
        List<Pegawai> list = new ArrayList<Pegawai>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, idPegawai);
            st.setString(2, idPegawai);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setIdPeg(rs.getString(1));
                pegawai.setNamaPeg(rs.getString(2));
                list.add(pegawai);
            }
        } catch (SQLException ex) {
        Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Pegawai login(String idPegawai, String pass){
        String sql= "SELECT * FROM `pegawai` WHERE `ID_PEG`=? AND `PASS_PEG`=?";
        Pegawai pegawai = null;
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, idPegawai);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            pegawai = new Pegawai();
            pegawai.setIdPeg(rs.getString(1));
            pegawai.setNamaPeg(rs.getString(2));
            pegawai.setJkPeg(rs.getString(3));
            pegawai.setPassPeg(rs.getString(4));
                System.out.println(pegawai.getIdPeg());
                System.out.println(pegawai.getNamaPeg());
                System.out.println(pegawai.getJkPeg());
                System.out.println(pegawai.getPassPeg());
            }
        } catch (SQLException ex) {
        Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pegawai;
    }

    

    

   
    
}
