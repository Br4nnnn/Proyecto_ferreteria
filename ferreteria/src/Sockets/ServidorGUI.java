package Sockets;

import PruebaMenu.MenuPrueba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class ServidorGUI {
    public JPanel main;
    private JTextArea textArea1;
    private JButton enviarButton;
    private JTextField textField1;
    private JButton iniciarServidorButton;
    private JButton volverAlMenúButton;

    private PrintWriter out;
    private Socket clientSocket;

    public ServidorGUI(){
        textArea1.setEditable(false);


        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enviarMensaje();
                }
            }
        });


        iniciarServidorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> iniciar()).start();
            }
        });
        volverAlMenúButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = (JFrame) SwingUtilities.getWindowAncestor(volverAlMenúButton);
                jFrame.dispose();
                MenuPrueba.main(null);
            }
        });
    }

    public void iniciar(){
        try (ServerSocket serverSocket = new ServerSocket(12345)){
            JOptionPane.showMessageDialog(null, "Servidor iniciado");
            do {
                clientSocket = serverSocket.accept();
                actualizarTextArea("Se ha conectado el cliente.\n");

                //Leyendo los mensajes que llegan del cliente al server y viceversa
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                new Thread(() -> recibirMensaje(in)).start();

            } while (true);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error del servidor", "Error: ", ERROR_MESSAGE);
        }
    }

    public void enviarMensaje(){
        String mensaje = textField1.getText();
        if(mensaje != null || !mensaje.trim().isEmpty()){
            if(out != null){
                out.println(mensaje);
                actualizarTextArea("Servidor: " + mensaje + "\n");
                textField1.setText("");
            } else {
                showMessageDialog(null, "Error al conectar con el cliente");
            }
        }
    }

    private void actualizarTextArea(String mensaje) {
        SwingUtilities.invokeLater(() -> textArea1.append(mensaje));
    }



    public void recibirMensaje(BufferedReader in){
        try{
            String recievedMessage;
            while ((recievedMessage = in.readLine()) != null) {
                if (recievedMessage.equalsIgnoreCase("salir")) {
                    actualizarTextArea("El cliente abandonó la conversación.\n");
                    break;
                }
                actualizarTextArea("Cliente: " + recievedMessage + "\n");
            }
        } catch (IOException e){
            actualizarTextArea("Error al recibir el mensaje: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat del Servidor");
        ServidorGUI servidorGUI = new ServidorGUI();
        frame.setContentPane(servidorGUI.main);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Comentado por alguna razón
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
