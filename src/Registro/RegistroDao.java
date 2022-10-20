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
import Socio.Socio;
import EntityManajer.InterfaceEntityManager;
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
    CompraCuponera compraCuponeraSelected = null;

    public RegistroDao(){

    }
    
    private void SocioEstaEnClase (int idSocio, int idClase) {
        List<Registro> lista =em.createNativeQuery("select * from registro r where r.CLASE_ID=" + idClase + " and r.SOCIO_id=" + idSocio, Registro.class).getResultList();
        if (lista.size() > 0) {
            throw new SocioAlreadyAreInClass("El socio" + idSocio + " ya es parte de la clase" + idClase);
        }
    }
    
    @Override
    public void insertar(int idSocio, List<Integer> clases, DtRegistro registro,Integer cuponeraId) throws SocioNotFoundException,CuponeraNotFoundException, MaxClasesForCuponera,CompraCuponeraNotFoundException{
        System.out.println("voy a buscar a el id" + idSocio);
        Socio socio = em.find(Socio.class, idSocio);
        if (socio == null) {
            throw new SocioNotFoundException("Socio no encontrado");
        }
        Cuponera cup = null;
        if(cuponeraId != null){
          cup = em.find(Cuponera.class, cuponeraId);
          if(cup == null){
              throw new CuponeraNotFoundException("Cuponera no existe");
          }
          ICompraCuponeraBo compraCupBo = new CompraCuponeraBo();
          this.compraCuponeraSelected = compraCupBo.getByCuponeraAndSocio(cuponeraId,idSocio);
          if(this.compraCuponeraSelected.cantClases() <= clases.size()){
              throw new MaxClasesForCuponera("El numero de clases excede la cantidad de clases que se pueden aplicar con la cuponera");
          }
        }
        this.cuponeraSelected = cup;
        clases.forEach((Integer idClase) -> {
            Clase clase = clasedao.existe(idClase);
            int sizeOfRegistros = clase.getRegistros().size();
            if (sizeOfRegistros >= clase.getCapMaxima()) {
                throw new ClassHasMaxOfReg("La clase " + clase.getNombre() + " ya alcanzo su limite de alumnos");
            }
            float priceOfRegistro;
            if(this.cuponeraSelected != null){
                priceOfRegistro =  clase.getActividad().getCosto() - (( clase.getActividad().getCosto() / 100) * this.cuponeraSelected.getDescuento());
                int newCantClass = this.compraCuponeraSelected.cantClases() - 1;
                this.compraCuponeraSelected.setCantClase(newCantClass);
            }else{
               priceOfRegistro = clase.getActividad().getCosto();
            }
           
            
            Registro r = new Registro();
            float costoFinal;
          
            r.setCosto(priceOfRegistro);
            r.setFecha(registro.getFecha());
            SocioEstaEnClase(idSocio, idClase);
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            r.setClase(clase);
            r.setSocio(socio);
            em.persist(r);
            tr.commit();
            // Agrego el registro actual a las 2 puntas
            socioDao.agregarRegistro(idSocio, r.getId());
            clasedao.agregarRegistro(idClase, r.getId());
        });
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