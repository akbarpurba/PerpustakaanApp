package utils;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PasswordUtil {

    private static boolean isVisible = false;

    public static void togglePassword(
            JPasswordField passwordField,
            JButton button
    ) {

        String iconPath;

        if (isVisible) {

            passwordField.setEchoChar('•');

            iconPath = "/assets/view.png";

            isVisible = false;

        } else {

            passwordField.setEchoChar((char) 0);

            iconPath = "/assets/hide.png";

            isVisible = true;
        }

        ImageIcon icon = new ImageIcon(
                PasswordUtil.class.getResource(iconPath)
        );

        Image img = icon.getImage().getScaledInstance(
                20,
                20,
                Image.SCALE_SMOOTH
        );

        button.setIcon(new ImageIcon(img));
    }
}