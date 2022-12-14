/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mygym.presentacion.components;

import Actividad.ActividadBO;
import Actividad.dtos.ActividadDTO;
import Clase.ClaseBO;
import Clase.DtClase;
import Cuponera.CuponeraBo;
import Cuponera.DtCuponera;
import Cuponera.InterfaceCuponeraBo;
import CustomCalendar.main.CalendarCustom;
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
import Registro.DtRegistro;
import Registro.RegistroBO;
import Socio.SocioBO;
import Socio.dtos.SocioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import mygym.presentacion.pages.Instituciones;
import utils.CustomClick;
import utils.RenderFoto;

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
    ClaseBO claseBO = new ClaseBO();
    RegistroBO regBO = new RegistroBO();
    InterfaceCuponeraBo cupBO  = new CuponeraBo();


    HashMap<Integer, ActividadDTO> actividades = new HashMap<>();
    HashMap<Integer, DtInstitucion> instituciones = new HashMap<>();
    HashMap<Integer, SocioDTO> socios = new HashMap<>();
    HashMap<Integer, DtClase> clases = new HashMap<>();
    HashMap<Integer, DtCuponera> cuponerasDisponibles = new HashMap<>();
    
    int selectedInstitucionId = -1;
    int selectedActividadId = -1;
    int selectedSocioId = -1;
    int selectedClaseId ;
    Integer selectedCuponeraId = null;
    int xMouse, yMouse;
    
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
            jComboSocios.addItem(soc.getNickname());
        });
        jComboSocios.setEnabled(true);
    }
   
    public void initSteps() {
        addFinal.setVisible(false);
        step1.setVisible(false);
        step2.setVisible(false);
        step4.setVisible(false);
        step3.setVisible(false);
        step5.setVisible(false);
    }
    
    public void fillSelectedClases() {
        this.selectedClases.setText("Clases Seleccionadas: " + CustomClick.selectedClaseId.size());
       
    }
    
    ActionListener autoFillSelectedClasses = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            fillSelectedClases();
        }
    };

    
    public void initTableClases() {
        if(this.selectedActividadId < 0){
            
            return;
        }
        
     
        try {
             DefaultTableModel modeloDatos = (DefaultTableModel) this.tablaClases.getModel(); 
             HashMap<Integer, DtClase> allClasses = claseBO.listarClasesByAct(this.selectedActividadId);
             modeloDatos.setRowCount(0);
             allClasses.forEach((Integer key, DtClase clase) -> {
     
                RenderFoto photoCell = new RenderFoto();
                photoCell.setHorizontalAlignment(SwingConstants.CENTER);
                this.tablaClases.getColumnModel().getColumn(0).setCellRenderer(photoCell);
                String filePath = "";
                if (clase.getImage() != null) {
                    filePath = clase.getImage().getAbsolutePath();
                }
                modeloDatos.addRow(new Object[]{ key,filePath, clase.getNombre(),clase.getFecha(), clase.getCapMinima(), clase.getCapMaxima()});
              
            });
             
     
         }  catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
        
         
       
    }
    
    public AgregarRegistros() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        dispose();
        setText();
        initSteps();
        llenarComboboxInstituciones();
        llenarComboboxSocios();
        this.tablaClases.getColumnModel().getColumn(1).setMinWidth(0);
        this.tablaClases.getColumnModel().getColumn(1).setMaxWidth(0);
        this.tablaClases.getColumnModel().getColumn(1).setWidth(0);
        this.tablaClases.setRowHeight(50);
        this.tablaClases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    public void nextStep() {
        
     
      
        addFinal.setVisible(false);
        if (!step1.isVisible() && !step2.isVisible() && !step4.isVisible() && !step3.isVisible() && !step5.isVisible()) {
            initSteps();
            step1.setVisible(true);
            return;
        }
        if (!step2.isVisible() && step1.isVisible() && !step4.isVisible() && !step3.isVisible() && !step5.isVisible()) {
            initSteps();
            step2.setVisible(true);
            return;
        }
        if (!step1.isVisible() && step2.isVisible() && !step4.isVisible() && !step3.isVisible() && !step5.isVisible()) {
            initSteps();
            step3.setVisible(true);
            return;
        }
        if (!step1.isVisible() && !step2.isVisible() && step3.isVisible() && !step4.isVisible()  && !step5.isVisible()) {
            initSteps();
            initTableClases();
            step4.setVisible(true);
            
            return;
        }
        
        if (!step1.isVisible() && !step2.isVisible() && !step3.isVisible() && step4.isVisible() && !step5.isVisible()) {
            initSteps();
            addFinal.setVisible(true);
            step5.setVisible(true);
           
            return;
        }
        
         if (!step1.isVisible() && !step2.isVisible() && !step3.isVisible() && !step4.isVisible() && step5.isVisible()) {
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
        addFinal.setVisible(false);
        if (step5.isVisible() && !step2.isVisible() && !step3.isVisible() && !step4.isVisible() &&  !step1.isVisible()) {
            initTableClases();
            step4.setVisible(true);
            step5.setVisible(false);
            return;
        }
        if (step4.isVisible() && !step1.isVisible() && !step2.isVisible() && !step3.isVisible() &&  !step5.isVisible()) {
            step3.setVisible(true);
            step4.setVisible(false);
            return;
        }
        if (step3.isVisible() && !step1.isVisible() && !step4.isVisible() && !step2.isVisible() &&  !step5.isVisible()) {
            initSteps();
            step2.setVisible(true);
            step3.setVisible(false);
            return;
        }
        if (step2.isVisible() && !step1.isVisible() && !step4.isVisible() && !step3.isVisible() &&  !step5.isVisible()) {
            initTableClases();
            initSteps();
            step1.setVisible(true);
            step2.setVisible(false);
            return;
        }
        
        if (step5.isVisible() && !step1.isVisible() && !step2.isVisible() && !step3.isVisible() &&  !step4.isVisible()) {
            initSteps();
            step5.setVisible(true);
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

        bgPanel = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        back = new javax.swing.JButton();
        addFinal = new javax.swing.JButton();
        step1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboInstitucion = new javax.swing.JComboBox<>();
        step2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboActividad = new javax.swing.JComboBox<>();
        step3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboSocios = new javax.swing.JComboBox<>();
        selectedClases = new javax.swing.JLabel();
        dragBar = new javax.swing.JLabel();
        btnMinimizarBG = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnExitBG = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        step5 = new javax.swing.JPanel();
        jComboBoxCupo = new javax.swing.JComboBox<>();
        jCheckBoxCuponera = new javax.swing.JCheckBox();
        step4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClases = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(780, 560));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(780, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 215, 215)));
        bgPanel.setMaximumSize(new java.awt.Dimension(910, 560));
        bgPanel.setMinimumSize(new java.awt.Dimension(910, 560));
        bgPanel.setPreferredSize(new java.awt.Dimension(910, 560));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(41, 69, 87));
        Header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Header.setText("Agregar Registro a Clase");
        bgPanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 910, 40));

        next.setBackground(new java.awt.Color(76, 131, 122));
        next.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("Next");
        next.setToolTipText("");
        next.setActionCommand("");
        next.setBorder(null);
        next.setFocusPainted(false);
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
        bgPanel.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 110, 40));

        back.setBackground(new java.awt.Color(76, 131, 122));
        back.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setToolTipText("");
        back.setBorder(null);
        back.setFocusPainted(false);
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
        bgPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 110, 40));

        addFinal.setBackground(new java.awt.Color(76, 131, 122));
        addFinal.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        addFinal.setForeground(new java.awt.Color(255, 255, 255));
        addFinal.setText("Agregar");
        addFinal.setToolTipText("");
        addFinal.setActionCommand("");
        addFinal.setBorder(null);
        addFinal.setFocusPainted(false);
        addFinal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        addFinal.setName(""); // NOI18N
        addFinal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFinalMouseClicked(evt);
            }
        });
        addFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFinalActionPerformed(evt);
            }
        });
        bgPanel.add(addFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 110, 40));

        step1.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel3.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel3.setText("Seleccione una Institucion");
        step1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jComboInstitucion.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jComboInstitucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboInstitucion.setFocusable(false);
        jComboInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboInstitucionActionPerformed(evt);
            }
        });
        step1.add(jComboInstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 30));

        bgPanel.add(step1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 320, 70));

        step2.setBackground(new java.awt.Color(255, 255, 255));
        step2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        step2.setForeground(new java.awt.Color(0, 153, 153));
        step2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel4.setText("Seleccione una Actividad");
        step2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jComboActividad.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jComboActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboActividad.setFocusable(false);
        jComboActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboActividadActionPerformed(evt);
            }
        });
        step2.add(jComboActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 30));

        bgPanel.add(step2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 320, 70));

        step3.setBackground(new java.awt.Color(255, 255, 255));
        step3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 153)));
        step3.setForeground(new java.awt.Color(0, 153, 153));
        step3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel5.setText("Seleccione un socio");
        step3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jComboSocios.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jComboSocios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboSocios.setFocusable(false);
        jComboSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboSociosActionPerformed(evt);
            }
        });
        step3.add(jComboSocios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, 30));

        bgPanel.add(step3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 320, 70));

        selectedClases.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        selectedClases.setText("Clases Seleccionadas: ");
        bgPanel.add(selectedClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

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
        bgPanel.add(dragBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 30));

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
            .addGroup(btnMinimizarBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnMinimizarBGLayout.setVerticalGroup(
            btnMinimizarBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        bgPanel.add(btnMinimizarBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 30, 20));

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

        bgPanel.add(btnExitBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 30, 20));

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione una Clase Disponible");
        bgPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        step5.setBackground(new java.awt.Color(255, 255, 255));
        step5.setForeground(new java.awt.Color(255, 255, 255));

        jComboBoxCupo.setEnabled(false);
        jComboBoxCupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCupoActionPerformed(evt);
            }
        });

        jCheckBoxCuponera.setActionCommand("jCheckBoxAplicarCup");
        jCheckBoxCuponera.setLabel("Aplicar cuponera?");
        jCheckBoxCuponera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCuponeraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout step5Layout = new javax.swing.GroupLayout(step5);
        step5.setLayout(step5Layout);
        step5Layout.setHorizontalGroup(
            step5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(step5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCuponera)
                    .addComponent(jComboBoxCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        step5Layout.setVerticalGroup(
            step5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, step5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jCheckBoxCuponera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jCheckBoxCuponera.getAccessibleContext().setAccessibleName("ds");

        bgPanel.add(step5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 320, -1));

        tablaClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Foto", "Nombre", "Fecha", "CapMin", "CapMax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClases);

        javax.swing.GroupLayout step4Layout = new javax.swing.GroupLayout(step4);
        step4.setLayout(step4Layout);
        step4Layout.setHorizontalGroup(
            step4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, step4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        step4Layout.setVerticalGroup(
            step4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bgPanel.add(step4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 550, 310));

        getContentPane().add(bgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void step1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_step1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_step1FocusGained

    private void step1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_step1FocusLost
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
        this.resetSelectedCuponeras();
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
        this.resetSelectedCuponeras();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboInstitucionActionPerformed

    private void jComboSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboSociosActionPerformed
        Object selectedItem = this.jComboSocios.getSelectedItem();
        if (selectedItem != null) {
            String selectedSocName = selectedItem.toString();
            socios.forEach((Integer key, SocioDTO soc) -> {
                if (soc.getNickname().equals(selectedSocName)) {
                    this.selectedSocioId = soc.getId();
                }
            });
            // this.llenarActividades();
        }
        this.resetSelectedCuponeras();
// TODO add your handling code here:
    }//GEN-LAST:event_jComboSociosActionPerformed

    private void addFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFinalMouseClicked
         try {
            int selectedRowId = this.tablaClases.getSelectedRow();
            if(selectedRowId == -1){
                JOptionPane.showMessageDialog(new JFrame(), "Error, seleccione una clase existente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
  
            Object idObj = this.tablaClases.getValueAt(selectedRowId, 0);
            int selectedClaseID = (Integer) idObj;
            
            DtRegistro reg = new DtRegistro(0, null, new Date(), "", "");

            regBO.agregarRegistro(selectedSocioId,selectedClaseID, reg,this.selectedCuponeraId);
            JOptionPane.showMessageDialog(new JFrame(), "Se registo correctamente el socio a las clases seleccionadas" , "Registro completado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addFinalMouseClicked

    private void addFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFinalActionPerformed
       
    }//GEN-LAST:event_addFinalActionPerformed

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

    private void jCheckBoxCuponeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCuponeraActionPerformed
       boolean isSelected = this.jCheckBoxCuponera.isSelected();
       if(isSelected)  { 
           if(this.selectedSocioId == -1 || this.selectedActividadId == -1){ 
               return;
           }
           this.cuponerasDisponibles = this.cupBO.listarCuponerasDisponiblesBySocio(this.selectedSocioId,this.selectedActividadId);
           this.renderListCuponerasDisp();
           this.jComboBoxCupo.setEnabled(true);
           
           return;
       }
       this.jComboBoxCupo.setEnabled(true);
       this.jComboBoxCupo.removeAllItems();
       this.selectedCuponeraId = null;
       
    }//GEN-LAST:event_jCheckBoxCuponeraActionPerformed

    
    private void renderListCuponerasDisp(){
        this.jComboBoxCupo.removeAllItems();
        Iterator<DtCuponera> it = this.cuponerasDisponibles.values().iterator();
        DtCuponera curr;
        if(it.hasNext()){
           curr = it.next();
           this.selectedCuponeraId = curr.getId();  //asignamos el primer elemento al valor del checkbox
            this.jComboBoxCupo.addItem(curr.getNombre());
        }

        while(it.hasNext()){
            curr = it.next();
            this.jComboBoxCupo.addItem(curr.getNombre()); 
        
            
        }
        
    }
    private void jComboBoxCupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCupoActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void llenarActividades() {
        this.jComboActividad.removeAllItems();
        actividades = actBo.listarActividades(this.selectedInstitucionId,"Aceptada");
        actividades.forEach((Integer key, ActividadDTO actividad) -> {
            this.jComboActividad.addItem(actividad.getNombre());
        });
        this.jComboActividad.setEnabled(true);
    }
    
    private void resetSelectedCuponeras(){
        this.jCheckBoxCuponera.setSelected(false);
        this.jComboBoxCupo.removeAllItems();
        this.cuponerasDisponibles.clear();
        this.selectedCuponeraId = null;
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
    private javax.swing.JLabel Header;
    private javax.swing.JButton addFinal;
    private javax.swing.JButton back;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel btnExit;
    private javax.swing.JPanel btnExitBG;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JPanel btnMinimizarBG;
    private javax.swing.JLabel dragBar;
    private javax.swing.JCheckBox jCheckBoxCuponera;
    private javax.swing.JComboBox<String> jComboActividad;
    private javax.swing.JComboBox<String> jComboBoxCupo;
    private javax.swing.JComboBox<String> jComboInstitucion;
    private javax.swing.JComboBox<String> jComboSocios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JLabel selectedClases;
    private javax.swing.JPanel step1;
    private javax.swing.JPanel step2;
    private javax.swing.JPanel step3;
    private javax.swing.JPanel step4;
    private javax.swing.JPanel step5;
    private javax.swing.JTable tablaClases;
    // End of variables declaration//GEN-END:variables
}
