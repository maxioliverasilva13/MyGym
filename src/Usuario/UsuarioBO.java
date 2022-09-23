package Usuario;

import Profesor.dtos.ProfesorCreateDTO;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;
import Usuario.exceptions.UserNotExist;
import java.util.HashMap;
import java.util.List;
import javax.persistence.NoResultException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angel
 */
public class UsuarioBO implements IUsuarioBO {
    UsuarioDAO userDao = new UsuarioDAO();

    @Override
    public void create(UsuarioCreateDTO userCreate) throws UserAlreadyEmailExist,UserAlreadyNickExist {
        if(userDao.getByNickname(userCreate.getNickname()) != null){
              throw new UserAlreadyNickExist("ya existe un usuario con este nickname");
        }
        if(userDao.getByEmail(userCreate.getEmail()) != null){
              throw new UserAlreadyEmailExist("ya existe un usuario con este email");
        }
        userDao.create(userCreate);
    }

    @Override
    public HashMap<Integer, UsuarioDTO> listarUsuarios() {
         HashMap<Integer,UsuarioDTO> res = new HashMap<Integer,UsuarioDTO>();
         List<Usuario> userList = userDao.listar();
         userList.forEach((user) -> {
             res.put(user.getId(), new UsuarioDTO(user.getId(),user.getNombre(),user.getApellido(),user.getNickname(),user.getEmail(), user.getNacimiento(), user.createTempFile()));
         });
         return res;
    }

    @Override
    public String getTipoById(int id) {
         if(userDao.getById(id) == null){
             throw new UserNotExist("Usuario no existe");
         }
        
         return userDao.getTipoById(id);
         
    }
    
     @Override
     public void seguirAUsuario(int myId, int idUsuario){
         userDao.seguirAUsuario(myId, idUsuario);
         
     }
     
     @Override
     public void dejarSeguirUsuario(int myId, int idUsuario){
         userDao.dejarSeguirUsuario(myId, idUsuario);
     }
 
    
    
    
}
