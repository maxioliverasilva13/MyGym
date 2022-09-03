/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Actividad.Actividad;
import Actividad.dtos.ActividadDTO;
import Institucion.DtInstitucion;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import Profesor.exceptions.ProfesorNotExist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author angel
 */
public class ProfesorBO implements IProfesorBO {

    @Override
    public ProfesorDTO getProfesorById(int id) throws ProfesorNotExist  {
         IProfesorDao profDao = new ProfesorDao();
         Profesor profFind = profDao.getById(id);
         ProfesorDTO res;
         if(profFind == null){
             throw new ProfesorNotExist("El profesor no existe");
         }
         List<DtInstitucion> instituciones = new ArrayList();
         List<ActividadDTO> actividades = new ArrayList();
         
         profFind.getActividades().forEach((actividad) ->{
               actividades.add(actividad.getDtActividad());
          });
         
         profFind.getInstituciones().forEach((institucion) ->{
               instituciones.add(institucion.getDtInstitucion());
         });

        res = new ProfesorDTO(profFind.getId(),profFind.getNombre(),
                 profFind.getApellido(),profFind.getNickname(),profFind.getEmail(),profFind.getNacimiento(),  profFind.getDescripcionGeneral(),
                 profFind.getBiografia(),
         profFind.getLinkSitioWeb(),
         actividades,
         instituciones);
         return res;
    }

  
    @Override
    public boolean existeById(int id) {
        ProfesorDao profDao = new ProfesorDao();
        if(profDao.getById(id) != null){
            return true;
        } 
        return false;
    }

    @Override
    public void editProfesorById(int id, ProfesorEditDTO profEdit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarActividad(Actividad act) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public HashMap<Integer, ProfesorDTO> listarProfesores(){
        ProfesorDao profDao = new ProfesorDao();
        List<Profesor> profes = profDao.listarProfesores();
        HashMap<Integer, ProfesorDTO> profesDTO = new HashMap<>();
        profes.forEach((prof) -> {
            profesDTO.put(prof.getId(), prof.getDtProfesor());
        });
        
        return profesDTO;
    }   
}
