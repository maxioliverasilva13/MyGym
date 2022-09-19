
package Actividad.dtos;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Categoria.DtCategoria;
import Clase.DtClase;
import CuponeraXActividad.DtCuponeraXActividad;
import Institucion.DtInstitucion;
import Profesor.dtos.ProfesorDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ActividadDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;
    private float costo;
    private Date fechaRegistro;
    ProfesorDTO profesor;
    private List<DtClase> clases = new ArrayList<>();
    private List<DtCuponeraXActividad> cuponerasXActivdad = new ArrayList<>();
    private List<DtCategoria> categorias = new ArrayList<>();

    DtInstitucion institucion;
    

    public ActividadDTO(String nombre, String descripcion, int duracion, float costo, Date fechaRegistro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
    }
    
    public ActividadDTO(int id, String nombre, String descripcion, int duracion, float costo, Date fechaRegistro, ProfesorDTO profe, List<DtClase> clases, DtInstitucion ins) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profe;
        if (clases != null) {
            this.clases = clases;
        }
        this.id = id;
        this.institucion = ins;
    }
    
    public ActividadDTO(int id, String nombre, String descripcion, int duracion, float costo, Date fechaRegistro, ProfesorDTO profe, List<DtClase> clases, DtInstitucion ins, List<DtCuponeraXActividad> cupsXAct) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profe;
        if (clases != null) {
            this.clases = clases;
        }
        this.clases = clases;
        this.id = id;
        this.institucion = ins;
        if (cupsXAct != null) {
           this.cuponerasXActivdad = cupsXAct;
        }
    }
    
    public ActividadDTO(int id, String nombre, String descripcion, int duracion, float costo, Date fechaRegistro, ProfesorDTO profe, List<DtClase> clases, DtInstitucion ins, List<DtCuponeraXActividad> cupsXAct, List<DtCategoria> cats) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profe;
        if (clases != null) {
            this.clases = clases;
        }
        this.clases = clases;
        this.id = id;
        this.institucion = ins;
        if (cupsXAct != null) {
           this.cuponerasXActivdad = cupsXAct;
        }
        if (cats != null) {
            this.categorias = cats;
        }
    }
    
    public int getId(){
        return id;
    }
    
    public ProfesorDTO getProfesor() {
        return profesor;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<DtClase> getClases() {
        return clases;
    }

    public int getDuracion() {
        return duracion;
    }

    public float getCosto() {
        return costo;
    }
    
    public List<DtCuponeraXActividad> getDtCuponeraXActividad() {
        return this.cuponerasXActivdad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
}
