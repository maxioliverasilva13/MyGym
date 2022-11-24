/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor;

import Actividad.Actividad;
import Actividad.dtos.ActividadDTO;
import Clase.Clase;
import Clase.ClaseDao;
import Clase.InterfaceClaseDao;
import Exceptions.ClaseNotFoundException;
import Exceptions.ProfesorNoDictaClaseException;
import Exceptions.ProfesorNoDictaClaseException;
import Institucion.DtInstitucion;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import Profesor.exceptions.ProfesorNotExist;
import PuntuacionProfesor.IPuntuacionProfesorDAO;
import PuntuacionProfesor.PuntuacionProfesor;
import PuntuacionProfesor.PuntuacionProfesorDAO;
import Socio.ISocioDAO;
import Socio.Socio;
import Socio.SocioDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mygym.logica.usuario.dataTypes.DtPuntuacionProfesor;
import mygym.logica.usuario.dataTypes.ProfesorPuntuacionesDTO;
import utils.ParserClassesToDt;

/**
 *
 * @author angel
 */
public class ProfesorBO implements IProfesorBO {
    ProfesorDao profDao = new ProfesorDao();

    @Override
    public ProfesorDTO getProfesorById(int id) throws ProfesorNotExist  {
         IProfesorDao profDao = new ProfesorDao();
         Profesor profFind = profDao.getById(id);
         ProfesorDTO res;
         if(profFind == null){
             throw new ProfesorNotExist("El profesor no existe");
         }
         res = profFind.getDtProfesor();
         return res;
    }

  
    @Override
    public boolean existeById(int id) {
        if(profDao.getById(id) != null){
            return true;
        } 
        return false;
    }

    @Override
    public void editProfesorById(int id, ProfesorEditDTO profEdit) {
        profDao.editById(id, profEdit);
    }

    @Override
    public void agregarActividad(Actividad act) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public HashMap<Integer, ProfesorDTO> listarProfesores(){
        ProfesorDao profDao = new ProfesorDao();
        List<Profesor> profes = profDao.listarProfesores();
        HashMap<Integer, ProfesorDTO> profesDTO = new HashMap<>();
        profes.forEach((prof) -> {
            profesDTO.put(prof.getId(), prof.getDtProfesor());
        });
        
        return profesDTO;
    }   

    @Override
    public DtInstitucion getInstitucion(int idProf) {
        Profesor profe = profDao.getById(idProf);
        if(profe == null){
             throw new ProfesorNotExist("El profesor no existe");
        }
        return profe.getInstituciones().get(0).getDtInstitucion();
    }

    @Override
    public ProfesorPuntuacionesDTO getValoracionesGenerales(int idProf) {
       Profesor profe = profDao.getById(idProf);
       if(profe == null){
             throw new ProfesorNotExist("El profesor no existe");
       }
       
       List<PuntuacionProfesor> puntuaciones  = this.profDao.getPuntuacionesProfesor(profe);
       
       
       double cantOne = 0;
       double cantTwo = 0;
       double cantThree = 0;
       double cantFour = 0;
       double cantFive = 0;
       double cant = 0;
       
       double sumPuntuaciones = 0;
       Iterator<PuntuacionProfesor>  puntuacionsIt =   puntuaciones.iterator();
       while(puntuacionsIt.hasNext()){
           PuntuacionProfesor currentPuntuacion =  puntuacionsIt.next();
           int puntCurr = currentPuntuacion.getPuntuacion();
           switch(puntCurr){
               case 1: 
                   cantOne++;
                   break;
               case 2: 
                   cantTwo++;
                   break;
               case 3: 
                   cantThree++;
                   break;
               case 4: 
                   cantFour++;
                   break;
                case 5: 
                   cantFive++;
                   break;
           }
           sumPuntuaciones = sumPuntuaciones + puntCurr;
           cant++;
       }
       System.out.println("cant three: "  + cantThree);
       System.out.println("cant four: "  + cantFour);
       System.out.println((cantThree / cant) * 100);
       double puntuacionGeneral = sumPuntuaciones / cant; 
       double percentageOne = Math.round((cantOne/cant) * 100);
       double percentageTwo = (cantTwo / cant) * 100;
       double percentageThree = (cantThree / cant) * 100;
       double percentageFour = (cantFour / cant) * 100;
       double percentageFive = (cantFive  / cant) * 100;
       
      
       
       ProfesorPuntuacionesDTO res = new ProfesorPuntuacionesDTO(puntuacionGeneral, percentageOne,percentageTwo,percentageThree,percentageFour,percentageFive);
       return res;
    }

    @Override
    public double getValoracionByClass(int idClass) {
       
        
        InterfaceClaseDao claseDao = new ClaseDao();
        Clase claseFind = claseDao.consultarClase(idClass);
        if(claseFind == null){
            throw new ClaseNotFoundException("No existe una clase con ese id");
        }
  
         
        double promedio = 0;
        
        List<PuntuacionProfesor> res  = this.profDao.getPuntuacionesProfesorByClass(claseFind);
        int rowCant = res.size();
        double sum = 0;
       
        for(int i = 0 ; i < rowCant; i++){
           PuntuacionProfesor current  =  res.get(i);
           sum+= current.getPuntuacion();
           
        }
        
        if(rowCant == 0){
            return 0;
        }
        promedio = sum/rowCant;
        return promedio;
    }
    
    @Override
    public int getCantValoracionByClass(int idClass) {
       
        
        InterfaceClaseDao claseDao = new ClaseDao();
        Clase claseFind = claseDao.consultarClase(idClass);
        if(claseFind == null){
            throw new ClaseNotFoundException("No existe una clase con ese id");
        }
 
        List<PuntuacionProfesor> res  = this.profDao.getPuntuacionesProfesorByClass(claseFind);
        int rowCant = res.size();
        return rowCant;
    }

    
    

   
    
    
  
}
