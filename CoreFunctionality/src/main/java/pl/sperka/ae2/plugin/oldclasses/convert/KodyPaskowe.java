package pl.sperka.ae2.plugin.oldclasses.convert;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * KodyPaskowe.java
 *
 * Created on 2011-06-23, 22:56:10
 */

/**
 *
 * @author kapitan
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.text.NumberFormat;

public class KodyPaskowe extends javax.swing.JFrame {

    /** Creates new form KodyPaskowe */
    public KodyPaskowe( Component parent ) {
        initComponents();
        LiczRez();
        LiczDlaw();
        LiczKond();
        setLocationRelativeTo( parent );
    }
    
    private Color getColor(String nazwa)
    {
        Color kolor=null;
        float[] hsb;
        if(nazwa.equalsIgnoreCase("czarny")) kolor=Color.black;
        if(nazwa.equalsIgnoreCase("brązowy")) {hsb=Color.RGBtoHSB(88, 57, 30,null); kolor=Color.getHSBColor(hsb[0],hsb[1],hsb[2]);}
        if(nazwa.equalsIgnoreCase("czerwony")) kolor=Color.red;
        if(nazwa.equalsIgnoreCase("pomarańczowy")) {hsb=Color.RGBtoHSB(255, 100, 0,null); kolor=Color.getHSBColor(hsb[0],hsb[1],hsb[2]);}
        if(nazwa.equalsIgnoreCase("żółty")) kolor=Color.yellow;
        if(nazwa.equalsIgnoreCase("zielony")) kolor=Color.green;
        if(nazwa.equalsIgnoreCase("niebieski")) kolor=Color.blue;
        if(nazwa.equalsIgnoreCase("fioletowy")) {hsb=Color.RGBtoHSB(156, 0, 255,null); kolor=Color.getHSBColor(hsb[0],hsb[1],hsb[2]);}
        if(nazwa.equalsIgnoreCase("szary")) kolor=Color.gray;
        if(nazwa.equalsIgnoreCase("biały")) kolor=Color.white;
        if(nazwa.equalsIgnoreCase("srebrny")) kolor=Color.lightGray;
        if(nazwa.equalsIgnoreCase("złoty")) {hsb=Color.RGBtoHSB(255, 190, 0,null); kolor=Color.getHSBColor(hsb[0],hsb[1],hsb[2]);}
        if(nazwa.equalsIgnoreCase("piaskowy")) {hsb=Color.RGBtoHSB(255, 240, 174,null); kolor=Color.getHSBColor(hsb[0],hsb[1],hsb[2]);}
        if(nazwa.equalsIgnoreCase("brak paska")) {hsb=Color.RGBtoHSB(255, 240, 174,null); kolor=Color.getHSBColor(hsb[0],hsb[1],hsb[2]);}
        return kolor;
    }

    private String roundFloat(double f)
    {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        return nf.format(f);
    }

    private double getRezMultiplier(JComboBox jcb)
    {
        double multiplier=0;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("złoty")) multiplier=0.1f;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("srebrny")) multiplier=0.01f;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("czarny")) multiplier=1;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("brak paska")) multiplier=1;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("brązowy")) multiplier=10;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("czerwony")) multiplier=100;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("pomarańczowy")) multiplier=1000;//1k
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("żółty")) multiplier=10000;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("zielony")) multiplier=100000;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("niebieski")) multiplier=1000000;//1M
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("fioletowy")) multiplier=10000000;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("szary")) multiplier=100000000;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("biały")) multiplier=1000000000;//1G
        return multiplier;
    }

    private float getRezPrecision(JComboBox jcb)
    {
        float prec=0;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("brązowy")) prec=1;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("czerwony")) prec=2;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("zielony")) prec=0.5f;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("niebieski")) prec=0.25f;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("fioletowy")) prec=0.1f;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("srebrny")) prec=10;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("złoty")) prec=5;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("brak paska")) prec=20;
        return prec;
    }

    private int getRezTempPrecision(JComboBox jcb)
    {
        int wsptemp=0;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("czarny")) wsptemp=200;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("brązowy")) wsptemp=100;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("czerwony")) wsptemp=50;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("pomarańczowy")) wsptemp=25;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("żółty")) wsptemp=15;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("zielony")) wsptemp=10;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("niebieski")) wsptemp=5;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("fioletowy")) wsptemp=2;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("szary")) wsptemp=1;
        return wsptemp;
    }

    private String prefixToString(int prefix)
    {
        String strpref=null;
        if(prefix==0) strpref="p";
        if(prefix==1) strpref="n";
        if(prefix==2) strpref="u";
        if(prefix==3) strpref="m";
        if(prefix==4) strpref="";
        if(prefix==5) strpref="k";
        if(prefix==6) strpref="M";
        if(prefix==7) strpref="G";
        return strpref;
    }

    private int getRezBarValue(JComboBox jcb)
    {
        int value=0;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("czarny")) value=0;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("brązowy")) value=1;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("czerwony")) value=2;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("pomarańczowy")) value=3;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("żółty")) value=4;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("zielony")) value=5;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("niebieski")) value=6;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("fioletowy")) value=7;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("szary")) value=8;
        if(jcb.getSelectedItem().toString().equalsIgnoreCase("biały")) value=9;
        return value;
    }

    private void LiczRez()
    {
        double rez=0, multiplier=0;
        int prefix=0;
        if(cbRezP4.getSelectedIndex()==0&&cbRezP5.getSelectedIndex()==0&&cbRezP6.getSelectedIndex()==0)
        { //3 paski
            Rysuj(panRezRys,getColor("piaskowy"),getColor("piaskowy"),getColor("piaskowy"),
                    getColor(cbRezP1.getSelectedItem().toString()),
                    getColor(cbRezP2.getSelectedItem().toString()),
                    getColor(cbRezP3.getSelectedItem().toString()),
                    getColor("piaskowy"));
            if(getRezMultiplier(cbRezP3)<100) {multiplier=getRezMultiplier(cbRezP3); prefix=4;}
            if(getRezMultiplier(cbRezP3)>=100&&getRezMultiplier(cbRezP3)<100000) {multiplier=getRezMultiplier(cbRezP3)/1000; prefix=5;}
            if(getRezMultiplier(cbRezP3)>=100000&&getRezMultiplier(cbRezP3)<100000000) {multiplier=getRezMultiplier(cbRezP3)/1000000; prefix=6;}
            if(getRezMultiplier(cbRezP3)>=100000000) {multiplier=getRezMultiplier(cbRezP3)/1000000000; prefix=7;}
            rez=((10*getRezBarValue(cbRezP1))+getRezBarValue(cbRezP2))*multiplier;
            lblRezWynik.setText("<HTML>Rezystancja: "+roundFloat(rez)+" "+prefixToString(prefix)+"Ohm"
                    + "<BR>Precyzja: 20%</HTML>");
        } else
        if(cbRezP5.getSelectedIndex()==0&&cbRezP6.getSelectedIndex()==0)
        { //4 paski
            Rysuj(panRezRys,getColor("piaskowy"),getColor("piaskowy"),getColor("piaskowy"),
                    getColor(cbRezP1.getSelectedItem().toString()),
                    getColor(cbRezP2.getSelectedItem().toString()),
                    getColor(cbRezP3.getSelectedItem().toString()),
                    getColor(cbRezP4.getSelectedItem().toString()));
            if(getRezMultiplier(cbRezP3)<100) {multiplier=getRezMultiplier(cbRezP3); prefix=4;}
            if(getRezMultiplier(cbRezP3)>=100&&getRezMultiplier(cbRezP3)<100000) {multiplier=getRezMultiplier(cbRezP3)/1000; prefix=5;}
            if(getRezMultiplier(cbRezP3)>=100000&&getRezMultiplier(cbRezP3)<100000000) {multiplier=getRezMultiplier(cbRezP3)/1000000; prefix=6;}
            if(getRezMultiplier(cbRezP3)>=100000000) {multiplier=getRezMultiplier(cbRezP3)/1000000000; prefix=7;}
            rez=((10*getRezBarValue(cbRezP1))+getRezBarValue(cbRezP2))*multiplier;
            lblRezWynik.setText("<HTML>Rezystancja: "+roundFloat(rez)+" "+prefixToString(prefix)+"Ohm"
                    + "<BR>Precyzja: "+Float.toString(getRezPrecision(cbRezP4))+"%</HTML>");
        } else
        if(cbRezP6.getSelectedIndex()==0)
        { //5 pasków
            Rysuj(panRezRys,getColor("piaskowy"),getColor("piaskowy"),
                    getColor(cbRezP1.getSelectedItem().toString()),
                    getColor(cbRezP2.getSelectedItem().toString()),
                    getColor(cbRezP3.getSelectedItem().toString()),
                    getColor(cbRezP4.getSelectedItem().toString()),
                    getColor(cbRezP5.getSelectedItem().toString()));
            if(getRezMultiplier(cbRezP4)<10) {multiplier=getRezMultiplier(cbRezP4); prefix=4;}
            if(getRezMultiplier(cbRezP4)>=10&&getRezMultiplier(cbRezP4)<10000) {multiplier=getRezMultiplier(cbRezP4)/1000; prefix=5;}
            if(getRezMultiplier(cbRezP4)>=10000&&getRezMultiplier(cbRezP4)<10000000) {multiplier=getRezMultiplier(cbRezP4)/1000000; prefix=6;}
            if(getRezMultiplier(cbRezP4)>=10000000) {multiplier=getRezMultiplier(cbRezP4)/1000000000; prefix=7;}
            rez=((100*getRezBarValue(cbRezP1))+(10*getRezBarValue(cbRezP2))
                    +getRezBarValue(cbRezP3))*multiplier;
            lblRezWynik.setText("<HTML>Rezystancja: "+roundFloat(rez)+" "+prefixToString(prefix)+"Ohm"
                    + "<BR>Precyzja: "+Float.toString(getRezPrecision(cbRezP5))+"%</HTML>");
        } else { //6 pasków
            Rysuj(panRezRys,getColor("piaskowy"),
                    getColor(cbRezP1.getSelectedItem().toString()),
                    getColor(cbRezP2.getSelectedItem().toString()),
                    getColor(cbRezP3.getSelectedItem().toString()),
                    getColor(cbRezP4.getSelectedItem().toString()),
                    getColor(cbRezP5.getSelectedItem().toString()),
                    getColor(cbRezP6.getSelectedItem().toString()));
            if(getRezMultiplier(cbRezP4)<10) {multiplier=getRezMultiplier(cbRezP4); prefix=4;}
            if(getRezMultiplier(cbRezP4)>=10&&getRezMultiplier(cbRezP4)<10000) {multiplier=getRezMultiplier(cbRezP4)/1000; prefix=5;}
            if(getRezMultiplier(cbRezP4)>=10000&&getRezMultiplier(cbRezP4)<10000000) {multiplier=getRezMultiplier(cbRezP4)/1000000; prefix=6;}
            if(getRezMultiplier(cbRezP4)>=10000000) {multiplier=getRezMultiplier(cbRezP4)/1000000000; prefix=7;}
            rez=((100*getRezBarValue(cbRezP1))+(10*getRezBarValue(cbRezP2))
                    +getRezBarValue(cbRezP3))*multiplier;
            lblRezWynik.setText("<HTML>Rezystancja: "+roundFloat(rez)+" "+prefixToString(prefix)+"Ohm"
                    + "<BR>Precyzja: "+Float.toString(getRezPrecision(cbRezP5))+"%"
                    + "<BR>Wsp. temp.: "+Integer.toString(getRezTempPrecision(cbRezP6))+" ppm/K</HTML>");
        }
    }

    private void LiczDlaw()
    {
        double ind=0, multiplier=0;
        int prefix=0;
        Rysuj(panDlaRys,getColor("piaskowy"),getColor("piaskowy"),
                    getColor(cbDlaP1.getSelectedItem().toString()),
                    getColor(cbDlaP2.getSelectedItem().toString()),
                    getColor(cbDlaP3.getSelectedItem().toString()),
                    getColor("piaskowy"),
                    getColor(cbDlaP4.getSelectedItem().toString()));
        if(getRezMultiplier(cbDlaP3)<0.1) {multiplier=getRezMultiplier(cbDlaP3)*1000; prefix=1;}
        if(getRezMultiplier(cbDlaP3)>=0.1&&getRezMultiplier(cbDlaP3)<100) {multiplier=getRezMultiplier(cbDlaP3); prefix=2;}
        if(getRezMultiplier(cbDlaP3)>=100&&getRezMultiplier(cbDlaP3)<100000) {multiplier=getRezMultiplier(cbDlaP3)/1000; prefix=3;}
        if(getRezMultiplier(cbDlaP3)>=100000&&getRezMultiplier(cbDlaP3)<100000000) {multiplier=getRezMultiplier(cbDlaP3)/1000000; prefix=4;}
        if(getRezMultiplier(cbDlaP3)>=100000000) {multiplier=getRezMultiplier(cbDlaP3)/1000000000; prefix=5;}
        ind=((10*getRezBarValue(cbDlaP1))+getRezBarValue(cbDlaP2))*multiplier;
        lblDlaWynik.setText("<HTML>Indukcyjność: "+roundFloat(ind)+" "+prefixToString(prefix)+"H"
                    + "<BR>Precyzja: "+Float.toString(getRezPrecision(cbDlaP4))+"%</HTML>");
    }

    private void LiczKond()
    {
        double poj=0, multiplier=0;
        int prefix=0;
        Rysuj(panKondRys,getColor("piaskowy"),
                    getColor(cbKondP1.getSelectedItem().toString()),
                    getColor(cbKondP2.getSelectedItem().toString()),
                    getColor(cbKondP3.getSelectedItem().toString()),
                    getColor("piaskowy"),
                    getColor(cbKondP4.getSelectedItem().toString()),
                    getColor(cbKondP5.getSelectedItem().toString()));
        if(getRezMultiplier(cbKondP3)<100) {multiplier=getRezMultiplier(cbKondP3); prefix=0;}
        if(getRezMultiplier(cbKondP3)>=100&&getRezMultiplier(cbKondP3)<100000) {multiplier=getRezMultiplier(cbKondP3)/1000; prefix=1;}
        if(getRezMultiplier(cbKondP3)>=100000&&getRezMultiplier(cbKondP3)<100000000) {multiplier=getRezMultiplier(cbKondP3)/1000000; prefix=2;}
        if(getRezMultiplier(cbKondP3)>=100000000) {multiplier=getRezMultiplier(cbKondP3)/1000000000; prefix=3;}
        poj=((10*getRezBarValue(cbKondP1))+getRezBarValue(cbKondP2))*multiplier;
        if(cbKondP5.getSelectedIndex()==0)
        {
            lblKondWynik.setText("<HTML>Pojemność: "+roundFloat(poj)+" "+prefixToString(prefix)+"F"
                        + "<BR>Precyzja: "+Float.toString(getRezPrecision(cbKondP4))+"%</HTML>");
        } else {
            lblKondWynik.setText("<HTML>Pojemność: "+roundFloat(poj)+" "+prefixToString(prefix)+"F"
                        + "<BR>Precyzja: "+Float.toString(getRezPrecision(cbKondP4))+"%"
                        + "<BR>Wsp. temp.: "+Integer.toString(getRezTempPrecision(cbKondP5))+" ppm/K</HTML>");
        }
    }

    private void Rysuj(JPanel panel, Color background, Color bar1, Color bar2,
            Color bar3, Color bar4, Color bar5, Color bar6)
    {
        panel.removeAll();
        panel.repaint();
        BufferedImage img = new BufferedImage(260,70, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d=img.createGraphics();
        g2d.setColor(background);
        g2d.fillRect(20, 0, 220, 70);
        g2d.setColor(Color.black);
        g2d.drawLine(0,35,20,35);
        g2d.drawLine(240,35,260,35);
        g2d.setColor(bar1); g2d.fillRect(30,0,25,70);
        g2d.setColor(bar2); g2d.fillRect(65,0,25,70);
        g2d.setColor(bar3); g2d.fillRect(100,0,25,70);
        g2d.setColor(bar4); g2d.fillRect(135,0,25,70);
        g2d.setColor(bar5); g2d.fillRect(170,0,25,70);
        g2d.setColor(bar6); g2d.fillRect(205,0,25,70);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setSize(260,70);
        panel.add(label);
        label.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panRezRys = new javax.swing.JPanel();
        cbRezP1 = new javax.swing.JComboBox();
        cbRezP2 = new javax.swing.JComboBox();
        cbRezP3 = new javax.swing.JComboBox();
        cbRezP4 = new javax.swing.JComboBox();
        cbRezP5 = new javax.swing.JComboBox();
        cbRezP6 = new javax.swing.JComboBox();
        lblRezWynik = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panKondRys = new javax.swing.JPanel();
        cbKondP1 = new javax.swing.JComboBox();
        lblKondWynik = new javax.swing.JLabel();
        cbKondP2 = new javax.swing.JComboBox();
        cbKondP3 = new javax.swing.JComboBox();
        cbKondP4 = new javax.swing.JComboBox();
        cbKondP5 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        panDlaRys = new javax.swing.JPanel();
        cbDlaP1 = new javax.swing.JComboBox();
        cbDlaP2 = new javax.swing.JComboBox();
        cbDlaP3 = new javax.swing.JComboBox();
        cbDlaP4 = new javax.swing.JComboBox();
        lblDlaWynik = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kody paskowe elementów");
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        panRezRys.setPreferredSize(new java.awt.Dimension(260, 100));

        javax.swing.GroupLayout panRezRysLayout = new javax.swing.GroupLayout(panRezRys);
        panRezRys.setLayout(panRezRysLayout);
        panRezRysLayout.setHorizontalGroup(
            panRezRysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        panRezRysLayout.setVerticalGroup(
            panRezRysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cbRezP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRezP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbRezP1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRezP1ItemStateChanged(evt);
            }
        });

        cbRezP2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRezP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbRezP2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRezP2ItemStateChanged(evt);
            }
        });

        cbRezP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRezP3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Złoty", "Srebrny", "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbRezP3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRezP3ItemStateChanged(evt);
            }
        });

        cbRezP4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRezP4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak paska", "Złoty", "Srebrny", "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbRezP4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRezP4ItemStateChanged(evt);
            }
        });

        cbRezP5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRezP5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak paska", "Złoty", "Srebrny", "Brązowy", "Czerwony", "Zielony", "Niebieski", "Fioletowy" }));
        cbRezP5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRezP5ItemStateChanged(evt);
            }
        });

        cbRezP6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbRezP6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak paska", "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary" }));
        cbRezP6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRezP6ItemStateChanged(evt);
            }
        });

        lblRezWynik.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRezWynik.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblRezWynik))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbRezP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRezP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRezP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRezP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbRezP5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(cbRezP6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(panRezRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panRezRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRezP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRezP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRezP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRezP5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRezP6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRezP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRezWynik)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rezystor", jPanel2);

        panKondRys.setPreferredSize(new java.awt.Dimension(260, 100));

        javax.swing.GroupLayout panKondRysLayout = new javax.swing.GroupLayout(panKondRys);
        panKondRys.setLayout(panKondRysLayout);
        panKondRysLayout.setHorizontalGroup(
            panKondRysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        panKondRysLayout.setVerticalGroup(
            panKondRysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cbKondP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbKondP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbKondP1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKondP1ItemStateChanged(evt);
            }
        });

        lblKondWynik.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKondWynik.setText("jLabel1");

        cbKondP2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbKondP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbKondP2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKondP2ItemStateChanged(evt);
            }
        });

        cbKondP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbKondP3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak paska", "Złoty", "Srebrny", "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbKondP3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKondP3ItemStateChanged(evt);
            }
        });

        cbKondP4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbKondP4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak paska", "Złoty", "Srebrny", "Brązowy", "Czerwony", "Zielony", "Niebieski", "Fioletowy" }));
        cbKondP4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKondP4ItemStateChanged(evt);
            }
        });

        cbKondP5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbKondP5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak paska", "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary" }));
        cbKondP5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKondP5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(panKondRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblKondWynik))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbKondP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKondP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKondP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKondP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKondP5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panKondRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKondP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKondP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKondP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKondP5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKondP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKondWynik)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kondensator", jPanel3);

        panDlaRys.setPreferredSize(new java.awt.Dimension(260, 100));

        javax.swing.GroupLayout panDlaRysLayout = new javax.swing.GroupLayout(panDlaRys);
        panDlaRys.setLayout(panDlaRysLayout);
        panDlaRysLayout.setHorizontalGroup(
            panDlaRysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        panDlaRysLayout.setVerticalGroup(
            panDlaRysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cbDlaP1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbDlaP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbDlaP1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDlaP1ItemStateChanged(evt);
            }
        });

        cbDlaP2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbDlaP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbDlaP2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDlaP2ItemStateChanged(evt);
            }
        });

        cbDlaP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbDlaP3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Złoty", "Srebrny", "Czarny", "Brązowy", "Czerwony", "Pomarańczowy", "Żółty", "Zielony", "Niebieski", "Fioletowy", "Szary", "Biały" }));
        cbDlaP3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDlaP3ItemStateChanged(evt);
            }
        });

        cbDlaP4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbDlaP4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak paska", "Złoty", "Srebrny", "Brązowy", "Czerwony", "Zielony", "Niebieski", "Fioletowy" }));
        cbDlaP4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDlaP4ItemStateChanged(evt);
            }
        });

        lblDlaWynik.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDlaWynik.setText("jLabel1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblDlaWynik))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbDlaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbDlaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbDlaP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbDlaP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(panDlaRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDlaRys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDlaP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDlaP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDlaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDlaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDlaWynik)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dławik", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRezP1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRezP1ItemStateChanged
        LiczRez();
    }//GEN-LAST:event_cbRezP1ItemStateChanged

    private void cbRezP2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRezP2ItemStateChanged
        LiczRez();
    }//GEN-LAST:event_cbRezP2ItemStateChanged

    private void cbRezP3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRezP3ItemStateChanged
        LiczRez();
    }//GEN-LAST:event_cbRezP3ItemStateChanged

    private void cbRezP4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRezP4ItemStateChanged
        if(cbRezP4.getSelectedIndex()==0) {cbRezP5.setSelectedIndex(0); cbRezP6.setSelectedIndex(0);}
        LiczRez();
    }//GEN-LAST:event_cbRezP4ItemStateChanged

    private void cbRezP5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRezP5ItemStateChanged
        if(cbRezP5.getSelectedIndex()==0) cbRezP6.setSelectedIndex(0);
        LiczRez();
    }//GEN-LAST:event_cbRezP5ItemStateChanged

    private void cbRezP6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRezP6ItemStateChanged
        LiczRez();
    }//GEN-LAST:event_cbRezP6ItemStateChanged

    private void cbDlaP1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDlaP1ItemStateChanged
        LiczDlaw();
    }//GEN-LAST:event_cbDlaP1ItemStateChanged

    private void cbDlaP2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDlaP2ItemStateChanged
        LiczDlaw();
    }//GEN-LAST:event_cbDlaP2ItemStateChanged

    private void cbDlaP3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDlaP3ItemStateChanged
        LiczDlaw();
    }//GEN-LAST:event_cbDlaP3ItemStateChanged

    private void cbDlaP4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDlaP4ItemStateChanged
        LiczDlaw();
    }//GEN-LAST:event_cbDlaP4ItemStateChanged

    private void cbKondP1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKondP1ItemStateChanged
        LiczKond();
    }//GEN-LAST:event_cbKondP1ItemStateChanged

    private void cbKondP2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKondP2ItemStateChanged
        LiczKond();
    }//GEN-LAST:event_cbKondP2ItemStateChanged

    private void cbKondP3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKondP3ItemStateChanged
        if(cbKondP3.getSelectedIndex()==0) {cbKondP4.setSelectedIndex(0); cbKondP5.setSelectedIndex(0);}
        LiczKond();
    }//GEN-LAST:event_cbKondP3ItemStateChanged

    private void cbKondP4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKondP4ItemStateChanged
        if(cbKondP4.getSelectedIndex()==0) {cbKondP5.setSelectedIndex(0);}
        LiczKond();
    }//GEN-LAST:event_cbKondP4ItemStateChanged

    private void cbKondP5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKondP5ItemStateChanged
        LiczKond();
    }//GEN-LAST:event_cbKondP5ItemStateChanged

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDlaP1;
    private javax.swing.JComboBox cbDlaP2;
    private javax.swing.JComboBox cbDlaP3;
    private javax.swing.JComboBox cbDlaP4;
    private javax.swing.JComboBox cbKondP1;
    private javax.swing.JComboBox cbKondP2;
    private javax.swing.JComboBox cbKondP3;
    private javax.swing.JComboBox cbKondP4;
    private javax.swing.JComboBox cbKondP5;
    private javax.swing.JComboBox cbRezP1;
    private javax.swing.JComboBox cbRezP2;
    private javax.swing.JComboBox cbRezP3;
    private javax.swing.JComboBox cbRezP4;
    private javax.swing.JComboBox cbRezP5;
    private javax.swing.JComboBox cbRezP6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDlaWynik;
    private javax.swing.JLabel lblKondWynik;
    private javax.swing.JLabel lblRezWynik;
    private javax.swing.JPanel panDlaRys;
    private javax.swing.JPanel panKondRys;
    private javax.swing.JPanel panRezRys;
    // End of variables declaration//GEN-END:variables

}
