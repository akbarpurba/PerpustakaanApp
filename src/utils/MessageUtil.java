/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class MessageUtil {
     public static void success(
            JFrame frame,
            String message
    ) {

        JOptionPane.showMessageDialog(
                frame,
                message,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void error(
            JFrame frame,
            String message
    ) {

        JOptionPane.showMessageDialog(
                frame,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void warning(
            JFrame frame,
            String message
    ) {

        JOptionPane.showMessageDialog(
                frame,
                message,
                "Warning",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static int confirm(
            JFrame frame,
            String message
    ) {

        return JOptionPane.showConfirmDialog(
                frame,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );
    }
    
    
}
