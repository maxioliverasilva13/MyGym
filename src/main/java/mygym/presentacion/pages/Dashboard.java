/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import mygym.presentacion.enums.SideBarContent;
import mygym.presentacion.enums.PAGE;

/**
 *
 * @author maximilianooliverasilva
 */
public final class Dashboard extends javax.swing.JFrame {
    
    SideBarContent contentController = new SideBarContent();
    /**
     * Creates new form Dashboard
     */
    
    int xMouse, yMouse;
    
    JButton getButton() {
        PAGE activePage = contentController.getActivePage();
        JButton buttonToReturn;
        
        buttonInicio.setBackground(new Color(153, 153, 153));
        buttonInicio.setOpaque(true);
        buttonActividades.setBackground(new Color(153, 153, 153));
        buttonActividades.setOpaque(true);
        buttonCuponera.setBackground(new Color(153, 153, 153));
        buttonCuponera.setOpaque(true);
        buttonClases.setBackground(new Color(153, 153, 153));
        buttonClases.setOpaque(true);
        buttonInstitucion.setBackground(new Color(153, 153, 153));
        buttonInstitucion.setOpaque(true);
        buttonUsuarios.setBackground(new Color(153, 153, 153));
        buttonUsuarios.setOpaque(true);
        switch (activePage) {
            case INICIO -> buttonToReturn = buttonInicio;
            case ACTIVIDAD -> buttonToReturn = buttonActividades;
            case CUPONERA -> buttonToReturn = buttonCuponera;
            case CLASE -> buttonToReturn = buttonClases;
            case INSTITUCION -> buttonToReturn = buttonInstitucion;
            case USUARIO -> buttonToReturn = buttonUsuarios;
            default -> throw new AssertionError();
        }
        buttonToReturn.setBackground(new Color(0, 204, 204));
        buttonToReturn.setOpaque(true);
        return buttonToReturn;
    }
    
    public Dashboard() {
        initComponents();
        colocatePage();
    }
    
    void colocatePage() {
      getButton();
      JPanel paneltoShow = contentController.getContentPanel();
      System.out.println(contentController.activePage);
      paneltoShow.setSize(720, 540);
      paneltoShow.setLocation(0,0);
      content.removeAll();
      content.add(paneltoShow, BorderLayout.CENTER);
      content.revalidate();
      content.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        sidebarPanel = new javax.swing.JPanel();
        buttonInicio = new javax.swing.JButton();
        buttonUsuarios = new javax.swing.JButton();
        buttonActividades = new javax.swing.JButton();
        buttonClases = new javax.swing.JButton();
        buttonCuponera = new javax.swing.JButton();
        buttonInstitucion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        headerBar = new javax.swing.JPanel();
        exitBtnBG = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(720, 540));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        backgroundPanel.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 720, 540));

        sidebarPanel.setBackground(new java.awt.Color(51, 51, 51));

        buttonInicio.setBackground(new java.awt.Color(0, 204, 204));
        buttonInicio.setForeground(new java.awt.Color(255, 255, 255));
        buttonInicio.setText("Inicio");
        buttonInicio.setBorder(null);
        buttonInicio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInicioActionPerformed(evt);
            }
        });

        buttonUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        buttonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        buttonUsuarios.setText("Usuarios");
        buttonUsuarios.setBorder(null);
        buttonUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUsuariosActionPerformed(evt);
            }
        });

        buttonActividades.setBackground(new java.awt.Color(153, 153, 153));
        buttonActividades.setForeground(new java.awt.Color(255, 255, 255));
        buttonActividades.setText("Actividades");
        buttonActividades.setBorder(null);
        buttonActividades.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActividadesActionPerformed(evt);
            }
        });

        buttonClases.setBackground(new java.awt.Color(153, 153, 153));
        buttonClases.setForeground(new java.awt.Color(255, 255, 255));
        buttonClases.setText("Clases");
        buttonClases.setBorder(null);
        buttonClases.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClasesActionPerformed(evt);
            }
        });

        buttonCuponera.setBackground(new java.awt.Color(153, 153, 153));
        buttonCuponera.setForeground(new java.awt.Color(255, 255, 255));
        buttonCuponera.setText("Cuponera");
        buttonCuponera.setBorder(null);
        buttonCuponera.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonCuponera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCuponeraActionPerformed(evt);
            }
        });

        buttonInstitucion.setBackground(new java.awt.Color(153, 153, 153));
        buttonInstitucion.setForeground(new java.awt.Color(255, 255, 255));
        buttonInstitucion.setText("Institucion");
        buttonInstitucion.setBorder(null);
        buttonInstitucion.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInstitucionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Shree Devanagari 714", 3, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TUGym");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 255, 255)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonActividades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonClases, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCuponera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonInstitucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonClases, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCuponera, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        backgroundPanel.add(sidebarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 560));

        headerBar.setBackground(new java.awt.Color(255, 255, 255));
        headerBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerBarMouseDragged(evt);
            }
        });
        headerBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerBarMousePressed(evt);
            }
        });
        headerBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtnBG.setBackground(new java.awt.Color(102, 0, 51));

        exitBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn.setText("X");
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exitBtnBGLayout = new javax.swing.GroupLayout(exitBtnBG);
        exitBtnBG.setLayout(exitBtnBGLayout);
        exitBtnBGLayout.setHorizontalGroup(
            exitBtnBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        exitBtnBGLayout.setVerticalGroup(
            exitBtnBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtnBGLayout.createSequentialGroup()
                .addComponent(exitBtn)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        headerBar.add(exitBtnBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(827, 0, -1, -1));

        backgroundPanel.add(headerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUsuariosActionPerformed
        contentController.setActivatePage(PAGE.USUARIO);    
        colocatePage();        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUsuariosActionPerformed

    private void buttonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicioActionPerformed
        contentController.setActivatePage(PAGE.INICIO);    
        colocatePage();
// TODO add your handling code here:
    }//GEN-LAST:event_buttonInicioActionPerformed

    private void buttonActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActividadesActionPerformed
        contentController.setActivatePage(PAGE.ACTIVIDAD);    
        colocatePage();     
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonActividadesActionPerformed

    private void buttonClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClasesActionPerformed
        contentController.setActivatePage(PAGE.CLASE);    
        colocatePage();     
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonClasesActionPerformed

    private void buttonCuponeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCuponeraActionPerformed
        contentController.setActivatePage(PAGE.CUPONERA);    
        colocatePage();     
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCuponeraActionPerformed

    private void buttonInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInstitucionActionPerformed
        contentController.setActivatePage(PAGE.INSTITUCION);    
        colocatePage();
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonInstitucionActionPerformed

    private void headerBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerBarMousePressed

    private void headerBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerBarMouseDragged

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton buttonActividades;
    private javax.swing.JButton buttonClases;
    private javax.swing.JButton buttonCuponera;
    private javax.swing.JButton buttonInicio;
    private javax.swing.JButton buttonInstitucion;
    private javax.swing.JButton buttonUsuarios;
    private javax.swing.JPanel content;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JPanel exitBtnBG;
    private javax.swing.JPanel headerBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables
}
