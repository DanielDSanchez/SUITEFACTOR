/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.Usuario;
import java.util.ArrayList;
import Config.Conexion;
import ModeloVO.MateriaPrima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author 1Usuario
 */
public class MateriaPrimaDAO implements Interfaces.CRUD
{
    Conexion conexion = new Conexion();
    Connection Cn;
    PreparedStatement puente;
    ResultSet mensajero;
    MateriaPrima mp = new MateriaPrima();
    boolean Operacion = false;

    /*public ArrayList<Usuario> listarUsuarios(){
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        String sql = "select * from usuarios";
        try{
             Cn = conexion.obtenerConexion();
             puente = Cn.prepareStatement(sql);
             mensajero = puente.executeQuery();
             while(mensajero.next()){
                 Usuario usuario = new Usuario();
                 usuario.setId_Usuarios(mensajero.getInt("Id_Usuarios"));
                 usuario.setNombre(mensajero.getString("Nombre"));
                 usuario.setDocumento(mensajero.getString("Documento"));
                 usuario.setTelefono(mensajero.getString("Telefono"));
                 usuario.setEmail(mensajero.getString("Email"));
                 usuario.setDireccion(mensajero.getString("Direccion"));
                 Usuarios.add(usuario);
             }
        }catch(Exception e){
            
        }
        return Usuarios;
    }; */ 
    
    @Override
    public List consultar() {
        ArrayList<MateriaPrima>list = new ArrayList<>();
        String sql = "select * from materia_prima";
        try{
             Cn = conexion.obtenerConexion();
             puente = Cn.prepareStatement(sql);
             mensajero = puente.executeQuery();
             while(mensajero.next()){
                 MateriaPrima materiaPrima = new MateriaPrima();
                 materiaPrima.setId(mensajero.getInt("Id_materia_Prima"));
                 materiaPrima.setNombre(mensajero.getString("Nombre"));
                 materiaPrima.setEstado(mensajero.getString("Estado"));
                 list.add(materiaPrima);
             }
             
        }catch(Exception e){
            
        }
        return list;
    };
    

    @Override
    public MateriaPrima consult(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrar(MateriaPrima mp) {
      String sql = "insert into materia_prima(Nombre,Estado) values('"+mp.getNombre()+"','"+mp.getEstado()+"')"; 
      try{
          Cn=conexion.obtenerConexion();
          puente=Cn.prepareStatement(sql);
          puente.executeUpdate();
      }catch(SQLException e){
          
      }
      return Operacion;
     
    };

    @Override
    public boolean editar(MateriaPrima mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
