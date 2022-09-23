/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.forms;

import Actividad.ActividadBO;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.raven.datechooser.SelectedDate;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JTable;
import Actividad.dtos.ActividadCreateDTO;
import Categoria.CategoriaBO;
import Categoria.DtCategoria;
import Institucion.DtInstitucion;
import Profesor.dtos.ProfesorDTO;
import Institucion.InstitucionBO;
import ParseDate.ParseDate;
import Profesor.ProfesorBO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import mygym.presentacion.pages.Actividades;
import utils.ComboItem;
import utils.BrowseFile;


/**
 *
 * @author mandi
 */
public class createActividadForm extends javax.swing.JFrame{

   public static HashMap<Integer, DtInstitucion> instituciones = new HashMap<>();
   public static HashMap<Integer, DtCategoria> categorias = new HashMap<>();
   public static HashMap<Integer, String> categoriasSeleccionadas = new HashMap<>();
   public static HashMap<Integer, ProfesorDTO> profesores = new HashMap<>(); 

    DefaultComboBoxModel modelInstituciones = new DefaultComboBoxModel();
    DefaultComboBoxModel modelCategorias = new DefaultComboBoxModel();
    DefaultComboBoxModel modelProfesores = new DefaultComboBoxModel();
    DefaultListModel listModelCategorias = new DefaultListModel();
    
    ParseDate parse = new ParseDate();
    int xMouse, yMouse;
    Color gris = new Color(204,204,204);

    ActividadBO actBO = new ActividadBO();
    InstitucionBO insBO = new InstitucionBO();
    CategoriaBO catBO = new CategoriaBO();
    ProfesorBO profBO = new ProfesorBO();
    
    public createActividadForm() {
        initComponents();
        llenarCBoxInstituciones();
        llenarCBoxProfesores();
        llenarCBoxCategorias();
        
        this.setLocationRelativeTo(null);
        scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(gris));
        txtNombre.setText("");
        txtDuracion.setText("");
        txtCosto.setText("");
        txtareaDescripcion.setText("");
        
        txtDuracion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                     e.consume();  // if it's not a number, ignore the event
                }
            }
         });
        
        txtCosto.addKeyListener(new KeyAdapter() {
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
        txtFecha.enable(false);
    }
     
    private void llenarCBoxInstituciones(){
        cmbInstituciones.removeAllItems();
        instituciones = insBO.listarInstituciones();
        instituciones.forEach((key, value) -> {
            DtInstitucion currentInstitucion = instituciones.get(key);
            modelInstituciones.addElement(new ComboItem(key.toString(), currentInstitucion.getNombre()));
        });
        cmbInstituciones.setModel(modelInstituciones);
        cmbInstituciones.setSelectedItem(null);
    }    
   
        private void llenarCBoxProfesores(){
        cmbProfesores.removeAllItems();
        profesores = profBO.listarProfesores();
        profesores.forEach((key, value) -> {
            ProfesorDTO currentProf = profesores.get(key);
            modelProfesores.addElement(new ComboItem(key.toString(), currentProf.getNombre()));
        });
        cmbProfesores.setModel(modelProfesores);
        cmbProfesores.setSelectedItem(null);
    }    
    
    private void llenarCBoxCategorias(){
        cmbCategorias.removeAllItems();
        categorias = catBO.listarCategorias();
        categorias.forEach((key, value) -> { 
            DtCategoria currentCat = categorias.get(key);
            modelCategorias.addElement(new ComboItem(Integer.toString(currentCat.getId()), currentCat.getNombre()));
        });
        cmbCategorias.setModel(modelCategorias);
        cmbCategorias.setSelectedItem(null);
    }
        
    
    private void llenarCategoriasSeleccionadas(){
        listModelCategorias.removeAllElements();
        categoriasSeleccionadas.forEach((key, value) -> { 
            DtCategoria currentCat = categorias.get(key);
            listModelCategorias.addElement(currentCat.getNombre());
        });
        this.listCategorias.setModel(listModelCategorias);
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
        jPanel2 = new javax.swing.JPanel();
        dragBar = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnExitBG = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        buttonSubirImage = new javax.swing.JPanel();
        labelSubirImage = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        lblInstitucion = new javax.swing.JLabel();
        cmbInstituciones = new javax.swing.JComboBox<>();
        lblProfesor = new javax.swing.JLabel();
        cmbProfesores = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        cmbCategorias = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        separatorNombre = new javax.swing.JSeparator();
        lblDuracion = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        separatorDuracion = new javax.swing.JSeparator();
        lblCosto = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        separatorCosto = new javax.swing.JSeparator();
        lblDescripcion = new javax.swing.JLabel();
        scrollDescr = new javax.swing.JScrollPane();
        txtareaDescripcion = new javax.swing.JTextArea();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        separatorFecha = new javax.swing.JSeparator();
        btnCrearBG = new javax.swing.JPanel();
        btnCrear = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        dateChooserActual.setToolTipText("");
        dateChooserActual.setEnabled(false);
        dateChooserActual.setFocusable(false);
        dateChooserActual.setName(""); // NOI18N
        dateChooserActual.setRequestFocusEnabled(false);
        dateChooserActual.setTextRefernce(txtFecha);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear cuponera");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 710));
        setMinimumSize(new java.awt.Dimension(600, 710));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));
        jPanel2.setMaximumSize(new java.awt.Dimension(600, 710));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 710));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 710));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(dragBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 20));

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
            .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        jPanel2.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 20));

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

        jPanel2.add(btnExitBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 20));

        buttonSubirImage.setBackground(new java.awt.Color(76, 131, 122));
        buttonSubirImage.setPreferredSize(new java.awt.Dimension(120, 50));
        buttonSubirImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSubirImageMouseClicked(evt);
            }
        });

        labelSubirImage.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        labelSubirImage.setForeground(new java.awt.Color(255, 255, 255));
        labelSubirImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubirImage.setText("Subir Imagen");
        labelSubirImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelSubirImage.setMaximumSize(new java.awt.Dimension(100, 19));
        labelSubirImage.setMinimumSize(new java.awt.Dimension(100, 19));
        labelSubirImage.setPreferredSize(new java.awt.Dimension(100, 19));
        labelSubirImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSubirImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttonSubirImageLayout = new javax.swing.GroupLayout(buttonSubirImage);
        buttonSubirImage.setLayout(buttonSubirImageLayout);
        buttonSubirImageLayout.setHorizontalGroup(
            buttonSubirImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonSubirImageLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelSubirImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttonSubirImageLayout.setVerticalGroup(
            buttonSubirImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonSubirImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSubirImage, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(buttonSubirImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 110, 50));

        lblHeader.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(4, 37, 58));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Alta de Actividad Deportiva");
        jPanel2.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 600, 29));

        lblInstitucion.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblInstitucion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInstitucion.setText("Institucion");
        jPanel2.add(lblInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 70, 30));

        cmbInstituciones.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        cmbInstituciones.setFocusable(false);
        cmbInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInstitucionesActionPerformed(evt);
            }
        });
        jPanel2.add(cmbInstituciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 210, 30));

        lblProfesor.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblProfesor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProfesor.setText("Profesor");
        jPanel2.add(lblProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 70, 30));

        cmbProfesores.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        cmbProfesores.setFocusable(false);
        jPanel2.add(cmbProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 210, 30));

        lblCategoria.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCategoria.setText("Categoría/s");
        jPanel2.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 70, 30));

        cmbCategorias.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        cmbCategorias.setFocusable(false);
        jPanel2.add(cmbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 160, 30));

        lblNombre.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 50, 30));

        txtNombre.setBorder(null);
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 210, 30));
        jPanel2.add(separatorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 210, 20));

        lblDuracion.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblDuracion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDuracion.setText("Duración (minutos)");
        jPanel2.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 120, 30));

        txtDuracion.setToolTipText("");
        txtDuracion.setBorder(null);
        jPanel2.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 210, 30));
        jPanel2.add(separatorDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 210, 20));

        lblCosto.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCosto.setText("Costo");
        jPanel2.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 40, 30));

        txtCosto.setToolTipText("");
        txtCosto.setBorder(null);
        jPanel2.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 210, 30));
        jPanel2.add(separatorCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 210, 20));

        lblDescripcion.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescripcion.setText("Descripción");
        jPanel2.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 70, 30));

        scrollDescr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 249, 248)));

        txtareaDescripcion.setColumns(20);
        txtareaDescripcion.setLineWrap(true);
        txtareaDescripcion.setRows(5);
        txtareaDescripcion.setBorder(null);
        scrollDescr.setViewportView(txtareaDescripcion);

        jPanel2.add(scrollDescr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 200, -1));

        lblFecha.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Fecha del Sistema");
        jPanel2.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 150, 30));

        txtFecha.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(null);
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 130, 20));
        jPanel2.add(separatorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 130, 20));

        btnCrearBG.setBackground(new java.awt.Color(76, 131, 122));

        btnCrear.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrear.setText("Crear");
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jPanel2.add(btnCrearBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, -1, -1));

        labelImage.setMaximumSize(new java.awt.Dimension(90, 90));
        labelImage.setMinimumSize(new java.awt.Dimension(90, 90));
        labelImage.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel2.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 90, 90));

        jButton3.setBackground(new java.awt.Color(76, 131, 122));
        jButton3.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar/Eliminar");
        jButton3.setBorder(null);
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 120, 30));

        jScrollPane1.setBorder(null);

        listCategorias.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        listCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCategorias.setFocusable(false);
        listCategorias.setSelectionBackground(new java.awt.Color(255, 255, 255));
        listCategorias.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(listCategorias);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 210, 140));

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categoría(s) Seleccionada(s)");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       
    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        boolean error = false;
        
        if (cmbInstituciones.getSelectedItem() == null){
            JOptionPane.showMessageDialog(new JFrame(), "Seleccione una Insitución.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (cmbProfesores.getSelectedItem() == null){
            JOptionPane.showMessageDialog(new JFrame(), "Seleccione un Profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Control de campo NOMBRE vacío.
        if (txtNombre.getText().equals("")){
            separatorNombre.setForeground(Color.red);
            error=true;
        }
        
        // Control de campo DURACIÓN vacío.
        if (txtDuracion.getText().equals("")){
            separatorDuracion.setForeground(Color.red);
            error=true;
        }
        
        // Control de campo COSTO vacío.
        if (txtCosto.getText().equals("")){
            separatorCosto.setForeground(Color.red);
            error=true;
        }
        
        // Control de campo DESCRIPCIÓN vacío.
        if (txtareaDescripcion.getText().equals("")){
            scrollDescr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
            scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            error=true;
        }
        
        if (categoriasSeleccionadas.isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Debe agregar al menos una categoría para ésta actividad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!error){
            
            Object selectedItemInsti = cmbInstituciones.getSelectedItem();
            int selectedInstitucionId = Integer.parseInt(((ComboItem)selectedItemInsti).getId());           
            
            Object selectedItemProf = cmbProfesores.getSelectedItem();
            int selectedProfId = Integer.parseInt(((ComboItem)selectedItemProf).getId());           

            
            SelectedDate fActual = dateChooserActual.getSelectedDate();
            Date fecha = parse.parseDate(fActual.getYear() + "-" + fActual.getMonth() + "-" + fActual.getDay());
            
            
            List<DtCategoria> catsInThisAct = new ArrayList<>();

            categoriasSeleccionadas.forEach((key, value) -> {
                DtCategoria cat = new DtCategoria(key, value);
                catsInThisAct.add(cat);
            });

            ActividadCreateDTO act = new ActividadCreateDTO(selectedInstitucionId, selectedProfId, Float.parseFloat(txtCosto.getText()), txtNombre.getText(), txtareaDescripcion.getText(), fecha, Integer.parseInt(txtDuracion.getText()), BrowseFile.globalFile, catsInThisAct); 
            try {
                actBO.crear(act, selectedInstitucionId, selectedProfId);
                JOptionPane.showMessageDialog(new JFrame(),  "Actividad insertada con exito.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            txtNombre.setText("");
            txtDuracion.setText("");
            txtCosto.setText("");
            txtareaDescripcion.setText("");
            separatorNombre.setForeground(gris);
            separatorDuracion.setForeground(gris);
            separatorCosto.setForeground(gris);
            scrollDescr.setViewportBorder(javax.swing.BorderFactory.createLineBorder(gris));
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

    private void cmbInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInstitucionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbInstitucionesActionPerformed

    private void labelSubirImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSubirImageMouseClicked
        BrowseFile.browseClickEvent(labelImage);
    }//GEN-LAST:event_labelSubirImageMouseClicked

    private void buttonSubirImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSubirImageMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSubirImageMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
        Object selectedItemCategoria = cmbCategorias.getSelectedItem();
        if (selectedItemCategoria != null){
            int selectedCatId = Integer.parseInt(((ComboItem)selectedItemCategoria).getId());           
            String selectedCatName = ((ComboItem)selectedItemCategoria).getValue();           
            
            if(categoriasSeleccionadas.isEmpty()){
                categoriasSeleccionadas.put(selectedCatId, selectedCatName);
                llenarCategoriasSeleccionadas();
            }else{
                if (categoriasSeleccionadas.containsKey(selectedCatId)){ // Si ya tiene esa categoría, la elimina de la lista.
                    categoriasSeleccionadas.remove(selectedCatId);
                    llenarCategoriasSeleccionadas();
                }else{
                    categoriasSeleccionadas.put(selectedCatId, selectedCatName);
                    llenarCategoriasSeleccionadas();
                }
            }
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(createActividadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createActividadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createActividadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createActividadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createActividadForm().setVisible(true);
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
    private javax.swing.JPanel buttonSubirImage;
    private javax.swing.JComboBox<String> cmbCategorias;
    private javax.swing.JComboBox<String> cmbInstituciones;
    private javax.swing.JComboBox<String> cmbProfesores;
    private com.raven.datechooser.DateChooser dateChooserActual;
    private javax.swing.JLabel dragBar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelSubirImage;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProfesor;
    private javax.swing.JList<String> listCategorias;
    private javax.swing.JScrollPane scrollDescr;
    private javax.swing.JSeparator separatorCosto;
    private javax.swing.JSeparator separatorDuracion;
    private javax.swing.JSeparator separatorFecha;
    private javax.swing.JSeparator separatorNombre;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtareaDescripcion;
    // End of variables declaration//GEN-END:variables
}
