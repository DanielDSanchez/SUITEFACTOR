/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Sena
 */
public class OrdenDetallesVO {
    
    String id_Orden_Detalles,id_Orden,id_Detalles_Producto,cantidadSolicitada, Estado;

    public OrdenDetallesVO(String id_Orden_Detalles, String id_Orden, String id_Detalles_Producto, String cantidadSolicitada, String Estado) {
        this.id_Orden_Detalles = id_Orden_Detalles;
        this.id_Orden = id_Orden;
        this.id_Detalles_Producto = id_Detalles_Producto;
        this.cantidadSolicitada = cantidadSolicitada;
        this.Estado = Estado;
    }

    public OrdenDetallesVO() {
    }

    public String getId_Orden_Detalles() {
        return id_Orden_Detalles;
    }

    public void setId_Orden_Detalles(String id_Orden_Detalles) {
        this.id_Orden_Detalles = id_Orden_Detalles;
    }

    public String getId_Orden() {
        return id_Orden;
    }

    public void setId_Orden(String id_Orden) {
        this.id_Orden = id_Orden;
    }

    public String getId_Detalles_Producto() {
        return id_Detalles_Producto;
    }

    public void setId_Detalles_Producto(String id_Detalles_Producto) {
        this.id_Detalles_Producto = id_Detalles_Producto;
    }

    public String getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(String cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
