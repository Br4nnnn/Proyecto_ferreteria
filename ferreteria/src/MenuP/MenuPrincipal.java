package MenuP;

import Clientes.ClientesGUI;
import Empleados.EmpleadosGUI;
import Inventario_productos.Inventario_productosGUI;
import Proveedores.ProveedoresGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private JPanel main;
    private JButton clientesMenu;
    private JButton empleadosMenu;
    private JButton inventarioproductoMenu;
    private JButton ordenesCompraMenu;
    private JButton proveedoresMenu;
    private JPanel jPanelBackground;

    public MenuPrincipal(){

        clientesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(clientesMenu);
                jFrame.dispose();
                ClientesGUI.main(null);
            }
        });

        inventarioproductoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(inventarioproductoMenu);
                jFrame.dispose();
                Inventario_productosGUI.main(null);
            }
        });

        empleadosMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(empleadosMenu);
                jFrame.dispose();
                EmpleadosGUI.main(null);
            }
        });

        proveedoresMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(proveedoresMenu);
                jFrame.dispose();
                ProveedoresGUI.main(null);
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú principal");
        frame.setContentPane(new MenuPrincipal().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
    }
}