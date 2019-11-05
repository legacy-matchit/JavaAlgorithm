public class Counter {

    private char c;
    private int count;
    /** Skapa en räknare för tecknet c. Antalet är inledningsvis 0 (noll). */
    public Counter(char c){
        this.c = c;
        count = 0;
    }
    /** Tar reda på vilket tecken som räknas. */
    public char getChar(){
        return c;
    }
    /** Räknar en förekomst av tecknet, dvs öka antalet med ett. */
    public void increase(){
        count++;
    }
    /** Tar reda på antalet. */
    public int getCount(){
        return count;
    }
    /** Returnerar en sträng som beskriver tecknet och dess antal,
     på formen "[S]: 27" (om tecknet ’S’ räknats 27 gånger). */
    public String toString(){
        return "["+c+"]: " + count;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Counter)){
            return false;
        }
        Counter c = (Counter) obj;
        return this.c == c.c;
    }
}
