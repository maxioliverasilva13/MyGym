/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.forms;

import Actividad.dtos.ActividadDTO;
import Cuponera.DtCuponera;
import CuponeraXActividad.DtCuponeraXActividad;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import mygym.logica.usuario.dataTypes.DtActividad;
import utils.ComboItem;

/**
 *
 * @author mandi
 */
public class showInfoCuponera extends javax.swing.JFrame {

    int xMouse, yMouse;
    public List<DtCuponeraXActividad> actividades; 
    
    DefaultComboBoxModel modelActividades = new DefaultComboBoxModel();
    
    public showInfoCuponera() {
        initComponents();
    }
    
    public showInfoCuponera(DtCuponera dt) {
        initComponents();
        this.setLocationRelativeTo(null);
        pintarInfoCuponera(dt);
        llenarCBoxActividades(dt);
        if(cmbActividades.getItemCount() == 0){
            pnlConsultar.setVisible(false);
            lblError.setText("Lo sentimos, no hemos encontrado actividades asociadas.");
        }
    }

    
    public void llenarCBoxActividades (DtCuponera dt){
        this.cmbActividades.removeAllItems();
        actividades = dt.getCuponerasXActividad();
        if (actividades != null) {
            actividades.forEach((DtCuponeraXActividad cuxa) -> {
                String nombre = cuxa.getActividad().getNombre() + "  (" + cuxa.getCantClases() + ")";
                modelActividades.addElement(new ComboItem(Integer.toString(cuxa.getActividad().getId()), nombre));
            });
            cmbActividades.setModel(modelActividades);
        }
    }
    
        private void pintarInfoCuponera(DtCuponera cup){

        nombreCuponera.setText(cup.getNombre());
        Date fecha = cup.getPeriodoVigencia();
        String fechaCompuesta = fecha.getDate()+ "/" + fecha.getMonth() + "/" + fecha.getYear()+1900;
        pvigenciaCuponera.setText(fechaCompuesta);
        descuentoCuponera.setText(Integer.toString(cup.getDescuento()) + " %");
        txaDescripcionCuponera.setText(cup.getDescripcion());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        dragBar = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnExitBG = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scrollCuponera = new javax.swing.JScrollPane();
        txaDescripcionCuponera = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        descuentoCuponera = new javax.swing.JLabel();
        pvigenciaCuponera = new javax.swing.JLabel();
        nombreCuponera = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlConsultar = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        cmbActividades = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 520));
        setMinimumSize(new java.awt.Dimension(500, 520));
        setUndecorated(true);

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(4, 37, 58));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Información de la Cuponera");
        bgPanel.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 29));

        dragBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragBarMouseDragged(evt);
            }
        });
        dragBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragBarMousePressed(evt);
            }
        });
        bgPanel.add(dragBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 20));

        btnMinimizarBG.setBackground(java.awt.Color.lightGray);

        btnMinimizar.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimizar.setText("-");
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnMinimizarBGLayout = new javax.swing.GroupLayout(btnMinimizarBG);
        btnMinimizarBG.setLayout(btnMinimizarBGLayout);
        btnMinimizarBGLayout.setHorizontalGroup(
            btnMinimizarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        btnMinimizarBGLayout.setVerticalGroup(
            btnMinimizarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        bgPanel.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 20));

        btnExitBG.setBackground(new java.awt.Color(174, 0, 51));

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setText("X");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnExitBGLayout = new javax.swing.GroupLayout(btnExitBG);
        btnExitBG.setLayout(btnExitBGLayout);
        btnExitBGLayout.setHorizontalGroup(
            btnExitBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnExitBGLayout.setVerticalGroup(
            btnExitBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bgPanel.add(btnExitBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 0, 0, new java.awt.Color(76, 131, 122)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollCuponera.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txaDescripcionCuponera.setEditable(false);
        txaDescripcionCuponera.setColumns(20);
        txaDescripcionCuponera.setLineWrap(true);
        txaDescripcionCuponera.setRows(5);
        txaDescripcionCuponera.setBorder(null);
        scrollCuponera.setViewportView(txaDescripcionCuponera);

        jPanel1.add(scrollCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 156, 230, 90));

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripción");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, -1));

        jLabel3.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descuento");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        descuentoCuponera.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        descuentoCuponera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descuentoCuponera.setText("xxxxxxxxxxxxxxx");
        jPanel1.add(descuentoCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 260, 20));

        pvigenciaCuponera.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        pvigenciaCuponera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pvigenciaCuponera.setText("xxxxxxxxxxxxxxx");
        jPanel1.add(pvigenciaCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 260, 20));

        nombreCuponera.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        nombreCuponera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCuponera.setText("xxxxxxxxxxxxxxx");
        jPanel1.add(nombreCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 260, 20));

        jLabel4.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, -1));

        jLabel6.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fecha de Vencimiento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        bgPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 450, 250));

        pnlConsultar.setBackground(new java.awt.Color(255, 255, 255));
        pnlConsultar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConsultar.setBackground(new java.awt.Color(76, 131, 122));
        btnConsultar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar Información de la Actividad");
        btnConsultar.setToolTipText("");
        btnConsultar.setBorder(null);
        btnConsultar.setFocusPainted(false);
        btnConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarMouseClicked(evt);
            }
        });
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnlConsultar.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 310, 40));

        cmbActividades.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        cmbActividades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Item" }));
        cmbActividades.setFocusable(false);
        cmbActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbActividadesActionPerformed(evt);
            }
        });
        pnlConsultar.add(cmbActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 220, -1));

        jLabel1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actividades Asociadas");
        pnlConsultar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 180, -1));

        bgPanel.add(pnlConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 430, 170));

        lblError.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgPanel.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 500, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActividadesActionPerformed

    }//GEN-LAST:event_cmbActividadesActionPerformed

    private void dragBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_dragBarMouseDragged

    private void dragBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragBarMousePressed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
            Object selectedItem = cmbActividades.getSelectedItem();

            if (selectedItem != null){
                    int actAbuscar = Integer.parseInt(((ComboItem)selectedItem).getId());
                    actividades.forEach((currentDT) -> {
                        if (currentDT.getActividad().getId() == actAbuscar){
                            showActividadInfoForm formInfo = new showActividadInfoForm(currentDT.getActividad());
                            if (!formInfo.isVisible()) {
                                formInfo.setVisible(true);
                            }
                        }
                    });
            }
    }//GEN-LAST:event_btnConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(showInfoCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showInfoCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showInfoCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showInfoCuponera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showInfoCuponera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel btnExit;
    private javax.swing.JPanel btnExitBG;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel btnMinimizarBG;
    private javax.swing.JComboBox<String> cmbActividades;
    private javax.swing.JLabel descuentoCuponera;
    private javax.swing.JLabel dragBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel nombreCuponera;
    private javax.swing.JPanel pnlConsultar;
    private javax.swing.JLabel pvigenciaCuponera;
    private javax.swing.JScrollPane scrollCuponera;
    private javax.swing.JTextArea txaDescripcionCuponera;
    // End of variables declaration//GEN-END:variables
}
