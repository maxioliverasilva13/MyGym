/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categoria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author mandi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategoria {
    private int id;
    private String nombre;
    int totalActividades;

    public DtCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public DtCategoria(int id, String nombre, int totalActividades) {
        this.id = id;
        this.nombre = nombre;
        this.totalActividades = totalActividades;
    }

    public DtCategoria(String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTotalActividades() {
        return totalActividades;
    }

}
