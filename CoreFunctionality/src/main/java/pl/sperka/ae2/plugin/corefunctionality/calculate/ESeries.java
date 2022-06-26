package pl.sperka.ae2.plugin.corefunctionality.calculate;

/*
 * Created on 2011-12-16, 21:14:57
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class ESeries extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( ESeries.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.calculate.Strings" );
    private javax.swing.JLabel lblE12;
    private javax.swing.JLabel lblE192;
    private javax.swing.JLabel lblE24;
    private javax.swing.JLabel lblE3;
    private javax.swing.JLabel lblE48;
    private javax.swing.JLabel lblE6;
    private javax.swing.JLabel lblE96;
    private javax.swing.JTextField txtLiczba;

    public ESeries( Component parent ) {
        initComponents();
        setLocationRelativeTo( parent );
    }

    private void initComponents() {

        txtLiczba = new javax.swing.JTextField();
        lblE3 = new javax.swing.JLabel();
        lblE6 = new javax.swing.JLabel();
        lblE12 = new javax.swing.JLabel();
        lblE24 = new javax.swing.JLabel();
        lblE48 = new javax.swing.JLabel();
        lblE96 = new javax.swing.JLabel();
        lblE192 = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "e-series.title" ) );
        setResizable( false );

        txtLiczba.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
                try {
                    Find( nf.parse( txtLiczba.getText() ).doubleValue() );
                } catch ( Exception ignored ) {
                }
            }
        } );

        lblE3.setText( "E3:" );
        lblE6.setText( "E6:" );
        lblE12.setText( "E12:" );
        lblE24.setText( "E24:" );
        lblE48.setText( "E48:" );
        lblE96.setText( "E96:" );
        lblE192.setText( "E192:" );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( txtLiczba, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( lblE3 ).addComponent( lblE6 ).addComponent( lblE12 ).addComponent( lblE24 ).addComponent( lblE48 ).addComponent( lblE96 ).addComponent( lblE192 ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( txtLiczba, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( lblE3 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblE6 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblE12 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblE24 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblE48 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblE96 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblE192 ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    void Find( double value ) {
        final double[] e3 = { 1, 2.2, 4.7, 10 };
        final double[] e6 = { 1, 1.5, 2.2, 3.3, 4.7, 6.8, 10 };
        final double[] e12 = { 1, 1.2, 1.5, 1.8, 2.2, 2.7, 3.3, 3.9, 4.7, 5.6, 6.8, 8.2, 10 };
        final double[] e24 = { 1, 1.1, 1.2, 1.3, 1.5, 1.6, 1.8, 2, 2.2, 2.4, 2.7, 3, 3.3, 3.6, 3.9, 4.3, 4.7, 5.1, 5.6, 6.2, 6.8, 7.5, 8.2, 9.1, 10 };
        final double[] e48 = { 1.00, 1.05, 1.10, 1.15, 1.21, 1.27, 1.33, 1.40, 1.47, 1.54, 1.62, 1.69, 1.78, 1.87, 1.96, 2.05, 2.15, 2.26, 2.37, 2.49, 2.61, 2.74, 2.87, 3.01, 3.16, 3.32, 3.48, 3.65, 3.83, 4.02, 4.22, 4.42, 4.64, 4.87, 5.11, 5.36, 5.62, 5.90, 6.19, 6.49, 6.81, 7.15, 7.50, 7.87, 8.25, 8.66, 9.09, 9.53, 10 };
        final double[] e96 = { 1.00, 1.02, 1.05, 1.07, 1.10, 1.13, 1.15, 1.18, 1.21, 1.24, 1.27, 1.30, 1.33, 1.37, 1.40, 1.43, 1.47, 1.50, 1.54, 1.58, 1.62, 1.65, 1.69, 1.74, 1.78, 1.82, 1.87, 1.91, 1.96, 2.00, 2.05, 2.10, 2.15, 2.21, 2.26, 2.32, 2.37, 2.43, 2.49, 2.55, 2.61, 2.67, 2.74, 2.80, 2.87, 2.94, 3.01, 3.09, 3.16, 3.24, 3.32, 3.40, 3.48, 3.57, 3.65, 3.74, 3.83, 3.92, 4.02, 4.12, 4.22, 4.32, 4.42, 4.53, 4.64, 4.75, 4.87, 4.99, 5.11, 5.23, 5.36, 5.49, 5.62, 5.76, 5.90, 6.04, 6.19, 6.34, 6.49, 6.65, 6.81, 6.90, 7.15, 7.32, 7.50, 7.68, 7.87, 8.06, 8.25, 8.45, 8.66, 8.87, 9.09, 9.31, 9.53, 9.76, 10 };
        final double[] e192 = { 1.00, 1.01, 1.02, 1.04, 1.05, 1.06, 1.07, 1.09, 1.10, 1.11, 1.13, 1.14, 1.15, 1.17, 1.18, 1.20, 1.21, 1.23, 1.24, 1.26, 1.27, 1.29, 1.30, 1.32, 1.33, 1.35, 1.37, 1.38, 1.40, 1.42, 1.43, 1.45, 1.47, 1.49, 1.50, 1.52, 1.54, 1.56, 1.58, 1.60, 1.62, 1.64, 1.65, 1.67, 1.69, 1.72, 1.74, 1.76, 1.78, 1.80, 1.82, 1.84, 1.87, 1.89, 1.91, 1.93, 1.96, 1.98, 2.00, 2.03, 2.05, 2.08, 2.10, 2.13, 2.15, 2.18, 2.21, 2.23, 2.26, 2.29, 2.32, 2.34, 2.37, 2.40, 2.43, 2.46, 2.49, 2.52, 2.55, 2.58, 2.61, 2.64, 2.67, 2.71, 2.74, 2.77, 2.80, 2.84, 2.87, 2.91, 2.94, 2.98, 3.01, 3.05, 3.09, 3.12, 3.16, 3.20, 3.24, 3.28, 3.32, 3.36, 3.40, 3.44, 3.48, 3.52, 3.57, 3.61, 3.65, 3.70, 3.74, 3.79, 3.83, 3.88, 3.92, 3.97, 4.02, 4.07, 4.12, 4.17, 4.22, 4.27, 4.32, 4.37, 4.42, 4.48, 4.53, 4.59, 4.64, 4.70, 4.75, 4.81, 4.87, 4.93, 4.99, 5.05, 5.11, 5.17, 5.23, 5.30, 5.36, 5.42, 5.49, 5.56, 5.62, 5.69, 5.76, 5.83, 5.90, 5.97, 6.04, 6.12, 6.19, 6.26, 6.34, 6.42, 6.49, 6.57, 6.65, 6.73, 6.81, 6.90, 6.98, 7.06, 7.15, 7.23, 7.32, 7.41, 7.50, 7.59, 7.68, 7.77, 7.87, 7.96, 8.06, 8.16, 8.25, 8.35, 8.45, 8.56, 8.66, 8.76, 8.87, 8.98, 9.09, 9.19, 9.31, 9.42, 9.53, 9.65, 9.76, 9.88, 10 };
        double multiplier = 1;

        DecimalFormat df = new DecimalFormat( "###.###" );

        if ( value > 0 ) {
            if ( value > 10 ) while ( value > 10 ) {
                value /= 10;
                multiplier *= 10;
            }

            if ( value < 1 ) while ( value < 1 ) {
                value *= 10;
                multiplier /= 10;
            }

            for ( int i = 0; i < e3.length - 1; i++ ) //E3
            {
                if ( value >= e3[i] && value <= e3[i + 1] ) {
                    if ( Math.abs( value - e3[i] ) < Math.abs( value - e3[i + 1] ) )
                        lblE3.setText( "E3: " + df.format( e3[i] * multiplier ) );
                    else lblE3.setText( "E3: " + df.format( e3[i + 1] * multiplier ) );
                }
            }
            for ( int i = 0; i < e6.length - 1; i++ ) //E6
            {
                if ( value >= e6[i] && value <= e6[i + 1] ) {
                    if ( Math.abs( value - e6[i] ) < Math.abs( value - e6[i + 1] ) )
                        lblE6.setText( "E6: " + df.format( e6[i] * multiplier ) );
                    else lblE6.setText( "E6: " + df.format( e6[i + 1] * multiplier ) );
                }
            }
            for ( int i = 0; i < e12.length - 1; i++ )//E12
            {
                if ( value >= e12[i] && value <= e12[i + 1] ) {
                    if ( Math.abs( value - e12[i] ) < Math.abs( value - e12[i + 1] ) )
                        lblE12.setText( "E12: " + df.format( e12[i] * multiplier ) );
                    else lblE12.setText( "E12: " + df.format( e12[i + 1] * multiplier ) );
                }
            }
            for ( int i = 0; i < e24.length - 1; i++ )//E24
            {
                if ( value >= e24[i] && value <= e24[i + 1] ) {
                    if ( Math.abs( value - e24[i] ) < Math.abs( value - e24[i + 1] ) )
                        lblE24.setText( "E24: " + df.format( e24[i] * multiplier ) );
                    else lblE24.setText( "E24: " + df.format( e24[i + 1] * multiplier ) );
                }
            }
            for ( int i = 0; i < e48.length - 1; i++ )//E48
            {
                if ( value >= e48[i] && value <= e48[i + 1] ) {
                    if ( Math.abs( value - e48[i] ) < Math.abs( value - e48[i + 1] ) )
                        lblE48.setText( "E48: " + df.format( e48[i] * multiplier ) );
                    else lblE48.setText( "E48: " + df.format( e48[i + 1] * multiplier ) );
                }
            }
            for ( int i = 0; i < e96.length - 1; i++ )//E96
            {
                if ( value >= e96[i] && value <= e96[i + 1] ) {
                    if ( Math.abs( value - e96[i] ) < Math.abs( value - e96[i + 1] ) )
                        lblE96.setText( "E96: " + df.format( e96[i] * multiplier ) );
                    else lblE96.setText( "E96: " + df.format( e96[i + 1] * multiplier ) );
                }
            }
            for ( int i = 0; i < e192.length - 1; i++ )//E192
            {
                if ( value >= e192[i] && value <= e192[i + 1] ) {
                    if ( Math.abs( value - e192[i] ) < Math.abs( value - e192[i + 1] ) )
                        lblE192.setText( "E192: " + df.format( e192[i] * multiplier ) );
                    else lblE192.setText( "E192: " + df.format( e192[i + 1] * multiplier ) );
                }
            }
        } else {
            lblE3.setText( "E3: 0" );
            lblE6.setText( "E6: 0" );
            lblE12.setText( "E12: 0" );
            lblE24.setText( "E24: 0" );
            lblE48.setText( "E48: 0" );
            lblE96.setText( "E96: 0" );
            lblE192.setText( "E192: 0" );
        }
    }
}
