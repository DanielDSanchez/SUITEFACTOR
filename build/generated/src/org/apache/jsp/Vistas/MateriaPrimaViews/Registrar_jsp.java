package org.apache.jsp.vistas.MateriaPrimaViews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloVO.Usuario;
import java.util.ArrayList;

public final class Registrar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Materia Prima</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Vistas/Stilos/EstilosRmt.css\">\n");
      out.write("        <link  rel=\"icon\"   href=\"Vistas/img/Logo (1).png\" type=\"png\" />\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body class=\"row\" background=\"Vistas/img/WhatsApp Image 2021-11-18 at 6.24.21 PM.jpeg\">\n");
      out.write("        <nav class=\"navbar navbar-light  col-md-6 text-light\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"L navbar-brand text-light nav-link\" href=\"RegistroOrden.html\">\n");
      out.write("                    <img src=\"Vistas/img/Logo (1).png\" alt=\"\" width=\"60\" height=\"60\" class=\"d-inline-block align-text-top\">\n");
      out.write("                     SUITEFACTOR   \n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"col-md-6 \">\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light col-md-12 \">\n");
      out.write("                <div class=\"mx-auto\" id=\"navbarNav\">\n");
      out.write("\n");
      out.write("                    <ul class=\"navbar-nav mx-auto\">\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\" nav-link text-light \" href=\"ControladorMateriaPrima?accion=index\">Inicio</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\" nav-link text-light \" href=\"ControladorMateriaPrima?accion=consultar\">Materia Prima</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link text-light \" href=\"\">Producto</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\" nav-link text-light \" href=\"\">Contactenos</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"Fondo1 col-md-4 mx-auto\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                <div class=\"col-md-12 mt-3\">\n");
      out.write("                    <h1 class=\"Titulo text-center\">Registrar Materia Prima</h1>\n");
      out.write("                </div>\n");
      out.write("                <form class=\"form form-group mx-auto\" action=\"ControladorMateriaPrima\">\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label class=\"form-label text-light \"><b>Nombre Materia Prima</b></label>\n");
      out.write("                        <input type=\"text\" class=\"in form-control text-light\" name=\"nombremt\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label class=\"form-label text-light\"><b>Id Usuario</b></label>\n");
      out.write("                        ");
 
                         ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) request.getAttribute("listaU");
                        
      out.write("\n");
      out.write("                        <select name=\"usuarioId\">\n");
      out.write("                            ");

                              for(Usuario u : listaUsuarios){ 
      out.write("\n");
      out.write("                              <option value=\"");
      out.print( u.getId_Usuarios());
      out.write('"');
      out.write('>');
      out.print( u.getNombre() );
      out.write("</option>\n");
      out.write("                              ");

                              }      
                            
                            
      out.write("   \n");
      out.write("                            \n");
      out.write("                        </select> \n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 mt-2 m\">\n");
      out.write("                        <button type=\"submit\" class=\"btn text-light\" name=\"accion\" value=\"Agregar\"><b>Guardar</b></button>\n");
      out.write("                    </div>\n");
      out.write("                </form>    \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
