/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import Registro.DtRegistro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public class ClaseBO implements InterfaceClaseBO {
    ClaseDao claseDao = new ClaseDao();
    
    @Override
    public void insertarClase(int idActividad, DtClase clase){
        Clase cl = new Clase();
        cl.setCapMaxima(clase.getCapMaxima());
        cl.setCapMinima(clase.getCapMinima());
        cl.setFecha(clase.getFecha());
        cl.setFechaRegistro(clase.getFechaRegistro());
        cl.setNombre(clase.getNombre());
        cl.setUrlAcceso(clase.getUrlAcceso());
        if (clase.getImage() != null) {
            cl.setImage(clase.getImage());
        }
        claseDao.insertar(idActividad, cl);
    }
    
    @Override
    public HashMap<Integer, DtClase> listarClasesByAct(int idActividad){
        List<Clase> clases = claseDao.getClasesByActividad(idActividad);
        HashMap<Integer, DtClase> parsedClases = new HashMap<>();
        for (int i = 0; i < clases.size(); i++) {
             Clase clase = clases.get(i);
             DtClase classParsed = clase.getDtClase();
           int key = clase.getId();
           parsedClases.put(key, classParsed);
        }
        return parsedClases;
        // clases.forEach(action);
    }
    
    @Override
    public DtClase consultarClase(int idClase){
        Clase clase = claseDao.consultarClase(idClase);
        DtClase dtToReturn = clase.getDtClase();
        return dtToReturn;
    }
    
    @Override
    public void agregarRegistro(int idClase, int idRegistro){
        claseDao.agregarRegistro(idClase, idRegistro);
    }

}
