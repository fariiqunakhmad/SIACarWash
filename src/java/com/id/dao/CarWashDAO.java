/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.dao;


import com.sia.model.customer;
import com.sia.model.pelayanan;
import com.sia.model.pencucian;
import java.util.List;

/**
 *
 * @author Cha Rock
 */
public interface CarWashDAO {
   
    public List<customer> getAllCus();
    public void insertCus(customer c);
    public void updateCus(customer c);
    public void deleteCus(String idCus);
    public customer getCus(String idCus);
    
    public List<pelayanan> getAllPel();
    public void insertPel(pelayanan p);
    public void updatePel(pelayanan p);
    public void deletePel(String idPel);
    public pelayanan getPel(String idPel);
    
    public List<pencucian> getAllPencu();
    public void insertPencu(pencucian pen);
    public void updatePencu(pencucian pen);
    public void deletePencu(String idPen);
    public pencucian getPencu(String idPen);
    
    
}
