/**
* Submission.java
*
* A representation of a Submission
*/

import java.util.Random;
import java.util.*;

interface ISubmission{
    public abstract void addReport(iReporter r);
    public abstract void removeReport(iReporter r);
    public abstract void notifyReports();
}

public class Submission implements ISubmission
{	
    private Random myRandom;
    private List<iReporter> reports;
   	private boolean lastTestPassed;
	private boolean lastErrorWasTimeout;

    // You may add attributes to this class if necessary

	public Submission()
	{
	    myRandom = new Random();
		lastErrorWasTimeout = false;
		reports = new ArrayList<iReporter>();
	}

    public void runTestCase()
	{
	    // For now, randomly pass or fail, possibly due to a timeout
		boolean passed = myRandom.nextBoolean();
		lastTestPassed = passed;
		if(!passed)
		{
		    lastErrorWasTimeout = myRandom.nextBoolean();
		}
        System.out.println("DEBUG: Submission calling notifyReports()");
        notifyReports();
	}
	
    public boolean wasTimeoutError()
	{
	    return lastErrorWasTimeout;
	}
	public boolean didTestPass()
	{
		return lastTestPassed;
	}

    @Override
    public void addReport(iReporter r){
        System.out.println("DEBUG: Report added to reports list");
        reports.add(r);

	}
    @Override
    public void removeReport(iReporter r){
        int i = reports.indexOf(r);
        if (i >= 0) {
            reports.remove(i);
        }
    }

    @Override
	public void notifyReports(){
		for (iReporter i : reports){
			i.notifyTestResult();
		}
	}

	public void report(){
        System.out.println("DEBUG: Grabbing reports for display");
        for (iReporter i : reports){
			i.report();
		}
	}

	public void runTests(){
		runTests(20);
	}

	public void runTests(int numTests){
		for (int i = 0; i < numTests; i++){
			runTestCase();
		}
	}

	public static void main(String[] args){
		Submission testSubmission = new Submission();
        new NumTestsPassedReport(testSubmission);
        new NumTestsTimeoutReport(testSubmission);

		testSubmission.runTests();
		testSubmission.report();
	}
}
