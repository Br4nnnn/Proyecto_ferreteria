/**
 * Clase ClientesDAO que maneja las operaciones de base de datos para la entidad Clientes.
 * Proporciona métodos para crear, eliminar y actualizar registros en la tabla clientes.
 */
package Clientes;

import Conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientesDAO {

    /** Objeto para gestionar la conexión a la base de datos. */
    private ConexionBD conexionBD = new ConexionBD();

    /**
     * Crea un nuevo cliente en la base de datos.
     * @param clientes Objeto Clientes con la información del nuevo cliente.
     */
    public void crear(Clientes clientes){
        Connection con = conexionBD.getConnection();
        String query = "INSERT INTO clientes (nombre,telefono,direccion,correo) VALUES (?,?,?,?)";

        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, clientes.getNombre());
            pst.setString(2, clientes.getTelefono());
            pst.setString(3, clientes.getDireccion());
            pst.setString(4, clientes.getCorreo()); // Corregido el índice de correo

            int resultado = pst.executeUpdate();
            if (resultado > 0){
                JOptionPane.showMessageDialog(null, "Cliente creado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear al cliente.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente de la base de datos basado en su ID.
     * @param id_cliente Identificador del cliente a eliminar.
     */
    public void eliminar(int id_cliente){
        Connection con = conexionBD.getConnection();
        String query = "DELETE FROM clientes WHERE id_cliente = ?"; // Corregida la consulta SQL

        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_cliente);

            int resultado = pst.executeUpdate();
            if (resultado > 0){
                JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al cliente.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     * @param clientes Objeto Clientes con la información actualizada del cliente.
     */
    public void actualizar(Clientes clientes){
        Connection con = conexionBD.getConnection();
        String query = "UPDATE clientes SET nombre = ?, telefono = ?, direccion = ?, correo = ? WHERE id_cliente = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, clientes.getNombre());
            pst.setString(2, clientes.getTelefono());
            pst.setString(3, clientes.getDireccion());
            pst.setString(4, clientes.getCorreo());
            pst.setInt(5, clientes.getId_cliente());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Éxito al actualizar al cliente.");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al cliente.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
