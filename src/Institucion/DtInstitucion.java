/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Institucion;

import Actividad.dtos.ActividadDTO;
import java.util.List;
import Profesor.dtos.ProfesorDTO;
import Actividad.dtos.ActividadDetalleDTO;

/**
 *
 * @author maximilianooliverasilva
 */
public class DtInstitucion {
    private int id;
    private String nombre;
    private String descripcion;
    private String url;
    private List<ProfesorDTO> profesores;
    private List<ActividadDTO> actividades;

    public DtInstitucion(int id, String nombre, String descripcion, String url, List<ProfesorDTO> profesores, List<ActividadDTO> actividades) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.profesores = profesores;
        this.actividades = actividades;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

    public List<ProfesorDTO> getProfesores() {
        return profesores;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }
    
}
