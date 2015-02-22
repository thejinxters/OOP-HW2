/**
* SubmissionQueue.java
* 
* A FIFO Queue for handling submissions.
*/

import java.util.Queue;

public class SubmissionQueue
{
	private PriorityBlockingQueue<Submission> internalQueue;
	public boolean add(Submission s){
		return internalQueue.add(s);
	}
	public boolean process(){
		Submission target = internalQueue.take();
		//do some stuff
		if(target == null) return false;
		return true;
	}
	public SubmissionQueue(){
		internalQueue = new PriorityBlockingQueue<Submission>();
	}
}
