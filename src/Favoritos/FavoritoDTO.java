/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Favoritos;

/**
 *
 * @author maximilianoolivera
 */
public class FavoritoDTO {
    private int userId;
    private int actid;
    private int id;

    public FavoritoDTO(int userId, int actid, int id) {
        this.userId = userId;
        this.actid = actid;
        this.id = id;
    }
    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActid() {
        return actid;
    }

    public void setActid(int actid) {
        this.actid = actid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
