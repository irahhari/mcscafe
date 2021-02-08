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
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author harig
 */
public class FoodRegistration extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public FoodRegistration() {
        initComponents();
        Price.setTransferHandler(null);
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
        jLabel4 = new javax.swing.JLabel();
        Code = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        Modify = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Food Registration | MC's Café");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("New Food Registration");

        jLabel2.setText("Food Code: ");

        jLabel3.setText("Food Name: ");

        jLabel4.setText("Food Price: ");

        Code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CodeKeyTyped(evt);
            }
        });

        Name.setEnabled(false);
        Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NameKeyTyped(evt);
            }
        });

        Price.setEnabled(false);
        Price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PriceKeyTyped(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Menu)
                        .addGap(51, 51, 51))))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Add)
                        .addGap(41, 41, 41)
                        .addComponent(Modify)
                        .addGap(31, 31, 31)
                        .addComponent(Delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Clear)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Search)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Clear)
                    .addComponent(Modify)
                    .addComponent(Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        String code = Code.getText().trim();
        String name = Name.getText().trim();
        String pric = Price.getText().trim();
        
        Connection con = null;
        Statement stmt = null;
        if (code.length() > 0 && name.length() > 0 && pric.length() > 0) {
            int price = Integer.parseInt(pric);
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "INSERT INTO food VALUES('" + code + "', '" + name + "', " + price + ");";
                stmt.executeUpdate(query);
                Clear.doClick();
            } catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(this, "Entered Code is already present", "Warning Message", JOptionPane.WARNING_MESSAGE);
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " FoodRegistration:282:AddActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
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

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        Code.setEnabled(true);
        Delete.setEnabled(false);
        Add.setEnabled(false);
        Modify.setEnabled(false);
        Code.setText("");
        Name.setText("");
        Price.setText("");
        Search.setEnabled(true);
        Name.setEnabled(false);
        Price.setEnabled(false);
    }//GEN-LAST:event_ClearActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        Search.setEnabled(false);
        Code.setEnabled(false);
        String code = Code.getText(), type;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        if (code.length() > 0) {
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "SELECT * FROM food WHERE Code='" + code + "';";
                rs = stmt.executeQuery(query);
                rs.next();
                Name.setText(rs.getString(2));
                Price.setText(rs.getInt(3) + "");
                Modify.setEnabled(true);
                Delete.setEnabled(true);
                Name.setEnabled(true);
                Price.setEnabled(true);
            } catch (ClassNotFoundException | SQLException e) {
                if ("Illegal operation on empty result set.".equals(e.getMessage())) {
                    Add.setEnabled(true);
                    Name.setEnabled(true);
                    Price.setEnabled(true);
                } else {
                    try {
                        Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                                + " FoodRegistration:364:SearchActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
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
        String code = Code.getText().trim();
        String name = Name.getText().trim();
        String pric = Price.getText().trim();
        
        Connection con = null;
        Statement stmt = null;
        if (code.length() > 0 && name.length() > 0 && pric.length() > 0) {
            int price = Integer.parseInt(pric);
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "UPDATE food SET Name='" + name + "', Price=" + price + " WHERE Code='" + code + "';";
                stmt.executeUpdate(query);
                Clear.doClick();
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " FoodRegistration:422:ModifyActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
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
        String code = Code.getText().trim();
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
            stmt = con.createStatement();
            String query = "DELETE FROM food WHERE Code='" + code + "';";
            stmt.executeUpdate(query);
            Clear.doClick();
        } catch (ClassNotFoundException | SQLException e) {
            try {
                Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                        + " FoodRegistration:459:DeleteActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
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

    private void NameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyTyped
        // TODO add your handling code here:
        if (Name.getText().length() >= 30)
            evt.consume();
    }//GEN-LAST:event_NameKeyTyped

    private void PriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceKeyTyped
        // TODO add your handling code here:
        if (Price.getText().length() >= 5 || !Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_PriceKeyTyped

    private void CodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeKeyTyped
        // TODO add your handling code here:
        if (Code.getText().length() >= 7)
            evt.consume();
    }//GEN-LAST:event_CodeKeyTyped

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuPage().setVisible(true);
    }//GEN-LAST:event_MenuActionPerformed

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
                        + " FoodRegistration:521:main\n" + ex.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            }
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FoodRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JTextField Code;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Menu;
    private javax.swing.JButton Modify;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Price;
    private javax.swing.JButton Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}