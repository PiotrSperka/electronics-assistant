package pl.sperka.ae2.plugin.oldclasses.microcontrollers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.UIManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piotrek
 */
public class HD44780SmallCharCell extends JPanel {
    
    private int[] rowData = new int[8];
    private Rectangle[] rects;
    
    private final int pixelSize = 3;
    
    public HD44780SmallCharCell()
    {
        this.setPreferredSize(new Dimension((5*pixelSize)+1,(8*pixelSize)+1));
        for(int i = 0; i<8; i++) rowData[i] = 0;
        
        createCell();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setCellData(g);
    }
    
    private void createCell()
    {
        rects = new Rectangle[40];
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                rects[(i*5)+j] = new Rectangle((j*pixelSize),(i*pixelSize),pixelSize,pixelSize);
            }
        }
    }
    
    private void setCellData(Graphics g)
    {
        int t = 16;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                g.setColor(UIManager.getColor("Panel.background").darker());
                if((rowData[i] & t) != 0)
                {
                    g.setColor(Color.black);
                    g.fillRect((int)rects[(i*5)+j].getX(),
                        (int)rects[(i*5)+j].getY(), (int)rects[(i*5)+j].getWidth(), (int)rects[(i*5)+j].getHeight());
                    g.setColor(Color.darkGray.darker());
                }
                g.drawRect((int)rects[(i*5)+j].getX(),
                    (int)rects[(i*5)+j].getY(), (int)rects[(i*5)+j].getWidth(), (int)rects[(i*5)+j].getHeight());
                t /= 2;
            }
            t = 16;
        }
    }
    
    public void setData(int[] tab)
    {
        if(tab.length != 8) return;
        rowData = tab;
        repaint();
    }
    
}
