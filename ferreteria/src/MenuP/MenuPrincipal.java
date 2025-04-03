package MenuP;

import Clientes.ClientesGUI;
import Empleados.EmpleadosGUI;
import Inventario_productos.Inventario_productosGUI;
import Proveedores.ProveedoresGUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa el menú principal de la aplicación.
 * Permite la navegación a diferentes módulos como Clientes, Empleados, Inventario de Productos y Proveedores.
 */
public class MenuPrincipal {
    private JPanel main;
    private JButton clientesMenu;
    private JButton empleadosMenu;
    private JButton inventarioproductoMenu;
    private JButton ordenesCompraMenu;
    private JButton proveedoresMenu;

    /**
     * Constructor de la clase MenuPrincipal.
     * Configura los botones para abrir las respectivas interfaces de usuario de cada módulo.
     */
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

    /**
     * Método principal para iniciar la aplicación y mostrar el menú principal.
     * @param args Argumentos de la línea de comandos (no se usan en este caso).
     */
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
