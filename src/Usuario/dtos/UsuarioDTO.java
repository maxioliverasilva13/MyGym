/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario.dtos;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author angel
 */
public  class UsuarioDTO {
    protected int ID;
    protected String NOMBRE;
    protected String APELLIDO;
    protected String NICKNAME;
    protected String EMAIL;
    protected Date NACIMIENTO;
    private File image;
    List<UsuarioDTO> seguidos = new ArrayList<>();
    List<UsuarioDTO> seguidores = new ArrayList<>();
    private byte[] blobImage;

    
    public UsuarioDTO(int id, String nombre,String apellido,String nickname,String email,Date nacimiento, File file, List<UsuarioDTO> seguidos, List<UsuarioDTO> seguidores, byte[] blobImage){
        this.ID = id;
        this.NOMBRE = nombre;
        this.APELLIDO = apellido;
        this.NICKNAME = nickname;
        this.EMAIL = email;
        this.NACIMIENTO = nacimiento;
        this.image = file;
        this.seguidores = seguidores;
        this.seguidos = seguidos;
        this.blobImage = blobImage;

    }
    
    public File getImage() {
        return image;
    }

    public byte[] getBlobImage() {
        return blobImage;
    }
    
    public int getId(){
        return this.ID;
    }
    public String getNombre(){
        return this.NOMBRE;
    }
    public String getApellido(){
        return this.APELLIDO;
    }
    public String getNickname(){
        return this.NICKNAME;
    }
    public String getEmail(){
        return this.EMAIL;
    }
    
    public Date getNacimiento(){
        return this.NACIMIENTO;
    }

    public List<UsuarioDTO> getSeguidos() {
        return seguidos;
    }

    public List<UsuarioDTO> getSeguidores() {
        return seguidores;
    }
    
    
}
