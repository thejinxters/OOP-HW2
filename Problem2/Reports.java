
interface iReporter
{

	public abstract void report();
	public abstract void notifyTestResult();
}


class NumTestsPassedReport implements iReporter
{
	private double passed;
	private double totalRun;
	private Submission submission;

	NumTestsPassedReport(Submission submission){
		passed = 0;
		totalRun = 0;
		this.submission = submission;
	}

	public void report(){
		System.out.println("**********************************");
		System.out.println("Submission Test Passed Report: ");
		System.out.println("*** Tests Passed: " + passed);
		System.out.println("*** Total Run: " + totalRun);
		double grade = passed/totalRun;
		System.out.println("*** Submission Grade: " + grade);
		System.out.println("**********************************");
	}

	public void notifyTestResult(){
		boolean lp = submission.didTestPass();
		if (lp) passed ++;
		totalRun ++;
	}	
}

class NumTestsTimeoutReport implements iReporter
{
	private int timedOut;
	private int numFailed;
	private Submission submission;

	public NumTestsTimeoutReport(Submission submission){
		timedOut = 0;
		numFailed = 0;
		this.submission = submission;
	}
	public void report(){
		System.out.println("**********************************");
		System.out.println("Test Timeout Report");
		System.out.println("*** Number of Timeouts: " + timedOut);
		System.out.println("*** Total failed: " + numFailed);
		System.out.println("**********************************");
	}

	public void notifyTestResult(){
		boolean lt = submission.wasTimeoutError();
		boolean lp = submission.didTestPass();
		if (lp){
			numFailed ++;
			if (lt){
				timedOut ++;
			}
		}
	}
}