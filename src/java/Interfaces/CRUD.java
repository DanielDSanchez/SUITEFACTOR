/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.MateriaPrima;
import java.util.List;

/**
 *
 * @author 1Usuario
 */
public interface CRUD {
    public List consultar();
    public MateriaPrima consult(int id);
    public boolean agregar(MateriaPrima mp);
    public boolean editar(MateriaPrima mp);
    public boolean eliminar(int id);
}
