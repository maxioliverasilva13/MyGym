package utils;

import Clase.DtClase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import ParseDate.ParseDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomClick implements ActionListener {
    ParseDate ps = new ParseDate();
    public DtClase clase = null;
    public static List<Integer> selectedClaseId = new ArrayList<>();
    public ActionListener additionalEvent;
    boolean existe = false;
    
    public void setAditionalEvent(ActionListener a) {
        this.additionalEvent = a;
    }
    
    public CustomClick(DtClase clase){
        super();
        this.clase = clase;
    }
    
    public void addSelectedClaseId(int id){
        this.selectedClaseId.add(id);
    }
    
    public List<Integer> getSelectedClaseId() {
        return this.selectedClaseId;
    }
    
    public LocalDate getDate() {
        String fecha = "";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (this.clase.getFecha() != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.clase.getFecha());
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH)+ 1;
            int year = calendar.get(Calendar.YEAR);
            fecha = (day < 10 ? "0" + day : day) + "-" + (month < 10 ? "0" + month : month) + "-" + year;
        }
        LocalDate ds = LocalDate.parse(fecha, df);
        return ds;
    }
    
    private void addCurrentClase() {
        addSelectedClaseId(this.clase.getId());
        existe = true;
    }
    
    private void removeCurrentClase() {
        int index = selectedClaseId.indexOf(this.clase.getId());
        selectedClaseId.remove(index);
        existe = false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (existe) {
            removeCurrentClase();
        } else {
            addCurrentClase();
        }
        if (additionalEvent != null) {
            this.additionalEvent.actionPerformed(ae);
        }
    }
}