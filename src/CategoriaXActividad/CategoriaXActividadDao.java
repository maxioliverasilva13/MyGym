/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriaXActividad;

import Actividad.Actividad;
import Actividad.ActividadDao;
import Categoria.Categoria;
import EntityManajer.InterfaceEntityManager;
import Exceptions.CategoriaNotFoundException;
import Exceptions.CategoriaXActividadAlreadyExists;
import Exceptions.CategoriaXActividadNotFound;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author mandi
 */
public class CategoriaXActividadDao implements ICategoriaXActividadDao {
    
        EntityManager em = InterfaceEntityManager.getInstance();
        ActividadDao actDao = new ActividadDao();
        
        
        @Override
        public void insertar(int idCategoria, int idActividad, DtCategoriaXActividad catXact){
        // EXISTE CATEGORIA
        Categoria cat = em.find(Categoria.class, idCategoria);
        if (cat == null) {
            throw new CategoriaNotFoundException("Categoria no encontrada");
        }
        List<CategoriaXActividad> exists = em.createNativeQuery(
                "SELECT * FROM categoriaxactividad where CATEGORIA_ID=" + idCategoria + " AND ACTIVIDAD_ID=" + idActividad
        ).getResultList();
        if (exists.size() > 0) {
            throw new CategoriaXActividadAlreadyExists("Esta actividad ya tiene esta categoria asignada. (IDCategoria: " + idCategoria  + ", IDActividad: "+ idActividad +")");
        }
        Actividad act = actDao.getById(idActividad);
        CategoriaXActividad catxact = new CategoriaXActividad();
        catxact.setCategoria(cat);
        catxact.setActividad(act);
        EntityTransaction trn = em.getTransaction();
        trn.begin();
        em.persist(catxact);
        trn.commit();
        actDao.agregarCategoriaXActividad(idCategoria, catxact);
        }
        
        @Override
        public CategoriaXActividad getById(int idCatXAct) {
            CategoriaXActividad catxact = em.find(CategoriaXActividad.class, idCatXAct);
            if (catxact == null){
                throw new CategoriaXActividadNotFound("Categoria X Actividad no encontrada");
            }
            return catxact;
        }






}
