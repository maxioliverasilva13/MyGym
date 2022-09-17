/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Categoria;

import java.util.HashMap;

/**
 *
 * @author mandi
 */
public interface ICategoriaBO {
    public void agregarCategoria(DtCategoria cat);
    public DtCategoria getCategoriaById(int idCategoria);
    public HashMap<Integer, DtCategoria> listarCategorias();
}
