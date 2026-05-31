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
import model.Peminjaman;
/**
 *
 * @author Acer
 */
public class PeminjamanDAO {
    public boolean insert(
            Peminjaman peminjaman
    ) {

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                INSERT INTO peminjaman(
                    id_anggota,
                    id_buku,
                    tanggal_pinjam,
                    lama_peminjaman,
                    tanggal_kembali,
                    status
                )
                VALUES (?, ?, ?, ?, ?, ?)
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            pst.setInt(
                    1,
                    peminjaman.getIdAnggota()
            );

            pst.setInt(
                    2,
                    peminjaman.getIdBuku()
            );

            pst.setString(
                    3,
                    peminjaman.getTanggalPinjam()
            );

            pst.setInt(
                    4,
                    peminjaman.getLamaPeminjaman()
            );

            pst.setString(
                    5,
                    peminjaman.getTanggalKembali()
            );

            pst.setString(
                    6,
                    "dipinjam"
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

    public ArrayList<Peminjaman> getAll() {

        ArrayList<Peminjaman> list
                = new ArrayList<>();

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                SELECT
                    peminjaman.*,

                    anggota.name,
                    anggota.no_hp,

                    buku.judul_buku

                FROM peminjaman

                JOIN anggota
                ON peminjaman.id_anggota
                = anggota.id_anggota

                JOIN buku
                ON peminjaman.id_buku
                = buku.id_buku

                ORDER BY id_pinjam DESC
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            ResultSet rs
                    = pst.executeQuery();

            while (rs.next()) {

                Peminjaman peminjaman
                        = new Peminjaman();

                peminjaman.setIdPinjam(
                        rs.getInt("id_pinjam")
                );

                peminjaman.setIdAnggota(
                        rs.getInt("id_anggota")
                );

                peminjaman.setIdBuku(
                        rs.getInt("id_buku")
                );

                peminjaman.setNama(
                        rs.getString("name")
                );

                peminjaman.setNoHp(
                        rs.getString("no_hp")
                );

                peminjaman.setJudulBuku(
                        rs.getString("judul_buku")
                );

                peminjaman.setTanggalPinjam(
                        rs.getString("tanggal_pinjam")
                );

                peminjaman.setLamaPeminjaman(
                        rs.getInt("lama_peminjaman")
                );

                peminjaman.setTanggalKembali(
                        rs.getString("tanggal_kembali")
                );

                peminjaman.setStatus(
                        rs.getString("status")
                );

                list.add(peminjaman);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    public boolean updateStatus(
            int idPinjam,
            String status
    ) {

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                UPDATE peminjaman
                SET status = ?
                WHERE id_pinjam = ?
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            pst.setString(1, status);

            pst.setInt(2, idPinjam);

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
            int idPinjam
    ) {

        try {

            Connection conn
                    = Database.getConnection();

            String sql = """
                DELETE FROM peminjaman
                WHERE id_pinjam = ?
            """;

            PreparedStatement pst
                    = conn.prepareStatement(sql);

            pst.setInt(1, idPinjam);

            pst.executeUpdate();

            Database.commit();

            return true;

        } catch (Exception e) {

            Database.rollback();

            e.printStackTrace();
        }

        return false;
    }
}