/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import EntityManajer.InterfaceEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import Actividad.Actividad;
import Exceptions.ActividadNotFoundException;
import Exceptions.ClaseNotFoundException;
import Exceptions.RegistroNotFoundException;
import Registro.DtRegistro;
import Registro.Registro;
import java.util.Collection;
import java.util.List;
import Actividad.ActividadDao;

/**
 *
 * @author maximilianooliverasilva
 */
public class ClaseDao implements InterfaceClaseDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    ActividadDao actdao = new ActividadDao();
    
    public ClaseDao(){
        
    }

    @Override
    public void insertar(int idActividad, Clase clase){
        Actividad act = em.find(Actividad.class, idActividad);
        if (act == null) {
            throw new ActividadNotFoundException("Actividad no encontrada");
        }
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        clase.setActividad(act);
        actdao.agergarClase(idActividad, clase);
        em.persist(clase);
        tr.commit();
    }
    
    @Override
    public List<Clase> getClasesByActividad(int idActividad){
        List<Clase> clases = em.createNativeQuery(
        "SELECT * FROM CLASE c WHERE c.ACTIVIDAD_ID=" + idActividad, Clase.class)
        .getResultList();
        return clases;
    }
    
    @Override
    public Clase consultarClase(int idClase){
        try {
          Clase clase = existe(idClase);
        return clase;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void agregarRegistro(int idClase, int idRegistro){
        Clase clase = existe(idClase);
        // TODO: SOCIO VALIDATION
        Registro r = em.find(Registro.class, idRegistro);
        if (r == null) {
            throw new RegistroNotFoundException("Registro no encontrado");
        }
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        clase.addRegistro(r);
        tr.commit();
    }
    
    @Override
    public Clase existe(int id){
        Clase clase = em.find(Clase.class, id);
        if (clase == null) {
            throw new ClaseNotFoundException("La clase no existe");
        }
        return clase;
    }
}
