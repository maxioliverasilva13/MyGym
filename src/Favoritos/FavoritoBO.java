/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Favoritos;

/**
 *
 * @author maximilianoolivera
 */
public class FavoritoBO implements InterfaceFavoritoBO {
    FavoritoDAO favDao = new FavoritoDAO();

    @Override
    public boolean toggleFavoritoActividad(int idActividad, int idSocio) {
        return favDao.toggleFavoritoActividad(idActividad, idSocio);
    }

}
