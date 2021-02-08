/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harig
 */
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class SwingXDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JComboBox comboBox;
                comboBox = new JComboBox(new Object[]{"Ester", "Jordi","Jordina", "Jorge", "Sergi"});
                AutoCompleteDecorator.decorate(comboBox);
                System.out.println("Is editable - "
                        + comboBox.isEditable() + ". Surprise!");
                JOptionPane.showMessageDialog(null, comboBox);
            }

        });
    }
}
