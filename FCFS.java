import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FCFS {
    pcb fcfs=new pcb();
    int counter=0;

    public void addFcfs(int bursTime){
        fcfs.ar[counter]=counter;
        fcfs.bt[counter]=bursTime;
        fcfs.pid[counter]=++counter;

    }


    public void findTurnAroundTime() {
        // calculating turnaround time by adding
        // bt[i] + wt[i]
        for (int i = 0; i < counter; i++) {
            fcfs.ta[i] = fcfs.bt[i] + fcfs.wt[i];
        }
    }
    public void findWaitingTime() {
        fcfs.wt[0] = 0;
        // calculating waiting time
        for (int i = 1; i < counter; i++) {
            fcfs.wt[i] = fcfs.bt[i - 1] + fcfs.wt[i - 1];
        }
    }

    public void findavgTime() {
        int wt[] = new int[30], tat[] = new int[30];
        int total_wt = 0, total_tat = 0,  total_ca=0;

        findWaitingTime();

        findTurnAroundTime();


        //Display processes along with all details
        System.out.printf("Processes BurstTime Waiting"
                +"Time TurnAroundTime\n");

        // Calculate total waiting time and total turn
        // around time
        for (int i = 0; i < counter; i++) {
            total_wt = total_wt + fcfs.wt[i];
            total_tat = total_tat + fcfs.ta[i];
             total_ca = total_ca + fcfs.ct[i];

            System.out.printf(" %d ", (i + 1));
            System.out.printf("        %d ", fcfs.bt[i]);
            System.out.printf("        %d", fcfs.wt[i]);
            System.out.printf("         %d\n", fcfs.ta[i]);
        }
        float s = (float)total_wt /(float) counter;
        int t = total_tat / counter;
        float c= (float)total_ca /(float) counter;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);



    }









}



