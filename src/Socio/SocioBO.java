/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio;

import Clase.DtClase;
import Profesor.Profesor;
import Registro.DtRegistro;
import Registro.Registro;
import Socio.dtos.SocioDTO;
import Socio.dtos.SocioEditDTO;
import Socio.exceptions.SocioNotExist;
import Usuario.dtos.UsuarioDTO;

import java.util.ArrayList;
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

  
   
}
