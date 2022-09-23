/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Categoria;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mandi
 */
public class CategoriaBO implements ICategoriaBO {
    CategoriaDao catDao = new CategoriaDao();

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
    
}
