package pl.sperka.ae2.plugin.corefunctionality.microcontrollers.GraphicalLcdImageGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.ResourceBundle;

/**
 * @author Piotr Sperka
 */
public class GraphLcdPictInfo extends JDialog {
    private static final Logger logger = LogManager.getLogger( GraphLcdPictInfo.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Strings" );
    private javax.swing.JLabel jlInfo;

    public GraphLcdPictInfo( JFrame parent ) {
        super( parent, strings.getString( "graphic-lcd-picture-generator.information" ), true );
        initComponents();
        setLocationRelativeTo( parent );
        jlInfo.setText( strings.getString( "graphic-lcd-picture-generator.information-contents" ) );
    }

    private void initComponents() {

        jlInfo = new javax.swing.JLabel();

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setResizable( false );

        jlInfo.setVerticalAlignment( javax.swing.SwingConstants.TOP );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
        getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE ).addContainerGap() ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup( layout.createSequentialGroup().addContainerGap().addComponent( jlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE ).addContainerGap() ) );

        pack();
    }
}
