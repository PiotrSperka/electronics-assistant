package pl.sperka.ae2.plugin.oldclasses.microcontrollers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piotrek
 */
public class HD44780CharCell extends JPanel implements MouseListener {
    
    private int[] rowData = new int[8];
    private Rectangle[] rects;
    
    private HD44780SmallCharCell preview;
    
    private final int pixelSize = 20;
    
    public HD44780CharCell()
    {
        this.setPreferredSize(new Dimension((5*pixelSize)+1,(8*pixelSize)+1));
        for(int i = 0; i<8; i++) rowData[i] = 0;
        this.addMouseListener(this);
        
        createCell();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setCellData(g);
        if(preview != null) preview.setData(rowData);
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
                g.setColor(Color.black);
                if((rowData[i] & t) != 0)
                {
                    g.fillRect((int)rects[(i*5)+j].getX(),
                        (int)rects[(i*5)+j].getY(), (int)rects[(i*5)+j].getWidth(), (int)rects[(i*5)+j].getHeight());
                    g.setColor(Color.gray);
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
    
    public void set()
    {
        for(int i = 0; i<8; i++) rowData[i] = 0x1f;
        repaint();
    }
    
    public void clear()
    {
        for(int i = 0; i<8; i++) rowData[i] = 0;
        repaint();
    }
    
    public void setPreview(HD44780SmallCharCell hd)
    {
        preview = hd;
    }
    
    public int[] getData()
    {
        return rowData;
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(rects[(i*5)+j].contains(e.getX(), e.getY()))
                    rowData[i] = rowData[i]^(1 << (4-j));
            }
        }
        repaint();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
}
