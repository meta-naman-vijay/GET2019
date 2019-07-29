import java.util.Scanner;

public class MainClassJobScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalProcesses;
		Scanner scanner;
		JobScheduler js = new JobScheduler();

		int process[][] = js.input();
		if (process != null) {
			process = js.waitTime(process);
			process = js.completionTime(process);
			process = js.turnAroundTime(process);

			js.print(process);

			System.out.println("Average Waiting Time :: " + js.avgWaitTime(process));
			System.out.println("Maximum Waiting Time :: " + js.maxWaitTime(process));
		}
	}
}