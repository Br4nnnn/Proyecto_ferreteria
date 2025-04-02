/**
 * Clase de acceso a datos (DAO) para la gestión de ventas en la base de datos.
 * Proporciona métodos para agregar, eliminar, actualizar y listar ventas.
 */
package Ventas;

import Conexion.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;

public class ventasDAO {
    private ConexionBD conexionBD = new ConexionBD();

    /**
     * Agrega una nueva venta a la base de datos.
     * @param venta Objeto de la clase Ventas con la información de la venta a agregar.
     */
    public void agregar(Ventas venta) {
        Connection con = conexionBD.getConnection();
        String query = "INSERT INTO ventas (id_cliente, id_empleado, total, fecha) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, venta.getIdCliente());
            pst.setInt(2, venta.getIdEmpleado());
            pst.setDouble(3, venta.getTotal());
            pst.setTimestamp(4, venta.getFecha());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Venta agregada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Venta no agregada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una venta de la base de datos según su ID.
     * @param idVenta Identificador único de la venta a eliminar.
     */
    public void eliminar(int idVenta) {
        Connection con = conexionBD.getConnection();
        String query = "DELETE FROM ventas WHERE id_venta = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, idVenta);

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Venta no eliminada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de una venta en la base de datos.
     * @param venta Objeto de la clase Ventas con los nuevos datos de la venta.
     */
    public void actualizar(Ventas venta) {
        Connection con = conexionBD.getConnection();
        String query = "UPDATE ventas SET id_cliente = ?, id_empleado = ?, total = ?, fecha = ? WHERE id_venta = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, venta.getIdCliente());
            pst.setInt(2, venta.getIdEmpleado());
            pst.setDouble(3, venta.getTotal());
            pst.setTimestamp(4, venta.getFecha());
            pst.setInt(5, venta.getIdVenta());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Venta actualizada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Venta no actualizada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene y muestra una lista de todas las ventas en la base de datos.
     */
    public void listar() {
        Connection con = conexionBD.getConnection();
        String query = "SELECT * FROM ventas";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID Venta: " + rs.getInt("id_venta") +
                        ", ID Cliente: " + rs.getInt("id_cliente") +
                        ", ID Empleado: " + rs.getInt("id_empleado") +
                        ", Total: " + rs.getDouble("total") +
                        ", Fecha: " + rs.getString("fecha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
