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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;

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
    @Column
    protected  String nombre;
    @Column
    protected String apellido;
    @Column()
    protected String email;
    
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
    
     public void setImage(File file) {
         try {
             byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();
        this.image = picInBytes;
         } catch (Exception e) {
             System.out.println("Usuario-SetImage");
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
   

}
