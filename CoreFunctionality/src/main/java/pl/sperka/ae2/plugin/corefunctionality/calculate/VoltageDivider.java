package pl.sperka.ae2.plugin.corefunctionality.calculate;

/*
 * Created on 2011-04-02, 17:44:18
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import javax.swing.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class VoltageDivider extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( VoltageDivider.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.calculate.Strings" );

    private javax.swing.JComboBox< String > cmbR2;
    private javax.swing.JLabel lblR1;
    private javax.swing.JPanel panObrazek;
    private javax.swing.JTextField txtR2;
    private javax.swing.JTextField txtWej;
    private javax.swing.JTextField txtWyj;

    public VoltageDivider( ICore core ) {
        initComponents();
        ClassLoader cl = this.getClass().getClassLoader();
        URL url = cl.getResource( "pl/sperka/ae2/plugin/oldclasses/images/Dzielnik.jpg" );
        Icon icon = new ImageIcon( url );
        JLabel label = new JLabel( icon );
        label.setSize( 120, 161 );
        panObrazek.add( label );
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        txtWej = new javax.swing.JTextField();
        txtWyj = new javax.swing.JTextField();
        txtR2 = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        lblR1 = new javax.swing.JLabel();
        cmbR2 = new javax.swing.JComboBox<>();
        panObrazek = new javax.swing.JPanel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "voltage-divider.title" ) );
        setResizable( false );

        jLabel1.setText( strings.getString( "voltage-divider.input-voltage" ) );

        jLabel2.setText( strings.getString( "voltage-divider.output-voltage" ) );

        txtWej.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtWejKeyReleased( evt );
            }
        } );

        txtWyj.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtWyjKeyReleased( evt );
            }
        } );

        txtR2.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtR2KeyReleased( evt );
            }
        } );

        jLabel3.setText( "R2:" );

        lblR1.setText( "R1:" );

        cmbR2.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Ohm", "kOhm", "MOhm" } ) );
        cmbR2.addItemListener( new java.awt.event.ItemListener() {
            public void itemStateChanged( java.awt.event.ItemEvent evt ) {
                cmbR2ItemStateChanged( evt );
            }
        } );

        javax.swing.GroupLayout panObrazekLayout = new javax.swing.GroupLayout( panObrazek );
        panObrazek.setLayout( panObrazekLayout );
        panObrazekLayout.setHorizontalGroup( panObrazekLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 120, Short.MAX_VALUE ) );
        panObrazekLayout.setVerticalGroup( panObrazekLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 161, Short.MAX_VALUE ) );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel1 ).addComponent( jLabel2 ).addComponent( jLabel3 ) ).addGap( 12, 12, 12 ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addComponent( txtR2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cmbR2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( txtWyj, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtWej, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addComponent( lblR1 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( panObrazek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( panObrazek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGroup( layout.createSequentialGroup().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtWej, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtWyj, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtR2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cmbR2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( lblR1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private void txtWyjKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void txtR2KeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void cmbR2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        Calculate();
    }

    private void txtWejKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void Calculate() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        if ( !txtR2.getText().equals( "" ) && !txtWej.getText().equals( "" ) && !txtWyj.getText().equals( "" ) ) {
            float Uwej = 0, Uwyj = 0, R2 = 0;
            double R1 = 0;
            try {
                Uwej = nf.parse( txtWej.getText() ).floatValue();
                Uwyj = nf.parse( txtWyj.getText() ).floatValue();
                R2 = nf.parse( txtR2.getText() ).floatValue();
            } catch ( Exception ignored ) {
            }
            if ( Objects.equals( cmbR2.getSelectedItem(), "kOhm" ) ) R2 *= 1000;
            if ( Objects.equals( cmbR2.getSelectedItem(), "MOhm" ) ) R2 *= 1000000;
            R1 = R2 * ( Uwej / Uwyj ) - R2;
            R1 = Math.round( R1 * 10 );
            if ( R1 < 0 ) {
                lblR1.setText( strings.getString( "voltage-divider.input-smaller-than-output" ) );
            } else if ( R1 < 10000 ) {
                lblR1.setText( "R1: " + nf.format( R1 / 10 ) + " Ohm" );
            } else if ( R1 < 10000000 ) {
                lblR1.setText( "R1: " + nf.format( R1 / 10000 ) + " kOhm" );
            } else {
                lblR1.setText( "R1: " + nf.format( R1 / 10000000 ) + " MOhm" );
            }
        }
    }
}
