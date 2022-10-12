/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor.dtos;

import Actividad.dtos.ActividadDTO;
import Institucion.DtInstitucion;
import Institucion.Institucion;
import Usuario.dtos.UsuarioDTO;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 *
 * @author angel
 */
public class ProfesorDTO extends UsuarioDTO {
   
    private String descripcionGeneral;
    private String biografia;
    private String linkSitioWeb;
    private List<DtInstitucion> instituciones;
    private List<ActividadDTO> actividades;
    
    public ProfesorDTO(int id,String nombre,String apellido,String nickname,String email ,Date nacimiento,String descripcionGeneral,String biografia,String linkSitioWeb, List<ActividadDTO> acts, List<DtInstitucion> instituciones, File file, List<UsuarioDTO> seguidos, List<UsuarioDTO> seguidores, byte[] blobImage){
      super(id, nombre,apellido,nickname,email,nacimiento, file, seguidos, seguidores, blobImage);
      this.descripcionGeneral = descripcionGeneral;
      this.biografia = biografia;
      this.linkSitioWeb = linkSitioWeb;
      this.actividades = acts;
      this.instituciones = instituciones;
    }



    public List<DtInstitucion> getInstituciones() {
        return this.instituciones;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }
    
   
    public String getdescripcionGeneral(){
        return this.descripcionGeneral;
    }
    public String getBiografia(){
        return this.biografia;
    }
    public String getLinkSitioWeb(){
        return this.linkSitioWeb;
    }
    
    public String getType(){
        return "Profesor";
    }
       
}
