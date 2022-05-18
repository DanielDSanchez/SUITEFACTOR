/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.OrdenesVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Date;

/**
 *
 * @author Sena
 */
public class OrdenesDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    // Declarar variables del modulo(VO)
    private String Id_Orden = "", Id_Usuarios = "", fecha_registro = "", fecha_entrega = "";

    //2. Crear metodo principal para recibir los datos del VO
    public OrdenesDAO(OrdenesVO ordVO) {
        super();
        //3. Conectarse a la base de datos
        try {
            
            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            Id_Orden = ordVO.getId_Orden();
            Id_Usuarios = ordVO.getId_Usuarios();
            fecha_registro = ordVO.getFecha_registro();
            fecha_entrega = ordVO.getFecha_entrega();

        } catch (Exception e) {
            Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public OrdenesDAO() {
    }

    @Override
    public boolean agregarRegistro() {
        try {
            //Armar sentencia
            sql = "insert into ordenes (Id_Usuarios, fecha_registro, fecha_entrega) values (?,?,?)";

            // crear el camino por donde va la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Usuarios);
            puente.setString(2, fecha_registro);
            puente.setString(3, fecha_entrega);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{

            try{
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
         return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {

            sql = "update ordenes set Id_Usuarios = ?, fecha_registro = ?, fecha_entrega = ? where Id_Orden = ? ";

            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Usuarios);
            puente.setString(2, fecha_registro);
            puente.setString(3, fecha_entrega);
            puente.setString(4, Id_Orden);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            //Armar sentencia
           sql = "UPDATE `ordenes` SET `Estado`= 0 WHERE Id_orden = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Orden);
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
    
    
    public OrdenesVO consultarOrden(String Orden) {

        OrdenesVO ordVo = null;

        try {

            conexion = this.obtenerConexion();
            sql = "select * from ordenes where Id_Orden = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Orden);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                ordVo = new OrdenesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

            }
        } catch (Exception e) {
            Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ordVo;
    }

    public ArrayList<OrdenesVO> listar() {

        ArrayList<OrdenesVO> listaOrdenes = new ArrayList<>();
        try {

            sql = "select * from OrdenesView";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                OrdenesVO ordVo = new OrdenesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

                listaOrdenes.add(ordVo);
            }
        } catch (Exception e) {

            Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaOrdenes;

    }
    
     public ArrayList<OrdenesVO> listarDos() {

        ArrayList<OrdenesVO> listaOrdenes = new ArrayList<>();
        try {

            sql = "select * from OrdenesView2";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                OrdenesVO ordVo = new OrdenesVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

                listaOrdenes.add(ordVo);
            }
        } catch (Exception e) {

            Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(OrdenesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaOrdenes;

    }
     
     public boolean ActivarRegistro() {
        try {
            //Armar sentencia
           sql = "UPDATE `ordenes` SET `Estado`= 1 WHERE Id_orden = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Orden);
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
     
     public boolean eliminarRegistroTotal() {
        try {
            //Armar sentencia
           sql = "delete from `ordenes` WHERE Id_orden = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Orden);
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
}
