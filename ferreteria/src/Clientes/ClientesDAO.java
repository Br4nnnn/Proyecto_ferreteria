package Clientes;

import Conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientesDAO {
    private ConexionBD conexionBD = new ConexionBD();
    public void crear(Clientes clientes){
        Connection con = conexionBD.getConnection();

        String query = "INSERT INTO clientes (nombre,telefono,direccion,correo) VALUES (?,?,?,?)";

        try{
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1,clientes.getNombre());
            pst.setString(2, clientes.getTelefono());
            pst.setString(3, clientes.getDireccion());
            pst.setString(3, clientes.getCorreo());

            int resultado = pst.executeUpdate();
            if (resultado > 0){
                JOptionPane.showMessageDialog(null,"Cliente creado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null,"Error al crear al cliente.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
