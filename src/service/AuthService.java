/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.AnggotaDAO;
import dao.UserDAO;
import model.Anggota;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Acer
 */
public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    private final AnggotaDAO anggotaDAO = new AnggotaDAO();

   public String registerAnggota(
        String username,
        String password,
        String name,
        String email,
        String alamat,
        String noHp,
        String jenisKelamin,
        String profesi
) {

    if (
        userDAO.isUsernameExists(username)
    ) {

        return "Username already exists";
    }

    String hashedPassword =
            BCrypt.hashpw(
                    password,
                    BCrypt.gensalt()
            );

    User user = new User(
            username,
            hashedPassword,
            "anggota"
    );

    int userId =
            userDAO.insert(user);

    if (userId == 0) {

        return "Registration failed";
    }

    Anggota anggota = new Anggota(
            userId,
            name,
            email,
            alamat,
            noHp,
            jenisKelamin,
            profesi
    );

    boolean success =
            anggotaDAO.insert(anggota);

    if (!success) {

        return "Registration failed";
    }

    return "success";
}
   
   
    
   public User login(
        String username,
        String password
) {

    return userDAO.login(
            username,
            password
    );
}
   
}
