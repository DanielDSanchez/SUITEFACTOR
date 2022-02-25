/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.MateriaPrima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                 materiaPrima.setId(mensajero.getInt("Id_materiaPrima"));
                 materiaPrima.setNombre(mensajero.getString("Nombre"));
                 materiaPrima.setIdUs(mensajero.getInt("Id_Usuarios"));
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
      String sql = "insert into materia_prima(Id_materiaPrima,Nombre,Id_Usuarios) values('"+mp.getId()+"','"+mp.getNombre()+"','"+mp.getIdUs()+"')"; 
      try{
          /*Cn = conexion.obtenerConexion();
          puente.executeUpdate();
          puente.setInt(1,mp.getId());
          puente.setInt(3,mp.getIdUs() );
          puente.setString(2,mp.getNombre());
          puente = Cn.prepareStatement(sql);
          puente.executeUpdate();
          Operacion = true;*/
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
