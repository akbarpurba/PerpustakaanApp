/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import service.AuthService;
import model.User;
/**
 *
 * @author Acer
 */
public class AuthController {
      private final AuthService authService
            = new AuthService();
      public String registerAnggota(
        String username,
        String password,
        String name,
        String email,
        String alamat,
        String noHp,
        String jenisKelamin,
        String profesi
) {

    return authService.registerAnggota(
            username,
            password,
            name,
            email,
            alamat,
            noHp,
            jenisKelamin,
            profesi
    );
}
      
    public User login(
        String username,
        String password
) {

    return authService.login(
            username,
            password
    );
}
    
}
