/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import EntityManajer.InterfaceEntityManager;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
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
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        System.out.println(editProf.getEmail());
        prof.setApellido(editProf.getApellido());
        prof.setEmail(editProf.getEmail());
        prof.setNacimiento(editProf.getFechaNacimiento());
        prof.setNombre(editProf.getNombre());
        prof.setNickname(editProf.getNickname());
        prof.setDescripcionGeneral(editProf.getDescripcionGeneral());
        prof.setLinkSitioWeb(editProf.getLinkSitioWeb());
        prof.setBiografia(editProf.getBiografia());
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
}
