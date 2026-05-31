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
import model.Buku;
/**
 *
 * @author Acer
 */
public class BukuDAO {
   public boolean insert(
            Buku buku
    ) {

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                INSERT INTO buku(
                    judul_buku,
                    pengarang,
                    penerbit,
                    tahun_terbit,
                    stok
                )
                VALUES (?, ?, ?, ?, ?)
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            pst.setString(
                    1,
                    buku.getJudulBuku()
            );

            pst.setString(
                    2,
                    buku.getPengarang()
            );

            pst.setString(
                    3,
                    buku.getPenerbit()
            );

            pst.setInt(
                    4,
                    buku.getTahunTerbit()
            );

            pst.setInt(
                    5,
                    buku.getStok()
            );

            pst.executeUpdate();

            Database.commit();

            return true;

        } catch (Exception e) {

            Database.rollback();

            e.printStackTrace();
        }

        return false;
    }

    public boolean update(
            Buku buku
    ) {

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                UPDATE buku
                SET
                    judul_buku = ?,
                    pengarang = ?,
                    penerbit = ?,
                    tahun_terbit = ?,
                    stok = ?
                WHERE id_buku = ?
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            pst.setString(
                    1,
                    buku.getJudulBuku()
            );

            pst.setString(
                    2,
                    buku.getPengarang()
            );

            pst.setString(
                    3,
                    buku.getPenerbit()
            );

            pst.setInt(
                    4,
                    buku.getTahunTerbit()
            );

            pst.setInt(
                    5,
                    buku.getStok()
            );

            pst.setInt(
                    6,
                    buku.getIdBuku()
            );

            pst.executeUpdate();

            Database.commit();

            return true;

        } catch (Exception e) {

            Database.rollback();

            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(
            int idBuku
    ) {

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                DELETE FROM buku
                WHERE id_buku = ?
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            pst.setInt(1, idBuku);

            pst.executeUpdate();

            Database.commit();

            return true;

        } catch (Exception e) {

            Database.rollback();

            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Buku> getAll() {

        ArrayList<Buku> list
                = new ArrayList<>();

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                SELECT *
                FROM buku
                ORDER BY id_buku DESC
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            ResultSet rs
                    = pst.executeQuery();

            while (rs.next()) {

                Buku buku = new Buku();

                buku.setIdBuku(
                        rs.getInt("id_buku")
                );

                buku.setJudulBuku(
                        rs.getString("judul_buku")
                );

                buku.setPengarang(
                        rs.getString("pengarang")
                );

                buku.setPenerbit(
                        rs.getString("penerbit")
                );

                buku.setTahunTerbit(
                        rs.getInt("tahun_terbit")
                );

                buku.setStok(
                        rs.getInt("stok")
                );

                list.add(buku);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
    public Buku getBukuById(
        int idBuku
) {

    Buku buku = null;

    try {

        Connection conn =
                Database.getConnection();

        String sql = """
            SELECT *
            FROM buku
            WHERE id_buku = ?
        """;

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(
                1,
                idBuku
        );

        ResultSet rs =
                pst.executeQuery();

        if (rs.next()) {

            buku = new Buku();

            buku.setIdBuku(
                    rs.getInt("id_buku")
            );

            buku.setJudulBuku(
                        rs.getString("judul_buku")
                );

                buku.setPengarang(
                        rs.getString("pengarang")
                );

            buku.setPenerbit(
                    rs.getString("penerbit")
            );

            buku.setTahunTerbit(
                    rs.getInt("tahun_terbit")
            );

            buku.setStok(
                    rs.getInt("stok")
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return buku;
}
}
