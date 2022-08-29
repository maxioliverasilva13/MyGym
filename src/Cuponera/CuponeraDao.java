/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import CuponeraXActividad.CuponeraXActividadDao;
import CuponeraXActividad.CuponeraXActividad;
import CuponeraXActividad.DtCuponeraXActividad;
import EntityManajer.InterfaceEntityManager;
import Exceptions.CuponeraNotFoundException;
import Exceptions.CuponeraAlreadyExistsException;
import java.util.ArrayList;
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
        //try {
            List<Cuponera> existe = em.createNativeQuery("select * from CUPONERA where NOMBRE='" + cuponera.getNombre() +"'").getResultList();
            if (existe.size() > 0) {
                throw new CuponeraAlreadyExistsException("Ya existe una cuponera con ese Nombre.");
            }else{
                Cuponera cup = new Cuponera();
                cup.setDescripcion(cuponera.getDescripcion());
                cup.setDescuento(cuponera.getDescuento());
                cup.setNombre(cuponera.getNombre());
                cup.setPeriodoVigencia(cuponera.getPeriodoVigencia());
                EntityTransaction et = em.getTransaction();
                et.begin();
                em.persist(cup);
                et.commit();
            }
        //} catch (Exception e) {
            //JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        //}
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


}
