package pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Hd44780CharacterGenerator;

import javax.swing.*;
import java.awt.*;


/**
 * @author Piotr Sperka
 */
public class HD44780SmallCharCell extends JPanel {
    private final int pixelSize = 3;
    private int[] rowData = new int[8];
    private Rectangle[] rects;

    public HD44780SmallCharCell() {
        this.setPreferredSize( new Dimension( ( 5 * pixelSize ) + 1, ( 8 * pixelSize ) + 1 ) );
        for ( int i = 0; i < 8; i++ ) rowData[i] = 0;

        createCell();
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        setCellData( g );
    }

    private void createCell() {
        rects = new Rectangle[40];
        for ( int i = 0; i < 8; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                rects[( i * 5 ) + j] = new Rectangle( ( j * pixelSize ), ( i * pixelSize ), pixelSize, pixelSize );
            }
        }
    }

    private void setCellData( Graphics g ) {
        int t = 16;
        for ( int i = 0; i < 8; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                g.setColor( UIManager.getColor( "Panel.background" ).darker() );
                if ( ( rowData[i] & t ) != 0 ) {
                    g.setColor( Color.black );
                    g.fillRect( (int) rects[( i * 5 ) + j].getX(), (int) rects[( i * 5 ) + j].getY(), (int) rects[( i * 5 ) + j].getWidth(), (int) rects[( i * 5 ) + j].getHeight() );
                    g.setColor( Color.darkGray.darker() );
                }
                g.drawRect( (int) rects[( i * 5 ) + j].getX(), (int) rects[( i * 5 ) + j].getY(), (int) rects[( i * 5 ) + j].getWidth(), (int) rects[( i * 5 ) + j].getHeight() );
                t /= 2;
            }
            t = 16;
        }
    }

    public void setData( int[] tab ) {
        if ( tab.length != 8 ) return;
        rowData = tab;
        repaint();
    }
}
