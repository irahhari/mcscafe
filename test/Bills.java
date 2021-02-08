

import MCsCafe.LoginPage;
import MCsCafe.UserRegistration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author harig
 */
public class Bills extends javax.swing.JFrame {

    /**
     * Creates new form Bills
     */
    @SuppressWarnings("unchecked")
    public Bills() {
        File file = new File(System.getProperty("user.dir") + "\\lib\\log.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }

        this.numbers = new ArrayList<>();
        initComponents();

        JComboBox c = new JComboBox();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
            stmt = con.createStatement();
            String query = "SELECT code FROM food;";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                c.addItem(rs.getString(1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            try {
                Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                        + " Bills:75:Bills\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }

        jTable1.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(c));
        ComboRenderer renderer = new ComboRenderer();
        jTable1.setDefaultRenderer(Object.class, renderer);
        AutoCompleteDecorator.decorate(c);
        createKeybindings(jTable1);
    }

    private void createKeybindings(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "Tab");
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Tab");
        table.getActionMap().put("Tab", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int col = table.getSelectedColumn();
                table.editCellAt(table.getSelectedRow(), 4);
                table.editCellAt(table.getSelectedRow(), col);
                if (table.getSelectedRow() != -1) {
                    boolean b1 = table.getModel().getValueAt(table.getSelectedRow(), 3) != null;
                    boolean b2 = table.getValueAt(table.getSelectedRow(), 2) != null;
                    if (b1 && b2) {
                        table.setValueAt((int) table.getValueAt(table.getSelectedRow(), 3) * (int) table.getValueAt(table.getSelectedRow(), 2), table.getSelectedRow(), 4);

                        int total = 0;
                        for (int i = 0; i < table.getRowCount(); i++) {
                            if (table.getValueAt(i, 4) != null) {
                                total += (int) table.getValueAt(i, 4);
                            }
                        }
                        TotalTF.setText("" + total);   //CALCULATES AND SETS TOTAL VALUE
                    }
                }

                if (table.getSelectedColumn() == 0) {
                    table.changeSelection(table.getSelectedRow(), 3, false, false);     //MOVES TO NEXT EDITABLE CELL WHEN TAB IS RELEASED(TAKE NOTE YOU MUST ADD ONE TO THE GETELECTED COLUMN BECAUSE THE TAB ALREADY MOVES IT TO THE NEXT CELL BEFORE EVENT IS CALLED)
                    table.editCellAt(table.getSelectedRow(), 3);
                    table.transferFocus();
                } else if (table.getSelectedColumn() == 3) {
                    int row = table.getSelectedRow();
                    if (row == table.getRowCount() - 1 && table.getValueAt(row, table.getColumnCount() - 1) != null) {
                        model.addRow(new Object[]{null, null, null, null, null});  //ADDS NEW EMPTY ROW WHEN AT LAST CELL
                    }
                    table.changeSelection(table.getSelectedRow() + 1, 0, false, false);
                    table.editCellAt(table.getSelectedRow(), 0);
                    table.transferFocus();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AddressTF = new javax.swing.JTextField();
        NameCB = new javax.swing.JComboBox<>();
        MobileTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TotalTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UPIRB = new javax.swing.JRadioButton();
        CardRB = new javax.swing.JRadioButton();
        PostpaidRB = new javax.swing.JRadioButton();
        CashRB = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        AmountTF = new javax.swing.JTextField();
        ReturnTF = new javax.swing.JTextField();
        BillBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        MenuBtn = new javax.swing.JButton();
        WACB = new javax.swing.JCheckBox();
        ParcelCB = new javax.swing.JCheckBox();
        TACB = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bill | MC's Café");
        setMinimumSize(new java.awt.Dimension(580, 580));

        jLabel1.setText("Bill");

        jLabel2.setText("Address");

        jLabel3.setText("Name");

        jLabel4.setText("Mobile");

        AddressTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AddressTFKeyTyped(evt);
            }
        });

        NameCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NameCBItemStateChanged(evt);
            }
        });

        MobileTF.setEditable(false);
        MobileTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        MobileTF.setEnabled(false);

        jButton1.setMnemonic('S');
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Item Code", "Item Name", "Rate", "Quantity", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel5.setText("Total");

        TotalTF.setEditable(false);
        TotalTF.setDisabledTextColor(java.awt.Color.black);

        jLabel6.setText("Payment");

        buttonGroup1.add(UPIRB);
        UPIRB.setText("UPI");
        UPIRB.setEnabled(false);

        buttonGroup1.add(CardRB);
        CardRB.setText("Card");
        CardRB.setEnabled(false);

        buttonGroup1.add(PostpaidRB);
        PostpaidRB.setText("Postpaid");
        PostpaidRB.setEnabled(false);

        buttonGroup1.add(CashRB);
        CashRB.setText("Cash");
        CashRB.setEnabled(false);
        CashRB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CashRBItemStateChanged(evt);
            }
        });

        jLabel7.setText("Customer gave");

        jLabel8.setText("Return");

        AmountTF.setDisabledTextColor(java.awt.Color.black);
        AmountTF.setEnabled(false);
        AmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmountTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AmountTFKeyTyped(evt);
            }
        });

        ReturnTF.setDisabledTextColor(java.awt.Color.black);
        ReturnTF.setEnabled(false);

        BillBtn.setMnemonic('B');
        BillBtn.setText("Bill");
        BillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillBtnActionPerformed(evt);
            }
        });

        CancelBtn.setMnemonic('C');
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        MenuBtn.setMnemonic('M');
        MenuBtn.setText("Back to Menu");
        MenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBtnActionPerformed(evt);
            }
        });

        WACB.setSelected(true);
        WACB.setText("Send WhatsApp Message");

        ParcelCB.setSelected(true);
        ParcelCB.setText("Parcel");
        ParcelCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ParcelCBItemStateChanged(evt);
            }
        });

        TACB.setText("Take Away");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelBtn)
                        .addGap(73, 73, 73)
                        .addComponent(BillBtn)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TotalTF, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(AmountTF)
                                    .addComponent(ReturnTF)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(MenuBtn)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddressTF)
                            .addComponent(NameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(MobileTF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TACB)
                                .addGap(18, 18, 18)
                                .addComponent(ParcelCB))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(UPIRB)
                                .addGap(18, 18, 18)
                                .addComponent(CardRB)
                                .addGap(18, 18, 18)
                                .addComponent(PostpaidRB)
                                .addGap(18, 18, 18)
                                .addComponent(CashRB))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(WACB)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(NameCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MobileTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TotalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ParcelCB)
                    .addComponent(TACB))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(UPIRB)
                    .addComponent(CardRB)
                    .addComponent(PostpaidRB)
                    .addComponent(CashRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ReturnTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(WACB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BillBtn)
                    .addComponent(CancelBtn)
                    .addComponent(MenuBtn))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AmountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTFKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_AmountTFKeyTyped

    private void CashRBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CashRBItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            AmountTF.setEnabled(true);
        } else {
            AmountTF.setEnabled(false);
            AmountTF.setText("");
            ReturnTF.setText("");
        }
    }//GEN-LAST:event_CashRBItemStateChanged

    private void AddressTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddressTFKeyTyped
        // TODO add your handling code here:
        if (AddressTF.getText().length() >= 5 || !Character.isLetterOrDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_AddressTFKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NameCB.removeAllItems();
        numbers.removeAll(numbers);
        TotalTF.setText("");

        if ("".equals(AddressTF.getText())) {
            JOptionPane.showMessageDialog(this, "Enter the address", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
            stmt = con.createStatement();
            String query = "SELECT Name, Mobile FROM user WHERE Address LIKE '" + AddressTF.getText() + "%';";
            rs = stmt.executeQuery(query);
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "User not Registered", "Warning", JOptionPane.WARNING_MESSAGE);
                new UserRegistration().setVisible(true);
                this.setVisible(false);
            } else {
                do {
                    numbers.add(rs.getLong(2));
                    NameCB.addItem(rs.getString(1));
                } while (rs.next());
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            try {
                Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                        + " Bills:521:jButton1ActionPerformed\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NameCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NameCBItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED && NameCB.getSelectedIndex() != -1)
            MobileTF.setText("" + numbers.get(NameCB.getSelectedIndex()));
    }//GEN-LAST:event_NameCBItemStateChanged

    private void AmountTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTFKeyReleased
        // TODO add your handling code here:
        if (!"".equals(AmountTF.getText()) && !"".equals(TotalTF.getText())) {
            int total = Integer.parseInt(TotalTF.getText());
            int amount = Integer.parseInt(AmountTF.getText());
            if (amount >= total) {
                ReturnTF.setText("" + (amount - total));    //CALCULATES AMOUNT TO BE RETURNED BY CUSTOMER
            } else {
                ReturnTF.setText("");
            }
        }
    }//GEN-LAST:event_AmountTFKeyReleased

    private void BillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillBtnActionPerformed
        // TODO add your handling code here:
        if (jTable1.getValueAt(jTable1.getRowCount() - 1, 0) == null) {
            ((DefaultTableModel) jTable1.getModel()).setRowCount(jTable1.getRowCount() - 1);
        }

        long mobile;
        int price, outstanding = 0;

        try {
            mobile = Long.parseLong(MobileTF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter address and choose a name", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            price = Integer.parseInt(TotalTF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter items", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (("".equals(ReturnTF.getText()) && CashRB.isSelected())) {
            JOptionPane.showMessageDialog(this, "Enter Receiving Amount!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        String method = null, methods = null, time = timestamp.substring(0, timestamp.indexOf('.'));
        if (ParcelCB.isSelected()) {
            methods = "Pay%20after%20delivery";
        } else if (UPIRB.isSelected()) {
            method = "U";
            methods = "UPI";
        } else if (CardRB.isSelected()) {
            method = "B";
            methods = "Card";
        } else if (CashRB.isSelected()) {
            method = "C";
            methods = "Cash";
        } else if (PostpaidRB.isSelected()) {
            method = "P";
            methods = "Postpaid";
        } else {
            JOptionPane.showMessageDialog(this, "Choose a Payment Method!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
            stmt = con.createStatement();
            String query;
            if (ParcelCB.isSelected()) {
                price += 10;
                query = "INSERT INTO bill VALUES('" + time + "'," + mobile + "," + price + ",null,'P');";
            } else {
                query = "INSERT INTO bill VALUES('" + time + "'," + mobile + "," + price + ",'" + method + "','D');";
            }
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Bill Processed!");
        } catch (ClassNotFoundException | SQLException e) {
            try {
                Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                        + " Bills:632:BillBtnActionPerformed For Inserting into Bill\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
            }
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }

        if (ParcelCB.isSelected()) {
            String item = "";
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                item += (jTable1.getValueAt(i, 3) + " " + jTable1.getValueAt(i, 1) + "\n");
            }
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query;
                if (TACB.isSelected()) {
                    query = "INSERT INTO queue VALUES('" + time + "'," + mobile + ",'" + item + "'," + price + ",'F','M');";
                } else {
                    query = "INSERT INTO queue VALUES('" + time + "'," + mobile + ",'" + item + "'," + price + ",'F','F');";
                }
                stmt.executeUpdate(query);
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " Bills:664:BillBtnActionPerformed For Inserting into Queue\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException ex) {
                }
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                    }
                }
            }
        } else if (PostpaidRB.isSelected()) {
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "SELECT outstanding FROM postpaid where mobile=" + mobile + ";";
                rs = stmt.executeQuery(query);
                rs.next();
                outstanding = rs.getInt(1);
                query = "INSERT INTO postpaid VALUES (" + mobile + "," + price + ") ON DUPLICATE KEY UPDATE outstanding = outstanding +" + price + ";";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Postpaid Updated! Outstanding Balance: " + (outstanding + price));
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " Bills:697:BillBtnActionPerformed For Getting/Inserting from/into Postpaid\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException ex) {
                }
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }

        String items = "Hello%20from%20MC's%20Café!%0D%0A%0D%0ANet%20Amount%20Payable%3A%20%E2%82%B9" + price + "%0D%0APayment%20Method%3A%20" + methods + "%0D%0A%0D%0A";
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            items += (jTable1.getValueAt(i, 3) + "%20" + jTable1.getValueAt(i, 1) + "%20(%E2%82%B9" + jTable1.getValueAt(i, 2) + ")%20-%20%E2%82%B9" + jTable1.getValueAt(i, 4) + "%0D%0A");
        }

        CancelBtn.doClick();

        if (ParcelCB.isSelected()) {
            items += "%0D%0AParcel%20Charges%20-%20%E2%82%B910%0D%0A";
        } else if (PostpaidRB.isSelected()) {
            items += "%0D%0AOutstanding%20Balance%3A%20%20%E2%82%B9" + (outstanding + price) + "%0D%0A";
        }

        if (WACB.isSelected()) {
            try {
                URI url = new URI(("https://wa.me/91" + mobile + "?text=" + items + "%0D%0AThank%20you%20for%20dining%20with%20us%2C%0D%0AHope%20to%20see%20you%20again!").replaceAll(" ", "%20"));
                java.awt.Desktop.getDesktop().browse(url);
            } catch (IOException | URISyntaxException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " Bills:788:BillBtnActionPerformed For Opening WA\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
                } catch (IOException ex) {
                }
            }
        }
    }//GEN-LAST:event_BillBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        new Bills().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void MenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBtnActionPerformed
        // TODO add your handling code here:
        new MCsCafe.MenuPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuBtnActionPerformed

    private void ParcelCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ParcelCBItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            buttonGroup1.clearSelection();
            UPIRB.setEnabled(false);
            CardRB.setEnabled(false);
            PostpaidRB.setEnabled(false);
            CashRB.setEnabled(false);
            TACB.setEnabled(true);
        } else {
            UPIRB.setEnabled(true);
            CardRB.setEnabled(true);
            PostpaidRB.setEnabled(true);
            CashRB.setEnabled(true);
            TACB.setEnabled(false);
        }
        TACB.setSelected(false);
    }//GEN-LAST:event_ParcelCBItemStateChanged

    private ArrayList<Long> numbers;

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
                        + " Bills:844:main\n" + ex.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            }
        }
        //</editor-fold>

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressTF;
    private javax.swing.JTextField AmountTF;
    private javax.swing.JButton BillBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JRadioButton CardRB;
    private javax.swing.JRadioButton CashRB;
    private javax.swing.JButton MenuBtn;
    private javax.swing.JTextField MobileTF;
    private javax.swing.JComboBox<String> NameCB;
    private javax.swing.JCheckBox ParcelCB;
    private javax.swing.JRadioButton PostpaidRB;
    private javax.swing.JTextField ReturnTF;
    private javax.swing.JCheckBox TACB;
    private javax.swing.JTextField TotalTF;
    private javax.swing.JRadioButton UPIRB;
    private javax.swing.JCheckBox WACB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
