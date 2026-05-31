/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.Peminjaman;
import service.PeminjamanService;

/**
 *
 * @author Acer
 */
public class PeminjamanController {
     private final PeminjamanService peminjamanService
            = new PeminjamanService();

    public boolean pinjamBuku(
            Peminjaman peminjaman
    ) {

        return peminjamanService.pinjamBuku(
                peminjaman
        );
    }

    public ArrayList<Peminjaman> getAllPeminjaman() {

        return peminjamanService
                .getAllPeminjaman();
    }

    public boolean updateStatus(
            int idPinjam,
            String status
    ) {

        return peminjamanService
                .updateStatus(
                        idPinjam,
                        status
                );
    }

    public boolean hapusPeminjaman(
            int idPinjam
    ) {

        return peminjamanService
                .hapusPeminjaman(
                        idPinjam
                );
    }
}
