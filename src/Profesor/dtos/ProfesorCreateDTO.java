/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor.dtos;

import Usuario.dtos.UsuarioCreateDTO;
import java.util.Date;

/**
 *
 * @author angel
 */
public class ProfesorCreateDTO extends UsuarioCreateDTO{
    
   
    private String descripcionGeneral;
    private String biografia;
    private String linkSitioWeb;
  
    
    public ProfesorCreateDTO(String nombre,String apellido,String nickname,String descripcionGeneral,String biografia,String email, String linkSitioWeb,Date nacimiento){
        super(nombre,apellido,email,nickname,nacimiento);
        
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
    }
    
    public String getdescripcionGeneral(){
        return this.descripcionGeneral;
    }
    public String getBiografia(){
        return this.biografia;
    }
    public String getLinkSitioWeb(){
        return this.linkSitioWeb;
    }
       
    
}
