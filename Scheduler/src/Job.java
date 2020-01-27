public class Job implements Comparable<Job>{

    private String name;
    private int time;

    public Job(String name, int time){
        this.name = name;
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    public int compareTo(Job j){
        return Integer.compare(j.time,time);
    }

    @Override
    public String toString() {
        return name + " (" + time +")";
    }
}
