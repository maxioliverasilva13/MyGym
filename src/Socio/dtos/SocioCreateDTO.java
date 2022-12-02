package Socio.dtos;

import Usuario.dtos.UsuarioCreateDTO;
import java.io.File;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author angel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SocioCreateDTO extends UsuarioCreateDTO {
    private String nombre;
    private String apellido;
    private String nickname;
    private Date nacimiento;
    private String email;
    
    public SocioCreateDTO() {
        
    }
    
    public SocioCreateDTO(String nombre,String apellido,String nickname, char[] password,String email,Date nacimiento, File file){
         super(nombre,apellido,email,nickname,nacimiento,password, file);
    }
    
}
