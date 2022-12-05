/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario.dtos;

import java.io.File;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author angel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class UsuarioCreateDTO {
    
    public UsuarioCreateDTO() {
        
    }

    protected String nombre;
    protected String apellido;
    protected String email;
    protected String nickname;
    protected char[] password;
    protected Date nacimiento;

    File image;

    public File getImage() {
        return image;
    }

    public UsuarioCreateDTO(String nombre, String apellido, String email, String nickname, Date nacimiento, char[] pass, File file) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nickname = nickname;
        this.password = pass;
        this.nacimiento = nacimiento;
        this.image = file;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public char[] getPasswordChar() {
        return this.password;
    }

    public String getPasswordString() {
        return this.password.toString();
    }

    public Date getNacimiento() {
        return this.nacimiento;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
