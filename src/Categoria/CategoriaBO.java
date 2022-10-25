/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categoria;

import EntityManajer.InterfaceEntityManager;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mandi
 */
public class CategoriaBO implements ICategoriaBO {
    CategoriaDao catDao = new CategoriaDao();
    
            
    public CategoriaBO() {
        // this is for the frontend servelets because by default the entity manager is not instanced
        InterfaceEntityManager.getInstance();
    }

    public void agregarCategoria(DtCategoria cat){
        catDao.create(cat);
    }
    
    public DtCategoria getCategoriaById(int idCategoria){
        Categoria cat = catDao.existe(idCategoria);
        if (cat != null) {
            return cat.getDtCategoria();
        }
        return null;
    }
    
    public HashMap<Integer, DtCategoria> listarCategorias(){
        List<Categoria> categorias = catDao.listarCategorias();
        HashMap<Integer, DtCategoria> dtcategorias = new HashMap<>();
        
        categorias.forEach((cat) -> {
            dtcategorias.put(cat.getId(), cat.getDtCategoria());
        });
        
        return dtcategorias;
    }
    
    
    public int totalActividades(int idCategoria) {
        return catDao.getCantidadActividadesDeCategoria(idCategoria);
    }
    
}
