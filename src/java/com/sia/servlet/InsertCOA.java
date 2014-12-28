/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sia.servlet;

import com.sia.model.COA;
import com.sia.query.COAQuery;
import com.sia.utils.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Akhmad Fariiqun Awwa
 */
@WebServlet(name = "InsertCOA", urlPatterns = {"/insertCOA"})
public class InsertCOA extends HttpServlet {
DBConnection dbc = DBConnection.getInstance();
COA cOA = new COA();
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
        
        cOA.setIdCOA(request.getParameter("txtIdCOA"));
        cOA.setIdJenisCOA(Integer.parseInt(request.getParameter("txtIdJenisCOA")));
        cOA.setNamaCOA(request.getParameter("txtNamaCOA"));
        cOA.setSaldoAwalCOA(request.getParameter("txtSaldoAwalCOA"));
        cOA.setTglBukaCOA(Date.valueOf(request.getParameter("txtTglBukaCOA")));
        cOA.setStatCOA(request.getParameter("txtStatCOA"));

        
        try{
            COAQuery cOAq = new COAQuery(dbc.getCon());
            cOAq.simpanCOA(cOA);
            System.out.println("Insert Sukses");
        } catch (Exception e){
            System.out.println("Gagal karena : "+ e);
        }
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertCOA</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertCOA at " + request.getContextPath() + "</h1>");
            out.println("<br><a href='index.jsp'> Home </a>");
            out.println("<br><a href='daftarcOA.jsp'> Daftar COA</a>");
            out.print(cOA.getIdJenisCOA()+","+cOA.getIdCOA()+","+cOA.getNamaCOA()+","+cOA.getSaldoAwalCOA()+","+cOA.getTglBukaCOA()+"'"+cOA.getStatCOA());
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("daftarcoa.jsp");
        } finally {            
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
