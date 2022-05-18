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
public class RolVO {
    
    private String  id_rol, roltipo, Estado;

    public RolVO() {
    }

    public RolVO(String id_rol, String roltipo, String Estado) {
        this.id_rol = id_rol;
        this.roltipo = roltipo;
        this.Estado = Estado;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getRoltipo() {
        return roltipo;
    }

    public void setRoltipo(String roltipo) {
        this.roltipo = roltipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
    
}
