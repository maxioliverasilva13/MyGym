/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import EntityManajer.InterfaceEntityManager;
import Exceptions.ClassHasMaxOfReg;
import Exceptions.CompraCuponeraNotFoundException;
import Exceptions.CuponeraNotFoundException;
import Exceptions.MaxClasesForCuponera;
import Exceptions.RegistroNotFoundException;
import Exceptions.SocioAlreadyAreInClass;
import Exceptions.SocioNotFoundException;
import Exceptions.RegistroNotFoundException;
import PuntuacionProfesor.IPuntuacionProfesorDAO;
import PuntuacionProfesor.PuntuacionProfesorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maximilianooliverasilva
 */
public class RegistroBO implements InterfaceRegistroBO {
    RegistroDao registrodao = new RegistroDao();
    
    public RegistroBO() {
               InterfaceEntityManager.getInstance();
    }
    
    @Override
    public void agregarRegistro(int idSocio,  int claseID, DtRegistro registro,Integer cuponeraId) throws MaxClasesForCuponera,CompraCuponeraNotFoundException,ClassHasMaxOfReg,SocioAlreadyAreInClass{
            registrodao.insertar(idSocio,  claseID, registro,cuponeraId);
    } 

    @Override
    public void addPuntuacionToProfesor(Registro registro, int puntuacion) {
        IPuntuacionProfesorDAO puntProfDao = new PuntuacionProfesorDAO();
        puntProfDao.create(registro, puntuacion);
    }

    @Override
    public DtRegistro getById(int id) throws RegistroNotFoundException{
       Registro registro = this.registrodao.existe(id);
       System.out.println(registro.getId());
       return registro.getDtRegistro();
    }
}