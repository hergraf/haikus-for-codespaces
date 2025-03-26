

import jdk.incubator.vector.*;


public class App {
    public static void main(String[] args) throws Exception {
           // Ein neues Array erstellen
           String[] data = new String[3];

           // Daten in das Array schreiben
           data[0] = "Hallo";
           data[1] = "Welt";
           data[2] = "Java";
   
           // Array-Inhalt ausgeben
           for (String element : data) {
               System.out.println(element);
           }

           int flags = 0b0000_1100; // Binär: 12 (entspricht den Bits 00001100)

           // Prüfen, ob ein bestimmtes Bit gesetzt ist (z. B. das dritte Bit von rechts)
           int mask = 0b0000_0100; // Binär: 4 (entspricht dem dritten Bit)
           boolean isSet = (flags & mask) != 0;
           System.out.println("Drittes Bit gesetzt: " + isSet);
   
           // Ein Bit setzen (z. B. das erste Bit von rechts)
           mask = 0b0000_0001; // Binär: 1 (entspricht dem ersten Bit)
           flags = flags | mask; // Setzt das erste Bit
           System.out.println("Neuer Wert von flags: " + Integer.toBinaryString(flags));
   
           // Ein Bit löschen (z. B. das dritte Bit von rechts)
           mask = 0b0000_0100; // Binär: 4 (entspricht dem dritten Bit)
           flags = flags & ~mask; // Löscht das dritte Bit
           System.out.println("Neuer Wert von flags nach Löschen: " + Integer.toBinaryString(flags));


        // Ein Array mit Daten erstellen
        float[] array1 = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] array2 = {5.0f, 6.0f, 7.0f, 8.0f};
        float[] result = new float[4];

        // Vector-Spezifikation für 128-Bit-Floats
        VectorSpecies<Float> species = FloatVector.SPECIES_128;

        // Vektorisierte Addition
        for (int i = 0; i < array1.length; i += species.length()) {
            // Lade Daten in Vektoren
            FloatVector vector1 = FloatVector.fromArray(species, array1, i);
            FloatVector vector2 = FloatVector.fromArray(species, array2, i);

            // Addiere die Vektoren
            FloatVector vectorResult = vector1.add(vector2);

            // Speichere das Ergebnis im Array
            vectorResult.intoArray(result, i);
        }

        // Ergebnis ausgeben
        for (float value : result) {
            System.out.println(value);
        }


       }

       
}
