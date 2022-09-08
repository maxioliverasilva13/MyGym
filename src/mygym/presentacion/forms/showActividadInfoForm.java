/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.forms;

import javax.swing.JFrame;
import Actividad.dtos.ActividadDTO;
import Clase.DtClase;
import Cuponera.DtCuponera;
import CuponeraXActividad.DtCuponeraXActividad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import mygym.presentacion.pages.Actividades;
import utils.ComboItem;
import utils.Datehelper;

/**
 *
 * @author mandi
 */
public class showActividadInfoForm extends javax.swing.JFrame {
    public static HashMap<Integer, ActividadDTO> actividades = Actividades.actividadesSistema;
    List<DtClase> clases = new ArrayList<>();
    List<DtCuponeraXActividad> cuponeras = new ArrayList<>();
    DtCuponeraXActividad selectedCuponera;

    
    DefaultComboBoxModel modelClases = new DefaultComboBoxModel();
    DefaultComboBoxModel modelCuponeras = new DefaultComboBoxModel();

    
    int xMouse, yMouse;

    /**
     * Creates new form showActividadInfoForm
     */
    public showActividadInfoForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        // llenarCBoxCuponerasAsociadas();
        // llenarCBoxClasesAsociadas();   
    }
    
   
        public showActividadInfoForm(ActividadDTO act) {
        initComponents();
        this.setLocationRelativeTo(null);
        pintarInfoActividad(act);
        pintarInfoCuponerasAsociadas(act);
        // llenarCBoxCuponerasAsociadas();
        llenarCBoxClasesAsociadas(act); 
    }

   
    
    private void llenarCBoxClasesAsociadas(ActividadDTO selectedAct){
        try {
            clases = selectedAct.getClases();
            clases.forEach((currentDT) -> {
                modelClases.addElement(new ComboItem(Integer.toString(currentDT.getId()), currentDT.getNombre()));
            });
            cmbClases.setModel(modelClases);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    // Pintar los datos de un DataActividad (La actividad que seleccionó en el dashboard)
    private void pintarInfoActividad(ActividadDTO selectedAct){
        Datehelper helpDate= new Datehelper();
        String strFechaRegistro = helpDate.dateToStringFormat(selectedAct.getFechaRegistro());
        nombreActividad.setText(selectedAct.getNombre());
        costoActividad.setText(Float.toString(selectedAct.getCosto()));
        duracionActividad.setText(Integer.toString(selectedAct.getDuracion()));
        fechaAltaActividad.setText(strFechaRegistro);
        txaDescripcionActividad.setText(selectedAct.getDescripcion());
    }
    
    private void pintarInfoCuponerasAsociadas(ActividadDTO selectedAct){
        this.cmbCuponeras.removeAllItems();
        if (selectedAct.getDtCuponeraXActividad() != null) {
            selectedAct.getDtCuponeraXActividad().forEach((DtCuponeraXActividad cuxa) -> {
                String nombre = cuxa.getCuponera().getNombre();
                cuponeras.add(cuxa);
                cmbCuponeras.addItem(nombre);
            });
        }
    }
    
    private void llenarCuponeraInfo(int idCuponera) {
        
    }
    
    // Pintar información de la Cuponera seleccionada en el COMBOBOX
    private void pintarInfoCuponeraSeleccionada(DtCuponera cup){
        int selectedIndex = cmbCuponeras.getSelectedIndex();
        
        nombreCuponera.setText(cup.getNombre());
        descuentoCuponera.setText(Integer.toString(cup.getDescuento()));
        periodoVigenciaCuponera.setText("Fecha lalala");
        txaDescripcionCuponera.setText(cup.getDescripcion());
    }
    
    
    // Pintar información de la Cuponera seleccionada en el COMBOBOX
    private void pintarInfoClaseSeleccionada(DtClase clase){
        
        Datehelper helperDate = new Datehelper();
        
        String fechaAltaClaseStr = helperDate.dateToStringFormat(clase.getFecha());
        String fechaClaseStr = helperDate.dateToStringFormat(clase.getFecha());
        
        nombreClase.setText(clase.getNombre());
        fechaClase.setText(fechaClaseStr);
        profesorClase.setText(clase.getProfesor());
        capacidadMinimaClase.setText(Integer.toString(clase.getCapMinima()));
        capacidadMaximaClase.setText(Integer.toString(clase.getCapMaxima()));
        URLClase.setText(clase.getUrlAcceso());
        fechaAltaClase.setText(fechaAltaClaseStr);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCuponeras = new javax.swing.JComboBox<>();
        cmbClases = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollActividad = new javax.swing.JScrollPane();
        txaDescripcionActividad = new javax.swing.JTextArea();
        nombreActividad = new javax.swing.JLabel();
        costoActividad = new javax.swing.JLabel();
        duracionActividad = new javax.swing.JLabel();
        fechaAltaActividad = new javax.swing.JLabel();
        panelCuponeras = new javax.swing.JPanel();
        scrollCuponera = new javax.swing.JScrollPane();
        txaDescripcionCuponera = new javax.swing.JTextArea();
        periodoVigenciaCuponera = new javax.swing.JLabel();
        descuentoCuponera = new javax.swing.JLabel();
        nombreCuponera = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cantidadClases = new javax.swing.JLabel();
        panelClases = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        nombreClase = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fechaClase = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        profesorClase = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        capacidadMinimaClase = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        capacidadMaximaClase = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        URLClase = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fechaAltaClase = new javax.swing.JLabel();
        dragBar = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnExitBG = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(4, 37, 58));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Información de la Actividad");
        bgPanel.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 870, 29));

        jLabel1.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cuponeras Asociadas");
        bgPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 180, -1));

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Clases Asociadas");
        bgPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 180, -1));

        cmbCuponeras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Item" }));
        cmbCuponeras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuponerasActionPerformed(evt);
            }
        });
        bgPanel.add(cmbCuponeras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 180, -1));

        cmbClases.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Item" }));
        cmbClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClasesActionPerformed(evt);
            }
        });
        bgPanel.add(cmbClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 180, -1));

        jLabel3.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha de Alta al Sistema:");
        bgPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nombre:");
        bgPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 130, -1));

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripción:");
        bgPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 130, -1));

        jLabel6.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Duración en Minutos:");
        bgPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 130, -1));

        jLabel7.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Costo:");
        bgPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 130, -1));
        bgPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 870, 10));

        txaDescripcionActividad.setEditable(false);
        txaDescripcionActividad.setColumns(20);
        txaDescripcionActividad.setLineWrap(true);
        txaDescripcionActividad.setRows(5);
        scrollActividad.setViewportView(txaDescripcionActividad);

        bgPanel.add(scrollActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 230, -1));

        nombreActividad.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        nombreActividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreActividad.setText("xxxxxxxxxxxxxxx");
        bgPanel.add(nombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 260, 20));

        costoActividad.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        costoActividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        costoActividad.setText("xxxxxxxxxxxxxxx");
        bgPanel.add(costoActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 260, 20));

        duracionActividad.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        duracionActividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duracionActividad.setText("xxxxxxxxxxxxxxx");
        bgPanel.add(duracionActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 260, 20));

        fechaAltaActividad.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        fechaAltaActividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaAltaActividad.setText("xxxxxxxxxxxxxxx");
        bgPanel.add(fechaAltaActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 260, 20));

        panelCuponeras.setBackground(new java.awt.Color(236, 236, 236));
        panelCuponeras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txaDescripcionCuponera.setEditable(false);
        txaDescripcionCuponera.setColumns(20);
        txaDescripcionCuponera.setLineWrap(true);
        txaDescripcionCuponera.setRows(5);
        scrollCuponera.setViewportView(txaDescripcionCuponera);

        panelCuponeras.add(scrollCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 220, -1));

        periodoVigenciaCuponera.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        periodoVigenciaCuponera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        periodoVigenciaCuponera.setText("xx/xx/xxx - xx/xx/xxx");
        panelCuponeras.add(periodoVigenciaCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 250, 20));

        descuentoCuponera.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        descuentoCuponera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descuentoCuponera.setText("xxxxxxxxxxxxxxx");
        panelCuponeras.add(descuentoCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 250, 20));

        nombreCuponera.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        nombreCuponera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCuponera.setText("xxxxxxxxxxxxxxx");
        panelCuponeras.add(nombreCuponera, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 250, 20));

        jLabel8.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nombre: ");
        panelCuponeras.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 20));

        jLabel11.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Descuento:");
        panelCuponeras.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, -1));

        jLabel10.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Cantidad de clases");
        panelCuponeras.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, -1));

        jLabel9.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Descripción:");
        panelCuponeras.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, -1));

        jLabel19.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Período de Vigencia:");
        panelCuponeras.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, -1));

        cantidadClases.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        cantidadClases.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cantidadClases.setText("xxxxxxxxxxxxxxxx");
        panelCuponeras.add(cantidadClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 250, 20));

        bgPanel.add(panelCuponeras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 400, 230));

        panelClases.setBackground(new java.awt.Color(236, 236, 236));
        panelClases.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Nombre: ");
        panelClases.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 20));

        nombreClase.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        nombreClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreClase.setText("xxxxxxxxxxxxxxx");
        panelClases.add(nombreClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 230, 20));

        jLabel13.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Fecha de la Clase:");
        panelClases.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, -1));

        fechaClase.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        fechaClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaClase.setText("xxxxxxxxxxxxxxx");
        panelClases.add(fechaClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 230, 20));

        jLabel14.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Profesor:");
        panelClases.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        profesorClase.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        profesorClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profesorClase.setText("xxxxxxxxxxxxxxx");
        panelClases.add(profesorClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 230, 20));

        jLabel17.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Capacidad Mínima:");
        panelClases.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, -1));

        capacidadMinimaClase.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        capacidadMinimaClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        capacidadMinimaClase.setText("xxxxxxxxxxxxxxx");
        panelClases.add(capacidadMinimaClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 230, 20));

        jLabel18.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Capacidad Máxima:");
        panelClases.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, -1));

        capacidadMaximaClase.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        capacidadMaximaClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        capacidadMaximaClase.setText("xxxxxxxxxxxxxxx");
        panelClases.add(capacidadMaximaClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 230, 20));

        jLabel15.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("URL:");
        panelClases.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 130, -1));

        URLClase.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        URLClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        URLClase.setText("xxxxxxxxxxxxxxx");
        panelClases.add(URLClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 230, 20));

        jLabel16.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Fecha de Alta al Sistema:");
        panelClases.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        fechaAltaClase.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        fechaAltaClase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaAltaClase.setText("xxxxxxxxxxxxxxx");
        panelClases.add(fechaAltaClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 230, 20));

        bgPanel.add(panelClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 400, 230));

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
        bgPanel.add(dragBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 20));

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

        bgPanel.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 30, 20));

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

        bgPanel.add(btnExitBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 30, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCuponerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuponerasActionPerformed
       Object selectedString = cmbCuponeras.getSelectedItem();
       if (selectedString != null) {
           String stringSelectedString = selectedString.toString();
           cuponeras.forEach((DtCuponeraXActividad cuxa) -> {
               if (stringSelectedString == cuxa.getCuponera().getNombre()) {
                   selectedCuponera = cuxa;
                   fillSelectedCuponera();
               }
           });
       }
    }//GEN-LAST:event_cmbCuponerasActionPerformed

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

    private void cmbClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClasesActionPerformed
            Object selectedItem = cmbClases.getSelectedItem();
            
            if (selectedItem != null){
                    int claseAbuscar = Integer.parseInt(((ComboItem)selectedItem).getId());
                    clases.forEach((currentDT) -> {
                        if (currentDT.getId() == claseAbuscar){
                            pintarInfoClaseSeleccionada(currentDT);
                            return;
                        }
                    });
            }
    }//GEN-LAST:event_cmbClasesActionPerformed

    /**
     * @param args the command line arguments
     */

    public void fillSelectedCuponera() {
        if (selectedCuponera.getCuponera() != null) {
            
            Datehelper helperDate = new Datehelper();
            DtCuponera cup = selectedCuponera.getCuponera();
            
            String periodoDeVigenciaStr = helperDate.dateToStringFormat(cup.getPeriodoVigencia());
            this.nombreCuponera.setText(cup.getNombre());
            this.descuentoCuponera.setText(Float.toString(cup.getDescuento()));
            this.periodoVigenciaCuponera.setText(periodoDeVigenciaStr);
            this.cantidadClases.setText(Integer.toString(selectedCuponera.getCantClases()));
            this.txaDescripcionCuponera.setText(cup.getDescripcion());
        }
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
            java.util.logging.Logger.getLogger(showActividadInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showActividadInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showActividadInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showActividadInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showActividadInfoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel URLClase;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel btnExit;
    private javax.swing.JPanel btnExitBG;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel btnMinimizarBG;
    private javax.swing.JLabel cantidadClases;
    private javax.swing.JLabel capacidadMaximaClase;
    private javax.swing.JLabel capacidadMinimaClase;
    private javax.swing.JComboBox<String> cmbClases;
    private javax.swing.JComboBox<String> cmbCuponeras;
    private javax.swing.JLabel costoActividad;
    private javax.swing.JLabel descuentoCuponera;
    private javax.swing.JLabel dragBar;
    private javax.swing.JLabel duracionActividad;
    private javax.swing.JLabel fechaAltaActividad;
    private javax.swing.JLabel fechaAltaClase;
    private javax.swing.JLabel fechaClase;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel nombreActividad;
    private javax.swing.JLabel nombreClase;
    private javax.swing.JLabel nombreCuponera;
    private javax.swing.JPanel panelClases;
    private javax.swing.JPanel panelCuponeras;
    private javax.swing.JLabel periodoVigenciaCuponera;
    private javax.swing.JLabel profesorClase;
    private javax.swing.JScrollPane scrollActividad;
    private javax.swing.JScrollPane scrollCuponera;
    private javax.swing.JTextArea txaDescripcionActividad;
    private javax.swing.JTextArea txaDescripcionCuponera;
    // End of variables declaration//GEN-END:variables
}
