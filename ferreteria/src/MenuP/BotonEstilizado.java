package MenuP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonEstilizado extends JButton {

    private Color colorFondo = new Color(33, 150, 243);
    private Color colorHover = new Color(30, 136, 229);

    public BotonEstilizado(String texto) {
        super(texto);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBackground(colorFondo);
        setFont(new Font("Segoe UI", Font.BOLD, 18));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Efecto hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                colorFondo = colorHover;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                colorFondo = new Color(33, 150, 243);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(colorFondo);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g2);
    }
}
