/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Andrex
 */
public class ProductoVO {
    
    private String Id_Producto, Nombre, Estado;
    
    //Declaracion de constructor vacio para enciar datos
    public ProductoVO(){
        
    }
    
    public ProductoVO(String IdProducto, String Nombre, String Estado){
        this.Id_Producto = IdProducto;
        this.Nombre = Nombre;
        this.Estado = Estado;
    }
    
    public String getIdProducto(){
        return Id_Producto;
    }
    
    public void setIdProducto(String IdProducto){
        this.Id_Producto = IdProducto;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public void Nombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String getEstado(){
        return Estado;
    }
    
    public void Estado(String Estado){
        this.Estado = Estado;
    }
    
}
