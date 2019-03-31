import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class filereaderclass {

	public static rbtree rbt;
	public static int period;
	public static int node_cnt=0;
	public static int n;

	public static void main(String[] args) throws FileNotFoundException
	{
			//rbt first node
			rbt=new rbtree();
			ArrayList<process> processes=new ArrayList<process>();
			Scanner scanner = new Scanner(new File("C:\\vkk.txt"));
			Scanner consoleInput =new Scanner(System.in);
			n=scanner.nextInt();
			period=scanner.nextInt();
			System.out.println("Number of processes="+n);
			System.out.println("Quantum period= "+period);
			
                        System.out.println("\n\n1->Time in CPU\n2->Remaining Execution Time \n3->Time in CPU +Remaining Execution Time  ");
			int ch=consoleInput.nextInt();
                        int l=0;
                        for(int j=0;j<n;j++)
			{
				int m=0,n=3;
                                processes.add(new process(rbt,l,m,n));
                                l++;
                                node_cnt++;
                        }
                        consoleInput.close();
                        scanner.close();			

			 scheduler sc=new scheduler();
		    if(ch==1)
		    {
		    
		    sc.scheduleRBTree(rbt);
		    }
		    else if(ch==2)
		    {
		    	
		    	sc.scheduleRBTreeWtRe(rbt);
		    }
		    else if(ch==3)
		    {
		    	
		    	sc.scheduleRBTreeBoth(rbt);
		    }
		    else 
		    {
		    	System.out.println("\nIncorrect Input");
		    }
	}}