package utils;


import java.util.Calendar;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angel
 */
public class Datehelper {
    
    public String dateToStringFormat(Date fecha){
        Calendar fechaCalendar = Calendar.getInstance();
        fechaCalendar.setTime(fecha);
        int day = fechaCalendar.get(Calendar.DAY_OF_MONTH);
        int month = fechaCalendar.get(Calendar.MONTH);
        int year = fechaCalendar.get(Calendar.YEAR);

        return day + "/" + month + "/"+ year; 

    }
    
}
