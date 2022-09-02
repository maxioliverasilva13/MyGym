/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socio;

import Profesor.Profesor;
import Registro.DtRegistro;
import Registro.Registro;
import Socio.dtos.SocioDTO;
import Socio.dtos.SocioEditDTO;
import Socio.exceptions.SocioNotExist;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
               null
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
        
        res = new SocioDTO(socioFind.getId(), socioFind.getNombre(),socioFind.getApellido(),socioFind.getNickname(),socioFind.getEmail(),socioFind.getNacimiento(),registros);        
        return res;
        
    }

  
   
}
