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
     public Usuario getById(int id);
     public String getTipoById(int id);
     public void seguirAUsuario(int myId, int idUsuario);
     public void dejarSeguirUsuario(int myId, int idUsuario);
     public int getSeguidos(int idUsuario);
     public int getSeguidores(int idUsuario);
}
