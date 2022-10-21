/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import Exceptions.ClassHasMaxOfReg;
import Exceptions.CompraCuponeraNotFoundException;
import Exceptions.MaxClasesForCuponera;
import Exceptions.SocioAlreadyAreInClass;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceRegistroBO {
    public void agregarRegistro(int idSocio, List<Integer> clases, DtRegistro registro,Integer cuponeraId) throws MaxClasesForCuponera,CompraCuponeraNotFoundException,ClassHasMaxOfReg,SocioAlreadyAreInClass;
}
