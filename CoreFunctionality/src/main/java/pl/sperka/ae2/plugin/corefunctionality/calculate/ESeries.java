package pl.sperka.ae2.plugin.corefunctionality.calculate;

/*
 * Created on 2011-12-16, 21:14:57
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugin.corefunctionality.common.ESeriesFinder;
import pl.sperka.ae2.plugin.corefunctionality.common.ESeriesType;
import pl.sperka.ae2.plugins.ICore;

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

    public ESeries( ICore core ) {
        initComponents();
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
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
        DecimalFormat df = new DecimalFormat( "###.###" );

        lblE3.setText( "E3: " + df.format( ESeriesFinder.findValue( value, ESeriesType.E3 ) ) );
        lblE6.setText( "E6: " + df.format( ESeriesFinder.findValue( value, ESeriesType.E6 ) ) );
        lblE12.setText( "E12: " + df.format( ESeriesFinder.findValue( value, ESeriesType.E12 ) ) );
        lblE24.setText( "E24: " + df.format( ESeriesFinder.findValue( value, ESeriesType.E24 ) ) );
        lblE48.setText( "E48: " + df.format( ESeriesFinder.findValue( value, ESeriesType.E48 ) ) );
        lblE96.setText( "E96: " + df.format( ESeriesFinder.findValue( value, ESeriesType.E96 ) ) );
        lblE192.setText( "E192: " + df.format( ESeriesFinder.findValue( value, ESeriesType.E192 ) ) );
    }
}
