/**
* SubmissionQueue.java
* 
* A FIFO Queue for handling submissions.
*/


import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class SubmissionQueue
{
	private PriorityBlockingQueue<Submission> internalQueue;
    private static SubmissionQueue queue;

    private SubmissionQueue(){
        internalQueue = new PriorityBlockingQueue<Submission>();

    }

    public static SubmissionQueue getInstance(){
        if (queue == null){
            queue = new SubmissionQueue();
        }
        return queue;
    }

	public boolean add(Submission s){
		return internalQueue.add(s);
	}

    public boolean process() {
        Submission target;
        try {
            target = internalQueue.take();
        } catch (InterruptedException e) {
            //oh no
            System.err.println(e);
            return false;
        }

        //do some stuff to target

        return (target != null);
    }
}
