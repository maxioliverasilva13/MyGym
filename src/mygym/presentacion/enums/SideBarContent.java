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
import mygym.presentacion.pages.Categorias;

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
            case INICIO : pagetoReturn = new Inicio();
            break;
            case ACTIVIDAD : pagetoReturn = new Actividades();
                        break;
            case CUPONERA : pagetoReturn = new Cuponeras();
                        break;
            case CLASE : pagetoReturn = new Clase();
                        break;
            case INSTITUCION : pagetoReturn = new Instituciones();
                        break;
            case USUARIO : pagetoReturn = new Usuarios();
                        break;
            case CATEGORIA : pagetoReturn = new Categorias();
                        break;
            default : pagetoReturn = new Inicio();
        }
        return pagetoReturn;
    }
}
