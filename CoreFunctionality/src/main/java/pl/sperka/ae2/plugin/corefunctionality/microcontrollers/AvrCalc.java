package pl.sperka.ae2.plugin.corefunctionality.microcontrollers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class AvrCalc extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( AvrCalc.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Strings" );
    private final int[] stdUartBaud = { 300, 600, 1200, 2400, 4800, 9600, 14400, 19200, 28800,
            38400, 57600, 76800, 115200, 230400, 460800 };

    private javax.swing.JCheckBox jcb8bit;
    private javax.swing.JRadioButton jcbAsync;
    private javax.swing.JRadioButton jcbSync;
    private javax.swing.JComboBox<String> jcbTwiPrescaler;
    private javax.swing.JCheckBox jcbX2;
    private javax.swing.JLabel jlTwiResult;
    private javax.swing.JTable jtTimIntResult;
    private javax.swing.JTable jtUartResult;
    private javax.swing.JTextField jtfTimIntFint;
    private javax.swing.JTextField jtfTimIntFosc;
    private javax.swing.JTextField jtfTwiFosc;
    private javax.swing.JTextField jtfTwiFreq;
    private javax.swing.JTextField jtfUartBaud;
    private javax.swing.JTextField jtfUartFosc;

    public AvrCalc( ICore core ) {
        initComponents();
        jtTimIntResult.setDefaultRenderer( String.class, new TimIntCellRenderer() );
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class< ? > getColumnClass( int columnIndex ) {
                return String.class;
            }
        };
        jtTimIntResult.setModel( model );
        model.addColumn( strings.getString( "avr-calc.prescaler" ) );
        model.addColumn( "Timer 8-bit" );
        model.addColumn( "Timer 8-bit CTC" );
        model.addColumn( "Timer 16-bit" );
        model.addColumn( "Timer 16-bit CTC" );

        jtUartResult.setDefaultRenderer( String.class, new UartCellRenderer() );
        DefaultTableModel modelUart = new DefaultTableModel() {
            @Override
            public Class< ? > getColumnClass( int columnIndex ) {
                return String.class;
            }
        };
        jtUartResult.setModel( modelUart );
        modelUart.addColumn( "Baud Rate" );
        modelUart.addColumn( "UBRR" );
        modelUart.addColumn( strings.getString( "avr-calc.error" ) );
        showUartData();

        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {
        ButtonGroup bgSync = new ButtonGroup();
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        jtfTimIntFosc = new javax.swing.JTextField();
        JLabel jLabel2 = new JLabel();
        jtfTimIntFint = new javax.swing.JTextField();
        JScrollPane jScrollPane1 = new JScrollPane();
        jtTimIntResult = new javax.swing.JTable();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel3 = new JLabel();
        jtfUartFosc = new javax.swing.JTextField();
        jtfUartBaud = new javax.swing.JTextField();
        JLabel jLabel4 = new JLabel();
        JScrollPane jScrollPane2 = new JScrollPane();
        jtUartResult = new javax.swing.JTable();
        JPanel jPanel4 = new JPanel();
        jcb8bit = new javax.swing.JCheckBox();
        jcbX2 = new javax.swing.JCheckBox();
        jcbAsync = new javax.swing.JRadioButton();
        jcbSync = new javax.swing.JRadioButton();
        JPanel jPanel3 = new JPanel();
        jtfTwiFosc = new javax.swing.JTextField();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        jtfTwiFreq = new javax.swing.JTextField();
        JLabel jLabel7 = new JLabel();
        jcbTwiPrescaler = new javax.swing.JComboBox<>();
        jlTwiResult = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "avr-calc.title" ) );

        jLabel1.setText( strings.getString( "avr-calc.cpu-frequency" ) );
;
        jtfTimIntFosc.setText( "1" );
        jtfTimIntFosc.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfTimIntFoscKeyReleased( evt );
            }
        } );

        jLabel2.setText( strings.getString( "avr-calc.irq-frequency" ) );

        jtfTimIntFint.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfTimIntFintKeyReleased( evt );
            }
        } );

        jtTimIntResult.setModel( new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ) );
        jtTimIntResult.setEnabled( false );
        jScrollPane1.setViewportView( jtTimIntResult );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                                        .addGroup( jPanel1Layout.createSequentialGroup()
                                                .addComponent( jScrollPane1 )
                                                .addContainerGap() )
                                        .addGroup( jPanel1Layout.createSequentialGroup()
                                                .addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                                                        .addComponent( jLabel1 )
                                                        .addComponent( jLabel2 ) )
                                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                .addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false )
                                                        .addComponent( jtfTimIntFint, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE )
                                                        .addComponent( jtfTimIntFosc ) )
                                                .addGap( 253, 514, Short.MAX_VALUE ) ) ) )
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                        .addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                        .addComponent( jtfTimIntFosc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED )
                                .addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                        .addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                        .addComponent( jtfTimIntFint, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                .addComponent( jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE )
                                .addContainerGap() )
        );

        jTabbedPane1.addTab( strings.getString( "avr-calc.timers-irq" ), jPanel1 );

        jLabel3.setText( strings.getString( "avr-calc.cpu-frequency" ) );

        jtfUartFosc.setText( "1" );
        jtfUartFosc.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfUartFoscKeyReleased( evt );
            }
        } );

        jtfUartBaud.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfUartBaudKeyReleased( evt );
            }
        } );

        jLabel4.setText( strings.getString( "avr-calc.baud-rate" ) );

        jtUartResult.setModel( new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ) );
        jtUartResult.setEnabled( false );
        jScrollPane2.setViewportView( jtUartResult );

        jPanel4.setBorder( javax.swing.BorderFactory.createEtchedBorder() );

        jcb8bit.setText( strings.getString( "avr-calc.ubrr-8-bits-only" ) );
        jcb8bit.addActionListener( this::jcb8bitActionPerformed );

        jcbX2.setText( "X2U" );
        jcbX2.addActionListener( this::jcbX2ActionPerformed );

        bgSync.add( jcbAsync );
        jcbAsync.setSelected( true );
        jcbAsync.setText( strings.getString( "avr-calc.asynchronous-mode" ) );
        jcbAsync.addActionListener( this::jcbAsyncActionPerformed );

        bgSync.add( jcbSync );
        jcbSync.setText( strings.getString( "avr-calc.synchronous-mode" ) );
        jcbSync.addActionListener( this::jcbSyncActionPerformed );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout( jPanel4 );
        jPanel4.setLayout( jPanel4Layout );
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                                        .addComponent( jcbAsync )
                                        .addComponent( jcbSync ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE )
                                .addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                                        .addComponent( jcbX2 )
                                        .addComponent( jcb8bit ) )
                                .addContainerGap() )
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                        .addComponent( jcb8bit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                        .addComponent( jcbAsync, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
                                .addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                        .addComponent( jcbX2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                        .addComponent( jcbSync, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addContainerGap() )
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                                        .addComponent( jScrollPane2 )
                                        .addGroup( jPanel2Layout.createSequentialGroup()
                                                .addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false )
                                                        .addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent( jLabel3 )
                                                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                                .addComponent( jtfUartFosc ) )
                                                        .addGroup( javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent( jLabel4 )
                                                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                                .addComponent( jtfUartBaud, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE ) ) )
                                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE )
                                                .addComponent( jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ) )
                                .addContainerGap() )
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                                        .addGroup( jPanel2Layout.createSequentialGroup()
                                                .addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                                        .addComponent( jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                                        .addComponent( jtfUartFosc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED )
                                                .addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                                        .addComponent( jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                                        .addComponent( jtfUartBaud, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) )
                                        .addComponent( jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                .addComponent( jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE )
                                .addContainerGap() )
        );

        jTabbedPane1.addTab( "UART", jPanel2 );

        jtfTwiFosc.setText( "1" );
        jtfTwiFosc.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfTwiFoscKeyReleased( evt );
            }
        } );

        jLabel5.setText( strings.getString( "avr-calc.cpu-frequency" ) );

        jLabel6.setText( strings.getString( "avr-calc.twi-frequency" ) );

        jtfTwiFreq.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased( java.awt.event.KeyEvent evt ) {
                jtfTwiFreqKeyReleased( evt );
            }
        } );

        jLabel7.setText( strings.getString( "avr-calc.twi-prescaler" ) );

        jcbTwiPrescaler.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "0 (/1)", "1 (/4)", "2 (/16)", "3 (/64)" } ) );
        jcbTwiPrescaler.addItemListener( this::jcbTwiPrescalerItemStateChanged );

        jlTwiResult.setText( strings.getString( "avr-calc.enter-correct-data" ) );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout( jPanel3 );
        jPanel3.setLayout( jPanel3Layout );
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                                        .addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false )
                                                .addGroup( jPanel3Layout.createSequentialGroup()
                                                        .addComponent( jLabel5 )
                                                        .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                        .addComponent( jtfTwiFosc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                                .addGroup( jPanel3Layout.createSequentialGroup()
                                                        .addComponent( jLabel6 )
                                                        .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                        .addComponent( jtfTwiFreq ) ) )
                                        .addGroup( jPanel3Layout.createSequentialGroup()
                                                .addComponent( jLabel7 )
                                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                                .addComponent( jcbTwiPrescaler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                        .addComponent( jlTwiResult ) )
                                .addContainerGap( 521, Short.MAX_VALUE ) )
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                        .addComponent( jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                        .addComponent( jtfTwiFosc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED )
                                .addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                        .addComponent( jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                        .addComponent( jtfTwiFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                .addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
                                        .addComponent( jLabel7 )
                                        .addComponent( jcbTwiPrescaler, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) )
                                .addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
                                .addComponent( jlTwiResult, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE )
                                .addContainerGap( 169, Short.MAX_VALUE ) )
        );

        jTabbedPane1.addTab( "TWI (I2C)", jPanel3 );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup(
                layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent( jTabbedPane1 )
                                .addContainerGap() )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent( jTabbedPane1 )
                                .addContainerGap() )
        );

        pack();
    }

    private void jcbTwiPrescalerItemStateChanged( java.awt.event.ItemEvent evt ) {
        showTwiData();
    }

    private void jtfTwiFreqKeyReleased( java.awt.event.KeyEvent evt ) {
        showTwiData();
    }

    private void jtfTwiFoscKeyReleased( java.awt.event.KeyEvent evt ) {
        showTwiData();
    }

    private void jtfUartBaudKeyReleased( java.awt.event.KeyEvent evt ) {
        showUartData();
    }

    private void jtfUartFoscKeyReleased( java.awt.event.KeyEvent evt ) {
        showUartData();
    }

    private void jtfTimIntFintKeyReleased( java.awt.event.KeyEvent evt ) {
        showTimIntData();
    }

    private void jtfTimIntFoscKeyReleased( java.awt.event.KeyEvent evt ) {
        showTimIntData();
    }

    private void jcb8bitActionPerformed( java.awt.event.ActionEvent evt ) {
        showUartData();
    }

    private void jcbX2ActionPerformed( java.awt.event.ActionEvent evt ) {
        showUartData();
    }

    private void jcbAsyncActionPerformed( java.awt.event.ActionEvent evt ) {
        if ( jcbAsync.isSelected() ) {
            jcbX2.setEnabled( true );
        }
        showUartData();
    }

    private void jcbSyncActionPerformed( java.awt.event.ActionEvent evt ) {
        if ( jcbSync.isSelected() ) {
            jcbX2.setSelected( false );
            jcbX2.setEnabled( false );
        }
        showUartData();
    }

    private String[] getTimIntData( int prescaler ) {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        String[] temp = new String[4];
        try {
            double fosc = 1000000 * nf.parse( jtfTimIntFosc.getText() ).doubleValue() / prescaler;
            double fint = nf.parse( jtfTimIntFint.getText() ).doubleValue();
            int x = (int) Math.round( (double) fosc / fint );
            if ( x <= 256 && x > 0 ) {
                temp[0] = Integer.toString( 256 - x ) + "(f=" + nf.format( (double) fosc / x ) + " Hz)";
                temp[1] = Integer.toString( x - 1 ) + "(f=" + nf.format( (double) fosc / x ) + " Hz)";
            } else {
                temp[0] = "-";
                temp[1] = "-";
            }
            if ( x <= 65536 && x > 0 ) {
                temp[2] = Integer.toString( 65536 - x ) + "(f=" + nf.format( (double) fosc / x ) + " Hz)";
                temp[3] = Integer.toString( x - 1 ) + "(f=" + nf.format( (double) fosc / x ) + " Hz)";
            } else {
                temp[2] = "-";
                temp[3] = "-";
            }
        } catch ( Exception ignored ) {
        }
        return temp;
    }

    private void showTimIntData() {
        if ( !jtfTimIntFosc.getText().isEmpty() && !jtfTimIntFint.getText().isEmpty() ) {
            String[] temp;
            DefaultTableModel model = (DefaultTableModel) jtTimIntResult.getModel();
            int rows = model.getRowCount();
            for ( int i = rows - 1; i >= 0; i-- ) {
                model.removeRow( i );
            }
            temp = getTimIntData( 1 );
            model.addRow( new Object[]{ "1", temp[0], temp[1], temp[2], temp[3] } );
            temp = getTimIntData( 8 );
            model.addRow( new Object[]{ "8", temp[0], temp[1], temp[2], temp[3] } );
            temp = getTimIntData( 32 );
            model.addRow( new Object[]{ "32", temp[0], temp[1], temp[2], temp[3] } );
            temp = getTimIntData( 64 );
            model.addRow( new Object[]{ "64", temp[0], temp[1], temp[2], temp[3] } );
            temp = getTimIntData( 128 );
            model.addRow( new Object[]{ "128", temp[0], temp[1], temp[2], temp[3] } );
            temp = getTimIntData( 256 );
            model.addRow( new Object[]{ "256", temp[0], temp[1], temp[2], temp[3] } );
            temp = getTimIntData( 1024 );
            model.addRow( new Object[]{ "1024", temp[0], temp[1], temp[2], temp[3] } );
        }
        jtTimIntResult.repaint();
    }

    private void showUartData() {
        if ( jtfUartFosc.getText().isEmpty() ) return;
        int uartModeModifier = 16;
        if ( jcbX2.isSelected() ) uartModeModifier = 8;
        else if ( jcbSync.isSelected() ) uartModeModifier = 2;
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        DefaultTableModel model = (DefaultTableModel) jtUartResult.getModel();
        int rows = model.getRowCount();
        for ( int i = rows - 1; i >= 0; i-- )
            model.removeRow( i );
        try {
            if ( !jtfUartBaud.getText().isEmpty() ) {
                double ubrr = ( 1000000 * nf.parse( jtfUartFosc.getText() ).doubleValue()
                        / uartModeModifier / Integer.parseInt( jtfUartBaud.getText() ) ) - 1;
                ubrr = Math.round( ubrr );
                if ( ubrr > 0xff && jcb8bit.isSelected() ) ubrr = 0xff;
                if ( ubrr > 0xfff ) ubrr = 0xfff;
                if ( ubrr < 0 ) ubrr = 0;
                double realBaud = ( 1000000 * nf.parse( jtfUartFosc.getText() ).doubleValue()
                        / uartModeModifier / ( ubrr + 1 ) );
                model.addRow( new Object[]{ Integer.toString( Integer.parseInt( jtfUartBaud.getText() ) ),
                        "0x" + Integer.toHexString( 0x10000 | (int) ubrr ).substring( 1 ),
                        nf.format( Math.round( ( realBaud / Integer.parseInt( jtfUartBaud.getText() ) - 1 ) * 10000 ) / 100.0 ) + "%" } );
            }
            for ( int i = 0; i < stdUartBaud.length; i++ ) {
                double ubrr = ( 1000000 * nf.parse( jtfUartFosc.getText() ).doubleValue()
                        / uartModeModifier / stdUartBaud[i] ) - 1;
                ubrr = Math.round( ubrr );
                if ( ubrr > 0xff && jcb8bit.isSelected() ) ubrr = 0xff;
                if ( ubrr > 0xfff ) ubrr = 0xfff;
                if ( ubrr < 0 ) ubrr = 0;
                double realBaud = ( 1000000 * nf.parse( jtfUartFosc.getText() ).doubleValue()
                        / uartModeModifier / ( ubrr + 1 ) );
                model.addRow( new Object[]{ Integer.toString( stdUartBaud[i] ),
                        "0x" + Integer.toHexString( 0x10000 | (int) ubrr ).substring( 1 ),
                        nf.format( Math.round( ( realBaud / stdUartBaud[i] - 1 ) * 10000 ) / 100.0 ) + "%" } );
            }
        } catch ( Exception ignored ) {
        }
    }

    private void showTwiData() {
        if ( jtfTwiFosc.getText().isEmpty() || jtfTwiFreq.getText().isEmpty() ) {
            jlTwiResult.setText( strings.getString( "avr-calc.enter-correct-data" ) );
            return;
        }
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        try {
            double twbr = ( ( nf.parse( jtfTwiFosc.getText() ).doubleValue() * 1000000 ) /
                    ( ( nf.parse( jtfTwiFreq.getText() ) ).doubleValue() * 1000 * 2 *
                            Math.pow( 4, jcbTwiPrescaler.getSelectedIndex() ) ) ) - 8;
            twbr = Math.round( twbr );
            if ( twbr < 0 ) twbr = 0;
            if ( twbr > 255 ) twbr = 255;
            double realSpeed = ( nf.parse( jtfTwiFosc.getText() ).doubleValue() * 1000000 ) /
                    ( ( 16 + 2 * twbr ) * Math.pow( 4, jcbTwiPrescaler.getSelectedIndex() ) );
            realSpeed = Math.round( realSpeed / 10 );
            jlTwiResult.setText( "TWBR = 0x" + Integer.toHexString( 0x100 | (int) twbr ).substring( 1 )
                    + ", " + strings.getString( "avr-calc.twi-frequency" ) + " " + nf.format( ( realSpeed ) / 100.0 ) );
        } catch ( Exception ignored ) {
        }
    }

    private class TimIntCellRenderer extends DefaultTableCellRenderer {
        private final Color GOOD_COLOR = Color.green;
        private final Color AVERAGE_COLOR = Color.yellow;
        private final Color BAD_COLOR = Color.red;
        private final Color BASE_COLOR = Color.white;

        @Override
        public Component getTableCellRendererComponent( JTable table,
                                                        Object value, boolean isSelected, boolean hasFocus, int row,
                                                        int col ) {

            Component superComponent = super.getTableCellRendererComponent( table, value, isSelected, hasFocus,
                    row, col );
            Object valueAt = table.getModel().getValueAt( row, col );
            java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
            String s = "";
            if ( valueAt != null ) s = valueAt.toString();
            if ( col == 0 ) superComponent.setBackground( BASE_COLOR );
            else {
                if ( !s.equals( "-" ) ) {
                    try {
                        double v = nf.parse( s.substring( s.indexOf( "=" ) + 1, s.indexOf( "H" ) ) ).doubleValue();
                        double vset = nf.parse( jtfTimIntFint.getText() ).doubleValue();
                        if ( v == vset ) superComponent.setBackground( GOOD_COLOR );
                        else if ( ( v < 1.05 * vset ) && ( v > 0.95 * vset ) )
                            superComponent.setBackground( AVERAGE_COLOR );
                        else superComponent.setBackground( BAD_COLOR );
                    } catch ( Exception ignored ) {
                    }
                } else superComponent.setBackground( BAD_COLOR );
            }

            return superComponent;
        }
    }

    private static class UartCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent( JTable table,
                                                        Object value, boolean isSelected, boolean hasFocus, int row,
                                                        int col ) {

            Component superComponent = super.getTableCellRendererComponent( table, value, isSelected, hasFocus,
                    row, col );
            Object valueAt = table.getModel().getValueAt( row, 2 ); 
            java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
            String s = "";
            if ( valueAt != null ) s = valueAt.toString().replaceAll( "%", "" );
            try {
                double err = nf.parse( s ).doubleValue();
                Color c = Color.red;
                if ( Math.abs( err ) <= 0.2 ) c = Color.green;
                else if ( Math.abs( err ) <= 1.5 ) c = Color.green.darker();
                else if ( Math.abs( err ) <= 3 ) c = Color.yellow;
                else if ( Math.abs( err ) < 5 ) c = Color.orange;
                superComponent.setBackground( c );
            } catch ( Exception ignored ) {
            }
            return superComponent;
        }
    }
}
