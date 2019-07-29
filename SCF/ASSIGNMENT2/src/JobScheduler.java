import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author naman
 * JobScheduler class simulates FCFS (First Come First Serve) scheduling algorithm. FCFS means the process which arrives first,gets executed first.
 */
public class JobScheduler {

	int totalProcesses;
	Scanner scanner;

	public JobScheduler() {
		scanner = new Scanner(System.in);
	}

	/**
	 * @return returns a 2-D array of processes
	 */
	public int[][] input() {

		int i, process[][] = null;
		try {

			System.out.println("total no. of process : ");
			totalProcesses = scanner.nextInt();
			process = new int[totalProcesses][5];

			for (i = 0; i < totalProcesses; i++) {
				System.out.println("Arrival Time : ");
				process[i][0] = scanner.nextInt();

				System.out.println("Burst Time : ");
				process[i][1] = scanner.nextInt();
			}

		} catch (InputMismatchException e) {
			System.out.println("Invalid number of processes");

		}

		return process;
	}

	/**
	 * @param p is the process array
	 * @return returns process array with values of waitTime
	 */
	public int[][] waitTime(int p[][]) {
		int i;
		try {
			for (i = 0; i < totalProcesses; i++) {
				if (i > 0 && p[i - 1][1] > p[i][0]) {
					p[i][2] = p[i - 1][1] - p[i][0];
				} else
					p[i][2] = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * @param p is the process array
	 * @return returns process array with values of turnAroundTime
	 */
	public int[][] turnAroundTime(int p[][]) {
		int i;
		for (i = 0; i < totalProcesses; i++) {
			p[i][3] = p[i][4] - p[i][0];
		}
		return p;
	}

	/**
	 * @param p is the process array
	 * @return returns process array with values of completionTime
	 */
	public int[][] completionTime(int p[][]) {
		int i;
		try {
			for (i = 0; i < totalProcesses; i++)

				if (p[i][2] > 0) {
					System.out.println("p[i][2]:" + p[i][2]);
					p[i][4] = p[i][1] + p[i][2];
					System.out.println(p[i][4]);
				} else {
					p[i][4] = p[i][0] + p[i][1];
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * @param p is the process array
	 * @return returns average wait time in process array
	 */
	public float avgWaitTime(int p[][]) {
		int i;
		float avg = 0;
		try {
			for (i = 0; i < totalProcesses; i++)
				avg += p[i][2];
			avg /= totalProcesses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avg;
	}

	/**
	 * @param p is the process array
	 * @return returns maximum waiting time in process array
	 */
	public int maxWaitTime(int p[][]) {
		int max = 0;
		int i;
		try {
			for (i = 0; i < totalProcesses; i++)

				if (p[i][2] > max) {
					max = p[i][2];
				} else {
					p[i][2] = 0;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return max;
	}

	/**
	 * @param p is the process array this function prints the 2-D process Array
	 */
	public void print(int p[][]) {
		try {
			System.out.println(
					"  Process no.   Arrival time  Burst Time  Waiting Time  TurnAround Time  Completion Time  ");
			for (int i = 0; i < totalProcesses; i++) {
				System.out.print("     p" + i);
				for (int j = 0; j < 5; j++)
					System.out.print("             " + p[i][j]);
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}

