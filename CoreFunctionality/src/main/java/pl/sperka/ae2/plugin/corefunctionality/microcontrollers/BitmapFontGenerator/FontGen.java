package pl.sperka.ae2.plugin.corefunctionality.microcontrollers.BitmapFontGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class FontGen extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( FontGen.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Strings" );
    private final static JFontChooser fc = new JFontChooser();
    private String index = "";
    private String chheight = "";
    private javax.swing.JComboBox< String > jcbString;
    private javax.swing.JRadioButton jrbSSzer;
    private javax.swing.JRadioButton jrbSWys;
    private javax.swing.JRadioButton jrbTabPel;
    private javax.swing.JRadioButton jrbTabPolPel;
    private javax.swing.JRadioButton jrbZSzer;
    private javax.swing.JRadioButton jrbZWys;
    private javax.swing.JTextArea jtaString;
    private javax.swing.JTextArea jtaWynik;

    public FontGen( ICore core ) {
        initComponents();
        jtaString.setFont( fc.getSelectedFont() );
        setLocationRelativeTo( core.getParentComponent() );
        setIconImage( core.getIcon() );
    }

    private void initComponents() {
        javax.swing.ButtonGroup bgSzer = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup bgWys = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup bgDane = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup bgBajt = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup bgTablica = new javax.swing.ButtonGroup();
        javax.swing.JButton jbFont = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jtaString = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton jbInsert = new javax.swing.JButton();
        jcbString = new javax.swing.JComboBox<>();
        javax.swing.JButton jbGenerate = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        jtaWynik = new javax.swing.JTextArea();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jrbSSzer = new javax.swing.JRadioButton();
        jrbZSzer = new javax.swing.JRadioButton();
        jrbSWys = new javax.swing.JRadioButton();
        jrbZWys = new javax.swing.JRadioButton();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JRadioButton jrbLiniaBajt = new javax.swing.JRadioButton();
        javax.swing.JRadioButton jrbZnakBajt = new javax.swing.JRadioButton();
        javax.swing.JRadioButton jrbCiag = new javax.swing.JRadioButton();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JRadioButton jrbMSB = new javax.swing.JRadioButton();
        javax.swing.JRadioButton jrbLSB = new javax.swing.JRadioButton();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        jrbTabPel = new javax.swing.JRadioButton();
        javax.swing.JRadioButton jrbTabNiepel = new javax.swing.JRadioButton();
        jrbTabPolPel = new javax.swing.JRadioButton();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "bitmap-font-generator.title" ) );
        setResizable( false );

        jbFont.setText( strings.getString( "bitmap-font-generator.change-font" ) );
        jbFont.addActionListener( this::jbFontActionPerformed );

        jtaString.setColumns( 1 );
        jtaString.setLineWrap( true );
        jtaString.setRows( 1 );
        jtaString.setMaximumSize( new java.awt.Dimension( 104, 64 ) );
        jScrollPane1.setViewportView( jtaString );

        jLabel1.setText( strings.getString( "bitmap-font-generator.characters-to-generate" ) );

        jbInsert.setText( strings.getString( "bitmap-font-generator.insert" ) );
        jbInsert.addActionListener( this::jbInsertActionPerformed );

        jcbString.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ "A-Z", "a-z", "A-Z, a-z", "0-9", strings.getString( "bitmap-font-generator.all-ascii" ), strings.getString( "bitmap-font-generator.polish-characters" ) } ) );

        jbGenerate.setText( strings.getString( "bitmap-font-generator.generate" ) );
        jbGenerate.addActionListener( this::jbGenerateActionPerformed );

        jtaWynik.setColumns( 20 );
        jtaWynik.setFont( new java.awt.Font( "Monospaced", Font.PLAIN, 12 ) );
        jtaWynik.setRows( 5 );
        jScrollPane2.setViewportView( jtaWynik );

        jLabel2.setText( strings.getString( "bitmap-font-generator.results" ) );

        jPanel1.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "bitmap-font-generator.character" ) ) );

        bgSzer.add( jrbSSzer );
        jrbSSzer.setText( strings.getString( "bitmap-font-generator.fixed-width" ) );

        bgSzer.add( jrbZSzer );
        jrbZSzer.setSelected( true );
        jrbZSzer.setText( strings.getString( "bitmap-font-generator.variable-width" ) );

        bgWys.add( jrbSWys );
        jrbSWys.setSelected( true );
        jrbSWys.setText( strings.getString( "bitmap-font-generator.fixed-height" ) );

        bgWys.add( jrbZWys );
        jrbZWys.setText( strings.getString( "bitmap-font-generator.variable-height" ) );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout( jPanel1 );
        jPanel1.setLayout( jPanel1Layout );
        jPanel1Layout.setHorizontalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbZSzer ).addComponent( jrbSSzer ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbSWys ).addComponent( jrbZWys ) ) ) );
        jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel1Layout.createSequentialGroup().addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jrbSSzer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbSWys, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( jPanel1Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jrbZSzer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbZWys, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) );

        jPanel2.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "bitmap-font-generator.data-type" ) ) );

        bgDane.add( jrbLiniaBajt );
        jrbLiniaBajt.setSelected( true );
        jrbLiniaBajt.setText( strings.getString( "bitmap-font-generator.data-type-separate-lines" ) );

        bgDane.add( jrbZnakBajt );
        jrbZnakBajt.setText( strings.getString( "bitmap-font-generator.data-type-separate-chars" ) );
        jrbZnakBajt.setEnabled( false );

        bgDane.add( jrbCiag );
        jrbCiag.setText( strings.getString( "bitmap-font-generator.data-type-packed" ) );
        jrbCiag.setEnabled( false );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbLiniaBajt ).addComponent( jrbZnakBajt ).addComponent( jrbCiag ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel2Layout.setVerticalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( jrbLiniaBajt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jrbZnakBajt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jrbCiag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) );

        jPanel3.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "bitmap-font-generator.data-endianness" ) ) );

        bgBajt.add( jrbMSB );
        jrbMSB.setSelected( true );
        jrbMSB.setText( "MSB" );

        bgBajt.add( jrbLSB );
        jrbLSB.setText( "LSB" );
        jrbLSB.setEnabled( false );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout( jPanel3 );
        jPanel3.setLayout( jPanel3Layout );
        jPanel3Layout.setHorizontalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addContainerGap().addComponent( jrbMSB ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jrbLSB ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel3Layout.setVerticalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jrbMSB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( jrbLSB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) );

        jPanel4.setBorder( javax.swing.BorderFactory.createTitledBorder( strings.getString( "bitmap-font-generator.character-description-array" ) ) );

        bgTablica.add( jrbTabPel );
        jrbTabPel.setText( strings.getString( "bitmap-font-generator.character-description-array-full-until-last-generated-char" ) );

        bgTablica.add( jrbTabNiepel );
        jrbTabNiepel.setSelected( true );
        jrbTabNiepel.setText( strings.getString( "bitmap-font-generator.character-description-array-only-generated" ) );

        bgTablica.add( jrbTabPolPel );
        jrbTabPolPel.setText( strings.getString( "bitmap-font-generator.character-description-array-full-between-characters" ) );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout( jPanel4 );
        jPanel4.setLayout( jPanel4Layout );
        jPanel4Layout.setHorizontalGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addContainerGap().addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jrbTabPel ).addComponent( jrbTabNiepel ).addComponent( jrbTabPolPel ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel4Layout.setVerticalGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addComponent( jrbTabPel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jrbTabPolPel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jrbTabNiepel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ) );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.TRAILING, false ).addComponent( jbFont, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jbGenerate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addComponent( jLabel1, javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addGroup( layout.createSequentialGroup().addComponent( jcbString, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jbInsert ) ).addComponent( jScrollPane1 ).addComponent( jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addComponent( jLabel2 ).addGap( 0, 0, Short.MAX_VALUE ) ).addGroup( layout.createSequentialGroup().addComponent( jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE ).addContainerGap() ) ) ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( jLabel1 ).addComponent( jLabel2 ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addComponent( jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jbFont, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false ).addComponent( jbInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE ).addComponent( jcbString ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jbGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 0, 0, Short.MAX_VALUE ) ).addComponent( jScrollPane2 ) ).addContainerGap() ) );

        pack();
    }

    String sortChars( String ch ) {
        int n = ch.length();
        //Tworzenie tablicy pomocniczej
        char t[];
        char temp;
        t = ch.toCharArray();
        while ( n > 1 ) //Sortowanie bąbelkowe
        {
            for ( int i = 0; i < n - 1; i++ ) {
                if ( t[i] > t[i + 1] ) {
                    temp = t[i];
                    t[i] = t[i + 1];
                    t[i + 1] = temp;
                }
            }
            n--;
        }
        return new String( t );
    }

    Rectangle2D getStringBounds( String characters, Font font ) {
        FontRenderContext rendCont = new FontRenderContext( null, true, true );
        BufferedImage bi = new BufferedImage( 10, 10, BufferedImage.TYPE_INT_RGB ); //Tworzymy jakikolwiek BI
        Graphics gr = bi.getGraphics(); //Zeby mozna go tu przypisac
        Graphics2D g = (Graphics2D) gr; //Tworzymy G2D
        g.setFont( font ); //Ustawiamy czcionke
        FontMetrics fm = g.getFontMetrics(); //Tworzymy FM do pomiarow
        int hmax = fm.getHeight(); //Max. wysokosc znaku, ale trzeba ja pomnozyc przez 2 dla niektorych znakow (dla pola G2D)
        //String t=characters.substring(i,i+1);
        int wmax = fm.stringWidth( characters ); //Max. szerokosc znaku
        GlyphVector gv = g.getFont().createGlyphVector( rendCont, characters ); //Tworzymy GV
        Rectangle2D bounds = gv.getPixelBounds( null, wmax / 2, hmax ); //Wyznaczamy granice znaku
        g.dispose();
        gr.dispose();
        bi.flush();
        return bounds;
    }

    int getMaxFontWidth( String characters, Font font ) {
        int t = 0;
        FontRenderContext rendCont = new FontRenderContext( null, true, true );
        BufferedImage bi = new BufferedImage( 10, 10, BufferedImage.TYPE_INT_RGB ); //Tworzymy jakikolwiek BI
        Graphics gr = bi.getGraphics(); //Zeby mozna go tu przypisac
        Graphics2D g = (Graphics2D) gr; //Tworzymy G2D
        g.setFont( font ); //Ustawiamy czcionke
        FontMetrics fm = g.getFontMetrics(); //Tworzymy FM do pomiarow
        for ( int i = 0; i < characters.length(); i++ ) {
            if ( fm.stringWidth( characters.substring( i, i + 1 ) ) > t )
                t = fm.stringWidth( characters.substring( i, i + 1 ) );
        }
        g.dispose();
        gr.dispose();
        bi.flush();
        return t;
    }

    void generateGlyphs( int fontSize, String characters, Font font ) {
        FontRenderContext rendCont = new FontRenderContext( null, true, true );
        /*
         * Potrzeba jeszcze: Ustalić najwyższy znak w zestawie i do niego dostosować wysokość reszty, - działa
         * opcje: stała wysokość, szerokość, zmienna wysokość, szerokość... - działa
         * Ustawienia: bity w ciągu, znak w ciągu, linia po linii, MSB, LSB
         * Dodawanie wizualizacji znaku jako komentarz, tablica z opisem znaków - wybór tablicy pełnej czy niepełnej
         * Dopracować dla niektórych czcionek "index out of bounds" - chyba działa
         */
        Rectangle2D strbounds = getStringBounds( characters, font ); //Wymiary wszystkich znaków
//        chwidth = Integer.toString( (int) Math.ceil( strbounds.getWidth() ) );
        chheight = Integer.toString( (int) Math.ceil( strbounds.getHeight() ) );
        int maxFontWidth = 0;
        char lastChar = 32;
        if ( jrbSSzer.isSelected() ) maxFontWidth = getMaxFontWidth( characters, font );
        int iindex = 0;
        for ( int i = 0; i < characters.length(); i++ ) {
            BufferedImage bi = new BufferedImage( 10, 10, BufferedImage.TYPE_INT_RGB ); //Tworzymy jakikolwiek BI
            Graphics gr = bi.getGraphics(); //Zeby mozna go tu przypisac
            Graphics2D g = (Graphics2D) gr; //Tworzymy G2D
            g.setFont( font ); //Ustawiamy czcionke
            FontMetrics fm = g.getFontMetrics(); //Tworzymy FM do pomiarow
            int hmax = 0, wmax = 0;
            hmax = fm.getHeight(); //Max. wysokosc znaku, ale trzeba ja pomnozyc przez 2 dla niektorych znakow (dla pola G2D)
            String t = characters.substring( i, i + 1 );
            if ( jrbSWys.isSelected() ) wmax = (int) Math.ceil( strbounds.getWidth() );
            else wmax = fm.stringWidth( t ); //Max. szerokosc znaku
            GlyphVector gv = g.getFont().createGlyphVector( rendCont, t ); //Tworzymy GV
            Rectangle2D bounds = gv.getPixelBounds( null, wmax / 2, hmax ); //Wyznaczamy granice znaku
            bi = new BufferedImage( wmax * 2, hmax * 2, BufferedImage.TYPE_INT_RGB ); //Tworzymy odpowiednio duży BI
            //int w = (int)Math.ceil(bounds.getWidth()); //Szerokosc znaku
            //int h = (int)Math.ceil(strbounds.getHeight()); //Wysokosc znaku //strbounds dla stałej wysokości znaku
            gr = bi.getGraphics(); //Nie wiem czy trzeba to powtarzac...
            g = (Graphics2D) gr; //j.w.
            g.setFont( font ); //j.w.
            int sx = 0, sy = 0, w = 0, h = 0;
            sx = (int) bounds.getX();
            w = (int) Math.ceil( bounds.getWidth() );
            if ( jrbSWys.isSelected() ) {//Poczatek znaku Y //strbounds dla stałej wysokości znaku
                sy = (int) strbounds.getY();
                h = (int) Math.ceil( strbounds.getHeight() );
            } else {
                sy = (int) bounds.getY();
                h = (int) Math.ceil( bounds.getHeight() );
            }
            g.drawString( t, wmax / 2, hmax );
            // JLabel picLabel = new JLabel(new ImageIcon(bi));

            //System.out.printf("%d %d\n",w,h);
            // picLabel.setSize(wmax*2,hmax*2);
            //  jPanel1.add(picLabel);
            // picLabel.repaint();
            int temp = 0, wsk = 128;
            String commentline = "";
            //Wypełnianie tablicy indexów pustymi wpisami, jeżeli trzeba
            if ( jrbTabPel.isSelected() || jrbTabPolPel.isSelected() ) {
                char tmp[] = t.toCharArray();
                if ( jrbTabPolPel.isSelected() && ( lastChar != 32 ) || jrbTabPel.isSelected() )
                    if ( tmp[0] != ( lastChar + 1 ) ) //Wykryto nieciągłość znaków
                    {
                        for ( int j = ( lastChar + 1 ); j < tmp[0]; j++ ) {
                            if ( jrbZWys.isSelected() && jrbZSzer.isSelected() )
                                index = index + "{0,0,0}, //" + Character.toString( (char) j ) + "\n";
                            else if ( jrbSWys.isSelected() && jrbSSzer.isSelected() )
                                index = index + "{0}, //" + Character.toString( (char) j ) + "\n";
                            else index = index + "{0,0}, //" + Character.toString( (char) j ) + "\n";
                        }
                    }
                lastChar = tmp[0];
            }
            ///
            if ( jrbSWys.isSelected() && jrbZSzer.isSelected() )
                index = index + "{" + Integer.toString( w ) + ", " + Integer.toString( iindex ) + "}, //" + t + "\n";
            else if ( jrbZWys.isSelected() && jrbSSzer.isSelected() )
                index = index + "{" + Integer.toString( h ) + ", " + Integer.toString( iindex ) + "}, //" + t + "\n";
            else if ( jrbZWys.isSelected() && jrbZSzer.isSelected() )
                index = index + "{" + Integer.toString( w ) + ", " + Integer.toString( h ) + ", " + Integer.toString( iindex ) + "}, //" + t + "\n";
            else index = index + "{" + Integer.toString( iindex ) + "}, //" + t + "\n";
            //Obliczamy jeżeli stała szerokość ile dodać zer na początku i końcu
            int z1 = (int) Math.round( ( maxFontWidth - w ) / 2 );
            int z2 = maxFontWidth - w - z1;
            //\\//
            for ( int yy = sy; yy < sy + h; yy++ ) { //"Wyciagamy" narysowany na nadmiarowej plaszczyznie znak i obrabiamy
                if ( !jrbSSzer.isSelected() ) //Dla wszystkich innych niż ze stałą szerkością
                    for ( int xx = sx; xx < sx + w; xx++ ) {
                        //if(bi.getRGB(xx, yy)==-16777216) System.out.printf(" "); else System.out.printf("O");
                        if ( bi.getRGB( xx, yy ) != -16777216 ) {
                            commentline = commentline + "O";
                            temp = temp + wsk;
                        } else commentline = commentline + " ";
                        if ( wsk > 1 ) wsk /= 2;
                        else {
                            wsk = 128;
                            jtaWynik.append( "0x" + Integer.toHexString( 0x100 | temp ).substring( 1 ) + ", " );
                            iindex++;
                            temp = 0;
                        }
                    }
                else for ( int xx = sx - z1; xx < sx + w + z2; xx++ ) {
                    //if(bi.getRGB(xx, yy)==-16777216) System.out.printf(" "); else System.out.printf("O");
                    if ( xx < sx )//Zera na począktu
                    {
                        commentline = commentline + " ";
                    } else if ( xx >= ( sx + w ) ) { //Zera na końcu
                        commentline = commentline + " ";
                    } else if ( bi.getRGB( xx, yy ) != -16777216 ) {
                        commentline = commentline + "O";
                        temp = temp + wsk;
                    } else commentline = commentline + " ";
                    if ( wsk > 1 ) wsk /= 2;
                    else {
                        wsk = 128;
                        jtaWynik.append( "0x" + Integer.toHexString( 0x100 | temp ).substring( 1 ) + ", " );
                        iindex++;
                        temp = 0;
                    }
                }
                if ( wsk != 128 || temp != 0 ) {
                    jtaWynik.append( "0x" + Integer.toHexString( 0x100 | temp ).substring( 1 ) + ", //" + commentline + "\n" );
                    iindex++;
                } else jtaWynik.append( "//" + commentline + "\n" );
                wsk = 128;
                temp = 0;
                commentline = "";
            }
            jtaWynik.append( "\n" );
        }
    }

    private void jbFontActionPerformed( java.awt.event.ActionEvent evt ) {
        int result = fc.showDialog( this );
        if ( result == JFontChooser.OK_OPTION ) {
            jtaString.setFont( fc.getSelectedFont() );
        }
    }

    private void jbInsertActionPerformed( java.awt.event.ActionEvent evt ) {
        if ( jcbString.getSelectedIndex() == 0 ) jtaString.append( "ABCDEFGHIJKLMNOPQRSTUWXYZ" );
        else if ( jcbString.getSelectedIndex() == 1 ) jtaString.append( "abcdefghijklmnopqrstuwxyz" );
        else if ( jcbString.getSelectedIndex() == 2 )
            jtaString.append( "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuwxyz" );
        else if ( jcbString.getSelectedIndex() == 3 ) jtaString.append( "0123456789" );
        else if ( jcbString.getSelectedIndex() == 4 )
            jtaString.append( "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~" );
        else if ( jcbString.getSelectedIndex() == 5 ) jtaString.append( "ĄĆĘŁŃÓŚŻŹąćęłńóśżź" );
    }

    private void jbGenerateActionPerformed( java.awt.event.ActionEvent evt ) {
        jtaString.setText( sortChars( jtaString.getText().replaceAll( "\\s+", "" ) ) );
        index = "";
        jtaWynik.setText( "const char " + fc.getSelectedFont().getName() + Integer.toString( fc.getSelectedFont().getSize() ) + "ptBitmap[] = {\n" );
        generateGlyphs( fc.getSelectedFontSize(), jtaString.getText(), fc.getSelectedFont() );
        jtaWynik.append( "};\n\n//" + strings.getString( "bitmap-font-generator.character-height" ) + "\n" );
        jtaWynik.append( "const char " + fc.getSelectedFont().getName() + Integer.toString( fc.getSelectedFont().getSize() ) + "ptHeight = " + chheight + ";\n" );

        if ( jrbSWys.isSelected() && jrbZSzer.isSelected() ) {
            jtaWynik.append( "//{[" + strings.getString( "bitmap-font-generator.width" ) + "],[" + strings.getString( "bitmap-font-generator.first-byte-index" ) + "]}\n" );
            jtaWynik.append( "const unsigned int " + fc.getSelectedFont().getName() + Integer.toString( fc.getSelectedFont().getSize() ) + "ptIndex[][2] = {\n" );
        } else if ( jrbZWys.isSelected() && jrbSSzer.isSelected() ) {
            jtaWynik.append( "//{[" + strings.getString( "bitmap-font-generator.height" ) + "],[" + strings.getString( "bitmap-font-generator.first-byte-index" ) + "]}\n" );
            jtaWynik.append( "const unsigned int " + fc.getSelectedFont().getName() + Integer.toString( fc.getSelectedFont().getSize() ) + "ptIndex[][2] = {\n" );
        } else if ( jrbZWys.isSelected() && jrbZSzer.isSelected() ) {
            jtaWynik.append( "//{[" + strings.getString( "bitmap-font-generator.width" ) + "],[" + strings.getString( "bitmap-font-generator.height" ) + "],[" + strings.getString( "bitmap-font-generator.first-byte-index" ) + "]}\n" );
            jtaWynik.append( "const unsigned int " + fc.getSelectedFont().getName() + Integer.toString( fc.getSelectedFont().getSize() ) + "ptIndex[][3] = {\n" );
        } else {
            jtaWynik.append( "//{[" + strings.getString( "bitmap-font-generator.first-byte-index" ) + "]}\n" );
            jtaWynik.append( "const unsigned int " + fc.getSelectedFont().getName() + Integer.toString( fc.getSelectedFont().getSize() ) + "ptIndex[] = {\n" );
        }


        jtaWynik.append( index + "};" );
    }
}
