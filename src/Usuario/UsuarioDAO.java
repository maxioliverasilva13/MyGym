/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Clase.Clase;
import EntityManajer.InterfaceEntityManager;
import Exceptions.UsuarioASeguirNotFoundException;
import Institucion.Institucion;
import Institucion.InstitucionDao;
import Profesor.Profesor;
import Profesor.dtos.ProfesorCreateDTO;
import Socio.Socio;
import Socio.dtos.SocioCreateDTO;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import utils.EncryptPass;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import Exceptions.UsuarioASeguirNotFoundException;
import Seguidor.Seguidor;



/**
 *
 * @author angel
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    EntityManager em = null;
    InstitucionDao insDao = new InstitucionDao();
    
    public UsuarioDAO(){
        this.em = InterfaceEntityManager.getInstance();
    }

    @Override
    public void create(UsuarioCreateDTO userCreate) {
         
        EncryptPass ep = new EncryptPass();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
      
         if(userCreate instanceof ProfesorCreateDTO){
            
            ProfesorCreateDTO profCreate = (ProfesorCreateDTO)userCreate;
            String encryptedPassword = ep.encryptPass(new String(userCreate.getPasswordChar()));
        
            Profesor newProfesor = new Profesor();
            newProfesor.setDTYPE("Profesor");
            newProfesor.setNombre(profCreate.getNombre());
            newProfesor.setApellido(profCreate.getApellido());
            newProfesor.setNickname(profCreate.getNickname());
            newProfesor.setPassword(encryptedPassword);
            newProfesor.setNacimiento(profCreate.getNacimiento());
            newProfesor.setEmail(profCreate.getEmail());
            newProfesor.setBiografia(profCreate.getBiografia());
            newProfesor.setLinkSitioWeb(profCreate.getLinkSitioWeb());
            newProfesor.setDescripcionGeneral(profCreate.getdescripcionGeneral());
            newProfesor.setImage(profCreate.getImage());
            Institucion ins = insDao.existe(profCreate.getIdInstitucion());
            newProfesor.agregarInstitucion(ins);
            
            this.em.persist(newProfesor);
            
        }else{  // es un socio
            SocioCreateDTO socioCreate = (SocioCreateDTO)userCreate;
            
            String encryptedPassword = ep.encryptPass(new String(userCreate.getPasswordChar()));
            
            Socio newSocio = new Socio();
            newSocio.setNombre(socioCreate.getNombre());
            newSocio.setApellido(socioCreate.getApellido());
            newSocio.setNickname(socioCreate.getNickname());
            newSocio.setPassword(encryptedPassword);
            newSocio.setNacimiento(socioCreate.getNacimiento());
            newSocio.setEmail(socioCreate.getEmail());
            newSocio.setImage(socioCreate.getImage());
            newSocio.setDTYPE("Socio");
            
            this.em.persist(newSocio);
        }
        
        tx.commit();
            
        
        
        
    }

    @Override
    public Usuario getByNickname(String nickname) {
       
            List<Usuario> usuarios;
            Query query = this.em.createNativeQuery("SELECT * FROM usuario WHERE NICKNAME = "+"'"+nickname+"'",Usuario.class);
            query.setMaxResults(1);
            usuarios = query.getResultList();
            if(usuarios.isEmpty()){
                return null;
            }
            return usuarios.get(0);  
        
    }
    
 

    @Override
    public Usuario getByEmail(String email) {
        List<Usuario> usuarios;
        Query query = this.em.createNativeQuery("SELECT * FROM usuario WHERE EMAIL = "+"'"+email+"'",Usuario.class);
        query.setMaxResults(1);
        usuarios = query.getResultList();
        if(usuarios.isEmpty()){
            return null;
         }
         return usuarios.get(0);
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios;
        Query query = this.em.createNativeQuery("SELECT * FROM  usuario LEFT JOIN profesor ON usuario.id = profesor.userId LEFT JOIN socio ON socio.userId = usuario.id",Usuario.class);
        usuarios = query.getResultList();
    
        return usuarios;
    }

    @Override
    public Usuario getById(int id) {
        
         EntityTransaction tx = this.em.getTransaction();
         try{
              tx.begin();
               Usuario find = (Usuario)this.em.find(Usuario.class, id);
               tx.commit();
               return find;
          }catch(NoResultException e){
              System.out.println(e.getMessage());
          }
         return null;
    }

    @Override
    public String getTipoById(int id) {
        EntityTransaction tx = this.em.getTransaction();
         try{
              tx.begin();
               Usuario find = (Usuario)this.em.find(Usuario.class, id);
               //System.out.println("encontre " + find.getId());
               //System.out.println("encontre " + find.getDtype());
               tx.commit();
               return find.getDtype();
          } catch(NoResultException e){
              // System.out.println(e.getMessage());
          }
          return null;
    }
    
    public void existeSeguido(int myId, int idUsuario) {
        List<Seguidor> seguido;
        Query querySeguidor = em.createNativeQuery(
        "SELECT * FROM seguidor s WHERE s.PERSONA_ID=" + myId + " and s.SIGUEA_ID=" + idUsuario, Seguidor.class);
        seguido = querySeguidor.getResultList();
        if (!seguido.isEmpty()) {
            throw new UsuarioASeguirNotFoundException("Ya sigues a este usuario");
        }
    }
    
    @Override
    public void seguirAUsuario(int myId, int idUsuario) {
        if (myId == idUsuario) {
            throw new UsuarioASeguirNotFoundException("No te puedes seguir a ti mismo");
        }
        existeSeguido(myId, idUsuario);
        
        Usuario yo = getById(myId);
        if (yo == null) {
            throw new UsuarioASeguirNotFoundException("El usuario que va a seguir no existe");
        }
        
        Usuario personaASeguir = getById(idUsuario);
        if (personaASeguir == null) {
            throw new UsuarioASeguirNotFoundException("El usuario que va a seguir no existe");
        }
        EntityTransaction tx = this.em.getTransaction();
        tx.begin();
        Seguidor seg = new Seguidor();
        seg.setPersona(yo);
        seg.setSigueA(personaASeguir);
        em.persist(seg);
        tx.commit();
    }
    
    @Override
    public void dejarSeguirUsuario(int myId, int idUsuario) {
        Query querySeguidor = em.createNativeQuery(
        "SELECT *FROM seguidor s WHERE s.PERSONA_ID=" + myId + " and s.SIGUEA_ID=" + idUsuario, Seguidor.class);
        Seguidor s = (Seguidor)querySeguidor.getSingleResult();
        if (s!= null) {
             EntityTransaction tx = this.em.getTransaction();
            tx.begin();
            em.remove(s);
            tx.commit();
            
        }
       
    }
    
    @Override
    public int getSeguidos(int idUsuario) {
        Query querySeguidos = em.createNativeQuery(
        "SELECT COUNT(*) FROM seguidor s WHERE s.PERSONA_ID=" + idUsuario + ";"/*, Seguidor.class*/);
        int s = Math.toIntExact((Long)querySeguidos.getSingleResult());
        return s;
    }
    
    @Override
    public int getSeguidores(int idUsuario) {
        Query querySeguidores = em.createNativeQuery(
        "SELECT COUNT(*) FROM seguidor s WHERE s.SIGUEA_ID=" + idUsuario + ";"/*, Seguidor.class*/);
        int s = Math.toIntExact((Long)querySeguidores.getSingleResult());
        return s;
    }
}
