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

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@PrimaryKeyJoinColumn(name = "userId")
@Table
public class Profesor extends Usuario {
 private String descripcionGeneral;
 private String biografia;
 private String linkSitioWeb;
 @ManyToMany()
 private Set<Institucion> instituciones;
 @OneToMany(mappedBy = "profesor")
 private Set<Actividad> actividades;
 
 public void addInstitucion(Institucion a){
     this.instituciones.add(a);
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
 
 

}
