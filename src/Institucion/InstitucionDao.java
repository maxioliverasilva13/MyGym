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
import java.util.List;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author maximilianooliverasilva
 */
public class InstitucionDao implements InterfaceInstitucionDao {
    EntityManager em = null;
    
    public InstitucionDao(){
        this.em = InterfaceEntityManager.getInstance();

    }
    
    @Override
    public void insertar(DtInstitucion institucion){
        Institucion ins = new Institucion();
        ins.setDescripcion(institucion.getDescripcion());
        ins.setNombre(institucion.getNombre());
        ins.setUrl(institucion.getUrl());
        if (institucion.getImage() != null) {
            ins.setImage(institucion.getImage());
        }
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(ins);
        tr.commit();
    }
    
    @Override
    public Institucion existe(int id){
        Institucion ins = em.find(Institucion.class, id);
        if (ins == null) {
            throw new InstitucionNotFoundException("La institucion no existe");
        }
        return ins;
    }
    
    @Override
    public void agregarProfesor(int profesorId, int idInstitucion){
        Institucion ins = existe(idInstitucion);
        Profesor prof = em.find(Profesor.class, profesorId);
        if (prof == null) {
            throw new ProfesorNotFoundException("La institucion no existe");
        }
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        ins.addProfesor(prof);
        em.persist(ins);
        em.persist(prof);
        tr.commit();
    }
    
    @Override
    public void agregarActividad(int actId, int insId){
        try {
            Institucion ins = existe(insId);
            Actividad act = em.find(Actividad.class, actId);
            if (act == null) {
                throw new ActividadNotFoundException("La Actividad no existe");
            }
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            ins.addActividad(act);
            act.setInstitucion(ins);
            tr.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public List<Institucion> listarInstituciones() {
        List<Institucion> instituciones = em.createNativeQuery("SELECT * FROM INSTITUCION", Institucion.class).getResultList();
        return instituciones;
    }


}
