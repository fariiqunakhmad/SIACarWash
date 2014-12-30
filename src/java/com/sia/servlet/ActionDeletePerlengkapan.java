/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sia.servlet;

import com.sia.model.Perlengkapan;
import com.sia.query.PerlengkapanQuery;
import com.sia.utils.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author ibnu
 */
@WebServlet(name = "ActionDeletePerlengkapan", urlPatterns = {"/deleteperkap"})
public class ActionDeletePerlengkapan extends HttpServlet {
    
    DBConnection dbc = DBConnection.getInstance();
    Perlengkapan br  = new Perlengkapan();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        br.setIdPerkap(request.getParameter("txtidperkap"));
        
        try {
            PerlengkapanQuery mx = new PerlengkapanQuery(dbc.getCon());
            mx.deleteCustomer(request.getParameter("txtidperkap"));
            System.out.println("delete sukses");
        } catch (Exception e) {
            System.out.println("Gagal karena " +e);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActionInsertMK</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Data Berhasil ditambahkan di " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {          
            response.sendRedirect("formperlengkapan.jsp");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
