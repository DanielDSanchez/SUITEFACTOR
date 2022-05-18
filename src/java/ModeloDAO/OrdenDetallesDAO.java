/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.OrdenDetallesVO;
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
public class OrdenDetallesDAO extends Conexion implements Crud{

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    
    String id_Orden_Detalles,id_Orden,id_Detalles_Producto,cantidadSolicitada;
    
    public OrdenDetallesDAO(OrdenDetallesVO ordDetallVO) {
        
        super();

        //3. Conectarse a la base de datos
        try {
            
            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            id_Orden_Detalles = ordDetallVO.getId_Orden_Detalles();
            id_Orden = ordDetallVO.getId_Orden();
            id_Detalles_Producto = ordDetallVO.getId_Detalles_Producto();
            cantidadSolicitada = ordDetallVO.getCantidadSolicitada();
            
        } catch (Exception e) {
            Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    public OrdenDetallesDAO() {
    }
    @Override
    public boolean agregarRegistro() {
        try {
            //Armar sentencia
            sql = "insert into orden_detalles(id_Orden,id_Detalles_Producto,CantidadSolicitada) values (?,?,?)";

            // crear el camino por donde va la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_Orden);
            puente.setString(2, id_Detalles_Producto);
            puente.setString(3, cantidadSolicitada);
            
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{

            try{
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update orden_detalles set id_orden = ?, id_detalles_Producto = ?, "
                    + "CantidadSolicitada = ? where Id_Orden_Detalles = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1,id_Orden);
            puente.setString(2, id_Detalles_Producto);
            puente.setString(3, cantidadSolicitada);
            puente.setString(4, id_Orden_Detalles);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
       try {
            //Armar sentencia
           sql = "UPDATE `orden_detalles` SET `Estado`= 0 WHERE Id_orden_detalles = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_Orden_Detalles);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
        return operacion;
    }
    
    public OrdenDetallesVO cosnultarId(String Id) {

        OrdenDetallesVO OrdenDetallVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from orden_detalles where Id_Orden_Detalles = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

               OrdenDetallVO = new OrdenDetallesVO(mensajero.getString(1), mensajero.getString(2), 
                       mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

            }

        } catch (SQLException e) {
            Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return OrdenDetallVO;

    }

    public ArrayList<OrdenDetallesVO> Listar() {

        ArrayList<OrdenDetallesVO> listaOrdenDetalles = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from ordendetallesview";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

               OrdenDetallesVO OrdenDetallVO = new OrdenDetallesVO(mensajero.getString(1),
                       mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));
                listaOrdenDetalles.add(OrdenDetallVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenDetallesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaOrdenDetalles;

    }
}
