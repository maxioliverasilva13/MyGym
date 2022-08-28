/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Institucion;

import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public class DtInstitucion {
    private int id;
    private String nombre;
    private String descripcion;
    private String url;
    // private List<DtProfesor> profesores;
    // private List<DtActividad> actividades;

    public DtInstitucion(int id, String nombre, String descripcion, String url) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
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

    
}
