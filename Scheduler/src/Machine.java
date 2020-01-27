import java.util.ArrayList;

public class Machine implements Comparable<Machine>{

    private int nbr;
    private ArrayList<Job> jobs;

    /** init with machine number*/
    public Machine(int nbr){
        this.nbr = nbr;
        jobs = new ArrayList<>();
    }

    public int getNbr(){
        return nbr;
    }

    public void assignJob(Job j){
        jobs.add(j);
    }

    public void clearJobs(){
        jobs.clear();
    }

    public Job getNextJob(){
        if(jobs.size() > 0){
            return jobs.remove(0);
        }
        return null;
    }

    public int getTotalTime(){
        int time = 0;
        for(Job j:jobs){
            time += j.getTime();
        }
        return time;
    }

    public int compareTo(Machine m){
        int result = Integer.compare(getTotalTime(),m.getTotalTime());
        if(result == 0){
            result = Integer.compare(jobs.size(),m.jobs.size());
        }
        return result;
    }

    @Override
    public String toString() {
        return nbr + "  " + jobs.toString();
    }
}
