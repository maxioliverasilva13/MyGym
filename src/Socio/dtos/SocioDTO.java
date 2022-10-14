/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio.dtos;

import Registro.DtRegistro;
import Usuario.dtos.UsuarioDTO;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 *
 * @author angel
 */
public class SocioDTO extends UsuarioDTO {

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
