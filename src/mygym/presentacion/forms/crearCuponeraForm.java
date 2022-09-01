/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.forms;

import Cuponera.CuponeraBo;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.raven.datechooser.SelectedDate;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import Cuponera.DtCuponera;
import ParseDate.ParseDate;
import mygym.presentacion.pages.Cuponeras;

/**
 *
 * @author mandi
 */
public class crearCuponeraForm extends javax.swing.JFrame{

    int xMouse, yMouse;
    Color gris = new Color(204,204,204);
    CuponeraBo cupBo = new CuponeraBo();
    ParseDate parse = new ParseDate();
    
    public crearCuponeraForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getOwner();
        this.requestFocusInWindow(true);
        separatorNombre.setForeground(gris);
        separatorDescuento.setForeground(gris);
        scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(gris));
        txtNombre.setText("");
        txtDescuento.setText("");
        txtareaDescripcion.setText("");
        
        
        txtDescuento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                     e.consume();  // if it's not a number, ignore the event
                }
            }
         });
        
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
              char c = e.getKeyChar();
                 if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                  e.consume();  // ignore the event if it's not an alphabet
              }
             }
          });
        txtInicio.enable(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserActual = new com.raven.datechooser.DateChooser();
        dateChooserFin = new com.raven.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        separatorNombre = new javax.swing.JSeparator();
        lblDescuento = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        separatorDescuento = new javax.swing.JSeparator();
        lblDescripcion = new javax.swing.JLabel();
        scrollDescr = new javax.swing.JScrollPane();
        txtareaDescripcion = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtInicio = new javax.swing.JTextField();
        txtFin = new javax.swing.JTextField();
        separatorFInicio = new javax.swing.JSeparator();
        separatorFfin = new javax.swing.JSeparator();
        btnCrearBG = new javax.swing.JPanel();
        btnCrear = new javax.swing.JLabel();
        dragBar = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnExitBG = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();

        dateChooserActual.setEnabled(false);
        dateChooserActual.setFocusable(false);
        dateChooserActual.setTextRefernce(txtInicio);

        dateChooserFin.setTextRefernce(txtFin);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear cuponera");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 540));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(4, 37, 58));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Alta de Cuponera");
        jPanel2.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 500, 29));

        lblNombre.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 90, 30));

        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 210, 30));
        jPanel2.add(separatorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 210, 20));

        lblDescuento.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblDescuento.setText("Descuento (%)");
        jPanel2.add(lblDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 90, 30));

        txtDescuento.setToolTipText("");
        txtDescuento.setBorder(null);
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });
        jPanel2.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 210, 30));
        jPanel2.add(separatorDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 210, 20));

        lblDescripcion.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblDescripcion.setText("Descripción");
        jPanel2.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 80, 30));

        scrollDescr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 249, 248)));

        txtareaDescripcion.setColumns(20);
        txtareaDescripcion.setLineWrap(true);
        txtareaDescripcion.setRows(5);
        txtareaDescripcion.setBorder(null);
        scrollDescr.setViewportView(txtareaDescripcion);

        jPanel2.add(scrollDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 320, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Período de Vigencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dubai", 0, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha Actual");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, -1));

        jLabel6.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Fin");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txtInicio.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        txtInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtInicio.setBorder(null);
        txtInicio.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInicioActionPerformed(evt);
            }
        });
        jPanel1.add(txtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, 20));
        txtFin.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        txtFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFin.setBorder(null);
        jPanel1.add(txtFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 140, 20));
        jPanel1.add(separatorFInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 20));
        jPanel1.add(separatorFfin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 140, 20));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 320, 120));

        btnCrearBG.setBackground(new java.awt.Color(76, 131, 122));

        btnCrear.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrear.setText("Crear");
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnCrearBGLayout = new javax.swing.GroupLayout(btnCrearBG);
        btnCrearBG.setLayout(btnCrearBGLayout);
        btnCrearBGLayout.setHorizontalGroup(
            btnCrearBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCrearBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnCrearBGLayout.setVerticalGroup(
            btnCrearBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCrearBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(btnCrearBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, -1, -1));

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
        jPanel2.add(dragBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 20));

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
            .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        btnMinimizarBGLayout.setVerticalGroup(
            btnMinimizarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
        );

        jPanel2.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 20));

        btnExitBG.setBackground(new java.awt.Color(174, 0, 51));

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setText("X");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(btnExitBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        boolean error = false;
        // Control de campo NOMBRE vacío.
        if (txtNombre.getText().equals("")){
            separatorNombre.setForeground(Color.red);
            error=true;
        }
        
        // Control de campo DESCUENTO vacío.
        if (txtDescuento.getText().equals("")){
            separatorDescuento.setForeground(Color.red);
            error=true;
        }else{
            int descuento = Integer.parseInt(txtDescuento.getText());
            if (descuento > 99 || descuento < 1) {
                JOptionPane.showMessageDialog(new JFrame(), "El descuento debe ser entre 1 y 99.", "Error", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }
        
        // Control de campo DESCRIPCIÓN vacío.
        if (txtareaDescripcion.getText().equals("")){
            scrollDescr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
            scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            error=true;
        }
        
        if (error){ // para que no llegue a validar fecha hasta que se resuelvan antes todos los campos vacíos.
            return;
        }
        SelectedDate actual = dateChooserActual.getSelectedDate();
        SelectedDate fechafin = dateChooserFin.getSelectedDate();
        
        // Validación campo fecha fin
        if (fechafin.getYear() < actual.getYear() 
          || ((fechafin.getYear() == actual.getYear() && fechafin.getMonth() == actual.getMonth()) && (fechafin.getDay() < actual.getDay())) 
          || (fechafin.getYear() == actual.getYear() && fechafin.getMonth() < actual.getMonth())
          || (fechafin.getYear() == actual.getYear() && fechafin.getMonth() == actual.getMonth() && fechafin.getDay() == actual.getDay())){
            JOptionPane.showMessageDialog(new JFrame(), "Fecha de vencimiento inválida.", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        if (!error){
            // Parseo al formato de la BD:
            Date ffin = parse.parseDate(fechafin.getYear() + "-" + fechafin.getMonth() + "-" + fechafin.getDay());
            
            //    TODO: MODIFICAR ID DINÁMICO?
            DtCuponera cup = new DtCuponera(0, txtNombre.getText(), txtareaDescripcion.getText(), ffin, Integer.parseInt(txtDescuento.getText()), null);
            
            try{
                cupBo.agregarCuponera(cup);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            txtNombre.setText("");
            txtDescuento.setText("");
            txtareaDescripcion.setText("");
            separatorNombre.setForeground(gris);
            separatorDescuento.setForeground(gris);
            scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(gris));
            JOptionPane.showMessageDialog(new JFrame(), "Cuponera registrada con éxito!", "Información", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnCrearMouseClicked

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
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void txtInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInicioActionPerformed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoKeyTyped

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
            java.util.logging.Logger.getLogger(crearCuponeraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crearCuponeraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crearCuponeraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crearCuponeraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crearCuponeraForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCrear;
    private javax.swing.JPanel btnCrearBG;
    private javax.swing.JLabel btnExit;
    private javax.swing.JPanel btnExitBG;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel btnMinimizarBG;
    private com.raven.datechooser.DateChooser dateChooserActual;
    private com.raven.datechooser.DateChooser dateChooserFin;
    private javax.swing.JLabel dragBar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JScrollPane scrollDescr;
    private javax.swing.JSeparator separatorDescuento;
    private javax.swing.JSeparator separatorFInicio;
    private javax.swing.JSeparator separatorFfin;
    private javax.swing.JSeparator separatorNombre;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtareaDescripcion;
    // End of variables declaration//GEN-END:variables
}
