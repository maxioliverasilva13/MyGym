/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuario;

import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import Usuario.exceptions.UnauthorizedException;
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
    public String getTipoById(int id);
    public void seguirAUsuario(int myId, int idUsuario);
    public void dejarSeguirUsuario(int myId, int idUsuario);
    public UsuarioDTO authenticarse(String email,String password) throws UnauthorizedException;
    public boolean consultarSigueUsuario(int myId, int idUsuario);
    public UsuarioDTO getByEmail(String userOrNickname);
    public UsuarioDTO getByNickname(String nickname);
}
