public class scheduler {
	
    
    
        private int quantumTime=filereaderclass.period;

	process p;
	public static long CLOCK=1;
	public static long CLOCK2=1;




	public void scheduleRBTree(rbtree rt)
	{

		 long totalWaitTime=0;
		 long totalTurnAroundTime=0;
		 long timeKeeper=0;
		 System.out.println("\n\nScheduling using red black tree data structure...\n");
		 System.out.println("\nScheduling Metric/Unfairness Measure--Time In Processor--");


		while(rbtree.NodeCount>1){
			 long start = System.nanoTime();
			p=rt.delete().process;


			if(p.extime>quantumTime)
			{
				p.uf=p.uf+quantumTime;
				p.CPUtime=p.CPUtime+quantumTime;
				p.extime=p.extime-quantumTime;
				CLOCK2=CLOCK2+quantumTime;
				p.wt=CLOCK2- p.at- p.CPUtime; 
				if(p.extime>0)
				{
					rt.insert(p);
				}
				else
				{

					totalWaitTime+=p.wt;
					p.turnAroundTime=CLOCK2-p.at;
					totalTurnAroundTime+=p.turnAroundTime;
				}

			}
			else
			{
				p.CPUtime=p.CPUtime+p.extime;
				CLOCK2=CLOCK2+p.extime;
				p.wt=CLOCK2-p.at-p.CPUtime;  
				p.extime=0;	
				totalWaitTime+=p.wt;
				p.turnAroundTime=CLOCK2-p.at;
				totalTurnAroundTime+=p.turnAroundTime;


			}

			long end = System.nanoTime();
			timeKeeper+=(end-start);
                        System.out.println("RB Tree\n");
                        rt.printRB();
//		System.out.println("");
//	
		}

		float thr=((float)filereaderclass.n*100000)/((float)timeKeeper);
		long timeUnit=timeKeeper/CLOCK2;
		System.out.println("\nCOMPLETELY FAIR SCHEDULING USING RED BLACK TREES- PERFORMANCE METRICS ");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("\n1.Total Number of inputs :"+filereaderclass.n);
		System.out.println("\n2.Total Running Time: "+ timeKeeper+ " nano seconds");
		System.out.println("\n3.Running time per process:" +timeKeeper/filereaderclass.n+ " nano seconds");
		System.out.println("\n4.Total Wait Time :"+totalWaitTime*timeUnit+" nano seconds");
		System.out.println("\n5.Average Wait Time :"+(totalWaitTime/filereaderclass.n)*timeUnit+" nano seconds");
		System.out.println("\n6.Total turn around time: " +totalTurnAroundTime*timeUnit+" nano seconds");
		System.out.println("\n7.Average turn around time: " +(totalTurnAroundTime/filereaderclass.n)*timeUnit+" nano seconds");
		System.out.printf("\n8.Throughput: %.2f tasks/millisecond",thr);


        }	


// Impl RBTree
	public void scheduleRBTreeWtRe(rbtree rt) {


		 long totalWaitTime=0;
		 long totalTurnAroundTime=0;
		 long timeKeeper=0;

		System.out.println("\n\nScheduling using heap red black tree data structure...\n");
		System.out.println("\nScheduling Metric/Unfairness measure--Remaining execution time--");


		while(rbtree.NodeCount>1){
			long start = System.nanoTime();
			p=rt.delete().process;


			if(p.extime>quantumTime)
			{

				p.CPUtime=p.CPUtime+quantumTime;
				p.extime=p.extime-quantumTime;
				CLOCK2=CLOCK2+quantumTime;
				p.wt=CLOCK2- p.at- p.CPUtime; 
				p.uf=p.uf+p.extime;
				if(p.extime>0)
				{
					rt.insert(p);
				}
				else
				{

					totalWaitTime+=p.wt;
					p.turnAroundTime=CLOCK2-p.at;
					totalTurnAroundTime+=p.turnAroundTime;

				}

			}
			else
			{
				p.CPUtime=p.CPUtime+p.extime;
				CLOCK2=CLOCK2+p.extime;
				p.wt=CLOCK2-p.at-p.CPUtime;  
				p.extime=0;	
				totalWaitTime+=p.wt;
				p.turnAroundTime=CLOCK2-p.at;
				totalTurnAroundTime+=p.turnAroundTime;
				p.uf=p.uf+p.extime;

			}
			long end = System.nanoTime();
			timeKeeper+=(end-start);
            System.out.println("RB Tree\n");
	    rt.printRB();
//		System.out.println("");
//	
		}

		float thr=((float)filereaderclass.n*100000)/((float)timeKeeper);
		long timeUnit=timeKeeper/CLOCK2;
		System.out.println("\nCOMPLETELY FAIR SCHEDULING USING RED BLACK TREES- PERFORMANCE METRICS ");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("\n1.Total Number of inputs :"+filereaderclass.n);
		System.out.println("\n2.Total Running Time: "+ timeKeeper+ " nano seconds");
		System.out.println("\n3.Running time per process:" +timeKeeper/filereaderclass.n+ " nano seconds");
		System.out.println("\n4.Total Wait Time :"+totalWaitTime*timeUnit+" nano seconds");
		System.out.println("\n5.Average Wait Time :"+(totalWaitTime/filereaderclass.n)*timeUnit+" nano seconds");
		System.out.println("\n6.Total turn around time: " +totalTurnAroundTime*timeUnit+" nano seconds");
		System.out.println("\n7.Average turn around time: " +(totalTurnAroundTime/filereaderclass.n)*timeUnit+" nano seconds");
		System.out.printf("\n8.Throughput: %.2f tasks/millisecond",thr);


	}
        
        
        
        public void scheduleRBTreeBoth(rbtree rt)
	{

		 long totalWaitTime=0;
		 long totalTurnAroundTime=0;
		 long timeKeeper=0;
		System.out.println("\n\nScheduling using red black tree data structure...\n");
		System.out.println("\nScheduling Metric/Unfairness Measure--Time In Processor + Remaining Execution Time--");


		while(rbtree.NodeCount>1){
			 long start = System.nanoTime();
			p=rt.delete().process;


			if(p.extime>quantumTime)
			{

				p.CPUtime=p.CPUtime+quantumTime;
				p.extime=p.extime-quantumTime;
				CLOCK2=CLOCK2+quantumTime;
				p.wt=CLOCK2- p.at- p.CPUtime;
				p.uf=p.uf+quantumTime+p.extime;
				if(p.extime>0)
				{
					rt.insert(p);
				}
				else
				{

					totalWaitTime+=p.wt;
					p.turnAroundTime=CLOCK2-p.at;
					totalTurnAroundTime+=p.turnAroundTime;
				}

			}
			else
			{
				p.CPUtime=p.CPUtime+p.extime;
				CLOCK2=CLOCK2+p.extime;
				p.wt=CLOCK2-p.at-p.CPUtime;  
				p.extime=0;	
				totalWaitTime+=p.wt;
				p.turnAroundTime=CLOCK2-p.at;
				totalTurnAroundTime+=p.turnAroundTime;


			}

			long end = System.nanoTime();
			timeKeeper+=(end-start);
		rt.printRB();
//		System.out.println("");
//	
		}

		float thr=((float)filereaderclass.n*100000)/((float)timeKeeper);
		long timeUnit=timeKeeper/CLOCK2;
		System.out.println("\nCOMPLETELY FAIR SCHEDULING USING RED BLACK TREES- PERFORMANCE METRICS ");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("\n1.Total Number of inputs :"+filereaderclass.n);
		System.out.println("\n2.Total Running Time: "+ timeKeeper+ " nano seconds");
		System.out.println("\n3.Running time per process:" +timeKeeper/filereaderclass.n+ " nano seconds");
		System.out.println("\n4.Total Wait Time :"+totalWaitTime*timeUnit+" nano seconds");
		System.out.println("\n5.Average Wait Time :"+(totalWaitTime/filereaderclass.n)*timeUnit+" nano seconds");
		System.out.println("\n6.Total turn around time: " +totalTurnAroundTime*timeUnit+" nano seconds");
		System.out.println("\n7.Average turn around time: " +(totalTurnAroundTime/filereaderclass.n)*timeUnit+" nano seconds");
		System.out.printf("\n8.Throughput: %.2f tasks/millisecond",thr);


	}


}
        
        
        
        
        


