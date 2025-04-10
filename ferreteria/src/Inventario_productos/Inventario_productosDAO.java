package Inventario_productos;

import Conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Object) para gestionar operaciones CRUD en la tabla "inventario_productos".
 * Proporciona métodos para agregar, eliminar y actualizar productos en la base de datos.
 *
 */
public class Inventario_productosDAO {
    private ConexionBD ConexionBD = new ConexionBD();

    /**
     * Agrega un nuevo producto al inventario en la base de datos.
     *
     * @param inventario_productos Objeto de la clase Inventario_productos que contiene la información del producto a agregar.
     */
    public void agregar(Inventario_productos inventario_productos) {
        Connection con = ConexionBD.getConnection();
        String query = "INSERT INTO inventario_productos (categoria_producto, nombre_producto, precio_proveedor, precio_venta, cantidad_stock) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, inventario_productos.getcategoria_producto());
            pst.setString(2, inventario_productos.getnombre_producto());
            pst.setString(3, inventario_productos.getprecio_proveedor());
            pst.setString(4, inventario_productos.getprecio_venta());
            pst.setString(5, inventario_productos.getcantidad_stock());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no agregado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un producto del inventario en la base de datos según su ID.
     *
     * @param id_producto Identificador único del producto a eliminar.
     */
    public void eliminar(int id_producto) {
        Connection con = ConexionBD.getConnection();
        String query = "DELETE FROM inventario_productos WHERE id_producto = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_producto);

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no eliminado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Inventario_productos inventario_productos) {
        Connection con = ConexionBD.getConnection();
        String query = "UPDATE inventario_productos SET categoria_producto = ?, nombre_producto = ?, precio_proveedor = ?, precio_venta= ?, cantidad_stock= ? WHERE id_producto = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, inventario_productos.getcategoria_producto());
            pst.setString(2, inventario_productos.getnombre_producto());
            pst.setString(3, inventario_productos.getprecio_proveedor());
            pst.setString(4, inventario_productos.getprecio_venta());
            pst.setString(5, inventario_productos.getcantidad_stock());
            pst.setInt(6, inventario_productos.getid_producto());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no actualizado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

