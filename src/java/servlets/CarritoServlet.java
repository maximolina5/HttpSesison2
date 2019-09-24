/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 *
 * @author maxim
 */
@WebServlet(name = "CarritoServlet", urlPatterns = {"/CarritoServlet"})
public class CarritoServlet extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String articuloNuevo = request.getParameter("articulo");
        
        HttpSession sesion = request.getSession();
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        if(articulos == null){
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }
        if(articuloNuevo != null && !articuloNuevo.trim().equals("")){
            articulos.add(articuloNuevo);
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Lista de Art&iacute;culos</h1>");
            out.println("<br>");
            for(String articulo : articulos){
                out.print("<LI>" + articulo + "</LI>");
            }
            out.println("<br>");
            out.println("<a href='/EjemploCarritoCompras'>Regresar</a>");            
            out.close();
        }
    }
}

//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
