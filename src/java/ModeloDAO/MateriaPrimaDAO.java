/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.MateriaPrimaVO;
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
public class MateriaPrimaDAO extends Conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String Id_materia_Prima = "", Nombre = "", Actualizacion = "", Estado = "";

    public MateriaPrimaDAO(MateriaPrimaVO matPriVO) {
        super();

        //3. Conectarse a la base de datos
        try {

            conexion = this.obtenerConexion();
            // 4. traer al DAO los datos del VO para hacer las operaciones.

            Id_materia_Prima = matPriVO.getId_materia_Prima();
            Nombre = matPriVO.getNombre();
            Actualizacion = matPriVO.getActualizacion();
            Estado = matPriVO.getEstado();

        } catch (Exception e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public MateriaPrimaDAO() {
    }

    @Override
    public boolean agregarRegistro() {
        try {
            //Armar sentencia
            sql = "insert into materia_prima(Nombre, Actualizacion)values (?,?)";
            // crear el camino por donde va la sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Nombre);
            puente.setString(2, Actualizacion);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update materia_prima set Nombre = ? where Id_materia_Prima = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Nombre);
            puente.setString(2, Id_materia_Prima);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "UPDATE `materia_prima` SET `Estado`= 0 WHERE Id_materia_Prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_materia_Prima);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    public MateriaPrimaVO consultarIdMateriaPrima(String Id) {

        MateriaPrimaVO matPriVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from materia_prima where Id_materia_Prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                matPriVO = new MateriaPrimaVO(mensajero.getString(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4));

            }

        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return matPriVO;

    }

    public ArrayList<MateriaPrimaVO> Listar() {

        ArrayList<MateriaPrimaVO> listaMateriaPrima = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT materia_prima.Id_materia_Prima,materia_prima.Nombre,"
                    + " calculadora.existencias,materia_prima.Estado FROM calculadora,"
                    + "materia_prima WHERE materia_prima.Id_materia_Prima = calculadora.Id_Materia_Prima and materia_prima.estado =1";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

               MateriaPrimaVO matPriVO = new MateriaPrimaVO(mensajero.getString(1),
                       mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                listaMateriaPrima.add(matPriVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaMateriaPrima;

    }
     public ArrayList<MateriaPrimaVO> ListarDos() {

        ArrayList<MateriaPrimaVO> listaMateriaPrima = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from materiaprimaview";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

               MateriaPrimaVO matPriVO = new MateriaPrimaVO(mensajero.getString(1),
                       mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                listaMateriaPrima.add(matPriVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaMateriaPrima;

    }
     public boolean verificarMateriaPrima(String Nombre) {

        MateriaPrimaVO mpVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from materia_prima where Nombre = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Nombre);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                mpVO = new MateriaPrimaVO(mensajero.getString(1), mensajero.getString(2), 
                        mensajero.getString(3), mensajero.getString(4));
            }
            if (mpVO == null) {
                operacion = false;
            } else {
                operacion = true;
            }

        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        }

        return operacion;

    }
     public ArrayList<MateriaPrimaVO> ListarTres() {

        ArrayList<MateriaPrimaVO> listaMateriaPrima = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from materiaprimaview2";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

               MateriaPrimaVO matPriVO = new MateriaPrimaVO(mensajero.getString(1),
                       mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                listaMateriaPrima.add(matPriVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaMateriaPrima;
     }
     public boolean ActivarRegistro() {
        try {
            sql = "UPDATE `materia_prima` SET `Estado`= 1 WHERE Id_materia_Prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_materia_Prima);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
     
     public boolean EliminarRegistroTotal() {
        try {
            sql = "DELETE FROM `materia_prima` WHERE id_materia_prima = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_materia_Prima);
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(MateriaPrimaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

}

