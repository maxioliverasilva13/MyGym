/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio.dtos;

import Registro.DtRegistro;
import Usuario.dtos.UsuarioDTO;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author angel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SocioDTO extends UsuarioDTO implements Serializable {

    private List<DtRegistro> registros;
    
    public SocioDTO(int id,String nombre,String apellido,String nickname,String email,Date nacimiento,List<DtRegistro> registros, File file, List<UsuarioDTO> seguidos, List<UsuarioDTO> seguidores, byte[] blobImage){
        super(id,nombre,apellido,nickname,email,nacimiento, file, seguidos, seguidores, blobImage);
        this.registros  = registros;
    }
    
    public List<DtRegistro> getRegistros(){
        return this.registros;
    }
    
    public String getType(){
        return "Socio";
    }
    
    
   
}
