/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuponeraXActividad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import Actividad.Actividad;
import Cuponera.Cuponera;
/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
public class CuponeraXActividad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int cantClases;
    @ManyToOne
    @JoinColumn
    private Actividad actividad;
    @ManyToOne
    @JoinColumn
    private Cuponera cuponera;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantClases() {
        return cantClases;
    }

    public void setCantClases(int cantClases) {
        this.cantClases = cantClases;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Cuponera getCuponera() {
        return cuponera;
    }

    public void setCuponera(Cuponera cuponera) {
        this.cuponera = cuponera;
    }
    
    public DtCuponeraXActividad getDtCuponeraXActividad() {
        return new DtCuponeraXActividad(id, cantClases, (cuponera != null) ? cuponera.getDtCuponera() : null);
    }
    
    
}
