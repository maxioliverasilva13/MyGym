/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygym.logica.usuario.dataTypes;

import java.util.Date;

/**
 *
 * @author mandi
 */
public class DtActividad {
    private String nombre;
    private String descripcion;
    private String duracion;
    private String costo;
    private String fechaRegistro;

    public DtActividad(String nombre, String descripcion, String duracion, String costo, String fechaRegistro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
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
