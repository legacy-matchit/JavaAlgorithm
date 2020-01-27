import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SchdulerDemo {
    public static void main(String[] args) {


        /*
        Machine[] m = new Machine[3];
        for(int i = 0; i < m.length; i++){
            m[i] = new Machine(i + 1);
        }

        ArrayList<Job> jobList = new ArrayList<>();
        String[] names = {"j4","j2","j5","j6","j3","j7","j1"};
        int[] times = {16,14,6,5,4,3,2};
        for(int i = 0; i < names.length; i++){
            jobList.add(new Job(names[i],times[i]));
        }

        Scheduler s = new Scheduler(m);
        s.makeSchedule(jobList);
        s.printschedule();
        */



        String[] names = {"j4","j2","j5","j6","j3","j7","j1"};
        int[] times = {16,14,6,5,4,3,2};

        Queue<Job>q = new PriorityQueue<>();
        ArrayList<Job> jobList = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            q.offer(new Job(names[i],times[i]));
        }
        for(int i = 0; i < 7; i++){
            jobList.add(q.poll());
        }

        Queue<Machine> queue = new PriorityQueue<>();
        for(int i = 0; i < 3; i++){
            queue.offer(new Machine(i+1));
        }
        for (Job j: jobList) {
            Machine mm = queue.poll();
            mm.assignJob(j);
            queue.offer(mm);
        }
        for(int i = 0; i < 3; i++){
            Machine mm = queue.poll();
            System.out.println(mm);
        }

    }
}
