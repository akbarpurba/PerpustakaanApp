/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Admin;
import service.AdminService;

/**
 *
 * @author Acer
 */
public class AdminController {

    private final AdminService adminService
            = new AdminService();

    public boolean tambahAdmin(
            Admin admin
    ) {

        return adminService.tambahAdmin(
                admin
        );
    }

    public ArrayList<Admin> getAllAdmin() {

        return adminService.getAllAdmin();
    }

    public boolean updateAdmin(
            Admin admin
    ) {

        return adminService.updateAdmin(
                admin
        );
    }

    public boolean deleteAdmin(
            int userId
    ) {

        return adminService.deleteAdmin(
                userId
        );
    }

    public Admin getByUserId(
            int userId
    ) {

        return adminService.getByUserId(
                userId
        );
    }
    public Admin getAdminById(
        int idAdmin
) {

    return adminService.getAdminById(
            idAdmin
    );
}
    
    public boolean handlingDuplicateUsername(String username){
        return adminService.handlingUsernameInsert(username);
    }
    
    public boolean handlingDuplicateUsernameForUpdate(String username, int user_id){
        return adminService.handlingUsernameUpdate(username, user_id);
    }
}
