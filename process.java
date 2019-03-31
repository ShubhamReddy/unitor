public class process {


	public int pId;
	public long extime;
	public long CPUtime;
	public long wt;
	public long at;
	public rbtree rbt;
	public long uf;
	public long startTime;
	
	public long turnAroundTime;

	
	public process(rbtree rbtree,int newId,long newArrivalTime, long newExecTime){

		CPUtime=0;

		pId=newId;
		extime=newExecTime;
		at=newArrivalTime;
		wt=at;
		uf=at;

		rbt=rbtree;
		rbt.insert(this);




	}



}