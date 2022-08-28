/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Institucion;

/**
 *
 * @author maximilianooliverasilva
 */
public class InstitucionBO implements InterfaceInstitucionBO {
    InstitucionDao insDao = new InstitucionDao();
    
    @Override
    public void agregarInstitucion(DtInstitucion institucion){
        insDao.insertar(institucion);
    }
    
    @Override
    public DtInstitucion existeInstitucion(int idInstitucion){
        Institucion ins = insDao.existe(idInstitucion);
        if (ins != null) {
            return ins.getDtInstitucion();
        }
        return null;
    }
    
    @Override
    public void agregarProfesor(int idProfesor, int idInstitucion){
        insDao.agregarProfesor(idProfesor, idInstitucion);
    }
    
    @Override
    public void agregarActividad(int idActividad, int idInstitucion){
        insDao.agregarActividad(idActividad, idInstitucion);
    }




}