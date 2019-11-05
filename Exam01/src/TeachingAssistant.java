import java.util.ArrayList;

public class TeachingAssistant {

    private String name;
    private String personalIdNbr;
    private ArrayList<WorkShift> workShift;
    /** Skapar en ny labbhandledare med namnet name och personnumret personalIdNbr */
    public TeachingAssistant(String name, String personalIdNbr){
        this.name = name;
        this.personalIdNbr = personalIdNbr;
        workShift = new ArrayList<>();
    }
    /** Lägger till ett nytt arbetspass för denna handledare. Arbetspasset ska bli
     ett hemarbetspass om isAtHome är true (annars salsarbetspass) och passet
     arbetades dagen date från kl from till klockan to */
    public void addShift(boolean isAtHome, String date, int from, int to){

        //add
        workShift.add(new WorkShift(isAtHome,date,from,to));

        //sort ASC
        for(int i = 0; i < workShift.size(); i++){
            int asc = i;
            for(int j = i; j < workShift.size(); j++){
                if(workShift.get(j).getDateAsString().compareTo(workShift.get(asc).getDateAsString()) < 0){
                    asc = j;
                }
            }

            WorkShift tem = workShift.get(i);
            workShift.set(i,workShift.get(asc));
            workShift.set(asc,tem);
        }
    }
    /** Returnerar en lista med de hemarbetspass som denna labbhandledare arbetat i
     månad monthNbr, sorterade i datumordning.
     Om inga sådana pass arbetats returneras en tom lista */
    public ArrayList<WorkShift> getHomeShiftsForMonth(int monthNbr){

        ArrayList<WorkShift> w = new ArrayList<>();
        for(WorkShift shift: workShift){
            if(shift.getMonth() == monthNbr && shift.isAtHome()){
                w.add(shift);
            }
        }
        return w;
    }
    /** Returnerar en lista med de salsarbetspass som denna labbhandledare arbetat i
     månad monthNbr, sorterade i datumordning.
     Om inga sådana pass arbetats returneras en tom lista */
    public ArrayList<WorkShift> getTeachingShiftsForMonth(int monthNbr){
        ArrayList<WorkShift> w = new ArrayList<>();
        for(WorkShift shift: workShift){
            if(shift.getMonth() == monthNbr && !shift.isAtHome()){
                w.add(shift);
            }
        }
        return w;
    }
    /** Räknar ut hur många olika dagar labbhandledaren har arbetat under månaden med
     nummer monthNbr. En dag räknas som arbetad om det, oavsett längd, finns minst
     ett arbetspass registrerat för dagen */
    public int getNbrOfDaysForMonth(int monthNbr){
        return getHomeShiftsForMonth(monthNbr).size() + getTeachingShiftsForMonth(monthNbr).size();
    }
    /** Returnerar handledarens totala lön (baserat på arbetade pass, typ av pass
     samt aktuell timlön) för månad monthNbr */
    public double getTotalPaymentForMonth(int monthNbr){
        int home = 0;
        int teaching = 0;
        for(WorkShift w : getHomeShiftsForMonth(monthNbr)){
            home = home + (w.getLength() * (int)PaymentGenerator.HOME_SALARY);
        }
        for(WorkShift w : getTeachingShiftsForMonth(monthNbr)){
            teaching = teaching + (w.getLength() * (int)PaymentGenerator.TEACHING_SALARY);
        }
        return home + teaching;
    }
    /** Returnerar sträng som representerar denna handledares lönelista
     för månad monthNbr. OBS! Färdigskriven */
    public String getStringForMonth(int monthNbr){
        StringBuilder sb = new StringBuilder();
        sb.append("Löneutbetalning för: " + name).append("\n");
        sb.append("Hemarbete:").append("\n");
        ArrayList<WorkShift> home = getHomeShiftsForMonth(monthNbr);
        for (WorkShift workShift : home) {
            sb.append("\t" + workShift).append("\n");
        }
        sb.append("Salsarbete:").append("\n");
        ArrayList<WorkShift> teach = getTeachingShiftsForMonth(monthNbr);
        for (WorkShift workShift : teach) {
            sb.append("\t" + workShift).append("\n");
        }
        sb.append("Totalt arbetade dagar: " + getNbrOfDaysForMonth(monthNbr)).append("\n");
        sb.append("Total lön: " + getTotalPaymentForMonth(monthNbr)).append("\n");
        return sb.toString();
    }
}
