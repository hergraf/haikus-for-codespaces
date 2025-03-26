import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class TryEnum {

// Globale Flag für bedingtes Logging
private static final boolean ENABLE_LOGGING = true;

// Logger-Instanz
private static final Logger logger = Logger.getLogger(TryEnum.class.getName());

    public static void main(String[] args) {
        App1 color1 = App1.RED;
        App1 color2 = App1.GREEN;
        App1 color3 = App1.BLUE;

        System.out.println("Farbe: " + color1);
        System.out.println("Farbcode: " + color1.getColorCode());


        // Ein EnumSet erstellen, das bestimmte Farben enthält
        EnumSet<App1> primaryColors = EnumSet.of(App1.RED, App1.GREEN);

        // Alle Farben im EnumSet durchlaufen
        System.out.println("Primärfarben:");
        for (App1 color : primaryColors) {
            System.out.println("Farbe: " + color + ", Farbcode: " + color.getColorCode());
        }

        // Ein EnumSet erstellen, das alle Enum-Werte enthält
        EnumSet<App1> allColors = EnumSet.allOf(App1.class);
        System.out.println("\nAlle Farben:");
        for (App1 color : allColors) {
            System.out.println("Farbe: " + color + ", Farbcode: " + color.getColorCode());
        }

        // Ein leeres EnumSet erstellen
        EnumSet<App1> noColors = EnumSet.noneOf(App1.class);
        System.out.println("\nLeeres EnumSet: " + noColors);

         
                // Ein EnumSet erstellen, das bestimmte Farben enthält
                EnumSet<App1> colorMask = EnumSet.noneOf(App1.class);
        
                // Farben zur Bitmaske hinzufügen
                colorMask.add(App1.RED);
                colorMask.add(App1.GREEN);
        
                // Prüfen, ob eine Farbe in der Bitmaske enthalten ist
                System.out.println("Enthält Rot? " + colorMask.contains(App1.RED));
                System.out.println("Enthält Blau? " + colorMask.contains(App1.BLUE));
        
                // Eine Farbe aus der Bitmaske entfernen
                colorMask.remove(App1.RED);
                System.out.println("Enthält Rot nach Entfernen? " + colorMask.contains(App1.RED));
        
                // Alle Farben in der Bitmaske ausgeben
                System.out.println("Aktuelle Farben in der Bitmaske:");
                for (App1 color : colorMask) {
                    System.out.println("Farbe: " + color + ", Farbcode: " + color.getColorCode());
                }
        
                // Bitmaske zurücksetzen (leeren)
                colorMask.clear();
                System.out.println("Bitmaske nach dem Leeren: " + colorMask);


   

   // Bedingtes Logging
   if (ENABLE_LOGGING) {
       logger.info("Enthält Rot? " + colorMask.contains(App1.RED));
       logger.info("Enthält Blau? " + colorMask.contains(App1.BLUE));
   }


            
    }

    private static void configureLogger() {
        // Logger-Level setzen
        logger.setLevel(Level.ALL);

        // Konsolen-Handler hinzufügen
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);

        // Datei-Handler hinzufügen (optional)
        try {
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            System.err.println("Fehler beim Hinzufügen des Datei-Handlers: " + e.getMessage());
        }
    }
        
    
}
