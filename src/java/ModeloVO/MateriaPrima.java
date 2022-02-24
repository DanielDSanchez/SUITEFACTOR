/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 1Usuario
 */
public class MateriaPrima {
    int id;
    String nombre;
    int idUs;

    public MateriaPrima(int id, String nombre, int idUs) {
        this.id = id;
        this.nombre = nombre;
        this.idUs = idUs;
    }

    public MateriaPrima() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUs() {
        return idUs;
    }

    public void setIdUs(int idUs) {
        this.idUs = idUs;
    }
    
}
