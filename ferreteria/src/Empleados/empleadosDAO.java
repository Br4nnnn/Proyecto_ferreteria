package Empleados;

import Conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class empleadosDAO
{
    private ConexionBD ConexionBD = new ConexionBD();

    public void agregar(Empleados empleados) {
        Connection con = ConexionBD.getConnection();

        String query = "INSERT INTO empleados (Nombre,Cargo,Salario) VALUES (?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, empleados.getNombre());
            pst.setString(2, empleados.getCargo());
            pst.setDouble(3, empleados.getSalario());

            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "empleados agregado exitosamnte");
            } else {
                JOptionPane.showMessageDialog(null, "empleados no agregado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar ( int ID)
    {
        Connection con = ConexionBD.getConnection();

        String query = "DELETE FROM empleados WHERE id_empleado = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, ID);

            int resultado = pst.executeUpdate();

            if (resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "empleados eliminado exitosamnte");
            } else
            {
                JOptionPane.showMessageDialog(null, "empleados no eliminado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar (Empleados empleados)
    {
        Connection con = ConexionBD.getConnection();

        String query = "UPDATE empleados SET Nombre = ?, Cargo = ?, Salario = ? WHERE id_empleado = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, empleados.getNombre());
            pst.setString(2, empleados.getCargo());
            pst.setDouble(3, empleados.getSalario());
            pst.setInt(4, empleados.getID());

            int resultado = pst.executeUpdate();

            if (resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "empleados actualizado exitosamnte");
            } else
            {
                JOptionPane.showMessageDialog(null, "empleados no actualizado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}