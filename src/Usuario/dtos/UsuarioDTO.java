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
public  class UsuarioDTO {
    protected int ID;
    protected String NOMBRE;
    protected String APELLIDO;
    protected String NICKNAME;
    protected String EMAIL;
    protected Date NACIMIENTO;
    
    public UsuarioDTO(int id, String nombre,String apellido,String nickname,String email,Date nacimiento){
        this.ID = id;
        this.NOMBRE = nombre;
        this.APELLIDO = apellido;
        this.NICKNAME = nickname;
        this.EMAIL = email;
        this.NACIMIENTO = nacimiento;
       
        
    }
    
    public int getId(){
        return this.ID;
    }
    public String getNombre(){
        return this.NOMBRE;
    }
    public String getApellido(){
        return this.APELLIDO;
    }
    public String getNickname(){
        return this.NICKNAME;
    }
    public String getEmail(){
        return this.EMAIL;
    }
    
    public Date getNacimiento(){
        return this.NACIMIENTO;
    }
    
  
    
}
