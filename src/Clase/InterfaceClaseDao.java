/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.util.Collection;
import java.util.List;
import Registro.DtRegistro;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceClaseDao {
    
    public void insertar(int idActividad, Clase clase);
    public List<Clase> getClasesByActividad(int idActividad);
    public Clase consultarClase(int idClase);
    public void agregarRegistro(int idClase, int idRegistro);
    public Clase existe(int id);
}
