/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygym.logica.usuario.dataTypes;

import Clase.DtClase;
import Profesor.dtos.ProfesorDTO;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mandi
 */
public class DtActividad {
    private int id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private String costo;
    private String fechaRegistro;
    ProfesorDTO profesor;
    private List<DtClase> clases;
    

    public DtActividad(String nombre, String descripcion, String duracion, String costo, String fechaRegistro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
    }

    
    public DtActividad(int id, String nombre, String descripcion, String duracion, String costo, String fechaRegistro, ProfesorDTO profe, List<DtClase> clases) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profe;
        this.clases = clases;
        this.id = id;
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

    public String getDuracion() {
        return duracion;
    }

    public String getCosto() {
        return costo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }
}
