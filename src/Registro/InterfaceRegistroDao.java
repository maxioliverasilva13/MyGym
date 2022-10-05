/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import Clase.Clase;
import Exceptions.CuponeraNotFoundException;
import Exceptions.MaxClasesForCuponera;
import Exceptions.SocioNotFoundException;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceRegistroDao {
    public void insertar(int idSocio, List<Integer> clases, DtRegistro registro,Integer cuponeraId) throws SocioNotFoundException,CuponeraNotFoundException, MaxClasesForCuponera;
    public Registro existe(int idRegistro);
}
