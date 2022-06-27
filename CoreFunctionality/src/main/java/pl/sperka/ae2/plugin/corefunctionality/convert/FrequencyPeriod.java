package pl.sperka.ae2.plugin.corefunctionality.convert;

/*
 * Created on 2011-05-31, 16:06:45
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class FrequencyPeriod extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( FrequencyPeriod.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.convert.Strings" );
    private int lock = 0;
    private javax.swing.JComboBox< String > cbCzestotliwosc;
    private javax.swing.JComboBox< String > cbOkres;
    private javax.swing.JRadioButton rbCzestotliwosc;
    private javax.swing.JRadioButton rbOkres;
    private javax.swing.JTextField txtCzestotliwosc;
    private javax.swing.JTextField txtOkres;

    public FrequencyPeriod( ICore core ) {
        initComponents();
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {
        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        rbCzestotliwosc = new javax.swing.JRadioButton();
        rbOkres = new javax.swing.JRadioButton();
        txtCzestotliwosc = new javax.swing.JTextField();
        txtOkres = new javax.swing.JTextField();
        cbCzestotliwosc = new javax.swing.JComboBox<>();
        cbOkres = new javax.swing.JComboBox<>();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "frequency-period.title" ) );
        setResizable( false );

        buttonGroup1.add( rbCzestotliwosc );
        rbCzestotliwosc.setSelected( true );
        rbCzestotliwosc.setText( strings.getString( "frequency-period.frequency" ) );
        rbCzestotliwosc.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseClicked( java.awt.event.MouseEvent evt ) {
                rbCzestotliwoscMouseClicked( evt );
            }
        } );

        buttonGroup1.add( rbOkres );
        rbOkres.setText( strings.getString( "frequency-period.period" ) );
        rbOkres.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseClicked( java.awt.event.MouseEvent evt ) {
                rbOkresMouseClicked( evt );
            }
        } );

        txtCzestotliwosc.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtCzestotliwoscKeyReleased( evt );
            }
        } );

        txtOkres.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtOkresKeyReleased( evt );
            }
        } );

        cbCzestotliwosc.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Hz", "kHz", "MHz", "GHz" } ) );
        cbCzestotliwosc.addItemListener( this::cbCzestotliwoscItemStateChanged );

        cbOkres.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "ms", "us", "ns", "ps" } ) );
        cbOkres.addItemListener( this::cbOkresItemStateChanged );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addGroup( layout.createSequentialGroup().addComponent( rbOkres ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( txtOkres ) ).addGroup( layout.createSequentialGroup().addComponent( rbCzestotliwosc ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtCzestotliwosc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( cbCzestotliwosc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbOkres, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addGap( 18, 18, 18 ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( rbCzestotliwosc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtCzestotliwosc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbCzestotliwosc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtOkres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbOkres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( rbOkres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private void rbCzestotliwoscMouseClicked( java.awt.event.MouseEvent evt ) {
        Calculate();
    }

    private void rbOkresMouseClicked( java.awt.event.MouseEvent evt ) {
        Calculate();
    }

    private void txtCzestotliwoscKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void txtOkresKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void cbCzestotliwoscItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) Calculate();
    }

    private void cbOkresItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) Calculate();
    }

    private void Calculate() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        float freq = 0, period = 0;
        if ( rbCzestotliwosc.isSelected() ) {
            if ( !txtCzestotliwosc.getText().equals( "" ) ) {
                try {
                    freq = nf.parse( txtCzestotliwosc.getText() ).floatValue();

                    period = 1000 / freq;
                    lock = 1;
                    cbOkres.setSelectedIndex( cbCzestotliwosc.getSelectedIndex() );
                    txtOkres.setText( nf.format( period ) );
                    lock = 0;
                } catch ( Exception ignored ) {
                }
            }
        }

        if ( rbOkres.isSelected() ) {
            if ( !txtOkres.getText().equals( "" ) ) {
                try {
                    period = nf.parse( txtOkres.getText() ).floatValue();
                    freq = ( 1000 / period );
                    lock = 1;
                    cbCzestotliwosc.setSelectedIndex( cbOkres.getSelectedIndex() );
                    txtCzestotliwosc.setText( nf.format( freq ) );
                    lock = 0;
                } catch ( Exception ignored ) {
                }
            }
        }
    }
}
