/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Clase.DtClase;
import java.util.Date;

/**
 *
 * @author Maximiliano Olivera
 */
public class SelectedClase {
    
    private static SelectedClase single_instance = null;
    private static Date selectedDate;
    
    public void SelectedClase(){
    }
  
    
    public void SelectedClase(Date clase)
    {
        selectedDate = clase;
    }
  
    public Date getSelectedClase() {
        return SelectedClase.selectedDate;
    }
    
    public static SelectedClase getInstance() {
        if (single_instance == null)
            single_instance = new SelectedClase();
        return single_instance;
    }
}
