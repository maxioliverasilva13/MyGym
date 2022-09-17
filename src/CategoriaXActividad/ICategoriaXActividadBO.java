/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CategoriaXActividad;

/**
 *
 * @author mandi
 */
public interface ICategoriaXActividadBO {
    public void agregarCupXAct(int idCategoria, int idActividad, DtCategoriaXActividad catXact);
    public DtCategoriaXActividad getById(int idCatXact);
}
