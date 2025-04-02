/**
 * Clase VentasGUI que representa la interfaz gráfica de usuario para la gestión de ventas.
 * Permite agregar, actualizar, eliminar y visualizar ventas en una tabla.
 */
package Ventas;

import Conexion.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class VentasGUI {
    private JTable table1;
    private JPanel panel1;
    private JTextField textField1; // ID Venta
    private JTextField textField2; // ID Cliente
    private JTextField textField3; // ID Empleado
    private JTextField textField4; // Total
    private JTextField textField5; // Fecha
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;

    private ventasDAO ventasDAO = new ventasDAO();
    private ConexionBD conexionBD = new ConexionBD();

    /**
     * Constructor de la clase VentasGUI.
     * Inicializa la interfaz gráfica y configura los eventos de los botones.
     */
    public VentasGUI() {
        cargarVentas();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCliente = Integer.parseInt(textField2.getText());
                int idEmpleado = Integer.parseInt(textField3.getText());
                double total = Double.parseDouble(textField4.getText());

                // Crear un timestamp con la fecha y hora actual
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                textField5.setText(timestamp.toString());

                // Crear objeto Ventas con el timestamp
                Ventas venta = new Ventas(0, idCliente, idEmpleado, total, timestamp);
                ventasDAO.agregar(venta);
                cargarVentas();
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idVenta = Integer.parseInt(textField1.getText());
                int idCliente = Integer.parseInt(textField2.getText());
                int idEmpleado = Integer.parseInt(textField3.getText());
                double total = Double.parseDouble(textField4.getText());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                textField5.setText(timestamp.toString());

                Ventas venta = new Ventas(idVenta, idCliente, idEmpleado, total, timestamp);
                ventasDAO.actualizar(venta);
                cargarVentas();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idVenta = Integer.parseInt(textField1.getText());
                ventasDAO.eliminar(idVenta);
                cargarVentas();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    textField1.setText(table1.getValueAt(filaSeleccionada, 0).toString());
                    textField2.setText(table1.getValueAt(filaSeleccionada, 1).toString());
                    textField3.setText(table1.getValueAt(filaSeleccionada, 2).toString());
                    textField4.setText(table1.getValueAt(filaSeleccionada, 3).toString());
                    textField5.setText(table1.getValueAt(filaSeleccionada, 4).toString());
                }
            }
        });
    }

    /**
     * Carga las ventas desde la base de datos y las muestra en la tabla de la interfaz gráfica.
     */
    public void cargarVentas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Venta");
        model.addColumn("ID Cliente");
        model.addColumn("ID Empleado");
        model.addColumn("Total");
        model.addColumn("Fecha");

        table1.setModel(model);
        String[] datos = new String[5];
        Connection con = conexionBD.getConnection();

        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión.");
            return;
        }

        try {
            Statement stat = con.createStatement();
            String query = "SELECT * FROM ventas";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método principal que inicia la aplicación de gestión de ventas.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Ventas");
        frame.setContentPane(new VentasGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(880, 700);
        frame.setResizable(false);
    }
}
