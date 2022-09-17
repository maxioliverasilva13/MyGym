/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Categoria;

import java.util.List;

/**
 *
 * @author mandi
 */
public interface ICategoriaDao {
    public void create(DtCategoria cat);
    public Categoria existe(int id);
    public List<Categoria> listarCategorias();
}
