/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;
import Actividad.dtos.ActividadCreateDTO;
import Clase.Clase;
import CuponeraXActividad.CuponeraXActividad;
import Profesor.Profesor;
import Institucion.Institucion;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 *
 * @author angel
 */


public class ActividadDao implements IActividadDao {
     private  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Actividad");
    
    public ActividadDao(){
       
    } 

    @Override
    public void create(ActividadCreateDTO act ,Profesor profesor,Institucion institucion) {
        
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
            Actividad activity = new Actividad();
            activity.setDescripcion(act.getDescripcion());
            activity.setDuracion(act.getDuracion());
            activity.setFechaRegistro(act.getFechaRegistro());
            activity.setCosto(act.getCosto());
            activity.setProfesor(profesor);
            activity.setInstitucion(institucion);
            
            
            em.persist(activity);
            
        tx.commit();
    }

    @Override
    public Actividad getById(ActividadCreateDTO act) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Actividad> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
}
