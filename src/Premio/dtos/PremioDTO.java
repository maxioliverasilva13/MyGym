package Premio.dtos;


import Clase.DtClase;
import Registro.DtRegistro;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author maximilianoolivera
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PremioDTO {

    private int id;
    private String descripcion;
    private Date fechaCreacion;
    private int cantidadSorteados;
    private boolean fueSorteado;
    private List<DtRegistro> registros;
    private DtClase clase;

    public PremioDTO(int id, String descripcion, Date fechaCreacion, int cantidadSorteados, boolean fueSorteado, List<DtRegistro> registros) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.cantidadSorteados = cantidadSorteados;
        this.fueSorteado = fueSorteado;
        this.registros = registros;
    }

        public PremioDTO(int id, String descripcion, Date fechaCreacion, int cantidadSorteados, boolean fueSorteado, List<DtRegistro> registros, DtClase clase) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.cantidadSorteados = cantidadSorteados;
        this.fueSorteado = fueSorteado;
        this.registros = registros;
        this.clase = clase;
    }
    
    public DtClase getClase() {
        return clase;
    }
    
    

    public List<DtRegistro> getRegistros() {
        return registros;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public int getCantidadSorteados() {
        return cantidadSorteados;
    }

    public boolean isFueSorteado() {
        return fueSorteado;
    }

    
}
