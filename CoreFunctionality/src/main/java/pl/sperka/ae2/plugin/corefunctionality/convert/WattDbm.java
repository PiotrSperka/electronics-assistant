package pl.sperka.ae2.plugin.corefunctionality.convert;

/*
 * Created on 2011-06-02, 13:21:44
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class WattDbm extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( WattDbm.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.convert.Strings" );
    int lock = 0;
    private javax.swing.JComboBox< String > cbWat;
    private javax.swing.JComboBox< String > jbdB;
    private javax.swing.JTextField txtWat;
    private javax.swing.JTextField txtdBm;

    public WattDbm( ICore core ) {
        initComponents();
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {
        txtWat = new javax.swing.JTextField();
        txtdBm = new javax.swing.JTextField();
        cbWat = new javax.swing.JComboBox<>();
        jbdB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "watt-dbm.title" ) );
        setResizable( false );

        txtWat.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtWatKeyReleased( evt );
            }
        } );

        txtdBm.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtdBmKeyReleased( evt );
            }
        } );

        cbWat.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "mW", "W" } ) );
        cbWat.addItemListener( this::cbWatItemStateChanged );

        jbdB.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "dBm", "dBW" } ) );
        jbdB.addItemListener( this::jbdBItemStateChanged );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( txtdBm, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE ).addComponent( txtWat ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( cbWat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jbdB, 0, 84, Short.MAX_VALUE ) ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtWat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbWat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( txtdBm, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE ).addComponent( jbdB, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private void txtWatKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate( 0 );
    }

    private void cbWatItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) Calculate( 0 );
    }

    private void txtdBmKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate( 1 );
    }

    private void jbdBItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) Calculate( 1 );
    }

    private void Calculate( int mode ) {
        float wat = 0, dbm = 0;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( mode == 0 && !txtWat.getText().equals( "" ) ) {
                wat = nf.parse( txtWat.getText() ).floatValue();
                if ( cbWat.getSelectedItem().toString().equals( "mW" ) ) {
                    wat /= 1000;
                    lock = 1;
                    jbdB.setSelectedIndex( 0 );
                    lock = 0;
                } else {
                    lock = 1;
                    jbdB.setSelectedIndex( 1 );
                    lock = 0;
                }
                dbm = Double.valueOf( 10 * Math.log10( wat / 0.001 ) ).floatValue();
                if ( jbdB.getSelectedItem().toString().equals( "dBW" ) ) dbm -= 30;
                txtdBm.setText( nf.format( dbm ) );
            } else if ( mode == 1 && !txtdBm.getText().equals( "" ) ) {
                dbm = nf.parse( txtdBm.getText() ).floatValue();
                if ( jbdB.getSelectedItem().toString().equals( "dBW" ) ) dbm += 30;
                wat = Double.valueOf( 0.001 * Math.pow( 10, dbm / 10 ) ).floatValue();
                if ( wat >= 1 ) {
                    lock = 1;
                    cbWat.setSelectedIndex( 1 );
                    txtWat.setText( nf.format( wat ) );
                    lock = 0;
                } else {
                    lock = 1;
                    cbWat.setSelectedIndex( 0 );
                    txtWat.setText( nf.format( wat * 1000 ) );
                    lock = 0;
                }
            }
        } catch ( Exception ignored ) {
        }
    }
}
