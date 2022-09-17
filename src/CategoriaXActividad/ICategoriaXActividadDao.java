/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CategoriaXActividad;

/**
 *
 * @author mandi
 */
public interface ICategoriaXActividadDao {
    public void insertar(int idCategoria, int idActividad, DtCategoriaXActividad catXact);
    public CategoriaXActividad getById(int idCatXAct);
}
