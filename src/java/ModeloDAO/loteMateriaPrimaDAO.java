/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.loteMateriaPrimaVO;
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
public class loteMateriaPrimaDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    // Declarar variables del modulo(VO)
    private String Id_loteMateria_Prima = "", Id_Materia_Prima = "", cantidad = "", observaciones = "",
            fecha_ingreso = "", fecha_salida = "", Estado = "";

    //2. Crear metodo principal para recibir los datos del VO
    public loteMateriaPrimaDAO(loteMateriaPrimaVO loteMPVO) {
        super();

        //3. Conectarse a la base de datos
        try {

            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            Id_loteMateria_Prima = loteMPVO.getId_loteMateria_Prima();
            Id_Materia_Prima = loteMPVO.getId_Materia_Prima();
            cantidad = loteMPVO.getCantidad();
            observaciones = loteMPVO.getObservaciones();
            fecha_ingreso = loteMPVO.getFecha_ingreso();
            fecha_salida = loteMPVO.getFecha_salida();
            Estado = loteMPVO.getEstado();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            //Armar sentencia
            sql = "insert into lotemateria_prima(Id_Materia_Prima,cantidad, observaciones, fecha_ingreso, fecha_salida) values (?,?,?,?,?)";
            // crear el camino por donde va la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Materia_Prima);
            puente.setString(2, cantidad);
            puente.setString(3, observaciones);
            puente.setString(4, fecha_ingreso);
            puente.setString(5, fecha_salida);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {

        try {
            sql = "update lotemateria_prima set id_materia_prima = ?, cantidad = ?, observaciones = ?, fecha_ingreso = ?, fecha_salida = ? where Id_loteMateria_Prima = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Materia_Prima);
            puente.setString(2, cantidad);
            puente.setString(3, observaciones);
            puente.setString(4, fecha_ingreso);
            puente.setString(5, fecha_salida);
            puente.setString(6, Id_loteMateria_Prima);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {

        try {
            //Armar sentencia
            sql = "UPDATE `lotemateria_prima` SET `Estado`= 0 WHERE Id_lotemateria_prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_loteMateria_Prima);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    public loteMateriaPrimaVO consultarIdLoteMateriaPrima(String Id) {

        loteMateriaPrimaVO ltMatPriVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from lotemateria_prima where Id_loteMateria_Prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                ltMatPriVO = new loteMateriaPrimaVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),
                        mensajero.getString(6), mensajero.getString(7));

            }

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return ltMatPriVO;

    }

    public ArrayList<loteMateriaPrimaVO> Listar() {

        ArrayList<loteMateriaPrimaVO> listaLoteMateriaPrima = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from lotemateriaprimaview";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                loteMateriaPrimaVO ltMatPriVO = new loteMateriaPrimaVO(mensajero.getString(1),
                        mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listaLoteMateriaPrima.add(ltMatPriVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaLoteMateriaPrima;

    }
    public ArrayList<loteMateriaPrimaVO> ListarDos() {

        ArrayList<loteMateriaPrimaVO> listaLoteMateriaPrima = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from lotemateriaprimaview2";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                loteMateriaPrimaVO ltMatPriVO = new loteMateriaPrimaVO(mensajero.getString(1),
                        mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listaLoteMateriaPrima.add(ltMatPriVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaLoteMateriaPrima;
        

    }
    
     public boolean ActivarRegistro() {

        try {
            //Armar sentencia
            sql = "UPDATE `lotemateria_prima` SET `Estado`= 1 WHERE Id_lotemateria_prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_loteMateria_Prima);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
 public boolean eliminarRegistroTotal() {

        try {
            //Armar sentencia
            sql = "DELETE FROM `lotemateria_prima` WHERE id_lotemateria_prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_loteMateria_Prima);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(loteMateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

}
