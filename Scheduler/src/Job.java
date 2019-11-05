public class Job {

    private String name;
    private int time;

    public Job(String name, int time){
        this.name = name;
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    @Override
    public String toString() {
        return name + " (" + time +")";
    }
}
