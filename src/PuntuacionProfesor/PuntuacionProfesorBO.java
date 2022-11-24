/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuntuacionProfesor;

import Exceptions.RegistroNotFoundException;
import Exceptions.SocioNotFoundException;
import Registro.InterfaceRegistroDao;
import Registro.Registro;
import Registro.RegistroDao;
import Socio.ISocioDAO;
import Socio.Socio;
import Socio.SocioDAO;
import java.util.Date;
import mygym.logica.usuario.dataTypes.DtPuntuacionProfesor;

/**
 *
 * @author rodrigo
 */
public class PuntuacionProfesorBO implements IPuntuacionProfesorBO  {

    @Override
    public DtPuntuacionProfesor create(int puntuacion, int socioId, int registroId) throws SocioNotFoundException,RegistroNotFoundException,Exception {
       ISocioDAO socioDao = new SocioDAO();
       Socio socioFind = socioDao.getById(socioId);
       if(socioFind == null){
           throw new SocioNotFoundException("No se encontro un socio");
       }
       
       InterfaceRegistroDao registroDao = new RegistroDao();
       Registro registroFind = registroDao.existe(registroId);
       
       if(registroFind == null){
           throw new RegistroNotFoundException("El socio nunca se registro a esta clase");
       }
       
       Date today = new Date();
       if(today.compareTo(registroFind.getClase().getFecha()) <= 0){
           throw new Exception("No puedes dar una puntuacion si todavia no se ha dictado la clase");
       }
      
       IPuntuacionProfesorDAO puntProfDao = new PuntuacionProfesorDAO();
       if(puntProfDao.existeByRegistro(registroFind)){
           throw new Exception("El profesor ya ha sido puntuado por el socio");
       }
       PuntuacionProfesor res = puntProfDao.create(registroFind, puntuacion);
       return res.getDt();
    }
    
}
