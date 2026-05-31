/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.Buku;
import service.BukuService;
/**
 *
 * @author Acer
 */
public class BukuController {
    private final BukuService bukuService
            = new BukuService();

    public boolean tambahBuku(
            Buku buku
    ) {

        return bukuService.tambahBuku(
                buku
        );
    }

    public boolean updateBuku(
            Buku buku
    ) {

        return bukuService.updateBuku(
                buku
        );
    }

    public boolean hapusBuku(
            int idBuku
    ) {

        return bukuService.hapusBuku(
                idBuku
        );
    }

    public ArrayList<Buku> getAllBuku() {

        return bukuService.getAllBuku();
    }
    
    public Buku getBukuById(int id_buku){
        return bukuService.getBukuById(id_buku);
    }
}
