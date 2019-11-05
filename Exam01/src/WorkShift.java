public class WorkShift {

    private boolean isAtHome;
    private String date;
    private int day;
    private int month;
    private int from;
    private int to;

    /** Skapar ett nytt arbetspass där isAtHome är true om det gäller hemarbete
     och false annars. Passet är schemalagt till datumet date kl from till to. */
    public WorkShift(boolean isAtHome, String date, int from, int to){
        this.isAtHome = isAtHome;
        this.date = date;
        this.from = from;
        this.to = to;
        String [] d = date.split("-");
        this.month = Integer.parseInt(d[1]);
        this.day = Integer.parseInt(d[2]);
    }
    /** Returnerar true om passet är ett hemarbetespass, false annars */
    public boolean isAtHome(){
        return isAtHome;
    }
    /** Returnerar numret på den dag (1-31) då passet arbetades */
    public int getDay(){
        return day;
    }
    /** Returnerar numret på den månad (1-12) då passet arbetades */
    public int getMonth(){
        return month;
    }
    /** Returnerar arbetspassets längd i timmar */
    public int getLength(){
        return Math.abs(to - from);
    }
    /** Returnerar arbetspassets datum på formen yyyy-mm-dd */
    public String getDateAsString(){
        return date;
    }
    /** Returnerar en läsbar representation av detta arbetspass.
     Retursträngen kommer följa följande format:
     2019-06-24 kl 10-12 (2 timmar) */
    public String toString(){
        return date + " kl " +from + "-" + to + "(" + getLength() + " time)";
    }
}
