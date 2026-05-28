/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import javax.swing.JFrame;
/**
 *
 * @author Acer
 */
public class FormUtils {
     public static void openForm(JFrame currentForm, JFrame nextForm) {
        nextForm.setLocationRelativeTo(null);
        nextForm.setVisible(true);
        currentForm.dispose();
    }

    public static void showForm(JFrame form) {
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }

    public static void closeForm(JFrame form) {
        form.dispose();
    }
}
