package MenuP;

import Clientes.ClientesGUI;
import Empleados.EmpleadosGUI;
import Inventario_productos.Inventario_productosGUI;
import Ordenes_compra.Ordenes_compraGUI;
import Proveedores.ProveedoresGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;


public class MenuPrincipal {
    private JPanel main;
    private JButton clientesMenu;
    private JButton empleadosMenu;
    private JButton inventariosMenu;
    private JButton ordenesCompraMenu;
    private JButton proveedoresMenu;

    public MenuPrincipal(){
        aplicarEstiloBasico(clientesMenu);
        aplicarEstiloBasico(empleadosMenu);
        aplicarEstiloBasico(inventariosMenu);
        aplicarEstiloBasico(ordenesCompraMenu);
        aplicarEstiloBasico(proveedoresMenu);


        clientesMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(clientesMenu);
                jFrame.dispose();
                ClientesGUI.main(null);
            }
        });

        inventariosMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(inventariosMenu);
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

        ordenesCompraMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(ordenesCompraMenu);
                jFrame.dispose();
                Ordenes_compraGUI.main(null);
            }
        });
    }

    private void aplicarEstiloBasico(JButton boton) {
        boton.setFocusPainted(false);
        boton.setBackground(new Color(33, 150, 243));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú principal");
        MenuPrincipal menu = new MenuPrincipal();
        FondoPanel fondo = new FondoPanel();
        fondo.setLayout(new BorderLayout());

        menu.main.setOpaque(false);
        fondo.add(menu.main, BorderLayout.CENTER);

        frame.setContentPane(fondo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
    }
}

