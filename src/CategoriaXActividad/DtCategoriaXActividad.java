/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriaXActividad;

import Actividad.dtos.ActividadDTO;
import Categoria.DtCategoria;

/**
 *
 * @author mandi
 */
public class DtCategoriaXActividad {
    private int id;
    private DtCategoria categoria;
    private ActividadDTO actividad;

    
    public DtCategoriaXActividad(int id, DtCategoria categoria, ActividadDTO actividad) {
        this.id = id;
        this.categoria = categoria;
        this.actividad = actividad;
    }
       
    public int getId() {
        return id;
    }

    public DtCategoria getCategoria() {
        return categoria;
    }

    public ActividadDTO getActividad() {
        return actividad;
    }
    
}
