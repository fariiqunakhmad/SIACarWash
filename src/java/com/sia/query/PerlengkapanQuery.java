/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sia.query;

/**
 *
 * @author ibnu
 */
import com.sia.model.COA;
import com.sia.model.Pembelian;
import com.sia.model.Perlengkapan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerlengkapanQuery {

    private Connection conn = null;

    public PerlengkapanQuery(Connection conn) {
        this.conn = conn;
    }

//    public void insert(Customer cs) {
//        String sql = "INSERT INTO customer(KODE_MK,NAMA_MK,SEMESTER,SKS) VALUES(?,?,?,?)";
//        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(1, cs.getKodeCustomer());
//            st.setString(2, cs.getNamaCustomer());
//            st.setString(3, cs.getTelepon());
//            st.setString(4, cs.getAlamat());
//            st.setString(5, cs.getEmail());
//            st.setString(6, cs.getKodepos());
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public void delete(String nis) {
//        String sql = "DELETE FROM mk WHERE KODE_MK=?";
//        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(1, nis);
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public Customer loadNama(String nama) {
//        Customer cs = null;
//        String sql = "SELECT NO_KTP_PELANGGAN,ID_KOTA, ALAMAT_PELANGGAN, NO_HP_PELANGGAN, JK_PELANGGAN FROM pelanngan WHERE NAMA_PELANGGAN=?";
//        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                cs = new Customer();
//                cs.setNoKtpPel(rs.getString(1));
//                cs.setKotaPel(rs.getString(2));
//                cs.setNamaPel(rs.getString(3));
//                cs.setAlamatPel(rs.getString(4));
//                cs.setNoHpPel(rs.getString(5));
//                cs.setJkPel(rs.getString(6));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cs;
//    }

    public Perlengkapan load(String idPerlengkapan) {
        Perlengkapan p = null;
        String sql = "SELECT * FROM `perlengkapan` WHERE `ID_PERLENGKAPAN`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, idPerlengkapan);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
        p = new Perlengkapan();
        p.setIdPerkap(rs.getString(1));
        p.setNamaPerkap(rs.getString(2));
        
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public List<Perlengkapan> getAll() {
        Perlengkapan p = null;
        String sql = "SELECT NO_KTP_PELANGGAN,ID_KOTA, NAMA_PELANGGAN, ALAMAT_PELANGGAN, NO_HP_PELANGGAN, JK_PELANGGAN FROM pelanngan";
        List<Perlengkapan> list = new ArrayList<Perlengkapan>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Perlengkapan();
                p.setIdPerkap(rs.getString(1));
                p.setNamaPerkap(rs.getString(2));
               
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Perlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
//    public Customer load(String kodecustomer) {
//        Customer cs = null;
//        String sql = "SELECT KODE_MK,NAMA_MK,SEMESTER,SKS FROM mk WHERE KODE_MK=?";
//        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(1, kodecustomer);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                cs = new Customer();
//                cs.setKodeCustomer(rs.getString(1));
//                cs.setNamaCustomer(rs.getString(2));
//                cs.setTelepon(rs.getString(3));
//                cs.setAlamat(rs.getString(4));
//                cs.setEmail(rs.getString(5));
//                cs.setKodepos(rs.getString(6));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return cs;
//    }

//    public void update(String oldKodeMk, Customer mk) {
//        String sql = "UPDATE mk SET NAMA_MK=?,SEMESTER=?,SKS=? WHERE KODE_MK=?";
//        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(1, mk.getKodeMK());
//            st.setString(2, mk.getNamaMataKuliah());
//            st.setString(3, mk.getSemester());
//            st.setString(4, mk.getSks());
//            st.executeUpdate();
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public List<Customer> getAllKodeMK(String kodemk) {
//        String sql = "SELECT * FROM customer WHERE ID_CUSTOMER ?";
//        List<Customer> list = new ArrayList<Customer>();
//        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(1, "%" + kodemk + "%");
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Customer cs = new Customer();
//                cs.setKodeCustomer(rs.getString(1));
//                cs.setNamaCustomer(rs.getString(2));
//                cs.setTelepon(rs.getString(3));
//                cs.setAlamat(rs.getString(4));
//                cs.setEmail(rs.getString(5));
//                cs.setKodepos(rs.getString(6));
//                list.add(cs);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }

   

    public List<Perlengkapan> getAll2() {
        String sql = "select * from perlengkapan";
        List<Perlengkapan> list = new ArrayList<Perlengkapan>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Perlengkapan p = new Perlengkapan();
                p.setIdPerkap(rs.getString(1));
                p.setNamaPerkap(rs.getString(2));
                
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerlengkapanQuery.class.getName());
        }
        return list;
    
    }
   
    

  
    public void simpanPerlengkapan(Perlengkapan p) {
        String sql = "INSERT INTO perlengkapan (ID_PERLENGKAPAN,NAMA_PERLENGKAPAN) VALUES(?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, p.getIdPerkap());
            st.setString(2, p.getNamaPerkap());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Perlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePerlengkapan(Perlengkapan p) {
         String sql = "UPDATE perlengkapan SET "
                + " NAMA_PERLENGKAPAN = ? "
                 + " where ID_PERLENGKAPAN = ? ";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, p.getNamaPerkap());
            pst.setString(2, p.getIdPerkap());
          pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal karena " + e);
        }
    }
    
    public void deleteCustomer(String ki) {
        String sql = "DELETE FROM perlengkapan WHERE ID_PERLENGKAPAN=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ki);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Perlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    public Perlengkapan getAll(String idPerkap) {
        Perlengkapan p = null;
        String sql = "SELECT ID_PERLENGKAPAN, NAMA_PERLENGKAPAN FROM perlengkapan WHERE ID_PERLENGKAPAN = ?";
       try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, idPerkap);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p = new Perlengkapan();
                p.setIdPerkap(rs.getString(1));
                p.setNamaPerkap(rs.getString(2));
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Perlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
            return p;
    }

   

   

    

   
}
