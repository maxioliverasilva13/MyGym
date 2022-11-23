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
import Clase.DtClase;
import PuntuacionProfesor.PuntuacionProfesor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mygym.logica.usuario.dataTypes.DtPuntuacionProfesor;

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
    private int cantClases;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    @JoinColumn
    private Socio socio;
    @ManyToOne
    @JoinColumn
    private Clase clase;
    
    @OneToOne(mappedBy = "registro")
    private PuntuacionProfesor puntuacionProfesor;

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
        List<DtRegistro> regsOfClass = new ArrayList<>();
        
        this.clase.getRegistros().forEach((Registro r) -> {
            regsOfClass.add(new DtRegistro(r.getId(), r.getCosto(), r.getFecha(), "", ""));
        });
        File file = null;
        if (this.clase.getImage() != null) {
            file = this.clase.createTempFile();
        }
        String profesorName = this.clase.getActividad().getProfesor().getNombre();
        String profesorSurname = this.clase.getActividad().getProfesor().getApellido();
        DtClase clase = new DtClase(
         this.clase.getId(), this.clase.getNombre(), this.clase.getFecha(),profesorName + " " + profesorSurname , null, this.clase.getCapMinima(), this.clase.getCapMaxima(), this.clase.getUrlAcceso(), this.clase.getFechaRegistro(), regsOfClass, this.clase.getActividad().getId(), this.clase.getActividad().getNombre(), null, file, null);
        DtPuntuacionProfesor puntuacionProf = null;
        if(this.puntuacionProfesor != null){
        
         puntuacionProf = this.puntuacionProfesor.getDt();   
        }
        
        DtRegistro dtToReturn = new DtRegistro(
          id, costo, fecha, (socio != null) ? socio.getNombre() : null,
          (clase != null) ? clase.getNombre() : null, clase, (puntuacionProf != null) ? puntuacionProf : null
        );
        return dtToReturn;
    }
    
    public PuntuacionProfesor getPuntuacionProfesor() {
       return this.puntuacionProfesor;
    }
    
    

}
