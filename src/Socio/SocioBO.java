/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio;

import Clase.Clase;
import Clase.ClaseDao;
import Clase.DtClase;
import Clase.InterfaceClaseDao;
import Exceptions.RegistroNotFoundException;
import Exceptions.SocioAlreadyAreInClass;
import Profesor.Profesor;
import PuntuacionProfesor.PuntuacionProfesor;
import Registro.DtRegistro;
import Registro.InterfaceRegistroBO;
import Registro.InterfaceRegistroDao;
import Registro.Registro;
import Registro.RegistroBO;
import Registro.RegistroDao;
import Socio.dtos.SocioDTO;
import Socio.dtos.SocioEditDTO;
import Socio.exceptions.SocioNotExist;
import Usuario.dtos.UsuarioDTO;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author angel
 */
public class SocioBO implements ISocioBO {
    public SocioBO(){
        
    }
  
    @Override
    public void editar(int id, SocioEditDTO socioEdit) {
        ISocioDAO socioDao = new SocioDAO();
        socioDao.editar(id, socioEdit);
    }

 

    @Override
    public void agregarRegistro(Registro newRegistro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HashMap<Integer, SocioDTO> listar() {
        HashMap<Integer,SocioDTO> socios = new HashMap<Integer,SocioDTO>();
        ISocioDAO socioDao = new SocioDAO();
        socioDao.listar().forEach((item) -> {
            socios.put(item.getId(), new SocioDTO(
               item.getId(),
               item.getNombre(),
               item.getApellido(),
               item.getNickname(),
               item.getEmail(),
               item.getNacimiento(),
               null,
               item.createTempFile(),
               item.getSeguidosDt(),
               item.getSeguidoresDT(),
               item.getImage()
            ));
        });
        return socios;
    }

    @Override
    public SocioDTO consultarSocio(int id) throws SocioNotExist {
        ISocioDAO socioDao = new SocioDAO();
        Socio socioFind = socioDao.getById(id);
        SocioDTO res;
        if(socioFind  == null){
            throw new SocioNotExist("El socio no existe");
        }
        List<DtRegistro> registros = new ArrayList();
        
        socioFind.getRegistros().forEach((registro) ->{
            registros.add(registro.getDtRegistro());
        });
        
        if (socioFind.getImage() != null) {
            res = new SocioDTO(socioFind.getId(), socioFind.getNombre(),socioFind.getApellido(),socioFind.getNickname(),socioFind.getEmail(),socioFind.getNacimiento(),registros, socioFind.createTempFile(), socioFind.getSeguidosDt(), socioFind.getSeguidoresDT(), socioFind.getImage());        
            return res;
        } else {
            res = new SocioDTO(socioFind.getId(), socioFind.getNombre(),socioFind.getApellido(),socioFind.getNickname(),socioFind.getEmail(),socioFind.getNacimiento(),registros, null, socioFind.getSeguidosDt(), socioFind.getSeguidoresDT(), socioFind.getImage());        
            return res;
        }
        
        
        
    }

    @Override
    public void puntuarProfesorEnClase(int claseId,int socioId, int puntuacion) throws Exception {
        
         ISocioDAO socioDao = new SocioDAO();
         Socio socioFind = socioDao.getById(socioId);
         if(socioFind == null){
             throw new SocioNotExist("El socio no existe");
         }
         InterfaceClaseDao claseDao = new ClaseDao();
         Clase claseFind = claseDao.consultarClase(claseId);
         if(claseFind == null){
              throw new Exceptions.ClaseNotFoundException("No existe esta clase");
         }
         Date today = new Date();
         if(today.compareTo(claseFind.getFecha()) <= 0){
              throw new Exception("La clase aun no se ha dictado por lo tanto no puedes puntuar al profesor");
         }
        
         InterfaceRegistroDao registroDao = new RegistroDao();
         Registro registroFind = registroDao.getByClaseAndSocio(socioFind, claseFind);
         if(registroFind == null){
             throw new RegistroNotFoundException("El socio no esta registrado a la clase ");
         }
         
         PuntuacionProfesor puntuacionProf = registroFind.getPuntuacionProfesor();
         if(registroFind.getPuntuacionProfesor() != null){
             puntuacionProf.setPuntuacion(puntuacion);
         }else{
             InterfaceRegistroBO registroBo = new RegistroBO();
             registroBo.addPuntuacionToProfesor(registroFind, puntuacion);
         }
         
         
    }

  
   
}
