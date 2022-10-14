/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import CompraCuponera.CompraCuponera;
import CuponeraXActividad.CuponeraXActividadDao;
import CuponeraXActividad.CuponeraXActividad;
import CuponeraXActividad.DtCuponeraXActividad;
import EntityManajer.InterfaceEntityManager;
import Exceptions.CuponeraNotFoundException;
import Exceptions.CuponeraAlreadyExistsException;
import Socio.Socio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author maximilianooliverasilva
 */
public class CuponeraDao implements InterfaceCuponeraDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    
    @Override
    public void insertar(DtCuponera cuponera){
            List<Cuponera> existe = em.createNativeQuery("select * from CUPONERA where NOMBRE='" + cuponera.getNombre() +"'").getResultList();
            if (existe.size() > 0) {
                throw new CuponeraAlreadyExistsException("Ya existe una cuponera con ese Nombre.");
            }else{
                Cuponera cup = new Cuponera();
                cup.setDescripcion(cuponera.getDescripcion());
                cup.setDescuento(cuponera.getDescuento());
                cup.setNombre(cuponera.getNombre());
                cup.setPrecio(cuponera.getPrecio());
                if (cuponera.getImage() != null) {
                    cup.setImage(cuponera.getImage());
                }
                cup.setPeriodoVigencia(cuponera.getPeriodoVigencia());
                EntityTransaction et = em.getTransaction();
                et.begin();
                em.persist(cup);
                et.commit();
            }
    }
    
    @Override
    public List<Cuponera> listar(){
        try {
        List<Cuponera> cuponeras = em.createNativeQuery(
            "SELECT * FROM CUPONERA", Cuponera.class)
            .getResultList();
        return cuponeras;
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }
    
    @Override
    public Cuponera existe(int idCup){
        try {
          Cuponera cup = em.find(Cuponera.class, idCup);
          if (cup == null) {
              throw  new CuponeraNotFoundException("Cuponera no encontrada");
          }
          return cup;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public void agregarCupXActividad(int idCuponera, CuponeraXActividad cupXA ){
        try {
            Cuponera cup = existe(idCuponera);
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            cup.addCuponeraXActividad(cupXA);
            tr.commit();
        } catch (Exception e) {
        }
    }

    @Override
    public List<Cuponera> listarVigentes() {
       List<Cuponera> cuponeras = em.createNativeQuery(
            "SELECT * FROM CUPONERA WHERE PERIODOVIGENCIA > NOW()", Cuponera.class)
            .getResultList();
       return cuponeras;
    }

    @Override
    public void comprarCuponera(Socio socio, Cuponera cuponera,int cantClases) {
                CompraCuponera newPurchase = new CompraCuponera();
                newPurchase.setCosto(cuponera.getPrecio());
                newPurchase.setCuponera(cuponera);
                newPurchase.setSocio(socio);
                newPurchase.setFecha(new Date());
                newPurchase.setCantClase(cantClases);
                EntityTransaction et = em.getTransaction();
                et.begin();
                em.persist(newPurchase);
                et.commit();
    }      

    @Override
    public List<Cuponera> listarDisponiblesBySocioAndActividad(int socioID,int actId) {
        List<Cuponera> cuponeras = em.createNativeQuery(
            "SELECT * FROM CUPONERA cup WHERE  EXISTS (SELECT * FROM compracuponera cp WHERE cp.CUPONERA_ID = cup.ID AND cp.SOCIO_ID = "+socioID +") AND EXISTS (SELECT * FROM cuponeraxactividad ca WHERE ca.CUPONERA_ID = cup.ID AND ca.ACTIVIDAD_ID = "+actId+"); "
, Cuponera.class)
            .getResultList();

       return cuponeras;
    }
    
    @Override
    public List<Cuponera> listarDisponiblesBySocio(int socioID) {
        List<Cuponera> cuponeras = em.createNativeQuery(
            "SELECT * FROM CUPONERA cup WHERE  EXISTS (SELECT * FROM compracuponera cp WHERE cp.CUPONERA_ID = cup.ID AND cp.SOCIO_ID = "+socioID +");"
, Cuponera.class)
            .getResultList();

       return cuponeras;
    }
    

}
