/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.DetallesProductoDAO;
import ModeloVO.DetallesProductoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sena
 */
@WebServlet(name = "DetallesProductoControlador", urlPatterns = {"/DetallesProducto"})
public class DetallesProductoControlador extends HttpServlet {

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
         String Id_Detalles_Producto = request.getParameter("txtIdDetallesProducto");
        String Id_Producto = request.getParameter("txtIdProducto");
        String Descripcion = request.getParameter("txtDescripcion");
        String Talla = request.getParameter("txtTalla");
        String Estado = request.getParameter("txtEstado");

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        // 2. Quien tiene los datos de forma segura en el sistema? VO
        DetallesProductoVO detProVO = new DetallesProductoVO(Id_Detalles_Producto, Id_Producto, Descripcion, Talla, Estado);

        // 3. Quien hace las operaciones? DAO
        DetallesProductoDAO detProDAO = new DetallesProductoDAO(detProVO);

        switch (opcion) {

            case 1: //Agregar registro

                if (detProDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "Los detalles del producto se registraron correctamente!");

                } else {

                    request.setAttribute("mensajeError", "Los detalles del producto no se registraron correctamente");
                }
                request.getRequestDispatcher("registrarDetallesProducto.jsp").forward(request, response);
                break;

            case 2:

                if (detProDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "Los detalles del producto se actualizaron correctamente!");

                } else {

                    request.setAttribute("mensajeError", "Los detalles del producto no se actualizaron correctamente!");
                }
                request.getRequestDispatcher("actualizarDetallesProducto.jsp").forward(request, response);
                break;

            case 3:

                if (detProDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "Los detalles de la orden se eliminaron correctamente!");
                    request.getRequestDispatcher("consultarDetallesProducto.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "Los detalles de la orden no se eliminaron correctamente!");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            case 4: //Consultar por DetallesProducto

                detProVO = detProDAO.consultarDetallesProducto(Descripcion);
                if (detProVO != null) {

                    request.setAttribute("OrdenConsultada", detProVO);
                    request.getRequestDispatcher("actualizarDetallesProducto.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeExito", "Los detalles del producto no existen");
                    request.getRequestDispatcher("consultarDetallesProducto.jsp").forward(request, response);
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
