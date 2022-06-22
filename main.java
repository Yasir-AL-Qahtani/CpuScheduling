import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner;
public class main {





    public static void main(String[] args)throws Exception{

        RR test1=new RR(3);
        RR test2=new RR(5);
        FCFS test3=new FCFS();
        SJF test4=new SJF();


        File myObj = new File("testdata1.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()){
            if (myReader.hasNextInt()){
                int t= myReader.nextInt();
                test1.addRR(t);
                test2.addRR(t);
                test3.addFcfs(t);
                test4.addSjf(t,0);
            }
            if (myReader.hasNextLine()){
              myReader.nextLine();
             }

        }
        test1.findavgTime();
        System.out.println("***************************************************************************************");
        test2.findavgTime();
        System.out.println("***************************************************************************************");
        test3.findavgTime();
        System.out.println("\n***************************************************************************************");
        test4.findavgTime();

    }







}
