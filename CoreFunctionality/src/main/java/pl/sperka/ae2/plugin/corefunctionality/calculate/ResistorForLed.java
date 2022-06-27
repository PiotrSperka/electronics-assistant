package pl.sperka.ae2.plugin.corefunctionality.calculate;

/*
 * Created on 2011-03-20, 13:41:53
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class ResistorForLed extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( ResistorForLed.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.calculate.Strings" );
    private static final DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols( Locale.getDefault() );

    private javax.swing.JLabel lblRez;
    private javax.swing.JTextField txtIled;
    private javax.swing.JTextField txtUled;
    private javax.swing.JTextField txtUzas;

    public ResistorForLed( ICore core ) {
        initComponents();
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        txtUzas = new javax.swing.JTextField();
        txtUled = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        txtIled = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        lblRez = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jlRed = new javax.swing.JLabel();
        javax.swing.JLabel jlGreen = new javax.swing.JLabel();
        javax.swing.JLabel jlBlue = new javax.swing.JLabel();
        javax.swing.JLabel jlWhite = new javax.swing.JLabel();
        javax.swing.JLabel jlYellow = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "resistor-for-led.title" ) );
        setResizable( false );

        jLabel1.setText( strings.getString( "resistor-for-led.input-voltage" ) );

        txtUzas.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                Calculate();
            }
        } );

        txtUled.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                Calculate();
            }
        } );

        jLabel2.setText( strings.getString( "resistor-for-led.led-voltage" ) );

        txtIled.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                Calculate();
            }
        } );

        jLabel3.setText( strings.getString( "resistor-for-led.led-current" ) );

        jPanel1.setBorder( javax.swing.BorderFactory.createTitledBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "resistor-for-led.led-voltage-list" ) ) ) );

        jlRed.setForeground( new java.awt.Color( 255, 0, 0 ) );
        jlRed.setText( strings.getString( "resistor-for-led.led-voltage-red" ) );
        jlRed.setCursor( new java.awt.Cursor( java.awt.Cursor.HAND_CURSOR ) );
        jlRed.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseReleased( java.awt.event.MouseEvent evt ) {
                txtUled.setText( "1" + decimalFormatSymbols.getDecimalSeparator() + "8" );
                Calculate();
            }
        } );

        jlGreen.setForeground( new java.awt.Color( 0, 204, 0 ) );
        jlGreen.setText( strings.getString( "resistor-for-led.led-voltage-green" ) );
        jlGreen.setCursor( new java.awt.Cursor( java.awt.Cursor.HAND_CURSOR ) );
        jlGreen.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseReleased( java.awt.event.MouseEvent evt ) {
                txtUled.setText( "2" + decimalFormatSymbols.getDecimalSeparator() + "0" );
                Calculate();
            }
        } );

        jlBlue.setForeground( new java.awt.Color( 0, 0, 255 ) );
        jlBlue.setText( strings.getString( "resistor-for-led.led-voltage-blue" ) );
        jlBlue.setCursor( new java.awt.Cursor( java.awt.Cursor.HAND_CURSOR ) );
        jlBlue.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseReleased( java.awt.event.MouseEvent evt ) {
                txtUled.setText( "3" + decimalFormatSymbols.getDecimalSeparator() + "5" );
                Calculate();
            }
        } );

        jlWhite.setText( strings.getString( "resistor-for-led.led-voltage-white" ) );
        jlWhite.setCursor( new java.awt.Cursor( java.awt.Cursor.HAND_CURSOR ) );
        jlWhite.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseReleased( java.awt.event.MouseEvent evt ) {
                txtUled.setText( "3" + decimalFormatSymbols.getDecimalSeparator() + "6" );
                Calculate();
            }
        } );

        jlYellow.setForeground( new java.awt.Color( 204, 204, 0 ) );
        jlYellow.setText( strings.getString( "resistor-for-led.led-voltage-yellow" ) );
        jlYellow.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseReleased( java.awt.event.MouseEvent evt ) {
                txtUled.setText( "1" + decimalFormatSymbols.getDecimalSeparator() + "8" );
                Calculate();
            }
        } );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addGap( 0, 0, Short.MAX_VALUE ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jlWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jlBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jlGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jlRed, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap() ) ) ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jlYellow ).addGap( 0, 0, Short.MAX_VALUE ) ) ) ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jlRed ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlYellow ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlGreen ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlBlue ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlWhite ).addContainerGap( 43, Short.MAX_VALUE ) ) );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addGap( 18, 18, 18 ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( txtIled, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE ).addComponent( txtUled, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE ).addComponent( txtUzas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE ) ) ).addComponent( lblRez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addGap( 12, 12, 12 ).addComponent( jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( layout.createSequentialGroup().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtUzas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtUled, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtIled, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblRez ).addGap( 0, 0, Short.MAX_VALUE ) ) ).addContainerGap() ) );

        pack();
    }

    private void Calculate() {
        if ( ( !txtUled.getText().equals( "" ) ) && ( !txtIled.getText().equals( "" ) ) && ( !txtUzas.getText().equals( "" ) ) ) {
            float Uled = 0, Iled = 0, Uzas = 0, R = 0, Prez = 0;
            java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
            try {
                Uled = nf.parse( txtUled.getText() ).floatValue();
                Iled = ( nf.parse( txtIled.getText() ).floatValue() ) / 1000;
                Uzas = nf.parse( txtUzas.getText() ).floatValue();
            } catch ( Exception ignored ) {
            }

            R = ( Uzas - Uled ) / Iled;
            Prez = R * Iled * Iled * 100;
            Prez = Math.round( Prez );
            R = Math.round( R * 10 );

            if ( R < 0 ) {
                lblRez.setText( "Uzas < Uled !" );
            } else if ( R < 10000 ) {
                lblRez.setText( strings.getString( "resistor-for-led.resistor" ) + nf.format( R / 10 ) + " Ohm/" + nf.format( Prez / 100 ) + " W" );
            } else if ( R < 10000000 ) {
                lblRez.setText( strings.getString( "resistor-for-led.resistor" ) + nf.format( R / 10000 ) + " kOhm/" + nf.format( Prez / 100 ) + " W" );
            } else {
                lblRez.setText( strings.getString( "resistor-for-led.resistor" ) + nf.format( R / 10000000 ) + " MOhm/" + nf.format( Prez / 100 ) + " W" );
            }
        }
    }
}
