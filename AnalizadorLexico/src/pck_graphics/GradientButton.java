package pck_graphics;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.Timer;

public class GradientButton extends JButton implements Serializable {

    private int cornerRadius = 50;
    private int borderThickness = 10;
    private Color color1 = new Color(0, 200, 200);
    private Color color2 = new Color(0, 100, 255);
    private Color glowColor = new Color(255, 220, 100);
    private Color backgroundColor = Color.WHITE; // Color de fondo editable
    private boolean over = false;
    private boolean glowing = false;
    private Icon buttonIcon; // NUEVO: soporte de icono

    public GradientButton() {
        super("Button");
        init();
    }

    public GradientButton(String text) {
        super(text);
        init();
    }

    public GradientButton(String text, Icon icon) {
        super(text, icon);
        this.buttonIcon = icon;
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(new Color(80, 80, 80));
        setFont(new Font("Segoe UI", Font.BOLD, 16));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                over = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                over = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                startGlowAnimation();
            }
        });
    }

    private void startGlowAnimation() {
        glowing = true;
        repaint();

        Timer t = new Timer(300, e -> {
            glowing = false;
            repaint();
            ((Timer) e.getSource()).stop();
        });
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Colores del borde
        Color start = glowing ? glowColor : (over ? color1.brighter() : color1);
        Color end   = glowing ? glowColor : (over ? color2.brighter() : color2);

        // Borde con degradado
        GradientPaint gp = new GradientPaint(0, 0, start, width, height, end);
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);

        // Fondo interior editable
        g2.setColor(backgroundColor);
        g2.fillRoundRect(borderThickness, borderThickness,
                width - borderThickness * 2,
                height - borderThickness * 2,
                cornerRadius - borderThickness,
                cornerRadius - borderThickness);

        // Sombra interior
        g2.setColor(new Color(0, 0, 0, 30));
        g2.drawRoundRect(borderThickness, borderThickness,
                width - borderThickness * 2 - 1,
                height - borderThickness * 2 - 1,
                cornerRadius - borderThickness,
                cornerRadius - borderThickness);

        // ----- DIBUJAR ICONO + TEXTO -----
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();

        int iconWidth = 0, iconHeight = 0;
        if (buttonIcon != null) {
            iconWidth = buttonIcon.getIconWidth();
            iconHeight = buttonIcon.getIconHeight();
        }

        // Calcular posición centrada considerando icono + texto
        int totalWidth = textWidth + (buttonIcon != null ? iconWidth + 6 : 0); // +6 px espacio
        int xStart = (width - totalWidth) / 2;
        int yText = (height + textHeight) / 2 - 3;

        // Dibuja ícono si existe
        if (buttonIcon != null) {
            int yIcon = (height - iconHeight) / 2;
            buttonIcon.paintIcon(this, g2, xStart, yIcon);
            xStart += iconWidth + 6; // deja espacio para el texto
        }

        // Dibuja el texto
        g2.setColor(getForeground());
        g2.drawString(getText(), xStart, yText);

        g2.dispose();
    }

    // -------- GETTERS Y SETTERS (para NetBeans Properties) --------
    public int getCornerRadius() { return cornerRadius; }
    public void setCornerRadius(int cornerRadius) { this.cornerRadius = cornerRadius; repaint(); }

    public int getBorderThickness() { return borderThickness; }
    public void setBorderThickness(int borderThickness) { this.borderThickness = borderThickness; repaint(); }

    public Color getColor1() { return color1; }
    public void setColor1(Color color1) { this.color1 = color1; repaint(); }

    public Color getColor2() { return color2; }
    public void setColor2(Color color2) { this.color2 = color2; repaint(); }

    public Color getGlowColor() { return glowColor; }
    public void setGlowColor(Color glowColor) { this.glowColor = glowColor; repaint(); }

    public Color getBackgroundColor() { return backgroundColor; }
    public void setBackgroundColor(Color backgroundColor) { this.backgroundColor = backgroundColor; repaint(); }

    public Icon getButtonIcon() { return buttonIcon; }
    public void setButtonIcon(Icon buttonIcon) { this.buttonIcon = buttonIcon; repaint(); }
}
