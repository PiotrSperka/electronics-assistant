package pl.sperka.ae2.plugins;

import javax.swing.*;
import java.awt.*;

public interface ICore {
    public JPanel GetTabByName( String name );
    public JMenuBar GetMenuBar();
    public Component GetParentComponent();
}
