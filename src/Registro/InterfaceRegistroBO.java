/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import Exceptions.MaxClasesForCuponera;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceRegistroBO {
    public void agregarRegistro(int idSocio, List<Integer> clases, DtRegistro registro,Integer cuponeraId) throws MaxClasesForCuponera;
}
