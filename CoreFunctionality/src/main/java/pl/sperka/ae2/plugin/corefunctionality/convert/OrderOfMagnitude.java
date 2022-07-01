package pl.sperka.ae2.plugin.corefunctionality.convert;

/*
 * Created on 2011-12-15, 15:24:16
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import java.text.NumberFormat;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class OrderOfMagnitude extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( OrderOfMagnitude.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.convert.Strings" );
    private static final NumberFormat nf = NumberFormat.getInstance();
    private javax.swing.JTextField txtAtto;
    private javax.swing.JTextField txtEksa;
    private javax.swing.JTextField txtFemto;
    private javax.swing.JTextField txtGiga;
    private javax.swing.JTextField txtKilo;
    private javax.swing.JTextField txtMega;
    private javax.swing.JTextField txtMikro;
    private javax.swing.JTextField txtMili;
    private javax.swing.JTextField txtNano;
    private javax.swing.JTextField txtNormal;
    private javax.swing.JTextField txtPeta;
    private javax.swing.JTextField txtPiko;
    private javax.swing.JTextField txtTera;

    public OrderOfMagnitude( ICore core ) {
        initComponents();
        nf.setMaximumFractionDigits( 21 );
        nf.setGroupingUsed( false );
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        txtEksa = new javax.swing.JTextField();
        txtPeta = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        txtTera = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        txtGiga = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        txtMega = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        txtKilo = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        txtNormal = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        txtMili = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        txtMikro = new javax.swing.JTextField();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        txtNano = new javax.swing.JTextField();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        txtPiko = new javax.swing.JTextField();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        txtFemto = new javax.swing.JTextField();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        txtAtto = new javax.swing.JTextField();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "order-of-magnitude.title" ) );
        setResizable( false );

        jLabel1.setText( "Eksa" );

        txtEksa.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtEksa.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtEksaKeyReleased( evt );
            }
        } );

        txtPeta.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtPeta.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtPetaKeyReleased( evt );
            }
        } );

        jLabel2.setText( "Peta" );

        txtTera.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtTera.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtTeraKeyReleased( evt );
            }
        } );

        jLabel3.setText( "Tera" );

        txtGiga.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtGiga.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtGigaKeyReleased( evt );
            }
        } );

        jLabel4.setText( "Giga" );

        txtMega.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtMega.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMegaKeyReleased( evt );
            }
        } );

        jLabel5.setText( "Mega" );

        txtKilo.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtKilo.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtKiloKeyReleased( evt );
            }
        } );

        jLabel6.setText( "Kilo" );

        txtNormal.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtNormal.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtNormalKeyReleased( evt );
            }
        } );

        jLabel7.setText( "---" );

        txtMili.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtMili.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMiliKeyReleased( evt );
            }
        } );

        jLabel8.setText( "Mili" );

        txtMikro.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtMikro.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMikroKeyReleased( evt );
            }
        } );

        jLabel9.setText( "Mikro" );

        txtNano.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtNano.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtNanoKeyReleased( evt );
            }
        } );

        jLabel10.setText( "Nano" );

        txtPiko.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtPiko.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtPikoKeyReleased( evt );
            }
        } );

        jLabel11.setText( "Piko" );

        txtFemto.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtFemto.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtFemtoKeyReleased( evt );
            }
        } );

        jLabel12.setText( "Femto" );

        txtAtto.setPreferredSize( new java.awt.Dimension( 75, 20 ) );
        txtAtto.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAttoKeyReleased( evt );
            }
        } );

        jLabel13.setText( "Atto" );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( jLabel1 ).addComponent( jLabel2 ).addComponent( jLabel4 ).addComponent( jLabel3 ).addComponent( jLabel5 ).addComponent( jLabel6 ).addComponent( jLabel7 ).addComponent( jLabel8 ).addComponent( jLabel9 ).addComponent( jLabel10 ).addComponent( jLabel11 ).addComponent( jLabel12 ).addComponent( jLabel13 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( txtAtto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtFemto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtPiko, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtNano, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtMikro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtMili, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtKilo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtMega, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtGiga, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtTera, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtEksa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtEksa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtPeta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtTera, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtGiga, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtMega, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtKilo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtMili, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtMikro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtNano, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtPiko, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtFemto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAtto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( 15, Short.MAX_VALUE ) ) );

        pack();
    }

    private void txtNormalKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtNormal.getCaretPosition();
        if ( txtNormal.getText().endsWith( "," ) || txtNormal.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtNormal.getText() ).doubleValue() );
        } catch ( Exception ignored ) {
        }
        txtNormal.setCaretPosition( pos );
    }

    private void txtEksaKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtEksa.getCaretPosition();
        if ( txtEksa.getText().endsWith( "," ) || txtEksa.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtEksa.getText() ).doubleValue() * 1e18 );
        } catch ( Exception ignored ) {
        }
        txtEksa.setCaretPosition( pos );
    }

    private void txtPetaKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtPeta.getCaretPosition();
        if ( txtPeta.getText().endsWith( "," ) || txtPeta.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtPeta.getText() ).doubleValue() * 1e15 );
        } catch ( Exception ignored ) {
        }
        txtPeta.setCaretPosition( pos );
    }

    private void txtTeraKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtTera.getCaretPosition();
        if ( txtTera.getText().endsWith( "," ) || txtTera.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtTera.getText() ).doubleValue() * 1e12 );
        } catch ( Exception ignored ) {
        }
        txtTera.setCaretPosition( pos );
    }

    private void txtGigaKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtGiga.getCaretPosition();
        if ( txtGiga.getText().endsWith( "," ) || txtGiga.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtGiga.getText() ).doubleValue() * 1e9 );
        } catch ( Exception ignored ) {
        }
        txtGiga.setCaretPosition( pos );
    }

    private void txtMegaKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtMega.getCaretPosition();
        if ( txtMega.getText().endsWith( "," ) || txtMega.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtMega.getText() ).doubleValue() * 1e6 );
        } catch ( Exception ignored ) {
        }
        txtMega.setCaretPosition( pos );
    }

    private void txtKiloKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtKilo.getCaretPosition();
        if ( txtKilo.getText().endsWith( "," ) || txtKilo.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtKilo.getText() ).doubleValue() * 1e3 );
        } catch ( Exception ignored ) {
        }
        txtKilo.setCaretPosition( pos );
    }

    private void txtMiliKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtMili.getCaretPosition();
        if ( txtMili.getText().endsWith( "," ) || txtMili.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtMili.getText() ).doubleValue() / 1e3 );
        } catch ( Exception ignored ) {
        }
        txtMili.setCaretPosition( pos );
    }

    private void txtMikroKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtMikro.getCaretPosition();
        if ( txtMikro.getText().endsWith( "," ) || txtMikro.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtMikro.getText() ).doubleValue() / 1e6 );
        } catch ( Exception ignored ) {
        }
        txtMikro.setCaretPosition( pos );
    }

    private void txtNanoKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtNano.getCaretPosition();
        if ( txtNano.getText().endsWith( "," ) || txtNano.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtNano.getText() ).doubleValue() / 1e9 );
        } catch ( Exception ignored ) {
        }
        txtNano.setCaretPosition( pos );
    }

    private void txtPikoKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtPiko.getCaretPosition();
        if ( txtPiko.getText().endsWith( "," ) || txtPiko.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtPiko.getText() ).doubleValue() / 1e12 );
        } catch ( Exception ignored ) {
        }
        txtPiko.setCaretPosition( pos );
    }

    private void txtFemtoKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtFemto.getCaretPosition();
        if ( txtFemto.getText().endsWith( "," ) || txtFemto.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtFemto.getText() ).doubleValue() / 1e15 );
        } catch ( Exception ignored ) {
        }
        txtFemto.setCaretPosition( pos );
    }

    private void txtAttoKeyReleased( java.awt.event.KeyEvent evt ) {
        int pos = txtAtto.getCaretPosition();
        if ( txtAtto.getText().endsWith( "," ) || txtAtto.getText().endsWith( "." ) ) return;
        try {
            Convert( nf.parse( txtAtto.getText() ).doubleValue() / 1e18 );
        } catch ( Exception ignored ) {
        }
        txtAtto.setCaretPosition( pos );
    }

    private void Convert( double liczba ) {
        try {
            txtEksa.setText( nf.format( liczba / 1e18 ) );
            txtPeta.setText( nf.format( liczba / 1e15 ) );
            txtTera.setText( nf.format( liczba / 1e12 ) );
            txtGiga.setText( nf.format( liczba / 1e9 ) );
            txtMega.setText( nf.format( liczba / 1e6 ) );
            txtKilo.setText( nf.format( liczba / 1e3 ) );
            txtNormal.setText( nf.format( liczba ) );
            txtMili.setText( nf.format( liczba * 1e3 ) );
            txtMikro.setText( nf.format( liczba * 1e6 ) );
            txtNano.setText( nf.format( liczba * 1e9 ) );
            txtPiko.setText( nf.format( liczba * 1e12 ) );
            txtFemto.setText( nf.format( liczba * 1e15 ) );
            txtAtto.setText( nf.format( liczba * 1e18 ) );
        } catch ( Exception ignored ) {
        }
    }
}
