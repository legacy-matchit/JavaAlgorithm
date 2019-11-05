import java.util.ArrayList;
import java.util.Arrays;

public class Scheduler {

    private Machine[] machines;

    public Scheduler(Machine[] machines){
        this.machines = machines;
    }

    private int findLowerTimeMachine(){
        int pos = 0;
        for(int i = 1; i < machines.length; i++){
            if(machines[i].getTotalTime() < machines[pos].getTotalTime()){
                pos = i;
            }
        }
        return pos;
    }

    public void makeSchedule(ArrayList<Job> jobs){

        while (jobs.size() > 0){
            int pos = findLowerTimeMachine();
            machines[pos].assignJob(jobs.remove(0));
        }

    }

    public void printschedule() {

        for (int i = 0; i < machines.length; i++) {
            System.out.println(machines[i]);
        }
    }
}
