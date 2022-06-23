package pl.sperka.ae2.plugin.oldclasses.microcontrollers;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piotrek
 */

import java.awt.*;
import java.util.ArrayList;

public class _7SegGen extends javax.swing.JFrame {

    /**
     * Creates new form _7SegGen
     */
    ArrayList znaki = new ArrayList();
    
    private final static int OFF = 0;
    private final static int ON = 1;
   
    private final static int numbers[][] = {{ ON, ON, ON, ON, ON, ON, OFF },{ OFF, ON, ON, OFF, OFF, OFF, OFF },
    { ON, ON, OFF, ON, ON, OFF, ON },{ ON, ON, ON, ON, OFF, OFF, ON },{ OFF, ON, ON, OFF, OFF, ON, ON },
    { ON, OFF, ON, ON, OFF, ON, ON },{ ON, OFF, ON, ON, ON, ON, ON },{ ON, ON, ON, OFF, OFF, OFF, OFF },
    { ON, ON, ON, ON, ON, ON, ON },{ ON, ON, ON, ON, OFF, ON, ON }};
    
    public _7SegGen( Component parent ) {
        initComponents();
        jlInfo.setText("<HTML>Kliknij na segment, aby<br>zmienić jego stan.</HTML>");
        setLocationRelativeTo( parent );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ssd1 = new SevenSegmentDisplay();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlInfo = new javax.swing.JLabel();
        jbCustomAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jcbA = new javax.swing.JComboBox();
        jcbE = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jcbB = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jcbF = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jcbC = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jcbG = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jcbD = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jbNumbers = new javax.swing.JButton();
        jbClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaTable = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jrb1 = new javax.swing.JRadioButton();
        jrb0 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generator znaków dla wyświetlacza 7-segmentowego");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nietypowy znak"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("a");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("g");

        javax.swing.GroupLayout ssd1Layout = new javax.swing.GroupLayout(ssd1);
        ssd1.setLayout(ssd1Layout);
        ssd1Layout.setHorizontalGroup(
            ssd1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssd1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel7)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        ssd1Layout.setVerticalGroup(
            ssd1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ssd1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel7)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("b");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("c");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("d");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("e");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("f");

        jlInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlInfo.setText("Kliknij na segment");

        jbCustomAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCustomAdd.setText("Dodaj znak");
        jbCustomAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCustomAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCustomAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlInfo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ssd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ssd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel6)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5)
                        .addGap(50, 50, 50)))
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCustomAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Podłączenie wyświetlacza do portu"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("a");

        jcbA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" }));
        jcbA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAActionPerformed(evt);
            }
        });

        jcbE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" }));
        jcbE.setSelectedIndex(4);
        jcbE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("e");

        jcbB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" }));
        jcbB.setSelectedIndex(1);
        jcbB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("b");

        jcbF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" }));
        jcbF.setSelectedIndex(5);
        jcbF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("f");

        jcbC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" }));
        jcbC.setSelectedIndex(2);
        jcbC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("c");

        jcbG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbG.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" }));
        jcbG.setSelectedIndex(6);
        jcbG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("g");

        jcbD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" }));
        jcbD.setSelectedIndex(3);
        jcbD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("d");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbNumbers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbNumbers.setText("Dodaj cyfry 0-9");
        jbNumbers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNumbersActionPerformed(evt);
            }
        });

        jbClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbClear.setText("Wyczyść tablicę");
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });

        jtaTable.setEditable(false);
        jtaTable.setColumns(20);
        jtaTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jtaTable.setLineWrap(true);
        jtaTable.setRows(5);
        jtaTable.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtaTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Segment jest załączony dla logicznego:"));

        buttonGroup1.add(jrb1);
        jrb1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrb1.setSelected(true);
        jrb1.setText("\"1\"");
        jrb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb0);
        jrb0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrb0.setText("\"0\"");
        jrb0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrb1)
                .addGap(18, 18, 18)
                .addComponent(jrb0)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jrb1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jrb0, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNumbers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbClear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkPins(){
        boolean t=true;
        int conns[] = getConnections();
        for(int i=0;i<6;i++)
        {
            for(int j=i+1;j<7;j++)
            {
                if(conns[i]==conns[j]) {t=false; break;}
            }
            if(t==false) break;
        }
        return t;
    }
    
    private void parseTable()
    {
        if(checkPins())
        {
        jtaTable.setText(null);
        jtaTable.append("const unsigned char _7Seg[] = {");
        int conns[] = getConnections();
        for(int i=0;i<znaki.size();i++)
        {
            int temp=0;
            int ch=Integer.parseInt(znaki.get(i).toString());
            for(int j=0;j<7;j++)
            {
                if(jrb1.isSelected())temp+=(((ch&(1<<j))>>j)<<(conns[j]));
                else temp+=((((ch&(1<<j))>>j)^1)<<(conns[j]));
            }
            jtaTable.append("0x"+Integer.toHexString(0x100|temp).substring(1));
            if(i<znaki.size()-1) jtaTable.append(", ");
        }
        jtaTable.append("};");
        }
        else {
            jtaTable.setText("Piny zostały błędnie przypisane.");
        }
    }
    
    private int[] getConnections()
    {
        int tab[] = new int[7];
        tab[0]=jcbA.getSelectedIndex();
        tab[1]=jcbB.getSelectedIndex();
        tab[2]=jcbC.getSelectedIndex();
        tab[3]=jcbD.getSelectedIndex();
        tab[4]=jcbE.getSelectedIndex();
        tab[5]=jcbF.getSelectedIndex();
        tab[6]=jcbG.getSelectedIndex();
        return tab;
    }
    
    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        jtaTable.setText(null);
        znaki.clear();
    }//GEN-LAST:event_jbClearActionPerformed

    private void jbNumbersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNumbersActionPerformed
        for (int i=0;i<10;i++)
        {
            int temp=0;
            for(int j=0;j<7;j++)
            {
                temp+=((numbers[i][j])<<j);
            }
            znaki.add(temp);
        }
        parseTable();
    }//GEN-LAST:event_jbNumbersActionPerformed

    private void jbCustomAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCustomAddActionPerformed
        int ch[] = ssd1.getSegments();
        int temp=0;
        for(int i=0;i<7;i++)
        {
            temp+=((ch[i])<<i);
        }
        znaki.add(temp);
        parseTable();
    }//GEN-LAST:event_jbCustomAddActionPerformed

    private void jrb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb1ActionPerformed
        parseTable();
    }//GEN-LAST:event_jrb1ActionPerformed

    private void jrb0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb0ActionPerformed
        parseTable();
    }//GEN-LAST:event_jrb0ActionPerformed

    private void jcbAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAActionPerformed
        parseTable();
    }//GEN-LAST:event_jcbAActionPerformed

    private void jcbBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBActionPerformed
        parseTable();
    }//GEN-LAST:event_jcbBActionPerformed

    private void jcbCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCActionPerformed
        parseTable();
    }//GEN-LAST:event_jcbCActionPerformed

    private void jcbDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDActionPerformed
        parseTable();
    }//GEN-LAST:event_jcbDActionPerformed

    private void jcbEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEActionPerformed
        parseTable();
    }//GEN-LAST:event_jcbEActionPerformed

    private void jcbFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFActionPerformed
        parseTable();
    }//GEN-LAST:event_jcbFActionPerformed

    private void jcbGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGActionPerformed
        parseTable();
    }//GEN-LAST:event_jcbGActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbCustomAdd;
    private javax.swing.JButton jbNumbers;
    private javax.swing.JComboBox jcbA;
    private javax.swing.JComboBox jcbB;
    private javax.swing.JComboBox jcbC;
    private javax.swing.JComboBox jcbD;
    private javax.swing.JComboBox jcbE;
    private javax.swing.JComboBox jcbF;
    private javax.swing.JComboBox jcbG;
    private javax.swing.JLabel jlInfo;
    private javax.swing.JRadioButton jrb0;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JTextArea jtaTable;
    private SevenSegmentDisplay ssd1;
    // End of variables declaration//GEN-END:variables
}