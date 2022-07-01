package pl.sperka.ae2.plugin.corefunctionality.circuits;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class OpAmps extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( LM3xx.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.circuits.Strings" );
    private javax.swing.JLabel jlR2no;
    private javax.swing.JLabel jlR2od;
    private javax.swing.JPanel jpPict1;
    private javax.swing.JPanel jpPict2;
    private javax.swing.JTextField jtR1no;
    private javax.swing.JTextField jtR1od;
    private javax.swing.JTextField jtWzno;
    private javax.swing.JTextField jtWzod;

    public OpAmps( ICore core ) {
        initComponents();
        URL imgURL1 = getClass().getClassLoader().getResource( "pl/sperka/ae2/plugin/images/oanieodwr.jpg" );
        ImageIcon icon1 = new ImageIcon( imgURL1 );
        JLabel label1 = new JLabel( icon1 );
        label1.setSize( 200, 141 );
        jpPict1.add( label1 );
        label1.repaint();

        URL imgURL2 = getClass().getClassLoader().getResource( "pl/sperka/ae2/plugin/images/oaodwr.jpg" );
        ImageIcon icon2 = new ImageIcon( imgURL2 );
        JLabel label2 = new JLabel( icon2 );
        label2.setSize( 200, 149 );
        jpPict2.add( label2 );
        label2.repaint();

        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void CalculateNonInverting() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( !jtR1no.getText().isEmpty() && !jtWzno.getText().isEmpty() ) {
                double R1 = nf.parse( jtR1no.getText() ).doubleValue();
                double Wz = nf.parse( jtWzno.getText() ).doubleValue();
                double R2 = R1 * ( Wz - 1 );
                jlR2no.setText( "R2 = " + nf.format( R2 ) + " Ohm" );
            }
        } catch ( Exception ignored ) {
        }
    }

    private void CalculateInverting() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( !jtR1od.getText().isEmpty() && !jtWzod.getText().isEmpty() ) {
                double R1 = nf.parse( jtR1od.getText() ).doubleValue();
                double Wz = nf.parse( jtWzod.getText() ).doubleValue();
                double R2 = -1 * Wz * R1;
                jlR2od.setText( "R2 = " + nf.format( R2 ) + " Ohm" );
            }
        } catch ( Exception ignored ) {
        }
    }

    private void initComponents() {

        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel2 = new JPanel();
        jpPict2 = new javax.swing.JPanel();
        JLabel jLabel4 = new JLabel();
        jtR1od = new javax.swing.JTextField();
        jtWzod = new javax.swing.JTextField();
        JLabel jLabel5 = new JLabel();
        jlR2od = new javax.swing.JLabel();
        JPanel jPanel1 = new JPanel();
        jpPict1 = new javax.swing.JPanel();
        JLabel jLabel1 = new JLabel();
        jtR1no = new javax.swing.JTextField();
        JLabel jLabel2 = new JLabel();
        jtWzno = new javax.swing.JTextField();
        jlR2no = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "op-amps.title" ) );
        setResizable( false );


        javax.swing.GroupLayout jpPict2Layout = new javax.swing.GroupLayout( jpPict2 );
        jpPict2.setLayout( jpPict2Layout );
        jpPict2Layout.setHorizontalGroup( jpPict2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 201, Short.MAX_VALUE ) );
        jpPict2Layout.setVerticalGroup( jpPict2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 175, Short.MAX_VALUE ) );

        jLabel4.setText( "R1" );

        jtR1od.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtR1odKeyReleased( evt );
            }
        } );

        jtWzod.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtWzodKeyReleased( evt );
            }
        } );

        jLabel5.setText( strings.getString( "op-amps.amplification" ) );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jpPict2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jLabel4 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtR1od ) ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jLabel5 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtWzod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( jlR2od ) ).addGap( 0, 178, Short.MAX_VALUE ) ) );
        jPanel2Layout.setVerticalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jpPict2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtR1od, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtWzod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlR2od, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addGap( 0, 25, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "op-amps.inverting-amp" ), jPanel2 );

        javax.swing.GroupLayout jpPict1Layout = new javax.swing.GroupLayout( jpPict1 );
        jpPict1.setLayout( jpPict1Layout );
        jpPict1Layout.setHorizontalGroup( jpPict1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 201, Short.MAX_VALUE ) );
        jpPict1Layout.setVerticalGroup( jpPict1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 175, Short.MAX_VALUE ) );

        jLabel1.setText( "R1" );

        jtR1no.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtR1noKeyReleased( evt );
            }
        } );

        jLabel2.setText( strings.getString( "op-amps.amplification" ) );

        jtWzno.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtWznoKeyReleased( evt );
            }
        } );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jpPict1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jLabel1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtR1no ) ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jLabel2 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtWzno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( jlR2no ) ).addGap( 0, 178, Short.MAX_VALUE ) ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jpPict1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtR1no, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel1 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtWzno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlR2no, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addGap( 0, 25, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "op-amps.non-inverting-amp" ), jPanel1 );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jTabbedPane1 ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jTabbedPane1 ) );

        pack();
    }

    private void jtR1noKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateNonInverting();
    }

    private void jtWznoKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateNonInverting();
    }

    private void jtR1odKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateInverting();
    }

    private void jtWzodKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateInverting();
    }
}
