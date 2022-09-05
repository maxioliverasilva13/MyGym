/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mygym.presentacion.pages;

import Institucion.InstitucionBO;
import Cuponera.CuponeraBo;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import Institucion.DtInstitucion;
import javax.swing.DefaultComboBoxModel;
import mygym.presentacion.forms.createActividadForm;
import mygym.presentacion.forms.showActividadInfoForm;
import utils.ComboItem;
import Actividad.ActividadBO;
import Actividad.dtos.ActividadDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author maximilianooliverasilva
 */
public class Actividades extends javax.swing.JPanel {
    createActividadForm formCreate = new createActividadForm();
    //showActividadInfoForm formInfo = new showActividadInfoForm();
    DefaultComboBoxModel model = new DefaultComboBoxModel();

    InstitucionBO insBO = new InstitucionBO();
    ActividadBO actBO = new ActividadBO();

    public static HashMap<Integer, ActividadDTO> actividadesSistema = new HashMap<>(); 
    public static HashMap<Integer, DtInstitucion> institucionesSistema = new HashMap<>(); 
    
    
    /**
     * Creates new form Actividades
     */
    public Actividades() {
        initComponents();
        
        tablaActividades.getColumnModel().getColumn(0).setMinWidth(0);
        tablaActividades.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaActividades.getColumnModel().getColumn(0).setWidth(0);
        tablaActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        llenarCBoxInstituciones();
        cmbInstituciones.setSelectedItem(null);
    
        cmbInstituciones.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = cmbInstituciones.getSelectedItem();
                if (selectedItem != null) {
                    llenarTabla(Integer.parseInt(((ComboItem)selectedItem).getId()));
                }
            }
        });
        
        formCreate.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                Object selectedItem = cmbInstituciones.getSelectedItem();
                if (selectedItem != null) {
                    llenarTabla(Integer.parseInt(((ComboItem)selectedItem).getId()));
                }
            }
        });
    }
    
 
    public void llenarTabla(Integer idInstitucion){
        try {
            DefaultTableModel modeloDatos = (DefaultTableModel) tablaActividades.getModel();
            actividadesSistema = actBO.listarActividades(idInstitucion);
            modeloDatos.setRowCount(0);
            actividadesSistema.forEach((key, value) -> {
                ActividadDTO currentActividad = actividadesSistema.get(key);

                modeloDatos.addRow(new Object[]{currentActividad.getId(), currentActividad.getNombre(), currentActividad.getDescripcion(), currentActividad.getCosto()});
            });
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarCBoxInstituciones(){
        DefaultTableModel modeloDatos = (DefaultTableModel) tablaActividades.getModel();
        modeloDatos.setRowCount(0);
        cmbInstituciones.removeAllItems();
        institucionesSistema = insBO.listarInstituciones();
        
        institucionesSistema.forEach((key, value) -> {
            DtInstitucion currentInstitucion = institucionesSistema.get(key);
            model.addElement(new ComboItem(key.toString(), currentInstitucion.getNombre()));
        });
        cmbInstituciones.setModel(model);
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
        jLabel1 = new javax.swing.JLabel();
        cmbInstituciones = new javax.swing.JComboBox<>();
        btnAltaBG = new javax.swing.JPanel();
        btnAlta = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaActividades = new javax.swing.JTable();
        btnInfoBG = new javax.swing.JPanel();
        btnInfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bgPanelFocusGained(evt);
            }
        });
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 69, 87));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actividades");
        bgPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        cmbInstituciones.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        cmbInstituciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Instituciones" }));
        cmbInstituciones.setBorder(null);
        bgPanel.add(cmbInstituciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 240, 40));

        btnAltaBG.setBackground(new java.awt.Color(76, 131, 122));

        btnAlta.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnAlta.setForeground(new java.awt.Color(255, 255, 255));
        btnAlta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAlta.setText("Alta de Actividad");
        btnAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAltaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAltaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAltaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnAltaBGLayout = new javax.swing.GroupLayout(btnAltaBG);
        btnAltaBG.setLayout(btnAltaBGLayout);
        btnAltaBGLayout.setHorizontalGroup(
            btnAltaBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        btnAltaBGLayout.setVerticalGroup(
            btnAltaBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAltaBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bgPanel.add(btnAltaBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 160, -1));

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

        bgPanel.add(scrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 640, 350));

        btnInfoBG.setBackground(new java.awt.Color(76, 131, 122));

        btnInfo.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInfo.setText("CONSULTAR INFORMACIÓN");
        btnInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInfoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInfoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnInfoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnInfoBGLayout = new javax.swing.GroupLayout(btnInfoBG);
        btnInfoBG.setLayout(btnInfoBGLayout);
        btnInfoBGLayout.setHorizontalGroup(
            btnInfoBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
        btnInfoBGLayout.setVerticalGroup(
            btnInfoBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInfoBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bgPanel.add(btnInfoBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 330, -1));

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Seleccione una Institución");
        bgPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAltaMouseClicked
        if (!formCreate.isVisible()) {
            formCreate.setVisible(true);
        }
    }//GEN-LAST:event_btnAltaMouseClicked

    private void btnAltaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAltaMousePressed
        btnAltaBG.setBackground(new Color(103, 149, 142));
    }//GEN-LAST:event_btnAltaMousePressed

    private void btnAltaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAltaMouseReleased
        btnAltaBG.setBackground(new Color(76,131,122));
    }//GEN-LAST:event_btnAltaMouseReleased

    private void bgPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bgPanelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bgPanelFocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        //llenarTabla();
    }//GEN-LAST:event_formFocusGained

    private void btnInfoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoMouseReleased
        btnInfoBG.setBackground(new Color(76,131,122));
    }//GEN-LAST:event_btnInfoMouseReleased

    private void btnInfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoMousePressed
        btnInfoBG.setBackground(new Color(103, 149, 142));
    }//GEN-LAST:event_btnInfoMousePressed

    private void btnInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInfoMouseClicked

        int selectedRowId = tablaActividades.getSelectedRow();
        if(selectedRowId == -1){
            JOptionPane.showMessageDialog(new JFrame(), "Error, seleccione una actividad existente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Object idObj = tablaActividades.getValueAt(selectedRowId, 0);
        int selectedActividadID = (Integer) idObj;
        ActividadDTO selectedAct = actividadesSistema.get(selectedActividadID); // PASARLE ESTE DT POR EL CONSTRUCTOR DEL FORM
        if (selectedAct != null){
            showActividadInfoForm formInfo = new showActividadInfoForm(selectedActividadID);
            if (!formInfo.isVisible()) {
                formInfo.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Error, seleccione una actividad existente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
/*
        int selectedRowId = tablaActividades.getSelectedRow();

        DtActividad selectedActividad = actividadesSistema.get(selectedRowId);
        // = new DtCuponera(selectedCuponera.getNombre(), selectedCuponera.getDescripcion(), selectedCuponera.getFechaVigencia(), selectedCuponera.getDescuento());
        if (selectedActividad != null){
            //JOptionPane.showMessageDialog(new JFrame(), "Actividad seleccionada: " + selectedActividad.getNombre(), "Información de Selección", JOptionPane.INFORMATION_MESSAGE);
            if (!formInfo.isVisible()) {
                formInfo.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Error, seleccione una actividad existente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
*/
    }//GEN-LAST:event_btnInfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel btnAlta;
    private javax.swing.JPanel btnAltaBG;
    private javax.swing.JLabel btnInfo;
    private javax.swing.JPanel btnInfoBG;
    private javax.swing.JComboBox<String> cmbInstituciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaActividades;
    // End of variables declaration//GEN-END:variables
}
