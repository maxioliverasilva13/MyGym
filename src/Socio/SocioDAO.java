/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio;

import EntityManajer.InterfaceEntityManager;
import Exceptions.RegistroNotFoundException;
import Exceptions.SocioNotFoundException;
import Profesor.Profesor;
import Registro.RegistroDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import Registro.Registro;
import Socio.dtos.SocioEditDTO;
import Socio.exceptions.SocioNotExist;
import Usuario.UsuarioDAO;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;
import ParseDate.ParseDate;
import utils.EncryptPass;
/**
 *
 * @author angel
 */
public class SocioDAO implements ISocioDAO {

    ParseDate p = new ParseDate();
    EntityManager em = null;
    UsuarioDAO userDao = new UsuarioDAO();

    public SocioDAO() {
        this.em = InterfaceEntityManager.getInstance();

    }

    public List<Socio> listar() {
        List<Socio> res;
        Query query = this.em.createNativeQuery("SELECT * FROM socio JOIN usuario ON socio.userId = usuario.id", Socio.class);
        res = query.getResultList();
        return res;
    }

    @Override
    public Socio getById(int id) {
        EntityTransaction tx = this.em.getTransaction();
        try {
            tx.begin();
            Socio find = (Socio) this.em.find(Socio.class, id);
            tx.commit();
            return find;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void editar(int idSocio, SocioEditDTO socio) {        
        
        Socio soc = this.getById(idSocio);
        if (soc == null) {
            throw new SocioNotExist("El socio no existe");
        }
        if(!socio.getNickname().equals(soc.getNickname()) && userDao.getByNickname(socio.getNickname()) != null){
              throw new UserAlreadyNickExist("ya existe un usuario con este nickname");
        }
        if(!socio.getEmail().equals(soc.getEmail()) && userDao.getByEmail(socio.getEmail()) != null){
              throw new UserAlreadyEmailExist("ya existe un usuario con este email");
        }

        EncryptPass ep = new EncryptPass();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        System.out.println(socio.getNickname());
        soc.setApellido(socio.getApellido());
        soc.setEmail(socio.getEmail());
        soc.setNacimiento(socio.getNacimiento());
        soc.setNombre(socio.getNombre());
        soc.setNickname(soc.getNickname());
                    System.out.println("casi ALOHA");
        if (socio.getPasswordChar() != null){
            System.out.println("ACAAAA ALOHA");
            String encryptedPassword = ep.encryptPass(new String(socio.getPasswordChar()));
            soc.setPassword(encryptedPassword);
        }
        soc.setImage(socio.getImage());
        tr.commit();
    }

    @Override
    public void agregarRegistro(int idSocio, int idRegistro) {
        try {
            Socio soc = em.find(Socio.class, idSocio);
            if (soc == null) {
                throw new SocioNotFoundException("El socio no existe");
            }
            Registro reg = em.find(Registro.class, idRegistro);
            if (reg == null) {
                throw new RegistroNotFoundException("Registro no encontrado");
            }
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            soc.addRegistro(reg);
            tr.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
