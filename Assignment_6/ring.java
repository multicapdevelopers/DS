import java.io.*;
import java.util.Scanner;
 
class ring{
    static int n;
    static int process[] = new int[100];
    static int status[] = new int[100];
    static int priority[] = new int[100];
    static int coordinator;
     
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of process: ");
        n = sc.nextInt();
                  
        for(int i=0;i<n;i++)
        {
            //System.out.println("For process "+(i+1)+":");
        	System.out.print("\nEnter process (process no. is same as priority): ");
            process[i] = sc.nextInt();
            System.out.print("Status (1 is active and 0 is inactive):");
            status[i]=sc.nextInt();
            
        }
        
        System.out.println("\nThe ring formed is: ");
        for (int i=1;i<=n;i++) {
        	System.out.print(i + " ->");
        }
        System.out.println("1");
         
        System.out.print("\nWhich process will initiate election?: ");
        int initiateElection = sc.nextInt();
        System.out.println();
         
        election(initiateElection);
        System.out.println("\n\nFinal coordinator is "+coordinator);
    }
     
    static void election(int initiateElection)
    {
        
        int i;
        int index = 0;
        int max = 0;
        //add from election initiator to the end to priority array
        for(i=(initiateElection-1);i<n;i++) 
        {
        	if(status[i]==1) 
        	{
        		priority[index] = process[i];
        		index = index + 1;
        	}
        }
      //add from beginning to the election initiator to priority array
        for(i=0;i<initiateElection-1;i++) 
        {
        	if(status[i] == 1) 
        	{
        		priority[index] = process[i];
        		index = index + 1;
        	}
        }
        //print priority array and find the greatest of all
        System.out.print("the priority array is: ");
        for(i=0;i<index;i++) 
        {
        	
        	if(priority[i]>max) 
        	{
        		max = priority[i];
        	}
        	System.out.print(priority[i] + " ");
        }
        
        coordinator = max;
    }
}