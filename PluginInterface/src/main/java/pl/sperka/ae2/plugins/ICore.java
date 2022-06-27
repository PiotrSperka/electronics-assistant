package pl.sperka.ae2.plugins;

import javax.swing.*;
import java.awt.*;

public interface ICore {
    JPanel getTabByName( String name );
    JMenuBar getTopMenuBar();
    Component getParentComponent();
    Image getIcon();
}
