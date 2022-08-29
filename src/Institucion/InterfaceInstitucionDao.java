/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Institucion;

import java.util.List;

/**
 *
 * @author maximilianooliverasilva
 */
public interface InterfaceInstitucionDao {
    public void insertar(DtInstitucion institucion);
    public Institucion existe(int id);
    public void agregarProfesor(int profesorId, int idInstitucion);
    public void agregarActividad(int actId, int insId);
    public List<Institucion> listarInstituciones();

}
