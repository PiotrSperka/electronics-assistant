package pl.sperka.ae2.plugin.corefunctionality.calculate;

/*
 * Created on 2011-04-22, 22:59:28
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class Radiator extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( Radiator.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.calculate.Strings" );
    private javax.swing.JRadioButton rbRezTerm;
    private javax.swing.JRadioButton rbTempUkl;
    private javax.swing.JTextField txtMoc;
    private javax.swing.JTextField txtRezOb;
    private javax.swing.JTextField txtRezRad;
    private javax.swing.JTextField txtTempOt;
    private javax.swing.JTextField txtTempUkl;

    public Radiator( Component parent ) {
        initComponents();
        setLocationRelativeTo( parent );
    }

    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        txtRezRad = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        rbTempUkl = new javax.swing.JRadioButton();
        rbRezTerm = new javax.swing.JRadioButton();
        txtTempOt = new javax.swing.JTextField();
        txtTempUkl = new javax.swing.JTextField();
        txtMoc = new javax.swing.JTextField();
        txtRezOb = new javax.swing.JTextField();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "radiator.title" ) );
        setResizable( false );

        txtRezRad.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtRezRadKeyReleased( evt );
            }
        } );

        jLabel5.setText( strings.getString( "radiator.radiators-thermal-resistance" ) );

        jLabel4.setText( strings.getString( "radiator.junction-case-thermal-resistance" ) );

        jLabel3.setText( strings.getString( "radiator.dissipation-power" ) );

        jLabel2.setText( strings.getString( "radiator.ic-temperature" ) );

        jLabel1.setText( strings.getString( "radiator.room-temperature" ) );

        jPanel1.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "radiator.calculate" ) ) );

        buttonGroup1.add( rbTempUkl );
        rbTempUkl.setText( strings.getString( "radiator.ic-temperature-2" ) );
        rbTempUkl.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseClicked( java.awt.event.MouseEvent evt ) {
                rbTempUklMouseClicked( evt );
            }
        } );

        buttonGroup1.add( rbRezTerm );
        rbRezTerm.setSelected( true );
        rbRezTerm.setText( strings.getString( "radiator.ic-radiator-thermal-resistance" ) );
        rbRezTerm.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseClicked( java.awt.event.MouseEvent evt ) {
                rbRezTermMouseClicked( evt );
            }
        } );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( rbTempUkl ).addComponent( rbRezTerm ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( rbRezTerm ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( rbTempUkl ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        txtTempOt.setText( "20" );
        txtTempOt.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtTempOtKeyReleased( evt );
            }
        } );

        txtTempUkl.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtTempUklKeyReleased( evt );
            }
        } );

        txtMoc.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMocKeyReleased( evt );
            }
        } );

        txtRezOb.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtRezObKeyReleased( evt );
            }
        } );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( layout.createSequentialGroup().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel3 ).addComponent( jLabel2 ).addComponent( jLabel1 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( txtTempUkl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtTempOt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtMoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addComponent( jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jLabel5 ) ).addGroup( layout.createSequentialGroup().addGap( 159, 159, 159 ).addComponent( txtRezOb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( layout.createSequentialGroup().addGap( 160, 160, 160 ).addComponent( txtRezRad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtTempOt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel1 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtTempUkl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel2 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtMoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel3 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jLabel4 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtRezOb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jLabel5 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtRezRad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap( 30, Short.MAX_VALUE ) ) );

        pack();
    }

    private void txtRezRadKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void rbRezTermMouseClicked( java.awt.event.MouseEvent evt ) {
        Calculate();
    }

    private void rbTempUklMouseClicked( java.awt.event.MouseEvent evt ) {
        Calculate();
    }

    private void txtTempOtKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void txtTempUklKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void txtMocKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void txtRezObKeyReleased( java.awt.event.KeyEvent evt ) {
        Calculate();
    }

    private void Calculate() {
        float TempUkl = 0, TempOt = 0, Moc = 0, RezOb = 0, RezRad = 0;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( rbRezTerm.isSelected() ) {
                if ( !txtTempUkl.getText().equals( "" ) && !txtMoc.getText().equals( "" ) && !txtTempOt.getText().equals( "" ) && !txtRezOb.getText().equals( "" ) ) {
                    TempUkl = nf.parse( txtTempUkl.getText() ).floatValue();
                    TempOt = nf.parse( txtTempOt.getText() ).floatValue();
                    Moc = nf.parse( txtMoc.getText() ).floatValue();
                    RezOb = nf.parse( txtRezOb.getText() ).floatValue();

                    RezRad = ( TempUkl - TempOt ) / Moc - RezOb;
                    txtRezRad.setText( nf.format( RezRad ) );
                }
            }
            if ( rbTempUkl.isSelected() ) {
                if ( !txtRezRad.getText().equals( "" ) && !txtMoc.getText().equals( "" ) && !txtTempOt.getText().equals( "" ) && !txtRezRad.getText().equals( "" ) ) {
                    RezRad = nf.parse( txtRezRad.getText() ).floatValue();
                    TempOt = nf.parse( txtTempOt.getText() ).floatValue();
                    Moc = nf.parse( txtMoc.getText() ).floatValue();
                    RezOb = nf.parse( txtRezOb.getText() ).floatValue();

                    TempUkl = Moc * ( RezOb + RezRad ) + TempOt;
                    txtTempUkl.setText( nf.format( TempUkl ) );
                }
            }
        } catch ( Exception ignored ) {
        }
    }
}
