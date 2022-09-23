/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mygym.presentacion.pages;

import Categoria.CategoriaBO;
import Categoria.DtCategoria;
import java.util.HashMap;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import mygym.presentacion.forms.AddCategoriaForm;

/**
 *
 * @author maximilianooliverasilva
 */
public class Categorias extends javax.swing.JPanel {

    CategoriaBO catBo = new CategoriaBO();
    public static HashMap<Integer, DtCategoria> categorias = new HashMap<>();
    

    public Categorias() {
        initComponents();
        tablaCategorias.getColumnModel().getColumn(0).setMinWidth(0);
        tablaCategorias.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaCategorias.getColumnModel().getColumn(0).setWidth(0);
        tablaCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        llenarTabla();
        
        
    }

    
    private void llenarTabla(){
        categorias = catBo.listarCategorias();
        DefaultTableModel modeloDatos = (DefaultTableModel) tablaCategorias.getModel();
        modeloDatos.setRowCount(0);
        categorias.forEach((key, value) -> {
            DtCategoria currentCat = categorias.get(key);

            modeloDatos.addRow(new Object[]{currentCat.getId(), currentCat.getNombre()});
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

        pnlHeader = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAltaCategoria = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(720, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(215, 215, 215)));
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 69, 87));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categorias");
        pnlHeader.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        btnAltaCategoria.setBackground(new java.awt.Color(76, 131, 122));
        btnAltaCategoria.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnAltaCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnAltaCategoria.setText("Alta de Categoria");
        btnAltaCategoria.setToolTipText("");
        btnAltaCategoria.setBorder(null);
        btnAltaCategoria.setFocusPainted(false);
        btnAltaCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAltaCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAltaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaCategoriaActionPerformed(evt);
            }
        });
        pnlHeader.add(btnAltaCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 160, 40));

        scrollTabla.setBackground(new java.awt.Color(255, 255, 255));
        scrollTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        scrollTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablaCategorias.setAutoCreateRowSorter(true);
        tablaCategorias.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaCategorias.setGridColor(new java.awt.Color(255, 255, 255));
        tablaCategorias.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tablaCategorias.setShowGrid(false);
        tablaCategorias.setUpdateSelectionOnSort(false);
        scrollTabla.setViewportView(tablaCategorias);

        pnlHeader.add(scrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 640, 350));

        add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaCategoriaActionPerformed
        AddCategoriaForm formAlta = new AddCategoriaForm();
        formAlta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                llenarTabla();
            }
        });
        if (!formAlta.isVisible()) {
            formAlta.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAltaCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaCategoria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaCategorias;
    // End of variables declaration//GEN-END:variables
}