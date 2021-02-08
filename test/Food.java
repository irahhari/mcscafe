
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author harig
 */
public class Food {

    String code, name;
    int price;

    Food(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
//new javax.swing.DefaultComboBoxModel<>(new String[] { "item", "af", "adfa", "afda", "adf" }));

    static ArrayList<Food> list(ResultSet rs) {
        ArrayList<Food> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Food(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Food.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static Object[] cb(ResultSet rs) {
        ArrayList<String> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(rs.getString(2));
            }
            return list.toArray();
        } catch (SQLException ex) {
            Logger.getLogger(Food.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
