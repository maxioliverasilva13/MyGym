/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuario;

import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IUsuarioDAO {
     public void  create(UsuarioCreateDTO userCreate);
     public List<Usuario> listar();
     public Usuario getByNickname(String nickname);
     public Usuario getByEmail(String email);
   
}
