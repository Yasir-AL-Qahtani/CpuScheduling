public class RR {
    pcb RR=new pcb();
    int counter=0;
    int quan=0;

    public RR( int quan) {
        this.quan=quan;
    }

    public void addRR(int bursTime){
        RR.ar[counter]=counter;
        RR.bt[counter]=bursTime;
        RR.pid[counter]=++counter;
    }
    public void findWaitingTime( ) {

        int rem_bt[] = new int[30];
        for (int i = 0 ; i < counter ; i++)
            rem_bt[i] =  RR.bt[i];

        int t = 0;


        while(true)
        {
            boolean done = true;

            for (int i = 0 ; i < counter; i++)
            {

                if (rem_bt[i] > 0)
                {
                    done = false;

                    if (rem_bt[i] > quan)
                    {
                        // Increase the value of t i.e. shows
                        // how much time a process has been processed
                        t += quan;

                        // Decrease the burst_time of current process
                        // by quantum
                        rem_bt[i] -= quan;
                    }

                    // If burst time is smaller than or equal to
                    // quantum. Last cycle for this process
                    else
                    {
                        // Increase the value of t i.e. shows
                        // how much time a process has been processed
                        t = t + rem_bt[i];

                        // Waiting time is current time minus time
                        // used by this process
                        RR.wt[i] = t - RR.bt[i];

                        // As the process gets fully executed
                        // make its remaining burst time = 0
                        rem_bt[i] = 0;
                    }
                }
            }

            // If all processes are done
            if (done == true)
                break;
        }
    }

    public void findTurnAroundTime() {
        // calculating turnaround time by adding
        // bt[i] + wt[i]
        for (int i = 0; i < counter ; i++)
            RR.ta[i] = RR.bt[i] + RR.wt[i];
    }
    public void findavgTime()
    {
        int wt[] = new int[30], tat[] = new int[30];
        int total_wt = 0, total_tat = 0;

        // Function to find waiting time of all processes
        findWaitingTime();

        // Function to find turn around time for all processes
        findTurnAroundTime();

        // Display processes along with all details
        System.out.println("Processes " + " Burst time " +
                " Waiting time " + " Turn around time");

        // Calculate total waiting time and total turn
        // around time
        for (int i=0; i<counter; i++)
        {
            total_wt = total_wt + RR.wt[i];
            total_tat = total_tat + RR.ta[i];
            System.out.println(" " + (i+1) + "\t\t\t" + RR.bt[i] +"\t\t\t " +
                    RR.wt[i] +"\t\t\t " + RR.ta[i]);
        }

        System.out.println("Average waiting time = " +
                (float)total_wt / (float)counter);
        System.out.println("Average turn around time = " +
                (float)total_tat / (float)counter);
    }

}
