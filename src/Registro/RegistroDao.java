/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;
import Clase.ClaseDao;
import Clase.Clase;
import CompraCuponera.CompraCuponera;
import CompraCuponera.CompraCuponeraBo;
import CompraCuponera.ICompraCuponeraBo;
import Cuponera.Cuponera;
import CuponeraXActividad.CuponeraXActividad;
import CuponeraXActividad.CuponeraXActividadBo;
import CuponeraXActividad.InterfaceCuponeraXActividadBo;
import Socio.Socio;
import EntityManajer.InterfaceEntityManager;
import Exceptions.ClaseNotFoundException;
import Exceptions.ClassHasMaxOfReg;
import Exceptions.CompraCuponeraNotFoundException;
import Exceptions.CuponeraNotFoundException;
import Exceptions.MaxClasesForCuponera;
import Exceptions.RegistroNotFoundException;
import Exceptions.SocioAlreadyAreInClass;
import Exceptions.SocioNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import Socio.SocioDAO;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public class RegistroDao implements InterfaceRegistroDao {
    EntityManager em = InterfaceEntityManager.getInstance();
    ClaseDao clasedao = new ClaseDao();
    SocioDAO socioDao = new SocioDAO();
    Cuponera cuponeraSelected = null;

    public RegistroDao(){

    }
    
    private void SocioEstaEnClase (int idSocio, int idClase) {
        List<Registro> lista =em.createNativeQuery("select * from registro r where r.CLASE_ID=" + idClase + " and r.SOCIO_id=" + idSocio, Registro.class).getResultList();
        if (lista.size() > 0) {
            throw new SocioAlreadyAreInClass("El socio" + idSocio + " ya es parte de la clase" + idClase);
        }
    }
    
    @Override
    public void insertar(int idSocio, int claseID, DtRegistro registro,Integer cuponeraId) throws SocioNotFoundException,CuponeraNotFoundException, MaxClasesForCuponera,CompraCuponeraNotFoundException{
        /*Validamos si existe el socio enviado*/
        Socio socio = em.find(Socio.class, idSocio);
        if (socio == null) {
            throw new SocioNotFoundException("Socio no encontrado");
        }
        /*Validamos si existe la clase enviada*/
        Clase clase = em.find(Clase.class, claseID);
        if(clase == null) {
            throw new ClaseNotFoundException("La clase no existe");
        }
        SocioEstaEnClase(idSocio, claseID);
        /*Validamos si se aplica o no una cuponera*/
        Cuponera cup = null;
        if(cuponeraId != null){
          cup = em.find(Cuponera.class, cuponeraId);
          /* si se aplica o no una cuponera validamos que esta exista*/
          if(cup == null){
              throw new CuponeraNotFoundException("Cuponera no existe");
          }
        }
        
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        /*Compra de la cuponera*/
        float priceOfRegistro; //Precio final
        if(cup != null){
            priceOfRegistro =  clase.getActividad().getCosto() - (( clase.getActividad().getCosto() / 100) * cup.getDescuento());
            /*Vemos si esta asociada a la actividad de la clase previamente encontrada  para restarle cantClases disponibles*/
            InterfaceCuponeraXActividadBo cupXActBO = new CuponeraXActividadBo();
            CuponeraXActividad cupXAct = cupXActBO.get(clase.getActividad().getId(), cup.getId());
            int cantClases = cupXAct.getCantClases();
            if(cantClases <= 0){
                tr.rollback();
                throw new MaxClasesForCuponera("Ya no se puede comprar clases con esta cuponera de esta actividad");
            }
            cupXAct.setCantClases(cantClases - 1);
        }else{
            priceOfRegistro = clase.getActividad().getCosto();
        }    
        Registro r = new Registro();
        float costoFinal;
          
        r.setCosto(priceOfRegistro);
        r.setFecha(registro.getFecha());
        r.setClase(clase);
        r.setSocio(socio);
        em.persist(r);
        tr.commit();
           
        
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