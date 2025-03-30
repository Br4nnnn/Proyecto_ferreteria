package Proveedores;

import Conexion.ConexionBD;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Object) para gestionar operaciones CRUD en la tabla "Proveedores".
 * Proporciona métodos para agregar, eliminar y actualizar Proveedores en la base de datos.
 *

 */
public class proveedoresDAO {
    private ConexionBD ConexionBD = new ConexionBD();

    /**
     * Agrega un nuevo empleado a la base de datos.
     *
     * @param proveedores Objeto de la clase Empleados que contiene la información del empleado a agregar.
     */
    public void agregar(Proveedores proveedores) {
        Connection con = ConexionBD.getConnection();
        String query = "INSERT INTO empleados (Nombre,contacto) VALUES (?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, proveedores.getnombre());
            pst.setDouble(3, proveedores.getcontacto());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Proveedores agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Proveedores no agregado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un Proveedores de la base de datos según su id_proveedor.
     *
     * @param id_proveedor Identificador único del Proveedores a eliminar.
     */
    public void eliminar(int id_proveedor) {
        Connection con = ConexionBD.getConnection();
        String query = "DELETE FROM proveedores WHERE id_proveedores = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_proveedor);

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Proveedores eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Proveedores no eliminado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un empleado en la base de datos.
     *
     * @param proveedores Objeto de la clase Empleados con los nuevos datos del empleado.
     */
    public void actualizar(Proveedores proveedores) {
        Connection con = ConexionBD.getConnection();
        String query = "UPDATE proveedor SET nombre = ?, contacto = ? WHERE id_proveedor = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, proveedores.getid_proveedor());
            pst.setString(2, proveedores.getnombre());
            pst.setDouble(3, proveedores.getcontacto());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor no actualizado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}