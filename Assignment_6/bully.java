import java.io.*;
import java.util.Scanner;
 
class bully{
    static int n;
    static int process[] = new int[100];
    static int status[] = new int[100];
    static int coordinator;
     
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of process: ");
        n = sc.nextInt();
                  
        for(int i=0;i<n;i++)
        {
            //System.out.println("For process "+(i+1)+":");
            System.out.print("Enter process (process no. is same as priority): ");
            process[i] = sc.nextInt();
            System.out.print("Status (1 is active and 0 is inactive):");
            status[i]=sc.nextInt();
        }
         
        System.out.print("Which process will initiate election?: ");
        int initiateElection = sc.nextInt();
        System.out.println();
         
        election(initiateElection);
        System.out.println("\nFinal coordinator is "+coordinator);
    }
     
    static void election(int initiateElection)
    {
    	initiateElection = initiateElection-1;
    	coordinator = initiateElection+1;
        for(int i=0;i<n;i++)
        {
            if(process[initiateElection]<process[i] && status[i]!=0)
            {
                System.out.println("Election message is sent from "+(initiateElection+1)+" to "+(i+1));
                //if(status[i]==1)
                election(i+1);
            }
        }
    }
}