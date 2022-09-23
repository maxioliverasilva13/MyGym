/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categoria;

/**
 *
 * @author mandi
 */
public class DtCategoria {
    private int id;
    private String nombre;

    public DtCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}
