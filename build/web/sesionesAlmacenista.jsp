<%-- 
    Document   : sesionesAlmacenista
    Created on : 01-may-2022, 20:09:45
    Author     : 1Usuario
--%>
<%@page import="ModeloVO.Usuario_rolVO"%>
<%@page import="ModeloDAO.UsuarioRolDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", 0);
%>


<%
    HttpSession buscarSesion = (HttpSession) request.getSession();
    UsuarioVO usuVO1 = null;
    if (buscarSesion.getAttribute("datosUsuario") == null) {

        request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);

    } else {
        UsuarioRolDAO uRDAO = new UsuarioRolDAO();
        usuVO1 = (UsuarioVO) buscarSesion.getAttribute("datosUsuario");
        Usuario_rolVO uRVO2 = uRDAO.consultarRol(usuVO1.getIdUsuarios());
        String id = uRVO2.getId_Rol();
        if (id.equals("2") || id.equals("1") || id.equals("3")) {

        } else {
            request.getRequestDispatcher("errorPermisos.jsp").forward(request, response);

        }

    }

%>
