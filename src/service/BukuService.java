/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.BukuDAO;
import java.util.ArrayList;
import model.Buku;
/**
 *
 * @author Acer
 */
public class BukuService {
    private final BukuDAO bukuDAO
            = new BukuDAO();

    public boolean tambahBuku(
            Buku buku
    ) {

        if (
            buku.getJudulBuku().isEmpty()
        ) {

            return false;
        }

        return bukuDAO.insert(buku);
    }

    public boolean updateBuku(
            Buku buku
    ) {

        if (
            buku.getIdBuku() <= 0
        ) {

            return false;
        }

        return bukuDAO.update(buku);
    }

    public boolean hapusBuku(
            int idBuku
    ) {

        if (idBuku <= 0) {

            return false;
        }

        return bukuDAO.delete(idBuku);
    }

    public ArrayList<Buku> getAllBuku() {

        return bukuDAO.getAll();
    }
    
    public Buku getBukuById(int id_buku){
        return bukuDAO.getBukuById(id_buku);
    }
    
    public int getIdByBuku(String judul){
        return bukuDAO.getIdByJudul(judul);
    }
}
