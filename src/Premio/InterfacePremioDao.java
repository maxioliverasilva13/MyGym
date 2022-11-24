/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Premio;
import Clase.Clase;
import Premio.dtos.PremioDTO;
import Socio.dtos.SocioDTO;
import java.io.File;
import java.util.List;
/**
 *
 * @author maximilianoolivera
 */
public interface InterfacePremioDao {
    public void insertarPremio(int idClase, String nombre, int cantidadSorteado);
    public List<SocioDTO> realizarSorteo(int idPremio);
    public List<PremioDTO> premiosOfUser(int idSocio);
    public File imprimirPremio(int idPremio, int idSocio);
}
