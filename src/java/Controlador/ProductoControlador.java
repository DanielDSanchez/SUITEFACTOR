/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ProductoDAO;
import ModeloVO.ProductoVO;
import Util.Conexion;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Andrex
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/Producto"})
public class ProductoControlador extends HttpServlet {

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
        //recibir datos
        String Id_Producto = request.getParameter("txtId");
        String Nombre = request.getParameter("txtNombre");
        String Estado = request.getParameter("txtEstado");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. Quien tiene los datos de forma segura en el sistema? VO
        ProductoVO prodVO = new ProductoVO(Id_Producto, Nombre, Estado);

        // 3. Quien hace las operaciones? DAO
        ProductoDAO prodDAO = new ProductoDAO(prodVO);
        

        // 4. Administrar las operaciones del modulo
        switch (opcion) {

            case 1: //Agregar registro
                if (prodDAO.verificarProducto(Nombre) == false) {
                    if (prodDAO.agregarRegistro() == true) {
                        
                        request.setAttribute("Bien", "Se ha registrado");
                        request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
                    } else {
                        request.setAttribute("Error", "Error al Registrar!");
                        request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "El producto ya existe");
                    request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
                }

                break;

            case 2:

                if (prodDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "El producto se actualizo correctamente!");

                } else {

                    request.setAttribute("mensajeExito", "El producto no se actualizo correctamente!");
                }
                request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
                break;

            case 3:

                if (prodDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "El producto se elimino correctamente!");
                    request.getRequestDispatcher("consultarProducto.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "El producto no se elimino correctamente!");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            default:
                break;

            case 4: {
                prodVO = prodDAO.consultarProducto(Id_Producto);
            }
            if (prodVO != null) {
                request.setAttribute("productoConsultado", prodVO);
                request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
            } else {
                request.setAttribute("mensajError", "El producto no existe");
                request.getRequestDispatcher("consultarProducto.jsp").forward(request, response);
            }
            break;
            
            case 5:

                if (prodDAO.ActivarRegistro()) {

                    request.setAttribute("mensajeExito", "El producto se activo correctamente!");
                    request.getRequestDispatcher("eliminarProducto.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "El producto no se elimino correctamente!");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;
                
                case 6:

                if (prodDAO.EliminarRegistroTotal()) {

                    request.setAttribute("mensajeExito", "El producto se elimino correctamente!");
                    request.getRequestDispatcher("eliminarProducto.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "El producto no se elimino correctamente!");
                    request.getRequestDispatcher("eliminarProducto.jsp").forward(request, response);
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;
            
            case 10:
                //generarReporte
                response.setHeader("Content-Disposition", "attachment; filename=\"reporteProductos.pdf\";");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                response.setContentType("application/pdf");

                ServletOutputStream out = response.getOutputStream();
                try {
                    Conexion conexion = new Conexion();
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("reportes/reportesProducto/reporteProducto.jasper"));
                    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion.obtenerConexion());

                    JRExporter exporter = new JRPdfExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                    exporter.exportReport();
                } catch (Exception e) {
                    e.printStackTrace();
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
