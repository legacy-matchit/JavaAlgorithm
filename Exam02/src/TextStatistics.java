import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class TextStatistics {
    ArrayList<Counter> characters;
    /** Skapar ett nytt register för att räkna antal förekomster för olika tecken.
     Inledningsvis finns inga tecken registrerade. */
    public TextStatistics(){
        characters = new ArrayList<>();
    }
    /** Räknar (en förekomst av) tecknet ch. Om tecknet förekommit tidigare ökas
     antalet förekomster med ett. Annars läggs tecknet in i registret. */
    public void countChar(char ch){

        Counter c = new Counter(ch);
        c.increase();
        if(characters.contains(c)){
            characters.get(characters.indexOf(c)).increase();
        }else{
            characters.add(c);
        }

    }
    /** Räknar varje tecken som förekommer i strängen s. */
    public void count(String s){
        for (int i =0 ; i < s.length(); i++){
            countChar(s.charAt(i));
        }
    }
    /** Hämtar alla tecken som räknats, ordnade efter antal förekomster.
     Varje tecken förekommer exakt en gång i resultatet. Det vanligaste
     tecknet kommer först i strängen, och det ovanligaste kommer sist. */
    public String frequencyOrder(){

        StringBuilder b = new StringBuilder();

        //sort by count
        for(int i = 0; i < characters.size(); i++){
            int max = i;
            for(int j = i; j < characters.size(); j++){
                if(characters.get(j).getCount() > characters.get(max).getCount()){
                    max = j;
                }
            }

            Counter tem = characters.get(i);
            characters.set(i,characters.get(max));
            characters.set(max,tem);
        }

        for (Counter c : characters){
            b.append(c.getChar());
        }

        return b.toString();
    }
}
