/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuntuacionProfesor;

import EntityManajer.InterfaceEntityManager;
import Profesor.Profesor;
import Registro.Registro;
import Socio.Socio;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author rodrigo
 */
public class PuntuacionProfesorDAO implements IPuntuacionProfesorDAO {
    EntityManager em = InterfaceEntityManager.getInstance();

    @Override
    public PuntuacionProfesor create(Registro registro, int puntuacion) {
        
       EntityTransaction tx = this.em.getTransaction();
       tx.begin();
       PuntuacionProfesor newPuntuacion = new PuntuacionProfesor();
       newPuntuacion.setRegistro(registro);
       newPuntuacion.setFecha(new Date());
       newPuntuacion.setPuntuacion(puntuacion);
       em.persist(newPuntuacion);
       tx.commit();
       return newPuntuacion;
    }

   

    @Override
    public boolean existe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeByRegistro(Registro registro) {
        List<PuntuacionProfesor> lista =em.createNativeQuery("select * from puntuacionprofesor p where p.REGISTRO_ID=" + registro.getId() + " " , Registro.class).getResultList();
        if (lista.size() <= 0) {
            return false;
        }
        return true;
    }
    
}
