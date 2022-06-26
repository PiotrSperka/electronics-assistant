package pl.sperka.ae2.plugin.corefunctionality.calculate;

/*
 * Created on 2011-03-20, 17:22:06
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class VoltageCurrentPower extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( VoltageCurrentPower.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.calculate.Strings" );

    private javax.swing.JLabel jlCurrent;
    private javax.swing.JLabel jlPower;
    private javax.swing.JLabel jlResistance;
    private javax.swing.JLabel jlVoltage;
    private javax.swing.JTextField jtfCurrent;
    private javax.swing.JTextField jtfPower;
    private javax.swing.JTextField jtfResistance;
    private javax.swing.JTextField jtfVoltage;

    public VoltageCurrentPower( Component parent ) {
        initComponents();
        setLocationRelativeTo( parent );
    }

    private void initComponents() {
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        jtfPower = new javax.swing.JTextField();
        jtfResistance = new javax.swing.JTextField();
        jtfVoltage = new javax.swing.JTextField();
        jtfCurrent = new javax.swing.JTextField();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jlPower = new javax.swing.JLabel();
        jlResistance = new javax.swing.JLabel();
        jlVoltage = new javax.swing.JLabel();
        jlCurrent = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "voltage-current-power.title" ) );
        setResizable( false );

        jLabel4.setText( strings.getString( "voltage-current-power.enter-any-two-values" ) );

        jLabel1.setText( strings.getString( "voltage-current-power.power" ) );

        jLabel2.setText( strings.getString( "voltage-current-power.resistance" ) );

        jLabel3.setText( strings.getString( "voltage-current-power.voltage" ) );

        jLabel5.setText( strings.getString( "voltage-current-power.current" ) );

        jtfPower.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfPowerKeyReleased( evt );
            }
        } );

        jtfResistance.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfResistanceKeyReleased( evt );
            }
        } );

        jtfVoltage.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfVoltageKeyReleased( evt );
            }
        } );

        jtfCurrent.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfCurrentKeyReleased( evt );
            }
        } );

        jSeparator1.setOrientation( javax.swing.SwingConstants.VERTICAL );

        jLabel6.setText( strings.getString( "voltage-current-power.results" ) );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jLabel4 ).addGroup( layout.createSequentialGroup().addComponent( jLabel1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtfPower ) ).addGroup( layout.createSequentialGroup().addComponent( jLabel2 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtfResistance ) ).addGroup( layout.createSequentialGroup().addComponent( jLabel3 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtfVoltage ) ).addGroup( layout.createSequentialGroup().addComponent( jLabel5 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtfCurrent ) ) ).addGap( 18, 18, 18 ).addComponent( jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel6 ).addComponent( jlResistance, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jlVoltage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jlCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jlPower, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jSeparator1 ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addComponent( jLabel4 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtfPower, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtfResistance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtfVoltage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtfCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addGroup( layout.createSequentialGroup().addComponent( jLabel6 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlPower, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlResistance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlVoltage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private void jtfPowerKeyReleased( java.awt.event.KeyEvent evt ) {
        Licz();
    }

    private void jtfResistanceKeyReleased( java.awt.event.KeyEvent evt ) {
        Licz();
    }

    private void jtfVoltageKeyReleased( java.awt.event.KeyEvent evt ) {
        Licz();
    }

    private void jtfCurrentKeyReleased( java.awt.event.KeyEvent evt ) {
        Licz();
    }

    private boolean checkInput() {
        int i = 0;
        if ( !( jtfPower.getText().isEmpty() ) ) i++;
        if ( !( jtfResistance.getText().isEmpty() ) ) i++;
        if ( !( jtfVoltage.getText().isEmpty() ) ) i++;
        if ( !( jtfCurrent.getText().isEmpty() ) ) i++;
        if ( i >= 2 ) return true;
        else return false;
    }

    private void Licz() {
        if ( !checkInput() ) return;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( !jtfPower.getText().isEmpty() && !jtfResistance.getText().isEmpty() ) {
                jlPower.setText( jtfPower.getText() );
                jlResistance.setText( jtfResistance.getText() );
                jlVoltage.setText( nf.format( Math.sqrt( nf.parse( jtfPower.getText() ).doubleValue() * nf.parse( jtfResistance.getText() ).doubleValue() ) ) );
                jlCurrent.setText( nf.format( Math.sqrt( nf.parse( jtfPower.getText() ).doubleValue() / nf.parse( jtfResistance.getText() ).doubleValue() ) ) );
            } else if ( !jtfPower.getText().isEmpty() && !jtfVoltage.getText().isEmpty() ) {
                jlPower.setText( jtfPower.getText() );
                jlResistance.setText( nf.format( ( nf.parse( jtfVoltage.getText() ).doubleValue() * nf.parse( jtfVoltage.getText() ).doubleValue() ) / nf.parse( jtfPower.getText() ).doubleValue() ) );
                jlVoltage.setText( jtfVoltage.getText() );
                jlCurrent.setText( nf.format( nf.parse( jtfPower.getText() ).doubleValue() / nf.parse( jtfVoltage.getText() ).doubleValue() ) );
            } else if ( !jtfPower.getText().isEmpty() && !jtfCurrent.getText().isEmpty() ) {
                jlPower.setText( jtfPower.getText() );
                jlResistance.setText( nf.format( nf.parse( jtfPower.getText() ).doubleValue() / ( nf.parse( jtfCurrent.getText() ).doubleValue() * nf.parse( jtfCurrent.getText() ).doubleValue() ) ) );
                jlVoltage.setText( nf.format( nf.parse( jtfPower.getText() ).doubleValue() / nf.parse( jtfCurrent.getText() ).doubleValue() ) );
                jlCurrent.setText( jtfCurrent.getText() );
            } else if ( !jtfResistance.getText().isEmpty() && !jtfVoltage.getText().isEmpty() ) {
                jlPower.setText( nf.format( ( nf.parse( jtfVoltage.getText() ).doubleValue() * nf.parse( jtfVoltage.getText() ).doubleValue() ) / nf.parse( jtfResistance.getText() ).doubleValue() ) );
                jlResistance.setText( jtfResistance.getText() );
                jlVoltage.setText( jtfVoltage.getText() );
                jlCurrent.setText( nf.format( nf.parse( jtfVoltage.getText() ).doubleValue() / nf.parse( jtfResistance.getText() ).doubleValue() ) );
            } else if ( !jtfResistance.getText().isEmpty() && !jtfCurrent.getText().isEmpty() ) {
                jlPower.setText( nf.format( ( nf.parse( jtfCurrent.getText() ).doubleValue() * nf.parse( jtfCurrent.getText() ).doubleValue() ) * nf.parse( jtfResistance.getText() ).doubleValue() ) );
                jlResistance.setText( jtfResistance.getText() );
                jlVoltage.setText( nf.format( nf.parse( jtfCurrent.getText() ).doubleValue() * nf.parse( jtfResistance.getText() ).doubleValue() ) );
                jlCurrent.setText( jtfCurrent.getText() );
            } else if ( !jtfVoltage.getText().isEmpty() && !jtfCurrent.getText().isEmpty() ) {
                jlPower.setText( nf.format( nf.parse( jtfCurrent.getText() ).doubleValue() * nf.parse( jtfVoltage.getText() ).doubleValue() ) );
                jlResistance.setText( nf.format( nf.parse( jtfVoltage.getText() ).doubleValue() / nf.parse( jtfCurrent.getText() ).doubleValue() ) );
                jlVoltage.setText( jtfVoltage.getText() );
                jlCurrent.setText( jtfCurrent.getText() );
            }
            jlPower.setText( jlPower.getText() + " W" );
            jlResistance.setText( jlResistance.getText() + " Ohm" );
            jlVoltage.setText( jlVoltage.getText() + " V" );
            jlCurrent.setText( jlCurrent.getText() + " A" );
        } catch ( Exception e ) {
            jlPower.setText( "-" );
            jlResistance.setText( "-" );
            jlVoltage.setText( "-" );
            jlCurrent.setText( "-" );
        }
    }
}
