package Empleados;

import Conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase DAO (Data Access Object) para gestionar operaciones CRUD en la tabla "empleados".
 * Proporciona métodos para agregar, eliminar y actualizar empleados en la base de datos.
 *
 * @author Alejandro Vera
 */
public class empleadosDAO {
    private ConexionBD ConexionBD = new ConexionBD();

    /**
     * Agrega un nuevo empleado a la base de datos.
     *
     * @param empleados Objeto de la clase Empleados que contiene la información del empleado a agregar.
     */
    public void agregar(Empleados empleados) {
        Connection con = ConexionBD.getConnection();
        String query = "INSERT INTO empleados (Nombre, Cargo, Salario) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, empleados.getNombre());
            pst.setString(2, empleados.getCargo());
            pst.setDouble(3, empleados.getSalario());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no agregado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un empleado de la base de datos según su ID.
     *
     * @param ID Identificador único del empleado a eliminar.
     */
    public void eliminar(int ID) {
        Connection con = ConexionBD.getConnection();
        String query = "DELETE FROM empleados WHERE id_empleado = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, ID);

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no eliminado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un empleado en la base de datos.
     *
     * @param empleados Objeto de la clase Empleados con los nuevos datos del empleado.
     */
    public void actualizar(Empleados empleados) {
        Connection con = ConexionBD.getConnection();
        String query = "UPDATE empleados SET Nombre = ?, Cargo = ?, Salario = ? WHERE id_empleado = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, empleados.getNombre());
            pst.setString(2, empleados.getCargo());
            pst.setDouble(3, empleados.getSalario());
            pst.setInt(4, empleados.getID());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no actualizado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
