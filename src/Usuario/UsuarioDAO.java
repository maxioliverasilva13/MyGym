/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import EntityManajer.InterfaceEntityManager;
import Institucion.Institucion;
import Institucion.InstitucionDao;
import Profesor.Profesor;
import Profesor.dtos.ProfesorCreateDTO;
import Socio.Socio;
import Socio.dtos.SocioCreateDTO;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



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
         
        EntityTransaction tx = em.getTransaction();
        tx.begin();
      
         if(userCreate instanceof ProfesorCreateDTO){
            
            ProfesorCreateDTO profCreate = (ProfesorCreateDTO)userCreate;
            
            Profesor newProfesor = new Profesor();
            newProfesor.setDTYPE("Profesor");
            newProfesor.setNombre(profCreate.getNombre());
            newProfesor.setApellido(profCreate.getApellido());
            newProfesor.setNickname(profCreate.getNickname());
            newProfesor.setNacimiento(profCreate.getNacimiento());
            newProfesor.setEmail(profCreate.getEmail());
            newProfesor.setBiografia(profCreate.getBiografia());
            newProfesor.setLinkSitioWeb(profCreate.getLinkSitioWeb());
            newProfesor.setDescripcionGeneral(profCreate.getdescripcionGeneral());
            Institucion ins = insDao.existe(profCreate.getIdInstitucion());
            newProfesor.agregarInstitucion(ins);
            
            this.em.persist(newProfesor);
            
        }else{  // es un socio
            SocioCreateDTO socioCreate = (SocioCreateDTO)userCreate;
            
            Socio newSocio = new Socio();
            newSocio.setNombre(socioCreate.getNombre());
            newSocio.setApellido(socioCreate.getApellido());
            newSocio.setNickname(socioCreate.getNombre());
            newSocio.setNacimiento(socioCreate.getNacimiento());
            newSocio.setEmail(socioCreate.getEmail());
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
               System.out.println("encontre " + find.getId());
               System.out.println("encontre " + find.getDtype());
               tx.commit();
               return find.getDtype();
          } catch(NoResultException e){
              // System.out.println(e.getMessage());
          }
          return null;

        
    }
    
    
    
    
}
