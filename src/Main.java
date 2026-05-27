import config.Koneksi;
import com.formdev.flatlaf.FlatLightLaf;
import view.admin.DashboardView;

public class Main {

    public static void main(String[] args) {
       try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new DashboardView().setVisible(true);
        });
    }
    }
    

