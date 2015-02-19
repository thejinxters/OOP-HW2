/**
* Submission.java
*
* A representation of a Submission
*/

import java.util.Random;

public class Submission
{	
    private Random myRandom;
	private boolean lastErrorWasTimeout;

    // You may add attributes to this class if necessary

	public Submission()
	{
	    myRandom = new Random();
		lastErrorWasTimeout = false;
	}

    public void runTestCase()
	{
	    // For now, randomly pass or fail, possibly due to a timeout
		boolean passed = myRandom.nextBoolean();
		if(!passed)
		{
		    lastErrorWasTimeout = myRandom.nextBoolean();
		}
		
		// You can add to the end of this method for reporting purposes
	}
	
    public boolean wasTimeoutError()
	{
	    return lastErrorWasTimeout;
	}
}
