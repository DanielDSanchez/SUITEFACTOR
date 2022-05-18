/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Juan Pablo
 */
public class UsuarioVO {

    private String Id_Usuarios, Nombre, Documento, Telefono, Email, Direccion,
            Estado, Contrasena;

    // Declarar constructor vacio para enviar datos.
    public UsuarioVO() {
    }

    public UsuarioVO(String Id_Usuarios) {
        this.Id_Usuarios = Id_Usuarios;
    }

    public UsuarioVO(String IdUsuarios, String Nombre, String Documento, String Telefono, String Email,
            String Direccion, String Estado, String Contrasena) {
        this.Id_Usuarios = IdUsuarios;
        this.Nombre = Nombre;
        this.Documento = Documento;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Direccion = Direccion;
        this.Estado = Estado;
        this.Contrasena = Contrasena;
    }

    public String getIdUsuarios() {
        return Id_Usuarios;
    }

    public void setIdUsuarios(String IdUsuarios) {
        this.Id_Usuarios = IdUsuarios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

}
