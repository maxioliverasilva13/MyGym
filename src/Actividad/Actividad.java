/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import Profesor.Profesor;
import Institucion.Institucion;
import java.util.Collection;
import javax.persistence.OneToMany;
import Clase.Clase;
import CuponeraXActividad.CuponeraXActividad;
import java.util.List;
import Clase.DtClase;
import java.util.ArrayList;
import Profesor.dtos.ProfesorDTO;
import Actividad.dtos.ActividadDTO;
import Categoria.Categoria;
import Categoria.DtCategoria;
import Institucion.DtInstitucion;
import CuponeraXActividad.DtCuponeraXActividad;
import com.mysql.cj.conf.IntegerProperty;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
public class Actividad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;
    private float costo;
    private Date fechaRegistro;
    @Column(columnDefinition = "varchar(255) default 'Ingresada'")
    private String estado = "Ingresada";
    @ManyToOne
    @JoinColumn()
    private Profesor profesor;
    @ManyToOne
    @JoinColumn()
    private Institucion institucion;
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private Collection<Clase> clases;
    @OneToMany(mappedBy = "actividad")
    private Collection<CuponeraXActividad> cuponerasXActividad;
    @OneToMany
    private Collection<Categoria> categorias;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public File createTempFile() {
        String dir = System.getProperty("java.io.tmpdir");
        File file = new File(dir + "image-" + this.nombre + ".jpg");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(this.image);
        } catch (Exception e) {
            System.out.println("Actividad-createTempFile");
            System.out.println(e.getMessage());
        }
        return file;
    }

    public void setImage(File file) throws FileNotFoundException, IOException {
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();
        this.image = picInBytes;
    }

    public void addCuponerasXActividad(CuponeraXActividad cuxact) {
        cuponerasXActividad.add(cuxact);
    }

    public void addCategoria(Categoria cat) {
        categorias.add(cat);
    }

    public void addClase(Clase clase) {
        clases.add(clase);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Collection<Clase> getClases() {
        return clases;
    }

    public void setClases(Collection<Clase> clases) {
        this.clases = clases;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<CuponeraXActividad> getCuponerasXActividad() {
        return cuponerasXActividad;
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    public void setCuponerasXActividad(Collection<CuponeraXActividad> cuponerasXActividad) {
        this.cuponerasXActividad = cuponerasXActividad;
    }

    public void setCategorias(Collection<Categoria> cats) {
        this.categorias = cats;
    }

    public ActividadDTO getDtActividad() {
        SimpleIntegerProperty totalActividadesAceptadas = new SimpleIntegerProperty();
        List<DtClase> allClases = new ArrayList<>();
        this.getClases().forEach((clase) -> {
            allClases.add(clase.getDtClase());
        });
        ProfesorDTO profe = null;
        if (this.profesor != null) {
            profe = new ProfesorDTO(profesor.getId(), profesor.getNombre(), profesor.getApellido(),
                    profesor.getNickname(), profesor.getEmail(), profesor.getNacimiento(),
                    profesor.getDescripcionGeneral(), profesor.getBiografia(), profesor.getLinkSitioWeb(), null, null,
                    null, profesor.getSeguidosDt(), profesor.getSeguidoresDT(), profesor.getImage());
        }
        DtInstitucion dtIns = null;
        if (this.institucion != null) {
            this.institucion.getActividades().forEach((Actividad act) -> {
                if (act.getEstado().equals("Aceptada")) {
                    totalActividadesAceptadas.set(totalActividadesAceptadas.get() + 1);
                }
            });
            File photo = null;
            if (this.institucion.getImage() != null) {
                photo = this.institucion.createTempFile();
            }
            dtIns = new DtInstitucion(institucion.getId(), institucion.getNombre(), institucion.getDescripcion(),
                    institucion.getUrl(), null, null, photo, null, totalActividadesAceptadas.get());
        }
        List<DtCuponeraXActividad> cuponerasXact = new ArrayList<>();
        cuponerasXActividad.forEach((cuponera) -> {
            cuponerasXact.add(cuponera.getDtCuponeraXActividad());
        });
        // TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO
        List<DtCategoria> categorias = new ArrayList<>(); // Agregar al DTO creado.
        if (this.getCategorias() != null) {

            this.getCategorias().forEach((categoria) -> {
                categorias.add(categoria.getDtCategoria());
            });

        }

        try {
            ActividadDTO dt = new ActividadDTO(
                    this.id, this.nombre, this.descripcion, this.duracion, this.costo, this.fechaRegistro, profe,
                    allClases, dtIns, cuponerasXact, this.image != null ? createTempFile() : null, categorias,
                    this.getImage());
            return dt;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getEstado() {
        return this.estado;
    }

}
