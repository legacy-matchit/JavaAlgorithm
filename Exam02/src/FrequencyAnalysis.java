import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FrequencyAnalysis {

    // Tecken i svenska språket, ordnade utifrån hur vanliga de är
    private static final String F_KLARTEXT = "EAN RTSILDOMKGVHF.UPÄBCÅÖYJXWZQ";
    /** Knäcker det krypterade meddelandet m med hjälp
     av frekvensanalys, och skriver ut det i klartext. */
    public static void crack(String m) {
        // återstår att implementera

        TextStatistics statistics = new TextStatistics();
        statistics.count(m);
        String orderedText = statistics.frequencyOrder();

        for (int i = 0; i < m.length(); i++){
            char c = m.charAt(i);
            int index = orderedText.indexOf(c);
            System.out.print(F_KLARTEXT.charAt(index));
        }
    }
    public static void main(String[] args) {
        try {
            // Filen innehåller en enda rad med krypterad text
            Scanner scan = new Scanner(new File("src/encrypted.txt"));
            String s = scan.nextLine();
            FrequencyAnalysis.crack(s);
        } catch (FileNotFoundException e) {
            System.out.println("Fel: filen kunde inte läsas: " + e);
        }
    }
}
