package Usuario;

import Profesor.dtos.ProfesorCreateDTO;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;
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

    @Override
    public void create(UsuarioCreateDTO userCreate) throws UserAlreadyEmailExist,UserAlreadyNickExist {
        UsuarioDAO userDao = new UsuarioDAO();
        if(userDao.getByNickname(userCreate.getNickname()) != null){
              throw new UserAlreadyNickExist("ya existe un usuario con este nickname");
        }
        if(userDao.getByEmail(userCreate.getEmail()) != null){
              throw new UserAlreadyEmailExist("ya existe un usuario con este nickname");
        }
        userDao.create(userCreate);
        
    }
    
}
