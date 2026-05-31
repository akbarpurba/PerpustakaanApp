/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AdminDAO;
import java.util.ArrayList;
import model.Admin;

/**
 *
 * @author Acer
 */
public class AdminService {

    private final AdminDAO adminDAO
            = new AdminDAO();

    public boolean tambahAdmin(
            Admin admin
    ) {

        return adminDAO.insert(admin);
    }

    public ArrayList<Admin> getAllAdmin() {

        return adminDAO.getAll();
    }

    public boolean updateAdmin(
            Admin admin
    ) {

        return adminDAO.update(admin);
    }

    public boolean deleteAdmin(
            int userId
    ) {

        return adminDAO.delete(userId);
    }

    public Admin getByUserId(
            int userId
    ) {

        return adminDAO.getByUserId(
                userId
        );
    }

  public Admin getAdminById(
        int idAdmin
) {

    return adminDAO.getAdminById(
            idAdmin
    );
}
  public boolean handlingUsernameInsert(String username){
      return adminDAO.isUsernameExist(username);
  }
  public boolean handlingUsernameUpdate(String username, int user_id){
          return adminDAO.isUsernameExistForUpdate(username, user_id);
}
}