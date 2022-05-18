/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CantidadNecesariaVO;
import Util.Conexion;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESCOBAR
 */
public class CantidadNecesariaDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    
    private String Id_Materia_Prima, Id_Detalles_Producto, materiaprimaenproducto;
    
    public CantidadNecesariaDAO(CantidadNecesariaVO cantNecVO){
        super();
        
        try {
            
            conexion = this.obtenerConexion();
            //Traer datos para operar
            
            Id_Materia_Prima = cantNecVO.getId_Materia_Prima();
            Id_Detalles_Producto = cantNecVO.getId_Detalles_Producto();
            materiaprimaenproducto = cantNecVO.getMateriaprimaenproducto();
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public CantidadNecesariaDAO() {
    }

    @Override
    public boolean agregarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CantidadNecesariaVO consultarCantidadNecesaria(String Id){
        CantidadNecesariaVO cantNecVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "select * from cantidadnecesaria where Id_Materia_Prima=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, Id_Materia_Prima);
            mensajero = puente.executeQuery();
            
            while(mensajero.next()){
                cantNecVO = new CantidadNecesariaVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3));
            }
        } catch (Exception e) {
            Logger.getLogger(CantidadNecesariaVO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try{
                this.cerrarConexion();
            }catch(Exception e){
                Logger.getLogger(CantidadNecesariaVO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return cantNecVO;
    }
    
    public ArrayList<CantidadNecesariaVO> listar(){
        
        ArrayList<CantidadNecesariaVO> listaCantidadNecesaria = new ArrayList();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from cantidadnecesaria";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            
            while(mensajero.next()){
                CantidadNecesariaVO cantNecVO = new CantidadNecesariaVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3));
                
                listaCantidadNecesaria.add(cantNecVO);
            }
        } catch (Exception e) {
            Logger.getLogger(CantidadNecesariaVO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try{
                this.cerrarConexion();
            }catch(Exception e){
                Logger.getLogger(CantidadNecesariaVO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaCantidadNecesaria;
    }
}
