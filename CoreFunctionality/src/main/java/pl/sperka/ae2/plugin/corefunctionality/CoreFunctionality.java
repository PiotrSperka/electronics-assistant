package pl.sperka.ae2.plugin.corefunctionality;

import com.google.auto.service.AutoService;
import pl.sperka.ae2.plugin.corefunctionality.calculate.*;
import pl.sperka.ae2.plugin.corefunctionality.circuits.LM3xx;
import pl.sperka.ae2.plugin.corefunctionality.circuits.NE555;
import pl.sperka.ae2.plugin.corefunctionality.circuits.OpAmps;
import pl.sperka.ae2.plugin.corefunctionality.convert.*;
import pl.sperka.ae2.plugin.corefunctionality.microcontrollers.AvrCalc;
import pl.sperka.ae2.plugin.corefunctionality.microcontrollers.BitmapFontGenerator.FontGen;
import pl.sperka.ae2.plugin.corefunctionality.microcontrollers.GraphicalLcdImageGenerator.GraphLcdPict;
import pl.sperka.ae2.plugin.corefunctionality.microcontrollers.Hd44780CharacterGenerator.HD44780CharGen;
import pl.sperka.ae2.plugin.corefunctionality.microcontrollers.SevenSegmentDisplay._7SegGen;
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
        var tabCalculate = core.getTabByName( strings.getString( "plugin.tab.calculate" ) );

        var ledButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.led-resistor" ) );
        ledButton.addActionListener( e -> new ResistorForLed( core ).setVisible( true ) );

        var combinedResistanceButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.combined-resistance" ) );
        combinedResistanceButton.addActionListener( e -> new CombinedResistance( core ).setVisible( true ) );

        var uipButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.voltage-current-power" ) );
        uipButton.addActionListener( e -> new VoltageCurrentPower( core ).setVisible( true ) );

        var voltageDividerButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.voltage-divider" ) );
        voltageDividerButton.addActionListener( e -> new VoltageDivider( core ).setVisible( true ) );

        var radiatorParametersButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.radiator-parameters" ) );
        radiatorParametersButton.addActionListener( e -> new Radiator( core ).setVisible( true ) );

        var coilInductanceButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.coil-inductance" ) );
        coilInductanceButton.addActionListener( e -> new Coils( core ).setVisible( true ) );

        var closestESeriesValueButton = addButtonToPanel( tabCalculate, strings.getString( "plugin.tab.calculate.closest-e-series-value" ) );
        closestESeriesValueButton.addActionListener( e -> new ESeries( core ).setVisible( true ) );

        var tabConvert = core.getTabByName( strings.getString( "plugin.tab.convert" ) );

        var frequencyPeriodButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.frequency-period" ) );
        frequencyPeriodButton.addActionListener( e -> new FrequencyPeriod( core ).setVisible( true ) );

        var wattsDbmButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.watts-dbm" ) );
        wattsDbmButton.addActionListener( e -> new WattDbm( core ).setVisible( true ) );

        var orderOfMagnitudeButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.order-of-magnitude" ) );
        orderOfMagnitudeButton.addActionListener( e -> new OrderOfMagnitude( core ).setVisible( true ) );

        var numericalSystemsButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.numerical-systems" ) );
        numericalSystemsButton.addActionListener( e -> new NumericalSystems( core ).setVisible( true ) );

        var barCodesButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.bar-codes" ) );
        barCodesButton.addActionListener( e -> new BarCodes( core ).setVisible( true ) );

        var milCodeButton = addButtonToPanel( tabConvert, strings.getString( "plugin.tab.convert.mil-code" ) );
        milCodeButton.addActionListener( e -> new Mil( core ).setVisible( true ) );

        var tabCircuits = core.getTabByName( strings.getString( "plugin.tab.circuits" ) );

        var opAmpCircuitsButton = addButtonToPanel( tabCircuits, strings.getString( "plugin.tab.circuits.op-amp-circuits" ) );
        opAmpCircuitsButton.addActionListener( e -> new OpAmps( core ).setVisible( true ) );

        var lm3xxCircuitsButton = addButtonToPanel( tabCircuits, strings.getString( "plugin.tab.circuits.lm3xx-circuits" ) );
        lm3xxCircuitsButton.addActionListener( e -> new LM3xx( core ).setVisible( true ) );

        var ne555CircuitsButton = addButtonToPanel( tabCircuits, strings.getString( "plugin.tab.circuits.ne555-circuits" ) );
        ne555CircuitsButton.addActionListener( e -> new NE555( core ).setVisible( true ) );

        var tabMicrocontrollers = core.getTabByName( strings.getString( "plugin.tab.microcontrollers" ) );

        var avrCalculatorsButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.avr-calculators" ) );
        avrCalculatorsButton.addActionListener( e -> new AvrCalc( core ).setVisible( true ) );

        var bitmapFontGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.bitmap-font-generator" ) );
        bitmapFontGeneratorButton.addActionListener( e -> new FontGen( core ).setVisible( true ) );

        var sevenSegmentCharacterGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.seven-segment-character-generator" ) );
        sevenSegmentCharacterGeneratorButton.addActionListener( e -> new _7SegGen( core ).setVisible( true ) );

        var graphicalDisplayImageGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.graphical-display-image-generator" ) );
        graphicalDisplayImageGeneratorButton.addActionListener( e -> new GraphLcdPict( core ).setVisible( true ) );

        var hdCharacterGeneratorButton = addButtonToPanel( tabMicrocontrollers, strings.getString( "plugin.tab.microcontrollers.hd44780-character-generator-generator" ) );
        hdCharacterGeneratorButton.addActionListener( e -> new HD44780CharGen( core ).setVisible( true ) );

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
