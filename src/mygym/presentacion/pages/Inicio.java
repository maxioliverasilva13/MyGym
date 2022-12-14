/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mygym.presentacion.pages;
//import mygym.presentacion.pages.Instituciones;
import Actividad.ActividadBO;
import Actividad.dtos.ActividadDTO;
import Cuponera.CuponeraBo;
import Cuponera.DtCuponera;
import Institucion.DtInstitucion;
import Institucion.InstitucionBO;
import RegistroSitio.RegistroSitioDTO;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mygym.presentacion.pages.Cuponeras;
import mygym.presentacion.pages.Actividades;
import RegistroSitio.RegistroSitioBO;
import RegistroSitio.RegistroSitioDao;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import static mygym.presentacion.pages.Actividades.actividadesSistema;
import utils.RenderFoto;
/**
 *
 * @author maximilianooliverasilva
 */
public class Inicio extends javax.swing.JPanel {

    /**
     * Creates new form Inicio
     */
    InstitucionBO insBO = new InstitucionBO();
    ActividadBO actBO = new ActividadBO();
    CuponeraBo cupBo = new CuponeraBo();
    
    HashMap<Integer, DtCuponera> cuponerasSistema = new HashMap<>();
    HashMap<Integer, DtInstitucion> institucionesSistema = new HashMap<>(); 
    HashMap<Integer, ActividadDTO> actividadesSistema = new HashMap<>(); 

    RegistroSitioBO regsBO = new RegistroSitioBO();
    
    public Inicio() {
        initComponents();
        tablaInicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaInicio.setRowHeight(50);
        llenarTabla();
    }
        
    public void llenarTabla(){
        try {
            DefaultTableModel modeloDatos = (DefaultTableModel) tablaInicio.getModel();
            List<RegistroSitioDTO> registros = regsBO.listarRegistros();
            modeloDatos.setRowCount(0);
            registros.forEach((RegistroSitioDTO r) -> {
                modeloDatos.addRow(new Object[]{r.getId(), r.getUrl(), r.getBrowser(), r.getBrowser(), r.getIp()});
            });
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        Titulo = new javax.swing.JLabel();
        subTitulo = new javax.swing.JLabel();
        logoIns = new javax.swing.JLabel();
        inst = new javax.swing.JLabel();
        cantInstituciones = new javax.swing.JLabel();
        logoCup = new javax.swing.JLabel();
        cup = new javax.swing.JLabel();
        cantCuponeras = new javax.swing.JLabel();
        logoAct = new javax.swing.JLabel();
        act = new javax.swing.JLabel();
        cantActividades = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaInicio = new javax.swing.JTable();
        subTitulo1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 540));

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(215, 215, 215)));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(41, 69, 87));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Inicio");
        bgPanel.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        subTitulo.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        subTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitulo.setText("Acceso al sitio");
        bgPanel.add(subTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 220, 720, 20));

        logoIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/casa80.png"))); // NOI18N
        bgPanel.add(logoIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 90, -1));

        inst.setFont(new java.awt.Font("Dubai Light", 0, 24)); // NOI18N
        inst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inst.setText("Instituciones");
        bgPanel.add(inst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, 60));

        cantInstituciones.setFont(new java.awt.Font("Dubai Light", 0, 24)); // NOI18N
        cantInstituciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgPanel.add(cantInstituciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 210, 30));

        logoCup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoCup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pngwing90.png"))); // NOI18N
        bgPanel.add(logoCup, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 120, 80));

        cup.setFont(new java.awt.Font("Dubai Light", 0, 24)); // NOI18N
        cup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cup.setText("Cuponeras");
        bgPanel.add(cup, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 220, 60));

        cantCuponeras.setFont(new java.awt.Font("Dubai Light", 0, 24)); // NOI18N
        cantCuponeras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgPanel.add(cantCuponeras, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 220, 30));

        logoAct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/corriendo80.png"))); // NOI18N
        bgPanel.add(logoAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 130, 80));

        act.setFont(new java.awt.Font("Dubai Light", 0, 24)); // NOI18N
        act.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        act.setText("Actividades");
        bgPanel.add(act, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 210, 60));

        cantActividades.setFont(new java.awt.Font("Dubai Light", 0, 24)); // NOI18N
        cantActividades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgPanel.add(cantActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 210, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(76, 131, 122)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        bgPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 170, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(76, 131, 122)));
        jPanel2.setPreferredSize(new java.awt.Dimension(170, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        bgPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 180, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(76, 131, 122)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        bgPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 180, 50));

        scrollTabla.setBackground(new java.awt.Color(255, 255, 255));
        scrollTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        scrollTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tablaInicio.setAutoCreateRowSorter(true);
        tablaInicio.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        tablaInicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Url", "Browser", "Navegador", "Ip"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaInicio.setGridColor(new java.awt.Color(255, 255, 255));
        tablaInicio.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tablaInicio.setUpdateSelectionOnSort(false);
        scrollTabla.setViewportView(tablaInicio);

        bgPanel.add(scrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 640, 240));

        subTitulo1.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        subTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitulo1.setText("Estad??sticas del Sistema");
        bgPanel.add(subTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 720, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel act;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JLabel cantActividades;
    private javax.swing.JLabel cantCuponeras;
    private javax.swing.JLabel cantInstituciones;
    private javax.swing.JLabel cup;
    private javax.swing.JLabel inst;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logoAct;
    private javax.swing.JLabel logoCup;
    private javax.swing.JLabel logoIns;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JLabel subTitulo;
    private javax.swing.JLabel subTitulo1;
    private javax.swing.JTable tablaInicio;
    // End of variables declaration//GEN-END:variables
}
