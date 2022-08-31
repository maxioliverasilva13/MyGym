/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import EntityManajer.InterfaceEntityManager;
import Profesor.Profesor;
import Profesor.dtos.ProfesorCreateDTO;
import Socio.Socio;
import Socio.dtos.SocioCreateDTO;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.exceptions.DatabaseException;


/**
 *
 * @author angel
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    EntityManager em = null;
    
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
            newProfesor.setNombre(profCreate.getNombre());
            newProfesor.setApellido(profCreate.getApellido());
            newProfesor.setNickname(profCreate.getNickname());
            newProfesor.setNacimiento(profCreate.getNacimiento());
            newProfesor.setEmail(profCreate.getEmail());
            newProfesor.setBiografia(profCreate.getBiografia());
            newProfesor.setLinkSitioWeb(profCreate.getLinkSitioWeb());
            newProfesor.setDescripcionGeneral(profCreate.getdescripcionGeneral());
            
            this.em.persist(newProfesor);
            
        }else{  // es un socio
            SocioCreateDTO socioCreate = (SocioCreateDTO)userCreate;
            
            Socio newSocio = new Socio();
            newSocio.setNombre(socioCreate.getNombre());
            newSocio.setApellido(socioCreate.getApellido());
            newSocio.setNickname(socioCreate.getNombre());
            newSocio.setNacimiento(socioCreate.getNacimiento());
            newSocio.setEmail(socioCreate.getEmail());
        
            
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
        Query query = this.em.createNativeQuery("SELECT id,nombre,apellido,nickname,email,nacimiento FROM  usuario",Usuario.class);
        usuarios = query.getResultList();
        
        return usuarios;
    }
    
    
    
    
}
