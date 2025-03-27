/**
 * Clase EmpleadosGUI.
 *
 * Proporciona una interfaz gráfica para la gestión de empleados, permitiendo agregar, actualizar y eliminar registros en la base de datos.
 *
 * @author Alejandro Vera
 * @version 1.0
 */
package Empleados;

import Conexion.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadosGUI {
    private JPanel panel1;
    private JTextField textField3;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTable table1;
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;

    private empleadosDAO empleadosDAO = new empleadosDAO();
    private ConexionBD conexionBD = new ConexionBD();

    /**
     * Constructor de la clase EmpleadosGUI.
     *
     * Inicializa la interfaz gráfica y configura los eventos de los botones.
     */
    public EmpleadosGUI() {
        cargarEmpleados();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                String cargo = (String) comboBox1.getSelectedItem();
                double salario = Double.parseDouble(textField2.getText());

                Empleados empleado = new Empleados(0, nombre, cargo, salario);
                empleadosDAO.agregar(empleado);
                cargarEmpleados();
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField3.getText());
                String nombre = textField1.getText();
                String cargo = (String) comboBox1.getSelectedItem();
                double salario = Double.parseDouble(textField2.getText());

                Empleados empleado = new Empleados(id, nombre, cargo, salario);
                empleadosDAO.actualizar(empleado);
                cargarEmpleados();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField3.getText());
                empleadosDAO.eliminar(id);
                cargarEmpleados();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    textField3.setText(table1.getValueAt(filaSeleccionada, 0).toString());
                    textField1.setText(table1.getValueAt(filaSeleccionada, 1).toString());
                    comboBox1.setSelectedItem(table1.getValueAt(filaSeleccionada, 2).toString());
                    textField2.setText(table1.getValueAt(filaSeleccionada, 3).toString());
                }
            }
        });
    }

    /**
     * Carga los empleados desde la base de datos y los muestra en la tabla de la interfaz gráfica.
     */
    public void cargarEmpleados() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Cargo");
        model.addColumn("Salario");

        table1.setModel(model);
        String[] datos = new String[4];
        Connection con = conexionBD.getConnection();

        try {
            Statement stat = con.createStatement();
            String query = "SELECT * FROM empleados";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
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
        frame.setContentPane(new EmpleadosGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(880, 700);
        frame.setResizable(false);
    }
}
