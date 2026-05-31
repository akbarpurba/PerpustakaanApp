/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Anggota;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Acer
 */
public class AnggotaDAO {
    public boolean insert(Anggota anggota) {

    try {

        Connection conn = Database.getConnection();

        String sql = """
            INSERT INTO anggota(
                user_id,
                name,
                email,
                alamat,
                no_hp,
                jenis_kelamin,
                profesi
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, anggota.getUserId());
        pst.setString(2, anggota.getName());
        pst.setString(3, anggota.getEmail());
        pst.setString(4, anggota.getAlamat());
        pst.setString(5, anggota.getNoHp());
        pst.setString(6, anggota.getJenisKelamin());
        pst.setString(7, anggota.getProfesi());

        pst.executeUpdate();

        conn.commit();

        return true;

    } catch (Exception e) {

        try {
            Database.getConnection().rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        e.printStackTrace();
    }

    return false;
}
    
  public Anggota getByUserId(
        int userId
) {

    Anggota anggota = null;

    try {

        Connection conn = Database.getConnection();

        String sql = """
            SELECT 
                anggota.*,
                users.username,
                users.password
            FROM anggota
            JOIN users
                ON anggota.user_id = users.id
            WHERE anggota.user_id = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setInt(1, userId);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            anggota = new Anggota();

            anggota.setUserId(
                    rs.getInt("user_id")
            );

            anggota.setName(
                    rs.getString("name")
            );

            anggota.setEmail(
                    rs.getString("email")
            );

            anggota.setAlamat(
                    rs.getString("alamat")
            );

            anggota.setNoHp(
                    rs.getString("no_hp")
            );

            anggota.setJenisKelamin(
                    rs.getString("jenis_kelamin")
            );

            anggota.setProfesi(
                    rs.getString("profesi")
            );

            anggota.setUsername(
                    rs.getString("username")
            );

            anggota.setPassword(
                    rs.getString("password")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return anggota;
}
 public boolean update(
        Anggota anggota
) {

    try {

        Connection conn = Database.getConnection();

        String sql = """
            UPDATE anggota
            SET
                name = ?,
                email = ?,
                alamat = ?,
                no_hp = ?,
                jenis_kelamin = ?,
                profesi = ?
            WHERE user_id = ?
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, anggota.getName());
        pst.setString(2, anggota.getEmail());
        pst.setString(3, anggota.getAlamat());
        pst.setString(4, anggota.getNoHp());
        pst.setString(5, anggota.getJenisKelamin());
        pst.setString(6, anggota.getProfesi());
        pst.setInt(7, anggota.getUserId());

        pst.executeUpdate();

        conn.commit();

        return true;

    } catch (Exception e) {

        try {
            Database.getConnection().rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        e.printStackTrace();
    }

    return false;
}
 public boolean isUsernameExist(
        String username
) {

    try {

        Connection conn =
                Database.getConnection();

        String sql = """
            SELECT id
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

        return rs.next();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}
   
 public boolean isEmailExist(
        String email
) {

    try {

        Connection conn =
                Database.getConnection();

        String sql = """
            SELECT id_anggota
            FROM anggota
            WHERE email = ?
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(
                1,
                email
        );

        ResultSet rs =
                pst.executeQuery();

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

        Connection conn =
                Database.getConnection();

        String sql = """
            SELECT id
            FROM users
            WHERE username = ?
            AND id <> ?
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(
                1,
                username
        );

        pst.setInt(
                2,
                userId
        );

        ResultSet rs =
                pst.executeQuery();

        return rs.next();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}
 
 public boolean isEmailExistForUpdate(
        String email,
        int userId
) {

    try {

        Connection conn =
                Database.getConnection();

        String sql = """
            SELECT id_anggota
            FROM anggota
            WHERE email = ?
            AND user_id <> ?
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(
                1,
                email
        );

        pst.setInt(
                2,
                userId
        );

        ResultSet rs =
                pst.executeQuery();

        return rs.next();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}

public boolean delete(
        int userId
) {

    try {

        Connection conn =
                Database.getConnection();

        String sql = """
            DELETE FROM users
            WHERE id = ?
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(
                1,
                userId
        );

        pst.executeUpdate();

        conn.commit();

        return true;

    } catch (Exception e) {

        try {

            Database.getConnection()
                    .rollback();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        e.printStackTrace();
    }

    return false;
}

public ArrayList<Anggota> getAll() {

    ArrayList<Anggota> list
            = new ArrayList<>();

    try {

        Connection conn
                = Database.getConnection();

        String sql = """
            SELECT
                anggota.id_anggota,
                anggota.user_id,
                anggota.name,
                anggota.email,
                anggota.alamat,
                anggota.no_hp,
                anggota.jenis_kelamin,
                anggota.profesi,

                users.username

            FROM anggota

            JOIN users
            ON anggota.user_id = users.id

            ORDER BY anggota.id_anggota DESC
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        ResultSet rs
                = pst.executeQuery();

        while (rs.next()) {

            Anggota anggota
                    = new Anggota();

            anggota.setIdAnggota(
                    rs.getInt("id_anggota")
            );

            anggota.setUserId(
                    rs.getInt("user_id")
            );

            anggota.setName(
                    rs.getString("name")
            );

            anggota.setEmail(
                    rs.getString("email")
            );

            anggota.setAlamat(
                    rs.getString("alamat")
            );

            anggota.setNoHp(
                    rs.getString("no_hp")
            );

            anggota.setJenisKelamin(
                    rs.getString("jenis_kelamin")
            );

            anggota.setProfesi(
                    rs.getString("profesi")
            );

            anggota.setUsername(
                    rs.getString("username")
            );

            list.add(anggota);
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return list;
}
public boolean add(
        Anggota anggota
) {

    Connection conn = null;

    try {

        conn = Database.getConnection();

        String userSql = """
            INSERT INTO users(
                username,
                password,
                role
            )
            VALUES (?, ?, 'anggota')
        """;

        PreparedStatement userPst =
                conn.prepareStatement(
                        userSql,
                        PreparedStatement.RETURN_GENERATED_KEYS
                );

        userPst.setString(
                1,
                anggota.getUsername()
        );

        userPst.setString(
                2,
                anggota.getPassword()
        );

        userPst.executeUpdate();

        ResultSet rs =
                userPst.getGeneratedKeys();

        int userId = 0;

        if (rs.next()) {

            userId = rs.getInt(1);
        }

        String anggotaSql = """
            INSERT INTO anggota(
                user_id,
                name,
                email,
                alamat,
                no_hp,
                jenis_kelamin,
                profesi
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        PreparedStatement anggotaPst =
                conn.prepareStatement(
                        anggotaSql
                );

        anggotaPst.setInt(
                1,
                userId
        );

        anggotaPst.setString(
                2,
                anggota.getName()
        );

        anggotaPst.setString(
                3,
                anggota.getEmail()
        );

        anggotaPst.setString(
                4,
                anggota.getAlamat()
        );

        anggotaPst.setString(
                5,
                anggota.getNoHp()
        );

        anggotaPst.setString(
                6,
                anggota.getJenisKelamin()
        );

        anggotaPst.setString(
                7,
                anggota.getProfesi()
        );

        anggotaPst.executeUpdate();

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

public boolean ubah(
        Anggota anggota
) {

    Connection conn = null;

    try {

        conn = Database.getConnection();

        String userSql = """
            UPDATE users
            SET
                username = ?,
                password = ?
            WHERE id = ?
        """;

        PreparedStatement userPst =
                conn.prepareStatement(userSql);

        userPst.setString(
                1,
                anggota.getUsername()
        );

        userPst.setString(
                2,
                anggota.getPassword()
        );

        userPst.setInt(
                3,
                anggota.getUserId()
        );

        int userResult =
                userPst.executeUpdate();

        String anggotaSql = """
            UPDATE anggota
            SET
                name = ?,
                email = ?,
                alamat = ?,
                no_hp = ?,
                jenis_kelamin = ?,
                profesi = ?
            WHERE user_id = ?
        """;

        PreparedStatement anggotaPst =
                conn.prepareStatement(anggotaSql);

        anggotaPst.setString(
                1,
                anggota.getName()
        );

        anggotaPst.setString(
                2,
                anggota.getEmail()
        );

        anggotaPst.setString(
                3,
                anggota.getAlamat()
        );

        anggotaPst.setString(
                4,
                anggota.getNoHp()
        );

        anggotaPst.setString(
                5,
                anggota.getJenisKelamin()
        );

        anggotaPst.setString(
                6,
                anggota.getProfesi()
        );

        anggotaPst.setInt(
                7,
                anggota.getUserId()
        );

        int anggotaResult =
                anggotaPst.executeUpdate();

        if (
                userResult > 0
                && anggotaResult > 0
        ) {

            conn.commit();

            return true;
        }

        conn.rollback();

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

public Anggota getMemberById(
        int idMember
) {

    Anggota anggota = null;

    try {

        Connection conn
                = Database.getConnection();

        String sql = """
            SELECT
                users.username,
                users.password,

                anggota.name,
                anggota.email,
                anggota.alamat,
                anggota.no_hp,
                anggota.jenis_kelamin,
                anggota.profesi,

                anggota.id_anggota,
                anggota.user_id

            FROM anggota

            JOIN users
            ON anggota.user_id = users.id

            WHERE anggota.id_anggota = ?
        """;

        PreparedStatement pst
                = conn.prepareStatement(sql);

        pst.setInt(1, idMember);

        ResultSet rs
                = pst.executeQuery();

        if (rs.next()) {

            anggota = new Anggota();

            anggota.setIdAnggota(rs.getInt("id_anggota"));
                   

            anggota.setUserId(
                    rs.getInt("user_id")
            );

            anggota.setUsername(
                    rs.getString("username")
            );

            anggota.setPassword(rs.getString("password"));
            anggota.setName(rs.getString("name"));
            anggota.setAlamat(rs.getString("alamat"));
            anggota.setEmail(rs.getString("email"));
            anggota.setJenisKelamin(rs.getString("jenis_kelamin"));
            anggota.setNoHp(rs.getString("no_hp"));
            anggota.setProfesi(rs.getString("profesi"));
           
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return anggota;
}
public int getIdByUsername(
        String username
) {

    try {

        Connection conn =
                Database.getConnection();

        String sql = """
            SELECT anggota.id_anggota
            FROM anggota

            JOIN users
            ON anggota.user_id = users.id

            WHERE users.username = ?
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

            return rs.getInt(
                    "id_anggota"
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return 0;
}
}
