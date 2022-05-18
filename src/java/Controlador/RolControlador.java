/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.RolDAO;
import ModeloVO.RolVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Pablo
 */
@WebServlet(name = "RolControlador", urlPatterns = {"/Rol"})
public class RolControlador extends HttpServlet {

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
        String id_rol = request.getParameter("txtId");
        String roltipo = request.getParameter("txtroltipo");
        String Estado = request.getParameter("txtEstado");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. Quien tiene los datos de forma segura en el sistema? VO
        RolVO RVO = new RolVO(id_rol, roltipo, Estado);

        // 3. Quien hace las operaciones? DAO
        RolDAO RDAO = new RolDAO(RVO);

        // 4. Administrar las operaciones del modulo
        switch (opcion) {

            case 1: //Agregar registro

               if (RDAO.verificarRol(roltipo) == false) {
                    if (RDAO.agregarRegistro() == true) {

                    request.setAttribute("mensajeExito", "Se ha registrado correctamente");
                        request.getRequestDispatcher("registrarRol.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensajeError", "Error al Registrar!");
                        request.getRequestDispatcher("registrarRol.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "El Rol ya existe");
                    request.getRequestDispatcher("registrarRol.jsp").forward(request, response);
                }

                break;

            case 2:

                if (RDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "El rol se actualizo correctamente!");

                } else {

                    request.setAttribute("mensajeExito", "El rol no se actualizo correctamente!");
                }
                request.getRequestDispatcher("actualizarRol.jsp").forward(request, response);
                break;

            case 3:

                if (RDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "El rol se elimino correctamente!");
                     request.getRequestDispatcher("consultarRol.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeExito", "El rol no se elimino correctamente!");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            default:
                break;

            case 4: {
                RVO = RDAO.consultarRol(id_rol);
            }
            if (RVO != null) {
                request.setAttribute("rolConsultado", RVO);
                request.getRequestDispatcher("actualizarRol.jsp").forward(request, response);
            } else {
                request.setAttribute("mensajError", "El rol no existe");
                request.getRequestDispatcher("consultarRol.jsp").forward(request, response);
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
