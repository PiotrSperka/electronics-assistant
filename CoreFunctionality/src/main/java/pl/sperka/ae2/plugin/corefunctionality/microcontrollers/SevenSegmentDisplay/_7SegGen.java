package pl.sperka.ae2.plugin.corefunctionality.microcontrollers.SevenSegmentDisplay;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class _7SegGen extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( _7SegGen.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Strings" );
    private final static int OFF = 0;
    private final static int ON = 1;
    private final static int[][] numbers = { { ON, ON, ON, ON, ON, ON, OFF }, { OFF, ON, ON, OFF, OFF, OFF, OFF }, { ON, ON, OFF, ON, ON, OFF, ON }, { ON, ON, ON, ON, OFF, OFF, ON }, { OFF, ON, ON, OFF, OFF, ON, ON }, { ON, OFF, ON, ON, OFF, ON, ON }, { ON, OFF, ON, ON, ON, ON, ON }, { ON, ON, ON, OFF, OFF, OFF, OFF }, { ON, ON, ON, ON, ON, ON, ON }, { ON, ON, ON, ON, OFF, ON, ON } };
    ArrayList< Integer > characters = new ArrayList<>();

    private javax.swing.JComboBox< String > jcbA;
    private javax.swing.JComboBox< String > jcbB;
    private javax.swing.JComboBox< String > jcbC;
    private javax.swing.JComboBox< String > jcbD;
    private javax.swing.JComboBox< String > jcbE;
    private javax.swing.JComboBox< String > jcbF;
    private javax.swing.JComboBox< String > jcbG;
    private javax.swing.JLabel jlInfo;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JTextArea jtaTable;
    private SevenSegmentDisplay ssd1;

    public _7SegGen( Component parent ) {
        initComponents();
        jlInfo.setText( strings.getString( "seven-segment.click-to-change" ) );
        setLocationRelativeTo( parent );
    }

    private void initComponents() {
        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        ssd1 = new SevenSegmentDisplay();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jlInfo = new javax.swing.JLabel();
        javax.swing.JButton jbCustomAdd = new javax.swing.JButton();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        jcbA = new javax.swing.JComboBox<>();
        jcbE = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        jcbB = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        jcbF = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        jcbC = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        jcbG = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        jcbD = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        javax.swing.JButton jbNumbers = new javax.swing.JButton();
        javax.swing.JButton jbClear = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jtaTable = new javax.swing.JTextArea();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        jrb1 = new javax.swing.JRadioButton();
        javax.swing.JRadioButton jrb0 = new javax.swing.JRadioButton();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "seven-segment.title" ) );
        setResizable( false );

        jPanel1.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "seven-segment.custom-character" ) ) );

        jLabel1.setText( "a" );
        jLabel7.setText( "g" );

        javax.swing.GroupLayout ssd1Layout = new javax.swing.GroupLayout( ssd1 );
        ssd1.setLayout( ssd1Layout );
        ssd1Layout.setHorizontalGroup( ssd1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( ssd1Layout.createSequentialGroup().addGap( 51, 51, 51 ).addComponent( jLabel7 ).addContainerGap( 51, Short.MAX_VALUE ) ) );
        ssd1Layout.setVerticalGroup( ssd1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( ssd1Layout.createSequentialGroup().addGap( 57, 57, 57 ).addComponent( jLabel7 ).addContainerGap( 106, Short.MAX_VALUE ) ) );

        jLabel2.setText( "b" );
        jLabel3.setText( "c" );
        jLabel4.setText( "d" );
        jLabel5.setText( "e" );
        jLabel6.setText( "f" );
        jlInfo.setText( strings.getString( "seven-segment.click-on-segment" ) );
        jbCustomAdd.setText( strings.getString( "seven-segment.add-character" ) );
        jbCustomAdd.addActionListener( this::jbCustomAddActionPerformed );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jbCustomAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jlInfo ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING ).addComponent( jLabel5 ).addComponent( jLabel6 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( ssd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel2 ).addComponent( jLabel3 ) ) ).addGroup( jPanel1Layout.createSequentialGroup().addGap( 63, 63, 63 ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jLabel4 ).addComponent( jLabel1 ) ) ) ).addGap( 0, 0, Short.MAX_VALUE ) ) ).addContainerGap() ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jLabel1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( ssd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel1Layout.createSequentialGroup().addGap( 62, 62, 62 ).addComponent( jLabel2 ).addGap( 57, 57, 57 ).addComponent( jLabel3 ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ) ).addGroup( javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap( 62, 62, 62 ).addComponent( jLabel6 ).addGap( 57, 57, 57 ).addComponent( jLabel5 ).addGap( 50, 50, 50 ) ) ).addComponent( jLabel4 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( jbCustomAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        jPanel2.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "seven-segment.display-to-port-connection" ) ) );

        jLabel8.setText( "a" );
        jcbA.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" } ) );
        jcbA.addActionListener( this::jcbAActionPerformed );

        jcbE.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" } ) );
        jcbE.setSelectedIndex( 4 );
        jcbE.addActionListener( this::jcbEActionPerformed );

        jLabel9.setText( "e" );

        jcbB.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" } ) );
        jcbB.setSelectedIndex( 1 );
        jcbB.addActionListener( this::jcbBActionPerformed );

        jLabel10.setText( "b" );

        jcbF.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" } ) );
        jcbF.setSelectedIndex( 5 );
        jcbF.addActionListener( this::jcbFActionPerformed );

        jLabel11.setText( "f" );

        jcbC.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" } ) );
        jcbC.setSelectedIndex( 2 );
        jcbC.addActionListener( this::jcbCActionPerformed );

        jLabel12.setText( "c" );

        jcbG.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" } ) );
        jcbG.setSelectedIndex( 6 );
        jcbG.addActionListener( this::jcbGActionPerformed );

        jLabel13.setText( "g" );

        jcbD.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "P.0", "P.1", "P.2", "P.3", "P.4", "P.5", "P.6", "P.7" } ) );
        jcbD.setSelectedIndex( 3 );
        jcbD.addActionListener( this::jcbDActionPerformed );

        jLabel14.setText( "d" );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jLabel8 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jcbA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( jLabel10 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jcbB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( jLabel12 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jcbC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jLabel9 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jcbE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel11 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jcbF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( jLabel13 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jcbG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( jLabel14 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jcbD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel2Layout.setVerticalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jcbD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jcbC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jcbB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jcbA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jcbG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jcbF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jcbE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        jbNumbers.setText( strings.getString( "seven-segment.add-numbers" ) );
        jbNumbers.addActionListener( this::jbNumbersActionPerformed );

        jbClear.setText( strings.getString( "seven-segment.clear" ) );
        jbClear.addActionListener( this::jbClearActionPerformed );

        jtaTable.setEditable( false );
        jtaTable.setColumns( 20 );
        jtaTable.setFont( new java.awt.Font( "Monospaced", Font.PLAIN, 12 ) );
        jtaTable.setLineWrap( true );
        jtaTable.setRows( 5 );
        jtaTable.setWrapStyleWord( true );
        jScrollPane1.setViewportView( jtaTable );

        jPanel3.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "seven-segment.segment-is-on-for-1-or-0" ) ) );

        buttonGroup1.add( jrb1 );
        jrb1.setSelected( true );
        jrb1.setText( "\"1\"" );
        jrb1.addActionListener( this::jrb1ActionPerformed );

        buttonGroup1.add( jrb0 );
        jrb0.setText( "\"0\"" );
        jrb0.addActionListener( this::jrb0ActionPerformed );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout( jPanel3 );
        jPanel3.setLayout( jPanel3Layout );
        jPanel3Layout.setHorizontalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addContainerGap().addComponent( jrb1 ).addGap( 18, 18, 18 ).addComponent( jrb0 ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel3Layout.setVerticalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jrb1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrb0, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jScrollPane1 ).addGroup( layout.createSequentialGroup().addComponent( jbNumbers ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jbClear ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGroup( layout.createSequentialGroup().addComponent( jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jbNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jbClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private boolean checkPins() {
        boolean t = true;
        int[] connections = getConnections();
        for ( int i = 0; i < 6; i++ ) {
            for ( int j = i + 1; j < 7; j++ ) {
                if ( connections[i] == connections[j] ) {
                    t = false;
                    break;
                }
            }
            if ( !t ) break;
        }
        return t;
    }

    private void parseTable() {
        if ( checkPins() ) {
            jtaTable.setText( null );
            jtaTable.append( "const unsigned char _7Seg[] = {" );
            int[] connections = getConnections();
            for ( int i = 0; i < characters.size(); i++ ) {
                int temp = 0;
                int ch = Integer.parseInt( characters.get( i ).toString() );
                for ( int j = 0; j < 7; j++ ) {
                    if ( jrb1.isSelected() ) temp += ( ( ( ch & ( 1 << j ) ) >> j ) << ( connections[j] ) );
                    else temp += ( ( ( ( ch & ( 1 << j ) ) >> j ) ^ 1 ) << ( connections[j] ) );
                }
                jtaTable.append( "0x" + Integer.toHexString( 0x100 | temp ).substring( 1 ) );
                if ( i < characters.size() - 1 ) jtaTable.append( ", " );
            }
            jtaTable.append( "};" );
        } else {
            jtaTable.setText( strings.getString( "seven-segment.wrong-pin-assignment" ) );
        }
    }

    private int[] getConnections() {
        int[] tab = new int[7];
        tab[0] = jcbA.getSelectedIndex();
        tab[1] = jcbB.getSelectedIndex();
        tab[2] = jcbC.getSelectedIndex();
        tab[3] = jcbD.getSelectedIndex();
        tab[4] = jcbE.getSelectedIndex();
        tab[5] = jcbF.getSelectedIndex();
        tab[6] = jcbG.getSelectedIndex();
        return tab;
    }

    private void jbClearActionPerformed( java.awt.event.ActionEvent evt ) {
        jtaTable.setText( null );
        characters.clear();
    }

    private void jbNumbersActionPerformed( java.awt.event.ActionEvent evt ) {
        for ( int i = 0; i < 10; i++ ) {
            int temp = 0;
            for ( int j = 0; j < 7; j++ ) {
                temp += ( ( numbers[i][j] ) << j );
            }
            characters.add( temp );
        }
        parseTable();
    }

    private void jbCustomAddActionPerformed( java.awt.event.ActionEvent evt ) {
        int[] ch = ssd1.getSegments();
        int temp = 0;
        for ( int i = 0; i < 7; i++ ) {
            temp += ( ( ch[i] ) << i );
        }
        characters.add( temp );
        parseTable();
    }

    private void jrb1ActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jrb0ActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jcbAActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jcbBActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jcbCActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jcbDActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jcbEActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jcbFActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }

    private void jcbGActionPerformed( java.awt.event.ActionEvent evt ) {
        parseTable();
    }
}
