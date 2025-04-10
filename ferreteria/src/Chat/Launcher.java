package Chat;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Chat.chatGUI("Empleado");
            new Chat.chatGUI("Cliente");
        });
    }
}

