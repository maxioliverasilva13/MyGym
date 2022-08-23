/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mygym.presentacion.pages.Dashboard;

/**
 *
 * @author maximilianooliverasilva
 */
public class Mavenproject3 {

    public static void main(String[] args) {
        
        Dashboard appDash = new Dashboard();
        appDash.setVisible(true);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myConnection");
        EntityManager em = emf.createEntityManager();
        
        
        //Persona p = new Persona();
        //p.setId(6);
        //p.setNombre("Name");
        //em.getTransaction().begin();
        //em.persist(p);
        //em.getTransaction().commit();
        //em.close();
        
        System.out.println("Hello World!");
        
        
    }
}
