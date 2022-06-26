package pl.sperka.ae2.plugin.corefunctionality.circuits;

/*
 * Created on 2011-12-16, 12:58:42
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
public class NE555 extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( NE555.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.circuits.Strings" );
    int lock = 0;
    private javax.swing.JComboBox< String > cbAst1C1;
    private javax.swing.JComboBox< String > cbAst1R1;
    private javax.swing.JComboBox< String > cbAst1f;
    private javax.swing.JComboBox< String > cbAst2C1;
    private javax.swing.JComboBox< String > cbAst2R1;
    private javax.swing.JComboBox< String > cbAst2R2;
    private javax.swing.JComboBox< String > cbAst2f;
    private javax.swing.JComboBox< String > cbAst3C1;
    private javax.swing.JComboBox< String > cbAst3R1;
    private javax.swing.JComboBox< String > cbAst3R2;
    private javax.swing.JComboBox< String > cbAst3f;
    private javax.swing.JComboBox< String > cbMonC1;
    private javax.swing.JComboBox< String > cbMonImp;
    private javax.swing.JComboBox< String > cbMonR1;
    private javax.swing.JPanel jpAst1Pict;
    private javax.swing.JPanel jpAst2Pict;
    private javax.swing.JPanel jpAst3Pict;
    private javax.swing.JPanel jpMonPict;
    private javax.swing.JRadioButton rbAst1Tryb1;
    private javax.swing.JRadioButton rbAst1Tryb2;
    private javax.swing.JRadioButton rbAst2Tryb1;
    private javax.swing.JRadioButton rbAst2Tryb2;
    private javax.swing.JRadioButton rbAst3Tryb1;
    private javax.swing.JRadioButton rbAst3Tryb2;
    private javax.swing.JRadioButton rbMonTryb1;
    private javax.swing.JRadioButton rbMonTryb2;
    private javax.swing.JTextField txtAst1C1;
    private javax.swing.JTextField txtAst1R1;
    private javax.swing.JTextField txtAst1f;
    private javax.swing.JTextField txtAst2C1;
    private javax.swing.JTextField txtAst2R1;
    private javax.swing.JTextField txtAst2R2;
    private javax.swing.JTextField txtAst2Wyp;
    private javax.swing.JTextField txtAst2f;
    private javax.swing.JTextField txtAst3C1;
    private javax.swing.JTextField txtAst3R1;
    private javax.swing.JTextField txtAst3R2;
    private javax.swing.JTextField txtAst3Wyp;
    private javax.swing.JTextField txtAst3f;
    private javax.swing.JTextField txtMonC1;
    private javax.swing.JTextField txtMonImp;
    private javax.swing.JTextField txtMonR1;

    public NE555( Component parent ) {
        initComponents();
        ClassLoader cl = this.getClass().getClassLoader();
        URL url = cl.getResource( "pl/sperka/ae2/plugin/oldclasses/images/ne555mon.jpg" );
        Icon icon = new ImageIcon( url );
        JLabel ne555mon = new JLabel( icon );
        ne555mon.setSize( 200, 190 );
        jpMonPict.add( ne555mon );

        url = cl.getResource( "pl/sperka/ae2/plugin/oldclasses/images/ne555ast1.jpg" );
        icon = new ImageIcon( url );
        JLabel ne555ast1 = new JLabel( icon );
        ne555ast1.setSize( 200, 198 );
        jpAst1Pict.add( ne555ast1 );

        url = cl.getResource( "pl/sperka/ae2/plugin/oldclasses/images/ne555ast2.jpg" );
        icon = new ImageIcon( url );
        JLabel ne555ast2 = new JLabel( icon );
        ne555ast2.setSize( 190, 206 );
        jpAst2Pict.add( ne555ast2 );

        url = cl.getResource( "pl/sperka/ae2/plugin/oldclasses/images/ne555ast3.jpg" );
        icon = new ImageIcon( url );
        JLabel ne555ast3 = new JLabel( icon );
        ne555ast3.setSize( 182, 200 );
        jpAst3Pict.add( ne555ast3 );

        setLocationRelativeTo( parent );
    }

    private void initComponents() {
        ButtonGroup buttonGroup1 = new ButtonGroup();
        ButtonGroup buttonGroup2 = new ButtonGroup();
        ButtonGroup buttonGroup3 = new ButtonGroup();
        ButtonGroup buttonGroup4 = new ButtonGroup();
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel1 = new JPanel();
        JPanel jPanel5 = new JPanel();
        rbMonTryb1 = new javax.swing.JRadioButton();
        rbMonTryb2 = new javax.swing.JRadioButton();
        jpMonPict = new javax.swing.JPanel();
        JLabel jLabel1 = new JLabel();
        txtMonC1 = new javax.swing.JTextField();
        txtMonR1 = new javax.swing.JTextField();
        JLabel jLabel2 = new JLabel();
        txtMonImp = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        cbMonC1 = new javax.swing.JComboBox<>();
        cbMonR1 = new javax.swing.JComboBox<>();
        cbMonImp = new javax.swing.JComboBox<>();
        JPanel jPanel3 = new JPanel();
        txtAst1f = new javax.swing.JTextField();
        txtAst1R1 = new javax.swing.JTextField();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        txtAst1C1 = new javax.swing.JTextField();
        cbAst1C1 = new javax.swing.JComboBox<>();
        cbAst1R1 = new javax.swing.JComboBox<>();
        cbAst1f = new javax.swing.JComboBox<>();
        JPanel jPanel6 = new JPanel();
        rbAst1Tryb1 = new javax.swing.JRadioButton();
        rbAst1Tryb2 = new javax.swing.JRadioButton();
        jpAst1Pict = new javax.swing.JPanel();
        JPanel jPanel2 = new JPanel();
        txtAst2f = new javax.swing.JTextField();
        JLabel jLabel7 = new JLabel();
        cbAst2f = new javax.swing.JComboBox<>();
        jpAst2Pict = new javax.swing.JPanel();
        cbAst2R1 = new javax.swing.JComboBox<>();
        cbAst2C1 = new javax.swing.JComboBox<>();
        JPanel jPanel7 = new JPanel();
        rbAst2Tryb1 = new javax.swing.JRadioButton();
        rbAst2Tryb2 = new javax.swing.JRadioButton();
        txtAst2C1 = new javax.swing.JTextField();
        txtAst2R1 = new javax.swing.JTextField();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        txtAst2Wyp = new javax.swing.JTextField();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel11 = new JLabel();
        txtAst2R2 = new javax.swing.JTextField();
        JLabel jLabel12 = new JLabel();
        cbAst2R2 = new javax.swing.JComboBox<>();
        JPanel jPanel4 = new JPanel();
        JLabel jLabel13 = new JLabel();
        txtAst3Wyp = new javax.swing.JTextField();
        JLabel jLabel14 = new JLabel();
        jpAst3Pict = new javax.swing.JPanel();
        cbAst3f = new javax.swing.JComboBox<>();
        cbAst3R2 = new javax.swing.JComboBox<>();
        cbAst3R1 = new javax.swing.JComboBox<>();
        cbAst3C1 = new javax.swing.JComboBox<>();
        JLabel jLabel15 = new JLabel();
        JLabel jLabel16 = new JLabel();
        JLabel jLabel17 = new JLabel();
        JLabel jLabel18 = new JLabel();
        txtAst3C1 = new javax.swing.JTextField();
        txtAst3R1 = new javax.swing.JTextField();
        txtAst3R2 = new javax.swing.JTextField();
        txtAst3f = new javax.swing.JTextField();
        JPanel jPanel8 = new JPanel();
        rbAst3Tryb1 = new javax.swing.JRadioButton();
        rbAst3Tryb2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "ne555.title" ) );
        setResizable( false );

        jPanel5.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "ne555.calculate" ) ) );

        buttonGroup1.add( rbMonTryb1 );
        rbMonTryb1.setSelected( true );
        rbMonTryb1.setText( strings.getString( "ne555.pulse-time-knowing-r1-and-c1" ) );
        rbMonTryb1.addItemListener( this::rbMonTryb1ItemStateChanged );

        buttonGroup1.add( rbMonTryb2 );
        rbMonTryb2.setText( strings.getString( "ne555.r1-knowing-pulse-time-and-c1" ) );
        rbMonTryb2.addItemListener( this::rbMonTryb2ItemStateChanged );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout( jPanel5 );
        jPanel5.setLayout( jPanel5Layout );
        jPanel5Layout.setHorizontalGroup( jPanel5Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel5Layout.createSequentialGroup().addContainerGap().addGroup( jPanel5Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( rbMonTryb1 ).addComponent( rbMonTryb2 ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel5Layout.setVerticalGroup( jPanel5Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel5Layout.createSequentialGroup().addContainerGap().addComponent( rbMonTryb1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( rbMonTryb2 ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        javax.swing.GroupLayout jpMonPictLayout = new javax.swing.GroupLayout( jpMonPict );
        jpMonPict.setLayout( jpMonPictLayout );
        jpMonPictLayout.setHorizontalGroup( jpMonPictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 225, Short.MAX_VALUE ) );
        jpMonPictLayout.setVerticalGroup( jpMonPictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 200, Short.MAX_VALUE ) );

        jLabel1.setText( "C1" );

        txtMonC1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMonC1KeyReleased( evt );
            }
        } );

        txtMonR1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMonR1KeyReleased( evt );
            }
        } );

        jLabel2.setText( "R1" );

        txtMonImp.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtMonImpKeyReleased( evt );
            }
        } );

        jLabel3.setText( strings.getString( "ne555.pulse-time" ) );

        cbMonC1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "uF", "nF", "pF" } ) );
        cbMonC1.addItemListener( this::cbMonC1ItemStateChanged );

        cbMonR1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Ohm", "kOhm", "MOhm" } ) );
        cbMonR1.addItemListener( this::cbMonR1ItemStateChanged );

        cbMonImp.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "s", "ms", "us" } ) );
        cbMonImp.addItemListener( this::cbMonImpItemStateChanged );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent( jLabel3 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtMonImp, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE ) ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( jLabel2 ).addComponent( jLabel1 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( txtMonC1 ).addComponent( txtMonR1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE ) ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( cbMonR1, 0, 125, Short.MAX_VALUE ).addComponent( cbMonImp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( cbMonC1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) ).addComponent( jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jpMonPict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 5, 5, 5 ) ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addComponent( jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtMonC1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( cbMonC1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtMonR1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbMonR1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtMonImp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addGroup( jPanel1Layout.createSequentialGroup().addGap( 6, 6, 6 ).addComponent( cbMonImp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) ).addGroup( jPanel1Layout.createSequentialGroup().addGap( 19, 19, 19 ).addComponent( jpMonPict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( 93, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "ne555.monostable" ), jPanel1 );

        txtAst1f.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst1fKeyReleased( evt );
            }
        } );

        txtAst1R1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst1R1KeyReleased( evt );
            }
        } );

        jLabel4.setText( strings.getString( "ne555.frequency" ) );

        jLabel5.setText( "R1" );

        jLabel6.setText( "C1" );

        txtAst1C1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst1C1KeyReleased( evt );
            }
        } );

        cbAst1C1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "uF", "nF", "pF" } ) );
        cbAst1C1.setMinimumSize( new java.awt.Dimension( 0, 0 ) );
        cbAst1C1.addItemListener( this::cbAst1C1ItemStateChanged );

        cbAst1R1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Ohm", "kOhm", "MOhm" } ) );
        cbAst1R1.setMinimumSize( new java.awt.Dimension( 0, 0 ) );
        cbAst1R1.addItemListener( this::cbAst1R1ItemStateChanged );

        cbAst1f.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Hz", "kHz" } ) );
        cbAst1f.setMinimumSize( new java.awt.Dimension( 0, 0 ) );
        cbAst1f.addItemListener( this::cbAst1fItemStateChanged );

        jPanel6.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "ne555.calculate" ) ) );

        buttonGroup2.add( rbAst1Tryb1 );
        rbAst1Tryb1.setSelected( true );
        rbAst1Tryb1.setText( strings.getString( "ne555.frequency-knowing-r1-and-c1" ) );
        rbAst1Tryb1.addItemListener( this::rbAst1Tryb1ItemStateChanged );

        buttonGroup2.add( rbAst1Tryb2 );
        rbAst1Tryb2.setText( strings.getString( "ne555.r1-knowing-frequency-and-c1" ) );
        rbAst1Tryb2.addItemListener( this::rbAst1Tryb2ItemStateChanged );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout( jPanel6 );
        jPanel6.setLayout( jPanel6Layout );
        jPanel6Layout.setHorizontalGroup( jPanel6Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel6Layout.createSequentialGroup().addContainerGap().addGroup( jPanel6Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( rbAst1Tryb1 ).addComponent( rbAst1Tryb2 ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel6Layout.setVerticalGroup( jPanel6Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel6Layout.createSequentialGroup().addContainerGap().addComponent( rbAst1Tryb1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( rbAst1Tryb2 ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        javax.swing.GroupLayout jpAst1PictLayout = new javax.swing.GroupLayout( jpAst1Pict );
        jpAst1Pict.setLayout( jpAst1PictLayout );
        jpAst1PictLayout.setHorizontalGroup( jpAst1PictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 201, Short.MAX_VALUE ) );
        jpAst1PictLayout.setVerticalGroup( jpAst1PictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 200, Short.MAX_VALUE ) );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout( jPanel3 );
        jPanel3.setLayout( jPanel3Layout );
        jPanel3Layout.setHorizontalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addContainerGap().addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addComponent( jLabel4 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtAst1f, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE ) ).addGroup( jPanel3Layout.createSequentialGroup().addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( jLabel5 ).addComponent( jLabel6 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( txtAst1C1 ).addComponent( txtAst1R1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE ) ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( cbAst1R1, 0, 159, Short.MAX_VALUE ).addComponent( cbAst1f, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( cbAst1C1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) ).addComponent( jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jpAst1Pict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 5, 5, 5 ) ) );
        jPanel3Layout.setVerticalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addContainerGap().addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jpAst1Pict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGroup( jPanel3Layout.createSequentialGroup().addComponent( jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtAst1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( cbAst1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst1R1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbAst1R1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst1f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addGroup( jPanel3Layout.createSequentialGroup().addGap( 6, 6, 6 ).addComponent( cbAst1f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) ) ).addContainerGap( 93, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "ne555.astable-generator-50" ), jPanel3 );

        txtAst2f.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst2fKeyReleased( evt );
            }
        } );

        jLabel7.setText( strings.getString( "ne555.frequency" ) );

        cbAst2f.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Hz", "kHz" } ) );
        cbAst2f.addItemListener( this::cbAst2fItemStateChanged );

        javax.swing.GroupLayout jpAst2PictLayout = new javax.swing.GroupLayout( jpAst2Pict );
        jpAst2Pict.setLayout( jpAst2PictLayout );
        jpAst2PictLayout.setHorizontalGroup( jpAst2PictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 229, Short.MAX_VALUE ) );
        jpAst2PictLayout.setVerticalGroup( jpAst2PictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 0, Short.MAX_VALUE ) );

        cbAst2R1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Ohm", "kOhm", "MOhm" } ) );
        cbAst2R1.addItemListener( this::cbAst2R1ItemStateChanged );

        cbAst2C1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "uF", "nF", "pF" } ) );
        cbAst2C1.addItemListener( this::cbAst2C1ItemStateChanged );

        jPanel7.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "ne555.calculate" ) ) );

        buttonGroup3.add( rbAst2Tryb1 );
        rbAst2Tryb1.setSelected( true );
        rbAst2Tryb1.setText( strings.getString( "ne555.frequency-and-duty-cycle-knowing-r1-r2-and-c1" ) );
        rbAst2Tryb1.addItemListener( this::rbAst2Tryb1ItemStateChanged );

        buttonGroup3.add( rbAst2Tryb2 );
        rbAst2Tryb2.setText( strings.getString( "ne555.r1-and-r2-knowing-frequency-duty-cycle-and-c1" ) );
        rbAst2Tryb2.addItemListener( this::rbAst2Tryb2ItemStateChanged );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout( jPanel7 );
        jPanel7.setLayout( jPanel7Layout );
        jPanel7Layout.setHorizontalGroup( jPanel7Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel7Layout.createSequentialGroup().addContainerGap().addGroup( jPanel7Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( rbAst2Tryb1 ).addComponent( rbAst2Tryb2 ) ).addContainerGap( 23, Short.MAX_VALUE ) ) );
        jPanel7Layout.setVerticalGroup( jPanel7Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel7Layout.createSequentialGroup().addContainerGap().addComponent( rbAst2Tryb1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( rbAst2Tryb2 ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        txtAst2C1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst2C1KeyReleased( evt );
            }
        } );

        txtAst2R1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst2R1KeyReleased( evt );
            }
        } );

        jLabel8.setText( "R1" );
        jLabel9.setText( "C1" );

        txtAst2Wyp.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst2WypKeyReleased( evt );
            }
        } );

        jLabel10.setText( strings.getString( "ne555.duty-cycle" ) );
        jLabel11.setText( "%" );

        txtAst2R2.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst2R2KeyReleased( evt );
            }
        } );

        jLabel12.setText( "R2" );

        cbAst2R2.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Ohm", "kOhm", "MOhm" } ) );
        cbAst2R2.addItemListener( this::cbAst2R2ItemStateChanged );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( jLabel12 ).addComponent( jLabel8 ).addComponent( jLabel9 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( txtAst2C1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE ).addComponent( txtAst2R1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE ).addComponent( txtAst2R2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE ) ) ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent( jLabel10 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtAst2Wyp, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE ) ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent( jLabel7 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtAst2f, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel11 ).addComponent( cbAst2R1, 0, 95, Short.MAX_VALUE ).addComponent( cbAst2C1, 0, 95, Short.MAX_VALUE ).addComponent( cbAst2R2, 0, 95, Short.MAX_VALUE ).addComponent( cbAst2f, 0, 95, Short.MAX_VALUE ) ) ).addComponent( jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jpAst2Pict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap() ) );
        jPanel2Layout.setVerticalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false ).addComponent( jpAst2Pict, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent( jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtAst2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( cbAst2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst2R1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbAst2R1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst2R2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbAst2R2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst2f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbAst2f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst2Wyp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "ne555.astable-generator-over-50" ), jPanel2 );

        jLabel13.setText( strings.getString( "ne555.duty-cycle" ) );

        txtAst3Wyp.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst3WypKeyReleased( evt );
            }
        } );

        jLabel14.setText( "%" );

        javax.swing.GroupLayout jpAst3PictLayout = new javax.swing.GroupLayout( jpAst3Pict );
        jpAst3Pict.setLayout( jpAst3PictLayout );
        jpAst3PictLayout.setHorizontalGroup( jpAst3PictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 195, Short.MAX_VALUE ) );
        jpAst3PictLayout.setVerticalGroup( jpAst3PictLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 0, Short.MAX_VALUE ) );

        cbAst3f.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Hz", "kHz" } ) );
        cbAst3f.addItemListener( this::cbAst3fItemStateChanged );

        cbAst3R2.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Ohm", "kOhm", "MOhm" } ) );
        cbAst3R2.addItemListener( this::cbAst3R2ItemStateChanged );

        cbAst3R1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "Ohm", "kOhm", "MOhm" } ) );
        cbAst3R1.addItemListener( this::cbAst3R1ItemStateChanged );

        cbAst3C1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "uF", "nF", "pF" } ) );
        cbAst3C1.addItemListener( this::cbAst3C1ItemStateChanged );

        jLabel15.setText( strings.getString( "ne555.frequency" ) );
        jLabel16.setText( "R2" );
        jLabel17.setText( "R1" );
        jLabel18.setText( "C1" );

        txtAst3C1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst3C1KeyReleased( evt );
            }
        } );

        txtAst3R1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst3R1KeyReleased( evt );
            }
        } );

        txtAst3R2.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst3R2KeyReleased( evt );
            }
        } );

        txtAst3f.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                txtAst3fKeyReleased( evt );
            }
        } );

        jPanel8.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "ne555.calculate" ) ) );

        buttonGroup4.add( rbAst3Tryb1 );
        rbAst3Tryb1.setSelected( true );
        rbAst3Tryb1.setText( strings.getString( "ne555.frequency-and-duty-cycle-knowing-r1-r2-and-c1" ) );
        rbAst3Tryb1.addItemListener( this::rbAst3Tryb1ItemStateChanged );

        buttonGroup4.add( rbAst3Tryb2 );
        rbAst3Tryb2.setText( strings.getString( "ne555.r1-and-r2-knowing-frequency-duty-cycle-and-c1" ) );
        rbAst3Tryb2.addItemListener( this::rbAst3Tryb2ItemStateChanged );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout( jPanel8 );
        jPanel8.setLayout( jPanel8Layout );
        jPanel8Layout.setHorizontalGroup( jPanel8Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel8Layout.createSequentialGroup().addContainerGap().addGroup( jPanel8Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( rbAst3Tryb1 ).addComponent( rbAst3Tryb2 ) ).addContainerGap( 57, Short.MAX_VALUE ) ) );
        jPanel8Layout.setVerticalGroup( jPanel8Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel8Layout.createSequentialGroup().addContainerGap().addComponent( rbAst3Tryb1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( rbAst3Tryb2 ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout( jPanel4 );
        jPanel4.setLayout( jPanel4Layout );
        jPanel4Layout.setHorizontalGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addContainerGap().addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( txtAst3C1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE ).addComponent( txtAst3R1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE ).addComponent( txtAst3R2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE ) ) ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addComponent( jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtAst3Wyp, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE ) ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addComponent( jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( txtAst3f, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( cbAst3R1, 0, 126, Short.MAX_VALUE ).addComponent( cbAst3C1, 0, 126, Short.MAX_VALUE ).addComponent( cbAst3R2, 0, 126, Short.MAX_VALUE ).addComponent( cbAst3f, 0, 126, Short.MAX_VALUE ) ) ).addComponent( jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jpAst3Pict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap() ) );
        jPanel4Layout.setVerticalGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addContainerGap().addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false ).addComponent( jpAst3Pict, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup().addComponent( jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( txtAst3C1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addComponent( cbAst3C1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst3R1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbAst3R1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst3R2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbAst3R2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst3f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbAst3f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( txtAst3Wyp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "ne555.astable-generator-0-to-100" ), jPanel4 );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jTabbedPane1 ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private void txtMonC1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczMon();
    }

    private void txtMonR1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczMon();
    }

    private void txtMonImpKeyReleased( java.awt.event.KeyEvent evt ) {
        liczMon();
    }

    private void rbMonTryb1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczMon();
    }

    private void rbMonTryb2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczMon();
    }

    private void cbMonC1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczMon();
    }

    private void cbMonR1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczMon();
    }

    private void cbMonImpItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczMon();
    }

    private void txtAst1fKeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst1();
    }

    private void txtAst1R1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst1();
    }

    private void txtAst1C1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst1();
    }

    private void cbAst1C1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst1();
    }

    private void cbAst1R1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst1();
    }

    private void cbAst1fItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst1();
    }

    private void rbAst1Tryb1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczAst1();
    }

    private void rbAst1Tryb2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczAst1();
    }

    private void txtAst2fKeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst2();
    }

    private void cbAst2fItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst2();
    }

    private void cbAst2R1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst2();
    }

    private void cbAst2C1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst2();
    }

    private void rbAst2Tryb1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczAst2();
    }

    private void rbAst2Tryb2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczAst2();
    }

    private void txtAst2C1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst2();
    }

    private void txtAst2R1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst2();
    }

    private void txtAst2WypKeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst2();
    }

    private void txtAst2R2KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst2();
    }

    private void cbAst2R2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst2();
    }

    private void txtAst3WypKeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst3();
    }

    private void cbAst3fItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst3();
    }

    private void cbAst3R2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst3();
    }

    private void cbAst3R1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst3();
    }

    private void cbAst3C1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( lock == 0 ) liczAst3();
    }

    private void txtAst3C1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst3();
    }

    private void txtAst3R1KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst3();
    }

    private void txtAst3R2KeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst3();
    }

    private void txtAst3fKeyReleased( java.awt.event.KeyEvent evt ) {
        liczAst3();
    }

    private void rbAst3Tryb1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczAst3();
    }

    private void rbAst3Tryb2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        liczAst3();
    }

    private void liczAst3() {
        double R1, R2, C1, f, wyp;
        lock = 1;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( rbAst3Tryb1.isSelected() && !txtAst3R1.getText().isEmpty() && !txtAst3R2.getText().isEmpty() && !txtAst3C1.getText().isEmpty() ) {
                R1 = nf.parse( txtAst3R1.getText() ).doubleValue();
                R2 = nf.parse( txtAst3R2.getText() ).doubleValue();
                C1 = nf.parse( txtAst3C1.getText() ).doubleValue();
                if ( cbAst3R1.getSelectedItem().toString().equals( "kOhm" ) ) R1 *= 1e3;
                else if ( cbAst3R1.getSelectedItem().toString().equals( "MOhm" ) ) R1 *= 1e6;
                if ( cbAst3R2.getSelectedItem().toString().equals( "kOhm" ) ) R2 *= 1e3;
                else if ( cbAst3R2.getSelectedItem().toString().equals( "MOhm" ) ) R2 *= 1e6;
                if ( cbAst3C1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbAst3C1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbAst3C1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                f = 1 / ( 0.693 * C1 * ( R1 + R2 ) );
                wyp = R1 / ( R1 + R2 );
                txtAst3Wyp.setText( nf.format( wyp * 100 ) );
                if ( f >= 1e3 ) {
                    txtAst3f.setText( nf.format( f * 1e-3 ) );
                    cbAst3f.setSelectedIndex( 1 );
                } else if ( f < 1e3 ) {
                    txtAst3f.setText( nf.format( f ) );
                    cbAst3f.setSelectedIndex( 0 );
                }
            } else if ( rbAst3Tryb2.isSelected() && !txtAst3f.getText().isEmpty() && !txtAst3C1.getText().isEmpty() ) {
                f = nf.parse( txtAst3f.getText() ).doubleValue();
                wyp = nf.parse( txtAst3Wyp.getText() ).doubleValue();
                C1 = nf.parse( txtAst3C1.getText() ).doubleValue();
                if ( cbAst3f.getSelectedItem().toString().equals( "kHz" ) ) f *= 1e3;
                if ( cbAst3C1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbAst3C1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbAst3C1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                R2 = ( ( 100 - wyp ) / 100 ) / ( 0.693 * C1 * f );
                R1 = ( wyp / 100 ) / ( 0.693 * C1 * f );
                if ( R1 >= 1e6 ) {
                    txtAst3R1.setText( nf.format( R1 * 1e-6 ) );
                    cbAst3R1.setSelectedIndex( 2 );
                } else if ( R1 < 1e6 && R1 >= 1e3 ) {
                    txtAst3R1.setText( nf.format( R1 * 1e-3 ) );
                    cbAst3R1.setSelectedIndex( 1 );
                } else if ( R1 < 1e3 ) {
                    txtAst3R1.setText( nf.format( R1 ) );
                    cbAst3R1.setSelectedIndex( 0 );
                }
                if ( R2 >= 1e6 ) {
                    txtAst3R2.setText( nf.format( R2 * 1e-6 ) );
                    cbAst3R2.setSelectedIndex( 2 );
                } else if ( R2 < 1e6 && R2 >= 1e3 ) {
                    txtAst3R2.setText( nf.format( R2 * 1e-3 ) );
                    cbAst3R2.setSelectedIndex( 1 );
                } else if ( R2 < 1e3 ) {
                    txtAst3R2.setText( nf.format( R2 ) );
                    cbAst3R2.setSelectedIndex( 0 );
                }
            }
            lock = 0;
        } catch ( Exception ignored ) {
        }
    }

    private void liczAst2() {
        double R1, R2, C1, f, wyp;
        lock = 1;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( rbAst2Tryb1.isSelected() && !txtAst2R1.getText().isEmpty() && !txtAst2R2.getText().isEmpty() && !txtAst2C1.getText().isEmpty() ) {
                R1 = nf.parse( txtAst2R1.getText() ).doubleValue();
                R2 = nf.parse( txtAst2R2.getText() ).doubleValue();
                C1 = nf.parse( txtAst2C1.getText() ).doubleValue();
                if ( cbAst2R1.getSelectedItem().toString().equals( "kOhm" ) ) R1 *= 1e3;
                else if ( cbAst2R1.getSelectedItem().toString().equals( "MOhm" ) ) R1 *= 1e6;
                if ( cbAst2R2.getSelectedItem().toString().equals( "kOhm" ) ) R2 *= 1e3;
                else if ( cbAst2R2.getSelectedItem().toString().equals( "MOhm" ) ) R2 *= 1e6;
                if ( cbAst2C1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbAst2C1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbAst2C1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                f = 1.44 / ( ( R1 + ( 2 * R2 ) ) * C1 );
                wyp = ( 0.693 * ( R1 + R2 ) * C1 ) / ( 0.693 * ( R1 + ( 2 * R2 ) ) * C1 );
                txtAst2Wyp.setText( nf.format( wyp * 100 ) );
                if ( f >= 1e3 ) {
                    txtAst2f.setText( nf.format( f * 1e-3 ) );
                    cbAst2f.setSelectedIndex( 1 );
                } else if ( f < 1e3 ) {
                    txtAst2f.setText( nf.format( f ) );
                    cbAst2f.setSelectedIndex( 0 );
                }
            } else if ( rbAst2Tryb2.isSelected() && !txtAst2f.getText().isEmpty() && !txtAst2C1.getText().isEmpty() ) {
                f = nf.parse( txtAst2f.getText() ).doubleValue();
                wyp = nf.parse( txtAst2Wyp.getText() ).doubleValue();
                C1 = nf.parse( txtAst2C1.getText() ).doubleValue();
                if ( cbAst2f.getSelectedItem().toString().equals( "kHz" ) ) f *= 1e3;
                if ( cbAst2C1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbAst2C1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbAst2C1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                R2 = ( ( 100 - wyp ) / ( 100 * f ) ) / ( 0.693 * C1 );
                R1 = ( 1.44 / f / C1 ) - 2 * R2;
                if ( R1 >= 1e6 ) {
                    txtAst2R1.setText( nf.format( R1 * 1e-6 ) );
                    cbAst2R1.setSelectedIndex( 2 );
                } else if ( R1 < 1e6 && R1 >= 1e3 ) {
                    txtAst2R1.setText( nf.format( R1 * 1e-3 ) );
                    cbAst2R1.setSelectedIndex( 1 );
                } else if ( R1 < 1e3 ) {
                    txtAst2R1.setText( nf.format( R1 ) );
                    cbAst2R1.setSelectedIndex( 0 );
                }
                if ( R2 >= 1e6 ) {
                    txtAst2R2.setText( nf.format( R2 * 1e-6 ) );
                    cbAst2R2.setSelectedIndex( 2 );
                } else if ( R2 < 1e6 && R2 >= 1e3 ) {
                    txtAst2R2.setText( nf.format( R2 * 1e-3 ) );
                    cbAst2R2.setSelectedIndex( 1 );
                } else if ( R2 < 1e3 ) {
                    txtAst2R2.setText( nf.format( R2 ) );
                    cbAst2R2.setSelectedIndex( 0 );
                }
            }
            lock = 0;
        } catch ( Exception ignored ) {
        }
    }

    private void liczAst1() {
        double R1, C1, f;
        lock = 1;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( rbAst1Tryb1.isSelected() && !txtAst1R1.getText().isEmpty() && !txtAst1C1.getText().isEmpty() ) {
                R1 = nf.parse( txtAst1R1.getText() ).doubleValue();
                C1 = nf.parse( txtAst1C1.getText() ).doubleValue();
                if ( cbAst1R1.getSelectedItem().toString().equals( "kOhm" ) ) R1 *= 1e3;
                else if ( cbAst1R1.getSelectedItem().toString().equals( "MOhm" ) ) R1 *= 1e6;
                if ( cbAst1C1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbAst1C1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbAst1C1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                f = 1 / ( 1.386 * R1 * C1 );
                if ( f >= 1e3 ) {
                    txtAst1f.setText( nf.format( f * 1e-3 ) );
                    cbAst1f.setSelectedIndex( 1 );
                } else if ( f < 1e3 ) {
                    txtAst1f.setText( nf.format( f ) );
                    cbAst1f.setSelectedIndex( 0 );
                }
            } else if ( rbAst1Tryb2.isSelected() && !txtAst1f.getText().isEmpty() && !txtAst1C1.getText().isEmpty() ) {
                f = nf.parse( txtAst1f.getText() ).doubleValue();
                C1 = nf.parse( txtAst1C1.getText() ).doubleValue();
                if ( cbAst1f.getSelectedItem().toString().equals( "kHz" ) ) f *= 1e3;
                if ( cbAst1C1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbAst1C1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbAst1C1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                R1 = 1 / ( 1.386 * f * C1 );
                if ( R1 >= 1e6 ) {
                    txtAst1R1.setText( nf.format( R1 * 1e-6 ) );
                    cbAst1R1.setSelectedIndex( 2 );
                } else if ( R1 < 1e6 && R1 >= 1e3 ) {
                    txtAst1R1.setText( nf.format( R1 * 1e-3 ) );
                    cbAst1R1.setSelectedIndex( 1 );
                } else if ( R1 < 1e3 ) {
                    txtAst1R1.setText( nf.format( R1 ) );
                    cbAst1R1.setSelectedIndex( 0 );
                }
            }
            lock = 0;
        } catch ( Exception ignored ) {
        }
    }

    private void liczMon() {
        double R1, C1, imp;
        lock = 1;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            if ( rbMonTryb1.isSelected() && !txtMonR1.getText().isEmpty() && !txtMonC1.getText().isEmpty() ) {
                R1 = nf.parse( txtMonR1.getText() ).doubleValue();
                C1 = nf.parse( txtMonC1.getText() ).doubleValue();
                if ( cbMonR1.getSelectedItem().toString().equals( "kOhm" ) ) R1 *= 1e3;
                else if ( cbMonR1.getSelectedItem().toString().equals( "MOhm" ) ) R1 *= 1e6;
                if ( cbMonC1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbMonC1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbMonC1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                imp = 1.1 * R1 * C1;
                if ( imp >= 1 ) {
                    txtMonImp.setText( nf.format( imp ) );
                    cbMonImp.setSelectedIndex( 0 );
                } else if ( imp < 1 && imp >= 1e-3 ) {
                    txtMonImp.setText( nf.format( imp * 1e3 ) );
                    cbMonImp.setSelectedIndex( 1 );
                } else if ( imp < 1e-3 ) {
                    txtMonImp.setText( nf.format( imp * 1e6 ) );
                    cbMonImp.setSelectedIndex( 2 );
                }
            } else if ( rbMonTryb2.isSelected() && !txtMonImp.getText().isEmpty() && !txtMonC1.getText().isEmpty() ) {
                imp = nf.parse( txtMonImp.getText() ).doubleValue();
                C1 = nf.parse( txtMonC1.getText() ).doubleValue();
                if ( cbMonImp.getSelectedItem().toString().equals( "ms" ) ) imp *= 1e-3;
                else if ( cbMonImp.getSelectedItem().toString().equals( "us" ) ) imp *= 1e-6;
                if ( cbMonC1.getSelectedItem().toString().equals( "uF" ) ) C1 *= 1e-6;
                else if ( cbMonC1.getSelectedItem().toString().equals( "nF" ) ) C1 *= 1e-9;
                else if ( cbMonC1.getSelectedItem().toString().equals( "pF" ) ) C1 *= 1e-12;
                R1 = imp / ( 1.1 * C1 );
                if ( R1 >= 1e6 ) {
                    txtMonR1.setText( nf.format( R1 * 1e-6 ) );
                    cbMonR1.setSelectedIndex( 2 );
                } else if ( R1 < 1e6 && R1 >= 1e3 ) {
                    txtMonR1.setText( nf.format( R1 * 1e-3 ) );
                    cbMonR1.setSelectedIndex( 1 );
                } else if ( R1 < 1e3 ) {
                    txtMonR1.setText( nf.format( R1 ) );
                    cbMonR1.setSelectedIndex( 0 );
                }
            }
            lock = 0;
        } catch ( Exception ignored ) {
        }
    }
}
