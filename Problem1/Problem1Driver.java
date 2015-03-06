/**
 * Created by jinxters on 3/2/15.
 */
public class Problem1Driver {
    public static void main(String[] args) {
        Submission submission1 = new Submission();
        Submission submission2 = new Submission();
        Submission submission3 = new Submission();
        Submission submission4 = new Submission();
        Submission submission5 = new Submission();
        Submission submission6 = new Submission();

        SubmissionQueue queue = SubmissionQueue.getInstance();

        queue.add(submission1);
        queue.add(submission2);
        queue.add(submission3);
        queue.add(submission4);

        queue.process();
        queue.process();

        queue.add(submission5);
        queue.add(submission6);

        queue.process();
        queue.process();
        queue.process();
        queue.process();

    }
}
