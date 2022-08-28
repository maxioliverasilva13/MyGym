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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import Registro.DtRegistro;

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
    @Basic
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private int capMinima;
    private int capMaxima;
    private String urlAcceso;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @ManyToOne
    @JoinColumn()
    private Actividad actividad;
    @OneToMany(mappedBy = "clase")
    private List<Registro> registros;
    
    public int getId() {
        return id;
    }
    
    public void setActividad(Actividad act) {
        this.actividad = act;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void addRegistro(Registro registr) {
        this.registros.add(registr);
    }
    
    public Actividad getActividad() {
        return actividad;
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
    
    public DtClase getDtClase() {
        List<DtRegistro> registrosClase = new ArrayList<DtRegistro>();
        this.getRegistros().forEach((registro) -> {
            registrosClase.add(registro.getDtRegistro());
        });
        DtClase classParsed = new DtClase(id,nombre, fecha, (actividad != null)
        ? this.actividad.getProfesor().getNombre(): null, (actividad != null)
        ? this.actividad.getProfesor().getId() : null, capMinima, capMaxima, urlAcceso, fechaRegistro, 
         registrosClase, (actividad != null)
        ? this.actividad.getId(): null, (actividad != null)
        ? this.actividad.getNombre(): null
       );
        return classParsed;
    }
    
    
}
