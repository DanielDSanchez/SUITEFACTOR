/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import ModeloDAO.OrdenDetallesDAO;
import ModeloVO.OrdenDetallesVO;
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
@WebServlet(name = "OrdenDetallesControlador", urlPatterns = {"/OrdenDetalles"})
public class OrdenDetallesControlador extends HttpServlet {

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
        
       String id_Orden_Detalles = request.getParameter("txtIdOrdenDetalles");
       String id_Orden = request.getParameter("txtIdOrden");
       String id_Detalles_Producto = request.getParameter("idDetallesProducto");
       String cantidadSolicitada = request.getParameter("txtcantidadSolicitada");
       String Estado = request.getParameter("txtEstado");
       
       int opcion = Integer.parseInt(request.getParameter("opcion"));
        // 2. Quien tiene los datos de forma segura en el sistema? VO
        OrdenDetallesVO ordenDetallVO = new OrdenDetallesVO(id_Orden_Detalles, id_Orden, 
                id_Detalles_Producto, cantidadSolicitada, Estado);

        // 3. Quien hace las operaciones? DAO
        OrdenDetallesDAO ordenDetalDAO = new OrdenDetallesDAO(ordenDetallVO);

        // 4. Administrar las operaciones del modulo
        switch (opcion) {

            case 1: //Agregar registro

                if (ordenDetalDAO.agregarRegistro()) {

                        request.setAttribute("mensajeExito", "La orden Detalles se registró correctamente!");

                } else {

                    request.setAttribute("mensajeError", "La orden Detalles no se registró correctamente");
                }
                request.getRequestDispatcher("registrarOrdenDetalles.jsp").forward(request, response);
                break;

            case 2:

                if (ordenDetalDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "La orden Detalles se actualizo correctamente!");

                } else {

                    request.setAttribute("mensajeError", "La orden Detalles no se actualizo correctamente!");
                }
                request.getRequestDispatcher("consultarOrdenDetalles.jsp").forward(request, response);
                break;

            case 3:

                if (ordenDetalDAO.eliminarRegistro()) {

                    request.setAttribute("mensajeExito", "La orden detalles se elimino correctamente!");
                    request.getRequestDispatcher("consultarOrdenDetalles.jsp").forward(request, response);


                } else {

                    request.setAttribute("mensajeError", "El lote de Produccion no se elimino correctamente!");
                }
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            case 4: //Consultar por Orden_Detalles

                ordenDetallVO = ordenDetalDAO.cosnultarId(id_Orden_Detalles);
                if (ordenDetallVO != null) {

                    request.setAttribute("OrdenDetallesConsultada", ordenDetallVO);
                    request.getRequestDispatcher("actualizarOrdenDetalles.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeExito", "La orden Detalles no existe");
                    request.getRequestDispatcher("consultarOrdenDetalles.jsp").forward(request, response);
                }
                break;
            case 10:    
                response.setHeader("Content-Disposition", "attachment; filename=\"reporteOrdenDetalle.pdf\";");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                response.setContentType("application/pdf");

                ServletOutputStream out = response.getOutputStream();
                try {
                    Conexion conexion = new Conexion();
                    JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("reportes/reportesOrdenDetalles/reporteOrdenDetalle.jasper"));
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
