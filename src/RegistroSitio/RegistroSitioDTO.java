/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroSitio;

/**
 *
 * @author maximilianoolivera
 */
public class RegistroSitioDTO {

    private int id;
    private String ip;
    private String url;
    private String browser;
    private String So;

    public RegistroSitioDTO(int id, String ip, String url, String browser, String So) {
        this.id = id;
        this.ip = ip;
        this.url = url;
        this.browser = browser;
        this.So = So;
    }

    public RegistroSitioDTO(String ip, String url, String browser, String So) {
        this.ip = ip;
        this.url = url;
        this.browser = browser;
        this.So = So;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getSo() {
        return So;
    }
}
