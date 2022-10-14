/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categoria;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mandi
 */
@Entity
@Table()
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DtCategoria getDtCategoria() {
        CategoriaBO catBO = new CategoriaBO();
        if (this.id != 0) {
            int cantidadActividades = catBO.totalActividades(this.id);
            DtCategoria resultDT = new DtCategoria(
                    this.id, this.nombre,
                    cantidadActividades
            );
            return resultDT;
        } else {
            DtCategoria resultDT = new DtCategoria(
                    this.id, this.nombre
            );
            return resultDT;
        }

    }

}
