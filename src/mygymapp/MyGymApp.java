/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mygymapp;

import EntityManajer.InterfaceEntityManager;
import Usuario.UsuarioDAO;
import javax.persistence.EntityManager;
import mygym.presentacion.pages.Dashboard;

/**
 *
 * @author maximilianooliverasilva
 */
public class MyGymApp {

    public static void main(String[] args)  {
        EntityManager em = InterfaceEntityManager.getInstance();
        Dashboard ds = new Dashboard();
        ds.setVisible(true);
    }
}