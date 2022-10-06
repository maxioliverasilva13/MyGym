/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Profesor.Profesor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import Seguidor.Seguidor;
import Socio.Socio;
import Usuario.dtos.UsuarioDTO;

/**
 *
 * @author maximilianooliverasilva
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column()
    protected  String nickname;
    @Column()
    protected String password;
    @Column
    protected  String nombre;
    @Column
    protected String apellido;
    @Column()
    protected String email;
    @OneToMany(mappedBy = "persona")
    @JoinColumn()
    List<Seguidor> seguidos;
    @OneToMany(mappedBy = "sigueA")
    @JoinColumn()
    List<Seguidor> seguidores;
    
    public void addSeguidor(Seguidor s) {
        this.seguidores.add(s);
    }
    
    public void addSeguido(Seguidor s) {
        this.seguidos.add(s);
    }

    public List<Seguidor> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(List<Seguidor> seguidos) {
        this.seguidos = seguidos;
    }

    public List<Seguidor> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(List<Seguidor> seguidores) {
        this.seguidores = seguidores;
    }
    
    @Column()
    protected Date nacimiento;

    @Basic(optional = true)
    protected  String DTYPE;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected byte[] image;
    
    public byte[] getImage() {
        return image;
    }
    
    public File createTempFile() {
        if (this.image != null) {
             String dir = System.getProperty("java.io.tmpdir");
        File file = new File(dir + "image-user-" + this.nombre + ".jpg");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(this.image);
        } catch (Exception e) {
            System.out.println("Usuario-createTempFile");
            System.out.println(e.getMessage());
        }
                return file;

        }
       return null;
    }
    
     public void setImage(File file) {
         try {
    System.out.println(file);
             byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();
        this.image = picInBytes;
         } catch (Exception e) {
             System.out.println("Usuario-SetImage");
             System.out.println(e.getMessage());
         }
    }
    

    public Usuario(){
        
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }
    
    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Date getNacimiento() {
        return nacimiento;
    }
    
    public String getDtype(){
        return DTYPE;
    }

    public List<UsuarioDTO> getSeguidoresDT() {
        List<UsuarioDTO> allUsers = new ArrayList<>();
        this.seguidores.forEach((item) -> {
            if (item.getPersona().getDtype().equals("Socio")) {
                Socio soc = (Socio)item.getPersona();
                allUsers.add(soc.getDtSocio());
            }
            if (item.getPersona().getDtype().equals("Profesor")) {
                Profesor soc = (Profesor)item.getPersona();
                allUsers.add(soc.getDtProfesor());
            }
        });
        return allUsers;
    }

    public List<UsuarioDTO> getSeguidosDt() {
        System.out.println(this.seguidores.size());
        System.out.println(this.seguidos.size());
        List<UsuarioDTO> allUsers = new ArrayList<>();
        this.seguidos.forEach((item) -> {
            if (item.getSigueA().getDtype().equals("Socio")) {
                Socio soc = (Socio)item.getSigueA();
                allUsers.add(soc.getDtSocio());
            }
            if (item.getSigueA().getDtype().equals("Profesor")) {
                Profesor soc = (Profesor)item.getSigueA();
                allUsers.add(soc.getDtProfesor());
            }
        });
        return allUsers;
    }
   

}
