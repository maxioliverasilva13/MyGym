package Usuario;

import EntityManajer.InterfaceEntityManager;
import Profesor.dtos.ProfesorCreateDTO;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import Usuario.exceptions.UnauthorizedException;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;
import Usuario.exceptions.UserNotExist;
import java.util.HashMap;
import java.util.List;
import javax.persistence.NoResultException;
import utils.EncryptPass;

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
    
     public UsuarioBO() {
        // this is for the frontend servelets because by default the entity manager is not instanced
        InterfaceEntityManager.getInstance();
    }

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

    @Override
    public UsuarioDTO authenticarse(String email, String pass) throws UnauthorizedException{
        Usuario usu = userDao.getByEmail(email);
        if(usu == null){
           throw new UnauthorizedException("Correo o contraseña incorrecta");
        }
        EncryptPass ep = new EncryptPass();
        String passwordEncrypted = ep.encryptPass(pass);
        if(!(usu.getPassword().equals(passwordEncrypted))){
          throw new UnauthorizedException("Correo o contraseña incorrecta");
        }
        UsuarioDTO res = new UsuarioDTO(usu.getId(),usu.getNombre(),usu.getApellido(),usu.getNickname(),usu.getEmail(),usu.getNacimiento());
        return res;   
    }

  

    
    
    
    
}
