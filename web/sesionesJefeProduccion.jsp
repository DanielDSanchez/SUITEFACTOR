<%-- 
    Document   : sesionesJefeProduccion
    Created on : 3/05/2022, 02:08:39 PM
    Author     : AdminSena
--%>
<%@page import="ModeloVO.Usuario_rolVO"%>
<%@page import="ModeloDAO.UsuarioRolDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%
HttpSession buscarSesion = (HttpSession) request.getSession();
    UsuarioVO usuVO1 = null;
    if (buscarSesion.getAttribute("datosUsuario") == null) {
        request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
    }else{
        UsuarioRolDAO uRDAO = new UsuarioRolDAO();
         usuVO1 = (UsuarioVO) buscarSesion.getAttribute("datosUsuario");
         Usuario_rolVO uRVO2 = uRDAO.consultarRol(usuVO1.getIdUsuarios());
         String id = uRVO2.getId_Rol();
         if(id.equals("2") || id.equals("1")){
             
         }else{
             request.getRequestDispatcher("errorPermisos.jsp").forward(request, response);
         }
         
    } 
%>