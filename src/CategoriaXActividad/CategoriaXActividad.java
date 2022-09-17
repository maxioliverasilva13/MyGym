/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriaXActividad;

import Actividad.Actividad;
import Actividad.dtos.ActividadDTO;
import Categoria.Categoria;
import Categoria.DtCategoria;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mandi
 */
@Entity
@Table()
public class CategoriaXActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn
    private Categoria categoria;
    @ManyToOne
    @JoinColumn
    private Actividad actividad;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria cat) {
        this.categoria = cat;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
    public DtCategoriaXActividad getDtCategoriaXActividad() {
        if (categoria != null){
            DtCategoria cat = new DtCategoria(this.categoria.getId(), this.categoria.getNombre());
            if (actividad != null){
                ActividadDTO act = this.actividad.getDtActividad();
                return new DtCategoriaXActividad(id, cat, act);
            }else{
                System.out.println("*** ERROR en getDtCategoriaXActividad(), actividad == NULL ***");
            }
            return new DtCategoriaXActividad(id, cat, this.actividad.getDtActividad());
        }else{
            System.out.println("*** ERROR en getDtCategoriaXActividad(), categoria == NULL ***");
        }
        // *Eliminar el return de abajo si llega algo null*
        return new DtCategoriaXActividad(id, this.categoria.getDtCategoria(), this.actividad.getDtActividad());
    }
    
}
