/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuario;

import Usuario.dtos.UsuarioCreateDTO;

/**
 *
 * @author angel
 */
public interface IUsuarioDAO {
     public void  create(UsuarioCreateDTO userCreate);
     public Usuario getByNickname(String nickname);
     public Usuario getByEmail(String email);
}
