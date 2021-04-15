package lessons;

import java.util.Date;
import java.util.Scanner;

public class MyThread2 extends Thread{
	int sleepTime;
	
	MyThread2(int sleepTime){
		this.sleepTime = sleepTime;
		System.out.println("Constructing MyThread2("+sleepTime+ ")");
	}
	
	public void run() {
		boolean continueFlag = true;
		
		while (continueFlag) {
			try {
				Thread.sleep(sleepTime); //Sleep
				Date d = new Date();
				System.out.println(sleepTime + " Thread wakes up at Date =" + d);
			} catch (InterruptedException e) {
				System.out.println(sleepTime + "was just interrupted");
				continueFlag = false;
			}
		}
	}
	
	static boolean anyThreadsStillRunning(Thread[] myThreads) {
		for (int i=0; i < myThreads.length; i++) {
			if (myThreads[i].isAlive())
				return true;
		}
		return false;
	}
	
	static void killThread(Thread t) {
		t.interrupt();
		// we want to pause to give the thread a chance to terminate
		// before checking which threads are still running.
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			System.out.println("Dont expect to get here ... EVER");
		}
	}

	public static void main(String[] args) {
		int [] sleepTimes = {5000, 8000, 10000};
		Thread[] myThreads = new Thread[sleepTimes.length];
		
		// start up my threads
		for (int i =0; i <sleepTimes.length; i++) {
			myThreads[i] = new MyThread2(sleepTimes[i]);
			myThreads[i].start();
		}
		
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("Enter the index of which thread you want to kill (0,1,2)");
			int killIndex = keyboard.nextInt();
			killThread(myThreads[killIndex]);
		} while (anyThreadsStillRunning(myThreads));
		
		System.out.println("Exiting main thread");


	}

}
