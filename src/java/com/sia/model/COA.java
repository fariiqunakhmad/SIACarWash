/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sia.model;

import java.sql.Date;

/**
 *
 * @author Akhmad Fariiqun
 */
public class COA {
    private String idCOA, namaCOA, saldoAwalCOA, statCOA;
    private int idJenisCOA;
    private Date tglBukaCOA;

    /**
     * @return the idCOA
     */
    public String getIdCOA() {
        return idCOA;
    }

    /**
     * @param idCOA the idCOA to set
     */
    public void setIdCOA(String idCOA) {
        this.idCOA = idCOA;
    }

    /**
     * @return the idJenisCOA
     */
    public int getIdJenisCOA() {
        return idJenisCOA;
    }

    /**
     * @param idJenisCOA the idJenisCOA to set
     */
    public void setIdJenisCOA(int idJenisCOA) {
        this.idJenisCOA = idJenisCOA;
    }

    /**
     * @return the namaCOA
     */
    public String getNamaCOA() {
        return namaCOA;
    }

    /**
     * @param namaCOA the namaCOA to set
     */
    public void setNamaCOA(String namaCOA) {
        this.namaCOA = namaCOA;
    }

    /**
     * @return the saldoAwalCOA
     */
    public String getSaldoAwalCOA() {
        return saldoAwalCOA;
    }

    /**
     * @param saldoAwalCOA the saldoAwalCOA to set
     */
    public void setSaldoAwalCOA(String saldoAwalCOA) {
        this.saldoAwalCOA = saldoAwalCOA;
    }

    /**
     * @return the statCOA
     */
    public String getStatCOA() {
        return statCOA;
    }

    /**
     * @param statCOA the statCOA to set
     */
    public void setStatCOA(String statCOA) {
        this.statCOA = statCOA;
    }

    /**
     * @return the tglBukaCOA
     */
    public Date getTglBukaCOA() {
        return tglBukaCOA;
    }

    /**
     * @param tglBukaCOA the tglBukaCOA to set
     */
    public void setTglBukaCOA(Date tglBukaCOA) {
        this.tglBukaCOA = tglBukaCOA;
    }
    
}
