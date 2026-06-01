import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import view.auth.LoginView;

public class Main {

    public static void main(String[] args) {

        try {

            FlatLightLaf.setup();

        } catch (Exception e) {

            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {

            LoginView loginView =
                    new LoginView();

            Image icon =
                    new ImageIcon(
                            Main.class.getResource(
                                    "/assets/logo.png"
                            )
                    ).getImage();

            loginView.setIconImage(icon);

            loginView.setVisible(true);
        });
    }
}