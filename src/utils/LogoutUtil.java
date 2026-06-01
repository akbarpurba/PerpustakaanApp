/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JFrame;

import config.Session;
import view.auth.LoginView;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class LogoutUtil {
    
     public static void logout(
        JFrame currentFrame
) {

    int confirm =
            MessageUtil.confirm(
                    currentFrame,
                    "Apakah Anda yakin ingin logout?"
            );

    if (
        confirm != JOptionPane.YES_OPTION
    ) {

        return;
    }

    Session.id = 0;
    Session.username = null;
    Session.role = null;

    new LoginView().setVisible(true);

    currentFrame.dispose();
}
    
}
