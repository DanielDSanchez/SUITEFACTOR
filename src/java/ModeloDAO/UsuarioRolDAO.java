/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.RolVO;
import ModeloVO.Usuario_rolVO;
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
public class UsuarioRolDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String id_Rol, id_Usuarios, estado;

    public UsuarioRolDAO() {
    }
    

    public UsuarioRolDAO(Usuario_rolVO uRVO) {
        super();

        try {
            conexion = this.obtenerConexion();
            id_Rol = uRVO.getId_Rol();
            id_Usuarios = uRVO.getId_Usuarios();
            estado = uRVO.getEstado();

        } catch (Exception e) {
            Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        sql = "insert into usuario_rol(Id_Rol,Id_Usuarios,Estado) values (?,?,?)";
        try {
            //Sentencia
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_Rol);
            puente.setString(2, id_Usuarios);
            puente.setString(3, estado);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            
            sql= "update usuario_rol set Id_Rol = ?, Estado = ? where Id_Usuarios = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_Rol);
            puente.setString(2, estado);
            puente.setString(3, id_Usuarios);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try{
                this.cerrarConexion();
            }catch (Exception e){
                Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario_rolVO consultarRol(String id_Usuarios){
        Usuario_rolVO uRVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario_rol where id_Usuarios=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_Usuarios);
            mensajero = puente.executeQuery();
            while(mensajero.next()){
                uRVO = new Usuario_rolVO(mensajero.getString(1), mensajero.getString(2),mensajero.getString(3));
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try{
                this.cerrarConexion();
            }catch(Exception e){
                Logger.getLogger(UsuarioRolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return uRVO;
    }
    
    public ArrayList<Usuario_rolVO> listar(){
        
        ArrayList<Usuario_rolVO> listaUsuarioRol = new ArrayList();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from UsuarioRolView";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            
            while(mensajero.next()){
                Usuario_rolVO uRVO = new Usuario_rolVO(mensajero.getString(1),mensajero.getString(2));
                
                listaUsuarioRol.add(uRVO);
            }
        } catch (Exception e) {
            Logger.getLogger(RolVO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try{
                this.cerrarConexion();
            }catch(Exception e){
                Logger.getLogger(RolVO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaUsuarioRol;
    }


}
