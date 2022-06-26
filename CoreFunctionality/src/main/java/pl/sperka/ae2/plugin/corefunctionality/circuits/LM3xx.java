package pl.sperka.ae2.plugin.corefunctionality.circuits;

/*
 * Created on 2011-06-03, 23:56:52
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class LM3xx extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( LM3xx.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.circuits.Strings" );

    private javax.swing.JPanel jpPict;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblR2;
    private javax.swing.JLabel lblVin;
    private javax.swing.JRadioButton rbLM317;
    private javax.swing.JRadioButton rbLM337;
    private javax.swing.JTextField txtR1;
    private javax.swing.JTextField txtVout;

    public LM3xx( Component parent ) {
        initComponents();
        URL imgURL = getClass().getClassLoader().getResource( "pl/sperka/ae2/plugin/oldclasses/images/lm317.jpg" );
        ImageIcon icon = new ImageIcon( imgURL );
        JLabel label = new JLabel( icon );
        label.setSize( 200, 137 );
        jpPict.add( label );
        label.repaint();
        setLocationRelativeTo( parent );
    }


    private void initComponents() {

        ButtonGroup buttonGroup1 = new ButtonGroup();
        jpPict = new javax.swing.JPanel();
        rbLM317 = new javax.swing.JRadioButton();
        rbLM337 = new javax.swing.JRadioButton();
        JLabel jLabel1 = new JLabel();
        txtR1 = new javax.swing.JTextField();
        JLabel jLabel2 = new JLabel();
        txtVout = new javax.swing.JTextField();
        lblInfo = new javax.swing.JLabel();
        lblR2 = new javax.swing.JLabel();
        lblVin = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "lm3xx.title" ) );
        setResizable( false );

        javax.swing.GroupLayout jpPictLayout = new javax.swing.GroupLayout( jpPict );
        jpPict.setLayout( jpPictLayout );
        jpPictLayout.setHorizontalGroup( jpPictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 200, Short.MAX_VALUE ) );
        jpPictLayout.setVerticalGroup( jpPictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 140, Short.MAX_VALUE ) );

        buttonGroup1.add( rbLM317 );
        rbLM317.setSelected( true );
        rbLM317.setText( "LM317/350" );
        rbLM317.addItemListener( new java.awt.event.ItemListener() {
            public void itemStateChanged( java.awt.event.ItemEvent evt ) {
                rbLM317ItemStateChanged( evt );
            }
        } );

        buttonGroup1.add( rbLM337 );
        rbLM337.setText( "LM337" );
        rbLM337.addItemListener( new java.awt.event.ItemListener() {
            public void itemStateChanged( java.awt.event.ItemEvent evt ) {
                rbLM337ItemStateChanged( evt );
            }
        } );

        jLabel1.setText( strings.getString( "lm3xx.r1" ) );

        txtR1.setText( "240" );
        txtR1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtR1KeyReleased( evt );
            }
        } );

        jLabel2.setText( strings.getString( "lm3xx.v-out" ) );

        txtVout.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtVoutKeyReleased( evt );
            }
        } );

        lblInfo.setForeground( new java.awt.Color( 255, 0, 0 ) );

        lblR2.setText( " " );

        lblVin.setText( " " );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jpPict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( rbLM317 ).addComponent( rbLM337 ).addGroup( layout.createSequentialGroup().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel1 ).addComponent( jLabel2 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( txtVout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtR1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addComponent( lblInfo ).addComponent( lblR2 ).addComponent( lblVin ) ).addContainerGap( 35, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( jpPict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGroup( layout.createSequentialGroup().addComponent( rbLM317 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( rbLM337 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtR1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtVout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblInfo ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblR2 ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( lblVin ).addContainerGap( 32, Short.MAX_VALUE ) ) );

        pack();
    }

    private void rbLM317ItemStateChanged( java.awt.event.ItemEvent evt ) {
        jpPict.removeAll();
        jpPict.repaint();
        URL imgURL = getClass().getClassLoader().getResource( "pl/sperka/ae2/plugin/oldclasses/images/lm317.jpg" );
        ImageIcon icon = new ImageIcon( imgURL );
        JLabel label = new JLabel( icon );
        label.setSize( 200, 137 );
        jpPict.add( label );
        label.repaint();
        lblInfo.setText( null );
        Calculate();
    }

    private void rbLM337ItemStateChanged( java.awt.event.ItemEvent evt ) {
        jpPict.removeAll();
        jpPict.repaint();
        URL imgURL = getClass().getClassLoader().getResource( "pl/sperka/ae2/plugin/oldclasses/images/lm337.jpg" );
        ImageIcon icon = new ImageIcon( imgURL );
        JLabel label = new JLabel( icon );
        label.setSize( 200, 106 );
        jpPict.add( label );
        label.repaint();
        lblInfo.setText( strings.getString( "lm3xx.v-out-must-be-negative" ) );
        Calculate();
    }

    private void txtR1KeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void txtVoutKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void Calculate() {
        if ( !txtVout.getText().isEmpty() && !txtR1.getText().isEmpty() ) {
            java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
            float vout = 0, r1 = 0, r2 = 0;
            try {
                vout = nf.parse( txtVout.getText() ).floatValue();
                r1 = nf.parse( txtR1.getText() ).floatValue();
                if ( rbLM317.isSelected() && vout >= 1.25 && vout <= 37 ) {
                    r2 = Double.valueOf( ( ( vout / 1.25 ) - 1 ) * r1 ).floatValue();
                    lblVin.setText( nf.format( vout + 3 ) + "V<=Vin<=37V" );
                    lblR2.setText( nf.format( r2 ) + " Ohm" );
                } else if ( rbLM337.isSelected() && vout <= -1.25 && vout >= -37 ) {
                    r2 = Double.valueOf( ( ( vout / -1.25 ) - 1 ) * r1 ).floatValue();
                    lblVin.setText( nf.format( vout - 3 ) + "V>=Vin>=-37V" );
                    lblR2.setText( nf.format( r2 ) + " Ohm" );
                }
            } catch ( Exception ignored ) {
            }
        }
    }
}
