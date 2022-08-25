/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygym.logica.usuario.dataTypes;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author mandi
 */
public class DtCuponeraDetalle {
    private String nombre;
    private String descripcion;
    private Date periodoDeVigencia;
    private float descuento;
    private HashMap actividades;
    
    
    public DtCuponeraDetalle(String nombre, String descripcion, Date periodoDeVigencia, float descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.periodoDeVigencia = periodoDeVigencia;
        this.descuento = descuento;
    }    
    
    
    
    
    
}
