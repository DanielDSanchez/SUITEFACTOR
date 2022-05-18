/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.loteMateriaPrimaDAO;
import ModeloVO.loteMateriaPrimaVO;
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
@WebServlet(name = "loteMateriaPrimaControlador", urlPatterns = {"/loteMateriaPrima"})
public class loteMateriaPrimaControlador extends HttpServlet {

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

        String IdLoteMateriaPrima = request.getParameter("txtIdLoteMateriaPrima");
        String IdMateriaPrima = request.getParameter("txtIdMateriaPrima");
        String Cantidad = request.getParameter("txtCantidad");
        String Observaciones = request.getParameter("txtObservaciones");
        String FechaIngreso = request.getParameter("txtFechaIngreso");
        String FechaSalida = request.getParameter("txtFechaSalida");
        String Estado = request.getParameter("txtEstado");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        // 2. Quien tiene los datos de forma segura en el sistema? VO
        loteMateriaPrimaVO loteMPVO = new loteMateriaPrimaVO(IdLoteMateriaPrima, IdMateriaPrima, Cantidad, Observaciones, FechaIngreso, FechaSalida, Estado);

        // 3. Quien hace las operaciones? DAO
        loteMateriaPrimaDAO loteMPDAO = new loteMateriaPrimaDAO(loteMPVO);

        // 4. Administrar las operaciones del modulo
        switch (opcion) {

            case 1: //Agregar registro

                if (loteMPDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se registro correctamente!");

                } else {

                    request.setAttribute("mensajeError", "No se pudo registrar");
                }
                request.getRequestDispatcher("registrarLoteMateriaPrima.jsp").forward(request, response);
                break;

            case 2:

                if (loteMPDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se actualizo correctamente!");

                } else {

                    request.setAttribute("mensajeError", "No se pudo actualizar.");
                }
                request.getRequestDispatcher("actualizarLoteMateriaPrima.jsp").forward(request, response);
                break;

            case 3:

                if (loteMPDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se elimino correctamente!");
                    request.getRequestDispatcher("consultarLoteMateriaPrima.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "No se pudo eliminar");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            case 4: //Consultar por lote

                loteMPVO = loteMPDAO.consultarIdLoteMateriaPrima(IdLoteMateriaPrima);
                if (loteMPVO != null) {

                    request.setAttribute("LoteMateriaPrimaConsultada", loteMPVO);
                    request.getRequestDispatcher("actualizarLoteMateriaPrima.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeExito", "La materia prima no existe");
                    request.getRequestDispatcher("consultarLoteMateriaPrima.jsp").forward(request, response);
                }
                break;

            case 5:

                if (loteMPDAO.ActivarRegistro()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se activo correctamente!");
                    request.getRequestDispatcher("eliminarLoteMateriaPrima.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "No se pudo acivar");
                    request.getRequestDispatcher("eliminarLoteMateriaPrima.jsp").forward(request, response);

                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            case 6:

                if (loteMPDAO.eliminarRegistroTotal()) {

                    request.setAttribute("mensajeExito", "El lote de materia prima se elimino correctamente!");
                    request.getRequestDispatcher("eliminarLoteMateriaPrima.jsp").forward(request, response);

                } else {

                    request.setAttribute("mensajeError", "No se pudo eliminar");
                    request.getRequestDispatcher("eliminarLoteMateriaPrima.jsp").forward(request, response);

                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;
            case 10:
                response.setHeader("Content-Disposition", "attachment; filename=\"reporteLoteMateriaPrima.pdf\";");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                response.setContentType("application/pdf");

                ServletOutputStream out = response.getOutputStream();
                try {
                    Conexion conexion = new Conexion();
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("reportes/reportesLoteMateriaPrima/reporteLoteMateriaPrima.jasper"));
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
