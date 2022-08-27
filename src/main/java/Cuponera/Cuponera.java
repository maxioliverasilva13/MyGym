/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuponera;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.ManyToMany;
import Actividad.Actividad;
import java.util.Collection;
import javax.persistence.OneToMany;
import CuponeraXActividad.CuponeraXActividad;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
public class Cuponera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;
    private Date periodoVigencia;
    private int descuento;
    @OneToMany(mappedBy = "cuponera")
    private Collection<CuponeraXActividad> cuponerasXActividad;
    

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

    public Date getPeriodoVigencia() {
        return periodoVigencia;
    }

    public void setPeriodoVigencia(Date periodoVigencia) {
        this.periodoVigencia = periodoVigencia;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    
}