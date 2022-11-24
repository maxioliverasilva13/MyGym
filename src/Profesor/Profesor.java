/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Usuario.Usuario;
import java.util.Collection;
import javax.persistence.Entity;
import Actividad.Actividad;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import Institucion.Institucion;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import Profesor.dtos.ProfesorDTO;
import java.util.ArrayList;
import Institucion.DtInstitucion;
import Actividad.dtos.ActividadDTO;
import PuntuacionProfesor.PuntuacionProfesor;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.OneToOne;
import org.eclipse.persistence.annotations.Cache;
import utils.ParserClassesToDt;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@PrimaryKeyJoinColumn(name = "userId")
@Table
@Cacheable(false)
public class Profesor extends Usuario {
 private String descripcionGeneral;
 private String biografia;
 private String linkSitioWeb;
 
 @ManyToMany()
 private List<Institucion> instituciones = new ArrayList();
 @OneToMany(mappedBy = "profesor")
 private Set<Actividad> actividades;
 

 
 
    
 
    public void agregarInstitucion(Institucion ins) {
        this.instituciones.add(ins);
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getLinkSitioWeb() {
        return linkSitioWeb;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setLinkSitioWeb(String linkSitioWeb) {
        this.linkSitioWeb = linkSitioWeb;
    }

    public List<Institucion> getInstituciones() {
        return this.instituciones;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setDTYPE(String DTYPE) {
        this.DTYPE = DTYPE;
    }
    
    public ProfesorDTO getDtProfesor() {
        ParserClassesToDt parseclass = new ParserClassesToDt();
        if (this.image != null) {
            ProfesorDTO profe = new ProfesorDTO(this.id, this.nombre, this.apellido, this.nickname, this.email, this.nacimiento, this.descripcionGeneral, this.biografia, this.linkSitioWeb, parseclass.getActividadDTOs(actividades), parseclass.getInstitucionesDt(instituciones), this.createTempFile(),  null, null, this.getImage());
            return profe;
        } else {
            ProfesorDTO profe = new ProfesorDTO(this.id, this.nombre, this.apellido, this.nickname, this.email, this.nacimiento, this.descripcionGeneral, this.biografia, this.linkSitioWeb, parseclass.getActividadDTOs(actividades), parseclass.getInstitucionesDt(instituciones), null,  null, null, this.getImage());
            return profe;
        }
    }
    
  

}
