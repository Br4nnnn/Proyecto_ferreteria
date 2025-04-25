package Proveedores;

import Conexion.ConexionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProveedoresDAO {
    private ConexionDB ConexionDB = new ConexionDB();

    public void agregar(Proveedores proveedores) {
        Connection con = ConexionDB.getConnection();
        String query = "INSERT INTO proveedores (nombre, contacto, categoria_producto) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, proveedores.getNombre());
            pst.setString(2, proveedores.getContacto());
            pst.setString(3, proveedores.getCategoria_producto());

            int resultado = pst.executeUpdate();
            String mensaje = resultado > 0 ? "Proveedor ingresado con éxito" : "Ups! Ocurrió un error al agregar al proveedor...";
            JOptionPane.showMessageDialog(null, mensaje);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id_proveedor) {
        Connection con = ConexionDB.getConnection();
        String query = "DELETE FROM proveedores WHERE id_proveedor = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_proveedor);

            int resultado = pst.executeUpdate();
            String mensaje = resultado > 0 ? "Proveedor eliminado con éxito!" : "Ups! Ocurrió un problema al eliminar el proveedor...";
            JOptionPane.showMessageDialog(null, mensaje);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Proveedores proveedores) {
        Connection con = ConexionDB.getConnection();
        String query = "UPDATE proveedores SET nombre = ?, contacto = ?, categoria_producto = ? WHERE id_proveedor = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, proveedores.getNombre());
            pst.setString(2, proveedores.getContacto());
            pst.setString(3, proveedores.getCategoria_producto());
            pst.setInt(4, proveedores.getId_proveedor());

            int resultado = pst.executeUpdate();
            String mensaje = resultado > 0 ? "Proveedor actualizado con éxito!" : "Ups! Ocurrió un error al actualizar al proveedor";
            JOptionPane.showMessageDialog(null, mensaje);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
