package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public Connection getConnection() {
        Connection con = null;

        try {
            // 🔹 Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 🔹 Conectar a la base de datos
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ferreteria", "root", "");

            System.out.println("✅ Conexión exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }

        return con;
    }
}
