/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.components;

import Actividad.ActividadBO;
import Actividad.dtos.ActividadDTO;
import Clase.ClaseBO;
import Clase.DtClase;
import Institucion.DtInstitucion;
import Institucion.InstitucionBO;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mygym.presentacion.forms.*;
import javax.swing.WindowConstants;
import utils.Datehelper;


/**
 *
 * @author maximilianooliverasilva
 */
public class ChooseInstitucion extends javax.swing.JFrame {

    /**
     * Creates new form AddUsersForm
     */
    InstitucionBO insBO = new InstitucionBO();
    ActividadBO actBO = new ActividadBO();
    ClaseBO claseBO = new ClaseBO();
    HashMap<Integer, DtInstitucion> instituciones = insBO.listarInstituciones();
    HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
    HashMap<Integer, DtClase> clases = new HashMap<>();
    DtClase selectedClase;
    JLabel text = new JLabel();
    
    int selectedIdInstitucion;
    int selectedIdActividad;
    int selectedIdClase;
    int xMouse, yMouse;
    
    public void initializeSomeFields() {
        this.labelCapMaxima.setText("");
        this.labelCapMaxima.setText("");
        this.labelCreacion.setText("");
        this.labelInicio.setText("");
        this.labelUrl.setText("");
        this.labelProfesor.setText("");        
        this.labelCantAlumnos.setText("");
        this.jComboActividades.setEnabled(false);
        this.jComboClases.setEnabled(false);
        this.jComboInstituciones.setEnabled(false);
        this.panelNotFound.setVisible(false);
    }
    
    public ChooseInstitucion() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        text.setText("Lo siento ! No encontramos ninguna clase");
        this.initializeSomeFields();
        this.loadInstituciones();
    }
    
    public ChooseInstitucion(DtClase clase) {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        this.jComboActividades.setVisible(false);
        this.jComboClases.setVisible(false);
        this.jComboInstituciones.setVisible(false);
        this.jLabel13.setVisible(false);
        this.jLabel14.setVisible(false);
        this.jLabel15.setVisible(false);
        this.selectedClase = clase;
        this.fillClaseData();
    }
    
    public void fillEmptyClassData() {
//        this.labelProfesor.setText("");
//        this.labelInicio.setText("");
//        this.labelCreacion.setText("");
//        this.labelCapMaxima.setText("");
//        this.labelCapMinima.setText("");
//        this.labelUrl.setText("");
        colocateEmptyResults();
    }
    
    public void colocateEmptyResults() {
        panelNotFound.setVisible(true);
        panelInfo.setVisible(false);
    }
    
    public void colocateCorrectResults() {
        panelNotFound.setVisible(false);
        panelInfo.setVisible(true);
    }
    
    public void fillClaseData() {
        if (selectedClase != null) {
            String fechaHoraInicio = "Vacio";
            String fechaCreacion = "Vacio";
            Datehelper dateHelper = new Datehelper();
            String profesorNombre = this.selectedClase.getProfesor();
            if (this.selectedClase.getFecha() != null) {
                fechaHoraInicio = dateHelper.dateToStringFormat(this.selectedClase.getFecha());
            }
            if (this.selectedClase.getFechaRegistro() != null) {
                fechaCreacion = dateHelper.dateToStringFormat(this.selectedClase.getFechaRegistro());
            }
            String capMin = Integer.toString(this.selectedClase.getCapMinima());
            String capMax = Integer.toString(this.selectedClase.getCapMaxima());
            String urlAcceso = this.selectedClase.getUrlAcceso();
            String cantAlumnos = Integer.toString(this.selectedClase.getRegistros().size());
            this.labelProfesor.setText(profesorNombre);
            this.labelInicio.setText(fechaHoraInicio);
            this.labelCreacion.setText(fechaCreacion);
            this.labelCapMaxima.setText(capMax);
            this.labelCapMinima.setText(capMin);
            this.labelUrl.setText(urlAcceso);
            this.labelCantAlumnos.setText(cantAlumnos);
            this.labelNombre.setText(selectedClase.getNombre());
            colocateCorrectResults();
        } else {
            // fillEmptyClassData();
            colocateEmptyResults();
        }
    }
    
    public void getClase() {
        this.selectedClase = claseBO.consultarClase(selectedIdClase);
        fillClaseData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        bgPanel = new javax.swing.JPanel();
        dragBar2 = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnExitBG = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        errorCapacidadLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboClases = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboInstituciones = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboActividades = new javax.swing.JComboBox<>();
        panelInfo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelProfesor = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelInicio = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelCreacion = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labelCapMinima = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labelCapMaxima = new javax.swing.JLabel();
        labelUrl = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        labelCantAlumnos = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        panelNotFound = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(360, 430));
        setMinimumSize(new java.awt.Dimension(360, 430));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));
        bgPanel.setMaximumSize(new java.awt.Dimension(390, 450));
        bgPanel.setMinimumSize(new java.awt.Dimension(390, 450));
        bgPanel.setPreferredSize(new java.awt.Dimension(390, 450));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dragBar2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragBar2MouseDragged(evt);
            }
        });
        dragBar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragBar2MousePressed(evt);
            }
        });
        bgPanel.add(dragBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 20));

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
            .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        bgPanel.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 0, 30, 20));

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
            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bgPanel.add(btnExitBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 0, 30, 20));
        bgPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 287, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        bgPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 555, -1, -1));
        jLabel4.getAccessibleContext().setAccessibleName("labelErrorCapacidad");

        errorCapacidadLbl.setForeground(new java.awt.Color(255, 0, 0));
        errorCapacidadLbl.setName("errorCapacidad"); // NOI18N
        bgPanel.add(errorCapacidadLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 555, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 0, 102));
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setName("errorLblMinSocios"); // NOI18N
        bgPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(954, 606, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        bgPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 612, -1, -1));
        jLabel12.getAccessibleContext().setAccessibleName("errorMaxSociosLbl");

        jComboClases.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jComboClases.setFocusable(false);
        jComboClases.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboClasesItemStateChanged(evt);
            }
        });
        jComboClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClasesActionPerformed(evt);
            }
        });
        bgPanel.add(jComboClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 290, 30));

        jLabel13.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel13.setText("Elija una clase");
        bgPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel14.setText("Elije una institucion");
        bgPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 23, -1, -1));

        jComboInstituciones.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jComboInstituciones.setFocusable(false);
        jComboInstituciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboInstitucionesItemStateChanged(evt);
            }
        });
        jComboInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboInstitucionesActionPerformed(evt);
            }
        });
        bgPanel.add(jComboInstituciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 290, 30));

        jLabel15.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel15.setText("Elija una Actividad");
        bgPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jComboActividades.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jComboActividades.setFocusable(false);
        jComboActividades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboActividadesItemStateChanged(evt);
            }
        });
        jComboActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboActividadesActionPerformed(evt);
            }
        });
        bgPanel.add(jComboActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 290, 30));

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));
        panelInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        panelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jLabel9.setText("Informacion de la clase");
        panelInfo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -8, -1, 50));

        jLabel16.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel16.setText("Profesor:");
        panelInfo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        labelProfesor.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelProfesor.setText("Nicolas escobar");
        panelInfo.add(labelProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel17.setText("Fecha y hora de inicio:");
        panelInfo.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        labelInicio.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelInicio.setText("27/08/2022 17:00");
<<<<<<< HEAD
        panelInfo.add(labelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));
=======
        panelInfo.add(labelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 160, -1));
>>>>>>> 17419923e39186799d13614eb857af709dd435cb

        jLabel18.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel18.setText("Fecha de creacion:");
        panelInfo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        labelCreacion.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelCreacion.setText("19/08/2022 ");
<<<<<<< HEAD
        panelInfo.add(labelCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));
=======
        panelInfo.add(labelCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 180, -1));
>>>>>>> 17419923e39186799d13614eb857af709dd435cb

        jLabel19.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel19.setText("Capacidad minima socios:");
        panelInfo.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        labelCapMinima.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelCapMinima.setText("2");
<<<<<<< HEAD
        panelInfo.add(labelCapMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 50, -1));
=======
        panelInfo.add(labelCapMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 50, -1));
>>>>>>> 17419923e39186799d13614eb857af709dd435cb

        jLabel20.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel20.setText("Capacidad maxima socios:");
        panelInfo.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        labelCapMaxima.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelCapMaxima.setText("10");
<<<<<<< HEAD
        panelInfo.add(labelCapMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 50, -1));
=======
        panelInfo.add(labelCapMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 50, -1));
>>>>>>> 17419923e39186799d13614eb857af709dd435cb

        labelUrl.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelUrl.setText("https://zoom.com/sa2ad");
        panelInfo.add(labelUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 240, -1));

        jTextNombre.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jTextNombre.setText("Nombre:");
        panelInfo.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel22.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel22.setText("Url de acceso");
        panelInfo.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        labelCantAlumnos.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelCantAlumnos.setText("2");
        panelInfo.add(labelCantAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 60, -1));

        jLabel23.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        jLabel23.setText("Cantidad Alumnos:");
        panelInfo.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        labelNombre.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelNombre.setText("2");
        panelInfo.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 170, -1));

        bgPanel.add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 330, 190));

        panelNotFound.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        panelNotFound.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel1.setText("Lo sentimos, no encontramos ninguna clase !");
        panelNotFound.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        bgPanel.add(panelNotFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 310, 70));

        getContentPane().add(bgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboClasesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboClasesItemStateChanged
        Object selected = jComboClases.getSelectedItem();
        if (selected != null) {
            String itemString = selected.toString();
            clases.forEach((Integer id, DtClase clasei) -> {
                if (clasei.getNombre() == itemString) {
                    selectedIdClase = clasei.getId();
                    this.getClase();
                }
            });
        }
    }//GEN-LAST:event_jComboClasesItemStateChanged

    private void jComboInstitucionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboInstitucionesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboInstitucionesItemStateChanged

    private void jComboActividadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboActividadesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboActividadesItemStateChanged

    private void jComboInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboInstitucionesActionPerformed
    Object selected = jComboInstituciones.getSelectedItem();
    if (selected != null) {
        String itemString = selected.toString();
        instituciones.forEach((Integer id, DtInstitucion ins) -> {
            if (ins.getNombre() == itemString && selectedIdInstitucion != ins.getId()) {
                selectedIdInstitucion = ins.getId();
                this.loadActividades();
            }
            if (selectedIdInstitucion == ins.getId()) {
                this.jComboInstituciones.setSelectedItem(ins.getNombre());
            }
        });
    }
    }//GEN-LAST:event_jComboInstitucionesActionPerformed
    
    private void jComboActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboActividadesActionPerformed
    Object selected = jComboActividades.getSelectedItem();
    if (selected != null) {
        String itemString = selected.toString();
        actividades.forEach((Integer id, ActividadDTO act) -> {
            if (act.getNombre() == itemString) {
                selectedIdActividad = act.getId();
                this.loadClases();
            }
        });
    }
    }//GEN-LAST:event_jComboActividadesActionPerformed

    private void jComboClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClasesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboClasesActionPerformed

    private void dragBar2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBar2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_dragBar2MouseDragged

    private void dragBar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBar2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragBar2MousePressed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

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
            java.util.logging.Logger.getLogger(AddUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUsersForm().setVisible(true);
            }
        });
    }
    
    /*CUSTOMS FUNCTIONS*/
    
  private void loadInstituciones(){
       this.jComboInstituciones.removeAllItems();
       System.out.println("entro 1");
       System.out.println(selectedIdInstitucion);
       instituciones.forEach((Integer key, DtInstitucion inst) -> {
                  System.out.println("el id es " + key );
           if (selectedIdInstitucion == key) {
               System.out.println("lo seteo bien");
               this.jComboInstituciones.setSelectedItem(inst.getNombre());
           }
           jComboInstituciones.addItem(inst.getNombre());
       });
       this.jComboInstituciones.setEnabled(true);
  }
  
  public void loadActividades() {
      this.jComboActividades.removeAllItems();
      actividades = actBO.listarActividades(this.selectedIdInstitucion);
      if (actividades.size() == 0) {
          this.jComboClases.removeAllItems();
          fillEmptyClassData();
          return;
      }
      actividades.forEach((Integer key, ActividadDTO act) -> {
        this.jComboActividades.addItem(act.getNombre());
      });
      
      this.jComboActividades.setEnabled(true);
  }
  
  public void loadClases() {
      this.jComboClases.removeAllItems();
      clases = claseBO.listarClasesByAct(this.selectedIdActividad);
      if (clases.size() == 0) {
          fillEmptyClassData();
          return;
      }
      clases.forEach((Integer idClase, DtClase classe) -> {
          this.jComboClases.addItem(classe.getNombre());
      });
      this.jComboClases.setEnabled(true);
  }
  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel btnExit;
    private javax.swing.JPanel btnExitBG;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel btnMinimizarBG;
    private javax.swing.JLabel dragBar2;
    private javax.swing.JLabel errorCapacidadLbl;
    private javax.swing.JComboBox<String> jComboActividades;
    private javax.swing.JComboBox<String> jComboClases;
    private javax.swing.JComboBox<String> jComboInstituciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel jTextNombre;
    private javax.swing.JLabel labelCantAlumnos;
    private javax.swing.JLabel labelCapMaxima;
    private javax.swing.JLabel labelCapMinima;
    private javax.swing.JLabel labelCreacion;
    private javax.swing.JLabel labelInicio;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelProfesor;
    private javax.swing.JLabel labelUrl;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelNotFound;
    // End of variables declaration//GEN-END:variables
}
