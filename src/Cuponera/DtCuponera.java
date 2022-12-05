package Cuponera;


import CuponeraXActividad.DtCuponeraXActividad;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maximilianooliverasilva
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtCuponera {
    private int id;
    private String nombre;
    private String descripcion;
    private Date periodoVigencia;
    private int descuento;
    private List<DtCuponeraXActividad> cuponerasXActividad;
    private File image;
    private float precio;
    private byte[] blobImage;
  
    public DtCuponera(int id, String nombre, String descripcion, Date periodoVigencia, int descuento,float precio, List<DtCuponeraXActividad> cupsXActs, File file, byte[] blobImage) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.periodoVigencia = periodoVigencia;
        this.descuento = descuento;
        this.cuponerasXActividad = cupsXActs;
        this.image = file;
        this.precio = precio;
        this.blobImage = blobImage;
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
    
    public float getPrecio(){
        return this.precio;
    }
    
    public byte[] getBlobImage(){
        return this.blobImage;
    }
    
}
