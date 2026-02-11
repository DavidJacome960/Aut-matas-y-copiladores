package pck_programa;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pck_GIU.Inicio;

public class main {

    public static void main(String[] args) {
        try {
            // Cambia el Look and Feel a Windows (si está disponible)
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException 
                | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        // Ahora abre tu ventana con el estilo aplicado
        Inicio i = new Inicio();
        i.setVisible(true);
    }
    
}
