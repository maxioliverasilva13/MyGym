/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import EntityManajer.InterfaceEntityManager;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import Usuario.Usuario;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author angel
 */
public class ProfesorDao  implements IProfesorDao {
    
    
    EntityManager em = null;
    
    public ProfesorDao(){
        this.em = InterfaceEntityManager.getInstance();
    }
    
    
  
    @Override
    public void editById(int id, ProfesorEditDTO editProf) {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    

    @Override
    public Profesor getByNickname(String nickname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
