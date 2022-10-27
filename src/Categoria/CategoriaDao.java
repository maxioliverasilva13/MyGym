/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categoria;

import EntityManajer.InterfaceEntityManager;
import Exceptions.CategoriaAlreadyExists;
import Exceptions.CategoriaNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author mandi
 */
public class CategoriaDao implements ICategoriaDao {
    EntityManager em = InterfaceEntityManager.getInstance();

    public CategoriaDao(){
       
    } 

    public void create(DtCategoria cat){
        List<Categoria> existe = em.createNativeQuery("select * from CATEGORIA where NOMBRE='" + cat.getNombre() +"'").getResultList();
        if (existe.size() > 0) {
            throw new CategoriaAlreadyExists("Ya existe una categoría con ese nombre, por favor elija otro.");
        }else{
            Categoria categoria = new Categoria();
            categoria.setId(cat.getId());
            categoria.setNombre(cat.getNombre());

            EntityTransaction tr = em.getTransaction();
            tr.begin();
            em.persist(categoria);
            tr.commit();
        }
    }
    
    public Categoria existe(int id){
        Categoria cat = em.find(Categoria.class, id);
        if (cat == null) {
            throw new CategoriaNotFoundException("La categoria no existe.");
        }
        return cat;
    }
    
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = em.createNativeQuery("select * from categoria", Categoria.class)
        .getResultList();
        return categorias;
    }
    
    public int getCantidadActividadesDeCategoria(int idCategoria) {
        List<Categoria> categorias = em.createNativeQuery("SELECT * FROM actividad_categoria ac WHERE categorias_ID= "+ idCategoria +" AND NOT EXISTS (SELECT * FROM actividad WHERE actividad.ID = ac.Actividad_ID AND (actividad.ESTADO = 'Ingresada' OR actividad.ESTADO = 'Rechazada'));").getResultList();
        return categorias.size();
    }
    
    
}
