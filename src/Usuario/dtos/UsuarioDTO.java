/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario.dtos;

import java.util.Date;

/**
 *
 * @author angel
 */
public abstract class UsuarioDTO {
     protected int id;
     protected String nombre;
    protected String apellido;
    protected String nickname;
    protected String email;
    protected Date nacimiento;
    
    public UsuarioDTO(int id, String nombre,String apellido,String nickname,String email,Date nacimiento){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.email = email;
        this.nacimiento = nacimiento;
        
    }
    
    public int getId(){
        return this.id;
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
    public String getEmail(){
        return this.email;
    }
    
}
