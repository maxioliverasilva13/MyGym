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
import CuponeraXActividad.CuponeraXActividadDao;
import Cuponera.Cuponera;
import Cuponera.CuponeraDao;
import EntityManajer.InterfaceEntityManager;
import Exceptions.ActividadAlreadyExistsException;

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
    EntityManager em = InterfaceEntityManager.getInstance();
    CuponeraDao cupDao = new CuponeraDao();
     
    public ActividadDao(){
       
    } 

    @Override
    public void create(ActividadCreateDTO act ,Profesor profesor,Institucion institucion) {
        List<Cuponera> existe = em.createNativeQuery("select * from ACTIVIDAD where NOMBRE='" + act.getNombre() +"' AND INSTITUCION_ID="+institucion.getId()).getResultList();
        if (!existe.isEmpty()) {
            throw new ActividadAlreadyExistsException("Ya existe una actividad con ese Nombre, en la institución especificada.");
        }else{
        EntityTransaction tx = em.getTransaction();
        tx.begin();
            Actividad activity = new Actividad();
            activity.setNombre(act.getNombre());
            activity.setDescripcion(act.getDescripcion());
            activity.setDuracion(act.getDuracion());
            activity.setFechaRegistro(act.getFechaRegistro());
            activity.setCosto(act.getCosto());
            activity.setProfesor(profesor);
            activity.setInstitucion(institucion);
            try {
                activity.setImage(act.getImage());
            } catch (Exception e) {
                System.out.println("Error al subir el archivo");
                System.out.println(e.getMessage());
            }
            
            em.persist(activity);
            
        tx.commit();
    }
    }

    @Override
    public Actividad getById(ActividadCreateDTO act) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Actividad> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void agregarCupXActividad(int idActividad, CuponeraXActividad cupXA ){
        try {
            Actividad act = em.find(Actividad.class, idActividad);

            EntityTransaction tr = em.getTransaction();
            tr.begin();
            act.addCuponerasXActividad(cupXA);
            tr.commit();
        } catch (Exception e) {
        }
    }
    
    @Override
    public void agergarClase(int idActividad, Clase clase){
        try {
            Actividad act = em.find(Actividad.class, idActividad);
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            act.addClase(clase);
            tr.commit();
        } catch (Exception e) {
        }
    }
    
    /*primer parametro id de institucion, segundo parametro puede ser (Todas,Aceptada,Rechazada,Ingresada)()*/
   
    
    public List<Actividad> listarActividades(int idInstitucion,String status) {
        try {
            List<Actividad> actividades;
            if(status.equals("Todas")){
                actividades = em.createNativeQuery("select actividad.ID, actividad.COSTO, actividad.DURACION, actividad.FECHAREGISTRO, actividad.NOMBRE ,actividad.DESCRIPCION from ACTIVIDAD actividad WHERE  actividad.INSTITUCION_ID=" + idInstitucion, Actividad.class).getResultList();
            }else{
                
                actividades = em.createNativeQuery("select actividad.ID, actividad.COSTO, actividad.DURACION, actividad.FECHAREGISTRO, actividad.NOMBRE ,actividad.DESCRIPCION from ACTIVIDAD actividad WHERE actividad.ESTADO='"+status+"' AND  " + "actividad.INSTITUCION_ID=" + idInstitucion, Actividad.class).getResultList();
            }            
            return actividades;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Actividad> listarActividadesByInstitucionNotIntCup(int institucionId, int cuponeraId) {
         List<Actividad> actividades = this.em.createNativeQuery("SELECT actividad.id, actividad.costo, actividad.duracion, actividad.fecharegistro, actividad.nombre ,actividad.descripcion FROM actividad WHERE actividad.ID NOT IN (SELECT actividad.id FROM actividad LEFT JOIN cuponeraxactividad ON actividad.id = cuponeraxactividad.ACTIVIDAD_ID WHERE cuponeraxactividad.CUPONERA_ID = " + cuponeraId + " AND actividad.INSTITUCION_ID = "+institucionId + ") ", Actividad.class).getResultList();
         return actividades;
    }
    

    public List<Actividad> getAllActividades() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
       List<Actividad> actividades = this.em.createNativeQuery("SELECT * FROM actividad", Actividad.class).getResultList();
       tx.commit();
        return actividades;
    }

   
}
