/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inface;

import codes.DBconnect;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ASUS
 */
public class menu extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }
    
    public void tableload(){
        
        try {
            
            String sql = "SELECT empId,empName,age,cluster FROM employee";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Table01.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tabledata(){
        
        int r = Table01.getSelectedRow();
        
        String id = Table01.getValueAt(r, 0).toString();
        String name = Table01.getValueAt(r, 1).toString();
        String age = Table01.getValueAt(r, 2).toString();
        String cluster = Table01.getValueAt(r, 3).toString();
        
        Idbox.setText(id);
        Namebox.setText(name);
        Agebox.setText(age);
        Clusterbox.setSelectedItem(cluster);
    }
    
    public void search() {
        
        String srch = Searchbox.getText();
        
        try {
            String sql = "SELECT empId,empName,age,cluster FROM employee WHERE empName LIKE'%"+srch+"%' OR empId LIKE'%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Table01.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void update() {
        
        String id = Idbox.getText();
        String name = Namebox.getText();
        String age = Agebox.getText();
        String cluster = Clusterbox.getSelectedItem().toString();
        
        try {
             String sql = "UPDATE employee SET empName='"+name+"',age='"+age+"',cluster='"+cluster+"'WHERE empId='"+id+"'";
             pst = conn.prepareStatement(sql);
             pst.execute();
             JOptionPane.showMessageDialog(null, "updated!");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "error!");
        }
    }
    
    public void clear() {
         
        Searchbox.setText(" ");
        Idbox.setText(" ");
        Namebox.setText(" ");
        Agebox.setText(" ");
        Clusterbox.setSelectedIndex(0);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Namebox = new javax.swing.JTextField();
        Agebox = new javax.swing.JTextField();
        Clusterbox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        Idbox = new javax.swing.JTextField();
        Deletebutton = new javax.swing.JButton();
        Insertbutton = new javax.swing.JButton();
        Updatebutton = new javax.swing.JButton();
        Clearbutton = new javax.swing.JButton();
        Exitbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table01 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 18))); // NOI18N

        Searchbox.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        Searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Searchbox)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("Age");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("Cluster");

        Namebox.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        Namebox.setToolTipText("Enter your Name");

        Agebox.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        Agebox.setToolTipText("Enter your Age");

        Clusterbox.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Clusterbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Cluster A", "Cluster B", "Cluster C", "Cluster D", "Cluster E", " ", " " }));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setText("EmpId");

        Idbox.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        Idbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agebox, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(52, 52, 52)
                                .addComponent(Idbox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(Clusterbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Idbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Namebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Agebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clusterbox))
                .addGap(41, 41, 41))
        );

        Deletebutton.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Deletebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inface/icons8-delete-30.jpg"))); // NOI18N
        Deletebutton.setText("Delete");
        Deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebuttonActionPerformed(evt);
            }
        });

        Insertbutton.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Insertbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inface/icons8-insert-30.jpg"))); // NOI18N
        Insertbutton.setText("Insert");
        Insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertbuttonActionPerformed(evt);
            }
        });

        Updatebutton.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Updatebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inface/icons8-update-4811.jpg"))); // NOI18N
        Updatebutton.setText("Update");
        Updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebuttonActionPerformed(evt);
            }
        });

        Clearbutton.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Clearbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inface/clear01.jpg"))); // NOI18N
        Clearbutton.setText("Clear");
        Clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbuttonActionPerformed(evt);
            }
        });

        Exitbutton.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Exitbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inface/icons8-exit-32.jpg"))); // NOI18N
        Exitbutton.setText("Exit");
        Exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Updatebutton)
                            .addComponent(Insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Deletebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(Exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insertbutton)
                    .addComponent(Deletebutton))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Updatebutton)
                    .addComponent(Clearbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(Exitbutton)
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 470, 600));

        Table01.setFont(new java.awt.Font("Leelawadee UI", 1, 13)); // NOI18N
        Table01.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table01MouseClicked(evt);
            }
        });
        Table01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table01KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table01);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 790, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertbuttonActionPerformed

        String name;
        int age;
        String cluster;
        
        name = Namebox.getText();
        age = Integer.parseInt(Agebox.getText());
        cluster = (String) Clusterbox.getSelectedItem();
        
        try {
            
            String sql = "INSERT INTO employee(empName,age,cluster)VALUES ('"+name+"','"+age+"','"+cluster+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Inserted!");
            
            
        } catch (SQLException | HeadlessException e) {
            
            JOptionPane.showMessageDialog(null,e);
            
        }
        
        tableload();
        
    }//GEN-LAST:event_InsertbuttonActionPerformed

    private void Table01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table01MouseClicked
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_Table01MouseClicked

    private void Table01KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table01KeyReleased

        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_Table01KeyReleased

    private void SearchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchboxKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_SearchboxKeyReleased

    private void UpdatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebuttonActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
    }//GEN-LAST:event_UpdatebuttonActionPerformed

    private void IdboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdboxActionPerformed

    private void DeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebuttonActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null, "do you want to delete!");
        
        if(check==0) {
            String id = Idbox.getText();
            try {
                
                String sql = "DELETE FROM employee WHERE empId='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error!");
            }
        }
        tableload();
        clear();
    }//GEN-LAST:event_DeletebuttonActionPerformed

    private void ClearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbuttonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_ClearbuttonActionPerformed

    private void ExitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitbuttonActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_ExitbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Agebox;
    private javax.swing.JButton Clearbutton;
    private javax.swing.JComboBox Clusterbox;
    private javax.swing.JButton Deletebutton;
    private javax.swing.JButton Exitbutton;
    private javax.swing.JTextField Idbox;
    private javax.swing.JButton Insertbutton;
    private javax.swing.JTextField Namebox;
    private javax.swing.JTextField Searchbox;
    private javax.swing.JTable Table01;
    private javax.swing.JButton Updatebutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void intComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void searchm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
