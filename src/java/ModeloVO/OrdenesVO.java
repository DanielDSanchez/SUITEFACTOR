/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

//import java.util.Date;



/**
 *
 * @author Sena
 */
public class OrdenesVO {

    private String Id_Orden, Id_Usuarios, fecha_registro, fecha_entrega, Estado;
    
     public OrdenesVO() {
    }

    public OrdenesVO(String Id_Orden, String Id_Usuarios, String fecha_registro, String fecha_entrega, String Estado) {
        this.Id_Orden = Id_Orden;
        this.Id_Usuarios = Id_Usuarios;
        this.fecha_registro = fecha_registro;
        this.fecha_entrega = fecha_entrega;
        this.Estado = Estado;
    }
    
     public String getId_Orden() {
        return Id_Orden;
    }

    public void setId_Orden(String Id_Orden) {
        this.Id_Orden = Id_Orden;
    }

    public String getId_Usuarios() {
        return Id_Usuarios;
    }

    public void setId_Usuarios(String Id_Usuarios) {
        this.Id_Usuarios = Id_Usuarios;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
