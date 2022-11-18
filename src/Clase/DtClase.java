/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import Premio.dtos.PremioDTO;
import Registro.DtRegistro;
import java.io.File;
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
    private PremioDTO premio;
    File image;
    byte [] imageBlob;
    // TODO: Change this for the new DtProfesor and DtActividad
    
    
    
    public DtClase(int id, String nombre, Date fecha, String profesor, Integer ProfesorId , Integer capMinima, Integer capMaxima, String urlAcceso, Date fechaRegistro, List<DtRegistro> registros, Integer idActividad, String actividadName, Integer idInstitucion, File imageFile, byte[] imageBlob) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.profesor = profesor;
        if (ProfesorId != null) {
            this.ProfesorId = ProfesorId;
        }
        if (capMinima != null) {
           this.capMinima = capMinima;
        }
        if (capMaxima != null) {
           this.capMaxima = capMaxima;
        }
        this.urlAcceso = urlAcceso;
        this.fechaRegistro = fechaRegistro;
        this.registros = registros;
        if (idActividad != null) {
           this.idActividad = idActividad;
        }
        this.actividadName = actividadName;
        if (idInstitucion != null) {
            this.idInstitucion = idInstitucion;
        }
        this.image = imageFile;
        this.imageBlob = imageBlob;
    }
    
       public DtClase(int id, String nombre, Date fecha, String profesor, Integer ProfesorId , Integer capMinima, Integer capMaxima, String urlAcceso, Date fechaRegistro, List<DtRegistro> registros, Integer idActividad, String actividadName, Integer idInstitucion, File imageFile, byte[] imageBlob, PremioDTO premio) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.profesor = profesor;
        if (ProfesorId != null) {
            this.ProfesorId = ProfesorId;
        }
        if (capMinima != null) {
           this.capMinima = capMinima;
        }
        if (capMaxima != null) {
           this.capMaxima = capMaxima;
        }
        this.urlAcceso = urlAcceso;
        this.fechaRegistro = fechaRegistro;
        this.registros = registros;
        if (idActividad != null) {
           this.idActividad = idActividad;
        }
        this.actividadName = actividadName;
        if (idInstitucion != null) {
            this.idInstitucion = idInstitucion;
        }
        this.image = imageFile;
        this.imageBlob = imageBlob;
        this.premio = premio;
    }

    public PremioDTO getPremio() {
        return premio;
    }
    
    public void setId(int id) {
        this.id = id;
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

    public File getImage() {
        return image;
    }
    
    public byte [] getImageBlob() {
       return this.imageBlob; 
    }
}
