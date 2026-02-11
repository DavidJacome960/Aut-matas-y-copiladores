package pck_graphics;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRound extends JPanel {

    // ==== ESQUINAS REDONDEADAS ====
    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    // ==== COLORES DEGRADADO ====
    private Color gradientColor1 = new Color(66, 133, 244, 255); // Azul por defecto, alfa incluido
    private Color gradientColor2 = new Color(219, 68, 55, 255);  // Rojo por defecto, alfa incluido

    // ==== DIRECCION DEL DEGRADADO ====
    public enum GradientDirection { VERTICAL, HORIZONTAL, DIAGONAL }
    private GradientDirection gradientDirection = GradientDirection.VERTICAL;

    public PanelRound() {
        setOpaque(false);
    }

    // ==== PROPIEDADES ====
    public int getRoundTopLeft() { return roundTopLeft; }
    public void setRoundTopLeft(int roundTopLeft) { this.roundTopLeft = roundTopLeft; repaint(); }

    public int getRoundTopRight() { return roundTopRight; }
    public void setRoundTopRight(int roundTopRight) { this.roundTopRight = roundTopRight; repaint(); }

    public int getRoundBottomLeft() { return roundBottomLeft; }
    public void setRoundBottomLeft(int roundBottomLeft) { this.roundBottomLeft = roundBottomLeft; repaint(); }

    public int getRoundBottomRight() { return roundBottomRight; }
    public void setRoundBottomRight(int roundBottomRight) { this.roundBottomRight = roundBottomRight; repaint(); }

    public Color getGradientColor1() { return gradientColor1; }
    public void setGradientColor1(Color gradientColor1) { this.gradientColor1 = gradientColor1; repaint(); }

    public Color getGradientColor2() { return gradientColor2; }
    public void setGradientColor2(Color gradientColor2) { this.gradientColor2 = gradientColor2; repaint(); }

    public GradientDirection getGradientDirection() { return gradientDirection; }
    public void setGradientDirection(GradientDirection gradientDirection) { 
        this.gradientDirection = gradientDirection; 
        repaint(); 
    }

    // ==== PINTADO ====
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) area.intersect(new Area(createRoundTopRight()));
        if (roundBottomLeft > 0) area.intersect(new Area(createRoundBottomLeft()));
        if (roundBottomRight > 0) area.intersect(new Area(createRoundBottomRight()));

        // Crear degradado usando los colores con transparencia incluida
        GradientPaint gp;
        switch (gradientDirection) {
            case HORIZONTAL:
                gp = new GradientPaint(0, 0, gradientColor1, getWidth(), 0, gradientColor2);
                break;
            case DIAGONAL:
                gp = new GradientPaint(0, 0, gradientColor1, getWidth(), getHeight(), gradientColor2);
                break;
            default:
                gp = new GradientPaint(0, 0, gradientColor1, 0, getHeight(), gradientColor2);
        }

        g2.setPaint(gp);
        g2.fill(area);

        g2.dispose();
        super.paintComponent(grphcs);
    }

    // ==== FORMAS PARA ESQUINAS REDONDEADAS ====
    private Shape createRoundTopLeft() {
        int width = getWidth(), height = getHeight();
        int roundX = Math.min(width, roundTopLeft), roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth(), height = getHeight();
        int roundX = Math.min(width, roundTopRight), roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth(), height = getHeight();
        int roundX = Math.min(width, roundBottomLeft), roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth(), height = getHeight();
        int roundX = Math.min(width, roundBottomRight), roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
}
