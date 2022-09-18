/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Maximiliano Olivera
 */
public class RenderFoto extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();
    
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
  boolean hasFocus, int row, int column) {
     try {
             String filePath = (String)value;
    if (filePath == null ){        
        return null;
    }
    //lbl.setIcon(icon);
    ImageAvatar imgA = new ImageAvatar();
    ImageIcon imageIcon = new ImageIcon(filePath);
    Image image = imageIcon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(1451, 1451,  java.awt.Image.SCALE_AREA_AVERAGING); // scale it the smooth way  
    imageIcon = new ImageIcon(newimg);  // transform it back
    imgA.setImage(imageIcon);
    imgA.setBorderSize(0);
     
    JPanel panel = new JPanel();
    // panel.setLayout(new AbsoluteLayout());
    panel.add(imgA);
    return imgA;
    // return lbl;
     } catch (Exception e) {
         System.out.println(e.getMessage());
     }
     return null;
}
}