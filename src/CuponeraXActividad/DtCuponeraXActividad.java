package CuponeraXActividad;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Cuponera.DtCuponera;

/**
 *
 * @author maximilianooliverasilva
 */
public class DtCuponeraXActividad {
    private int id;
    private int cantClases;
    // private DtActividad actividad;
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
    
    

    public DtCuponeraXActividad(int id, int cantClases, DtCuponera cuponera) {
        this.id = id;
        this.cantClases = cantClases;
        this.cuponera = cuponera;
    }
    
    public DtCuponeraXActividad(int cantClases) {
        this.cantClases = cantClases;
    }
    
}
