/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCsCafe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author harig
 */
public class BuyerRegistration extends javax.swing.JFrame {

    /**
     * Creates new form BuyerRegistration
     */
    public BuyerRegistration() {
        initComponents();
        Mobile.setTransferHandler(null);
        File file = new File(System.getProperty("user.dir") + "\\lib\\log.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Mobile = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        Modify = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Seller Registration | MC's Café");

        jLabel1.setText("Seller Registration");

        jLabel2.setText("Name");

        jLabel3.setText("Mobile Number");

        Name.setEnabled(false);
        Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NameKeyTyped(evt);
            }
        });

        Mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MobileKeyTyped(evt);
            }
        });

        Add.setMnemonic('A');
        Add.setText("Add");
        Add.setEnabled(false);
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Clear.setMnemonic('C');
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Search.setMnemonic('S');
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Modify.setMnemonic('M');
        Modify.setText("Modify");
        Modify.setEnabled(false);
        Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyActionPerformed(evt);
            }
        });

        Delete.setMnemonic('D');
        Delete.setText("Delete");
        Delete.setEnabled(false);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Menu.setMnemonic('B');
        Menu.setText("Back to Menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Search)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Add)
                        .addGap(28, 28, 28)
                        .addComponent(Modify)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Delete)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu)
                    .addComponent(Clear))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Clear)
                    .addComponent(Modify)
                    .addComponent(Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Menu)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        Name.setText("");
        Mobile.setText("");
        Add.setEnabled(false);
        Modify.setEnabled(false);
        Delete.setEnabled(false);
        Search.setEnabled(true);
        Mobile.setEnabled(true);
        Name.setEnabled(false);
    }//GEN-LAST:event_ClearActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        String mobile = Mobile.getText().trim();
        String name = Name.getText().trim();
        Connection con = null;
        Statement stmt = null;
        if (mobile.length() == 10 && name.length() > 0) {
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "INSERT INTO buyer VALUES('" + name + "', " + mobile + ");";
                stmt.executeUpdate(query);
                Clear.doClick();
            } catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(this, "Entered Mobile Number is already present", "Warning Message", JOptionPane.WARNING_MESSAGE);
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " BuyerRegistration:234:AddActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException ex) {
                }
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "All inputs are required", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_AddActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        String mobile = Mobile.getText().trim();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        if (mobile.length() == 10) {
            Search.setEnabled(false);
            Mobile.setEnabled(false);
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "SELECT * FROM buyer WHERE Mobile=" + mobile + ";";
                rs = stmt.executeQuery(query);
                rs.next();
                Name.setText(rs.getString(1));
                Modify.setEnabled(true);
                Delete.setEnabled(true);
                Name.setEnabled(true);
            } catch (ClassNotFoundException | SQLException e) {
                if ("Illegal operation on empty result set.".equals(e.getMessage())) {
                    Add.setEnabled(true);
                    Name.setEnabled(true);
                } else {
                    try {
                        Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                                + " BuyerRegistration:283:SearchActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException ex) {
                    }
                }
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Mobile number is required", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyActionPerformed
        // TODO add your handling code here:
        String mobile = Mobile.getText().trim();
        String name = Name.getText().trim();
        Connection con = null;
        Statement stmt = null;
        if (mobile.length() == 10 && name.length() > 0) {
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "UPDATE buyer SET Name='" + name + "' WHERE Mobile=" + mobile + ";";
                stmt.executeUpdate(query);
                Clear.doClick();
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " BuyerRegistration:329:ModifyActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException ex) {
                }
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "All inputs are required", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ModifyActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        String mobile = Mobile.getText().trim();
        String string = Name.getText().trim() + ", " + mobile;
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
            stmt = con.createStatement();
            String query = "DELETE FROM buyer WHERE Mobile=" + mobile + ";";
            stmt.executeUpdate(query);
            Clear.doClick();
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Clear current outstanding before deleting", "Warning", JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new Pending(string).setVisible(true);
        } catch (ClassNotFoundException | SQLException e) {
            try {
                Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                        + " BuyerRegistration:371:DeleteActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
            }
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuPage().setVisible(true);
    }//GEN-LAST:event_MenuActionPerformed

    private void NameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyTyped
        // TODO add your handling code here:
        if (Name.getText().length() >= 30)
            evt.consume();
    }//GEN-LAST:event_NameKeyTyped

    private void MobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileKeyTyped
        // TODO add your handling code here:
        if (Mobile.getText().length() >= 10 || !Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_MobileKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            try {
                Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                        + " BuyerRegistration:427:main\n" + ex.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            }
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuyerRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Menu;
    private javax.swing.JTextField Mobile;
    private javax.swing.JButton Modify;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}