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
import EntityManajer.InterfaceEntityManager;
import Exceptions.ActividadNotFoundException;
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
    
    public ActividadBO() {
        // this is for the frontend servelets because by default the entity manager is not instanced
        InterfaceEntityManager.getInstance();
    }

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
    public ActividadDTO consultarById(int id) {
        Actividad act = actDao.getById(id);
        if (act != null) {
            return act.getDtActividad();
        }
        return null;
    }

   

    @Override
    public HashMap<Integer, ActividadDTO> listarByInstitucionNotInCuponeras(int institucionId, int cuponeraId,String status) throws InstitucionNotFoundException,CuponeraNotFoundException{
        InterfaceInstitucionDao insDao = new InstitucionDao();
        InterfaceCuponeraDao cupDao = new CuponeraDao();
        if(insDao.existe(institucionId) == null){
            throw new InstitucionNotFoundException("Institucion no existe");
        }
        if(cupDao.existe(cuponeraId) == null){
            throw new CuponeraNotFoundException("Cuponera no existe");
        }
        
        HashMap<Integer,ActividadDTO> res = new HashMap<Integer,ActividadDTO>();
        this.actDao.listarActividadesByInstitucionNotIntCup(institucionId, cuponeraId,status).forEach((actividad) ->{
             res.put(actividad.getId(), actividad.getDtActividad());
        });
        return res;
    }

    @Override
    public void addCupXAct(CuponeraXActividad cupXAct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public HashMap<Integer, ActividadDTO> listarActividades(int idInstitucion,String status){ 
        HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
        List<Actividad> acts = actDao.listarActividades(idInstitucion,status);
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
    public HashMap<Integer, ActividadDTO> getActividadesWithLimitAndAccepted(int limite){
        HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
        Collection<Actividad> acts = actDao.getAllActividadesWithLimitAndAccepted(limite);
        acts.forEach((Actividad act) -> {
            actividades.put(act.getId(), act.getDtActividad());
        });
        return actividades;
    }
    
    @Override
    public int getActividadesAceptadasSize(){
        return actDao.getActividadesAceptadasSize();
    }
    
    
    @Override
    public HashMap<Integer, ActividadDTO> listarByInstitucion(int idInstitucion,String status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HashMap<Integer, ActividadDTO> listarAllActividadesPendientes() {
        HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
        List<Actividad> acts = actDao.listarAllActividadesPendientes();
        acts.forEach((Actividad act) -> {
            actividades.put(act.getId(), act.getDtActividad());
        });
        return actividades;    
    }
    
    @Override
    public HashMap<Integer, ActividadDTO> listarActividadesByCategoria(List<String> cat, String estado){ 
        HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
        List<ActividadDTO> acts = actDao.listarActividadesByCategoria(cat,estado);
        acts.forEach((ActividadDTO act) -> {
            actividades.put(act.getId(), act);
        });
        return actividades;
    }

    @Override
    public void cambiarEstado(int idActividad, String newStatus) throws ActividadNotFoundException {
        IActividadDao actDao = new ActividadDao();
        Actividad actFind = actDao.getById(idActividad);
        if(actFind  == null){
            throw new ActividadNotFoundException("Actividad no existe!");
        }
        actDao.cambiarEstado(actFind, newStatus);
         
    }
}
