/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author 1Usuario
 */
public class Usuario_rolVO {

    private String id_Rol, id_Usuarios, estado;
    
    
    
    public Usuario_rolVO(String id_Rol, String id_Usuarios, String estado) {
        this.id_Rol = id_Rol;
        this.id_Usuarios = id_Usuarios;
        this.estado = estado;
    }
    public Usuario_rolVO(String id_Rol, String id_Usuarios) {
        this.id_Rol = id_Rol;
        this.id_Usuarios = id_Usuarios;
    }
    public Usuario_rolVO() {
    }
    public String getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(String id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getId_Usuarios() {
        return id_Usuarios;
    }

    public void setId_Usuarios(String id_Usuarios) {
        this.id_Usuarios = id_Usuarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
    
    
    
}
