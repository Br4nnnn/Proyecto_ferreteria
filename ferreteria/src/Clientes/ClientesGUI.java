package Clientes;

import Conexion.ConexionDB;
import PruebaMenu.MenuPrueba;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesGUI {
    private JPanel main;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JButton volverButton;
    private JButton volverAlMenuButton;

    ClientesDAO ClientesDAO = new ClientesDAO();
    ConexionDB ConexionDB = new ConexionDB();

    int filas = 0;

    public JPanel getMainPanel() {
        return main;
    }

    public ClientesGUI() {
        mostrar();
        textField1.setEnabled(false);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField2.getText();
                String telefono = textField3.getText();
                String direccion = textField4.getText();
                String correo = textField5.getText();

                Clientes Clientes = new Clientes(0, nombre, telefono, direccion, correo);
                ClientesDAO.agregar(Clientes);

                mostrar();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textField1.getText());
                ClientesDAO.eliminar(id);

                mostrar();
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField2.getText();
                String telefono = textField3.getText();
                String direccion = textField4.getText();
                String correo = textField5.getText();
                int id = Integer.parseInt(textField1.getText());

                Clientes Clientes = new Clientes(id, nombre, telefono, direccion, correo);
                ClientesDAO.actualizar(Clientes);

                mostrar();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectFila = table1.getSelectedRow();

                if (selectFila >= 0) {
                    textField1.setText((String) table1.getValueAt(selectFila, 0));
                    textField2.setText((String) table1.getValueAt(selectFila, 1));
                    textField3.setText((String) table1.getValueAt(selectFila, 2));
                    textField4.setText((String) table1.getValueAt(selectFila, 3));
                    textField5.setText((String) table1.getValueAt(selectFila, 4));

                    filas = selectFila;
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(volverButton);
                jFrame.dispose();
                MenuPrueba.main(null);
            }
        });
    }

    public void mostrar() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID cliente");
        model.addColumn("Nombre");
        model.addColumn("Telefono");
        model.addColumn("Direccion");
        model.addColumn("Correo");

        table1.setModel(model);
        String[] dato = new String[5];
        Connection con = ConexionDB.getConnection();

        try {
            Statement stat = con.createStatement();
            String query = "SELECT * FROM clientes";
            ResultSet fb = stat.executeQuery(query);

            while (fb.next()) {
                dato[0] = fb.getString(1);
                dato[1] = fb.getString(2);
                dato[2] = fb.getString(3);
                dato[3] = fb.getString(4);
                dato[4] = fb.getString(5);
                model.addRow(dato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatArcDarkIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Clientes");
        frame.setContentPane(new ClientesGUI().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1006, 550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
