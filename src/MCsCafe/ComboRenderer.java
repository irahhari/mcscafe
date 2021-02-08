/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCsCafe;

import java.awt.Component;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Santosh
 */
public class ComboRenderer implements TableCellRenderer {

    private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int rowIndex, int vColIndex) {

        Component c = RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, rowIndex, vColIndex);

        if ((vColIndex == 1 || vColIndex == 2) && table.getValueAt(rowIndex, 0) != null) {
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/mcscafe", "mcscafe", "hari");
                stmt = con.createStatement();
                String query = "SELECT name,price FROM food where code='" + table.getValueAt(rowIndex, 0) + "';";
                rs = stmt.executeQuery(query);

                while (rs.next() && table.getSelectedColumn() != -1) {
                    table.setValueAt(rs.getString(1), rowIndex, 1);
                    table.setValueAt(rs.getInt(2), rowIndex, 2);
                }
            } catch (ClassNotFoundException | SQLException e) {
                try {
                    Files.write(Paths.get(System.getProperty("user.dir") + "\\lib\\log.txt"), LoginPage.encrypt(new java.util.Date(System.currentTimeMillis()).toString()
                            + " ComboRenderer:54:getTableCellRendererComponent\n" + e.toString() + "\n\n").getBytes(), StandardOpenOption.APPEND);
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
        return c;
    }
}
