/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio.dtos;

import java.io.File;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author angel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SocioEditDTO {
    private String nombre;
    private String apellido;
    private String nickname;
    private char[] password;
    private Date nacimiento;
    private String email;
    private File image;

    public File getImage() {
        return image;
    }
    
    public SocioEditDTO(String nombre,String apellido,String nickname,char[] pass,String email,Date nacimiento, File image){
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.password = pass;
        this.nacimiento = nacimiento;
        this.email = email;
        this.image = image;
    }
    
    public SocioEditDTO() {
        
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
 
    public char[] getPasswordChar(){
        return this.password;
    }
    
    public Date getNacimiento(){
        return this.nacimiento;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
    
}
