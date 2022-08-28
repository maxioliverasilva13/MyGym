/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuario;

import Usuario.dtos.UsuarioCreateDTO;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;

/**
 *
 * @author angel
 */
public interface IUsuarioBO {
    public void create(UsuarioCreateDTO userCreate)  throws UserAlreadyEmailExist,UserAlreadyNickExist;
}
