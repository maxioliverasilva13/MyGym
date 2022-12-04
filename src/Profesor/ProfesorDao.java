/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Clase.Clase;
import EntityManajer.InterfaceEntityManager;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import PuntuacionProfesor.PuntuacionProfesor;
import Socio.Socio;
import Socio.dtos.SocioEditDTO;
import Socio.exceptions.SocioNotExist;
import Usuario.Usuario;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Usuario.UsuarioDAO;
import mygym.logica.usuario.dataTypes.ProfesorPuntuacionesDTO;
import utils.EncryptPass;

/**
 *
 * @author angel
 */
public class ProfesorDao  implements IProfesorDao {
    
    UsuarioDAO userDao = new UsuarioDAO();
    EntityManager em = null;
    
    public ProfesorDao(){
        this.em = InterfaceEntityManager.getInstance();
    }
    
    
  
     @Override
    public void editById(int id, ProfesorEditDTO editProf) {        
        
        Profesor prof = this.getById(id);
        if (prof == null) {
            throw new SocioNotExist("El socio no existe");
        }
        if(!prof.getNickname().equals(editProf.getNickname()) && userDao.getByNickname(editProf.getNickname()) != null){
              throw new UserAlreadyNickExist("ya existe un usuario con este nickname");
        }
        if(!prof.getEmail().equals(editProf.getEmail()) && userDao.getByEmail(editProf.getEmail()) != null){
              throw new UserAlreadyEmailExist("ya existe un usuario con este email");
        }
        
        EncryptPass ep = new EncryptPass();

        EntityTransaction tr = em.getTransaction();
        tr.begin();
        prof.setApellido(editProf.getApellido());
        if (editProf.getEmail() != null){
            prof.setEmail(editProf.getEmail());
        }
        prof.setNacimiento(editProf.getFechaNacimiento());
        prof.setNombre(editProf.getNombre());
        if (editProf.getNickname() != null){
            prof.setNickname(editProf.getNickname());
        }
        if (editProf.getPasswordChar() != null){
            String encryptedPassword = ep.encryptPass(new String(editProf.getPasswordChar()));
            prof.setPassword(encryptedPassword);
        }
        prof.setDescripcionGeneral(editProf.getDescripcionGeneral());
        prof.setLinkSitioWeb(editProf.getLinkSitioWeb());
        prof.setBiografia(editProf.getBiografia());
        prof.setImage(editProf.getImage());
        tr.commit();
    }


   
   

    @Override
    public Profesor getById(int id) {
         EntityTransaction tx = this.em.getTransaction();
         try{
              tx.begin();
               Profesor find = (Profesor)this.em.find(Profesor.class, id);
               tx.commit();
               return find;    
          }catch(NoResultException e){
              return null;
          }
    }

    public List<Profesor> listarProfesores() {
        List<Profesor> profesores = em.createNativeQuery("SELECT * FROM profesor JOIN usuario ON profesor.userId = usuario.id", Profesor.class).getResultList();
        return profesores;
    }    

    @Override
    public Profesor getByNickname(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PuntuacionProfesor> getPuntuacionesProfesor(Profesor prof) {
        List<PuntuacionProfesor> res;
        Query query = this.em.createNativeQuery("SELECT puntuacionprofesor.ID, puntuacionprofesor.PUNTUACION, puntuacionprofesor.FECHA, puntuacionprofesor.REGISTRO_ID  FROM puntuacionprofesor JOIN registro ON registro.ID = puntuacionprofesor.REGISTRO_ID JOIN clase ON clase.ID = registro.CLASE_ID JOIN actividad ON actividad.ID = clase.ACTIVIDAD_ID WHERE ACTIVIDAD.PROFESOR_ID="+prof.getId(),PuntuacionProfesor.class);
        res = query.getResultList();
    
        return res;
    }

    @Override
    public List<PuntuacionProfesor> getPuntuacionesProfesorByClass(Clase clase) {
        List<PuntuacionProfesor> res;
        Query query = this.em.createNativeQuery("SELECT puntuacionprofesor.ID, puntuacionprofesor.PUNTUACION, puntuacionprofesor.FECHA, puntuacionprofesor.REGISTRO_ID  FROM puntuacionprofesor JOIN registro ON registro.ID = puntuacionprofesor.REGISTRO_ID JOIN clase ON clase.ID = registro.CLASE_ID WHERE clase.ID="+clase.getId()+"",PuntuacionProfesor.class);
        res = query.getResultList();
    
        return res;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
