package pl.sperka.ae2.plugin.corefunctionality.convert;

/*
 * Created on 2011-06-02, 14:26:22
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class Mil extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( Mil.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.convert.Strings" );
    private javax.swing.JLabel lblWynik;
    private javax.swing.JTextField txtMIL;

    public Mil( Component parent ) {
        initComponents();
        setLocationRelativeTo( parent );
    }

    private void initComponents() {
        txtMIL = new javax.swing.JTextField();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        lblWynik = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "mil.title" ) );
        setResizable( false );

        txtMIL.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMILKeyReleased( evt );
            }
        } );

        jLabel1.setText( strings.getString( "mil.mil-code" ) );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addComponent( jLabel1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtMIL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( lblWynik ) ).addContainerGap( 91, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtMIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblWynik ).addContainerGap( 68, Short.MAX_VALUE ) ) );

        pack();
    }

    private void txtMILKeyReleased( java.awt.event.KeyEvent evt ) {
        if ( txtMIL.getText().length() == 3 ) Calculate();
    }

    private void Calculate() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            float wynik = 0;
            String wynik_str;
            wynik = nf.parse( txtMIL.getText().substring( 0, 2 ) ).floatValue() * Double.valueOf( Math.pow( 10, nf.parse( txtMIL.getText().substring( 2, 3 ) ).intValue() ) ).floatValue();
            if ( wynik < 1000 ) {
                wynik_str = nf.format( wynik );
                lblWynik.setText( "<html>" + strings.getString( "mil.resistor" ) + wynik_str + " Ohm<br>" + strings.getString( "mil.capacitor" ) + wynik_str + " pF<br>" + strings.getString( "mil.coil" ) + wynik_str + " uH</html>" );
            } else if ( wynik >= 1000 && wynik < 1000000 ) {
                wynik_str = nf.format( wynik / 1000 );
                lblWynik.setText( "<html>" + strings.getString( "mil.resistor" ) + wynik_str + " kOhm<br>" + strings.getString( "mil.capacitor" ) + wynik_str + " nF<br>" + strings.getString( "mil.coil" ) + wynik_str + " mH</html>" );
            } else if ( wynik >= 1000000 ) {
                wynik_str = nf.format( wynik / 1000000 );
                lblWynik.setText( "<html>" + strings.getString( "mil.resistor" ) + wynik_str + " MOhm<br>" + strings.getString( "mil.capacitor" ) + wynik_str + " uF<br>" + strings.getString( "mil.coil" ) + wynik_str + " H</html>" );
            }
        } catch ( Exception ignored ) {
        }
    }
}
