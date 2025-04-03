package Ordenes_compra;

import Conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ordenes_compraDAO {
    ConexionBD conexionDB = new ConexionBD();

    public void Crear(Ordenes_compra ordenesCompra){
        Connection con = conexionDB.getConnection();
        String query = "INSERT INTO ordenes_compra (id_cliente, id_empleado, id_producto, total, estado_orden, fecha_compra) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, ordenesCompra.getId_cliente());
            pst.setInt(2, ordenesCompra.getId_empleado());
            pst.setInt(3, ordenesCompra.getId_producto());
            pst.setInt(4, ordenesCompra.getTotal());
            pst.setString(4, ordenesCompra.getEstado_orden());
            pst.setString(4, ordenesCompra.getFecha_compra());

            int resultado = pst.executeUpdate();
            String mensaje = resultado > 0 ? "Orden de compra registrada con éxito!" : "Error al ingresar la orden de compra...";
            int tipo_mensaje = resultado > 0 ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(null, mensaje, "Ordenes compra:", tipo_mensaje);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

