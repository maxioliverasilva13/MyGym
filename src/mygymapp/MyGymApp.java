/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mygymapp;

import EntityManajer.InterfaceEntityManager;
import javax.persistence.EntityManager;
import mygym.presentacion.pages.Dashboard;

/**
 *
 * @author maximilianooliverasilva
 */
public class MyGymApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
                
        EntityManager inter = InterfaceEntityManager.getInstance();
        
        Dashboard ds = new Dashboard();
        ds.setVisible(true);
        
    }
    
}
