<%-- 
    Document   : sesiones
    Created on : 29/03/2022, 09:38:22 PM
    Author     : Juan Pablo
--%>

<%@page import="ModeloVO.Usuario_rolVO"%>
<%@page import="ModeloDAO.UsuarioRolDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
        if (id.equals("1")) {

        } else {
            request.getRequestDispatcher("errorPermisos.jsp").forward(request, response);

        }

    }

%>