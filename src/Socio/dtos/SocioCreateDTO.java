package Socio.dtos;

import Usuario.dtos.UsuarioCreateDTO;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author angel
 */
public class SocioCreateDTO extends UsuarioCreateDTO {
    private String nombre;
    private String apellido;
    private String nickname;
    private Date nacimiento;
    private String email;
    
    public SocioCreateDTO(String nombre,String apellido,String nickname, char[] password,String email,Date nacimiento){
         super(nombre,apellido,email,nickname,password,nacimiento);

       
    }
    
    
    
    
}
