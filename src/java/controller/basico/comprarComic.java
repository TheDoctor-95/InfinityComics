/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.basico;

import DAO.InfinitiComicsDAO;
import entities.Comic;
import entities.User;
import exeption.InfinityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablourbano
 */
public class comprarComic extends HttpServlet {

    InfinitiComicsDAO dao = new InfinitiComicsDAO();
    
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                InfinitiComicsDAO dao = new InfinitiComicsDAO();
                Comic c = dao.getComicsById(Integer.parseInt(request.getParameter("idComic")));
                User u = (User) request.getSession().getAttribute("user");
                
                User tienda =  dao.getUser(request.getParameter("tienda")) ;
                System.out.println(c);
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                System.out.println(u);
                System.out.println(cant);
                dao.comprarComic(c,u, tienda, cant);
                request.getSession().setAttribute("user", dao.getUser(u.getUsername()));
                request.setAttribute("status", "Comic comprado");
                request.getRequestDispatcher("/final.jsp").forward(request, response);
                
            } catch (SQLException | ClassNotFoundException | InfinityException ex) {
                request.setAttribute("status", ex.getMessage());
                request.getRequestDispatcher("/final.jsp").forward(request, response);
            }
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
