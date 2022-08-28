/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;
import Clase.ClaseDao;
import Clase.Clase;
import Socio.Socio;
import EntityManajer.InterfaceEntityManager;
import Exceptions.RegistroNotFoundException;
import Exceptions.SocioNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author maximilianooliverasilva
 */
public class RegistroDao implements InterfaceRegistroDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    ClaseDao clasedao = new ClaseDao();
    
    RegistroDao(){
        
    }
    
    @Override
    public void insertar(int idSocio, int idClase, DtRegistro registro){
        try {
            Clase clase = clasedao.existe(idClase);
            // TODO: FIND SOCIO WITH EXIST
            Socio socio = em.find(Socio.class, idSocio);
            if (socio == null) {
                throw new SocioNotFoundException("Socio no encontrado");
            }
            // existe la clase y el socio
            Registro r = new Registro();
            r.setCosto(registro.getCosto());
            r.setFecha(registro.getFecha());
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            r.setClase(clase);
            r.setSocio(socio);
            em.persist(r);
            tr.commit();
            // TODO : socioDao.agregarRegistro
            clasedao.agregarRegistro(idClase, idSocio);
        } catch (Exception e) {
        }
    }
    
    @Override
    public Registro existe(int id){
        try {
            Registro ins = em.find(Registro.class, id);
            if (ins == null) {
                throw new RegistroNotFoundException("El registro no existe");
            }
            return ins;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    

}
