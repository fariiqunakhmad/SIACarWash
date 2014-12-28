/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sia.servlet;

import com.sia.model.JenisCOA;
import com.sia.query.JenisCOAQuery;
import com.sia.utils.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "InsertJenisCOA", urlPatterns = {"/insertJenisCOA"})
public class InsertJenisCOA extends HttpServlet {
DBConnection dbc = DBConnection.getInstance();
JenisCOA jenisCOA = new JenisCOA();
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
        
        jenisCOA.setIdJenisCOA(Integer.parseInt(request.getParameter("txtIdJenisCOA")));
        jenisCOA.setNamaJenisCOA(request.getParameter("txtNamaJenisCOA"));
       
        
        try{
            JenisCOAQuery jenisCOAq = new JenisCOAQuery(dbc.getCon());
            jenisCOAq.simpanJenisCOA(jenisCOA);
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
            out.println("<title>Servlet InsertJenisCOA</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertJenisCOA at " + request.getContextPath() + "</h1>");
            out.println("<br><a href='index.jsp'> Home </a>");
            out.println("<br><a href='daftarjenisCOA.jsp'> Daftar JenisCOA</a>");
            out.print(jenisCOA.getIdJenisCOA()+","+jenisCOA.getNamaJenisCOA());
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("daftarjcoa.jsp");
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
