/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygym.logica.usuario.dataTypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author rodrigo
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtPuntuacionProfesor {
    private int id;
    private Date fecha;
    private int puntuacion;
    
    public DtPuntuacionProfesor(int id, Date fecha, int puntuacion) {
        this.id = id;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
    }
    
     public int getId() {
        return this.id;
    }
    public Date getFecha() {
        return this.fecha;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    } 
}
