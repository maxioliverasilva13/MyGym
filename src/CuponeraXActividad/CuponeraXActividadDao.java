/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuponeraXActividad;

import EntityManajer.InterfaceEntityManager;
import javax.persistence.EntityManager;
import Actividad.Actividad;
import Exceptions.ActividadNotFoundException;
import Cuponera.Cuponera;
import Exceptions.CuponeraNotFoundException;
import javax.persistence.EntityTransaction;
import Cuponera.CuponeraDao;
/**
 *
 * @author maximilianooliverasilva
 */
public class CuponeraXActividadDao implements InterfaceCuponeraXActividadDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    CuponeraDao cupdao = new CuponeraDao();
    
    
    
    @Override
    public void insertar(int idActividad, int idCuponera, DtCuponeraXActividad cupXact){
        try {
        // EXISTE ACTIVIDA
        Actividad act = em.find(Actividad.class, idActividad);
        if (act == null) {
            throw new ActividadNotFoundException("Actividad no encontrada");
        }
        Cuponera cup = cupdao.existe(idCuponera);
        CuponeraXActividad cuxa = new CuponeraXActividad();
        cuxa.setCantClases(cupXact.getCantClases());
        cuxa.setActividad(act);
        cuxa.setCuponera(cup);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(cuxa);
        et.commit();
        cupdao.agregarCupXActividad(idCuponera, cuxa.getId());
        // TODO : actdao.agregarCupXActividad
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
