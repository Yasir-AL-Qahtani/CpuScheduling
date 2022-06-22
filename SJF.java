import java.util.*;
public class SJF {
    pcb sjf=new pcb();
    int counter=0;

    public void addSjf(int bursTime,int art){
        sjf.ar[counter]=art;
        sjf.bt[counter]=bursTime;
        sjf.pid[counter]=++counter;

    }
    public void findTurnAroundTime() {
        for (int i = 0; i < counter; i++)
            sjf.ta[i] = sjf.bt[i]+ sjf.wt[i];
    }

    public void findWaitingTime() {
        int remainintTime[] = new int[30];


        for (int i = 0; i < counter; i++)
            remainintTime[i] = sjf.bt[i];

        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;


        while (complete != counter) {


            for (int j = 0; j < counter; j++)
            {
                if ((sjf.ar[j] <= t) &&
                        (remainintTime[j] < minm) && remainintTime[j] > 0) {
                    minm = remainintTime[j];
                    shortest = j;
                    check = true;
                }
            }

            if (check == false) {
                t++;
                continue;
            }


            remainintTime[shortest]--;

            minm = remainintTime[shortest];
            if (minm == 0)
                minm = Integer.MAX_VALUE;

            // If a process gets completely
            // executed
            if (remainintTime[shortest] == 0) {

                // Increment complete
                complete++;
                check = false;

                // Find finish time of current
                // process
                finish_time = t + 1;

                // Calculate waiting time
                sjf.wt[shortest] = finish_time -
                        sjf.bt[shortest] -
                        sjf.ar[shortest];

                if (sjf.wt[shortest] < 0)
                    sjf.wt[shortest] = 0;
            }
            // Increment time
            t++;
        }
    }

    public void findavgTime()
    {
        int wt[] = new int[30], tat[] = new int[30];
        int  total_wt = 0, total_tat = 0;

        // Function to find waiting time of all
        // processes
        findWaitingTime();

        // Function to find turn around time for
        // all processes
        findTurnAroundTime();

        // Display processes along with all
        // details
        System.out.println("Processes " +
                " BurstTime " +
                " WaitingTime " +
                " TurnAroundTime");

        // Calculate total waiting time and
        // total turnaround time
        for (int i = 0; i < counter; i++) {
            total_wt = total_wt + sjf.wt[i];
            total_tat = total_tat + sjf.ta[i];
            System.out.println(" " + sjf.pid[i] + "\t\t\t"
                    + sjf.bt[i] + "\t\t\t " + sjf.wt[i]
                    + "\t\t\t" + sjf.ta[i]);
        }

        System.out.println("Average waiting time = " +
                (float)total_wt / (float)counter);
        System.out.println("Average turn around time = " +
                (float)total_tat / (float)counter);
    }



}