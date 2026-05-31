/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author Acer
 */
public class Session {
    public static int id;

    public static String username;

    public static String role;

    public static String name;

    private Session() {
    }

    public static void clear() {

        id = 0;

        username = null;

        role = null;

        name = null;
    }

    public static boolean isLogin() {

        return id != 0;
    }

    public static boolean isAdmin() {

        return "admin".equals(role);
    }

    public static boolean isAnggota() {

        return "anggota".equals(role);
    }
}
