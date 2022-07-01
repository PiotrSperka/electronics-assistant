package pl.sperka.ae2.plugins;

import java.time.LocalDateTime;

public interface IPlugin {
    String getName();
    String getDescription();
    String getVersionString();
    default int getVersionNumber() {
        try {
            var versionString = getVersionString();
            var versionElements = versionString.split( "\\." );
            int versionNumber = 0;
            int multiplier = 1;

            for ( int i = versionElements.length - 1; i >= 0; i-- ) {
                versionNumber += Integer.parseInt( versionElements[i] ) * multiplier;
                multiplier *= 10;
            }

            return versionNumber;
        } catch ( Exception ex ) {
            return -1;
        }
    }

    String getAuthor();
    String getEmail();
    String getHomepage();
    LocalDateTime getCreationDate();
    Boolean initialize(ICore core);
}
