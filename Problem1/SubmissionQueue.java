/**
* SubmissionQueue.java
* 
* A FIFO Queue for handling submissions.
*/


import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SubmissionQueue
{
	private LinkedList<Submission> internalQueue;
    private static SubmissionQueue queue;

    private SubmissionQueue(){
        internalQueue = new LinkedList<Submission>();

    }

    public static SubmissionQueue getInstance(){
        if (queue == null){
            queue = new SubmissionQueue();
        }
        return queue;
    }

	public synchronized boolean add(Submission submission){
		System.out.println("Adding Submission with id " + submission.getId());
        return internalQueue.add(submission);
	}

    public boolean process() {
        Submission target = getNextSubmission();
        if (target != null){
            System.out.println("Processing Submission with id " + target.getId());
            return true;
        }
        return false;
    }

    private synchronized Submission getNextSubmission(){
        Submission target;
        try {
            target = internalQueue.remove();
            return target;
        }
        catch(NoSuchElementException e){
            System.err.println("Caught NoSuchElementException: " + e.getMessage());
            return null;
        }
    }
}
