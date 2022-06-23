package pl.sperka.ae2.plugin.oldclasses.microcontrollers;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Piotrek
 */
public class GraphLcdPict extends javax.swing.JFrame {

    private BufferedImage original, result;
    private Graphics g;
    private int brightest = 0;
    /**
     * Creates new form GraphLcdPict
     */
    public GraphLcdPict( Component parent ) {
        initComponents();
        setLocationRelativeTo( parent );
    }

    private BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    
    private void toGrayscale(BufferedImage bi)
    {
        for(int i=0;i<bi.getHeight();i++)
        {
            for(int j=0;j<bi.getWidth();j++)
            {
                Color c = new Color(bi.getRGB(j, i));
                int k = (c.getRed()+c.getBlue()+c.getGreen())/3;
                c = new Color(k,k,k);
                if(k>brightest) brightest = k;
                bi.setRGB(j, i, c.getRGB());
            }
        }
    }
    
    private void gamma(int value, BufferedImage bi)
    {
        for(int i=0;i<bi.getHeight();i++)
        {
            for(int j=0;j<bi.getWidth();j++)
            {
                Color c = new Color(bi.getRGB(j, i));
                int k = (c.getRed()+c.getBlue()+c.getGreen())/3;
                k = (int)(255*Math.pow(((double)k/255),(double)value/100));
                c = new Color(k,k,k);
                if(k>brightest) brightest = k;
                bi.setRGB(j, i, c.getRGB());
            }
        }
    }
    
    private BufferedImage scale(int wmax, int hmax, BufferedImage bi)
    {
        AffineTransform at = new AffineTransform();
        double scaleFactor = (double)hmax/bi.getHeight();
        double tmp = (double)wmax/bi.getWidth();
        if(tmp<scaleFactor) scaleFactor = tmp;
        //System.out.printf("%f", scaleFactor);
        at.scale(scaleFactor,scaleFactor);
        AffineTransformOp scaleAT = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage t = new BufferedImage((int)(bi.getWidth()*scaleFactor),(int)(bi.getHeight()*scaleFactor),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = t.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, (int)(bi.getWidth()*scaleFactor),(int)(bi.getHeight()*scaleFactor));
        g2d.drawImage(bi, scaleAT, 0, 0);
        return t;
    }
    
    private void Sierra24A(int thr, BufferedImage bi)
    {
        int[][] e_tab = new int[bi.getWidth()+2][bi.getHeight()+1];
        for(int i=0;i<bi.getHeight();i++)
            for(int j=0;j<bi.getWidth();j++)
            {
                    e_tab[j][i] = 0;
            }
        Color b = new Color(0,0,0);
        Color w = new Color(255,255,255);
        int threshold = (int)(brightest*((double)thr/100));
        int err = 0;
        for(int i=0;i<bi.getHeight();i++)
            for(int j=1;j<bi.getWidth()+1;j++)
            {
                //Color c = new Color(bi1.getRGB(j-1, i));
                err = (bi.getRGB(j-1, i)& 0x000000FF)+e_tab[j][i];
                if((err)>threshold)
                {
                    bi.setRGB(j-1, i, w.getRGB());
                    err -= brightest;
                } else bi.setRGB(j-1, i, b.getRGB());
                e_tab[j+1][i] = (int)(err*0.5);
                e_tab[j][i+1] = (int)(err*0.25);
                e_tab[j-1][i+1] = (int)(err*0.25);
            }
    }
    
    private void BWThreshold(int thr, BufferedImage bi)
    {
        Color b = new Color(0,0,0);
        Color w = new Color(255,255,255);
        int threshold = (int)(brightest*((double)thr/100));
        for(int i=0;i<bi.getHeight();i++)
            for(int j=0;j<bi.getWidth();j++)
            {
                //Color c = new Color(bi1.getRGB(j-1, i));
                int color = (bi.getRGB(j, i)& 0x000000FF);
                if(color > threshold)
                {
                    bi.setRGB(j, i, w.getRGB());
                } else bi.setRGB(j, i, b.getRGB());
            }
    }
    
    private void getResult()
    {
        if(jtfLcdWidth.getText().isEmpty() || jtfLcdHeight.getText().isEmpty()) return;
        result = scale(Integer.parseInt(jtfLcdWidth.getText()), Integer.parseInt(jtfLcdHeight.getText()), original);
        if(jrbMono.isSelected() && jrbSierra.isSelected())
        {
            toGrayscale(result);
            Sierra24A(jsThreshold.getValue(), result);
        } else if(jrbMono.isSelected() && jrbThreshold.isSelected())
        {
            toGrayscale(result);
            BWThreshold(jsThreshold.getValue(), result);
        } else if(jrbColor.isSelected())
        {
            //Nothing here by now...
        } else return;
        
        JPanel jp = new JPanel();
        jp.setSize(result.getWidth(),result.getHeight());
        JLabel lbl = new JLabel(new ImageIcon(result));
        lbl.setSize(result.getWidth(),result.getHeight());
        jp.add(lbl);
        jspResult.getViewport().add(jp);
        jspResult.setPreferredSize(new Dimension((int)jp.getWidth(), (int)jp.getHeight()));
    }
    
    private void makeBWArray(BufferedImage bi)
    {
        jtaResult.setText(null);
        String text = "const unsigned int width = " + Integer.toString(bi.getWidth()) + ";\n"
                + "const unsigned int height = " + Integer.toString(bi.getHeight()) + ";\n"
                + "const unsigned char Bitmap[] = {";
        int tmp = 0, ptr = 128;
        for(int i=0;i<bi.getHeight();i++)
            for(int j=0;j<bi.getWidth();j++)
            {
                //Color c = new Color(bi1.getRGB(j-1, i));
                int color = (bi.getRGB(j, i)& 0x000000FF);
                if(color == 0) tmp += ptr;
                ptr /= 2;
                if(ptr == 0)
                {
                    text += "0x"+Integer.toHexString(0x100|tmp).substring(1)+", ";
                    tmp = 0;
                    ptr = 128;
                }
            }
        if(ptr < 128)
            text += "0x"+Integer.toHexString(0x100|tmp).substring(1);
        text += "};";
        jtaResult.setText(text);
    }
    
    private void makeColorArray(BufferedImage bi)
    {
        jtaResult.setText(null);
        String text = "const unsigned int width = " + Integer.toString(bi.getWidth()) + ";\n"
                + "const unsigned int height = " + Integer.toString(bi.getHeight()) + ";\n";
        if(jrbRGB565.isSelected()) text += "// RGB565 -> 0bRRRRRGGG, 0bGGGBBBBB\n";
        else if (jrbRGB888.isSelected()) text += "// RGB888 -> 0bRRRRRRRR, 0bGGGGGGGG, 0bBBBBBBBB\n";
        text += "const unsigned char Bitmap[] = {";
        int tmp = 0, ptr = 128;
        for(int i=0;i<bi.getHeight();i++)
            for(int j=0;j<bi.getWidth();j++)
            {
                int colorB = (result.getRGB(j, i)& 0x000000FF);
                int colorG = (result.getRGB(j, i)& 0x0000FF00)>>8;
                int colorR = (result.getRGB(j, i)& 0x00FF0000)>>16;
                if(jrbRGB888.isSelected())
                {
                    text += "0x"+Integer.toHexString(0x100|colorR).substring(1)+", ";
                    text += "0x"+Integer.toHexString(0x100|colorG).substring(1)+", ";
                    text += "0x"+Integer.toHexString(0x100|colorB).substring(1)+", ";
                } else if(jrbRGB565.isSelected())
                {
                    text += "0x"+Integer.toHexString(0x100|((colorR & 0xF8) + ((colorG & 0xE0)>>5))).substring(1)+", ";
                    text += "0x"+Integer.toHexString(0x100|(((colorG & 0x1C)<<3) + ((colorB & 0xF8)>>3))).substring(1)+", ";
                }
            }
        if(ptr < 128)
            text += "0x"+Integer.toHexString(0x100|tmp).substring(1);
        text += "};";
        jtaResult.setText(text);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgLcdType = new javax.swing.ButtonGroup();
        bgType = new javax.swing.ButtonGroup();
        bgRGBConv = new javax.swing.ButtonGroup();
        jbLoad = new javax.swing.JButton();
        jspOriginal = new javax.swing.JScrollPane();
        jspResult = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfLcdHeight = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfLcdWidth = new javax.swing.JTextField();
        jrbMono = new javax.swing.JRadioButton();
        jrbColor = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaResult = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jrbThreshold = new javax.swing.JRadioButton();
        jrbSierra = new javax.swing.JRadioButton();
        jsThreshold = new javax.swing.JSlider();
        jbGetResult = new javax.swing.JButton();
        jbMakeArray = new javax.swing.JButton();
        jbSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jrbRGB565 = new javax.swing.JRadioButton();
        jrbRGB888 = new javax.swing.JRadioButton();
        jbSaveInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generator obrazów dla wyświetlaczy graficznych");

        jbLoad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbLoad.setText("Załaduj obraz");
        jbLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoadActionPerformed(evt);
            }
        });

        jspOriginal.setMaximumSize(new java.awt.Dimension(375, 250));
        jspOriginal.setPreferredSize(new java.awt.Dimension(375, 250));

        jspResult.setMaximumSize(new java.awt.Dimension(250, 375));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Wyświetlacz"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Wysokość [px]");

        jtfLcdHeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfLcdHeight.setText("128");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Szerokość [px]");

        jtfLcdWidth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfLcdWidth.setText("256");

        bgLcdType.add(jrbMono);
        jrbMono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbMono.setSelected(true);
        jrbMono.setText("Monochromatyczny");
        jrbMono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMonoActionPerformed(evt);
            }
        });

        bgLcdType.add(jrbColor);
        jrbColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbColor.setText("Kolorowy");
        jrbColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfLcdHeight))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfLcdWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbMono)
                    .addComponent(jrbColor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLcdHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbMono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLcdWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaResult.setColumns(20);
        jtaResult.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jtaResult.setLineWrap(true);
        jtaResult.setRows(5);
        jtaResult.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtaResult);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Rodzaj przetwarzania"));

        bgType.add(jrbThreshold);
        jrbThreshold.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbThreshold.setText("Progowe");

        bgType.add(jrbSierra);
        jrbSierra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbSierra.setSelected(true);
        jrbSierra.setText("Dithering (Sierra 2-4A)");

        jsThreshold.setMaximum(99);
        jsThreshold.setMinimum(1);
        jsThreshold.setToolTipText("Próg");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsThreshold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbThreshold)
                            .addComponent(jrbSierra))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbSierra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbGetResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbGetResult.setText("Podgląd");
        jbGetResult.setEnabled(false);
        jbGetResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGetResultActionPerformed(evt);
            }
        });

        jbMakeArray.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbMakeArray.setText("Przetwórz");
        jbMakeArray.setEnabled(false);
        jbMakeArray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMakeArrayActionPerformed(evt);
            }
        });

        jbSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbSave.setText("Zapisz obraz");
        jbSave.setEnabled(false);
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Konwersja RGB"));

        bgRGBConv.add(jrbRGB565);
        jrbRGB565.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbRGB565.setSelected(true);
        jrbRGB565.setText("-> RGB565 (16-bit)");
        jrbRGB565.setToolTipText("");
        jrbRGB565.setEnabled(false);

        bgRGBConv.add(jrbRGB888);
        jrbRGB888.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrbRGB888.setText("-> RGB888 (24-bit)");
        jrbRGB888.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbRGB565)
                    .addComponent(jrbRGB888))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbRGB565, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbRGB888, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbSaveInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbSaveInfo.setText("?");
        jbSaveInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbLoad)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGetResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbMakeArray)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSaveInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSave))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jspResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(jbGetResult, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(jbMakeArray, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(jbSave, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(jbSaveInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jspResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoadActionPerformed
        JFileChooser jfc = new JFileChooser();
        int i = jfc.showOpenDialog(this);
        if(i == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                original = ImageIO.read(jfc.getSelectedFile());
                JPanel jp = new JPanel();
                jp.setSize(original.getWidth(),original.getHeight());
                JLabel lbl = new JLabel(new ImageIcon(original));
                lbl.setSize(original.getWidth(),original.getHeight());
                jp.add(lbl);
                jspOriginal.getViewport().add(jp);
                jspOriginal.setPreferredSize(new Dimension((int)jp.getWidth(), (int)jp.getHeight()));
                jbGetResult.setEnabled(true);
            } catch(Exception e) {}
        }
    }//GEN-LAST:event_jbLoadActionPerformed

    private void jbGetResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGetResultActionPerformed
        getResult();
        jbSave.setEnabled(true);
        jbMakeArray.setEnabled(true);
    }//GEN-LAST:event_jbGetResultActionPerformed

    private void jbMakeArrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMakeArrayActionPerformed
        getResult();
        if(jrbMono.isSelected()) makeBWArray(result);
        else if(jrbColor.isSelected()) makeColorArray(result);
    }//GEN-LAST:event_jbMakeArrayActionPerformed

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter ffBMP = new FileNameExtensionFilter("Pliki bitmapowe *.bmp", "bmp");
        FileNameExtensionFilter ffBIN = new FileNameExtensionFilter("Pliki binarne *.bin", "bin");
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(ffBIN);
        jfc.addChoosableFileFilter(ffBMP);
        int a = jfc.showSaveDialog(this);
        if(a == JFileChooser.APPROVE_OPTION)
        {
            String ext = ((FileNameExtensionFilter)jfc.getFileFilter()).getExtensions()[0];
            String path = jfc.getSelectedFile().toString();
            if(!path.toLowerCase().endsWith("."+ext)) path = path + "." + ext;
            //Saving
            File f = new File(path);
            if(ext.equals("bmp"))
            {
                try
                {
                    ImageIO.write(result, "BMP", f);
                } catch(Exception e) {}
            }
            else if(ext.equals("bin"))
            {
                try
                {
                    DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
                    dos.write((result.getWidth()&0xff00)>>8);
                    dos.write((result.getWidth()&0xff));
                    dos.write((result.getHeight()&0xff00)>>8);
                    dos.write((result.getHeight()&0xff));
                    if(jrbMono.isSelected())
                    {// Monochromatic binary
                        int tmp = 0, ptr = 128;
                        dos.write(0x01);
                        for(int i=0;i<result.getHeight();i++)
                            for(int j=0;j<result.getWidth();j++)
                            {
                                int color = (result.getRGB(j, i)& 0x000000FF);
                                if(color == 0) tmp += ptr;
                                ptr /= 2;
                                if(ptr == 0)
                                {
                                    dos.write(tmp);
                                    tmp = 0;
                                    ptr = 128;
                                }
                            }
                        if(ptr < 128) dos.write(tmp);
                    } else if(jrbColor.isSelected()) //Color binary
                    {
                        if(jrbRGB888.isSelected()) dos.write(0x11);
                        else if(jrbRGB565.isSelected()) dos.write(0x12);
                        for(int i=0;i<result.getHeight();i++)
                            for(int j=0;j<result.getWidth();j++)
                            {
                                int colorB = (result.getRGB(j, i)& 0x000000FF);
                                int colorG = (result.getRGB(j, i)& 0x0000FF00)>>8;
                                int colorR = (result.getRGB(j, i)& 0x00FF0000)>>16;
                                if(jrbRGB888.isSelected())
                                {
                                    dos.write(colorR);
                                    dos.write(colorG);
                                    dos.write(colorB);
                                } else if(jrbRGB565.isSelected())
                                {
                                    dos.write((colorR & 0xF8) + ((colorG & 0xE0)>>5));
                                    dos.write(((colorG & 0x1C)<<3) + ((colorB & 0xF8)>>3));
                                }
                            }
                    }
                    dos.close();
                    
                } catch(Exception e) {}
            }
        }
    }//GEN-LAST:event_jbSaveActionPerformed

    private void jrbColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbColorActionPerformed
        jrbThreshold.setEnabled(false);
        jrbSierra.setEnabled(false);
        jsThreshold.setEnabled(false);
        jrbRGB888.setEnabled(true);
        jrbRGB565.setEnabled(true);
    }//GEN-LAST:event_jrbColorActionPerformed

    private void jrbMonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMonoActionPerformed
        jrbThreshold.setEnabled(true);
        jrbSierra.setEnabled(true);
        jsThreshold.setEnabled(true);
        jrbRGB888.setEnabled(false);
        jrbRGB565.setEnabled(false);
    }//GEN-LAST:event_jrbMonoActionPerformed

    private void jbSaveInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveInfoActionPerformed
        GraphLcdPictInfo info = new GraphLcdPictInfo(this);
        info.setVisible(true);
        info.dispose();
    }//GEN-LAST:event_jbSaveInfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgLcdType;
    private javax.swing.ButtonGroup bgRGBConv;
    private javax.swing.ButtonGroup bgType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGetResult;
    private javax.swing.JButton jbLoad;
    private javax.swing.JButton jbMakeArray;
    private javax.swing.JButton jbSave;
    private javax.swing.JButton jbSaveInfo;
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
    // End of variables declaration//GEN-END:variables
}
