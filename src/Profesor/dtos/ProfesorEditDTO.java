/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor.dtos;

/**
 *
 * @author angel
 */
public class ProfesorEditDTO {
      private String nombre;
    private String apellido;
    private String nickname;
    private String descripcionGeneral;
    private String biografia;
    private String linkSitioWeb;
    
    public ProfesorEditDTO(String nombre,String apellido,String nickname,String descripcionGeneral,String biografia,String linkSitioWeb){
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
       
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getNickname(){
        return this.nickname;
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
