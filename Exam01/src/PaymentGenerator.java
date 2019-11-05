import java.util.ArrayList;
import java.util.Scanner;

public class PaymentGenerator {
    public static final double TEACHING_SALARY = 264;
    public static final double HOME_SALARY = 130;

    private ArrayList<TeachingAssistant> assistantList;

    public PaymentGenerator(Scanner scanner){
        assistantList = new ArrayList<>();

        TeachingAssistant t = null;
        while (scanner.hasNextLine()){

            String line = scanner.nextLine();
            String[] s = line.split(" ");
            if(s[0].equals("#")){
                t = new TeachingAssistant(s[1] + s[2],s[3]);
                assistantList.add(t);
            }else{
                boolean isHome = s[0].equals("H");
                String date = s[1];
                int from = Integer.parseInt(s[2]);
                int to = Integer.parseInt(s[3]);
                t.addShift(isHome,date,from,to);
            }


        }
    }
    public void printShiftsForMonth(int monthNbr){
        for(int i = 0; i < assistantList.size(); i++){
            TeachingAssistant t = assistantList.get(i);
            System.out.println(t.getStringForMonth(monthNbr));
        }
    }
}
