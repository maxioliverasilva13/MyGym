/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Premio;

import Premio.dtos.PremioDTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.ManyToOne;
import Actividad.Actividad;
import java.util.Collection;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import Registro.Registro;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import Registro.DtRegistro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.persistence.Cacheable;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import org.eclipse.persistence.annotations.Cache;
import Clase.Clase;
import javax.persistence.ManyToMany;
import Clase.DtClase;

/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
@Cacheable(false)
public class Premio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String descripcion;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    private int cantidadSorteados;
    private boolean fueSorteado;

    @ManyToOne
    @JoinColumn()
    private Clase claseOfPremio;
    @ManyToMany(mappedBy = "premios")
    private List<Registro> registros = new ArrayList();

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCantidadSorteados() {
        return cantidadSorteados;
    }

    public void setCantidadSorteados(int cantidadSorteados) {
        this.cantidadSorteados = cantidadSorteados;
    }

    public boolean isFueSorteado() {
        return fueSorteado;
    }

    public void setFueSorteado(boolean fueSorteado) {
        this.fueSorteado = fueSorteado;
    }

    public Clase getClase() {
        return claseOfPremio;
    }

    public void setClase(Clase clase) {
        this.claseOfPremio = clase;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public void agregarRegistro(Registro reg) {
        this.registros.add(reg);
    }

    public PremioDTO getDtPremio() {
        List<DtRegistro> registros = new ArrayList<>();
        if (this.registros.size() > 0) {
            this.registros.forEach((Registro reg) -> {
                registros.add(reg.getDtRegistro());                      
            });
        }
        DtClase claseInfo = this.claseOfPremio.getDtClaseWithoutPremios();

        PremioDTO premio = new PremioDTO(id, descripcion, fechaCreacion, cantidadSorteados, fueSorteado, registros, claseInfo);
        return premio;
    }

}
