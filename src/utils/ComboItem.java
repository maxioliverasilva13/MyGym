/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author mandi
 */
public class ComboItem {
    private String id;
    private String value;

    public ComboItem(String id, String value) {
        this.id = id;
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
