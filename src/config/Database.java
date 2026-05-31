package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection conn;

    public static Connection getConnection() {

        try {

            if (
                conn == null ||
                conn.isClosed()
            ) {

                String url
                        = "jdbc:mysql://localhost:3306/perpustakaan";

                String user = "root";

                String pass = "";

                conn = DriverManager.getConnection(
                        url,
                        user,
                        pass
                );

                conn.setAutoCommit(false);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage()
            );
        }

        return conn;
    }

    public static void commit() {

        try {

            if (conn != null) {

                conn.commit();
            }

        } catch (SQLException e) {

            System.out.println(
                    "Commit Error: "
                    + e.getMessage()
            );
        }
    }

    public static void rollback() {

        try {

            if (conn != null) {

                conn.rollback();
            }

        } catch (SQLException e) {

            System.out.println(
                    "Rollback Error: "
                    + e.getMessage()
            );
        }
    }

    public static void closeConnection() {

        try {

            if (
                conn != null &&
                !conn.isClosed()
            ) {

                conn.close();
            }

        } catch (SQLException e) {

            System.out.println(
                    "Close Connection Error: "
                    + e.getMessage()
            );
        }
    }
}