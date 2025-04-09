package MenuP;

import javax.swing.*;
import java.awt.*;

public class FondoPanel extends JPanel {
    private Image imagen;

    public FondoPanel() {
        // Asegúrate de que el nombre y ruta de la imagen sean correctos
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/ferre.png"));
        imagen = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //  Activamos renderizado de alta calidad
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja la imagen escalada al tamaño del panel
        g2d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}




