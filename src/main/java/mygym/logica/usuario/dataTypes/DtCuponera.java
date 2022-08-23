/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mygym.logica.usuario.dataTypes;

import java.util.Date;

/**
 *
 * @author mandi
 */
public class DtCuponera {
    private String nombre;
    private String descripcion;
    private Date periodoDeVigencia; // Cambiar a DtPeriodo.
    private String descuento;

    public DtCuponera(String nombre, String descripcion, Date periodoDeVigencia, String descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.periodoDeVigencia = periodoDeVigencia;
        this.descuento = descuento;
    }

    public DtCuponera() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getPeriodoDeVigencia() {
        return periodoDeVigencia;
    }

    public String getDescuento() {
        return descuento;
    }
}
