/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sia.query;

/**
 *
 * @author AHSMP
 */
import com.id.dao.CarWashDAO;
import com.sia.model.customer;
import com.sia.model.pelayanan;
import com.sia.model.pencucian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarWashQuery implements CarWashDAO{
    private Connection conn = null;
    
    public CarWashQuery(Connection conn){
    
        this.conn= conn;            
    }
    
    
    @Override
    public List<customer> getAllCus() {
        String sql = "SELECT * FROM customer";
        List<customer> list = new ArrayList<customer>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                customer c = new customer();
                c.setIdCus(rs.getString(1));
                c.setNamaCus(rs.getString(2));
                c.setAlamatCus(rs.getString(3));
                c.setTlpCus((rs.getString(4)));
                c.setJkCus((rs.getInt(5)));
                c.setStat(rs.getString(6));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insertCus(customer c) {
    String sql = "INSERT INTO customer(IDCUS,NAMACUS,ALAMATCUS,TLPCUS,JKCUS,STAT) "
            + "VALUES(?,?,?,?,?,?)";
    try{
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, c.getIdCus());
        st.setString(2, c.getNamaCus());
        st.setString(3, c.getAlamatCus());
        st.setString(4, c.getTlpCus());
        st.setInt(5, c.getJkCus());
        st.setString(6, c.getStat());
        st.executeUpdate();
    }catch(SQLException ex){
        
    Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }
    
    
    @Override
    public void updateCus(customer c) {
        String sql="UPDATE customer SET namacus = ?, alamatcus = ?, tlpcus = ?, jkcus = ?, stat = ? "
                + "WHERE idcus = ?";
        
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, c.getNamaCus());
            st.setString(2, c.getAlamatCus());
            st.setString(3, c.getTlpCus());
            st.setInt(4, c.getJkCus());
            st.setString(5, c.getStat());
            st.setString(6, c.getIdCus());
            st.executeUpdate();
            
        }catch(SQLException ex){
            Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    
    @Override
    public void deleteCus(String idCus) {
       String sql ="DELETE FORM customer where idcus = ?";
       
       try{
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1, idCus);
           st.executeUpdate();
           
       }catch(SQLException ex){
           Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       }
    }

    
    @Override
    public customer getCus(String idCus) {
    customer c = null;
    String sql = "SELECT idcus, namacus, alamatcus, tlpcus, jkcus, stat FROM"
            + "CUSTOMER WHERE idcus=?";
    try{
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, idCus);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            c = new customer();
            c.setIdCus(rs.getString(1));
            c.setNamaCus(rs.getString(2));
            c.setAlamatCus(rs.getString(3));
            c.setTlpCus((rs.getString(4)));
            c.setJkCus(rs.getInt(5));
            c.setStat(rs.getString(6));
           
        }
    
    }catch(SQLException ex){
        Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
    }
        return c;
    }

    @Override
    public List<pelayanan> getAllPel() {
     String sql = "SELECT * FROM pelayanan ";
        List<pelayanan> p = new ArrayList<pelayanan>();
         try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pelayanan pel  = new pelayanan();
                pel.setIdPel(rs.getString(1));
                pel.setNamaPel(rs.getString(2));
                pel.setHargaPel(rs.getInt(3));
                p.add(pel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        
    }

    @Override
    public void insertPel(pelayanan p) {
    String sql = "INSERT INTO pelayanan(ID_PEL,NAMA_PEL,HARGA_PEL) "
            + "VALUES(?,?,?)";
    try{
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, p.getIdPel());
        st.setString(2, p.getNamaPel());
        st.setInt(3, p.getHargaPel());
        st.executeUpdate();
    }catch(SQLException ex){
        
    Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void updatePel(pelayanan p) {
        String sql="UPDATE pelayanan SET nama_pel = ?, harga_pel = ?"
                + "WHERE id_pel = ?";
        
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, p.getNamaPel());
            st.setInt(2, p.getHargaPel());
            st.setString(3, p.getIdPel());
            st.executeUpdate();
            
        }catch(SQLException ex){
            Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void deletePel(String idPel) {
        String sql ="DELETE FORM pelayanan where id_pel = ?";
       
       try{
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1, idPel);
           st.executeUpdate();
           
       }catch(SQLException ex){
           Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       }
    }

    @Override
    public pelayanan getPel(String idPel) {
          pelayanan pel = null;
    String sql = "SELECT id_pel, nama_pel, harga_pel FROM"
            + "PELAYANAN WHERE id_pel=?";
    try{
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, idPel);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            pel = new pelayanan();
            pel.setIdPel(rs.getString(1));
            pel.setNamaPel(rs.getString(2));
            pel.setHargaPel(rs.getInt(3));
           
                      
        }
    
    }catch(SQLException ex){
        Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
    }
        return pel;
        
    }

    @Override
    public List<pencucian> getAllPencu() {
        String sql = "SELECT * FROM pencucian ";
        List<pencucian> p = new ArrayList<pencucian>();
         try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pencucian pen  = new pencucian();
                pen.setIdCuci(rs.getString(1));
                pen.setIdPegawai(rs.getString(2));
                pen.setIdCustomer(rs.getString(3));
                pen.setTglCuci((rs.getString(4)));
                p.add(pen);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void insertPencu(pencucian pen) {
         String sql = "INSERT INTO pencucian(ID_CUCI,ID_PEG,IDCUS,TGL_CUCI) "
            + "VALUES(?,?,?,?)";
    try{
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, pen.getIdCuci());
        st.setString(2, pen.getIdPegawai());
        st.setString(3, pen.getIdCustomer());
        st.setString(4, pen.getTglCuci());
        st.executeUpdate();
    }catch(SQLException ex){
        
    Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void updatePencu(pencucian pen) {
                String sql="UPDATE pencucian SET id_peg = ?, idcus = ?, tgl_cuci = ?"
                + "WHERE id_cuci = ?";
        
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, pen.getIdPegawai());
            st.setString(2, pen.getIdCustomer());
            st.setString(3, pen.getTglCuci());
            st.setString( 4, pen.getIdCuci());
            st.executeUpdate();
            
        }catch(SQLException ex){
            Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void deletePencu(String idPen) {
        String sql ="DELETE FORM pencucian where id_cuci = ?";
       
       try{
           PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1, idPen);
           st.executeUpdate();
           
       }catch(SQLException ex){
           Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       }
    }

    @Override
    public pencucian getPencu(String idPen) {
    pencucian pen = null;
    String sql = "SELECT id_cuci, id_peg, idcus,tgl_cuci FROM"
            + "PENCUCIAN WHERE id_cuci=?";
    try{
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, idPen);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            pen = new pencucian();
            pen.setIdCuci(rs.getString(1));
            pen.setIdPegawai(rs.getString(2));
            pen.setIdCustomer(rs.getString(3));
            pen.setTglCuci((rs.getString(4)));
                      
        }
    
    }catch(SQLException ex){
        Logger.getLogger(CarWashDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
    }
        return pen;
    }

    
    
}
