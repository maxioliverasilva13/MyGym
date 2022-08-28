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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angel
 */
public class ActividadBO  implements IActividadBO{
    
    
 

    @Override
    public void crear(ActividadCreateDTO actCreate, int institucionId,int profesorId) {
           IActividadDao actDao = new ActividadDao();
           IProfesorDao profDao = new ProfesorDao();
           //IInstitucioDao  insDao = new InstitucionDao();
           Profesor profesorFind = profDao.getById(profesorId);
           if(profesorFind == null){
               
           }
           //Institucion instFind = insDao.getById(institucionId);    
           /*if(insDao.getBydId(institucionId)  == null){
               exception
            }
           
           */
            //actDao.create(actCreate,profesorFind,ins);
          
              
           
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HashMap<Integer, ActividadDetalleDTO> consultarById(int id) {
        ActividadDetalleDTO res = null;
        ActividadDao actDao = new ActividadDao();
        
       // Actividad act = actDao.getById(actDao)
        return null;
        
    }

    @Override
    public HashMap<Integer, ActividadDTO> listarByInstitucion(int idInstitucion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HashMap<Integer, ActividadDTO> listarNotInCuponeras(int cuponeraId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addCupXAct(CuponeraXActividad cupXAct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
