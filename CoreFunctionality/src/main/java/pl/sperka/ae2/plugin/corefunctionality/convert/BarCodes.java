package pl.sperka.ae2.plugin.corefunctionality.convert;

/*
 * Created on 2011-06-23, 22:56:10
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class BarCodes extends javax.swing.JFrame {
    private static final Logger logger = LogManager.getLogger( BarCodes.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.convert.Strings" );
    private javax.swing.JComboBox< String > cbDlaP1;
    private javax.swing.JComboBox< String > cbDlaP2;
    private javax.swing.JComboBox< String > cbDlaP3;
    private javax.swing.JComboBox< String > cbDlaP4;
    private javax.swing.JComboBox< String > cbKondP1;
    private javax.swing.JComboBox< String > cbKondP2;
    private javax.swing.JComboBox< String > cbKondP3;
    private javax.swing.JComboBox< String > cbKondP4;
    private javax.swing.JComboBox< String > cbKondP5;
    private javax.swing.JComboBox< String > cbRezP1;
    private javax.swing.JComboBox< String > cbRezP2;
    private javax.swing.JComboBox< String > cbRezP3;
    private javax.swing.JComboBox< String > cbRezP4;
    private javax.swing.JComboBox< String > cbRezP5;
    private javax.swing.JComboBox< String > cbRezP6;
    private javax.swing.JLabel lblDlaWynik;
    private javax.swing.JLabel lblKondWynik;
    private javax.swing.JLabel lblRezWynik;
    private javax.swing.JPanel panDlaRys;
    private javax.swing.JPanel panKondRys;
    private javax.swing.JPanel panRezRys;

    public BarCodes( Component parent ) {
        initComponents();
        CalculateResistor();
        CalculateCoil();
        CalculateCapacitor();
        setLocationRelativeTo( parent );
    }

    private Color getColor( String nazwa ) {
        Color kolor = null;
        float[] hsb;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.black" ) ) ) kolor = Color.black;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.brown" ) ) ) {
            hsb = Color.RGBtoHSB( 88, 57, 30, null );
            kolor = Color.getHSBColor( hsb[0], hsb[1], hsb[2] );
        }
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.red" ) ) ) kolor = Color.red;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.orange" ) ) ) {
            hsb = Color.RGBtoHSB( 255, 100, 0, null );
            kolor = Color.getHSBColor( hsb[0], hsb[1], hsb[2] );
        }
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.yellow" ) ) ) kolor = Color.yellow;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.green" ) ) ) kolor = Color.green;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.blue" ) ) ) kolor = Color.blue;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.violet" ) ) ) {
            hsb = Color.RGBtoHSB( 156, 0, 255, null );
            kolor = Color.getHSBColor( hsb[0], hsb[1], hsb[2] );
        }
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.grey" ) ) ) kolor = Color.gray;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.white" ) ) ) kolor = Color.white;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.silver" ) ) ) kolor = Color.lightGray;
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.gold" ) ) ) {
            hsb = Color.RGBtoHSB( 255, 190, 0, null );
            kolor = Color.getHSBColor( hsb[0], hsb[1], hsb[2] );
        }
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.sand" ) ) ) {
            hsb = Color.RGBtoHSB( 255, 240, 174, null );
            kolor = Color.getHSBColor( hsb[0], hsb[1], hsb[2] );
        }
        if ( nazwa.equalsIgnoreCase( strings.getString( "bar-codes.bar-missing" ) ) ) {
            hsb = Color.RGBtoHSB( 255, 240, 174, null );
            kolor = Color.getHSBColor( hsb[0], hsb[1], hsb[2] );
        }
        return kolor;
    }

    private String roundFloat( double f ) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits( 2 );
        nf.setMinimumFractionDigits( 2 );
        return nf.format( f );
    }

    private double getRezMultiplier( JComboBox< String > jcb ) {
        double multiplier = 0;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.gold" ) ) )
            multiplier = 0.1f;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.silver" ) ) )
            multiplier = 0.01f;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.black" ) ) )
            multiplier = 1;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.bar-missing" ) ) )
            multiplier = 1;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.brown" ) ) )
            multiplier = 10;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.red" ) ) )
            multiplier = 100;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.orange" ) ) )
            multiplier = 1000;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.yellow" ) ) )
            multiplier = 10000;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.green" ) ) )
            multiplier = 100000;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.blue" ) ) )
            multiplier = 1000000;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.violet" ) ) )
            multiplier = 10000000;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.grey" ) ) )
            multiplier = 100000000;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.white" ) ) )
            multiplier = 1000000000;
        return multiplier;
    }

    private float getRezPrecision( JComboBox< String > jcb ) {
        float prec = 0;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.brown" ) ) ) prec = 1;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.red" ) ) ) prec = 2;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.green" ) ) ) prec = 0.5f;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.blue" ) ) ) prec = 0.25f;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.violet" ) ) ) prec = 0.1f;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.silver" ) ) ) prec = 10;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.gold" ) ) ) prec = 5;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.bar-missing" ) ) )
            prec = 20;
        return prec;
    }

    private int getRezTempPrecision( JComboBox< String > jcb ) {
        int wsptemp = 0;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.black" ) ) )
            wsptemp = 200;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.brown" ) ) )
            wsptemp = 100;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.red" ) ) ) wsptemp = 50;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.orange" ) ) )
            wsptemp = 25;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.yellow" ) ) )
            wsptemp = 15;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.green" ) ) ) wsptemp = 10;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.blue" ) ) ) wsptemp = 5;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.violet" ) ) ) wsptemp = 2;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.grey" ) ) ) wsptemp = 1;
        return wsptemp;
    }

    private String prefixToString( int prefix ) {
        String strpref = null;
        if ( prefix == 0 ) strpref = "p";
        if ( prefix == 1 ) strpref = "n";
        if ( prefix == 2 ) strpref = "u";
        if ( prefix == 3 ) strpref = "m";
        if ( prefix == 4 ) strpref = "";
        if ( prefix == 5 ) strpref = "k";
        if ( prefix == 6 ) strpref = "M";
        if ( prefix == 7 ) strpref = "G";
        return strpref;
    }

    private int getRezBarValue( JComboBox< String > jcb ) {
        int value = 0;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.black" ) ) ) value = 0;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.brown" ) ) ) value = 1;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.red" ) ) ) value = 2;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.orange" ) ) ) value = 3;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.yellow" ) ) ) value = 4;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.green" ) ) ) value = 5;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.blue" ) ) ) value = 6;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.violet" ) ) ) value = 7;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.grey" ) ) ) value = 8;
        if ( jcb.getSelectedItem().toString().equalsIgnoreCase( strings.getString( "bar-codes.white" ) ) ) value = 9;
        return value;
    }

    private void CalculateResistor() {
        double rez = 0, multiplier = 0;
        int prefix = 0;
        if ( cbRezP4.getSelectedIndex() == 0 && cbRezP5.getSelectedIndex() == 0 && cbRezP6.getSelectedIndex() == 0 ) {
            Rysuj( panRezRys, getColor( strings.getString( "bar-codes.sand" ) ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbRezP1.getSelectedItem().toString() ), getColor( cbRezP2.getSelectedItem().toString() ), getColor( cbRezP3.getSelectedItem().toString() ), getColor( strings.getString( "bar-codes.sand" ) ) );
            if ( getRezMultiplier( cbRezP3 ) < 100 ) {
                multiplier = getRezMultiplier( cbRezP3 );
                prefix = 4;
            }
            if ( getRezMultiplier( cbRezP3 ) >= 100 && getRezMultiplier( cbRezP3 ) < 100000 ) {
                multiplier = getRezMultiplier( cbRezP3 ) / 1000;
                prefix = 5;
            }
            if ( getRezMultiplier( cbRezP3 ) >= 100000 && getRezMultiplier( cbRezP3 ) < 100000000 ) {
                multiplier = getRezMultiplier( cbRezP3 ) / 1000000;
                prefix = 6;
            }
            if ( getRezMultiplier( cbRezP3 ) >= 100000000 ) {
                multiplier = getRezMultiplier( cbRezP3 ) / 1000000000;
                prefix = 7;
            }
            rez = ( ( 10 * getRezBarValue( cbRezP1 ) ) + getRezBarValue( cbRezP2 ) ) * multiplier;
            lblRezWynik.setText( "<HTML>" + strings.getString( "bar-codes.resistance" ) + roundFloat( rez ) + " " + prefixToString( prefix ) + "Ohm" + "<BR>" + strings.getString( "bar-codes.tolerance" ) + "20%</HTML>" );
        } else if ( cbRezP5.getSelectedIndex() == 0 && cbRezP6.getSelectedIndex() == 0 ) {
            Rysuj( panRezRys, getColor( strings.getString( "bar-codes.sand" ) ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbRezP1.getSelectedItem().toString() ), getColor( cbRezP2.getSelectedItem().toString() ), getColor( cbRezP3.getSelectedItem().toString() ), getColor( cbRezP4.getSelectedItem().toString() ) );
            if ( getRezMultiplier( cbRezP3 ) < 100 ) {
                multiplier = getRezMultiplier( cbRezP3 );
                prefix = 4;
            }
            if ( getRezMultiplier( cbRezP3 ) >= 100 && getRezMultiplier( cbRezP3 ) < 100000 ) {
                multiplier = getRezMultiplier( cbRezP3 ) / 1000;
                prefix = 5;
            }
            if ( getRezMultiplier( cbRezP3 ) >= 100000 && getRezMultiplier( cbRezP3 ) < 100000000 ) {
                multiplier = getRezMultiplier( cbRezP3 ) / 1000000;
                prefix = 6;
            }
            if ( getRezMultiplier( cbRezP3 ) >= 100000000 ) {
                multiplier = getRezMultiplier( cbRezP3 ) / 1000000000;
                prefix = 7;
            }
            rez = ( ( 10 * getRezBarValue( cbRezP1 ) ) + getRezBarValue( cbRezP2 ) ) * multiplier;
            lblRezWynik.setText( "<HTML>" + strings.getString( "bar-codes.resistance" ) + roundFloat( rez ) + " " + prefixToString( prefix ) + "Ohm" + "<BR>" + strings.getString( "bar-codes.tolerance" ) + Float.toString( getRezPrecision( cbRezP4 ) ) + "%</HTML>" );
        } else if ( cbRezP6.getSelectedIndex() == 0 ) {
            Rysuj( panRezRys, getColor( strings.getString( "bar-codes.sand" ) ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbRezP1.getSelectedItem().toString() ), getColor( cbRezP2.getSelectedItem().toString() ), getColor( cbRezP3.getSelectedItem().toString() ), getColor( cbRezP4.getSelectedItem().toString() ), getColor( cbRezP5.getSelectedItem().toString() ) );
            if ( getRezMultiplier( cbRezP4 ) < 10 ) {
                multiplier = getRezMultiplier( cbRezP4 );
                prefix = 4;
            }
            if ( getRezMultiplier( cbRezP4 ) >= 10 && getRezMultiplier( cbRezP4 ) < 10000 ) {
                multiplier = getRezMultiplier( cbRezP4 ) / 1000;
                prefix = 5;
            }
            if ( getRezMultiplier( cbRezP4 ) >= 10000 && getRezMultiplier( cbRezP4 ) < 10000000 ) {
                multiplier = getRezMultiplier( cbRezP4 ) / 1000000;
                prefix = 6;
            }
            if ( getRezMultiplier( cbRezP4 ) >= 10000000 ) {
                multiplier = getRezMultiplier( cbRezP4 ) / 1000000000;
                prefix = 7;
            }
            rez = ( ( 100 * getRezBarValue( cbRezP1 ) ) + ( 10 * getRezBarValue( cbRezP2 ) ) + getRezBarValue( cbRezP3 ) ) * multiplier;
            lblRezWynik.setText( "<HTML>" + strings.getString( "bar-codes.resistance" ) + roundFloat( rez ) + " " + prefixToString( prefix ) + "Ohm" + "<BR>" + strings.getString( "bar-codes.tolerance" ) + Float.toString( getRezPrecision( cbRezP5 ) ) + "%</HTML>" );
        } else {
            Rysuj( panRezRys, getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbRezP1.getSelectedItem().toString() ), getColor( cbRezP2.getSelectedItem().toString() ), getColor( cbRezP3.getSelectedItem().toString() ), getColor( cbRezP4.getSelectedItem().toString() ), getColor( cbRezP5.getSelectedItem().toString() ), getColor( cbRezP6.getSelectedItem().toString() ) );
            if ( getRezMultiplier( cbRezP4 ) < 10 ) {
                multiplier = getRezMultiplier( cbRezP4 );
                prefix = 4;
            }
            if ( getRezMultiplier( cbRezP4 ) >= 10 && getRezMultiplier( cbRezP4 ) < 10000 ) {
                multiplier = getRezMultiplier( cbRezP4 ) / 1000;
                prefix = 5;
            }
            if ( getRezMultiplier( cbRezP4 ) >= 10000 && getRezMultiplier( cbRezP4 ) < 10000000 ) {
                multiplier = getRezMultiplier( cbRezP4 ) / 1000000;
                prefix = 6;
            }
            if ( getRezMultiplier( cbRezP4 ) >= 10000000 ) {
                multiplier = getRezMultiplier( cbRezP4 ) / 1000000000;
                prefix = 7;
            }
            rez = ( ( 100 * getRezBarValue( cbRezP1 ) ) + ( 10 * getRezBarValue( cbRezP2 ) ) + getRezBarValue( cbRezP3 ) ) * multiplier;
            lblRezWynik.setText( "<HTML>" + strings.getString( "bar-codes.resistance" ) + roundFloat( rez ) + " " + prefixToString( prefix ) + "Ohm" + "<BR>" + strings.getString( "bar-codes.tolerance" ) + Float.toString( getRezPrecision( cbRezP5 ) ) + "%" + "<BR>" + strings.getString( "bar-codes.temperature-coefficient" ) + Integer.toString( getRezTempPrecision( cbRezP6 ) ) + " ppm/K</HTML>" );
        }
    }

    private void CalculateCoil() {
        double ind = 0, multiplier = 0;
        int prefix = 0;
        Rysuj( panDlaRys, getColor( strings.getString( "bar-codes.sand" ) ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbDlaP1.getSelectedItem().toString() ), getColor( cbDlaP2.getSelectedItem().toString() ), getColor( cbDlaP3.getSelectedItem().toString() ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbDlaP4.getSelectedItem().toString() ) );
        if ( getRezMultiplier( cbDlaP3 ) < 0.1 ) {
            multiplier = getRezMultiplier( cbDlaP3 ) * 1000;
            prefix = 1;
        }
        if ( getRezMultiplier( cbDlaP3 ) >= 0.1 && getRezMultiplier( cbDlaP3 ) < 100 ) {
            multiplier = getRezMultiplier( cbDlaP3 );
            prefix = 2;
        }
        if ( getRezMultiplier( cbDlaP3 ) >= 100 && getRezMultiplier( cbDlaP3 ) < 100000 ) {
            multiplier = getRezMultiplier( cbDlaP3 ) / 1000;
            prefix = 3;
        }
        if ( getRezMultiplier( cbDlaP3 ) >= 100000 && getRezMultiplier( cbDlaP3 ) < 100000000 ) {
            multiplier = getRezMultiplier( cbDlaP3 ) / 1000000;
            prefix = 4;
        }
        if ( getRezMultiplier( cbDlaP3 ) >= 100000000 ) {
            multiplier = getRezMultiplier( cbDlaP3 ) / 1000000000;
            prefix = 5;
        }
        ind = ( ( 10 * getRezBarValue( cbDlaP1 ) ) + getRezBarValue( cbDlaP2 ) ) * multiplier;
        lblDlaWynik.setText( "<HTML>" + strings.getString( "bar-codes.inductance" ) + roundFloat( ind ) + " " + prefixToString( prefix ) + "H" + "<BR>" + strings.getString( "bar-codes.tolerance" ) + Float.toString( getRezPrecision( cbDlaP4 ) ) + "%</HTML>" );
    }

    private void CalculateCapacitor() {
        double poj = 0, multiplier = 0;
        int prefix = 0;
        Rysuj( panKondRys, getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbKondP1.getSelectedItem().toString() ), getColor( cbKondP2.getSelectedItem().toString() ), getColor( cbKondP3.getSelectedItem().toString() ), getColor( strings.getString( "bar-codes.sand" ) ), getColor( cbKondP4.getSelectedItem().toString() ), getColor( cbKondP5.getSelectedItem().toString() ) );
        if ( getRezMultiplier( cbKondP3 ) < 100 ) {
            multiplier = getRezMultiplier( cbKondP3 );
            prefix = 0;
        }
        if ( getRezMultiplier( cbKondP3 ) >= 100 && getRezMultiplier( cbKondP3 ) < 100000 ) {
            multiplier = getRezMultiplier( cbKondP3 ) / 1000;
            prefix = 1;
        }
        if ( getRezMultiplier( cbKondP3 ) >= 100000 && getRezMultiplier( cbKondP3 ) < 100000000 ) {
            multiplier = getRezMultiplier( cbKondP3 ) / 1000000;
            prefix = 2;
        }
        if ( getRezMultiplier( cbKondP3 ) >= 100000000 ) {
            multiplier = getRezMultiplier( cbKondP3 ) / 1000000000;
            prefix = 3;
        }
        poj = ( ( 10 * getRezBarValue( cbKondP1 ) ) + getRezBarValue( cbKondP2 ) ) * multiplier;
        if ( cbKondP5.getSelectedIndex() == 0 ) {
            lblKondWynik.setText( "<HTML>" + strings.getString( "bar-codes.capacitance" ) + roundFloat( poj ) + " " + prefixToString( prefix ) + "F" + "<BR>" + strings.getString( "bar-codes.tolerance" ) + Float.toString( getRezPrecision( cbKondP4 ) ) + "%</HTML>" );
        } else {
            lblKondWynik.setText( "<HTML>" + strings.getString( "bar-codes.capacitance" ) + roundFloat( poj ) + " " + prefixToString( prefix ) + "F" + "<BR>" + strings.getString( "bar-codes.tolerance" ) + Float.toString( getRezPrecision( cbKondP4 ) ) + "%" + "<BR>" + strings.getString( "bar-codes.temperature-coefficient" ) + Integer.toString( getRezTempPrecision( cbKondP5 ) ) + " ppm/K</HTML>" );
        }
    }

    private void Rysuj( JPanel panel, Color background, Color bar1, Color bar2, Color bar3, Color bar4, Color bar5, Color bar6 ) {
        panel.removeAll();
        panel.repaint();
        BufferedImage img = new BufferedImage( 260, 70, BufferedImage.TYPE_INT_ARGB );
        Graphics2D g2d = img.createGraphics();
        g2d.setColor( background );
        g2d.fillRect( 20, 0, 220, 70 );
        g2d.setColor( Color.black );
        g2d.drawLine( 0, 35, 20, 35 );
        g2d.drawLine( 240, 35, 260, 35 );
        g2d.setColor( bar1 );
        g2d.fillRect( 30, 0, 25, 70 );
        g2d.setColor( bar2 );
        g2d.fillRect( 65, 0, 25, 70 );
        g2d.setColor( bar3 );
        g2d.fillRect( 100, 0, 25, 70 );
        g2d.setColor( bar4 );
        g2d.fillRect( 135, 0, 25, 70 );
        g2d.setColor( bar5 );
        g2d.fillRect( 170, 0, 25, 70 );
        g2d.setColor( bar6 );
        g2d.fillRect( 205, 0, 25, 70 );
        JLabel label = new JLabel( new ImageIcon( img ) );
        label.setSize( 260, 70 );
        panel.add( label );
        label.repaint();
    }

    private void initComponents() {

        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel2 = new JPanel();
        panRezRys = new javax.swing.JPanel();
        cbRezP1 = new javax.swing.JComboBox<>();
        cbRezP2 = new javax.swing.JComboBox<>();
        cbRezP3 = new javax.swing.JComboBox<>();
        cbRezP4 = new javax.swing.JComboBox<>();
        cbRezP5 = new javax.swing.JComboBox<>();
        cbRezP6 = new javax.swing.JComboBox<>();
        lblRezWynik = new javax.swing.JLabel();
        JPanel jPanel3 = new JPanel();
        panKondRys = new javax.swing.JPanel();
        cbKondP1 = new javax.swing.JComboBox<>();
        lblKondWynik = new javax.swing.JLabel();
        cbKondP2 = new javax.swing.JComboBox<>();
        cbKondP3 = new javax.swing.JComboBox<>();
        cbKondP4 = new javax.swing.JComboBox<>();
        cbKondP5 = new javax.swing.JComboBox<>();
        JPanel jPanel4 = new JPanel();
        panDlaRys = new javax.swing.JPanel();
        cbDlaP1 = new javax.swing.JComboBox<>();
        cbDlaP2 = new javax.swing.JComboBox<>();
        cbDlaP3 = new javax.swing.JComboBox<>();
        cbDlaP4 = new javax.swing.JComboBox<>();
        lblDlaWynik = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( strings.getString( "bar-codes.title" ) );
        setResizable( false );

        panRezRys.setPreferredSize( new java.awt.Dimension( 260, 100 ) );

        javax.swing.GroupLayout panRezRysLayout = new javax.swing.GroupLayout( panRezRys );
        panRezRys.setLayout( panRezRysLayout );
        panRezRysLayout.setHorizontalGroup( panRezRysLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 260, Short.MAX_VALUE ) );
        panRezRysLayout.setVerticalGroup( panRezRysLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 100, Short.MAX_VALUE ) );

        cbRezP1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbRezP1.addItemListener( this::cbRezP1ItemStateChanged );

        cbRezP2.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbRezP2.addItemListener( this::cbRezP2ItemStateChanged );

        cbRezP3.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.gold" ), strings.getString( "bar-codes.silver" ), strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbRezP3.addItemListener( this::cbRezP3ItemStateChanged );

        cbRezP4.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.bar-missing" ), strings.getString( "bar-codes.gold" ), strings.getString( "bar-codes.silver" ), strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbRezP4.addItemListener( this::cbRezP4ItemStateChanged );

        cbRezP5.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.bar-missing" ), strings.getString( "bar-codes.gold" ), strings.getString( "bar-codes.silver" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ) } ) );
        cbRezP5.addItemListener( this::cbRezP5ItemStateChanged );

        cbRezP6.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.bar-missing" ), strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ) } ) );
        cbRezP6.addItemListener( this::cbRezP6ItemStateChanged );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
        jPanel2.setLayout( jPanel2Layout );
        jPanel2Layout.setHorizontalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addGap( 12, 12, 12 ).addComponent( lblRezWynik ) ).addGroup( jPanel2Layout.createSequentialGroup().addComponent( cbRezP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbRezP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbRezP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbRezP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbRezP5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 6, 6, 6 ).addComponent( cbRezP6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) ).addGroup( jPanel2Layout.createSequentialGroup().addGap( 195, 195, 195 ).addComponent( panRezRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
        jPanel2Layout.setVerticalGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel2Layout.createSequentialGroup().addContainerGap().addComponent( panRezRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 13, 13, 13 ).addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( cbRezP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbRezP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbRezP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbRezP5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbRezP6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbRezP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( lblRezWynik ).addContainerGap( 63, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "bar-codes.resistor" ), jPanel2 );

        panKondRys.setPreferredSize( new java.awt.Dimension( 260, 100 ) );

        javax.swing.GroupLayout panKondRysLayout = new javax.swing.GroupLayout( panKondRys );
        panKondRys.setLayout( panKondRysLayout );
        panKondRysLayout.setHorizontalGroup( panKondRysLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 260, Short.MAX_VALUE ) );
        panKondRysLayout.setVerticalGroup( panKondRysLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 100, Short.MAX_VALUE ) );

        cbKondP1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbKondP1.addItemListener( this::cbKondP1ItemStateChanged );

        cbKondP2.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbKondP2.addItemListener( this::cbKondP2ItemStateChanged );

        cbKondP3.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.bar-missing" ), strings.getString( "bar-codes.gold" ), strings.getString( "bar-codes.silver" ), strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbKondP3.addItemListener( this::cbKondP3ItemStateChanged );

        cbKondP4.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.bar-missing" ), strings.getString( "bar-codes.gold" ), strings.getString( "bar-codes.silver" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ) } ) );
        cbKondP4.addItemListener( this::cbKondP4ItemStateChanged );

        cbKondP5.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.bar-missing" ), strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ) } ) );
        cbKondP5.addItemListener( this::cbKondP5ItemStateChanged );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout( jPanel3 );
        jPanel3.setLayout( jPanel3Layout );
        jPanel3Layout.setHorizontalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addGap( 195, 195, 195 ).addComponent( panKondRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGroup( jPanel3Layout.createSequentialGroup().addContainerGap().addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addGap( 12, 12, 12 ).addComponent( lblKondWynik ) ).addGroup( jPanel3Layout.createSequentialGroup().addComponent( cbKondP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbKondP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbKondP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbKondP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED ).addComponent( cbKondP5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) ) ).addContainerGap( 116, Short.MAX_VALUE ) ) );
        jPanel3Layout.setVerticalGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel3Layout.createSequentialGroup().addGap( 6, 6, 6 ).addComponent( panKondRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addGroup( jPanel3Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( cbKondP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbKondP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbKondP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbKondP5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbKondP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( lblKondWynik ).addContainerGap( 63, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "bar-codes.capacitor" ), jPanel3 );

        panDlaRys.setPreferredSize( new java.awt.Dimension( 260, 100 ) );

        javax.swing.GroupLayout panDlaRysLayout = new javax.swing.GroupLayout( panDlaRys );
        panDlaRys.setLayout( panDlaRysLayout );
        panDlaRysLayout.setHorizontalGroup( panDlaRysLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 260, Short.MAX_VALUE ) );
        panDlaRysLayout.setVerticalGroup( panDlaRysLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0, 100, Short.MAX_VALUE ) );

        cbDlaP1.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbDlaP1.addItemListener( this::cbDlaP1ItemStateChanged );

        cbDlaP2.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbDlaP2.addItemListener( this::cbDlaP2ItemStateChanged );

        cbDlaP3.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.gold" ), strings.getString( "bar-codes.silver" ), strings.getString( "bar-codes.black" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.orange" ), strings.getString( "bar-codes.yellow" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ), strings.getString( "bar-codes.grey" ), strings.getString( "bar-codes.white" ) } ) );
        cbDlaP3.addItemListener( this::cbDlaP3ItemStateChanged );

        cbDlaP4.setModel( new javax.swing.DefaultComboBoxModel<>( new String[]{ strings.getString( "bar-codes.bar-missing" ), strings.getString( "bar-codes.gold" ), strings.getString( "bar-codes.silver" ), strings.getString( "bar-codes.brown" ), strings.getString( "bar-codes.red" ), strings.getString( "bar-codes.green" ), strings.getString( "bar-codes.blue" ), strings.getString( "bar-codes.violet" ) } ) );
        cbDlaP4.addItemListener( this::cbDlaP4ItemStateChanged );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout( jPanel4 );
        jPanel4.setLayout( jPanel4Layout );
        jPanel4Layout.setHorizontalGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addContainerGap().addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addGap( 12, 12, 12 ).addComponent( lblDlaWynik ) ).addGroup( jPanel4Layout.createSequentialGroup().addComponent( cbDlaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addComponent( cbDlaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addComponent( cbDlaP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 18, 18, 18 ).addComponent( cbDlaP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE ) ) ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ).addGroup( javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap( 196, Short.MAX_VALUE ).addComponent( panDlaRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addGap( 194, 194, 194 ) ) );
        jPanel4Layout.setVerticalGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( jPanel4Layout.createSequentialGroup().addContainerGap().addComponent( panDlaRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addGroup( jPanel4Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE ).addComponent( cbDlaP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbDlaP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbDlaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ).addComponent( cbDlaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE ) ).addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED ).addComponent( lblDlaWynik ).addContainerGap( 65, Short.MAX_VALUE ) ) );

        jTabbedPane1.addTab( strings.getString( "bar-codes.coil" ), jPanel4 );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jTabbedPane1 ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE ).addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

        pack();
    }

    private void cbRezP1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateResistor();
    }

    private void cbRezP2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateResistor();
    }

    private void cbRezP3ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateResistor();
    }

    private void cbRezP4ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( cbRezP4.getSelectedIndex() == 0 ) {
            cbRezP5.setSelectedIndex( 0 );
            cbRezP6.setSelectedIndex( 0 );
        }
        CalculateResistor();
    }

    private void cbRezP5ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( cbRezP5.getSelectedIndex() == 0 ) cbRezP6.setSelectedIndex( 0 );
        CalculateResistor();
    }

    private void cbRezP6ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateResistor();
    }

    private void cbDlaP1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateCoil();
    }

    private void cbDlaP2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateCoil();
    }

    private void cbDlaP3ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateCoil();
    }

    private void cbDlaP4ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateCoil();
    }

    private void cbKondP1ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateCapacitor();
    }

    private void cbKondP2ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateCapacitor();
    }

    private void cbKondP3ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( cbKondP3.getSelectedIndex() == 0 ) {
            cbKondP4.setSelectedIndex( 0 );
            cbKondP5.setSelectedIndex( 0 );
        }
        CalculateCapacitor();
    }

    private void cbKondP4ItemStateChanged( java.awt.event.ItemEvent evt ) {
        if ( cbKondP4.getSelectedIndex() == 0 ) {
            cbKondP5.setSelectedIndex( 0 );
        }
        CalculateCapacitor();
    }

    private void cbKondP5ItemStateChanged( java.awt.event.ItemEvent evt ) {
        CalculateCapacitor();
    }
}
