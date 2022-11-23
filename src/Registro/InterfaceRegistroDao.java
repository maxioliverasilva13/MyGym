/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import Clase.Clase;
import Exceptions.CompraCuponeraNotFoundException;
import Exceptions.CuponeraNotFoundException;
import Exceptions.MaxClasesForCuponera;
import Exceptions.SocioNotFoundException;
import Socio.Socio;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceRegistroDao {
    public void insertar(int idSocio, int claseID, DtRegistro registro,Integer cuponeraId) throws SocioNotFoundException,CuponeraNotFoundException, MaxClasesForCuponera,CompraCuponeraNotFoundException;
    public Registro existe(int idRegistro);
    public void SocioEstaEnClase (int idSocio, int idClase);
    public Registro getByClaseAndSocio(Socio socio, Clase clase);
   
}
