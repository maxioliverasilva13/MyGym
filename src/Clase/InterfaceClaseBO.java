/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import Registro.DtRegistro;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceClaseBO {
    public void insertarClase(int idActividad, DtClase clase);
    public HashMap<Integer, DtClase> listarClasesByAct(int idActividad);
    public DtClase consultarClase(int idClase);
    public void agregarRegistro(int idClase, int idRegistro);

}
