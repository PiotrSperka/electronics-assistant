package pl.sperka.ae2.desktop.core;

import com.formdev.flatlaf.FlatLightLaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class MainWindow extends JFrame implements ICore {
    private static final Logger logger = LogManager.getLogger( MainWindow.class );
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.desktop.Strings" );

    // UI elements
    private final JMenuBar menuBar = new JMenuBar();
    private final JTabbedPane mainTabbedPane = new JTabbedPane();

    public MainWindow() {
        URL url = this.getClass().getClassLoader().getResource( "pl/sperka/ae2/desktop/icons/aeicon.png" );
        if ( url != null ) {
            setIconImage( new ImageIcon( url ).getImage() );
        }

        this.setTitle( strings.getString( "application.name" ) + " " + strings.getString( "application.version" ) );
        this.setMinimumSize( new Dimension( 800, 600 ) );
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );

        var helpMenu = new JMenu( strings.getString( "core.menu.help" ) );
        menuBar.add( helpMenu );
        this.setJMenuBar( menuBar );

        var helpAboutMenuItem = new JMenuItem( strings.getString( "core.menu.help.about" ) );
        helpAboutMenuItem.addActionListener( e -> showHtmlDialog( strings.getString( "application.about" ), strings.getString( "core.menu.help.about" ), JOptionPane.INFORMATION_MESSAGE ) );
        helpMenu.add( helpAboutMenuItem );

        var helpUpdatesMenuItem = new JMenuItem( strings.getString( "core.menu.help.check-updates" ) );
        helpUpdatesMenuItem.addActionListener( e -> showHtmlDialog( strings.getString( "core.menu.help.update-info" ), strings.getString( "core.menu.help.check-updates" ), JOptionPane.INFORMATION_MESSAGE ) );
        helpMenu.add( helpUpdatesMenuItem );

        this.add( mainTabbedPane );

        PluginLoader.getInstance().loadPlugins( "./", this );
        PluginLoader.getInstance().loadPlugins( "./plugins/", this );
    }

    private static void setUIFontSize( int size ) {
        Enumeration< Object > keys = UIManager.getDefaults().keys();
        while ( keys.hasMoreElements() ) {
            Object key = keys.nextElement();
            Object value = UIManager.get( key );
            if ( value instanceof FontUIResource ) {
                UIManager.put( key, ( (FontUIResource) value ).deriveFont( ( (FontUIResource) value ).getStyle(), size ) );
            }
        }
    }

    public static void main( String[] args ) {
        EventQueue.invokeLater( () -> {
            FlatLightLaf.setup();
            setUIFontSize( 13 );
            new MainWindow().setVisible( true );
        } );
    }

    private void showHtmlDialog( String text, String title, int messageType ) {
        JLabel label = new JLabel();
        Font font = label.getFont();

        String style = "font-family:" + font.getFamily() + ";" + "font-weight:" + ( font.isBold() ? "bold" : "normal" ) + ";" + "font-size:" + font.getSize() + "pt;";
        JEditorPane ep = new JEditorPane( "text/html", "<html><body style=\"" + style + "\">" + text + "</body></html>" );

        ep.addHyperlinkListener( e -> {
            if ( e.getEventType().equals( HyperlinkEvent.EventType.ACTIVATED ) ) {
                try {
                    Desktop.getDesktop().browse( e.getURL().toURI() );
                } catch ( IOException | URISyntaxException ex ) {
                    logger.error( ex.getMessage(), ex );
                }
            }
        } );
        ep.setEditable( false );
        ep.setBackground( label.getBackground() );

        JOptionPane.showMessageDialog( this, ep, title, messageType );
    }

    @Override
    public JPanel getTabByName( String name ) {
        for ( int i = 0; i < mainTabbedPane.getTabCount(); i++ ) {
            if ( mainTabbedPane.getTitleAt( i ).equalsIgnoreCase( name ) )
                return (JPanel) mainTabbedPane.getComponentAt( i );
        }

        JPanel panel = new JPanel();
        BoxLayout bl = new BoxLayout( panel, BoxLayout.Y_AXIS );
        panel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 0, 10 ) );
        panel.setLayout( bl );
        mainTabbedPane.addTab( name, panel );

        return panel;
    }

    @Override
    public JMenuBar getTopMenuBar() {
        return menuBar;
    }

    @Override
    public Component getParentComponent() {
        return this;
    }

    @Override
    public Image getIcon() {
        return getIconImage();
    }
}
