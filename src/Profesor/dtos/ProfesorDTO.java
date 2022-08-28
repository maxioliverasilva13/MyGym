/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor.dtos;

import Usuario.dtos.UsuarioDTO;

/**
 *
 * @author angel
 */
public class ProfesorDTO extends UsuarioDTO {
   
    private String descripcionGeneral;
    private String biografia;
    private String linkSitioWeb;
    
    public ProfesorDTO(int id,String nombre,String apellido,String nickname,String email ,Date nacimiento,String descripcionGeneral,String biografia,String linkSitioWeb){
        super(id, nombre,apellido,nickname,email,nacimiento);
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
