/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.basico;

import DAO.InfinitiComicsDAO;
import entities.User;
import exeption.InfinityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablourbano
 */
public class cambiarUsuario extends HttpServlet {

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
            User u1 = (User) request.getSession().getAttribute("user");
            
            String nombre = request.getParameter("nombre");
            String username = u1.getUsername();
            String pass = request.getParameter("password");
            String ciudad = request.getParameter("ciudad");
            String tipo = u1.getTipo();
            
            User u2 = new User(nombre, username, pass, 0, ciudad, tipo);
            try {
                System.out.println("1");
                if(dao.getUser(u1.getUsername())!= null){
                    System.out.println("2");
                    dao.updateProfile(u2);
                    request.setAttribute("status", "Usuario updateado");
                }else{
                    request.setAttribute("status", "1 No se pudo updatear el usuario");
                }
                
            } catch (SQLException ex) {
                request.setAttribute("status", "2 No se pudo updatear el usuario");
            } catch (ClassNotFoundException ex) {
               request.setAttribute("status", "3 No se pudo updatear el usuario");
            }
            
            request.getRequestDispatcher("/final.jsp").forward(request, response);
            
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
