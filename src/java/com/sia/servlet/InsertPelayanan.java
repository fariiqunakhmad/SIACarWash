/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sia.servlet;

import com.id.dao.CarWashDAO;
import com.sia.utils.DBConnection;
import com.sia.model.pelayanan;
import com.sia.query.CarWashQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AHSMP
 */
@WebServlet(name = "InsertCustomer", urlPatterns = {"/insert_pelayanan"})
public class InsertPelayanan extends HttpServlet {

    DBConnection dbc = DBConnection.getInstance();
    pelayanan p = new pelayanan();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            p.setIdPel(request.getParameter("idpelayanan"));
            p.setNamaPel(request.getParameter("namapelayanan"));
            p.setHargaPel(Integer.parseInt(request.getParameter("hargapelayanan")));
           
            
            try{
                CarWashDAO cwd = new CarWashQuery(dbc.getCon());
                cwd.insertPel(p);
                
            }catch(SQLException ex){
                System.out.println("gagal karena" + ex);
                
            }
            
        
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>InsertCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertCustomer at " + request.getContextPath() + "</h1>");
            out.println("<META HTTP-EQUIV=\"Refresh\"CONTENT=\"1;URL=pelayanan.jsp\">");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
