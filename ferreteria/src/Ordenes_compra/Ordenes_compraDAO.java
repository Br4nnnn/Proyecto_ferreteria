package Ordenes_compra;

import Conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ordenes_compraDAO {
    ConexionBD conexionBD = new ConexionBD();

    public void crear(Ordenes_compra ordenes_Compra){
        Connection con = conexionBD.getConnection();
        String query = "INSERT INTO ordenes_compra (id_cliente, id_empleado, id_producto, total, estado_orden, fecha_compra) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, ordenes_Compra.getId_cliente());
            pst.setInt(2, ordenes_Compra.getId_empleado());
            pst.setInt(3, ordenes_Compra.getId_producto());
            pst.setInt(4, ordenes_Compra.getTotal());
            pst.setString(4, ordenes_Compra.getEstado_orden());
            pst.setString(4, ordenes_Compra.getFecha_compra());

            int resultado = pst.executeUpdate();
            String mensaje = resultado > 0 ? "Orden de compra registrada con éxito!" : "Error al ingresar la orden de compra...";
            int tipo_mensaje = resultado > 0 ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, mensaje, "Ordenes compra:", tipo_mensaje);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void actualizar(Ordenes_compra ordenes_Compra){
        Connection con = conexionBD.getConnection();
        String query = "UPDATE ordenes_compra SET id_cliente = ?, id_empleado = ?, id_producto = ?, total = ?, estado_compra = ?, fecha_compra = ?";

        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, ordenes_Compra.getId_cliente());
            pst.setInt(2, ordenes_Compra.getId_empleado());
            pst.setInt(3, ordenes_Compra.getId_producto());
            pst.setInt(4, ordenes_Compra.getTotal());
            pst.setString(4, ordenes_Compra.getEstado_orden());
            pst.setString(4, ordenes_Compra.getFecha_compra());

            int resultado = pst.executeUpdate();
            String mensaje = resultado > 0 ? "La órden de compra ha sido actualizada con éxito." : "Error al actualizar la orden de compra.";
            int mensaje_tipo = resultado > 0 ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, mensaje, "Ordenes compra:", mensaje_tipo);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

