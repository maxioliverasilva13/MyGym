/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.forms;

import Institucion.DtInstitucion;
import Institucion.Institucion;
import Institucion.InstitucionBO;
import Institucion.InterfaceInstitucionBO;
import ParseDate.ParseDate;
import Profesor.ProfesorBO;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import Socio.SocioBO;
import Socio.dtos.SocioCreateDTO;
import Socio.dtos.SocioDTO;
import Socio.dtos.SocioEditDTO;
import Usuario.UsuarioBO;
import Usuario.dtos.UsuarioDTO;
import Usuario.exceptions.UserAlreadyEmailExist;
import Usuario.exceptions.UserAlreadyNickExist;
import com.raven.datechooser.SelectedDate;
import java.awt.Color;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import utils.BrowseFile;
import utils.ComboItem;

/**
 *
 * @author maximilianooliverasilva
 */
public class AddUsersForm extends javax.swing.JFrame {

    /**
     * Creates new form AddUsersForm
     */
    UsuarioBO usr = new UsuarioBO();
    int xMouse, yMouse;
    
    ProfesorBO profeBO = new ProfesorBO();
    SocioBO socioBO = new SocioBO();
    boolean isEditing = false;
    int idToEdit;
    ParseDate parsed = new ParseDate();

    UsuarioDTO userInfo;

    public AddUsersForm() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        this.setLocationRelativeTo(null);
        jPanel2.hide();
        btnHabilitarModificarPass.setVisible(false);
        this.loadInstituciones();
    }

    public AddUsersForm(String userType, int id) {
        initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        this.setLocationRelativeTo(null);
        jPanel2.hide();
        this.isEditing = true;
        this.loadInstituciones();
        this.jLabel1.setText("Guardar Informacion");
        idToEdit = id;
        
        passField.setEnabled(false);
        passRepeatField.setEnabled(false);
        passField.setText("passwordtext");
        passRepeatField.setText("passwordtext");
        if ("Socio".equals(userType)) {
            SocioDTO socioInfo = socioBO.consultarSocio(id);
            fillSocioInfo(socioInfo);
        } else {
            ProfesorDTO profeInfo = profeBO.getProfesorById(id);
            fillProfeInfo(profeInfo);
        }
    }

    private void fillSocioInfo(SocioDTO socio) {
        this.jPanel2.setVisible(false);
        this.jComboBox1.setSelectedItem("Socio/a");
        this.jComboBox1.setEnabled(false);
        this.jTextField3.setEnabled(false);
        this.jTextField4.setEnabled(false);
        this.jTextField3.setText(socio.getNickname());
        this.jTextField2.setText(socio.getNombre());
        this.jTextField1.setText(socio.getApellido());
        this.jTextField4.setText(socio.getEmail());
        Calendar c = Calendar.getInstance();
        c.setTime(socio.getNacimiento());
        String formattedFecha = c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.YEAR);
        this.jTextField5.setText(formattedFecha);
        this.jTextField3.setText(socio.getNickname());
        File tempFile = socio.getImage();
        if (tempFile != null) {
             labelImage.setIcon(BrowseFile.RezizeImage(tempFile.getAbsolutePath(), labelImage));
             this.revalidate();
             this.repaint();
        }

    }

    private void fillProfeInfo(ProfesorDTO profe) {
        this.jPanel2.setVisible(true);
        this.jComboBox1.setSelectedItem("Profesor/a");
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        this.jTextField3.setText(profe.getNickname());
        this.jTextField2.setText(profe.getNombre());
        this.jTextField1.setText(profe.getApellido());
        this.jTextField4.setText(profe.getEmail());
        Calendar c = Calendar.getInstance();
        c.setTime(profe.getNacimiento());
        String formattedFecha = c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.YEAR);
        this.jTextField5.setText(formattedFecha);
        this.jTextField3.setText(profe.getNickname());
        this.jTextArea1.setText(profe.getBiografia());
        this.jTextArea2.setText(profe.getdescripcionGeneral());
        this.jTextArea2.setText(profe.getdescripcionGeneral());
        this.jTextField6.setText(profe.getLinkSitioWeb());
        this.jTextField3.setEnabled(false);
        this.jTextField4.setEnabled(false);
        if (profe.getInstituciones().size() > 0) {
            String profeNames = "";
            this.jComboBox2.setSelectedItem(profe.getInstituciones().get(0).getNombre());
        }
        File tempFile = profe.getImage();
        if (tempFile != null) {
             labelImage.setIcon(BrowseFile.RezizeImage(tempFile.getAbsolutePath(), labelImage));
             this.revalidate();
             this.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        fechaNac = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        headerBar = new javax.swing.JPanel();
        exitBtnBG = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblConfirmPass = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        passRepeatField = new javax.swing.JPasswordField();
        btnHabilitarModificarPass = new javax.swing.JButton();
        labelImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jOptionPane1.setBackground(new java.awt.Color(255, 255, 255));

        fechaNac.setTextRefernce(jTextField5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(540, 830));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.setMaximumSize(new java.awt.Dimension(540, 830));
        jPanel1.setMinimumSize(new java.awt.Dimension(540, 830));
        jPanel1.setPreferredSize(new java.awt.Dimension(540, 830));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 254));
        jComboBox1.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Socio/a", "Profesor/a" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jComboBox1.setFocusable(false);
        jComboBox1.setVerifyInputWhenFocusTarget(false);
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 120, -1));

        jLabel2.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        jLabel2.setText("Foto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextField1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 186, 27));

        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextField2.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 184, 30));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("Nickname");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 140, -1));

        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextField3.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 186, 30));

        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextField4.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 184, 27));

        jTextField5.setToolTipText("");
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextField5.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 184, 27));

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel8.setText("Informacion Personal");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 254));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CancelarButton.jpg"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, -1, -1));

        jButton2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AceptarButton.jpg"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 810, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 36, 328, -1));

        jLabel10.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel10.setText("Biografia");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 6, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel12.setText("Instituci??n");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jTextField6.setToolTipText("");
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextField6.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 184, 27));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 254));
        jComboBox2.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        jComboBox2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jComboBox2.setFocusable(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 170, -1));

        jLabel13.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel13.setText("Descripcion");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 124, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(null);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 154, 328, 86));

        jLabel14.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel14.setText("Sitio web");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 69, 87));
        jLabel1.setText("Agregar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 25));

        headerBar.setBackground(new java.awt.Color(255, 255, 255));
        headerBar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(215, 215, 215)));
        headerBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerBarMouseDragged(evt);
            }
        });
        headerBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerBarMousePressed(evt);
            }
        });
        headerBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtnBG.setBackground(new java.awt.Color(174, 0, 51));

        exitBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn.setText("X");
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exitBtnBGLayout = new javax.swing.GroupLayout(exitBtnBG);
        exitBtnBG.setLayout(exitBtnBGLayout);
        exitBtnBGLayout.setHorizontalGroup(
            exitBtnBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        exitBtnBGLayout.setVerticalGroup(
            exitBtnBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtnBGLayout.createSequentialGroup()
                .addComponent(exitBtn)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        headerBar.add(exitBtnBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 30, -1));

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
            .addComponent(btnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        headerBar.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 30, -1));

        jPanel1.add(headerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 20));

        lblPass.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        lblPass.setText("Contrase??a");
        jPanel1.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 140, -1));

        lblConfirmPass.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        lblConfirmPass.setText("Confirmar Contrase??a");
        jPanel1.add(lblConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 140, -1));

        passField.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        passField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 186, 30));

        passRepeatField.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        passRepeatField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(passRepeatField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 186, 30));

        btnHabilitarModificarPass.setBackground(new java.awt.Color(76, 131, 122));
        btnHabilitarModificarPass.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        btnHabilitarModificarPass.setForeground(new java.awt.Color(255, 255, 255));
        btnHabilitarModificarPass.setText("Modificar");
        btnHabilitarModificarPass.setBorder(null);
        btnHabilitarModificarPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHabilitarModificarPass.setFocusPainted(false);
        btnHabilitarModificarPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHabilitarModificarPassMouseClicked(evt);
            }
        });
        btnHabilitarModificarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarModificarPassActionPerformed(evt);
            }
        });
        jPanel1.add(btnHabilitarModificarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 70, 20));

        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mygym/presentacion/forms/AddPhoto.png"))); // NOI18N
        labelImage.setText("labelImage");
        labelImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelImageMouseClicked(evt);
            }
        });
        jPanel1.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 100, 60));

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel9.setText("Tipo de Usuario");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String text = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());

        if (!isEditing) {
            if (text == "Socio/a") {
                jPanel2.hide();
            }
            if (text == "Profesor/a") {
                jPanel2.show();
            }
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cancel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel
        this.dispose();
    }//GEN-LAST:event_cancel

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        boolean error = false;

        if (jTextField3.getText().equals("")) {
            jTextField3.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
            error = true;
        }

        if (jTextField2.getText().equals("")) {
            jTextField2.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
            error = true;
        }

        if (jTextField1.getText().equals("")) {
            jTextField1.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
            error = true;
        }

        if (jTextField4.getText().equals("")) {
            jTextField4.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
            error = true;
        }

        if (jTextField5.getText().equals("")) {
            jTextField5.setBorder(new MatteBorder(0, 0, 1, 0, Color.red));
            error = true;
        }

        if (passField.getText().equals("") || passRepeatField.getText().equals("")) {
            JOptionPane.showMessageDialog(new JFrame(), "Los campos de contrase??a no deben estar vac??os.", "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }

        if (jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("Profesor/a")) {
            if (jTextArea1.getText().equals("")) {
                jTextArea1.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
                error = true;
            }

            if (jTextArea2.getText().equals("")) {
                jTextArea2.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
                error = true;
            }

        }

        Object selectedItemInsti = jComboBox2.getSelectedItem();
        SelectedDate sDate = fechaNac.getSelectedDate();
        Date fecha = parsed.parseDate(sDate.getYear() + "-" + sDate.getMonth() + "-" + sDate.getDay());

        if (!isEditing) {
            try {
                if (error == false) {

                    if (jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("Profesor/a")) {

                        if (selectedItemInsti == null) {
                            JOptionPane.showMessageDialog(new JFrame(), "Por favor seleccione una institucion", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int selectedInstitucionId = Integer.parseInt(((ComboItem) selectedItemInsti).getId());
                        
                        if(passField.getText().equals(passRepeatField.getText())){
                            ProfesorCreateDTO prof = new ProfesorCreateDTO(jTextField2.getText(), jTextField1.getText(), jTextField3.getText(), passRepeatField.getPassword(), jTextArea2.getText(), jTextArea1.getText(), jTextField4.getText(), jTextField6.getText(), fecha, selectedInstitucionId,  BrowseFile.globalFile);
                            usr.create(prof);
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(new JFrame(), "Los campos de contrase??a deben coincidir.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    if (jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("Socio/a")) {
                        if(passField.getText().equals(passRepeatField.getText())){
                            SocioCreateDTO usu = new SocioCreateDTO(jTextField2.getText(), jTextField1.getText(), jTextField3.getText(), passRepeatField.getPassword(), jTextField4.getText(), fecha,  BrowseFile.globalFile);
                            usr.create(usu);
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(new JFrame(), "Los campos de contrase??a deben coincidir.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(new JFrame(), "Usuario agregado correctamente", "Usuario Agregado", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                if (error == false) {
                    
                    if (jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("Profesor/a")) {
                        if (passField.isEnabled()){ // Modifica datos y password.
                            if(passField.getText().equals(passRepeatField.getText())){
                                ProfesorEditDTO editSocio = new ProfesorEditDTO(jTextField2.getText(), jTextField1.getText(), jTextField3.getText(),passRepeatField.getPassword(), jTextArea2.getText(), jTextArea1.getText(), jTextField6.getText(), jTextField4.getText(), fecha,  BrowseFile.globalFile);
                                profeBO.editProfesorById(idToEdit, editSocio);
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(new JFrame(), "Los campos de contrase??a deben coincidir.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }else{ // Modifica otros datos, pero no la password.
                            ProfesorEditDTO editSocio = new ProfesorEditDTO(jTextField2.getText(), jTextField1.getText(), jTextField3.getText(), null, jTextArea2.getText(), jTextArea1.getText(), jTextField6.getText(), jTextField4.getText(), fecha,  BrowseFile.globalFile);
                            profeBO.editProfesorById(idToEdit, editSocio);
                            this.dispose();
                        }
                    }
                    if (jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("Socio/a")) {
                        if (passField.isEnabled()){
                            if(passField.getText().equals(passRepeatField.getText())){
                                SocioEditDTO editSocio = new SocioEditDTO(jTextField2.getText(), jTextField1.getText(), jTextField3.getText(),passRepeatField.getPassword(), jTextField4.getText(), fecha, BrowseFile.globalFile);
                                socioBO.editar(idToEdit, editSocio);
                                this.dispose();
                            }else{
                                JOptionPane.showMessageDialog(new JFrame(), "Los campos de contrase??a deben coincidir.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }else{ // No modifica password
                            SocioEditDTO editSocio = new SocioEditDTO(jTextField2.getText(), jTextField1.getText(), jTextField3.getText(), null, jTextField4.getText(), fecha,  BrowseFile.globalFile);
                            socioBO.editar(idToEdit, editSocio);
                            this.dispose();
                        }
                    }
                    JOptionPane.showMessageDialog(new JFrame(), "Usuario Editado correctamente", "Usuario Editado", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitBtnMouseClicked

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void headerBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerBarMouseDragged

    private void headerBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerBarMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerBarMousePressed

    private void btnHabilitarModificarPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHabilitarModificarPassMouseClicked
        if (!passField.isEnabled()){
            passField.setEnabled(true);
            passRepeatField.setEnabled(true);
            passField.setText("");
            passRepeatField.setText("");
        }else{
            passField.setEnabled(false);
            passRepeatField.setEnabled(false);
            passField.setText("passwordtext");
            passRepeatField.setText("passwordtext");
        }
    }//GEN-LAST:event_btnHabilitarModificarPassMouseClicked

    private void btnHabilitarModificarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarModificarPassActionPerformed

    }//GEN-LAST:event_btnHabilitarModificarPassActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void labelImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImageMouseClicked
        BrowseFile.browseClickEvent(labelImage);
        // TODO add your handling code here:
    }//GEN-LAST:event_labelImageMouseClicked

    private void loadInstituciones() {
        this.jComboBox2.removeAllItems();
        InterfaceInstitucionBO insBo = new InstitucionBO();
        HashMap<Integer, DtInstitucion> instituciones = insBo.listarInstituciones();

        DefaultComboBoxModel modelInstituciones = new DefaultComboBoxModel();
        instituciones.forEach((key, value) -> {
            DtInstitucion currentInstitucion = instituciones.get(key);
            modelInstituciones.addElement(new ComboItem(key.toString(), currentInstitucion.getNombre()));
        });
        this.jComboBox2.setModel(modelInstituciones);
    }

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUsersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHabilitarModificarPass;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel btnMinimizarBG;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JPanel exitBtnBG;
    private com.raven.datechooser.DateChooser fechaNac;
    private javax.swing.JPanel headerBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel lblConfirmPass;
    private javax.swing.JLabel lblPass;
    private javax.swing.JPasswordField passField;
    private javax.swing.JPasswordField passRepeatField;
    // End of variables declaration//GEN-END:variables
}
