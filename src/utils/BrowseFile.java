package utils;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.border.AbstractBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import utils.RoundedBorder;
;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maximiliano Olivera
 */
public class BrowseFile {
    
    public static File globalFile = null;
    
    public static void browseClickEvent(JLabel labelImage) {
        JFileChooser file = new JFileChooser();
           file.setCurrentDirectory(new File(System.getProperty("user.home")));
           FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
           file.addChoosableFileFilter(filter);
           int result = file.showSaveDialog(null);
           if (result == JFileChooser.APPROVE_OPTION) {
               File selected = file.getSelectedFile();
               globalFile = selected;
               String path = selected.getAbsolutePath();
               labelImage.setIcon(RezizeImage(path, labelImage));
           } else if (result == JFileChooser.CANCEL_OPTION) {
               System.out.println("No File Select");
           }
    }
    
    public static ImageIcon RezizeImage(String imagePath, JLabel labelImage) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
       //  labelImage.setBorder(new RoundedBorder(Color.RED, 20));
        return image;
    }
    
}