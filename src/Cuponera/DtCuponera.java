package Cuponera;


import CuponeraXActividad.DtCuponeraXActividad;
import java.io.File;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maximilianooliverasilva
 */
public class DtCuponera {
    private int id;
    private String nombre;
    private String descripcion;
    private Date periodoVigencia;
    private int descuento;
    private List<DtCuponeraXActividad> cuponerasXActividad;
    private File image;

    public DtCuponera(int id, String nombre, String descripcion, Date periodoVigencia, int descuento, List<DtCuponeraXActividad> cupsXActs) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.periodoVigencia = periodoVigencia;
        this.descuento = descuento;
        this.cuponerasXActividad = cupsXActs;
    }
    
    public DtCuponera(int id, String nombre, String descripcion, Date periodoVigencia, int descuento, List<DtCuponeraXActividad> cupsXActs, File file) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.periodoVigencia = periodoVigencia;
        this.descuento = descuento;
        this.cuponerasXActividad = cupsXActs;
        this.image = file;
    }

    public File getImage() {
        return image;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getPeriodoVigencia() {
        return periodoVigencia;
    }

    public int getDescuento() {
        return descuento;
    }

    public List<DtCuponeraXActividad> getCuponerasXActividad() {
        return cuponerasXActividad;
    }
    
    
}
