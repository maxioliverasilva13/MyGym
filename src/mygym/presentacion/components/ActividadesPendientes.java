/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.components;

import Actividad.ActividadBO;
import Actividad.IActividadBO;
import Actividad.dtos.ActividadDTO;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author maximilianooliverasilva
 */
public class ActividadesPendientes extends javax.swing.JFrame {

   
    HashMap<Integer, ActividadDTO> actividades = null;
    public ActividadesPendientes() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        this.loadActividadesPendientes(); 
        
    }

   


    private void loadActividadesPendientes(){ 
        IActividadBO actBo = new ActividadBO();
        try {
            DefaultTableModel modeloDatos = (DefaultTableModel) this.tablaActividades.getModel();
            this.actividades = actBo.listarAllActividadesPendientes();
            modeloDatos.setRowCount(0);
            this.actividades.forEach((key, value) -> {
                ActividadDTO currentActividad = this.actividades.get(key);
                modeloDatos.addRow(new Object[]{currentActividad.getId(), currentActividad.getNombre(), currentActividad.getDescripcion(), currentActividad.getCosto()});
            });
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        fechaNac = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        headerBar = new javax.swing.JPanel();
        exitBtnBG = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaActividades = new javax.swing.JTable();

        jOptionPane1.setBackground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(153, 0, 51));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CancelarButton.jpg"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jButton2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AceptarButton.jpg"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 69, 87));
        jLabel1.setText("Actividades pendientes ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 25));

        headerBar.setBackground(new java.awt.Color(255, 255, 255));
        headerBar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(215, 215, 215)));
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

        exitBtnBG.setBackground(new java.awt.Color(174, 0, 51));

        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
            .addComponent(exitBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        exitBtnBGLayout.setVerticalGroup(
            exitBtnBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtnBGLayout.createSequentialGroup()
                .addComponent(exitBtn)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        headerBar.add(exitBtnBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 30, -1));

        btnMinimizarBG.setBackground(java.awt.Color.lightGray);

        btnMinimizar.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimizar.setText("-");
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnMinimizarBGLayout = new javax.swing.GroupLayout(btnMinimizarBG);
        btnMinimizarBG.setLayout(btnMinimizarBGLayout);
        btnMinimizarBGLayout.setHorizontalGroup(
            btnMinimizarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMinimizarBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnMinimizarBGLayout.setVerticalGroup(
            btnMinimizarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        headerBar.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 30, -1));

        jPanel1.add(headerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 20));

        scrollTabla.setBackground(new java.awt.Color(255, 255, 255));
        scrollTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        scrollTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablaActividades.setAutoCreateRowSorter(true);
        tablaActividades.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        tablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Descripción", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaActividades.setGridColor(new java.awt.Color(255, 255, 255));
        tablaActividades.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tablaActividades.setShowGrid(false);
        tablaActividades.setUpdateSelectionOnSort(false);
        scrollTabla.setViewportView(tablaActividades);

        jPanel1.add(scrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 490, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel
        this.updateEstado("Rechazada");
    }//GEN-LAST:event_cancel

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitBtnMouseClicked

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void headerBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarMouseDragged
        
    }//GEN-LAST:event_headerBarMouseDragged

    private void headerBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarMousePressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_headerBarMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
         this.updateEstado("Aceptada");
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void updateEstado(String newEstado){  
        
        int selectedRowId = this.tablaActividades.getSelectedRow();
        if(selectedRowId == -1){
            JOptionPane.showMessageDialog(new JFrame(), "Error, seleccione una actividad existente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Object idObj = this.tablaActividades.getValueAt(selectedRowId, 0);
        int selectedActividadID = (Integer) idObj;
        ActividadDTO selectedAct = this.actividades.get(selectedActividadID); // PASARLE ESTE DT POR EL CONSTRUCTOR DEL FORM
        if (selectedAct != null){
            IActividadBO actBo = new ActividadBO();
            actBo.cambiarEstado(selectedActividadID, newEstado);
            this.loadActividadesPendientes();
            JOptionPane.showMessageDialog(new JFrame(), "La acitividad : " + selectedAct.getNombre() + " fue " + newEstado + " correctamente!", "Actividad editada correctamente", JOptionPane.INFORMATION_MESSAGE);

            
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Error, seleccione una actividad existente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
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
            java.util.logging.Logger.getLogger(ActividadesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActividadesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActividadesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActividadesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActividadesPendientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel btnMinimizarBG;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JPanel exitBtnBG;
    private com.raven.datechooser.DateChooser fechaNac;
    private javax.swing.JPanel headerBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaActividades;
    // End of variables declaration//GEN-END:variables
}
