/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import CuponeraXActividad.DtCuponeraXActividad;
import EntityManajer.InterfaceEntityManager;
import Exceptions.CuponeraNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author maximilianooliverasilva
 */
public class CuponeraDao implements InterfaceCuponeraDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    
    @Override
    public void insertar(DtCuponera cuponera){
        try {
            Cuponera cup = new Cuponera();
            cup.setDescripcion(cuponera.getDescripcion());
            cup.setDescuento(cuponera.getDescuento());
            cup.setNombre(cuponera.getNombre());
            cup.setPeriodoVigencia(cuponera.getPeriodoVigencia());
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(cup);
            et.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    
    public void agregarCupXActividad(int idCuponera, int idCxA ){
        try {
            Cuponera cup = existe(idCuponera);
            // find the CxA
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            cup.addCuponeraXActividad(null);
            tr.commit();
        } catch (Exception e) {
        }
    }


}
