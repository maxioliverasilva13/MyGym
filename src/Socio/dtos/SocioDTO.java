/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio.dtos;

import Usuario.dtos.UsuarioDTO;
import java.util.Date;

/**
 *
 * @author angel
 */
public class SocioDTO extends UsuarioDTO{

    
    public SocioDTO(int id,String nombre,String apellido,String nickname,String email,Date nacimiento){
        super(id,nombre,apellido,nickname,email,nacimiento);
       
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
