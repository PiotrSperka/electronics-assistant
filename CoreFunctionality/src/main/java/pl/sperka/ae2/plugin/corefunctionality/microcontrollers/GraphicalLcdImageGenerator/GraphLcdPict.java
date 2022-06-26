package pl.sperka.ae2.plugin.corefunctionality.microcontrollers.GraphicalLcdImageGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class GraphLcdPict extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( GraphLcdPict.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Strings" );
    private BufferedImage original, result;
    private int brightest = 0;
    private javax.swing.JButton jbGetResult;
    private javax.swing.JButton jbMakeArray;
    private javax.swing.JButton jbSave;
    private javax.swing.JRadioButton jrbColor;
    private javax.swing.JRadioButton jrbMono;
    private javax.swing.JRadioButton jrbRGB565;
    private javax.swing.JRadioButton jrbRGB888;
    private javax.swing.JRadioButton jrbSierra;
    private javax.swing.JRadioButton jrbThreshold;
    private javax.swing.JSlider jsThreshold;
    private javax.swing.JScrollPane jspOriginal;
    private javax.swing.JScrollPane jspResult;
    private javax.swing.JTextArea jtaResult;
    private javax.swing.JTextField jtfLcdHeight;
    private javax.swing.JTextField jtfLcdWidth;

    public GraphLcdPict( Component parent ) {
        initComponents();
        setLocationRelativeTo( parent );
    }

    private void toGrayscale( BufferedImage bi ) {
        for ( int i = 0; i < bi.getHeight(); i++ ) {
            for ( int j = 0; j < bi.getWidth(); j++ ) {
                Color c = new Color( bi.getRGB( j, i ) );
                int k = ( c.getRed() + c.getBlue() + c.getGreen() ) / 3;
                c = new Color( k, k, k );
                if ( k > brightest ) brightest = k;
                bi.setRGB( j, i, c.getRGB() );
            }
        }
    }

    private void gamma( int value, BufferedImage bi ) {
        for ( int i = 0; i < bi.getHeight(); i++ ) {
            for ( int j = 0; j < bi.getWidth(); j++ ) {
                Color c = new Color( bi.getRGB( j, i ) );
                int k = ( c.getRed() + c.getBlue() + c.getGreen() ) / 3;
                k = (int) ( 255 * Math.pow( ( (double) k / 255 ), (double) value / 100 ) );
                c = new Color( k, k, k );
                if ( k > brightest ) brightest = k;
                bi.setRGB( j, i, c.getRGB() );
            }
        }
    }

    private BufferedImage scale( int wmax, int hmax, BufferedImage bi ) {
        AffineTransform at = new AffineTransform();
        double scaleFactor = (double) hmax / bi.getHeight();
        double tmp = (double) wmax / bi.getWidth();
        if ( tmp < scaleFactor ) scaleFactor = tmp;

        at.scale( scaleFactor, scaleFactor );
        AffineTransformOp scaleAT = new AffineTransformOp( at, AffineTransformOp.TYPE_BILINEAR );
        BufferedImage t = new BufferedImage( (int) ( bi.getWidth() * scaleFactor ), (int) ( bi.getHeight() * scaleFactor ), BufferedImage.TYPE_INT_RGB );
        Graphics2D g2d = t.createGraphics();
        g2d.setColor( Color.WHITE );
        g2d.fillRect( 0, 0, (int) ( bi.getWidth() * scaleFactor ), (int) ( bi.getHeight() * scaleFactor ) );
        g2d.drawImage( bi, scaleAT, 0, 0 );
        return t;
    }

    private void Sierra24A( int thr, BufferedImage bi ) {
        int[][] e_tab = new int[bi.getWidth() + 2][bi.getHeight() + 1];
        for ( int i = 0; i < bi.getHeight(); i++ )
            for ( int j = 0; j < bi.getWidth(); j++ ) {
                e_tab[j][i] = 0;
            }
        Color b = new Color( 0, 0, 0 );
        Color w = new Color( 255, 255, 255 );
        int threshold = (int) ( brightest * ( (double) thr / 100 ) );
        int err = 0;
        for ( int i = 0; i < bi.getHeight(); i++ )
            for ( int j = 1; j < bi.getWidth() + 1; j++ ) {

                err = ( bi.getRGB( j - 1, i ) & 0x000000FF ) + e_tab[j][i];
                if ( ( err ) > threshold ) {
                    bi.setRGB( j - 1, i, w.getRGB() );
                    err -= brightest;
                } else bi.setRGB( j - 1, i, b.getRGB() );
                e_tab[j + 1][i] = (int) ( err * 0.5 );
                e_tab[j][i + 1] = (int) ( err * 0.25 );
                e_tab[j - 1][i + 1] = (int) ( err * 0.25 );
            }
    }

    private void BWThreshold( int thr, BufferedImage bi ) {
        Color b = new Color( 0, 0, 0 );
        Color w = new Color( 255, 255, 255 );
        int threshold = (int) ( brightest * ( (double) thr / 100 ) );
        for ( int i = 0; i < bi.getHeight(); i++ )
            for ( int j = 0; j < bi.getWidth(); j++ ) {

                int color = ( bi.getRGB( j, i ) & 0x000000FF );
                if ( color > threshold ) {
                    bi.setRGB( j, i, w.getRGB() );
                } else bi.setRGB( j, i, b.getRGB() );
            }
    }

    private void getResult() {
        if ( jtfLcdWidth.getText().isEmpty() || jtfLcdHeight.getText().isEmpty() ) return;
        result = scale( Integer.parseInt( jtfLcdWidth.getText() ), Integer.parseInt( jtfLcdHeight.getText() ), original );
        if ( jrbMono.isSelected() && jrbSierra.isSelected() ) {
            toGrayscale( result );
            Sierra24A( jsThreshold.getValue(), result );
        } else if ( jrbMono.isSelected() && jrbThreshold.isSelected() ) {
            toGrayscale( result );
            BWThreshold( jsThreshold.getValue(), result );
        } else if ( jrbColor.isSelected() ) {

        } else return;

        JPanel jp = new JPanel();
        jp.setSize( result.getWidth(), result.getHeight() );
        JLabel lbl = new JLabel( new ImageIcon( result ) );
        lbl.setSize( result.getWidth(), result.getHeight() );
        jp.add( lbl );
        jspResult.getViewport().add( jp );
        jspResult.setPreferredSize( new Dimension( (int) jp.getWidth(), (int) jp.getHeight() ) );
    }

    private void makeBWArray( BufferedImage bi ) {
        jtaResult.setText( null );
        StringBuilder text = new StringBuilder( "const unsigned int width = " + bi.getWidth() + ";\n" + "const unsigned int height = " + bi.getHeight() + ";\n" + "const unsigned char Bitmap[] = {" );
        int tmp = 0, ptr = 128;
        for ( int i = 0; i < bi.getHeight(); i++ )
            for ( int j = 0; j < bi.getWidth(); j++ ) {

                int color = ( bi.getRGB( j, i ) & 0x000000FF );
                if ( color == 0 ) tmp += ptr;
                ptr /= 2;
                if ( ptr == 0 ) {
                    text.append( "0x" ).append( Integer.toHexString( 0x100 | tmp ).substring( 1 ) ).append( ", " );
                    tmp = 0;
                    ptr = 128;
                }
            }
        if ( ptr < 128 ) text.append( "0x" ).append( Integer.toHexString( 0x100 | tmp ).substring( 1 ) );
        text.append( "};" );
        jtaResult.setText( text.toString() );
    }

    private void makeColorArray( BufferedImage bi ) {
        jtaResult.setText( null );
        StringBuilder text = new StringBuilder( "const unsigned int width = " + bi.getWidth() + ";\n" + "const unsigned int height = " + bi.getHeight() + ";\n" );
        if ( jrbRGB565.isSelected() ) text.append( "// RGB565 -> 0bRRRRRGGG, 0bGGGBBBBB\n" );
        else if ( jrbRGB888.isSelected() ) text.append( "// RGB888 -> 0bRRRRRRRR, 0bGGGGGGGG, 0bBBBBBBBB\n" );
        text.append( "const unsigned char Bitmap[] = {" );
        int tmp = 0, ptr = 128;
        for ( int i = 0; i < bi.getHeight(); i++ )
            for ( int j = 0; j < bi.getWidth(); j++ ) {
                int colorB = ( result.getRGB( j, i ) & 0x000000FF );
                int colorG = ( result.getRGB( j, i ) & 0x0000FF00 ) >> 8;
                int colorR = ( result.getRGB( j, i ) & 0x00FF0000 ) >> 16;
                if ( jrbRGB888.isSelected() ) {
                    text.append( "0x" ).append( Integer.toHexString( 0x100 | colorR ).substring( 1 ) ).append( ", " );
                    text.append( "0x" ).append( Integer.toHexString( 0x100 | colorG ).substring( 1 ) ).append( ", " );
                    text.append( "0x" ).append( Integer.toHexString( 0x100 | colorB ).substring( 1 ) ).append( ", " );
                } else if ( jrbRGB565.isSelected() ) {
                    text.append( "0x" ).append( Integer.toHexString( 0x100 | ( ( colorR & 0xF8 ) + ( ( colorG & 0xE0 ) >> 5 ) ) ).substring( 1 ) ).append( ", " );
                    text.append( "0x" ).append( Integer.toHexString( 0x100 | ( ( ( colorG & 0x1C ) << 3 ) + ( ( colorB & 0xF8 ) >> 3 ) ) ).substring( 1 ) ).append( ", " );
                }
            }
        if ( ptr < 128 ) text.append( "0x" ).append( Integer.toHexString( 0x100 | tmp ).substring( 1 ) );
        text.append( "};" );
        jtaResult.setText( text.toString() );
    }

    private void initComponents() {
        ButtonGroup bgLcdType = new ButtonGroup();
        ButtonGroup bgType = new ButtonGroup();
        ButtonGroup bgRGBConv = new ButtonGroup();
        JButton jbLoad = new JButton();
        jspOriginal = new javax.swing.JScrollPane();
        jspResult = new javax.swing.JScrollPane();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        jtfLcdHeight = new javax.swing.JTextField();
        JLabel jLabel2 = new JLabel();
        jtfLcdWidth = new javax.swing.JTextField();
        jrbMono = new javax.swing.JRadioButton();
        jrbColor = new javax.swing.JRadioButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        jtaResult = new javax.swing.JTextArea();
        JPanel jPanel2 = new JPanel();
        jrbThreshold = new javax.swing.JRadioButton();
        jrbSierra = new javax.swing.JRadioButton();
        jsThreshold = new javax.swing.JSlider();
        jbGetResult = new javax.swing.JButton();
        jbMakeArray = new javax.swing.JButton();
        jbSave = new javax.swing.JButton();
        JPanel jPanel3 = new JPanel();
        jrbRGB565 = new javax.swing.JRadioButton();
        jrbRGB888 = new javax.swing.JRadioButton();
        JButton jbSaveInfo = new JButton();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "graphic-lcd-picture-generator.title" ) );

        jbLoad.setText( strings.getString( "graphic-lcd-picture-generator.load-image" ) );
        jbLoad.addActionListener( this::jbLoadActionPerformed );

        jspOriginal.setMaximumSize( new java.awt.Dimension( 375, 250 ) );
        jspOriginal.setPreferredSize( new java.awt.Dimension( 375, 250 ) );

        jspResult.setMaximumSize( new java.awt.Dimension( 250, 375 ) );

        jPanel1.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "graphic-lcd-picture-generator.display" ) ) );

        jLabel1.setText( strings.getString( "graphic-lcd-picture-generator.height" ) );
        jtfLcdHeight.setText( "128" );

        jLabel2.setText( strings.getString( "graphic-lcd-picture-generator.width" ) );

        jtfLcdWidth.setText( "256" );

        bgLcdType.add( jrbMono );
        jrbMono.setSelected( true );
        jrbMono.setText( strings.getString( "graphic-lcd-picture-generator.monochromatic" ) );
        jrbMono.addActionListener( this::jrbMonoActionPerformed );

        bgLcdType.add( jrbColor );
        jrbColor.setText( strings.getString( "graphic-lcd-picture-generator.color" ) );
        jrbColor.addActionListener( this::jrbColorActionPerformed );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jLabel1 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtfLcdHeight ) ).addGroup( jPanel1Layout.createSequentialGroup().addComponent( jLabel2 ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jtfLcdWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addGap( 18, 18, 18 ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbMono ).addComponent( jrbColor ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtfLcdHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbMono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jtfLcdWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        jtaResult.setColumns( 20 );
        jtaResult.setFont( new java.awt.Font( "Monospaced", Font.PLAIN, 12 ) );
        jtaResult.setLineWrap( true );
        jtaResult.setRows( 5 );
        jtaResult.setWrapStyleWord( true );
        jScrollPane1.setViewportView( jtaResult );

        jPanel2.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "graphic-lcd-picture-generator.conversion-type" ) ) );

        bgType.add( jrbThreshold );
        jrbThreshold.setText( strings.getString( "graphic-lcd-picture-generator.threshold" ) );

        bgType.add( jrbSierra );
        jrbSierra.setSelected( true );
        jrbSierra.setText( strings.getString( "graphic-lcd-picture-generator.dithering" ) );

        jsThreshold.setMaximum( 99 );
        jsThreshold.setMinimum( 1 );
        jsThreshold.setToolTipText( strings.getString( "graphic-lcd-picture-generator.threshold" ) );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jsThreshold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( jPanel2Layout.createSequentialGroup().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbThreshold ).addComponent( jrbSierra ) ).addGap( 0, 0, Short.MAX_VALUE ) ) ).addContainerGap() ) );
        jPanel2Layout.setVerticalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jrbThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jrbSierra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( jsThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ) );

        jbGetResult.setText( strings.getString( "graphic-lcd-picture-generator.preview" ) );
        jbGetResult.setEnabled( false );
        jbGetResult.addActionListener( this::jbGetResultActionPerformed );

        jbMakeArray.setText( strings.getString( "graphic-lcd-picture-generator.generate" ) );
        jbMakeArray.setEnabled( false );
        jbMakeArray.addActionListener( this::jbMakeArrayActionPerformed );

        jbSave.setText( strings.getString( "graphic-lcd-picture-generator.save" ) );
        jbSave.setEnabled( false );
        jbSave.addActionListener( this::jbSaveActionPerformed );

        jPanel3.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "graphic-lcd-picture-generator.rgb-conversion" ) ) );

        bgRGBConv.add( jrbRGB565 );
        jrbRGB565.setSelected( true );
        jrbRGB565.setText( strings.getString( "graphic-lcd-picture-generator.rgb-conversion-565" ) );
        jrbRGB565.setToolTipText( "" );
        jrbRGB565.setEnabled( false );

        bgRGBConv.add( jrbRGB888 );
        jrbRGB888.setText( strings.getString( "graphic-lcd-picture-generator.rgb-conversion-888" ) );
        jrbRGB888.setEnabled( false );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout( jPanel3 );
        jPanel3.setLayout( jPanel3Layout );
        jPanel3Layout.setHorizontalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addContainerGap().addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbRGB565 ).addComponent( jrbRGB888 ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel3Layout.setVerticalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jrbRGB565, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jrbRGB888, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) );

        jbSaveInfo.setText( "?" );
        jbSaveInfo.addActionListener( this::jbSaveInfoActionPerformed );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( layout.createSequentialGroup().addComponent( jbLoad ).addGap( 0, 0, Short.MAX_VALUE ) ).addComponent( jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jspOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( layout.createSequentialGroup().addComponent( jbGetResult ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( jbMakeArray ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jbSaveInfo ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jbSave ) ).addComponent( jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE ).addComponent( jspResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jbLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE ).addComponent( jbGetResult, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE ).addComponent( jbMakeArray, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE ).addComponent( jbSave, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE ) ).addComponent( jbSaveInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jspResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jspOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addComponent( jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 0, 0, Short.MAX_VALUE ) ).addComponent( jScrollPane1 ) ).addContainerGap() ) );

        pack();
    }

    private void jbLoadActionPerformed( java.awt.event.ActionEvent evt ) {
        JFileChooser jfc = new JFileChooser();
        int i = jfc.showOpenDialog( this );
        if ( i == JFileChooser.APPROVE_OPTION ) {
            try {
                original = ImageIO.read( jfc.getSelectedFile() );
                JPanel jp = new JPanel();
                jp.setSize( original.getWidth(), original.getHeight() );
                JLabel lbl = new JLabel( new ImageIcon( original ) );
                lbl.setSize( original.getWidth(), original.getHeight() );
                jp.add( lbl );
                jspOriginal.getViewport().add( jp );
                jspOriginal.setPreferredSize( new Dimension( jp.getWidth(), jp.getHeight() ) );
                jbGetResult.setEnabled( true );
            } catch ( Exception ignored ) {
            }
        }
    }

    private void jbGetResultActionPerformed( java.awt.event.ActionEvent evt ) {
        getResult();
        jbSave.setEnabled( true );
        jbMakeArray.setEnabled( true );
    }

    private void jbMakeArrayActionPerformed( java.awt.event.ActionEvent evt ) {
        getResult();
        if ( jrbMono.isSelected() ) makeBWArray( result );
        else if ( jrbColor.isSelected() ) makeColorArray( result );
    }

    private void jbSaveActionPerformed( java.awt.event.ActionEvent evt ) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter ffBMP = new FileNameExtensionFilter( strings.getString( "graphic-lcd-picture-generator.bitmap-file" ), "bmp" );
        FileNameExtensionFilter ffBIN = new FileNameExtensionFilter( strings.getString( "graphic-lcd-picture-generator.binary-file" ), "bin" );
        jfc.setAcceptAllFileFilterUsed( false );
        jfc.addChoosableFileFilter( ffBIN );
        jfc.addChoosableFileFilter( ffBMP );
        int a = jfc.showSaveDialog( this );
        if ( a == JFileChooser.APPROVE_OPTION ) {
            String ext = ( (FileNameExtensionFilter) jfc.getFileFilter() ).getExtensions()[0];
            String path = jfc.getSelectedFile().toString();
            if ( !path.toLowerCase().endsWith( "." + ext ) ) path = path + "." + ext;

            File f = new File( path );
            if ( ext.equals( "bmp" ) ) {
                try {
                    ImageIO.write( result, "BMP", f );
                } catch ( Exception ignored ) {
                }
            } else if ( ext.equals( "bin" ) ) {
                try {
                    DataOutputStream dos = new DataOutputStream( new FileOutputStream( f ) );
                    dos.write( ( result.getWidth() & 0xff00 ) >> 8 );
                    dos.write( ( result.getWidth() & 0xff ) );
                    dos.write( ( result.getHeight() & 0xff00 ) >> 8 );
                    dos.write( ( result.getHeight() & 0xff ) );
                    if ( jrbMono.isSelected() ) {
                        int tmp = 0, ptr = 128;
                        dos.write( 0x01 );
                        for ( int i = 0; i < result.getHeight(); i++ )
                            for ( int j = 0; j < result.getWidth(); j++ ) {
                                int color = ( result.getRGB( j, i ) & 0x000000FF );
                                if ( color == 0 ) tmp += ptr;
                                ptr /= 2;
                                if ( ptr == 0 ) {
                                    dos.write( tmp );
                                    tmp = 0;
                                    ptr = 128;
                                }
                            }
                        if ( ptr < 128 ) dos.write( tmp );
                    } else if ( jrbColor.isSelected() ) {
                        if ( jrbRGB888.isSelected() ) dos.write( 0x11 );
                        else if ( jrbRGB565.isSelected() ) dos.write( 0x12 );
                        for ( int i = 0; i < result.getHeight(); i++ )
                            for ( int j = 0; j < result.getWidth(); j++ ) {
                                int colorB = ( result.getRGB( j, i ) & 0x000000FF );
                                int colorG = ( result.getRGB( j, i ) & 0x0000FF00 ) >> 8;
                                int colorR = ( result.getRGB( j, i ) & 0x00FF0000 ) >> 16;
                                if ( jrbRGB888.isSelected() ) {
                                    dos.write( colorR );
                                    dos.write( colorG );
                                    dos.write( colorB );
                                } else if ( jrbRGB565.isSelected() ) {
                                    dos.write( ( colorR & 0xF8 ) + ( ( colorG & 0xE0 ) >> 5 ) );
                                    dos.write( ( ( colorG & 0x1C ) << 3 ) + ( ( colorB & 0xF8 ) >> 3 ) );
                                }
                            }
                    }
                    dos.close();

                } catch ( Exception ignored ) {
                }
            }
        }
    }

    private void jrbColorActionPerformed( java.awt.event.ActionEvent evt ) {
        jrbThreshold.setEnabled( false );
        jrbSierra.setEnabled( false );
        jsThreshold.setEnabled( false );
        jrbRGB888.setEnabled( true );
        jrbRGB565.setEnabled( true );
    }

    private void jrbMonoActionPerformed( java.awt.event.ActionEvent evt ) {
        jrbThreshold.setEnabled( true );
        jrbSierra.setEnabled( true );
        jsThreshold.setEnabled( true );
        jrbRGB888.setEnabled( false );
        jrbRGB565.setEnabled( false );
    }

    private void jbSaveInfoActionPerformed( java.awt.event.ActionEvent evt ) {
        GraphLcdPictInfo info = new GraphLcdPictInfo( this );
        info.setVisible( true );
        info.dispose();
    }
}
