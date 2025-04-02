package Detalle_venta;
import Conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase DAO para gestionar operaciones CRUD sobre la tabla detalle_venta en la base de datos.
 */
public class detalle_ventaDAO {
    private ConexionBD conexion = new ConexionBD();

    /**
     * Agrega un nuevo detalle de venta a la base de datos.
     *
     * @param detalle Objeto Detalle_venta que contiene la información del detalle de venta a agregar.
     */
    public void agregar(Detalle_venta detalle) {
        Connection con = conexion.getConnection();
        String query = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, detalle.getIdVenta());
            pst.setInt(2, detalle.getIdProducto());
            pst.setInt(3, detalle.getCantidad());
            pst.setDouble(4, detalle.getPrecioUnitario());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Detalle de venta agregado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar detalle de venta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una lista de todos los detalles de venta almacenados en la base de datos.
     *
     * @return Lista de objetos Detalle_venta.
     */
    public List<Detalle_venta> listar() {
        List<Detalle_venta> lista = new ArrayList<>();
        Connection con = conexion.getConnection();
        String query = "SELECT * FROM detalle_venta";

        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                lista.add(new Detalle_venta(
                        rs.getInt("id_detalle"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_producto"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_unitario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Actualiza la información de un detalle de venta en la base de datos.
     *
     * @param detalle Objeto Detalle_venta con la información actualizada.
     */
    public void actualizar(Detalle_venta detalle) {
        Connection con = conexion.getConnection();
        String query = "UPDATE detalle_venta SET id_venta=?, id_producto=?, cantidad=?, precio_unitario=? WHERE id_detalle=?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, detalle.getIdVenta());
            pst.setInt(2, detalle.getIdProducto());
            pst.setInt(3, detalle.getCantidad());
            pst.setDouble(4, detalle.getPrecioUnitario());
            pst.setInt(5, detalle.getIdDetalle());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Detalle de venta actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar detalle de venta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un detalle de venta de la base de datos.
     *
     * @param idDetalle Identificador del detalle de venta a eliminar.
     */
    public void eliminar(int idDetalle) {
        Connection con = conexion.getConnection();
        String query = "DELETE FROM detalle_venta WHERE id_detalle=?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, idDetalle);

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Detalle de venta eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar detalle de venta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}