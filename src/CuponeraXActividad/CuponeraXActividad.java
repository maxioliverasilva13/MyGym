/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuponeraXActividad;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import Actividad.Actividad;
import Actividad.dtos.ActividadDTO;
import Categoria.DtCategoria;
import Clase.DtClase;
import Cuponera.Cuponera;
import Cuponera.DtCuponera;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        if (cuponera != null) {
            File photo = null;
            if (cuponera.getImage() != null) {
                photo = cuponera.createTempFile();
            }
            DtCuponera cup = new DtCuponera(this.cuponera.getId(), this.cuponera.getNombre(), this.cuponera.getDescripcion(), this.cuponera.getPeriodoVigencia(), this.cuponera.getDescuento(), null, photo);
            if (actividad != null){
                Collection<Clase.Clase> clases = this.actividad.getClases();
                List<DtClase> dtclases = new ArrayList<>();
                clases.forEach((clase) -> {
                    dtclases.add(clase.getDtClase());
                });
                Collection <CuponeraXActividad> cuxas = this.actividad.getCuponerasXActividad();
                List<DtCuponeraXActividad> dtCUXAS = new ArrayList<>();
                
                cuxas.forEach((cuxa) -> {
                    dtCUXAS.add(new DtCuponeraXActividad(id, cantClases, cup));
                });
                
                Collection<Categoria.Categoria> categorias = this.actividad.getCategorias();
                List<DtCategoria> dtcats = new ArrayList<>();
                categorias.forEach((cat) -> {
                    dtcats.add(cat.getDtCategoria());
                });
                
                ActividadDTO actividad = new ActividadDTO(
                    this.actividad.getId(), this.actividad.getNombre() , this.actividad.getDescripcion(), this.actividad.getDuracion(), this.actividad.getCosto(), this.actividad.getFechaRegistro(), this.actividad.getProfesor().getDtProfesor(),
                        dtclases, this.actividad.getInstitucion().getDtInstitucion(), dtCUXAS, null, dtcats);
                return new DtCuponeraXActividad(id, cantClases,  cup, actividad);
            }else{
                return new DtCuponeraXActividad(id, cantClases,  cup);
            }
        }
        return new DtCuponeraXActividad(id, cantClases, this.cuponera.getDtCuponera());
    }
    
}
