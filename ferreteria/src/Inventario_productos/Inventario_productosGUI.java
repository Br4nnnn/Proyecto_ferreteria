package Inventario_productos;

import Conexion.ConexionBD;
import MenuP.MenuPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventario_productosGUI {
    private JTable table1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JComboBox comboBox1;
    private JButton volverAlMenuButton;

    private Inventario_productosDAO inventario_productosDAO = new Inventario_productosDAO();
    private ConexionBD conexionBD = new ConexionBD();

    /**
     * Constructor de la clase Inventario_productosGUI.
     *
     * Inicializa la interfaz gráfica y configura los eventos de los botones.
     */
    public Inventario_productosGUI() {
        cargarInventario_productos(); // Asegúrate de que este método esté definido correctamente fuera de cualquier acción.

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoria_producto = (String) comboBox1.getSelectedItem();
                String nombre_producto = textField3.getText();
                String precio_proveedor = textField4.getText();
                String precio_venta = textField5.getText();
                String cantidad_stock = textField6.getText();


                Inventario_productos inventario_producto = new Inventario_productos(0, categoria_producto, nombre_producto, precio_proveedor, precio_venta, cantidad_stock);
                inventario_productosDAO.agregar(inventario_producto);
                cargarInventario_productos();
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id_producto = Integer.parseInt(textField1.getText());
                    String nombre_producto = textField3.getText();
                    String precio_proveedor = textField4.getText();
                    String precio_venta = textField5.getText();
                    String cantidad_stock = textField6.getText();
                    String categoria_producto = (String) comboBox1.getSelectedItem();

                    Inventario_productos inventario_producto = new Inventario_productos(id_producto, categoria_producto, nombre_producto, precio_proveedor, precio_venta, cantidad_stock);
                    inventario_productosDAO.actualizar(inventario_producto);
                    cargarInventario_productos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de producto no válido.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id_producto = Integer.parseInt(textField1.getText()); // Usando textField1 para el ID
                    inventario_productosDAO.eliminar(id_producto);
                    cargarInventario_productos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de producto no válido.");
                }
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    textField1.setText(table1.getValueAt(filaSeleccionada, 0).toString());
                    comboBox1.setSelectedItem(table1.getValueAt(filaSeleccionada, 1).toString());
                    textField3.setText(table1.getValueAt(filaSeleccionada, 2).toString());
                    textField4.setText(table1.getValueAt(filaSeleccionada, 3).toString());
                    textField5.setText(table1.getValueAt(filaSeleccionada, 4).toString());
                    textField6.setText(table1.getValueAt(filaSeleccionada, 5).toString());
                }
            }
        });
    }

    /**
     * Carga los productos desde la base de datos y los muestra en la tabla de la interfaz gráfica.
     */
    public void cargarInventario_productos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id_producto");
        model.addColumn("categoria_Producto");
        model.addColumn("nombre_producto");
        model.addColumn("precio_proveedor");
        model.addColumn("precio_venta");
        model.addColumn("cantidad_stock");

        table1.setModel(model);
        String[] datos = new String[6];
        Connection con = conexionBD.getConnection();

        try {
            Statement stat = con.createStatement();
            String query = "SELECT * FROM inventario_productos";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        volverAlMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(volverAlMenuButton);
                jFrame.dispose();
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.main(null);
            }
        });
    }

    /**
     * Método principal que inicia la aplicación de gestión de inventario de productos.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Inventario de Productos");
        frame.setContentPane(new Inventario_productosGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(880, 650);
        frame.setResizable(false);
    }
}
