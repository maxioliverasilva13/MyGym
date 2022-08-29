/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Institucion;

import java.util.HashMap;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceInstitucionBO {
    public void agregarInstitucion(DtInstitucion institucion);
    public DtInstitucion existeInstitucion(int idInstitucion);
    public void agregarProfesor(int idProfesor, int idInstitucion);
    public void agregarActividad(int idActividad, int idInstitucion);
    public HashMap<Integer, DtInstitucion> listarInstituciones();
}