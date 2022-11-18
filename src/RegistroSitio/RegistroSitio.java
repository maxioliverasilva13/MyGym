/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroSitio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import Socio.Socio;
import Clase.Clase;
import Clase.DtClase;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.annotations.Cache;
import Premio.Premio;
import Registro.DtRegistro;
import Socio.dtos.SocioDTO;
/**
 *
 * @author maximilianooliverasilva
 */
@Entity
@Table()
@Cacheable(false)
public class RegistroSitio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ip;
    private String url;
    private String browser;
    private String So;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getSo() {
        return So;
    }

    public void setSo(String So) {
        this.So = So;
    }
    
    
    public RegistroSitioDTO getRegistroSitioDTO() {
        RegistroSitioDTO regDTO = new RegistroSitioDTO(id,ip, url, browser, So);
        return regDTO;
    }
    

}
