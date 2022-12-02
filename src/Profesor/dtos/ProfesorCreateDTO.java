/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profesor.dtos;

import Usuario.dtos.UsuarioCreateDTO;
import java.io.File;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author angel
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfesorCreateDTO extends UsuarioCreateDTO {

    private String descripcionGeneral;
    private String biografia;
    private String linkSitioWeb;
    private int idInstitucion;

    public ProfesorCreateDTO() {

    }

    public ProfesorCreateDTO(String nombre, String apellido, String nickname, char[] pass, String descripcionGeneral, String biografia, String email, String linkSitioWeb, Date nacimiento, int idInstitucion, File file) {
        super(nombre, apellido, email, nickname, nacimiento, pass, file);

        this.descripcionGeneral = descripcionGeneral;
        this.biografia = biografia;
        this.linkSitioWeb = linkSitioWeb;
        this.idInstitucion = idInstitucion;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public String getdescripcionGeneral() {
        return this.descripcionGeneral;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public String getLinkSitioWeb() {
        return this.linkSitioWeb;
    }

}
