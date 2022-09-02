/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mygym.presentacion.pages;
import mygym.presentacion.forms.crearCuponeraForm;
import java.awt.Color;
import mygym.presentacion.forms.addActividadtoCuponera;
import java.util.Date;
import java.util.HashMap; // Eliminar
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mygym.logica.usuario.dataTypes.DtCuponera;
// import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maximilianooliverasilva
 */
public class Cuponeras extends javax.swing.JPanel {

    crearCuponeraForm formCrear = new crearCuponeraForm();
    addActividadtoCuponera formAgregar = new addActividadtoCuponera();
    public static HashMap<Integer, DtCuponera> cuponeras = new HashMap<Integer, DtCuponera>();
    
    public Cuponeras() {
        initComponents();
        //scrollTabla.setVisible(false);
        //btnAgregar.setVisible(false);
        //btnAgregarBG.setVisible(false);
        llenarTabla();
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
        btnCrearBG = new javax.swing.JPanel();
        btnCrear = new javax.swing.JLabel();
        btnActualizarCuponerasBG = new javax.swing.JPanel();
        btnActualizarCuponeras = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaCuponeras = new javax.swing.JTable();
        btnAgregarBG = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 540));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(41, 69, 87));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Cuponeras");
        bgPanel.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        btnCrearBG.setBackground(new java.awt.Color(76, 131, 122));

        btnCrear.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrear.setText("Crear");
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCrearMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCrearMouseReleased(evt);
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

        bgPanel.add(btnCrearBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        btnActualizarCuponerasBG.setBackground(new java.awt.Color(76, 131, 122));

        btnActualizarCuponeras.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnActualizarCuponeras.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCuponeras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarCuponeras.setText("Actualizar Lista");
        btnActualizarCuponeras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarCuponeras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarCuponerasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnActualizarCuponerasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnActualizarCuponerasMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnActualizarCuponerasBGLayout = new javax.swing.GroupLayout(btnActualizarCuponerasBG);
        btnActualizarCuponerasBG.setLayout(btnActualizarCuponerasBGLayout);
        btnActualizarCuponerasBGLayout.setHorizontalGroup(
            btnActualizarCuponerasBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnActualizarCuponerasBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnActualizarCuponeras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnActualizarCuponerasBGLayout.setVerticalGroup(
            btnActualizarCuponerasBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnActualizarCuponerasBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnActualizarCuponeras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bgPanel.add(btnActualizarCuponerasBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        scrollTabla.setBackground(new java.awt.Color(255, 255, 255));
        scrollTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        scrollTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablaCuponeras.setAutoCreateRowSorter(true);
        tablaCuponeras.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        tablaCuponeras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Descripción", "Descuento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCuponeras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaCuponeras.setGridColor(new java.awt.Color(255, 255, 255));
        tablaCuponeras.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tablaCuponeras.setShowGrid(false);
        tablaCuponeras.setUpdateSelectionOnSort(false);
        scrollTabla.setViewportView(tablaCuponeras);
        if (tablaCuponeras.getColumnModel().getColumnCount() > 0) {
            tablaCuponeras.getColumnModel().getColumn(0).setResizable(false);
            tablaCuponeras.getColumnModel().getColumn(1).setResizable(false);
            tablaCuponeras.getColumnModel().getColumn(2).setResizable(false);
        }

        bgPanel.add(scrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 630, 400));

        btnAgregarBG.setBackground(new java.awt.Color(76, 131, 122));

        btnAgregar.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar.setText("Agregar Actividad a la Cuponera");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAgregarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnAgregarBGLayout = new javax.swing.GroupLayout(btnAgregarBG);
        btnAgregarBG.setLayout(btnAgregarBGLayout);
        btnAgregarBGLayout.setHorizontalGroup(
            btnAgregarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
        btnAgregarBGLayout.setVerticalGroup(
            btnAgregarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregarBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bgPanel.add(btnAgregarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 330, -1));

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

    public void llenarTabla(){
        DefaultTableModel modeloDatos = (DefaultTableModel) tablaCuponeras.getModel();
        for (int i = 0; i < cuponeras.size(); i++){
            DtCuponera currentCuponera = cuponeras.get(i);
            //modeloDatos.addRow(new Object [] {currentCuponera.getNombre(), currentCuponera.getDescripcion(), currentCuponera.getDescuento()});           
            modeloDatos.setValueAt(currentCuponera.getNombre(), i, 0);
            modeloDatos.setValueAt(currentCuponera.getDescripcion(), i, 1);
            modeloDatos.setValueAt(currentCuponera.getDescuento(), i, 2);
        }
    }
    
    
    public static void agregarElemTabla(DtCuponera x){
        int idHashMap = cuponeras.size();
        cuponeras.put(idHashMap, x);
    }

    
    public void refreshCuponeras(){
        tablaCuponeras.repaint();
    }

    
    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        if (!formCrear.isVisible()) {
                // Focus LOST para el form.
                formCrear.setVisible(true);
                //formCrear.transferFocus();
        }
    }//GEN-LAST:event_btnCrearMouseClicked

    private void btnActualizarCuponerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCuponerasMouseClicked
        llenarTabla(); 
    }//GEN-LAST:event_btnActualizarCuponerasMouseClicked

    private void btnCrearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMousePressed
        btnCrearBG.setBackground(new Color(103, 149, 142));
    }//GEN-LAST:event_btnCrearMousePressed

    private void btnCrearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseReleased
        btnCrearBG.setBackground(new Color(76,131,122));
    }//GEN-LAST:event_btnCrearMouseReleased

    private void btnActualizarCuponerasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCuponerasMousePressed
        btnActualizarCuponerasBG.setBackground(new Color(103, 149, 142));
    }//GEN-LAST:event_btnActualizarCuponerasMousePressed

    private void btnActualizarCuponerasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCuponerasMouseReleased
        btnActualizarCuponerasBG.setBackground(new Color(76,131,122));
    }//GEN-LAST:event_btnActualizarCuponerasMouseReleased

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // ABRE SUB-FORM CON LAS INSTITUCIONES.
        //DefaultTableModel modelo = (DefaultTableModel) tablaCuponeras.getModel();
        int selectedRowId = tablaCuponeras.getSelectedRow();
        
        DtCuponera selectedCuponera = cuponeras.get(selectedRowId);
         // = new DtCuponera(selectedCuponera.getNombre(), selectedCuponera.getDescripcion(), selectedCuponera.getFechaVigencia(), selectedCuponera.getDescuento());
        if (selectedCuponera != null){
            //JOptionPane.showMessageDialog(new JFrame(), "Cuponera seleccionada: " + selectedCuponera.getNombre(), "Cuponera seleccionada", JOptionPane.INFORMATION_MESSAGE);
            if (!formAgregar.isVisible()) {
               formAgregar.setVisible(true);
            }
        }else{
            
            JOptionPane.showMessageDialog(new JFrame(), "Error, seleccione una cuponera existente.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    // Cambiar de color el botón al presionar.
    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed
        btnAgregarBG.setBackground(new Color(103, 149, 142));
    }//GEN-LAST:event_btnAgregarMousePressed

    // Cambiar de color el botón al presionar.
    private void btnAgregarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseReleased
        btnAgregarBG.setBackground(new Color(76,131,122));
    }//GEN-LAST:event_btnAgregarMouseReleased

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // ACTUALIZAR GRID
        tablaCuponeras.repaint();
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
        tablaCuponeras.repaint();
    }//GEN-LAST:event_formFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel btnActualizarCuponeras;
    private javax.swing.JPanel btnActualizarCuponerasBG;
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JPanel btnAgregarBG;
    private javax.swing.JLabel btnCrear;
    private javax.swing.JPanel btnCrearBG;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaCuponeras;
    // End of variables declaration//GEN-END:variables
}
