/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.MateriaPrimaDAO;
import ModeloVO.MateriaPrimaVO;
import Util.Conexion;
import java.io.IOException;

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
 * @author Sena
 */
@WebServlet(name = "MateriaPrimaControlador", urlPatterns = {"/MateriaPrima"})
public class MateriaPrimaControlador extends HttpServlet {

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

        String Id_materia_Prima = request.getParameter("txtIdMateriaPrima");
        String Nombre = request.getParameter("txtNombre");
        String Actualizacion = request.getParameter("txtActualizacion");
        String Estado = request.getParameter("txtEstado");
        String reporteOpcion = request.getParameter("txtreporte");
        if (Actualizacion == null) {
            Actualizacion = "0";
        }
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        // 2. Quien tiene los datos de forma segura en el sistema? VO
        MateriaPrimaVO matPriVO = new MateriaPrimaVO(Id_materia_Prima, Nombre, Actualizacion, Estado);
        // 3. Quien hace las operaciones? DAO
        MateriaPrimaDAO matPriDAO = new MateriaPrimaDAO(matPriVO);

        switch (opcion) {

            case 1: //Agregar registro

                 if (matPriDAO.verificarMateriaPrima(Nombre) == false) {
                    if (matPriDAO.agregarRegistro() == true) {

                         request.setAttribute("mensajeExito", "La materia prima se registró correctamente!");
                        request.getRequestDispatcher("registrarMateriasPrimas.jsp").forward(request, response);
                    

               } else {
                        request.setAttribute("mensajeError", "La materia prima no se registro correctamente!");
                        request.getRequestDispatcher("registrarMateriasPrimas.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "La materia Prima ya existe");
                    request.getRequestDispatcher("registrarMateriasPrimas.jsp").forward(request, response);
                }

                break;

            case 2:

                if (matPriDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "La materia prima se actualizó correctamente!");

                } else {

                    request.setAttribute("mensajeError", "La materia prima no se actualizó correctamente!");
                }
                request.getRequestDispatcher("actualizarMateriaPrima.jsp").forward(request, response);
                break;

            case 3:

                if (matPriDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "La materia prima se elimino correctamente!");
                    request.getRequestDispatcher("consultarMateriaPrima.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "La materia prima no se elimino correctamente!");
                }

                break;

            case 4: //Consultar por Ordens

                matPriVO = matPriDAO.consultarIdMateriaPrima(Id_materia_Prima);
                if (matPriVO != null) {

                    request.setAttribute("MateriaPrimaConsultada", matPriVO);
                    request.getRequestDispatcher("actualizarMateriaPrima.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeExito", "La materia prima no existe");
                    request.getRequestDispatcher("consultarMateriaPrima.jsp").forward(request, response);
                }
                break;

            case 5: //Consultar por Orden

                matPriVO = matPriDAO.consultarIdMateriaPrima(Id_materia_Prima);
                if (matPriVO != null) {

                    request.setAttribute("MateriaPrimaConsultada", matPriVO);
                    request.getRequestDispatcher("actualizarExistenciasMateriaPrima.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeExito", "La materia prima no existe");
                    request.getRequestDispatcher("consultarExistenciasMateriaPrima.jsp").forward(request, response);
                }
                break;
            case 6:

                if (matPriDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "La materia prima se elimino correctamente!");
                    request.getRequestDispatcher("consultarExistenciasMateriaPrima.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "La materia prima no se elimino correctamente!");
                }

                break;
                case 7:

                if (matPriDAO.ActivarRegistro()) {
                    request.setAttribute("mensajeExito", "La materia prima se activo correctamente!");
                    request.getRequestDispatcher("eliminarMateriaPrima.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "La materia prima no se activo correctamente!");
                }

                break;
                
                case 8:

                if (matPriDAO.EliminarRegistroTotal()) {
                    request.setAttribute("mensajeExito", "La materia prima se elimino correctamente!");
                    request.getRequestDispatcher("eliminarMateriaPrima.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "La materia prima no se elimino correctamente!");
                    request.getRequestDispatcher("eliminarMateriaPrima.jsp").forward(request, response);
                }

                break;
            case 10:

                if (reporteOpcion.equals("2")) {
                    response.setHeader("Content-Disposition", "attachment; filename=\"reporteExistenciasMateriaPrima.pdf\";");
                    response.setHeader("Cache-Control", "no-cache");
                    response.setHeader("Pragma", "no-cache");
                    response.setDateHeader("Expires", 0);
                    response.setContentType("application/pdf");

                    ServletOutputStream out = response.getOutputStream();
                    try {
                        Conexion conexion = new Conexion();
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("reportes/reportesMateriasPrimas/reporteExistenciasMateriaPrima.jasper"));
                        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion.obtenerConexion());

                        JRExporter exporter = new JRPdfExporter();
                        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                        exporter.exportReport();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    response.setHeader("Content-Disposition", "attachment; filename=\"reporteMateriaPrima.pdf\";");
                    response.setHeader("Cache-Control", "no-cache");
                    response.setHeader("Pragma", "no-cache");
                    response.setDateHeader("Expires", 0);
                    response.setContentType("application/pdf");

                    ServletOutputStream out = response.getOutputStream();
                    try {
                        Conexion conexion = new Conexion();
                        JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("reportes/reportesMateriasPrimas/reporteMateriaPrima.jasper"));
                        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion.obtenerConexion());

                        JRExporter exporter = new JRPdfExporter();
                        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
                        exporter.exportReport();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
