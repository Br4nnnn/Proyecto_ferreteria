package Detalle_venta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

/**
 * Clase GUI para gestionar la interfaz gráfica de la gestión de detalles de venta.
 */
public class Detalle_ventaGUI {
    private JTable table1;
    private JPanel panel1;
    private JTextField textField1; // ID Venta
    private JTextField textField2; // ID Cliente
    private JTextField textField3; // ID Empleado
    private JTextField textField4;
    private JTextField textField5;
    private JButton agregarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private detalle_ventaDAO detalleVentaDAO = new detalle_ventaDAO();

    /**
     * Constructor de la clase, inicializa la interfaz y configura los eventos de los botones.
     */
    public Detalle_ventaGUI() {
        cargarDetallesVenta();

        agregarButton.addActionListener(e -> {
            int idVenta = Integer.parseInt(textField2.getText());
            int idProducto = Integer.parseInt(textField3.getText());
            int cantidad = Integer.parseInt(textField4.getText());
            double precioUnitario = Double.parseDouble(textField5.getText());

            Detalle_venta detalle = new Detalle_venta(0, idVenta, idProducto, cantidad, precioUnitario);
            detalleVentaDAO.agregar(detalle);
            cargarDetallesVenta();
        });

        actualizarButton.addActionListener(e -> {
            int filaSeleccionada = table1.getSelectedRow();
            if (filaSeleccionada >= 0) {
                int idDetalle = Integer.parseInt(table1.getValueAt(filaSeleccionada, 0).toString());
                int idVenta = Integer.parseInt(textField2.getText());
                int idProducto = Integer.parseInt(textField3.getText());
                int cantidad = Integer.parseInt(textField4.getText());
                double precioUnitario = Double.parseDouble(textField5.getText());

                Detalle_venta detalle = new Detalle_venta(idDetalle, idVenta, idProducto, cantidad, precioUnitario);
                detalleVentaDAO.actualizar(detalle);
                cargarDetallesVenta();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para actualizar.");
            }
        });

        eliminarButton.addActionListener(e -> {
            int filaSeleccionada = table1.getSelectedRow();
            if (filaSeleccionada >= 0) {
                int idDetalle = Integer.parseInt(table1.getValueAt(filaSeleccionada, 0).toString());
                detalleVentaDAO.eliminar(idDetalle);
                cargarDetallesVenta();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = table1.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    textField1.setText(table1.getValueAt(filaSeleccionada, 0).toString()); // ID Detalle
                    textField2.setText(table1.getValueAt(filaSeleccionada, 1).toString()); // ID Venta
                    textField3.setText(table1.getValueAt(filaSeleccionada, 2).toString()); // ID Producto
                    textField4.setText(table1.getValueAt(filaSeleccionada, 3).toString()); // Cantidad
                    textField5.setText(table1.getValueAt(filaSeleccionada, 4).toString()); // Precio Unitario
                }
            }
        });
    }

    /**
     * Carga los detalles de venta en la tabla de la interfaz gráfica.
     */
    public void cargarDetallesVenta() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Detalle");
        model.addColumn("ID Venta");
        model.addColumn("ID Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio Unitario");

        List<Detalle_venta> lista = detalleVentaDAO.listar();
        for (Detalle_venta detalle : lista) {
            model.addRow(new Object[]{
                    detalle.getIdDetalle(), detalle.getIdVenta(), detalle.getIdProducto(),
                    detalle.getCantidad(), detalle.getPrecioUnitario()
            });
        }
        table1.setModel(model);
    }

    /**
     * Método principal para ejecutar la interfaz gráfica.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Detalle de Venta");
        frame.setContentPane(new Detalle_ventaGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(880, 700);
        frame.setVisible(true);
    }
}
