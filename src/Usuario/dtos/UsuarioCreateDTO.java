/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario.dtos;

import java.io.File;
import java.util.Date;

/**
 *
 * @author angel
 */
public abstract class UsuarioCreateDTO {
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String nickname;
    protected Date nacimiento;
    File image;

    public File getImage() {
        return image;
    }

    public UsuarioCreateDTO(String nombre,String apellido,String email,String nickname,Date nacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nickname = nickname;
        this.nacimiento = nacimiento;
    }
    
    public UsuarioCreateDTO(String nombre,String apellido,String email,String nickname,Date nacimiento, File file){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nickname = nickname;
        this.nacimiento = nacimiento;
        this.image = file;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
       return this.apellido;   
    }
    public String getEmail(){
        return this.email;
    }
    public String getNickname(){
        return this.nickname;
    }
    public Date  getNacimiento(){
        return this.nacimiento;
    }
    
    
}
