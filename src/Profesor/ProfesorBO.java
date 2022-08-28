/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Actividad.Actividad;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import Profesor.exceptions.ProfesorNotExist;
import java.util.HashMap;
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
         Profesor prof = profDao.getById(id);
         if(prof == null){
             throw new ProfesorNotExist("El profesor no existe");
         }

         ProfesorDTO res = new ProfesorDTO(prof.getId(),prof.getNombre(),prof.getApellido(),prof.getNickname(),prof.getEmail(),prof.getNacimiento(),  prof.getDescripcionGeneral(),prof.getBiografia(),
         prof.getLinkSitioWeb());
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

   
}
