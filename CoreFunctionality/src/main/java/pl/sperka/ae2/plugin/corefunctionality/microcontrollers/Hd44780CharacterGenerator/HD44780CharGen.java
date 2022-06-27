package pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Hd44780CharacterGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugin.corefunctionality.microcontrollers.SevenSegmentDisplay._7SegGen;
import pl.sperka.ae2.plugins.ICore;

import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class HD44780CharGen extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( _7SegGen.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Strings" );
    private HD44780CharCell LcdCell;
    private HD44780SmallCharCell LcdPreview;
    private javax.swing.JLabel jlInfo;
    private javax.swing.JTextArea jtaResult;

    public HD44780CharGen( ICore core ) {
        initComponents();
        LcdCell.setPreview( LcdPreview );
        jlInfo.setText( strings.getString( "hd44780-char-gen.click-to-change" ) );
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void showData() {
        int[] tmp = LcdCell.getData();
        StringBuilder s = new StringBuilder();
        for ( int i = 0; i < tmp.length; i++ ) {
            s.append( "0x" ).append( Integer.toHexString( 0x100 | (int) tmp[i] ).substring( 1 ) );
            if ( i != tmp.length - 1 ) s.append( ",\n" );
        }

        jtaResult.setText( s.toString() );
    }

    private void initComponents() {
        LcdCell = new HD44780CharCell();
        LcdPreview = new HD44780SmallCharCell();
        javax.swing.JButton jbClear = new javax.swing.JButton();
        javax.swing.JButton jbSet = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jtaResult = new javax.swing.JTextArea();
        jlInfo = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "hd44780-char-gen.title" ) );
        setResizable( false );

        LcdCell.addMouseListener( new java.awt.event.MouseAdapter() {
            public void mouseReleased( java.awt.event.MouseEvent evt ) {
                LcdCellMouseReleased( evt );
            }
        } );

        javax.swing.GroupLayout LcdCellLayout = new javax.swing.GroupLayout( LcdCell );
        LcdCell.setLayout( LcdCellLayout );
        LcdCellLayout.setHorizontalGroup( LcdCellLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 101, Short.MAX_VALUE ) );
        LcdCellLayout.setVerticalGroup( LcdCellLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 161, Short.MAX_VALUE ) );

        javax.swing.GroupLayout LcdPreviewLayout = new javax.swing.GroupLayout( LcdPreview );
        LcdPreview.setLayout( LcdPreviewLayout );
        LcdPreviewLayout.setHorizontalGroup( LcdPreviewLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 16, Short.MAX_VALUE ) );
        LcdPreviewLayout.setVerticalGroup( LcdPreviewLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 25, Short.MAX_VALUE ) );

        jbClear.setText( strings.getString( "hd44780-char-gen.clear" ) );
        jbClear.addActionListener( this::jbClearActionPerformed );

        jbSet.setText( strings.getString( "hd44780-char-gen.set" ) );
        jbSet.addActionListener( this::jbSetActionPerformed );

        jtaResult.setEditable( false );
        jtaResult.setColumns( 20 );
        jtaResult.setFont( new java.awt.Font( "Monospaced", Font.PLAIN, 12 ) );
        jtaResult.setRows( 5 );
        jScrollPane1.setViewportView( jtaResult );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false ).addComponent( jbSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jbClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( LcdCell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( LcdPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jScrollPane1 ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jScrollPane1 ).addComponent( LcdPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( LcdCell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( layout.createSequentialGroup().addComponent( jlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 25, 25, 25 ) ).addGroup( layout.createSequentialGroup().addComponent( jbClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jbSet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap() ) ) ) );

        pack();
    }

    private void LcdCellMouseReleased( java.awt.event.MouseEvent evt ) {
        showData();
    }

    private void jbClearActionPerformed( java.awt.event.ActionEvent evt ) {
        LcdCell.clear();
        showData();
    }

    private void jbSetActionPerformed( java.awt.event.ActionEvent evt ) {
        LcdCell.set();
        showData();
    }
}
