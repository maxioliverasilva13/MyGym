/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Institucion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.ManyToMany;
import Profesor.Profesor;
import java.util.Collection;
import javax.persistence.OneToMany;
import Actividad.Actividad;
import java.util.ArrayList;
import java.util.List;
import Profesor.dtos.ProfesorDTO;
import Actividad.dtos.ActividadDetalleDTO;
import Actividad.dtos.ActividadDTO;
import utils.ParserClassesToDt;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
public class Institucion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;
    private String url;
    @ManyToMany(mappedBy = "instituciones")
    private List<Profesor> profesores = new ArrayList<>();
    @OneToMany(mappedBy = "institucion")
    private List<Actividad> actividades = new ArrayList<>();
    
    public void addProfesor(Profesor prof) {
        this.profesores.add(prof);
    }
    
    public void addActividad(Actividad act) {
        this.actividades.add(act);
    }
    // public void addProfesor()

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
    
    
    
    public DtInstitucion getDtInstitucion() {
        DtInstitucion res = new DtInstitucion(this.id,this.nombre,this.descripcion,this.url,null,null);
        return res;
    }
    
    
}
