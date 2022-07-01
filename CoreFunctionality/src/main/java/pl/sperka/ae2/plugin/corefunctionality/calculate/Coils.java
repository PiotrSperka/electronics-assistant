package pl.sperka.ae2.plugin.corefunctionality.calculate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class Coils extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( Coils.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.calculate.Strings" );

    private javax.swing.JPanel jpPictcpj;
    private javax.swing.JPanel jpPictcpw;
    private javax.swing.JRadioButton jrbcpjL;
    private javax.swing.JRadioButton jrbcpjN;
    private javax.swing.JRadioButton jrbcpwL;
    private javax.swing.JRadioButton jrbcpwN;
    private javax.swing.JTextField jtCpwD2;
    private javax.swing.JTextField jtCpwDrut;
    private javax.swing.JTextField jtcpjD;
    private javax.swing.JTextField jtcpjL;
    private javax.swing.JTextField jtcpjl;
    private javax.swing.JTextField jtcpjn;
    private javax.swing.JTextField jtcpwD;
    private javax.swing.JTextField jtcpwL;
    private javax.swing.JTextField jtcpwl;
    private javax.swing.JTextField jtcpwn;

    public Coils( ICore core ) {
        initComponents();
        URL imgURL1 = getClass().getClassLoader().getResource( "pl/sperka/ae2/plugin/images/cewpj.jpg" );
        ImageIcon icon1 = new ImageIcon( imgURL1 );
        JLabel label1 = new JLabel( icon1 );
        label1.setSize( 100, 185 );
        jpPictcpj.add( label1 );
        label1.repaint();

        URL imgURL2 = getClass().getClassLoader().getResource( "pl/sperka/ae2/plugin/images/cewpw.jpg" );
        ImageIcon icon2 = new ImageIcon( imgURL2 );
        JLabel label2 = new JLabel( icon2 );
        label2.setSize( 250, 296 );
        jpPictcpw.add( label2 );
        label2.repaint();

        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {

        ButtonGroup buttonGroup1 = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel1 = new JPanel();
        jpPictcpj = new javax.swing.JPanel();
        jtcpjD = new javax.swing.JTextField();
        jtcpjl = new javax.swing.JTextField();
        jtcpjn = new javax.swing.JTextField();
        jtcpjL = new javax.swing.JTextField();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        jrbcpjN = new javax.swing.JRadioButton();
        jrbcpjL = new javax.swing.JRadioButton();
        JPanel jPanel2 = new JPanel();
        jpPictcpw = new javax.swing.JPanel();
        jtcpwD = new javax.swing.JTextField();
        jtcpwl = new javax.swing.JTextField();
        jtcpwn = new javax.swing.JTextField();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        jtcpwL = new javax.swing.JTextField();
        JLabel jLabel9 = new JLabel();
        jrbcpwN = new javax.swing.JRadioButton();
        jrbcpwL = new javax.swing.JRadioButton();
        jtCpwDrut = new javax.swing.JTextField();
        JLabel jLabel10 = new JLabel();
        jtCpwD2 = new javax.swing.JTextField();
        JLabel jLabel6 = new JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "coils.title" ) );
        setResizable( false );

        javax.swing.GroupLayout jpPictcpjLayout = new javax.swing.GroupLayout( jpPictcpj );
        jpPictcpj.setLayout( jpPictcpjLayout );
        jpPictcpjLayout.setHorizontalGroup( jpPictcpjLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 200, Short.MAX_VALUE ) );
        jpPictcpjLayout.setVerticalGroup( jpPictcpjLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 0, Short.MAX_VALUE ) );

        jtcpjD.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpjDKeyReleased( evt );
            }
        } );

        jtcpjl.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpjlKeyReleased( evt );
            }
        } );

        jtcpjn.setEditable( false );
        jtcpjn.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpjnKeyReleased( evt );
            }
        } );

        jtcpjL.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpjLKeyReleased( evt );
            }
        } );

        jLabel1.setText( strings.getString( "coils.diameter" ) );

        jLabel2.setText( strings.getString( "coils.length" ) );

        jLabel3.setText( strings.getString( "coils.turns" ) );

        jLabel4.setText( strings.getString( "coils.inductance" ) );

        buttonGroup1.add( jrbcpjN );
        jrbcpjN.setSelected( true );
        jrbcpjN.addItemListener( this::jrbcpjNItemStateChanged );

        buttonGroup1.add( jrbcpjL );
        jrbcpjL.addItemListener( this::jrbcpjLItemStateChanged );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jpPictcpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel2 ).addComponent( jLabel1 ) ).addGap( 80, 80, 80 ) ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jLabel3 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ) ) ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jLabel4 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false ).addComponent( jtcpjn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE ).addComponent( jtcpjD, javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jtcpjl, javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jtcpjL ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbcpjN ).addComponent( jrbcpjL ) ).addContainerGap( 61, Short.MAX_VALUE ) ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jpPictcpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addContainerGap() ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpjD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpjl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpjn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbcpjN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpjL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbcpjL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( 129, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "coils.air-cored-single-layer" ), jPanel1 );

        javax.swing.GroupLayout jpPictcpwLayout = new javax.swing.GroupLayout( jpPictcpw );
        jpPictcpw.setLayout( jpPictcpwLayout );
        jpPictcpwLayout.setHorizontalGroup( jpPictcpwLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 250, Short.MAX_VALUE ) );
        jpPictcpwLayout.setVerticalGroup( jpPictcpwLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 298, Short.MAX_VALUE ) );

        jtcpwD.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpwDKeyReleased( evt );
            }
        } );

        jtcpwl.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpwlKeyReleased( evt );
            }
        } );

        jtcpwn.setEditable( false );
        jtcpwn.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpwnKeyReleased( evt );
            }
        } );

        jLabel5.setText( strings.getString( "coils.turns" ) );

        jLabel7.setText( strings.getString( "coils.length" ) );

        jLabel8.setText( strings.getString( "coils.diameter-d1" ) );

        jtcpwL.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtcpwLKeyReleased( evt );
            }
        } );

        jLabel9.setText( strings.getString( "coils.inductance" ) );

        buttonGroup2.add( jrbcpwN );
        jrbcpwN.setSelected( true );
        jrbcpwN.addItemListener( this::jrbcpwNItemStateChanged );

        buttonGroup2.add( jrbcpwL );
        jrbcpwL.addChangeListener( this::jrbcpwLStateChanged );

        jtCpwDrut.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtCpwDrutKeyReleased( evt );
            }
        } );

        jLabel10.setText( strings.getString( "coils.wire-diameter" ) );

        jLabel6.setText( strings.getString( "coils.diameter-d2" ) );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jpPictcpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGap( 49, 49, 49 ) ).addGroup( jPanel2Layout.createSequentialGroup().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel10 ).addComponent( jLabel6 ) ).addGap( 4, 4, 4 ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jtCpwDrut ).addComponent( jtcpwL ).addComponent( jtcpwl ).addComponent( jtcpwn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jtCpwD2 ).addComponent( jtcpwD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbcpwN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jrbcpwL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addGap( 106, 106, 106 ) ) );
        jPanel2Layout.setVerticalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpwD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtCpwD2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpwl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtCpwDrut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpwn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbcpwN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jtcpwL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbcpwL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jpPictcpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 0, 0, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "coils.air-cored-multi-layer" ), jPanel2 );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jTabbedPane1 ) );

        pack();
    }

    private void jtcpjDKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateSingleLayer();
    }

    private void jtcpjlKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateSingleLayer();
    }

    private void jtcpjnKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateSingleLayer();
    }

    private void jtcpjLKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateSingleLayer();
    }

    private void jtcpwDKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateMultiLayer();
    }

    private void jtcpwlKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateMultiLayer();
    }

    private void jtcpwnKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateMultiLayer();
    }

    private void jtcpwLKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateMultiLayer();
    }

    private void jtCpwDrutKeyReleased( java.awt.event.KeyEvent evt ) {
        CalculateMultiLayer();
    }

    private void jrbcpwLStateChanged( javax.swing.event.ChangeEvent evt ) {
        if ( jrbcpwL.isSelected() ) {
            jtCpwD2.setEditable( false );
            jtcpwL.setEditable( false );
            jtcpwn.setEditable( true );
        }
    }

    private void jrbcpwNItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( jrbcpwN.isSelected() ) {
            jtCpwD2.setEditable( true );
            jtcpwL.setEditable( true );
            jtcpwn.setEditable( false );
        }
    }

    private void jrbcpjNItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( jrbcpjN.isSelected() ) {
            jtcpjn.setEditable( false );
            jtcpjL.setEditable( true );
        }
    }

    private void jrbcpjLItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( jrbcpjL.isSelected() ) {
            jtcpjL.setEditable( false );
            jtcpjn.setEditable( true );
        }
    }


    private void CalculateSingleLayer() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        if ( jrbcpjN.isSelected() && !jtcpjD.getText().isEmpty() && !jtcpjL.getText().isEmpty() && !jtcpjl.getText().isEmpty() ) {//oblicz zwoje
            double n, D, L, l;
            try {
                D = nf.parse( jtcpjD.getText() ).doubleValue();
                L = nf.parse( jtcpjL.getText() ).doubleValue();
                l = nf.parse( jtcpjl.getText() ).doubleValue();
                n = Math.sqrt( ( L * ( ( l / D ) + 0.45 ) / D ) ) * 10;
                jtcpjn.setText( nf.format( n ) );
            } catch ( Exception e ) {
            }
        } else if ( jrbcpjL.isSelected() && !jtcpjD.getText().isEmpty() && !jtcpjn.getText().isEmpty() && !jtcpjl.getText().isEmpty() ) { //oblicz indukcyjnosc
            double n, D, L, l;
            try {
                D = nf.parse( jtcpjD.getText() ).doubleValue();
                n = nf.parse( jtcpjn.getText() ).doubleValue();
                l = nf.parse( jtcpjl.getText() ).doubleValue();
                L = ( D * n * n ) / ( l / D + 0.45 ) / 100;
                jtcpjL.setText( nf.format( L ) );
            } catch ( Exception e ) {
            }
        }

    }

    private void CalculateMultiLayer() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        if ( jrbcpwN.isSelected() && !jtcpwD.getText().isEmpty() && !jtCpwDrut.getText().isEmpty() && !jtcpwL.getText().isEmpty() && !jtcpwl.getText().isEmpty() ) {//oblicz zwoje
            double n, D1, D2, L, l, r;
            try {
                D1 = nf.parse( jtcpwD.getText() ).doubleValue() / 1000;
                D2 = nf.parse( jtCpwD2.getText() ).doubleValue() / 1000;
                L = nf.parse( jtcpwL.getText() ).doubleValue();
                l = nf.parse( jtcpwl.getText() ).doubleValue() / 1000;
                double drut = nf.parse( jtCpwDrut.getText() ).doubleValue() / 1000;
                double r1 = ( D1 / 2 ) + drut;
                //double warstwy = Math.ceil(((D2-D1)/2)/drut);
                double r2 = ( D2 / 2 );
                n = Math.sqrt( ( L * ( 6 * r1 + 9 * l + 10 * ( r2 - r1 ) ) ) / ( 31.6 * r1 * r1 ) );
                jtcpwn.setText( nf.format( n ) );
            } catch ( Exception ignored ) {
            }
        } else if ( jrbcpwL.isSelected() && !jtcpwD.getText().isEmpty() && !jtCpwDrut.getText().isEmpty() && !jtcpwn.getText().isEmpty() && !jtcpwl.getText().isEmpty() ) { //oblicz indukcyjnosc
            double n, D, L, l, r;
            try {
                D = nf.parse( jtcpwD.getText() ).doubleValue() / 1000;
                n = nf.parse( jtcpwn.getText() ).doubleValue();
                l = nf.parse( jtcpwl.getText() ).doubleValue() / 1000;
                double drut = nf.parse( jtCpwDrut.getText() ).doubleValue() / 1000;
                double r1 = ( D / 2 ) + drut;
                double warstwy = Math.ceil( n / ( l / drut ) );
                double r2 = ( D / 2 ) + ( warstwy * drut );
                // r=nf.parse(jtcpwr.getText()).doubleValue();
                L = ( 31.6 * n * n * r1 * r1 ) / ( 6 * r1 + 9 * l + 10 * ( r2 - r1 ) );
                jtcpwL.setText( nf.format( L ) );
                jtCpwD2.setText( nf.format( ( D + 2 * warstwy * drut ) * 1000 ) );
            } catch ( Exception ignored ) {
            }
        }
    }
}
