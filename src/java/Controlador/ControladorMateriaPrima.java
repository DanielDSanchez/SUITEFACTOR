/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MateriaPrima;
import ModeloDAO.MateriaPrimaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1Usuario
 */
public class ControladorMateriaPrima extends HttpServlet {
    String consultar = "Vistas/MateriaPrimaViews/Consultar.jsp";
    String registrar = "Vistas/MateriaPrimaViews/Registrar.jsp";
    MateriaPrima mp = new MateriaPrima();
    MateriaPrimaDAO mtDAO = new MateriaPrimaDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorMateriaPrima</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorMateriaPrima at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("consultar")){
            acceso=consultar;
        }else if(action.equalsIgnoreCase("registrar")){
            acceso=registrar;
        }else if(action.equalsIgnoreCase("Agregar")){
            String id,idU;
            String Nom;
            id = request.getParameter("idmt");
            Nom = request.getParameter("nombremt");
            idU = request.getParameter("idx");
            mp.setId(Integer.parseInt(id));
            mp.setIdUs(Integer.parseInt(idU));
            mp.setNombre(Nom);
            mtDAO.registrar(mp);
            acceso=consultar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
