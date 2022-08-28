/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Socio;

import Registro.Registro;
import Socio.dtos.SocioCreateDTO;
import Socio.dtos.SocioDTO;
import Socio.dtos.SocioEditDTO;
import Socio.exceptions.SocioNotExist;
import java.util.HashMap;

/**
 *
 * @author angel
 */
public interface ISocioBO {
    public HashMap<Integer,SocioDTO> listar();
    public void editar(int id, SocioEditDTO socioEdit);
    public SocioDTO consultarSocio(int id) throws SocioNotExist;
    public void agregarRegistro(Registro newRegistro);
}
