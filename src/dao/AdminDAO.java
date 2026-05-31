/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Admin;
/**
 *
 * @author Acer
 */
public class AdminDAO {
    public boolean insert(Admin admin) {

    Connection conn = null;

    try {

        conn = Database.getConnection();

        String userSql = """
            INSERT INTO users(
                username,
                password,
                role
            )
            VALUES (?, ?, 'admin')
        """;

        PreparedStatement userPst =
                conn.prepareStatement(
                        userSql,
                        PreparedStatement.RETURN_GENERATED_KEYS
                );

        userPst.setString(
                1,
                admin.getUsername()
        );

        userPst.setString(
                2,
                admin.getPassword()
        );

        userPst.executeUpdate();

        ResultSet generatedKeys =
                userPst.getGeneratedKeys();

        int userId = 0;

        if (generatedKeys.next()) {

            userId = generatedKeys.getInt(1);
        }

        String adminSql = """
            INSERT INTO admin(
                user_id,
                name,
                jabatan
            )
            VALUES (?, ?, ?)
        """;

        PreparedStatement adminPst =
                conn.prepareStatement(adminSql);

        adminPst.setInt(
                1,
                userId
        );

        adminPst.setString(
                2,
                admin.getName()
        );

        adminPst.setString(
                3,
                admin.getJabatan()
        );

        adminPst.executeUpdate();

        conn.commit();

        return true;

    } catch (Exception e) {

        try {

            if (conn != null) {

                conn.rollback();
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        e.printStackTrace();
    }

    return false;
}
    public ArrayList<Admin> getAll() {

        ArrayList<Admin> list
                = new ArrayList<>();

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                SELECT
                    admin.id_admin,
                    admin.user_id,
                    admin.name,
                    users.username,
                    admin.jabatan

                FROM admin

                JOIN users
                ON admin.user_id = users.id
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            ResultSet rs
                    = pst.executeQuery();

            while (rs.next()) {

                Admin admin
                        = new Admin();

                admin.setIdAdmin(
                        rs.getInt("id_admin")
                );

                admin.setUserId(
                        rs.getInt("user_id")
                );

                admin.setUsername(
                        rs.getString("username")
                );
                admin.setName(
                        rs.getString("name")
                );

                admin.setJabatan(
                        rs.getString("jabatan")
                );

                list.add(admin);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

   public boolean update(
        Admin admin
) {

    Connection conn = null;

    try {

        conn = Database.getConnection();

        conn.setAutoCommit(false);

        String userSql = """
            UPDATE users
            SET
                username = ?,
                password = ?
            WHERE id = ?
        """;

        PreparedStatement userPst
                = conn.prepareStatement(userSql);

        userPst.setString(
                1,
                admin.getUsername()
        );

        userPst.setString(
                2,
                admin.getPassword()
        );

        userPst.setInt(
                3,
                admin.getUserId()
        );

        userPst.executeUpdate();

        String adminSql = """
            UPDATE admin
            SET
                name = ?,
                jabatan = ?
            WHERE user_id = ?
        """;

        PreparedStatement adminPst
                = conn.prepareStatement(adminSql);

        adminPst.setString(
                1,
                admin.getName()
        );

        adminPst.setString(
                2,
                admin.getJabatan()
        );

        adminPst.setInt(
                3,
                admin.getUserId()
        );

        adminPst.executeUpdate();

        conn.commit();

        return true;

    } catch (Exception e) {

        try {

            if (conn != null) {

                conn.rollback();
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        e.printStackTrace();
    }

    return false;
}

public boolean delete(
        int userId
) {

    Connection conn = null;

    try {

        conn = Database.getConnection();

        conn.setAutoCommit(false);

        String sql = """
            DELETE FROM users
            WHERE id = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setInt(
                1,
                userId
        );

        pst.executeUpdate();

        conn.commit();

        return true;

    } catch (Exception e) {

        try {

            if (conn != null) {

                conn.rollback();
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        e.printStackTrace();
    }

    return false;
}

   public Admin getByUserId(
        int userId
) {

    Admin admin = null;

    try {

        Connection conn
                = Database.getConnection();

        String sql = """
            SELECT
                users.username,
                users.password,

                admin.name,
                admin.jabatan,

                admin.id_admin,
                admin.user_id

            FROM admin

            JOIN users
            ON admin.user_id = users.id

            WHERE admin.user_id = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setInt(1, userId);

        ResultSet rs
                = pst.executeQuery();

        if (rs.next()) {

            admin = new Admin();

            admin.setIdAdmin(
                    rs.getInt("id_admin")
            );

            admin.setUserId(
                    rs.getInt("user_id")
            );

            admin.setUsername(
                    rs.getString("username")
            );

            admin.setPassword(
                    rs.getString("password")
            );

            admin.setName(
                    rs.getString("name")
            );

            admin.setJabatan(
                    rs.getString("jabatan")
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return admin;
}

public Admin getAdminById(
        int idAdmin
) {

    Admin admin = null;

    try {

        Connection conn
                = Database.getConnection();

        String sql = """
            SELECT
                users.username,
                users.password,

                admin.name,
                admin.jabatan,

                admin.id_admin,
                admin.user_id

            FROM admin

            JOIN users
            ON admin.user_id = users.id

            WHERE admin.id_admin = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setInt(1, idAdmin);

        ResultSet rs
                = pst.executeQuery();

        if (rs.next()) {

            admin = new Admin();

            admin.setIdAdmin(
                    rs.getInt("id_admin")
            );

            admin.setUserId(
                    rs.getInt("user_id")
            );

            admin.setUsername(
                    rs.getString("username")
            );

            admin.setPassword(
                    rs.getString("password")
            );

            admin.setName(
                    rs.getString("name")
            );

            admin.setJabatan(
                    rs.getString("jabatan")
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return admin;
}
   public boolean isUsernameExist(
        String username
) {

    try {

        Connection conn
                = Database.getConnection();

        String sql = """
            SELECT id
            FROM users
            WHERE username = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setString(
                1,
                username
        );

        ResultSet rs
                = pst.executeQuery();

        return rs.next();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}

public boolean isUsernameExistForUpdate(
        String username,
        int userId
) {

    try {

        Connection conn
                = Database.getConnection();

        String sql = """
            SELECT id
            FROM users
            WHERE username = ?
            AND id != ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setString(
                1,
                username
        );

        pst.setInt(
                2,
                userId
        );

        ResultSet rs
                = pst.executeQuery();

        return rs.next();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}
}
