/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.CantidadNecesariaDAO;
import ModeloVO.CantidadNecesariaVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ESCOBAR
 */
@WebServlet(name = "CantidadNecesariaControlador", urlPatterns = {"/CantidadNecesaria"})
public class CantidadNecesariaControlador extends HttpServlet {

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
        
        String id_materia_prima = request.getParameter("Id_Materia_Prima");
        String id_detalles_producto = request.getParameter("Id_Detalles_Producto");
        String materiaprimaenproducto = request.getParameter("materiaprimaenproducto");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
      CantidadNecesariaVO cantNecVO = new CantidadNecesariaVO(id_materia_prima, id_detalles_producto, materiaprimaenproducto);

        // 3. Quien hace las operaciones? DAO
        CantidadNecesariaDAO cantNecDAO = new CantidadNecesariaDAO(cantNecVO);
        
        switch (opcion) {

            case 1: //Agregar registro

                if (cantNecDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El producto se registro correctamente!");

                } else {

                    request.setAttribute("mensajeError", "El producto no se registro correctamente");
                }
                request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
                break;

            case 2:

                if (cantNecDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "El producto se actualizo correctamente!");

                } else {

                    request.setAttribute("mensajeExito", "El producto no se actualizo correctamente!");
                }
                request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
                break;

            case 3:

                if (cantNecDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "El producto se elimino correctamente!");

                } else {

                    request.setAttribute("mensajeExito", "El producto no se elimino correctamente!");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            default:
                break;

            case 4: {
                cantNecVO = cantNecDAO.consultarCantidadNecesaria(id_materia_prima);
            }
            if (cantNecVO != null) {
                request.setAttribute("productoCosultado", cantNecVO);
                request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
            } else {
                request.setAttribute("mensajError", "El producto no existe");
                request.getRequestDispatcher("consultarProducto.jsp").forward(request, response);
            }
            break;
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
