package pck_GIU;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.Compilador();
    }

    private void Compilador() {
        StyledDocument doc = txt_Consola.getStyledDocument();
        
        Style numero = txt_Consola.addStyle("numero", null);
        StyleConstants.setForeground(numero, new Color(0, 204, 51));
        Style minus = txt_Consola.addStyle("minus", null);
        StyleConstants.setForeground(minus, new Color(0, 0, 153));
        Style mayus = txt_Consola.addStyle("mayus", null);
        StyleConstants.setForeground(mayus, new Color(255, 0, 0));
        Style signo = txt_Consola.addStyle("signo", null);
        StyleConstants.setForeground(signo, new Color(255, 0, 153));
        Style id = txt_Consola.addStyle("id", null);
        StyleConstants.setForeground(id, new Color(102, 0, 102));

        ((AbstractDocument) doc).setDocumentFilter(new DocumentFilter() {

            java.util.regex.Pattern patron = java.util.regex.Pattern.compile(
                    "\\d+|"
                    + // números
                    "[a-zA-Z][a-zA-Z0-9_\\$]*|"
                    + // identificadores
                    "[a-z]+|"
                    + // minúsculas
                    "[A-Z]+|"
                    + // mayúsculas
                    "[+\\-*/=<>!%&|^(){}\\[\\]]" // signos
            );
            
            int totNum, totMin, totMay, totSig, totId;

            private void aplicarColores() {

                SwingUtilities.invokeLater(() -> {

                    String texto = txt_Consola.getText();
                    StyledDocument d = txt_Consola.getStyledDocument();

                    Style defaultStyle = txt_Consola.getStyle("default");
                    Style estiloNumero = txt_Consola.getStyle("numero");
                    Style estiloMinus = txt_Consola.getStyle("minus");
                    Style estiloMayus = txt_Consola.getStyle("mayus");
                    Style estiloSigno = txt_Consola.getStyle("signo");
                    Style estiloId = txt_Consola.getStyle("id");

                    d.setCharacterAttributes(0, texto.length(), defaultStyle, true);

                    java.util.regex.Matcher matcher = patron.matcher(texto);
                    
                    totNum = 0;
                    totMin = 0;
                    totMay = 0;
                    totSig = 0;
                    totId = 0;

                    while (matcher.find()) {

                        String token = matcher.group();
                        int inicio = matcher.start();
                        int longitud = token.length();

                        if (esNumero(token)) {
                            d.setCharacterAttributes(inicio, longitud, estiloNumero, false);
                            totNum++;
                        } else if (esMinusculas(token)) {
                            d.setCharacterAttributes(inicio, longitud, estiloMinus, false);
                            totMin++;
                        } else if (esMayusculas(token)) {
                            d.setCharacterAttributes(inicio, longitud, estiloMayus, false);
                            totMay++;
                        } else if (esSigno(token)) {
                            d.setCharacterAttributes(inicio, longitud, estiloSigno, false);
                            totSig++;
                        } else if (esIdentificador(token)) {
                            d.setCharacterAttributes(inicio, longitud, estiloId, false);
                            totId++;
                        }
                    }
                });
                
                txt_num.setText(String.valueOf(totNum++));
                txt_min.setText(String.valueOf(totMin++));
                txt_may.setText(String.valueOf(totMay++));
                txt_sig.setText(String.valueOf(totSig++));
                txt_id.setText(String.valueOf(totId++));
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                super.insertString(fb, offset, string, attr);
                aplicarColores();
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                super.replace(fb, offset, length, text, attrs);
                aplicarColores();
            }

            @Override
            public void remove(FilterBypass fb, int offset, int length)
                    throws BadLocationException {
                super.remove(fb, offset, length);
                aplicarColores();
            }
        });
    }

    private boolean esNumero(String s) {
        return s.matches("\\d+");
    }

    private boolean esMinusculas(String s) {
        return s.matches("[a-z]+");
    }

    private boolean esMayusculas(String s) {
        return s.matches("[A-Z]+");
    }

    private boolean esSigno(String s) {
        return s.matches("[+\\-*/=<>!%&|^(){}\\[\\]]");
    }

    private boolean esIdentificador(String s) {
        return s.matches("[a-zA-Z0-9_\\$+\\-*/=<>!%&|^]+");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new pck_graphics.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Consola = new javax.swing.JTextPane();
        panelRound7 = new pck_graphics.PanelRound();
        panelRound2 = new pck_graphics.PanelRound();
        panelRound3 = new pck_graphics.PanelRound();
        panelRound4 = new pck_graphics.PanelRound();
        panelRound5 = new pck_graphics.PanelRound();
        txt_id = new javax.swing.JLabel();
        panelRound6 = new pck_graphics.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_num = new javax.swing.JLabel();
        txt_min = new javax.swing.JLabel();
        txt_may = new javax.swing.JLabel();
        txt_sig = new javax.swing.JLabel();
        panelRound9 = new pck_graphics.PanelRound();
        panelRound10 = new pck_graphics.PanelRound();
        panelRound11 = new pck_graphics.PanelRound();
        panelRound8 = new pck_graphics.PanelRound();
        gradientButton2 = new pck_graphics.GradientButton();
        gradientButton1 = new pck_graphics.GradientButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setGradientColor1(new java.awt.Color(0, 0, 51));
        panelRound1.setGradientColor2(new java.awt.Color(0, 0, 51));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setViewportView(txt_Consola);

        panelRound1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 430, 450));

        panelRound7.setGradientColor1(new java.awt.Color(204, 255, 204));
        panelRound7.setGradientColor2(new java.awt.Color(204, 255, 204));
        panelRound7.setRoundBottomLeft(200);
        panelRound7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setGradientColor1(new java.awt.Color(102, 0, 102));
        panelRound2.setGradientColor2(new java.awt.Color(102, 0, 102));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound7.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 30, 30));

        panelRound3.setGradientColor1(new java.awt.Color(0, 204, 51));
        panelRound3.setGradientColor2(new java.awt.Color(0, 204, 51));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);
        panelRound7.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 30, 30));

        panelRound4.setGradientColor1(new java.awt.Color(255, 0, 153));
        panelRound4.setGradientColor2(new java.awt.Color(255, 0, 153));
        panelRound4.setRoundBottomLeft(30);
        panelRound4.setRoundBottomRight(30);
        panelRound4.setRoundTopLeft(30);
        panelRound4.setRoundTopRight(30);
        panelRound7.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 30, 30));

        panelRound5.setGradientColor1(new java.awt.Color(255, 0, 0));
        panelRound5.setGradientColor2(new java.awt.Color(255, 0, 0));
        panelRound5.setRoundBottomLeft(30);
        panelRound5.setRoundBottomRight(30);
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);
        panelRound7.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 30, 30));

        txt_id.setForeground(new java.awt.Color(0, 0, 0));
        txt_id.setText("0");
        panelRound7.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 40, 30));

        panelRound6.setGradientColor1(new java.awt.Color(0, 0, 153));
        panelRound6.setGradientColor2(new java.awt.Color(0, 0, 153));
        panelRound6.setRoundBottomLeft(30);
        panelRound6.setRoundBottomRight(30);
        panelRound6.setRoundTopLeft(30);
        panelRound6.setRoundTopRight(30);
        panelRound7.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 30, 30));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Minusculas");
        panelRound7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 100, 30));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Maysculas");
        panelRound7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, 30));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Signos");
        panelRound7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 100, 30));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Identificadores");
        panelRound7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 100, 30));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Números");
        panelRound7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 100, 30));

        txt_num.setForeground(new java.awt.Color(0, 0, 0));
        txt_num.setText("0");
        panelRound7.add(txt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 40, 30));

        txt_min.setForeground(new java.awt.Color(0, 0, 0));
        txt_min.setText("0");
        panelRound7.add(txt_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 40, 30));

        txt_may.setForeground(new java.awt.Color(0, 0, 0));
        txt_may.setText("0");
        panelRound7.add(txt_may, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 40, 30));

        txt_sig.setForeground(new java.awt.Color(0, 0, 0));
        txt_sig.setText("0");
        panelRound7.add(txt_sig, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 40, 30));

        panelRound1.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 300, 250));

        panelRound9.setGradientColor1(new java.awt.Color(204, 255, 204));
        panelRound9.setGradientColor2(new java.awt.Color(204, 255, 204));
        panelRound9.setGradientDirection(pck_graphics.PanelRound.GradientDirection.HORIZONTAL);
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound10.setGradientColor1(new java.awt.Color(0, 0, 51));
        panelRound10.setGradientColor2(new java.awt.Color(0, 0, 51));
        panelRound10.setGradientDirection(pck_graphics.PanelRound.GradientDirection.HORIZONTAL);
        panelRound10.setRoundTopRight(100);
        panelRound9.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 60));

        panelRound1.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 300, -1));

        panelRound11.setGradientColor1(new java.awt.Color(204, 255, 204));
        panelRound11.setGradientColor2(new java.awt.Color(204, 255, 204));
        panelRound11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound8.setGradientColor1(new java.awt.Color(0, 0, 51));
        panelRound8.setGradientColor2(new java.awt.Color(0, 0, 51));
        panelRound8.setRoundTopRight(150);
        panelRound8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound11.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 250));

        panelRound1.add(panelRound11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 100, 250));

        gradientButton2.setText("LIMPIAR");
        gradientButton2.setButtonIcon(new javax.swing.ImageIcon(getClass().getResource("/pck_icon/editar.png"))); // NOI18N
        gradientButton2.setColor1(new java.awt.Color(0, 0, 102));
        gradientButton2.setColor2(new java.awt.Color(102, 102, 255));
        gradientButton2.setCornerRadius(70);
        gradientButton2.setGlowColor(new java.awt.Color(204, 255, 204));
        gradientButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gradientButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gradientButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pck_icon/editar.png"))); // NOI18N
        gradientButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradientButton2ActionPerformed(evt);
            }
        });
        panelRound1.add(gradientButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 200, 70));

        gradientButton1.setText("CERRAR");
        gradientButton1.setButtonIcon(new javax.swing.ImageIcon(getClass().getResource("/pck_icon/cerca.png"))); // NOI18N
        gradientButton1.setColor1(new java.awt.Color(0, 0, 102));
        gradientButton1.setColor2(new java.awt.Color(102, 102, 255));
        gradientButton1.setCornerRadius(70);
        gradientButton1.setGlowColor(new java.awt.Color(204, 255, 204));
        gradientButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradientButton1ActionPerformed(evt);
            }
        });
        panelRound1.add(gradientButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 200, 70));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gradientButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradientButton2ActionPerformed
        txt_Consola.setText("");
        txt_Consola.setForeground(Color.black);
        txt_num.setText("0");
        txt_min.setText("0");
        txt_may.setText("0");
        txt_sig.setText("0");
        txt_id.setText("0");
    }//GEN-LAST:event_gradientButton2ActionPerformed

    private void gradientButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradientButton1ActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "Exit", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_gradientButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pck_graphics.GradientButton gradientButton1;
    private pck_graphics.GradientButton gradientButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private pck_graphics.PanelRound panelRound1;
    private pck_graphics.PanelRound panelRound10;
    private pck_graphics.PanelRound panelRound11;
    private pck_graphics.PanelRound panelRound2;
    private pck_graphics.PanelRound panelRound3;
    private pck_graphics.PanelRound panelRound4;
    private pck_graphics.PanelRound panelRound5;
    private pck_graphics.PanelRound panelRound6;
    private pck_graphics.PanelRound panelRound7;
    private pck_graphics.PanelRound panelRound8;
    private pck_graphics.PanelRound panelRound9;
    private javax.swing.JTextPane txt_Consola;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_may;
    private javax.swing.JLabel txt_min;
    private javax.swing.JLabel txt_num;
    private javax.swing.JLabel txt_sig;
    // End of variables declaration//GEN-END:variables
}
