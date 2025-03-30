package Proveedores;

import Conexion.ConexionBD;
import Proveedores.proveedoresDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProveedoresGUI {
    private JTable table1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;

    private proveedoresDAO proveedoresDAO = new proveedoresDAO();
    private ConexionBD conexionBD = new ConexionBD();

    /**
     * Constructor de la clase ProveedoresGUI.
     *
     * Inicializa la interfaz gráfica y configura los eventos de los botones.
     */
    public ProveedoresGUI() {
        cargarProveedores();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                double contacto = Double.parseDouble(textField2.getText());

                Proveedores proveedores = new Proveedores(0, nombre, contacto);
                proveedoresDAO.agregar(proveedores);
                cargarProveedores();
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_proveedor = Integer.parseInt(textField3.getText());
                String nombre = textField1.getText();
                double contacto = Double.parseDouble(textField2.getText());

                Proveedores proveedores = new Proveedores(id_proveedor, nombre, contacto);
                proveedoresDAO.actualizar(proveedores);
                cargarProveedores();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_proveedor = Integer.parseInt(textField3.getText());
                proveedoresDAO.eliminar(id_proveedor);
                cargarProveedores();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    textField3.setText(table1.getValueAt(filaSeleccionada, 0).toString());
                    textField1.setText(table1.getValueAt(filaSeleccionada, 1).toString());
                    textField2.setText(table1.getValueAt(filaSeleccionada, 2).toString());
                }
            }
        });
    }

    /**
     * Carga los empleados desde la base de datos y los muestra en la tabla de la interfaz gráfica.
     */
    public void cargarProveedores() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id_proveedor");
        model.addColumn("nombre");
        model.addColumn("contacto");

        table1.setModel(model);
        String[] datos = new String[3];
        Connection con = conexionBD.getConnection();

        try {
            Statement stat = con.createStatement();
            String query = "SELECT * FROM proveedores";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(2);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método principal que inicia la aplicación de gestión de empleados.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Empleados");
        frame.setContentPane(new ProveedoresGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(880, 700);
        frame.setResizable(false);
    }
}


