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
import Socio.SocioDAO;

/**
 *
 * @author maximilianooliverasilva
 */
public class RegistroDao implements InterfaceRegistroDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    ClaseDao clasedao = new ClaseDao();
    SocioDAO socioDao = new SocioDAO();

    public RegistroDao(){

    }

    @Override
    public void insertar(int idSocio, int idClase, DtRegistro registro){
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
        // Agrego el registro actual a las 2 puntas
        socioDao.agregarRegistro(idSocio, r.getId());
        clasedao.agregarRegistro(idClase, r.getId());
    }

    @Override
    public Registro existe(int id){
        Registro ins = em.find(Registro.class, id);
        if (ins == null) {
            throw new RegistroNotFoundException("El registro no existe");
        }
        return ins;
    }
}