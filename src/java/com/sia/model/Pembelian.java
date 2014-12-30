/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sia.model;

import java.sql.Date;

/**
 *
 * @author ibnu
 */
public class Pembelian {
private String idPembelian;
private int pemasok;
private String pegawai;
private Date tanggal;

    /**
     * @return the idPembelian
     */
    public String getIdPembelian() {
        return idPembelian;
    }

    /**
     * @param idPembelian the idPembelian to set
     */
    public void setIdPembelian(String idPembelian) {
        this.idPembelian = idPembelian;
    }

    /**
     * @return the pemasok
     */
    public int getPemasok() {
        return pemasok;
    }

    /**
     * @param pemasok the pemasok to set
     */
    public void setPemasok(int pemasok) {
        this.pemasok = pemasok;
    }

    /**
     * @return the pegawai
     */
    public String getPegawai() {
        return pegawai;
    }

    /**
     * @param pegawai the pegawai to set
     */
    public void setPegawai(String pegawai) {
        this.pegawai = pegawai;
    }

    /**
     * @return the tanggal
     */
    public Date getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    
    

}