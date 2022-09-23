/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mygym.presentacion.pages;

import java.io.File;

import Institucion.DtInstitucion;
import Institucion.InstitucionBO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import mygym.presentacion.institucion.AddInstitucionForm;
import utils.BrowseFile;
import utils.RenderFoto;

/**
 *
 * @author maximilianooliverasilva
 */
public class Instituciones extends javax.swing.JPanel {

    /**
     * Creates new form Instituciones
     */
    InstitucionBO inst = new InstitucionBO();
    int iterador;
    public Instituciones() {
        initComponents();
        listado();
        
        
    }
    
    public void listado() {
        RenderFoto photoCell = new RenderFoto();
        photoCell.setHorizontalAlignment(SwingConstants.CENTER);
        tablaInstituciones.getColumnModel().getColumn(0).setCellRenderer(photoCell);
        tablaInstituciones.setRowHeight(50);
        inst.listarInstituciones().forEach((Integer key, DtInstitucion ins)->{
            DtInstitucion indt = new DtInstitucion(ins.getId(), ins.getNombre(), ins.getDescripcion(), ins.getUrl(), null, null, ins.getImage());
            tablaInstituciones.setValueAt(indt.getNombre(), iterador, 1);
            tablaInstituciones.setValueAt(indt.getDescripcion(), iterador, 2);
            tablaInstituciones.setValueAt(indt.getUrl(), iterador, 3);
            if (indt.getImage() != null) {
                tablaInstituciones.setValueAt(indt.getImage().getAbsolutePath(), iterador, 0);
            }
            iterador++;
        });  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaInstituciones = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(215, 215, 215)));

        addButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarButton.jpg"))); // NOI18N
        addButton.setToolTipText("");
        addButton.setBorder(null);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 69, 87));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Instituciones");

        scrollTabla.setBackground(new java.awt.Color(255, 255, 255));
        scrollTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        scrollTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablaInstituciones.setAutoCreateRowSorter(true);
        tablaInstituciones.setBackground(new java.awt.Color(233, 233, 233));
        tablaInstituciones.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        tablaInstituciones.setModel(new javax.swing.table.DefaultTableModel(
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
                "Foto", "Nombre de Institucion", "Descripcion", "Url"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInstituciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaInstituciones.setGridColor(new java.awt.Color(255, 255, 255));
        tablaInstituciones.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tablaInstituciones.setUpdateSelectionOnSort(false);
        scrollTabla.setViewportView(tablaInstituciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(247, 247, 247)
                .addComponent(addButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addButton)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddInstitucionForm newframe = new AddInstitucionForm();
        
        newframe.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                tablaInstituciones.removeAll();
                iterador = 0;
                listado();
            }
        });
        
        newframe.setVisible(true);
        
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaInstituciones;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
