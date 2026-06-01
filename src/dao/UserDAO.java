/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Acer
 */
public class UserDAO {
     public int insert(User user) {

        int generatedId = 0;

        try {

            Connection conn = Database.getConnection();

            String sql = """
                INSERT INTO users(username, password, role)
                VALUES (?, ?, ?)
            """;

            PreparedStatement pst = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getRole());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();

            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedId;
    }
     
    public User login(
        String username,
        String password
) {

    try {

        Connection conn =
                Database.getConnection();

        String sql = """
            SELECT *
            FROM users
            WHERE username = ?
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(
                1,
                username
        );

        ResultSet rs =
                pst.executeQuery();

        if (rs.next()) {

            String hashedPassword =
                    rs.getString("password");

            if (
                BCrypt.checkpw(
                        password,
                        hashedPassword
                )
            ) {

                User user = new User();

                user.setId(
                        rs.getInt("id")
                );

                user.setUsername(
                        rs.getString("username")
                );

                user.setRole(
                        rs.getString("role")
                );

                return user;
            }
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return null;
}
     
 public boolean isUsernameExists(
        String username
) {

    boolean exists = false;

    try {

        Connection conn = Database.getConnection();

        String sql = """
            SELECT id FROM users
            WHERE username = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setString(1, username);

        ResultSet rs = pst.executeQuery();

        exists = rs.next();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return exists;
}
 
 public boolean update(
        int userId,
        String username,
        String password
) {

    try {

        Connection conn = Database.getConnection();

        String sql = """
            UPDATE users
            SET
                username = ?,
                password = ?
            WHERE id = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setString(1, username);

        pst.setString(2, password);

        pst.setInt(3, userId);

        pst.executeUpdate();

        return true;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}
