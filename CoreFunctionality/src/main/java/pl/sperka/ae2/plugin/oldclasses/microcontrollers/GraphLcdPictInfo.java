package pl.sperka.ae2.plugin.oldclasses.microcontrollers;

import javax.swing.JDialog;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piotrek
 */
public class GraphLcdPictInfo extends JDialog {

    /**
     * Creates new form GraphLcdPictInfo
     */
    public GraphLcdPictInfo(JFrame parent) {
        super(parent, "Informacje", true);
        initComponents();
        setLocationRelativeTo(parent);
        jlInfo.setText("<HTML>Plik binarny (*.BIN) posiada 5-bajtowy nagłówek. "
                + "Dwa pierwsze bajty określają szerokość, dwa kolejne "
                + "wysokość obrazu. Piąty bajt określa typ danych, które "
                + "następują po nim.<br><br>"
                + "Możliwe wartości piątego bajtu:<br>"
                + "0x01 - Obraz czarno-biały<br>"
                + "0x11 - Obraz kolorowy RGB888<br>"
                + "0x12 - Obraz kolorowy RGB565</HTML>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jlInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlInfo.setText("jLabel1");
        jlInfo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlInfo;
    // End of variables declaration//GEN-END:variables
}