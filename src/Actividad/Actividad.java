/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import Profesor.Profesor;
import Institucion.Institucion;
import java.util.Collection;
import javax.persistence.ManyToMany;
import Cuponera.Cuponera;
import javax.persistence.OneToMany;
import Clase.Clase;
import CuponeraXActividad.CuponeraXActividad;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
public class Actividad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String descripcion;
    private int duracion;
    private float costo;
    private Date fechaRegistro;
    @ManyToOne
    @JoinColumn()
    private Profesor profesor;
    @ManyToOne
    @JoinColumn()
    private Institucion institucion;
    @OneToMany(mappedBy = "actividad")
    private Collection<Clase> clases;
    @OneToMany(mappedBy = "actividad")
    private Collection<CuponeraXActividad> cuponerasXActividad;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
