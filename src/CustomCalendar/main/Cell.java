package CustomCalendar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.*;
import java.util.function.Consumer;
import utils.CustomClick;

public class Cell extends JButton {

    private Date date;
    private boolean title;
    private boolean isToDay;
    private boolean isMarked;
    private boolean isSelected;
    private List<CustomClick> availableDates = new ArrayList();

    public Cell() {
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
    }
    
    public void setAvailableDates(List<CustomClick> availableDates) {
        this.availableDates = availableDates;
    }

    public void asTitle() {
        title = true;
    }

    public boolean isTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void currentMonth(boolean act) {
        if (act) {
            setForeground(new Color(68, 68, 68));
        } else {
            setForeground(new Color(169, 169, 169));
        }
    }

    public void setAsToDay() {
        isToDay = true;
        setForeground(Color.WHITE);
    }
    
    public void setTootTipText(String text) {
        this.setToolTipText(text);
    }
    
    public void setIsMarked(Date c) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(c);
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int month = ca.get(Calendar.MONTH) + 1;
        int year = ca.get(Calendar.YEAR);
        
        if (this.availableDates != null) {
            this.availableDates.forEach(new Consumer<CustomClick>() {
               @Override
               public void accept(CustomClick customClick) {
                   LocalDate d = customClick.getDate();
                   if (d.getDayOfMonth()== day && d.getMonthValue()== month && d.getYear() == year) {
                       isMarked = true;
                       setTootTipText("Clase: " + customClick.clase.getNombre());
                       setForeground(Color.WHITE);
                       Cell.this.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                customClick.actionPerformed(e);
                                if (isSelected) {
                                    isSelected = false;
                                } else {
                                    isSelected = true;
                                }
                                setForeground(Color.WHITE);
                            }
                       });
                   }
               }
           }); 
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (title) {
            grphcs.setColor(new Color(213, 213, 213));
            grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }
        if (isToDay || isMarked) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(97, 49, 237));
            if (this.isSelected) {
                g2.setColor(new Color(19, 12, 63));
            } else {
                g2.setColor(new Color(97, 49, 237));
            }
            int x = getWidth() / 2 - 17;
            int y = getHeight() / 2 - 17;
            g2.fillRoundRect(x, y, 35, 35, 100, 100);
        }
        super.paintComponent(grphcs);
    }

}
