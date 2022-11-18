/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Premio;

import Premio.InterfacePremioDao;
import Socio.dtos.SocioDTO;
import java.util.List;
import Premio.dtos.PremioDTO;

/**
 *
 * @author maximilianoolivera
 */
public class PremioBO implements InterfacePremioBo {

    InterfacePremioDao premioDao = new PremioDao();

    @Override
    public void insertarPremio(int idClase, String nombre, int cantidadSorteado) {
        premioDao.insertarPremio(idClase, nombre, cantidadSorteado);
    }
    
    @Override
    public List<PremioDTO> premiosOfUser(int idSocio) {
        return premioDao.premiosOfUser(idSocio);
    }
    
    @Override
    public List<SocioDTO> realizarSorteo(int idPremio) {
        return premioDao.realizarSorteo(idPremio);
    }

}
