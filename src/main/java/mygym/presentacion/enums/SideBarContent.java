/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygym.presentacion.enums;

import javax.swing.JPanel;
import mygym.presentacion.pages.Actividades;
import mygym.presentacion.pages.Clase;
import mygym.presentacion.pages.Cuponeras;
import mygym.presentacion.pages.Inicio;
import mygym.presentacion.pages.Instituciones;
import mygym.presentacion.pages.Usuarios;
import mygym.presentacion.enums.PAGE;

/**
 *
 * @author maximilianooliverasilva
 */

public class SideBarContent {
    public PAGE activePage;
    
    public SideBarContent(){
        this.activePage = PAGE.INICIO;
    };
    
    public PAGE getActivePage() {
        return this.activePage;
    }
    
    public void setActivatePage(PAGE val) {
        this.activePage = val;
    }
    
    public JPanel getContentPanel() {
        JPanel pagetoReturn;
        switch (activePage) {
            case INICIO -> pagetoReturn = new Inicio();
            case ACTIVIDAD -> pagetoReturn = new Actividades();
            case CUPONERA -> pagetoReturn = new Cuponeras();
            case CLASE -> pagetoReturn = new Clase();
            case INSTITUCION -> pagetoReturn = new Instituciones();
            case USUARIO -> pagetoReturn = new Usuarios();
            default -> throw new AssertionError();
        }
        return pagetoReturn;
    }
}
