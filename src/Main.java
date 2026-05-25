import config.Koneksi;
import com.formdev.flatlaf.FlatLightLaf;
import view.auth.LoginView;

public class Main {

    public static void main(String[] args) {
       try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
    }
    

