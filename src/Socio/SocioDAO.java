/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio;


import EntityManajer.InterfaceEntityManager;
import Profesor.Profesor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author angel
 */
public class SocioDAO implements ISocioDAO{
    
    EntityManager em = null;
    public SocioDAO(){
        this.em = InterfaceEntityManager.getInstance();

    }
    
    public List<Socio> listar(){
        List<Socio> res;  
        Query query = this.em.createNativeQuery("SELECT * FROM profesor JOIN usuario ON profesor.userId = usuario.id", Socio.class);
        res = query.getResultList();
        return res;
    }

    @Override
    public Socio getById(int id) {
         EntityTransaction tx = this.em.getTransaction();
         try{
              tx.begin();
               Socio find = (Socio)this.em.find(Socio.class, id);
               tx.commit();
               return find;    
          }catch(NoResultException e){
              return null;
          }
    }
    
    
   
}
