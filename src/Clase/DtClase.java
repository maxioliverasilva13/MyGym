/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import Registro.DtRegistro;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author maximilianooliverasilva
 */
public class DtClase {
    private int id;
    private String nombre;
    private Date fecha;
    private String profesor;
    private int ProfesorId;
    private int capMinima;
    private int capMaxima;
    private String urlAcceso;
    private Date fechaRegistro;
    private List<DtRegistro> registros = new ArrayList<>();
    private int idActividad;
    private String actividadName;
    private int idInstitucion;
    // TODO: Change this for the new DtProfesor and DtActividad
    
    public DtClase(int id, String nombre, Date fecha, String profesor, int ProfesorId, int capMinima, int capMaxima, String urlAcceso, Date fechaRegistro, List<DtRegistro> registros, int idActividad, String actividadName) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.profesor = profesor;
        this.ProfesorId = ProfesorId;
        this.capMinima = capMinima;
        this.capMaxima = capMaxima;
        this.urlAcceso = urlAcceso;
        this.fechaRegistro = fechaRegistro;
        this.registros = registros;
        this.idActividad = idActividad;
        this.actividadName = actividadName;
    }
    
    public DtClase(int id, String nombre, Date fecha, String profesor, int ProfesorId, int capMinima, int capMaxima, String urlAcceso, Date fechaRegistro, List<DtRegistro> registros, int idActividad, String actividadName, int idInstitucion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.profesor = profesor;
        this.ProfesorId = ProfesorId;
        this.capMinima = capMinima;
        this.capMaxima = capMaxima;
        this.urlAcceso = urlAcceso;
        this.fechaRegistro = fechaRegistro;
        this.registros = registros;
        this.idActividad = idActividad;
        this.actividadName = actividadName;
        this.idInstitucion = idInstitucion;
    }
    
    
    public DtClase(int id, String nombre, Date fecha, int capMinima, int capMaxima, String urlAcceso, Date fechaRegistro, String profesor) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.capMinima = capMinima;
        this.capMaxima = capMaxima;
        this.urlAcceso = urlAcceso;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profesor;
    }
    
    public DtClase(int id, String nombre, Date fecha, int capMinima, int capMaxima, String urlAcceso, Date fechaRegistro, String profesor, List<DtRegistro> regs) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.capMinima = capMinima;
        this.capMaxima = capMaxima;
        this.urlAcceso = urlAcceso;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profesor;
        this.registros = regs;
    }
    
    public DtClase(int id, String nombre, Date fecha, int capMinima, int capMaxima, String urlAcceso, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.capMinima = capMinima;
        this.capMaxima = capMaxima;
        this.urlAcceso = urlAcceso;
        this.fechaRegistro = fechaRegistro;
    }
        
    
    public DtClase() {
       
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getProfesor() {
        return profesor;
    }

    public int getProfesorId() {
        return ProfesorId;
    }

    public int getCapMinima() {
        return capMinima;
    }

    public int getCapMaxima() {
        return capMaxima;
    }

    public String getUrlAcceso() {
        return urlAcceso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public List<DtRegistro> getRegistros() {
        return registros;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public String getActividadName() {
        return actividadName;
    }
    
}
