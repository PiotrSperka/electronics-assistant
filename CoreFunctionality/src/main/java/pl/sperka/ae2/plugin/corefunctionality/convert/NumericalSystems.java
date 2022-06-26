package pl.sperka.ae2.plugin.corefunctionality.convert;

/*
 * Created on 2011-12-15, 17:06:32
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class NumericalSystems extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( NumericalSystems.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.convert.Strings" );
    private javax.swing.JTextField txtBin;
    private javax.swing.JTextField txtDec;
    private javax.swing.JTextField txtHex;
    private javax.swing.JTextField txtOct;

    public NumericalSystems( Component parent ) {
        initComponents();
        setLocationRelativeTo( parent );
    }

    private void initComponents() {
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        txtBin = new javax.swing.JTextField();
        txtOct = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        txtDec = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        txtHex = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "numerical-systems.title" ) );
        setResizable( false );

        jLabel1.setText( "BIN:" );

        txtBin.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtBinKeyReleased( evt );
            }
        } );

        txtOct.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtOctKeyReleased( evt );
            }
        } );

        jLabel2.setText( "OCT:" );

        txtDec.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtDecKeyReleased( evt );
            }
        } );

        jLabel3.setText( "DEC:" );

        txtHex.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtHexKeyReleased( evt );
            }
        } );

        jLabel4.setText( "HEX:" );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addGroup( layout.createSequentialGroup().addComponent( jLabel4 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtHex ) ).addGroup( layout.createSequentialGroup().addComponent( jLabel1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtBin ) ).addGroup( layout.createSequentialGroup().addComponent( jLabel2 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtOct, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE ) ).addGroup( layout.createSequentialGroup().addComponent( jLabel3 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtDec ) ) ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtBin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtOct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtDec, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtHex, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private void txtDecKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtDec.getCaretPosition();
        Convert( Long.parseLong( txtDec.getText() ) );
        txtDec.setCaretPosition( pos );
    }

    private void txtBinKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtBin.getCaretPosition();
        Convert( Long.parseLong( txtBin.getText(), 2 ) );
        txtBin.setCaretPosition( pos );
    }

    private void txtOctKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtOct.getCaretPosition();
        Convert( Long.parseLong( txtOct.getText(), 8 ) );
        txtOct.setCaretPosition( pos );
    }

    private void txtHexKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtHex.getCaretPosition();
        Convert( Long.parseLong( txtHex.getText(), 16 ) );
        txtHex.setCaretPosition( pos );
    }

    private void Convert( long value ) {
        txtBin.setText( Long.toBinaryString( value ) );
        txtOct.setText( Long.toOctalString( value ) );
        txtDec.setText( Long.toString( value ) );
        txtHex.setText( Long.toHexString( value ) );
    }
}
