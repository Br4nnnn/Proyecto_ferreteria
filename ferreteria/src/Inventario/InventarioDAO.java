package Inventario;

import Conexion.ConexionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioDAO {
    private ConexionDB ConexionDB = new ConexionDB();

    public void agregar(Inventario inventario) {
        Connection con = ConexionDB.getConnection();

        try {
            // Verificar si el proveedor existe (si se proporciona)
            if (inventario.getId_proveedor_asociado() != null &&
                    !validarProveedor(inventario.getId_proveedor_asociado())) {
                JOptionPane.showMessageDialog(null,
                        "Error: El proveedor con ID " + inventario.getId_proveedor_asociado() + " no existe",
                        "Error de Proveedor",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Consulta para insertar nuevo producto
            String query = "INSERT INTO inventario_productos (nombre_producto, categoria, cantidad_stock, precio_producto, id_proveedor_asociado) VALUES (?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            // Establecer parámetros
            pst.setString(1, inventario.getNombre_producto());
            pst.setString(2, inventario.getCategoria());
            pst.setInt(3, inventario.getCantidad_stock());
            pst.setInt(4, inventario.getPrecio_producto());

            // Manejar el caso en que el proveedor puede ser null
            if (inventario.getId_proveedor_asociado() != null) {
                pst.setInt(5, inventario.getId_proveedor_asociado());
            } else {
                pst.setNull(5, java.sql.Types.INTEGER);
            }

            // Ejecutar inserción
            int resultado = pst.executeUpdate();

            // Mostrar mensaje de resultado
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar producto");
            }

            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public DefaultComboBoxModel<String> cargarProveedores() {
        // Creamos un modelo para el JComboBox que contendrá, por ejemplo, "id - nombre"
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
        Connection con = ConexionDB.getConnection();
        String query = "SELECT id_proveedor, nombre FROM proveedores";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                // Puedes elegir cómo mostrar la información, por ejemplo "id - nombre"
                comboModel.addElement(id + " - " + nombre);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar proveedores: " + e.getMessage());
            e.printStackTrace();
        }
        return comboModel;
    }


    public void eliminar(int id_producto) {
        Connection con = ConexionDB.getConnection();

        try {
            // Consulta para eliminar producto
            String query = "DELETE FROM inventario_productos WHERE id_producto = ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_producto);

            // Ejecutar eliminación
            int resultado = pst.executeUpdate();

            // Mostrar mensaje de resultado
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }

            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void actualizar(Inventario inventario) {
        Connection con = ConexionDB.getConnection();

        try {
            // Verificar si el proveedor existe (si se proporciona)
            if (inventario.getId_proveedor_asociado() != null &&
                    !validarProveedor(inventario.getId_proveedor_asociado())) {
                JOptionPane.showMessageDialog(null,
                        "Error: El proveedor con ID " + inventario.getId_proveedor_asociado() + " no existe",
                        "Error de Proveedor",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Consulta para actualizar producto
            String query = "UPDATE inventario_productos SET nombre_producto = ?, categoria = ?, cantidad_stock = ?, precio_producto = ?, id_proveedor_asociado = ? WHERE id_producto = ?";

            PreparedStatement pst = con.prepareStatement(query);

            // Establecer parámetros
            pst.setString(1, inventario.getNombre_producto());
            pst.setString(2, inventario.getCategoria());
            pst.setInt(3, inventario.getCantidad_stock());
            pst.setInt(4, inventario.getPrecio_producto());

            // Manejar el caso en que el proveedor puede ser null
            if (inventario.getId_proveedor_asociado() != null) {
                pst.setInt(5, inventario.getId_proveedor_asociado());
            } else {
                pst.setNull(5, java.sql.Types.INTEGER);
            }

            pst.setInt(6, inventario.getId_producto());

            // Ejecutar actualización
            int resultado = pst.executeUpdate();

            // Mostrar mensaje de resultado
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar producto");
            }

            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean validarProveedor(int id_proveedor) {
        Connection con = ConexionDB.getConnection();

        try {
            // Consulta para contar proveedores con el ID especificado
            String query = "SELECT COUNT(*) FROM proveedores WHERE id_proveedor = ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_proveedor);

            ResultSet rs = pst.executeQuery();

            // Verificar si existe el proveedor
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar proveedor: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}