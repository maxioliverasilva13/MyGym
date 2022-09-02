/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuario;

import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;
import Usuario.exceptions.UserNotExist;
import java.util.HashMap;

/**
 *
 * @author angel
 */
public interface IUsuarioBO {
    public void create(UsuarioCreateDTO userCreate)  throws UserAlreadyEmailExist,UserAlreadyNickExist;
    public HashMap<Integer,UsuarioDTO> listarUsuarios();
    public String getTipoById(int id) throws UserNotExist;
}
