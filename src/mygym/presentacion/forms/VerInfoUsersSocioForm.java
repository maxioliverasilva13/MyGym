/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.forms;

import Clase.DtClase;
import Registro.DtRegistro;
import Registro.InterfaceRegistroBO;
import Registro.RegistroBO;
import Socio.ISocioBO;
import Socio.SocioBO;
import Socio.dtos.SocioDTO;
import Socio.exceptions.SocioNotExist;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import mygym.presentacion.components.ChooseInstitucion;
import mygym.presentacion.components.InfoClase;
import utils.BrowseFile;


/**
 *
 * @author maximilianooliverasilva
 */
public class VerInfoUsersSocioForm extends javax.swing.JFrame {

    /**
     * Creates new form AddUsersForm
     */
    private int socioId;
    ChooseInstitucion claseInfoForm = new ChooseInstitucion();

    private SocioDTO socioData = null;
    public VerInfoUsersSocioForm(int socioId) {
        this.socioId = socioId;
        this.loadSocio(socioId);
        initComponents();
        this.render();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        this.setLocationRelativeTo(null);
        jList1.addMouseListener(mouseListenerClase);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Tipo de Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("NickName");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 69, 87));
        jLabel1.setText("Informacion del usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 0, -1, 25));

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel9.setText("Informacion de Clases");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel15.setText("SOCIO");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel13.setText("Adrian");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 50, -1));

        jLabel17.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel17.setText("Adrian");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        jLabel18.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel18.setText("Adrian");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel19.setText("Adrian");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jLabel22.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel22.setText("Informacion Personal");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 459, -1, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jList1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 229, 307));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLayeredPane2.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 61, -1, 392));

        jButton1.setBackground(new java.awt.Color(255, 255, 254));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VolverButton.jpg"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 499, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel20.setText("Adrian");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        labelImage.setText("Foto Perfil");
        jPanel1.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 100, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel
        this.dispose();
    }//GEN-LAST:event_cancel

    private void jList1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseEntered
        
    }//GEN-LAST:event_jList1MouseEntered

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

    }//GEN-LAST:event_jList1MouseClicked

   
    public  DtClase findClaseByName(String claseName) {
        List<DtClase> allClases = new ArrayList<>();
        
        if (socioData.getRegistros() != null) {
            socioData.getRegistros().forEach((DtRegistro reg) -> {
                allClases.add(reg.getClase());
            });
        }
        
        List<DtClase> claseToReturn = new ArrayList<>();
        allClases.forEach((DtClase c) -> {
            if (c.getNombre().equals(claseName)) {
                 claseToReturn.add(c);
            }
        });
        if (claseToReturn.size() > 0) {
            return claseToReturn.get(0);
        }
        return null;
    }
    
     public MouseListener mouseListenerClase = new MouseAdapter() {
      public void mouseClicked(MouseEvent mouseEvent) {
          JList<String> theList = (JList) mouseEvent.getSource();
        if (mouseEvent.getClickCount() == 2) {
          int index = theList.locationToIndex(mouseEvent.getPoint());
          if (index >= 0) {
            Object o = theList.getModel().getElementAt(index);
            DtClase clase = findClaseByName(o.toString());
            if (clase == null) {
                JOptionPane.showMessageDialog(new JFrame(), "La clase seleccionada es inavlida", "Error", JOptionPane.ERROR_MESSAGE);
            }
                claseInfoForm = new ChooseInstitucion(clase);
                claseInfoForm.setVisible(true);
          }
        }
      }
    };
    
    
    
    private void loadSocio(int socioId){
        ISocioBO socioBO = new SocioBO();
        try{
           SocioDTO socio = socioBO.consultarSocio(socioId);
           this.socioData = socio;
        }catch(SocioNotExist s){
            System.out.println(s);
        }
        
    }
    
    private void render(){
          this.jLabel13.setText(this.socioData.getNickname());
           this.jLabel13.setText(this.socioData.getNombre());
           this.jLabel17.setText(this.socioData.getApellido());
           this.jLabel18.setText(this.socioData.getEmail());
          
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            String date = DATE_FORMAT.format(this.socioData.getNacimiento());
            this.jLabel19.setText(date.toString());
            
            
            DefaultListModel listModelRegistros = new DefaultListModel();
            this.socioData.getRegistros().forEach(registro -> {
                listModelRegistros.addElement(registro.getClaseName());
            });
            this.jList1.setModel(listModelRegistros);
          File tempFile = socioData.getImage();
          if (tempFile != null) {
             labelImage.setIcon(BrowseFile.RezizeImage(tempFile.getAbsolutePath(), labelImage));
             this.revalidate();
             this.repaint();
          }
    }
  
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelImage;
    // End of variables declaration//GEN-END:variables
}
