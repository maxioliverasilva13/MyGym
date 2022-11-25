/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Favoritos;

import Premio.dtos.PremioDTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import Registro.Registro;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Cacheable;
import Clase.Clase;
import javax.persistence.ManyToMany;
import Actividad.Actividad;
import Socio.Socio;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
@Cacheable(false)
public class Favorito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn()
    private Actividad actividadFav;
    @ManyToOne
    @JoinColumn()
    private Socio socioFav;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Actividad getActividad() {
        return actividadFav;
    }

    public void setActividad(Actividad actividad) {
        this.actividadFav = actividad;
    }

    public Socio getSocioFav() {
        return socioFav;
    }

    public void setSocioFav(Socio socioFav) {
        this.socioFav = socioFav;
    }

    public FavoritoDTO getFavoritoDTO() {
        return new FavoritoDTO(this.socioFav.getId(), this.actividadFav.getId(), this.id);
    }
    
}
