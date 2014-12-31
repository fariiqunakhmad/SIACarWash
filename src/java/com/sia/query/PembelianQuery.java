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
import com.sia.model.Pemasok;
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

public class PembelianQuery {

    private Connection conn = null;

    public PembelianQuery(Connection conn) {
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

   

    public List<Pembelian> getAll2() {
        String sql = "select * from pembelian_perlengkapan";
        List<Pembelian> list = new ArrayList<Pembelian>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pembelian p = new Pembelian();
                p.setIdPembelian(rs.getString(1));
                p.setPemasok(rs.getInt(2));
                p.setPegawai(rs.getString(3));
                p.setTanggal(Date.valueOf(rs.getString(4)));
                
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembelianQuery.class.getName());
        }
        return list;
    
    }
   
    

  
    public void simpanPembelian(Pembelian p) {
        String sql = "INSERT INTO pembelian_perlengkapan (ID_PP, NO_PEMASOK, ID_PEG, TGL_PP) VALUES(?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, p.getIdPembelian());
            st.setInt(2, p.getPemasok());
            st.setString(3, p.getPegawai());
            st.setString(4, String.valueOf(p.getTanggal()));
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePembelian(Pembelian p) {
         String sql = "UPDATE pembelian_perlengkapan SET "
                + " NO_PEMASOK = ?, ID_PEG = ?, TGL_PP = ? "
                 + " where ID_PP = ? ";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, p.getPemasok());
            pst.setString(2, p.getPegawai());
            pst.setString(3, String.valueOf(p.getTanggal()));
            pst.setString(4, p.getIdPembelian());
          pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Gagal karena " + e);
        }
    }
    
    public void deletePembelian(String ki) {
        String sql = "DELETE FROM pembelian_perlengkapan WHERE ID_PP=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ki);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Perlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pembelian load(String idPembelian) {
        Pembelian p = null;
        String sql = "SELECT * FROM `pembelian_perlengkapan` WHERE `ID_PP`=?";
        try {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, idPembelian);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
        p = new Pembelian();
        p.setIdPembelian(rs.getString(1));
        p.setPemasok(rs.getInt(2));
        p.setPegawai(rs.getString(3));
        p.setTanggal(Date.valueOf(rs.getString(4)));
        
        }
        } catch (SQLException ex) {
        Logger.getLogger(COA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
  
    public Pembelian getAll(String idPembelian) {
        Pembelian p = null;
        String sql = "SELECT ID_PP, NO_PEMASOK, ID_PEG, TGL_PP FROM pembelian_perlengkapan WHERE ID_PP = ?";
       try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, idPembelian);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p = new Pembelian();
                p.setIdPembelian(rs.getString(1));
                p.setPemasok(rs.getInt(2));
                p.setPegawai(rs.getString(3));
                p.setTanggal(Date.valueOf(rs.getString(4)));
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(Perlengkapan.class.getName()).log(Level.SEVERE, null, ex);
        }
            return p;
    }

   

   

    

   
}
