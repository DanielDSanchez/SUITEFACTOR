/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DetallesProductoVO;
import ModeloVO.ProductoVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sena
 */
public class DetallesProductoDAO extends Conexion implements Crud {
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    String Id_Detalles_Producto = "", Id_Producto = "", Talla = "",Descripcion = "";
    
    public DetallesProductoDAO(DetallesProductoVO detProVO) {
        
        super();

        //3. Conectarse a la base de datos
        try {
            
            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            Id_Detalles_Producto = detProVO.getId_Detalles_Producto();
            Id_Producto = detProVO.getId_Producto();
            Talla = detProVO.getTalla();
            Descripcion = detProVO.getDescripcion();
            
            
        } catch (Exception e) {
            Logger.getLogger(LoteProduccionDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    public DetallesProductoDAO() {
    }
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into detalles_producto(Id_Producto, talla, Descripcion)values(?,?,?)";
            
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Producto);
            puente.setString(2, Talla);
            puente.setString(3, Descripcion);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update detalles_producto set Id_Producto = ?, Talla = ?,Descripcion = ? where Id_Detalles_Producto = ? ";
            puente = conexion.prepareStatement(sql);
            
            puente.setString(1, Id_Producto);
            puente.setString(2, Talla);
            puente.setString(3, Descripcion);
            
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
       
    }
    
    @Override
    public boolean eliminarRegistro() {
         try {
            sql = "UPDATE `detalles_producto` SET `Estado`= 0 WHERE Id_detalles_producto = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Detalles_Producto);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    
    public DetallesProductoVO consultarDetallesProducto(String DetallesProd) {
        
        DetallesProductoVO detProVO = null;
        
        try {
            
            conexion = this.obtenerConexion();
            sql = "select * from detalles_producto where Id_Producto = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Producto);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                detProVO = new DetallesProductoVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                
            }
        } catch (Exception e) {
            Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            
        } finally {
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return detProVO;
    }
    
    public ArrayList<DetallesProductoVO> listar() {
        
        ArrayList<DetallesProductoVO> listarDetallesProducto = new ArrayList<>();
        try {
            
            sql = "select * from DetallesProductoView";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            
            while (mensajero.next()) {
                DetallesProductoVO detProVO = new DetallesProductoVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),mensajero.getString(5));
                
                listarDetallesProducto.add(detProVO);
            }
        } catch (Exception e) {
            
            Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(DetallesProductoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return listarDetallesProducto;
        
    }    
    public String consultarProducto(String idProducto) {
        String nomProducto;
        ProductoVO prodVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from producto where id_producto=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idProducto);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                prodVO = new ProductoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3));
            }
        } catch (Exception e) {
            Logger.getLogger(ProductoVO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        nomProducto = prodVO.getNombre();
        return nomProducto;
    }
}
