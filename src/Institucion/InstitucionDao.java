/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Institucion;

import EntityManajer.InterfaceEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import Exceptions.InstitucionNotFoundException;
import Profesor.Profesor;
import Actividad.Actividad;
import Exceptions.ActividadNotFoundException;
import Exceptions.ProfesorNotFoundException;

/**
 *
 * @author maximilianooliverasilva
 */
public class InstitucionDao implements InterfaceInstitucionDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    
    InstitucionDao(){
        
    }
    
    @Override
    public void insertar(DtInstitucion institucion){
        Institucion ins = new Institucion();
        ins.setDescripcion(institucion.getDescripcion());
        ins.setNombre(institucion.getNombre());
        ins.setUrl(institucion.getUrl());
        
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(ins);
        tr.commit();
    }
    
    @Override
    public Institucion existe(int id){
        try {
            Institucion ins = em.find(Institucion.class, id);
            if (ins == null) {
                throw new InstitucionNotFoundException("La institucion no existe");
            }
            return ins;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public void agregarProfesor(int profesorId, int idInstitucion){
        try {
            Institucion ins = existe(idInstitucion);
            Profesor prof = em.find(Profesor.class, profesorId);
            if (prof == null) {
                throw new ProfesorNotFoundException("La institucion no existe");
            }
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            ins.addProfesor(prof);
            prof.addInstitucion(ins);
            em.persist(ins);
            em.persist(prof);
            tr.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void agregarActividad(int actId, int insId){
        try {
            Institucion ins = existe(insId);
            Actividad act = em.find(Actividad.class, actId);
            if (act == null) {
                throw new ActividadNotFoundException("La Actividad no existe");
            }
            System.out.println("asd");
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            ins.addActividad(act);
            act.setInstitucion(ins);
            tr.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}