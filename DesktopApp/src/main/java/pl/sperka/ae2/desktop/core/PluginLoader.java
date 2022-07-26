package pl.sperka.ae2.desktop.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.sperka.ae2.plugins.ICore;
import pl.sperka.ae2.plugins.IPlugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.ServiceLoader;

public class PluginLoader {
    private final static Logger logger = LogManager.getLogger( PluginLoader.class );
    private final static PluginLoader PLUGIN_LOADER = new PluginLoader();
    private final ArrayList< IPlugin > loadedPlugins = new ArrayList<>();

    public static PluginLoader getInstance() {
        return PLUGIN_LOADER;
    }

    public Boolean loadPlugins( String directory, ICore core ) {
        try {
            File pluginDirectory = new File( directory );
            ArrayList< URL > pluginUrls = new ArrayList<>();

            logger.debug( "Reading plugins from: " + pluginDirectory.getAbsolutePath() );

            var filesList = pluginDirectory.listFiles();
            if ( filesList != null ) {
                for ( File f : filesList ) {
                    if ( f.getName().endsWith( ".jar" ) ) {
                        pluginUrls.add( f.toURI().toURL() );
                    }
                }

                URLClassLoader ucl = new URLClassLoader( pluginUrls.toArray( new URL[0] ) );
                ServiceLoader< ? extends IPlugin > sl = ServiceLoader.load( IPlugin.class, ucl );
                for ( IPlugin plugin : sl ) {
                    logger.debug( "Plugin loaded: " + plugin.toString() );
                    if ( plugin.initialize( core ) ) loadedPlugins.add( plugin );
                }
            }
        } catch ( MalformedURLException | NullPointerException ex ) {
            logger.error( ex.getMessage(), ex );
            return false;
        }

        return true;
    }
}
