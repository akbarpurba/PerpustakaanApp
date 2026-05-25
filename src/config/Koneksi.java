package config;
import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    public static Connection conn;
    
    public static Connection getConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/perpustakaan";
            String user = "root";
            String pass = "";
            
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil");
        } catch(Exception e){
            System.out.println("Koneksi gagal");
            System.out.println(e);
        }
        return conn;
    } 
}
