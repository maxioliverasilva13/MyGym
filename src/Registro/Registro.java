/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registro;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import Socio.Socio;
import Clase.Clase;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
public class Registro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float costo;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    @JoinColumn
    private Socio socio;
    @ManyToOne
    @JoinColumn
    private Clase clase;

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public DtRegistro getDtRegistro() {
        DtRegistro dtToReturn = new DtRegistro(
          id, costo, fecha, (socio != null) ? socio.getNombre() : null,
          (clase != null) ? clase.getNombre() : null
        );
        return dtToReturn;
    }
    

}