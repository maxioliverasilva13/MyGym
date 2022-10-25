
package Actividad.dtos;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Categoria.DtCategoria;
import Clase.DtClase;
import CuponeraXActividad.DtCuponeraXActividad;
import Institucion.DtInstitucion;
import Profesor.dtos.ProfesorDTO;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ActividadDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;
    private float costo;
    private Date fechaRegistro;
    ProfesorDTO profesor;
    private List<DtClase> clases = new ArrayList<>();
    private List<DtCuponeraXActividad> cuponerasXActivdad = new ArrayList<>();
    private List<DtCategoria> categorias = new ArrayList<>();
    public byte[] imageBlob = null;
    private String estado;

    DtInstitucion institucion;
    File image;

    public File getImage() {
        return image;
    }
    
    public ActividadDTO(int id, String nombre, String descripcion, int duracion, float costo, Date fechaRegistro, ProfesorDTO profe, List<DtClase> clases, DtInstitucion ins, List<DtCuponeraXActividad> cupsXAct, File file, List<DtCategoria> cats, byte[] imageBlob) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profe;
        if (clases != null) {
            this.clases = clases;
        }
        this.clases = clases;
        this.id = id;
        this.institucion = ins;
        if (cupsXAct != null) {
           this.cuponerasXActivdad = cupsXAct;
        }
        if (cats != null) {
            this.categorias = cats;
        }
        this.image = file;
        if (imageBlob != null) {
            this.imageBlob = imageBlob;
        }
    }
    
    public ActividadDTO(int id, String nombre, String descripcion, int duracion, float costo, Date fechaRegistro, ProfesorDTO profe, List<DtClase> clases, DtInstitucion ins, List<DtCuponeraXActividad> cupsXAct, File file, List<DtCategoria> cats, byte[] imageBlob, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.profesor = profe;
        if (clases != null) {
            this.clases = clases;
        }
        this.clases = clases;
        this.id = id;
        this.institucion = ins;
        if (cupsXAct != null) {
           this.cuponerasXActivdad = cupsXAct;
        }
        if (cats != null) {
            this.categorias = cats;
        }
        this.image = file;
        if (imageBlob != null) {
            this.imageBlob = imageBlob;
        }
        if (estado != null) {
            this.estado = estado;
        }
    }

    public List<DtCuponeraXActividad> getCuponerasXActivdad() {
        return cuponerasXActivdad;
    }

    public DtInstitucion getInstitucion() {
        return institucion;
    }
    
    public int getId(){
        return id;
    }
    
    public ProfesorDTO getProfesor() {
        return profesor;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<DtClase> getClases() {
        return clases;
    }
    
    public List<DtCategoria> getCategorias() {
        return categorias;
    }

    public int getDuracion() {
        return duracion;
    }

    public float getCosto() {
        return costo;
    }
    
    public List<DtCuponeraXActividad> getDtCuponeraXActividad() {
        return this.cuponerasXActivdad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }
    
    public String getEstado() {
        return estado;
    }
    
}
