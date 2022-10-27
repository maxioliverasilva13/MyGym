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
import Actividad.ActividadDao;
import Exceptions.CuponeraXActividadExistsForThisActivityAndCuponera;
import Exceptions.CuponeraXActividadNotFoundException;
import java.util.List;
/**
 *
 * @author maximilianooliverasilva
 */
public class CuponeraXActividadDao implements InterfaceCuponeraXActividadDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    CuponeraDao cupdao = new CuponeraDao();
    ActividadDao actDao = new ActividadDao();
    
    @Override
    public void insertar(int idActividad, int idCuponera, DtCuponeraXActividad cupXact){
        // EXISTE ACTIVIDA
        Actividad act = em.find(Actividad.class, idActividad);
        if (act == null) {
            throw new ActividadNotFoundException("Actividad no encontrada");
        }
        List<CuponeraXActividad> exists = em.createNativeQuery("select * from CUPONERAXACTIVIDAD where ACTIVIDAD_ID=" + idActividad + " AND CUPONERA_ID=" + idCuponera).getResultList();
        if (exists.size() > 0) {
            throw new CuponeraXActividadExistsForThisActivityAndCuponera("Esta cuponera ya tiene esta actividad");
        }
        List<CuponeraXActividad> isAvailable = em.createNativeQuery("select * from CUPONERAXACTIVIDAD where CUPONERA_ID= "+ idCuponera + " AND NOT EXISTS (SELECT * FROM compracuponera WHERE CUPONERA_ID = 301);").getResultList();
        if (isAvailable.size() == 0) {
            throw new CuponeraXActividadExistsForThisActivityAndCuponera("Esta cuponera ya ha sido comprada, no se le pueden agregar actividades.");
        }
        Cuponera cup = cupdao.existe(idCuponera);
        CuponeraXActividad cuxa = new CuponeraXActividad();
        cuxa.setActividad(act);
        cuxa.setCuponera(cup);
        cuxa.setCantClases(cupXact.getCantClases());
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(cuxa);
        et.commit();
        cupdao.agregarCupXActividad(idCuponera, cuxa);
        actDao.agregarCupXActividad(idActividad, cuxa);
    }
    
    @Override
   public CuponeraXActividad existe(int idCuXAc) {
    CuponeraXActividad cuxa = em.find(CuponeraXActividad.class, idCuXAc);
    if (cuxa == null){
        throw new CuponeraXActividadNotFoundException("Cuponera X Actividad no encontrada");
    }
    return cuxa;
    }

    @Override
    public int getCantClass(Cuponera cup, Actividad act) {
        List<CuponeraXActividad> res  = em.createNativeQuery("select * from CUPONERAXACTIVIDAD cuxa where cuxa.ACTIVIDAD_ID=" + act.getId() + " AND cuxa.CUPONERA_ID=" + cup.getId(), CuponeraXActividad.class).getResultList();
        if(res.size() <= 0){
          throw new CuponeraXActividadNotFoundException("Cuponera X Actividad no encontrada");
        }
        return res.get(0).getCantClases();
    }
    
    @Override
    public CuponeraXActividad get(Cuponera cup, Actividad act) {
        List<CuponeraXActividad> res  = em.createNativeQuery("SELECT * from CUPONERAXACTIVIDAD where ACTIVIDAD_ID=" + act.getId() + " AND CUPONERA_ID=" + cup.getId(),CuponeraXActividad.class).getResultList();
        if(res.size() <= 0){
          throw new CuponeraXActividadNotFoundException("Cuponera X Actividad no encontrada");
        }
        return res.get(0);
    }
}
