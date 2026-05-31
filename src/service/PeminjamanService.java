/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.PeminjamanDAO;
import java.util.ArrayList;
import model.Peminjaman;
/**
 *
 * @author Acer
 */
public class PeminjamanService {
     private final PeminjamanDAO peminjamanDAO
            = new PeminjamanDAO();

    public boolean pinjamBuku(
            Peminjaman peminjaman
    ) {

        if (
            peminjaman.getIdAnggota() <= 0
        ) {

            return false;
        }

        if (
            peminjaman.getIdBuku() <= 0
        ) {

            return false;
        }

        if (
            peminjaman.getLamaPeminjaman() <= 0
        ) {

            return false;
        }

        return peminjamanDAO.insert(
                peminjaman
        );
    }

    public ArrayList<Peminjaman> getAllPeminjaman() {

        return peminjamanDAO.getAll();
    }

    public boolean updateStatus(
            int idPinjam,
            String status
    ) {

        return peminjamanDAO.updateStatus(
                idPinjam,
                status
        );
    }

    public boolean hapusPeminjaman(
            int idPinjam
    ) {

        return peminjamanDAO.delete(
                idPinjam
        );
    }
    
   
}
