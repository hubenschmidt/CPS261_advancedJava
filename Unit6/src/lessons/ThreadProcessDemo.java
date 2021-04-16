package lessons;

class CPUWaster extends Thread {
    public void run() {
	while (true) {
	    System.out.println(Thread.currentThread().getName());
	}
    }
}

public class ThreadProcessDemo {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// display current information about this process
	Runtime rt = Runtime.getRuntime();
	long usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
	System.out.format("  Process ID: %d\n", ProcessHandle.current().pid());
	System.out.format("Thread Count: %d\n", Thread.activeCount());
	System.out.format("Memory Usage: %d KB\n", usedKB);

	// start 6 new threads
	System.out.println("\nStarting 2 CPUWaster threads...\n");
	for (int i = 0; i < 1; i++)
	    new CPUWaster().start();

	// display current information about this process
	usedKB = (rt.totalMemory() - rt.freeMemory()) / 1024;
	System.out.format("  Process ID: %d\n", ProcessHandle.current().pid());
	System.out.format("Thread Count: %d\n", Thread.activeCount());
	System.out.format("Memory Usage: %d KB\n", usedKB);

    }

}
