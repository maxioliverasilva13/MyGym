/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import Exceptions.ClassHasMaxOfReg;
import Exceptions.CompraCuponeraNotFoundException;
import Exceptions.CuponeraNotFoundException;
import Exceptions.MaxClasesForCuponera;
import Exceptions.SocioAlreadyAreInClass;
import Exceptions.SocioNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maximilianooliverasilva
 */
public class RegistroBO implements InterfaceRegistroBO {
    RegistroDao registrodao = new RegistroDao();
    
    @Override
    public void agregarRegistro(int idSocio,  List<Integer> clases, DtRegistro registro,Integer cuponeraId) throws MaxClasesForCuponera,CompraCuponeraNotFoundException,ClassHasMaxOfReg,SocioAlreadyAreInClass{
       
            registrodao.insertar(idSocio, clases, registro,cuponeraId);
        
    } 
}