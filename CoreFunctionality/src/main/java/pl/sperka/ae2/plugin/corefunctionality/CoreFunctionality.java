package pl.sperka.ae2.plugin.corefunctionality;

import com.google.auto.service.AutoService;
import pl.sperka.ae2.plugin.corefunctionality.calculate.*;
import pl.sperka.ae2.plugin.oldclasses.circuits.*;
import pl.sperka.ae2.plugin.oldclasses.convert.*;
import pl.sperka.ae2.plugin.oldclasses.microcontrollers.*;
import pl.sperka.ae2.plugins.ICore;
import pl.sperka.ae2.plugins.IPlugin;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

@AutoService( IPlugin.class )
public class CoreFunctionality implements IPlugin {
    private static final ResourceBundle strings = ResourceBundle.getBundle( "pl.sperka.ae2.plugin.corefunctionality.Strings" );

    private ICore core = null;

    @Override
    public String getName() {
        return strings.getString( "plugin.name" );
    }

    @Override
    public String getDescription() {
        return strings.getString( "plugin.description" );
    }

    @Override
    public String getVersionString() {
        return strings.getString( "plugin.version" );
    }

    @Override
    public String getAuthor() {
        return strings.getString( "plugin.author" );
    }

    @Override
    public String getEmail() {
        return strings.getString( "plugin.email" );
    }

    @Override
    public String getHomepage() {
        return strings.getString( "plugin.homepage" );
    }

    @Override
    public LocalDateTime getCreationDate() {
        return LocalDateTime.parse( strings.getString( "plugin.build-date" ), DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" ) );
    }

    @Override
    public String toString() {
        return "CoreFunctionality{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", versionString='" + getVersionString() + '\'' +
                ", versionNumber=" + getVersionNumber() +
                ", author='" + getAuthor() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", homepage='" + getHomepage() + '\'' +
                ", creationDate=" + getCreationDate() +
                '}';
    }

    @Override
    public Boolean initialize( ICore core ) {
        this.core = core;

        var tabCalculate = core.GetTabByName( strings.getString( "plugin.tab.calculate" ) );

        var ledButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.led-resistor" ) );
        ledButton.addActionListener( e -> new ResistorForLed( core.GetParentComponent() ).setVisible( true ) );

        var combinedResistanceButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.combined-resistance" ) );
        combinedResistanceButton.addActionListener( e -> new CombinedResistance( core.GetParentComponent() ).setVisible( true ) );

        var uipButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.voltage-current-power" ) );
        uipButton.addActionListener( e -> new VoltageCurrentPower( core.GetParentComponent() ).setVisible( true ) );

        var voltageDividerButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.voltage-divider" ) );
        voltageDividerButton.addActionListener( e -> new VoltageDivider( core.GetParentComponent() ).setVisible( true ) );

        var radiatorParametersButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.radiator-parameters" ) );
        radiatorParametersButton.addActionListener( e -> new Radiator( core.GetParentComponent() ).setVisible( true ) );

        var coilInductanceButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.coil-inductance" ) );
        coilInductanceButton.addActionListener( e -> new Coils( core.GetParentComponent() ).setVisible( true ) );

        var closestESeriesValueButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.closest-e-series-value" ) );
        closestESeriesValueButton.addActionListener( e -> new ESeries( core.GetParentComponent() ).setVisible( true ) );

        var tabConvert = core.GetTabByName( strings.getString( "plugin.tab.convert" ) );

        var frequencyPeriodButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.frequency-period" ) );
        frequencyPeriodButton.addActionListener( e -> new CzestotOkres( core.GetParentComponent() ).setVisible( true ) );

        var wattsDbmButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.watts-dbm" ) );
        wattsDbmButton.addActionListener( e -> new WatDbm( core.GetParentComponent() ).setVisible( true ) );

        var orderOfMagnitudeButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.order-of-magnitude" ) );
        orderOfMagnitudeButton.addActionListener( e -> new PrzelJedn( core.GetParentComponent() ).setVisible( true ) );

        var numericalSystemsButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.numerical-systems" ) );
        numericalSystemsButton.addActionListener( e -> new SystLiczb( core.GetParentComponent() ).setVisible( true ) );

        var barCodesButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.bar-codes" ) );
        barCodesButton.addActionListener( e -> new KodyPaskowe( core.GetParentComponent() ).setVisible( true ) );

        var milCodeButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.mil-code" ) );
        milCodeButton.addActionListener( e -> new MIL( core.GetParentComponent() ).setVisible( true ) );

        var tabCircuits = core.GetTabByName( strings.getString( "plugin.tab.circuits" ) );

        var opAmpCircuitsButton = addButtonToPanel( tabCircuits, strings.getString( "plugin.tab.circuits.op-amp-circuits" ) );
        opAmpCircuitsButton.addActionListener( e -> new OPampy( core.GetParentComponent() ).setVisible( true ) );

        var lm3xxCircuitsButton = addButtonToPanel( tabCircuits, strings.getString( "plugin.tab.circuits.lm3xx-circuits" ) );
        lm3xxCircuitsButton.addActionListener( e -> new LM3xx( core.GetParentComponent() ).setVisible( true ) );

        var ne555CircuitsButton = addButtonToPanel( tabCircuits, strings.getString( "plugin.tab.circuits.ne555-circuits" ) );
        ne555CircuitsButton.addActionListener( e -> new NE555( core.GetParentComponent() ).setVisible( true ) );

        var tabMicrocontrollers = core.GetTabByName( strings.getString( "plugin.tab.microcontrollers" ) );

        var avrCalculatorsButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.avr-calculators" ) );
        avrCalculatorsButton.addActionListener( e -> new AVRKalk( core.GetParentComponent() ).setVisible( true ) );

        var bitmapFontGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.bitmap-font-generator" ) );
        bitmapFontGeneratorButton.addActionListener( e -> new FontGen( core.GetParentComponent() ).setVisible( true ) );

        var sevenSegmentCharacterGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.seven-segment-character-generator" ) );
        sevenSegmentCharacterGeneratorButton.addActionListener( e -> new _7SegGen( core.GetParentComponent() ).setVisible( true ) );

        var graphicalDisplayImageGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.graphical-display-image-generator" ) );
        graphicalDisplayImageGeneratorButton.addActionListener( e -> new GraphLcdPict( core.GetParentComponent() ).setVisible( true ) );

        var hdCharacterGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.hd44780-character-generator-generator" ) );
        hdCharacterGeneratorButton.addActionListener( e -> new HD44780CharGen( core.GetParentComponent() ).setVisible( true ) );

        return true;
    }

    private JButton addButtonToPanel( JPanel panel, String text ) {
        var button = new JButton( text );
        button.setAlignmentX( Component.CENTER_ALIGNMENT );
        button.setMaximumSize( new Dimension( Short.MAX_VALUE, 50 ) );
        button.setMaximumSize( new Dimension( Short.MAX_VALUE, 50 ) );
        panel.add( button );
        panel.add( Box.createRigidArea( new Dimension( 0, 10 ) ) );

        return button;
    }
}
