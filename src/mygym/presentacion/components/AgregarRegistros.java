/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.components;

import Actividad.ActividadBO;
import Actividad.dtos.ActividadDTO;
import Institucion.DtInstitucion;
import Institucion.InstitucionBO;
import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.WindowConstants;
import javax.swing.plaf.metal.MetalButtonUI;
import ParseDate.ParseDate;
import Socio.SocioBO;
import Socio.dtos.SocioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import mygym.presentacion.pages.Instituciones;

/**
 *
 * @author maximilianooliverasilva
 */
public class AgregarRegistros extends javax.swing.JFrame {

    /**
     * Creates new form AgregarRegistros
     */
    boolean isInitialized = false;
    ParseDate pd = new ParseDate();
    InstitucionBO insBo = new InstitucionBO();
    ActividadBO actBo = new ActividadBO();
    SocioBO socBo = new SocioBO();

    HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
    HashMap<Integer, DtInstitucion> instituciones = new HashMap<>();
    HashMap<Integer, SocioDTO> socios = new HashMap<>();
    int selectedInstitucionId;
    int selectedActividadId;
    int selectedSocioId;
    
    private void llenarComboboxInstituciones() {
        jComboInstitucion.removeAllItems();
        instituciones = insBo.listarInstituciones();
        instituciones.forEach((Integer key, DtInstitucion inst) -> {
            jComboInstitucion.addItem(inst.getNombre());
        });
        jComboInstitucion.setEnabled(true);
    }
    
    private void llenarComboboxSocios() {
        jComboSocios.removeAllItems();
        socios = socBo.listar();
        socios.forEach((Integer key, SocioDTO soc) -> {
            jComboSocios.addItem(soc.getNombre());
        });
        jComboSocios.setEnabled(true);
    }
    
    public void initSteps() {
        step1.setVisible(false);
        step2.setVisible(false);
        step4.setVisible(false);
        step3.setVisible(false);
    }
    
    public void initCalendar() {
        List<LocalDate> lista = new ArrayList<>();
        
        
        lista.add(LocalDate.parse("2022-09-03"));
        lista.add(LocalDate.parse("2022-09-04"));
        lista.add(LocalDate.parse("2022-10-04"));
        lista.add(LocalDate.parse("2023-01-22"));
        this.calendar.setAction((ActionEvent e) -> {
            System.out.println("Example");
        });
        this.calendar.setList(lista);
    }
    
    public AgregarRegistros() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        setText();
        initSteps();
        initCalendar();
        llenarComboboxInstituciones();
        llenarComboboxSocios();
        
    }
    
    public void nextStep() {
        if (!step1.isVisible() && !step2.isVisible() && !step4.isVisible() && !step3.isVisible()) {
            initSteps();
            step1.setVisible(true);
            return;
        }
        if (!step2.isVisible() && step1.isVisible() && !step4.isVisible() && !step3.isVisible()) {
            initSteps();
            step2.setVisible(true);
            return;
        }
        if (!step1.isVisible() && step2.isVisible() && !step4.isVisible() && !step3.isVisible()) {
            initSteps();
            step3.setVisible(true);
            return;
        }
        if (!step1.isVisible() && !step2.isVisible() && step3.isVisible() && !step4.isVisible()) {
            initSteps();
            step4.setVisible(true);
            return;
        }
        if (!step1.isVisible() && !step2.isVisible() && !step3.isVisible() && step4.isVisible()) {
            initSteps();
            step1.setVisible(true);
            return;
        }
        
    }
    
    public void setText() {
        next.setForeground(new Color(0,153,153));
        next.setOpaque(true);
        next.setBorder(null);
        next.repaint();
        back.repaint();

        if (isInitialized) {
            next.setText("Next");
            next.setForeground(Color.WHITE);
            back.setEnabled(true);
            nextStep();
        } else {
            next.setText("Iniciar");
            next.setForeground(Color.WHITE);
            back.setEnabled(false);
            back.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.WHITE;
            }
        }); 
        }
        
    }
    
    public void backStep() {
        if (step1.isVisible() && !step2.isVisible() && !step3.isVisible() && !step4.isVisible()) {
            initSteps();
            step4.setVisible(true);
            return;
        }
        if (step2.isVisible() && !step1.isVisible() && !step4.isVisible() && !step3.isVisible()) {
            initSteps();
            step1.setVisible(true);
            return;
        }
        if (step3.isVisible() && !step1.isVisible() && !step4.isVisible() && !step2.isVisible()) {
            initSteps();
            step2.setVisible(true);
            return;
        }
        if (step4.isVisible() && !step1.isVisible() && !step2.isVisible() && !step3.isVisible()) {
            initSteps();
            step3.setVisible(true);
            return;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        step1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboInstitucion = new javax.swing.JComboBox<>();
        step3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboSocios = new javax.swing.JComboBox<>();
        step2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboActividad = new javax.swing.JComboBox<>();
        step4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        calendar = new main.CalendarCustom();
        next = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(780, 710));
        setPreferredSize(new java.awt.Dimension(780, 850));
        setResizable(false);
        setSize(new java.awt.Dimension(780, 850));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Agregar Registro de Clase");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        step1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        step1.setForeground(new java.awt.Color(0, 153, 153));
        step1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                step1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                step1FocusLost(evt);
            }
        });
        step1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Seleccione una Institucion");
        step1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jComboInstitucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboInstitucionActionPerformed(evt);
            }
        });
        step1.add(jComboInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 30));

        getContentPane().add(step1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 320, 70));

        step3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        step3.setForeground(new java.awt.Color(0, 153, 153));
        step3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Seleccione un socio");
        step3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jComboSocios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboSociosActionPerformed(evt);
            }
        });
        step3.add(jComboSocios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 30));

        getContentPane().add(step3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 320, 70));

        step2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        step2.setForeground(new java.awt.Color(0, 153, 153));
        step2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Seleccione una Actividad");
        step2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jComboActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboActividadActionPerformed(evt);
            }
        });
        step2.add(jComboActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 30));

        getContentPane().add(step2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 320, 70));

        step4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        step4.setForeground(new java.awt.Color(0, 153, 153));
        step4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Seleccione una Clase Disponible");
        step4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        step4.add(calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 720, 340));

        getContentPane().add(step4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 730, 380));

        next.setBackground(new java.awt.Color(0, 153, 153));
        next.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("Next");
        next.setToolTipText("");
        next.setActionCommand("");
        next.setBorder(null);
        next.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        next.setName(""); // NOI18N
        next.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 760, 100, 30));

        back.setBackground(new java.awt.Color(0, 153, 153));
        back.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setToolTipText("");
        back.setBorder(null);
        back.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        back.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void step1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_step1FocusGained
        System.out.println("I am focus");
        // TODO add your handling code here:
    }//GEN-LAST:event_step1FocusGained

    private void step1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_step1FocusLost
        System.out.println("I am focus 2");
        // TODO add your handling code here:
    }//GEN-LAST:event_step1FocusLost

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked

    }//GEN-LAST:event_nextMouseClicked

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (isInitialized) {
            nextStep();
        } else {
            isInitialized = true;
            setText();
        }
    }//GEN-LAST:event_nextActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        backStep();
    // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void jComboActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboActividadActionPerformed
        Object selectedItem = this.jComboActividad.getSelectedItem();
        if (selectedItem != null) {
            String selectedActName = selectedItem.toString();
            actividades.forEach((Integer key, ActividadDTO ac) -> {
                if (ac.getNombre().equals(selectedActName) && selectedActividadId != ac.getId()) {
                    this.selectedActividadId = ac.getId();
                }
            });
            // this.llenarActividades();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboActividadActionPerformed

    private void jComboInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboInstitucionActionPerformed
        Object selectedItem = this.jComboInstitucion.getSelectedItem();
        if (selectedItem != null) {
            String selectedInstName = selectedItem.toString();
            instituciones.forEach((Integer key, DtInstitucion i) -> {
                if (i.getNombre().equals(selectedInstName) && selectedInstitucionId != i.getId()) {
                    this.selectedInstitucionId = i.getId();
                }
            });
            this.llenarActividades();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboInstitucionActionPerformed

    private void jComboSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboSociosActionPerformed
        Object selectedItem = this.jComboSocios.getSelectedItem();
        if (selectedItem != null) {
            String selectedSocName = selectedItem.toString();
            socios.forEach((Integer key, SocioDTO soc) -> {
                if (soc.getNombre().equals(selectedSocName) && selectedActividadId != soc.getId()) {
                    this.selectedSocioId = soc.getId();
                }
            });
            // this.llenarActividades();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jComboSociosActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void llenarActividades() {
        this.jComboActividad.removeAllItems();
        actividades = actBo.listarActividades(this.selectedInstitucionId);
        actividades.forEach((Integer key, ActividadDTO actividad) -> {
            this.jComboActividad.addItem(actividad.getNombre());
        });
        this.jComboActividad.setEnabled(true);
    }
    
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
            java.util.logging.Logger.getLogger(AgregarRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private main.CalendarCustom calendar;
    private javax.swing.JComboBox<String> jComboActividad;
    private javax.swing.JComboBox<String> jComboInstitucion;
    private javax.swing.JComboBox<String> jComboSocios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton next;
    private javax.swing.JPanel step1;
    private javax.swing.JPanel step2;
    private javax.swing.JPanel step3;
    private javax.swing.JPanel step4;
    // End of variables declaration//GEN-END:variables
}
