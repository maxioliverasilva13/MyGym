/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package mygym.presentacion.pages;

import Usuario.IUsuarioBO;
import Usuario.UsuarioBO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import mygym.presentacion.components.UserCard;
import javax.swing.border.EmptyBorder;
import mygym.presentacion.forms.AddUsersForm;

/**
 *
 * @author maximilianooliverasilva
 */
public class Usuarios extends javax.swing.JPanel {
    AddUsersForm form = new AddUsersForm();
    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();
        JPanel panelContent = new JPanel(new GridLayout(3, 3, 10,10));
        panelContent.setBorder(new EmptyBorder(0,0,0,0));
        panelContent.setBackground(Color.white); 
        //panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                 LoadUsers(panelContent);
                 revalidate();
                 repaint();
            }
        });
        JScrollPane js = new JScrollPane(panelContent,
          JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
          JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js.setBounds(0,35,720,540);
        js.setBorder(new EmptyBorder(0,0,0,0));
        js.getVerticalScrollBar().setUnitIncrement(16);
        add(js);
        revalidate();
        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(720, 540));

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 69, 87));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuarios");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(addButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addButton)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(514, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (!form.isVisible()) {
            form.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void LoadUsers(JPanel panel){
        panel.removeAll();
        IUsuarioBO usuarioBo = new UsuarioBO();
        int sizeOfRows = usuarioBo.listarUsuarios().size();
        usuarioBo.listarUsuarios().forEach((key,user) -> {
           UserCard card = new UserCard(key,user.getNombre(),user.getApellido(),user.getEmail());
           card.setSize(120, 90);
           panel.add(card);
        });
        new GridLayout((sizeOfRows / 3) + 1, 3, 10,10);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
