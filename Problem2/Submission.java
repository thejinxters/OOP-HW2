/**
* Submission.java
*
* A representation of a Submission
*/

import java.util.Random;
import java.util.*;

public class Submission
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
		iReporter passedReport = new NumTestsPassedReport(this);
		iReporter tOReport = new NumTestsTimeoutReport(this);
		reports.add(passedReport);
		reports.add(tOReport);
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

	public void addReport(iReporter r){
		reports.add(r);
	}

	public void notifyReports(){
		for (iReporter i : reports){
			i.notifyTestResult();
		}
	}

	public void report(){
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
		Submission test = new Submission();
		test.runTests();
		test.report();
	}
}
