package CuponeraXActividad;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Actividad.dtos.ActividadDTO;
import Cuponera.DtCuponera;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author maximilianooliverasilva
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtCuponeraXActividad {
    private int id;
    private int cantClases;
    private ActividadDTO actividad;
    private DtCuponera cuponera;

    public int getId() {
        return id;
    }

    public int getCantClases() {
        return cantClases;
    }

    public DtCuponera getCuponera() {
        return cuponera;
    }

    public ActividadDTO getActividad() {
        return actividad;
    }
    

    public DtCuponeraXActividad(int id, int cantClases, DtCuponera cuponera) {
        this.id = id;
        this.cantClases = cantClases;
        this.cuponera = cuponera;
    }
    
    // Para el listado de actividades de x cuponera.
        public DtCuponeraXActividad(int id, int cantClases, DtCuponera cuponera, ActividadDTO act) {
        this.id = id;
        this.cantClases = cantClases;
        this.cuponera = cuponera;
        this.actividad = act;
    }
    
    public DtCuponeraXActividad(int cantClases) {
        this.cantClases = cantClases;
    }
    
}
