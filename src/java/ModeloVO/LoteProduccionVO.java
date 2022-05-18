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
public class LoteProduccionVO {
    private String id_Lote_Produccion,id_Usuarios,id_orden_Detalles,fecha_Fabricacion,Estado;
    private int cantidad;
    //private Date fecha_Fabricacion;
    
    public LoteProduccionVO() {
    }

    public LoteProduccionVO(String id_Lote_Produccion,String id_Usuarios, String id_orden_Detalles,int cantidad,String fecha_Fabricacion,String estado) {
        this.id_Lote_Produccion = id_Lote_Produccion;
        this.id_Usuarios = id_Usuarios;
        this.id_orden_Detalles = id_orden_Detalles;
        this.cantidad = cantidad;
        this.fecha_Fabricacion = fecha_Fabricacion;
        this.Estado = estado;
    }
    public LoteProduccionVO(String id_Lote_Produccion,String id_Usuarios, String id_orden_Detalles,int cantidad,String fecha_Fabricacion) {
        this.id_Lote_Produccion = id_Lote_Produccion;
        this.id_Usuarios = id_Usuarios;
        this.id_orden_Detalles = id_orden_Detalles;
        this.cantidad = cantidad;
        this.fecha_Fabricacion = fecha_Fabricacion;
    }
    
     public String getId_Lote_Produccion() {
        return id_Lote_Produccion;
    }

    public void setId_Lote_Produccion(String id_Lote_Produccion) {
        this.id_Lote_Produccion = id_Lote_Produccion;
    }

    public String getId_Usuarios() {
        return id_Usuarios;
    }

    public void setId_Usuarios(String id_Usuarios) {
        this.id_Usuarios = id_Usuarios;
    }

    public String getId_orden_Detalles() {
        return id_orden_Detalles;
    }

    public void setId_orden_Detalles(String id_orden_Detalles) {
        this.id_orden_Detalles = id_orden_Detalles;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getFecha_Fabricacion() {
        return fecha_Fabricacion;
    }

    public void setFecha_Fabricacion(String fecha_Fabricacion) {
        this.fecha_Fabricacion = fecha_Fabricacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}

    