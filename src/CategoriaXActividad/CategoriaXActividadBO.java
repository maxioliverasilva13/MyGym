/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CategoriaXActividad;

/**
 *
 * @author mandi
 */
public class CategoriaXActividadBO implements ICategoriaXActividadBO {
    CategoriaXActividadDao catXactDao = new CategoriaXActividadDao();
    
    @Override
    public void agregarCupXAct(int idCategoria, int idActividad, DtCategoriaXActividad catXact){
        catXactDao.insertar(idCategoria, idActividad, catXact);
    }
    
    @Override
    public DtCategoriaXActividad getById(int idCatXact){
        catXactDao.getById(idCatXact);
        CategoriaXActividadDao catXactDao = new CategoriaXActividadDao();
        
        CategoriaXActividad catXact = catXactDao.getById(idCatXact);
        
        DtCategoriaXActividad res = new DtCategoriaXActividad(
                catXact.getId(), catXact.getCategoria().getDtCategoria(), catXact.getActividad().getDtActividad()
        );
        return res;
    }
}
