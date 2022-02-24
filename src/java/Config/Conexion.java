/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 1Usuario
 */
public class Conexion {
   // 1. Declarar variables y Objetos
    private String driver, user, password, dataBase, urlBd;
    private Connection conexion;

    // 2. Asignar Valores.
    public Conexion() {

        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        dataBase = "suitefactor";
        urlBd = "jdbc:mysql://localhost:3306/" + dataBase;

        // 3. Conectarse.
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd, user, password);
            System.out.println("Conexion ok!");
        } catch (Exception e) {
            System.out.println("Error al conectarse" + e.toString());
        }

    }

    public Connection obtenerConexion(){
        
        return conexion;
    }
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
        
    }
    
    public static void main(String[] args) {
        new Conexion();
    }
}
