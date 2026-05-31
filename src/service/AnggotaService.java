/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.AnggotaDAO;
import model.Anggota;
import dao.UserDAO;
import java.util.ArrayList;
/**
 *
 * @author Acer
 */
public class AnggotaService {
     private final AnggotaDAO anggotaDAO
            = new AnggotaDAO();

    public Anggota getProfile(
            int userId
    ) {

        return anggotaDAO.getByUserId(
                userId
        );
    }

private final UserDAO userDAO
        = new UserDAO();

public boolean updateProfile(
        Anggota anggota
) {

    boolean userUpdated
            = userDAO.update(
                    anggota.getUserId(),
                    anggota.getUsername(),
                    anggota.getPassword()
            );

    if (!userUpdated) {
        return false;
    }

    return anggotaDAO.update(anggota);
}

public boolean validateUsername(String username){
    return anggotaDAO.isUsernameExist(username);
}

public boolean validateEmail(String email){
    return anggotaDAO.isEmailExist(email);
}
public boolean validateUsernameUpdate(String username, int user_id){
    return anggotaDAO.isUsernameExistForUpdate(username, user_id);
}
public boolean validateEmailUpdate(String email, int user_id){
    return anggotaDAO.isEmailExistForUpdate(email, user_id);
}

public ArrayList <Anggota> getAllMember(){
    return anggotaDAO.getAll();
}
public boolean addMember(Anggota anggota){
    return anggotaDAO.add(anggota);
}
public boolean UpdateMember(Anggota anggota){
    return anggotaDAO.ubah(anggota);
}
public Anggota getMember(int id_member){
    return anggotaDAO.getMemberById(id_member);
}
public boolean deleteMember(int user_id){
    return anggotaDAO.delete(user_id);
}

public int getIdByUsername(String username){
    return anggotaDAO.getIdByUsername(username);
}
}
