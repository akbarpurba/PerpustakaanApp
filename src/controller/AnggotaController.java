/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Anggota;
import service.AnggotaService;
import java.util.ArrayList;
/**
 *
 * @author Acer
 */
public class AnggotaController {
     private final AnggotaService anggotaService
            = new AnggotaService();

    public Anggota getProfile(
            int userId
    ) {

        return anggotaService.getProfile(
                userId
        );
    }
    
    public boolean updateProfile(
        Anggota anggota
) {

    return anggotaService.updateProfile(
            anggota
    );
}
    
public boolean handlingDuplicateUsername(String username){
    return anggotaService.validateUsername(username);
}

public boolean handlingDuplicateEmail(String email){
    return anggotaService.validateEmail(email);
}

public boolean handlingUsernameUpdate(String username, int user_id){
    return anggotaService.validateUsernameUpdate(username, user_id);
}
public boolean handlingEmailUpdate(String email, int user_id){
    return anggotaService.validateEmailUpdate(email, user_id);
}
public ArrayList <Anggota> getAllMember(){
    return anggotaService.getAllMember();
}

public boolean addMember(Anggota anggota){
    return anggotaService.addMember(anggota);
}
public boolean updateMember(Anggota anggota){
    return anggotaService.UpdateMember(anggota);
}
public Anggota getMemberById(int id_anggota){
    return anggotaService.getMember(id_anggota);
}
public boolean deleteMember(int user_id){
    return anggotaService.deleteMember(user_id);
}
}
