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
    MateriaPrima MateriaPrima = new MateriaPrima();

    @Override
    public List consultar() {
        ArrayList<MateriaPrima>list = new ArrayList<>();
        String sql = "select * from materia_prima";
        try{
             Cn = conexion.obtenerConexion();
             puente = Cn.prepareStatement(sql);
             mensajero = puente.executeQuery();
             while(mensajero.next()){
                 MateriaPrima mt = new MateriaPrima();
                 mt.setId(mensajero.getInt("Id_materiaPrima"));
                 mt.setNombre(mensajero.getString("Nombre"));
                 mt.setIdUs(mensajero.getInt("Id_Usuarios"));
                 list.add(mt);
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
    public boolean agregar(MateriaPrima mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(MateriaPrima mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
