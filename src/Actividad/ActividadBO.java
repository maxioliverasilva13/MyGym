package Actividad;

import Actividad.dtos.ActividadCreateDTO;
import Actividad.IActividadBO;
import Actividad.dtos.ActividadDTO;
import Actividad.dtos.ActividadDetalleDTO;
import Clase.Clase;
import CuponeraXActividad.CuponeraXActividad;
import Institucion.Institucion;
import Profesor.IProfesorDao;
import Profesor.Profesor;
import Profesor.ProfesorDao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import Actividad.Actividad;
import Cuponera.CuponeraDao;
import Cuponera.InterfaceCuponeraDao;
import Exceptions.CuponeraNotFoundException;
import Exceptions.InstitucionNotFoundException;
import Institucion.InstitucionDao;
import Institucion.InterfaceInstitucionDao;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angel
 */
public class ActividadBO  implements IActividadBO{
    ActividadDao actDao = new ActividadDao();

    @Override
    public void crear(ActividadCreateDTO actCreate, int institucionId, int profesorId) {
           IProfesorDao profDao = new ProfesorDao();
           InterfaceInstitucionDao  insDao = new InstitucionDao();
           Profesor profesorFind = profDao.getById(profesorId);
           if(profesorFind == null){
               throw new Exceptions.ProfesorNotFoundException("Profesor no encontrado.");
           }
           
           Institucion instFind = insDao.existe(institucionId);
           actDao.create(actCreate, profesorFind, instFind);
    }

    @Override
    public HashMap<Integer, ActividadDetalleDTO> consultarById(int id) {
        ActividadDetalleDTO res = null;
        ActividadDao actDao = new ActividadDao();
        
        // Actividad act = actDao.getById(actDao)
        return null;
        
    }

   

    @Override
    public HashMap<Integer, ActividadDTO> listarByInstitucionNotInCuponeras(int institucionId, int cuponeraId) throws InstitucionNotFoundException,CuponeraNotFoundException{
        InterfaceInstitucionDao insDao = new InstitucionDao();
        InterfaceCuponeraDao cupDao = new CuponeraDao();
        if(insDao.existe(institucionId) == null){
            throw new InstitucionNotFoundException("Institucion no existe");
        }
        if(cupDao.existe(cuponeraId) == null){
            throw new CuponeraNotFoundException("Cuponera no existe");
        }
        
        HashMap<Integer,ActividadDTO> res = new HashMap<Integer,ActividadDTO>();
        this.actDao.listarActividadesByInstitucionNotIntCup(institucionId, cuponeraId).forEach((actividad) ->{
             res.put(actividad.getId(), actividad.getDtActividad());
        });
        return res;
    }

    @Override
    public void addCupXAct(CuponeraXActividad cupXAct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public HashMap<Integer, ActividadDTO> listarActividades(int idInstitucion){ 
        HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
        List<Actividad> acts = actDao.listarActividades(idInstitucion);
        acts.forEach((Actividad act) -> {
            actividades.put(act.getId(), act.getDtActividad());
        });
        return actividades;
    }
    
    public HashMap<Integer, ActividadDTO> getAllActividades(){
        HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
        Collection<Actividad> acts = actDao.getAllActividades();
        acts.forEach((Actividad act) -> {
            actividades.put(act.getId(), act.getDtActividad());
        });
        return actividades;
    }
    
    @Override
    public HashMap<Integer, ActividadDTO> listarByInstitucion(int idInstitucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
