import java.util.ArrayList;
import java.util.Arrays;

public class Scheduler {

    private Machine[] machines;

    public Scheduler(Machine[] machines){
        this.machines = machines;
    }

    private void sortByTotalTime(){
        for(int i = 0; i < machines.length; i++){
            int pos = i;
            for(int j = i; j < machines.length; j++){
                if(machines[j].getTotalTime() < machines[pos].getTotalTime()){
                    pos = j;
                }
            }

            Machine tem = machines[i];
            machines[i] = machines[pos];
            machines[pos] = tem;
        }
    }
    
    public void makeSchedule(ArrayList<Job> jobs){

        while (jobs.size() > 0){
            if(jobs.size() > 0){
                sortByTotalTime();
                machines[0].assignJob(jobs.remove(0));
            }
        }

    }

    public void printschedule(){
        for(int i = 0; i < machines.length; i++){
            int pos = i;
            for(int j = i; j < machines.length; j++){
                if(machines[j].getNbr() < machines[pos].getNbr()){
                    pos = j;
                }
            }

            Machine tem = machines[i];
            machines[i] = machines[pos];
            machines[pos] = tem;

            System.out.println(machines[i]);
        }
    }
}
