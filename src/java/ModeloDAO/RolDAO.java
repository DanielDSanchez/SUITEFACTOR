/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.RolVO;
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
 * @author Juan Pablo
 */
public class RolDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    public RolDAO() {
    }

    private String id_rol = "", roltipo = "";

    public RolDAO(RolVO RVO) {
        super();

        try {
            conexion = this.obtenerConexion();

            id_rol = RVO.getId_rol();
            roltipo = RVO.getRoltipo();

        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        sql = "insert into Rol(roltipo) values (?)";
        try {
            //Sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, roltipo);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {

            sql = "update Rol set roltipo = ? where id_rol = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, roltipo);
            puente.setString(2, id_rol);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
       try {

            sql = "UPDATE `rol` SET `Estado`= 0 WHERE Id_rol = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_rol);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }   

    public RolVO consultarRol(String rol) {
        RolVO RVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rol where id_rol=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_rol);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                RVO = new RolVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3));
            }
        } catch (Exception e) {
            Logger.getLogger(RolVO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(RolVO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return RVO;
    }

    public ArrayList<RolVO> listar() {

        ArrayList<RolVO> listaRol = new ArrayList();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rolview";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                RolVO RVO = new RolVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3));

                listaRol.add(RVO);
            }
        } catch (Exception e) {
            Logger.getLogger(RolVO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(RolVO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaRol;
    }
     public boolean verificarRol(String rolTipo) {

        RolVO rVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rol where roltipo = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, rolTipo);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                rVO = new RolVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3));
            }
            if (rVO == null) {
                operacion = false;
            } else {
                operacion = true;
            }

        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);

        }

        return operacion;

    }

}
