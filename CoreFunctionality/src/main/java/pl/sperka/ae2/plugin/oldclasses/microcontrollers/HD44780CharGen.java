package pl.sperka.ae2.plugin.oldclasses.microcontrollers;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

/**
 *
 * @author Piotrek
 */
public class HD44780CharGen extends javax.swing.JFrame {

    /**
     * Creates new form HD44780CharGen
     */
    public HD44780CharGen( Component parent ) {
        initComponents();
        LcdCell.setPreview(LcdPreview);
        jlInfo.setText("<HTML>Kliknij na piksel, aby<br>zmienić jego stan.</HTML>");
        setLocationRelativeTo( parent );
    }
    
    private void showData()
    {
        int[] tmp = LcdCell.getData();
        String s = "";
        for(int i = 0; i< tmp.length; i++)
        {
            s += "0x"+Integer.toHexString(0x100|(int)tmp[i]).substring(1);
            if(i != tmp.length-1) s += ",\n";
        }
        jtaResult.setText(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LcdCell = new HD44780CharCell();
        LcdPreview = new HD44780SmallCharCell();
        jbClear = new javax.swing.JButton();
        jbSet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaResult = new javax.swing.JTextArea();
        jlInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generator niestandardowych znaków dla HD44780");
        setResizable(false);

        LcdCell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LcdCellMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout LcdCellLayout = new javax.swing.GroupLayout(LcdCell);
        LcdCell.setLayout(LcdCellLayout);
        LcdCellLayout.setHorizontalGroup(
            LcdCellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );
        LcdCellLayout.setVerticalGroup(
            LcdCellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LcdPreviewLayout = new javax.swing.GroupLayout(LcdPreview);
        LcdPreview.setLayout(LcdPreviewLayout);
        LcdPreviewLayout.setHorizontalGroup(
            LcdPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        LcdPreviewLayout.setVerticalGroup(
            LcdPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jbClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbClear.setText("Wyczyść");
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });

        jbSet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbSet.setText("Ustaw");
        jbSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSetActionPerformed(evt);
            }
        });

        jtaResult.setEditable(false);
        jtaResult.setColumns(20);
        jtaResult.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jtaResult.setRows(5);
        jScrollPane1.setViewportView(jtaResult);

        jlInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlInfo.setText("Kliknij, ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LcdCell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LcdPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(LcdPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LcdCell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LcdCellMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LcdCellMouseReleased
        showData();
    }//GEN-LAST:event_LcdCellMouseReleased

    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        LcdCell.clear();
        showData();
    }//GEN-LAST:event_jbClearActionPerformed

    private void jbSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSetActionPerformed
        LcdCell.set();
        showData();
    }//GEN-LAST:event_jbSetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private HD44780CharCell LcdCell;
    private HD44780SmallCharCell LcdPreview;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbSet;
    private javax.swing.JLabel jlInfo;
    private javax.swing.JTextArea jtaResult;
    // End of variables declaration//GEN-END:variables
}
