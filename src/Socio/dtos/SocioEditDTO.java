/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio.dtos;

import java.util.Date;

/**
 *
 * @author angel
 */
public class SocioEditDTO {
    private String nombre;
    private String apellido;
    private String nickname;
    private Date nacimiento;
    private String email;
    
    public SocioEditDTO(String nombre,String apellido,String nickname,String email,Date nacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.nacimiento = nacimiento;
        this.email = email;
       
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
 
    public Date getNacimiento(){
        return this.nacimiento;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    
}
