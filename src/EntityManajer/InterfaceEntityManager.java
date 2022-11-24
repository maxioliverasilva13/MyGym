/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityManajer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author maximilianooliverasilva
 */
public class InterfaceEntityManager {
    private static EntityManager instance = null; 
    
    private InterfaceEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myConnection");
        EntityManager em = emf.createEntityManager();
        instance = em;
    }
    
    public static EntityManager getInstance(){
        if (instance==null) {
            InterfaceEntityManager interfaceEntityManager = new InterfaceEntityManager();
        }
        instance.clear();
        return instance;
    }
    
    
}
