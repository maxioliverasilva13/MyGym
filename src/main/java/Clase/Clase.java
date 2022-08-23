/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.ManyToOne;
import Actividad.Actividad;
import java.util.Collection;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import Registro.Registro;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
public class Clase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private Date fecha;
    private int capMinima;
    private int capMaxima;
    private String urlAcceso;
    private Date fechaRegistro;
    @ManyToOne
    @JoinColumn()
    private Actividad actividad;
    @OneToMany(mappedBy = "clase")
    private Collection<Registro> registros;
    
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCapMinima() {
        return capMinima;
    }

    public void setCapMinima(int capMinima) {
        this.capMinima = capMinima;
    }

    public int getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(int capMaxima) {
        this.capMaxima = capMaxima;
    }

    public String getUrlAcceso() {
        return urlAcceso;
    }

    public void setUrlAcceso(String urlAcceso) {
        this.urlAcceso = urlAcceso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
